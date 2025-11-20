package gui;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import gui.SessionListPanel;
import gui.AddSessionPanel;

import model.PracticeLog;
import model.PracticeSession;

public class MusicPracticeAppGUI extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    

    private SessionListPanel sessionListPanel;
    private AddSessionPanel addSessionPanel;
    private PracticeLog practiceLog;

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
        topBar.setBackground(new Color(230, 230, 230));
        topBar.setBorder(new EmptyBorder(10, 20, 10, 20)); 

        // Card panel setup
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setBackground(new Color(245, 245, 245));



        sessionListPanel = new SessionListPanel(practiceLog);
        addSessionPanel = new AddSessionPanel(practiceLog, sessionListPanel, cardLayout, cardPanel);

        cardPanel.add(addSessionPanel,  "add");
        cardPanel.add(sessionListPanel,  "log");

        add(cardPanel, BorderLayout.CENTER);

        addButton.addActionListener(e -> cardLayout.show(cardPanel, "add"));
        viewButton.addActionListener(e -> cardLayout.show(cardPanel, "log"));



        setVisible(true);
    
    }

    private void styleButton(JButton b) {
        b.setPreferredSize(new Dimension(180, 60));
        b.setBackground(new Color(220, 220, 220));
        b.setFont(new Font("Arial", Font.BOLD, 16));
    }

}
