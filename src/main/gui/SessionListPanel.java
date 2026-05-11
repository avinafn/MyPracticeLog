package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import model.PracticeLog;
import model.PracticeSession;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

// EFFECTS: cunstructs a new window to display the user's saved information
@ExcludeFromJacocoGeneratedReport
public class SessionListPanel extends JPanel {
    private PracticeLog log;
    // private JTextArea area;
    private JPanel container;
    private JLabel instrumentImageLabel;
    private JLabel totalTimeLabel;
    private JLabel sessionCountLabel;

    @SuppressWarnings("methodlength")
    public SessionListPanel(PracticeLog log) {

        setBackground(new Color(255, 204, 153));
        setOpaque(true);

        this.log = log;
        setLayout(new BorderLayout());

        JPanel statsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 5));
        statsPanel.setOpaque(false);

        sessionCountLabel = new JLabel();
        totalTimeLabel = new JLabel();

        sessionCountLabel.setFont(new Font("Arial", Font.BOLD, 14));
        totalTimeLabel.setFont(new Font("Arial", Font.BOLD, 14));

        statsPanel.add(sessionCountLabel);
        statsPanel.add(totalTimeLabel);

        add(statsPanel, BorderLayout.NORTH);


        //area = new JTextArea();
        //area.setEditable(false);
        //add(new JScrollPane(area), BorderLayout.CENTER);

        container = new JPanel();
        container.setLayout(new javax.swing.BoxLayout(container, javax.swing.BoxLayout.Y_AXIS));
        container.setBackground(new Color(255, 204, 153));

        add(new JScrollPane(container), BorderLayout.CENTER);

        instrumentImageLabel = new JLabel();
        instrumentImageLabel.setHorizontalAlignment(JLabel.CENTER);

        JPanel imagePanel = new JPanel(new BorderLayout());
        imagePanel.setBackground(new Color(253, 245, 230));
        imagePanel.setBorder(new EmptyBorder(20, 10, 20, 20));
        imagePanel.add(instrumentImageLabel, BorderLayout.NORTH);

        add(imagePanel, BorderLayout.EAST);
        refresh();
    }

    // EFFECTS: updates the information added by the user and
    // updates the instrument image
    // public void refresh() {
    //     StringBuilder sb = new StringBuilder();
    //     for (int i = 0; i < log.getSessions().size(); i++) {
    //         sb.append(log.showPracticeSession(i)).append("\n");
    //     }
    //     container.setText(sb.toString());

    //     if (!log.getSessions().isEmpty()) {
    //         PracticeSession last = log.getSessions().get(log.getSessions().size() - 1);
    //         updateInstrumentImage(last.getInstrument());
    //     } else {
    //         instrumentImageLabel.setIcon(null);
    //     }

    //     sessionCountLabel.setText("Sessions: " + log.sessionCount());
    //     totalTimeLabel.setText("Total time: " + log.totalPracticeTime());
    // }

    public void refresh() {
        container.removeAll();

        // loop thorugh every session one by one
        for (int i = 0; i < log.getSessions().size(); i++) {
            PracticeSession currentSession = log.getSessions().get(i);
            
            JPanel rowPanel = new JPanel(new BorderLayout());
            rowPanel.setOpaque(false);
            rowPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

            JTextArea sessionText = new JTextArea(log.showPracticeSession(i));
            sessionText.setEditable(false);
            sessionText.setOpaque(false);

            //button for a specific row
            javax.swing.JButton deleteBtn = new javax.swing.JButton("Delete");
            deleteBtn.setBackground(new Color(255,100, 100));
            deleteBtn.addActionListener(e -> {log.removeSession(currentSession);
                refresh();
            });

            rowPanel.add(sessionText, BorderLayout.CENTER);
            rowPanel.add(deleteBtn, BorderLayout.EAST);

            container.add(rowPanel);

        }    

            //update the image
            if (!log.getSessions().isEmpty()) {
            PracticeSession last = log.getSessions().get(log.getSessions().size() - 1);
            updateInstrumentImage(last.getInstrument());
            } else {
                instrumentImageLabel.setIcon(null);
            }

            // Update the stats
            sessionCountLabel.setText("Sessions: " + log.sessionCount());
            totalTimeLabel.setText("Total time: " + log.totalPracticeTime());

           
            container.revalidate();
            container.repaint();


        
    }

    // EFFECTS: returns the instrument image based on user's instrument entery or no
    // image of the instrument
    // is unknown
    @SuppressWarnings("methodlength")
    private void updateInstrumentImage(String instrumentName) {
        if (instrumentName == null) {
            instrumentImageLabel.setIcon(null);
            return;
        }

        String key = instrumentName.trim().toLowerCase();
        String filePath = null;

        switch (key) {
            case "piano":
                filePath = "./data/piano.png";
                break;
            case "violin":
                filePath = "./data/violin.png";
                break;
            case "guitar":
                filePath = "./data/guitar.png";
                break;

            default:
                instrumentImageLabel.setIcon(null); // unknown : no image
                return;
        }

        ImageIcon icon = new ImageIcon(filePath);
        if (icon.getIconWidth() <= 0 || icon.getIconHeight() <= 0) {
            instrumentImageLabel.setIcon(null);
            return;
        }

        Image scaled = icon.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        instrumentImageLabel.setIcon(new ImageIcon(scaled));
    }



    

    

}
