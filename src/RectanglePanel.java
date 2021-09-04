import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class RectanglePanel extends JPanel {
    private final int WIDTH = 750;
    private final int HEIGHT = 500;
    private final int RECTWIDTH = 25;
    private final int[] comparisonIndices = new int[2];
    private ArrayList<Integer> rectangles = new ArrayList<>();

    public RectanglePanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setArray();
        comparisonIndices[0] = -1; // Default value
        comparisonIndices[1] = -1; // Default value
    }

    public void setArray() {
        this.rectangles.clear();
        for (int x = 0; x < WIDTH; x += RECTWIDTH) {
            this.rectangles.add(new Random().nextInt(HEIGHT-150) + 10);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x, i;
        for (x = 0, i = 0; x < WIDTH; x += RECTWIDTH, i += 1) {
            if (i == comparisonIndices[0] || i == comparisonIndices[1]) {
                g.setColor(Color.red);
            }
            else {
                g.setColor(Color.darkGray);
            }
            g.fillRect(x,HEIGHT-rectangles.get(i), RECTWIDTH, rectangles.get(i));
        }
    }

    public void visualize(int choice) {
        if (choice == 0) {
            SortingAlgorithms.visualizeBubbleSort(rectangles, this);
        }
        else if (choice == 1) {
            SortingAlgorithms.visualizeBubbleSortEfficient(rectangles, this);
        }
        else if (choice == 2) {
            SortingAlgorithms.visualizeSelectionSort(rectangles, this);
        }
    }

    public void setComparisonIndices(int index1, int index2) {
        this.comparisonIndices[0] = index1;
        this.comparisonIndices[1] = index2;
    }
}
