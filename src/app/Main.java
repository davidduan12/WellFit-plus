package app;

import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

import java.io.IOException;
public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            // Set custom tabbed pane styling
//            UIManager.put("TabbedPane.tabAreaInsets", new Insets(5,5,0,5));
            UIManager.put("TabbedPane.selected", Color.LIGHT_GRAY);
            UIManager.put("TabbedPane.contentBorderInsets", new Insets(5,5,5,5));
            UIManager.put("TabbedPane.tabsOverlapBorder", true);

        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            //Main window
            JFrame application = new JFrame("WellFit+");
            application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
            tabbedPane.setUI(new EvenlySpreadingTabbedPaneUI());

            JPanel foodPanel = createPanel("Food");
            JPanel exercisePanel = createPanel("Exercise");
            JPanel profilePanel = createPanel("Profile");

            tabbedPane.addTab("Food", foodPanel);
            tabbedPane.addTab("Exercise", exercisePanel);
            tabbedPane.addTab("Profile", profilePanel);

            application.setLayout(new BorderLayout());
            application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            application.add(tabbedPane, BorderLayout.CENTER);
            application.setSize(500, 400);
            application.setLocationRelativeTo(null);
            application.setVisible(true);
        });

    }

    private static JPanel createPanel(String text) {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setLayout(new BorderLayout());
        JLabel label = new JLabel(text);
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }
    public static class EvenlySpreadingTabbedPaneUI extends BasicTabbedPaneUI {

        @Override
        protected void installDefaults() {
            super.installDefaults();
            tabAreaInsets.right = tabAreaInsets.left;
        }

        @Override
        protected int calculateTabWidth(int tabPlacement, int tabIndex, FontMetrics metrics) {
            int width = super.calculateTabWidth(tabPlacement, tabIndex, metrics);
            int totalWidth = tabPane.getWidth() - (tabInsets.left + tabInsets.right);
            int totalTabs = tabPane.getTabCount();
            return totalWidth / totalTabs;
        }

        @Override
        protected void setRolloverTab(int index) {
            // Empty to disable rollover effect
        }
    }
}
