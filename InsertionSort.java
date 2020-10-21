
public class InsertionSort {

    public static void main(String[] args) {
        final int[] input = {20, 35, -15, 7, 55, 1, -22};
        
        insertionSort(input, input.length);

        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }

    public static void insertionSort(int[] input, int numItems) {
        if (numItems < 2) {
            return;
        }

        insertionSort(input, numItems - 1);

        int newElement = input[numItems - 1];

        int i;

        for (i = numItems - 1; i > 0 && input[i - 1] > newElement; i--) {
            input[i] = input[i - 1];
        }

        input[i] = newElement;
    }
}