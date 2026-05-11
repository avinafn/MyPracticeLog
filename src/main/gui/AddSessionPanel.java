package gui;

import javax.swing.border.EmptyBorder;

import model.PracticeLog;
import model.PracticeSession;

import javax.swing.border.EmptyBorder;


import javax.swing.*;
import java.awt.*;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

import com.github.lgooddatepicker.components.DatePicker;
import java.time.LocalDate;

@ExcludeFromJacocoGeneratedReport
public class AddSessionPanel extends JPanel {
    private DatePicker dayField;
    private javax.swing.JComboBox<String> instrumentField;
    private JTextField piecesField;
    private JTextField commentField;
    private JTextField durationField;
    private javax.swing.JComboBox<String> categoryField;
    private JTextField goalField;
    private PracticeLog log;
    private SessionListPanel listPanel;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    // EFFECTS: constructs the add session menu with all the place holders and buttons that allows the user
    //          to enter their information
    public AddSessionPanel(PracticeLog log, SessionListPanel listPanel, CardLayout cardLayout, JPanel cardPanel) {

        this.log = log;
        this.listPanel = listPanel;
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;

        dayField = new DatePicker();

        String[] instruments = {"Piano", "Violin", "Guitar"};
        instrumentField = new javax.swing.JComboBox<>(instruments);
        this.add(new JLabel("Instruments: "));
        this.add(instrumentField);

        piecesField = new JTextField(15);
        commentField = new JTextField(15);
        durationField = new JTextField(15);

        String[] categories = {"Technique", "Repertoire", "Scales", "Performance", "Sight Reading"};
        categoryField = new javax.swing.JComboBox<>(categories);
        this.add(new JLabel("categories: "));
        this.add(categoryField);

        goalField = new JTextField(15);

        setupLayout();
        submitButton();

    }

    // EFFECTS: sets up the frame and fields that need to be filled by the user
    @SuppressWarnings("methodlength")
    private void setupLayout() {
        setLayout(new BorderLayout());
        setBackground(new Color(253, 245, 230));
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
    }

    // EFFECTS: sets up the submit button with an event handler
    private void submitButton() {
        JButton submit = new JButton("Submit");
        submit.setPreferredSize(new Dimension(120, 40));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.add(submit);

        add(buttonPanel, BorderLayout.SOUTH);

        submit.addActionListener(e -> handleSubmit());
    }

    // REQUIRES: the submit button is clicked
    // EFECTS: saves the info entered by the user 
    private void handleSubmit() {
        String day = dayField.getText().trim();
        String instrument = instrumentField.getSelectedItem().toString();
        String pieces = piecesField.getText().trim();
        String comment = commentField.getText().trim();
        String category = categoryField.getSelectedItem().toString();
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

        clearFields();
        cardLayout.show(cardPanel, "log");
    }

    // EFFECTS: clears out the fields filled before for new enteries
    private void clearFields() {
        dayField.setText("");
        instrumentField.setSelectedIndex(0);
        piecesField.setText("");
        commentField.setText("");
        durationField.setText("");
        categoryField.setSelectedIndex(0);
        goalField.setText("");
    }

}
