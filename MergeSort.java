class mergeSort {
    public static void main(String[] args) {
        final int[] input = {20, 35, -15, 7, 55, 1, -22};
        
        rMergeSort(input, 0, input.length);

        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }

    public static void rMergeSort(int[] arr, int start, int end) {

        // return early if array length is small
        if (end - start < 2) {
            return;
        }

        // partition the array into two halves and the recursively call left side and then right side.
        // Finally, merge the two halves
        final int mid = (start + end) / 2;
        rMergeSort(arr, start, mid);
        rMergeSort(arr, mid, end);
        merge(arr, start, mid, end);

    }

    public static void merge(int[] arr, int start, int mid, int end) {

        // the two sides of the array are already in sorted order. No work needs to be done.
        if (arr[mid - 1] <= arr[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int cur = 0;
        final int[] temp = new int[end - start];

        while (i < mid && j < end) {
            temp[cur++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        // Copy the rest of the left array if there are leftover elements
        System.arraycopy(arr, i, arr, start + cur, mid - i);

        // Copy the temp array into the start position in arr
        System.arraycopy(temp, 0, arr, start, cur);
    }
}