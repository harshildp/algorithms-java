import java.util.PriorityQueue;

public class FiveStar {
    public static void main(String[] args) {
        int[][] input = {
            {4,4},
            {1,2},
            {3,6}
        };

        System.out.println(moreFiveStars(input, 77));
    }

    public static int moreFiveStars(int[][] ratings, int threshold) {
        double num = 0.0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                double c1 = ((double) a[0] + 1) / (a[1] + 1) - ((double) a[0]/a[1]);
                double c2 = ((double) b[0] + 1) / (b[1] + 1) - ((double) b[0]/b[1]);
                double diff = c1 - c2;

                if (diff > 0) {
                    return -1;
                } else if (diff < 0) {
                    return 1;
                } else {
                    return 0;
                }
            }
        );
        
        for (int[] rating : ratings) {
            num += (double) rating[0]/rating[1];
            pq.add(rating);
        }
        System.out.println(" num" +  num*100/ratings.length + " thres " + threshold);


        int newRatings = 0;
        while (num * 100 / ratings.length < threshold) {
            int[] change = pq.poll();
            System.out.println("change is " + change[0] + " / " + change[1]);
            double percentageChange = (double) change[0]/change[1];
            change[0]++;
            change[1]++;
            percentageChange = (double) change[0]/change[1] - percentageChange;
            num += percentageChange;
            newRatings++;
            pq.add(change);
            System.out.println(" num" +  num*100/ratings.length + " thres " + threshold);

        }
        return newRatings;
    }
}