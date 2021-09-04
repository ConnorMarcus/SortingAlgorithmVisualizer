import java.util.ArrayList;
import java.util.Collections;

public class SortingAlgorithms {
    /**
     * Inefficient Bubble Sort Algorithm (does not terminate if no swaps are made)
     * @param arr The Array to be sorted.
     * @param panel The JPanel where the algorithm is visualized.
     */
    public static void visualizeBubbleSort(ArrayList<Integer> arr, RectanglePanel panel) {
        Thread t = new Thread(() -> {
            try {
                for (int i = 0; i < arr.size() - 1; i++) {
                    for (int j = 0; j < arr.size() - i - 1; j++) {
                        if (arr.get(j) > arr.get(j + 1)) {
                            Collections.swap(arr, j, j + 1);
                        }
                        panel.setComparisonIndices(j, j + 1);
                        panel.repaint();
                        Thread.sleep(50);
                    }
                }
                //List Sorted
                panel.setComparisonIndices(-1, -1);
                panel.repaint();
                SortingVisualiserGUI.setButtons(true);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
                System.exit(1);
            }
        });

        t.start();
    }

    /**
     * Efficient Bubble Sort Algorithm (terminates if no swaps are made)
     * @param arr The Array to be sorted.
     * @param panel The JPanel where the algorithm is visualized.
     */
    public static void visualizeBubbleSortEfficient(ArrayList<Integer> arr, RectanglePanel panel) {
        Thread t = new Thread(() -> {
            try {
                boolean noSwaps = true;
                for (int i = 0; i < arr.size() - 1; i++) {
                    for (int j = 0; j < arr.size() - i - 1; j++) {
                        if (arr.get(j) > arr.get(j + 1)) {
                            Collections.swap(arr, j, j + 1);
                            noSwaps = false;
                        }
                        panel.setComparisonIndices(j, j + 1);
                        panel.repaint();
                        Thread.sleep(50);
                    }
                    if (noSwaps) {
                        break;
                    }
                }
                //List Sorted
                panel.setComparisonIndices(-1, -1);
                panel.repaint();
                SortingVisualiserGUI.setButtons(true);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
                System.exit(1);
            }
        });

        t.start();
    }

    /**
     * Selection Sort Algorithm
     * @param arr The Array to be sorted.
     * @param panel The JPanel where the algorithm is visualized.
     */
    public static void visualizeSelectionSort(ArrayList<Integer> arr, RectanglePanel panel) {
        Thread t = new Thread(() -> {
            try {
                for (int i = arr.size() - 1; i >= 0; i--) {
                    int maxSoFar = 0;
                    for (int j = 1; j <= i; j++) {
                        panel.setComparisonIndices(maxSoFar, j);
                        panel.repaint();
                        Thread.sleep(50);
                        if (arr.get(j) > arr.get(maxSoFar)) {
                            maxSoFar = j;
                        }
                    }
                    Collections.swap(arr, maxSoFar, i);
                    panel.setComparisonIndices(-1, -1);
                    panel.repaint();
                    Thread.sleep(50);
                }
                //List Sorted
                SortingVisualiserGUI.setButtons(true);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
                System.exit(1);
            }
        });

        t.start();
    }
}


