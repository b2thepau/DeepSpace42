package org.kodejava.example.swing;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class JTableDisableSelection extends JPanel {
    public JTableDisableSelection() {
        initializePanel();
    }

    private void initializePanel() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(500, 150));

        JTable table = new JTable(new PremiereLeagueTableModel());
        table.getColumnModel().getColumn(0).setMinWidth(150);

        //
        // Disable table's cell selection.
        //
        table.setCellSelectionEnabled(false);

        //
        // Settings table focus to false completely remove selection
        // capability from the table component.
        //
        table.setFocusable(false);

        JScrollPane pane = new JScrollPane(table);
        add(pane, BorderLayout.CENTER);
    }

    public static void showFrame() {
        JPanel panel = new JTableDisableSelection();
        panel.setOpaque(true);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("JTable Disable Selection");
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JTableDisableSelection.showFrame();
            }
        });
    }

    class PremiereLeagueTableModel extends AbstractTableModel {
        // TableModel's column names
        private String[] columnNames = {
                "TEAM", "P", "W", "D", "L", "GS", "GA", "GD", "PTS"
        };

        // TableModel's data
        private Object[][] data = {
                {"Chelsea", 5, 5, 0, 0, 21, 1, 20, 15},
                {"Arsenal", 5, 3, 2, 0, 14, 4, 10, 11},
                {"Manchester United", 5, 3, 2, 0, 14, 7, 7, 11},
                {"Manchester City", 5, 2, 2, 1, 6, 2, 4, 8},
                {"Tottenham Hotspur", 5, 2, 2, 1, 6, 4, 2, 8}
        };

        public int getRowCount() {
            return data.length;
        }

        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }

        public Object getValueAt(int rowIndex, int columnIndex) {
            return data[rowIndex][columnIndex];
        }
    }
}
