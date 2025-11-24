package gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.IOException;

import model.PracticeLog;
import persistence.JsonReader;
import persistence.JsonWriter;
import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

@ExcludeFromJacocoGeneratedReport
public class MusicPracticeAppGUI extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    private SessionListPanel sessionListPanel;
    private AddSessionPanel addSessionPanel;
    private PracticeLog practiceLog;

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;



    private static final String JSON_STORE = "./data/practicelog.json";

    // EFFECTS: MusicPracticeAppGUI constructs the frame of the ui along with the
    // buttons in the top bar to
    // allow the user to add/view/load/save.
    @SuppressWarnings("methodlength")
    public MusicPracticeAppGUI() {
        // Frame setup
        super("Music Practice Log");

        practiceLog = new PracticeLog();

        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topBar = new JPanel();

        // Buttons setup
        JButton addButton = new JButton("Add Session");
        styleButton(addButton);
        JButton viewButton = new JButton("View Sessions");
        styleButton(viewButton);
        JButton saveButton = new JButton("Save Session");
        styleButton(saveButton);
        JButton loadButton = new JButton("Load Sessions");
        styleButton(loadButton);

        topBar.add(addButton);
        topBar.add(viewButton);
        topBar.add(saveButton);
        topBar.add(loadButton);

        add(topBar, BorderLayout.NORTH);
        topBar.setBackground(new Color(255, 192, 203));
        topBar.setBorder(new EmptyBorder(10, 20, 10, 20));

        // Card panel setup
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setBackground(new Color(204, 255, 255));

        sessionListPanel = new SessionListPanel(practiceLog);
        addSessionPanel = new AddSessionPanel(practiceLog, sessionListPanel, cardLayout, cardPanel);

        cardPanel.add(addSessionPanel, "add");
        cardPanel.add(sessionListPanel, "log");

        add(cardPanel, BorderLayout.CENTER);

        addButton.addActionListener(e -> cardLayout.show(cardPanel, "add"));
        viewButton.addActionListener(e -> cardLayout.show(cardPanel, "log"));
        saveButton.addActionListener(e -> savePracticeLog());
        loadButton.addActionListener(e -> loadPracticeLog());

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        setVisible(true);

    }


    // EFFECTS: styles the buttons in the user interface

    private void styleButton(JButton b) {
        b.setPreferredSize(new Dimension(180, 60));
        b.setBackground(new Color(220, 220, 220));
        b.setFont(new Font("Arial", Font.BOLD, 16));
    }

    // EFFECTS: saves the information from the user
    private void savePracticeLog() {
        try {
            jsonWriter.open();
            jsonWriter.write(practiceLog);
            jsonWriter.close();
            JOptionPane.showMessageDialog(this, "Practice log saved to " + JSON_STORE, "Successful",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Unable to save to file: " + JSON_STORE, "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadPracticeLog() {
        try {
            // read into a temporary log
            PracticeLog loaded = jsonReader.read();

            // Copy to the existing log object
            practiceLog.setPracticeSession(loaded.getPracticeSession());

            sessionListPanel.refresh();
            cardLayout.show(cardPanel, "log");

            JOptionPane.showMessageDialog(this, "Practice log loaded from " + JSON_STORE, "Successful",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Unable to read from file: " + JSON_STORE, "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}
