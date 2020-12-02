public class Autoscaling {
    
    public static void main(String[] args) {
        int[] input = {25,23,1,2,3,4,5,6,7,8,9,10,76,80};

        int[] input2 = {5,10,80};

        System.out.println(finalInstanceCount(input, 14, 2));
        System.out.println(finalInstanceCount(input2, 3, 1));
    }

    public static int finalInstanceCount(int[] utilization, int n, int start) {
        int count = start;

        for (int i = 0; i < n; i++) {
            if (utilization[i] < 25 && count > 1) {
                System.out.println("under " + i);
                count = (int) Math.ceil(count / 2);
                i+=9;
            } else if (utilization[i] > 60 && count * 2 < (2*10^8)) {
                System.out.println("over " + i);
                count *= 2;
                i+=9;
            }
        }

        return count;
    }
}