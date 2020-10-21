class QuickSort {

    public static void main(String[] args) {
        final int[] input = {20, 35, -15, 7, 55, 1, -22};

        quickSort(input, 0, input.length);
        
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (end - start < 2) {
            return;
        }

        // Need to return the index where the pivot was last placed.
        int pivotIndex = partition(arr, start, end);
        quickSort(arr, start, pivotIndex);
        quickSort(arr, pivotIndex + 1, end);
    }

    public static int partition(int[] arr, int start, int end) {
        // Uses the first element as the pivot
        int pivot = arr[start];

        int i = start;
        int j = end;

        while (i < j) {

            // Empty loop to traverse starting from decrementing j
            while (i < j && arr[--j] >= pivot);

            // Check to see while didnt drop out because of i < j
            if (i < j) {
                arr[i] = arr[j];
            }

            // Same thing but this time incrementing i
            while (i < j && arr[++i] <= pivot);

            if (i < j) {
                arr[j] = arr[i];
            }

        }

        // Set pivot to final i / j 
        arr[i] = pivot;
        return i;
    }
}