
public class CountingSort {
    public static void main(String[] args) {
        
        final int[] input = { 2, 5, 9, 8, 2, 8, 7, 10, 4, 3 };

        countingSort(input, 1, 10);

        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }

    public static void countingSort(int[] input, int min, int max) {

        int[] counter = new int[(max - min) + 1];

        for (int i = 0; i < input.length; i++) {
            counter[input[i] - min]++;
        }

        int index = 0;
        for (int j = 0; j < counter.length; j++) {
            if (counter[j] > 0) {
                while (counter[j] > 0) {
                    input[index++] = j + min;
                    counter[j]--;
                }
            }
        }
    }
}