import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortingVisualiserGUI {
    private static final JFrame frame = new JFrame();
    private static final JButton newArrayButton = new JButton("New Array");
    private static final JButton startButton = new JButton("Start");

    public void show() {
        String[] options = {"Bubble Sort", "Bubble Sort (Efficient)", "Selection Sort"};
        int choice = JOptionPane.showOptionDialog(null, "Choose a sorting algorithm:",
                "Sorting Algorithm",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        if (choice == -1) {
            System.exit(0);
        }

        RectanglePanel mainPanel = new RectanglePanel();
        newArrayButton.setPreferredSize(new Dimension(100, 50));
        newArrayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.setArray();
                mainPanel.repaint();
            }
        });

        startButton.setPreferredSize(new Dimension(100, 50));
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setButtons(false);
                mainPanel.visualize(choice);
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(newArrayButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void setButtons(boolean bool) {
        newArrayButton.setEnabled(bool);
        startButton.setEnabled(bool);
    }
}
