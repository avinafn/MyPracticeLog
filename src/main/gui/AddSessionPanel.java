package gui;

import javax.swing.border.EmptyBorder;

import model.PracticeLog;
import model.PracticeSession;

import javax.swing.border.EmptyBorder;

import javax.swing.*;
import java.awt.*;

public class AddSessionPanel extends JPanel {
    private JTextField dayField;
    private JTextField instrumentField;
    private JTextField piecesField;
    private JTextField commentField;
    private JTextField durationField;
    private JTextField categoryField;
    private JTextField goalField;
    private PracticeLog log;
    private SessionListPanel listPanel;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    @SuppressWarnings("methodlength")
    public AddSessionPanel(PracticeLog log, SessionListPanel listPanel, CardLayout cardLayout, JPanel cardPanel) {

        // dayField = new JTextField("day");
        // instrumentField = new JTextField("instrument");
        // piecesField = new JTextField("pieces");
        // commentField = new JTextField("comment");
        // durationField = new JTextField("duration (min)");
        // categoryField = new JTextField("category");
        // goalField = new JTextField("goal");

        // add(new JLabel("Day:"));
        // add(dayField);

        // add(new JLabel("Instrument:"));
        // add(instrumentField);

        // add(new JLabel("Pieces:"));
        // add(piecesField);

        // add(new JLabel("Comment:"));
        // add(commentField);

        // add(new JLabel("Duration (min):"));
        // add(durationField);

        // add(new JLabel("Category:"));
        // add(categoryField);

        // add(new JLabel("Goal:"));
        // add(goalField);

        // JButton submit = new JButton("Submit");
        // add(new JLabel());
        // add(submit);

        // setBackground(new Color(245, 245, 245));
        // setOpaque(true);

        // overall layout

        this.log = log;
        this.listPanel = listPanel;
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;

        dayField = new JTextField(15);
        instrumentField = new JTextField(15);
        piecesField = new JTextField(15);
        commentField = new JTextField(15);
        durationField = new JTextField(15);
        categoryField = new JTextField(15);
        goalField = new JTextField(15);

        setLayout(new BorderLayout());
        setBackground(new Color(245, 245, 245)); // soft grey
        setBorder(new EmptyBorder(30, 40, 30, 40));

        // title at the top
        JLabel title = new JLabel("Add Practice Session");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setHorizontalAlignment(JLabel.CENTER);
        add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(7, 2, 10, 10));
        formPanel.setOpaque(false);

        formPanel.add(new JLabel("Day:"));
        formPanel.add(dayField);

        formPanel.add(new JLabel("Instrument:"));
        formPanel.add(instrumentField);

        formPanel.add(new JLabel("Pieces:"));
        formPanel.add(piecesField);

        formPanel.add(new JLabel("Comment:"));
        formPanel.add(commentField);

        formPanel.add(new JLabel("Duration (min):"));
        formPanel.add(durationField);

        formPanel.add(new JLabel("Category:"));
        formPanel.add(categoryField);

        formPanel.add(new JLabel("Goal:"));
        formPanel.add(goalField);

        add(formPanel, BorderLayout.CENTER);

        // Submit button
        JButton submit = new JButton("Submit");
        submit.setPreferredSize(new Dimension(120, 40));
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.add(submit);

        add(buttonPanel, BorderLayout.SOUTH);

        submit.addActionListener(e -> {
            // Read values from the text fields
            String day = dayField.getText().trim();
            String instrument = instrumentField.getText().trim();
            String pieces = piecesField.getText().trim();
            String comment = commentField.getText().trim();
            String category = categoryField.getText().trim();
            String goal = goalField.getText().trim();

            int duration;
            try {
                duration = Integer.parseInt(durationField.getText().trim());
            } catch (NumberFormatException ex) {
                
                JOptionPane.showMessageDialog(this, "Duration must be a number (minutes).", "Invalid input",
                        JOptionPane.ERROR_MESSAGE);
                return; 
            }

            
            PracticeSession session = new PracticeSession(day, instrument, pieces, duration, comment, category, goal);

            
            log.addSession(session); 

           
            listPanel.refresh(); 

            // clear fields for the next entry
            dayField.setText("");
            instrumentField.setText("");
            piecesField.setText("");
            commentField.setText("");
            durationField.setText("");
            categoryField.setText("");
            goalField.setText("");

            // 6. back to log screen
            cardLayout.show(cardPanel, "log");
        });

    }

}
