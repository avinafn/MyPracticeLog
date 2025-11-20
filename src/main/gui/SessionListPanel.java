package gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.PracticeLog;
import model.PracticeSession;


import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;


// EFFECTS: cunstructs a new window to display the user's saved information
@ExcludeFromJacocoGeneratedReport
public class SessionListPanel extends JPanel {
    private PracticeLog log;
    private JTextArea area;

    public SessionListPanel(PracticeLog log) {

        setBackground(new Color(245, 245, 245));
        setOpaque(true);

        this.log = log;
        setLayout(new BorderLayout());

        area = new JTextArea();
        area.setEditable(false);

        add(new JScrollPane(area), BorderLayout.CENTER);
        refresh();
    }

    public void refresh() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < log.getSessions().size(); i++) {
            sb.append(log.showPracticeSession(i)).append("\n");
        }
        area.setText(sb.toString());
    }

}
