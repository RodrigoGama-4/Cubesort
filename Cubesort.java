import java.util.*;

public class Cubesort{

    static void sortArray(int arr[], int n) {
        Integer[] ar = new Integer[n];

        for (int i = 0; i < n; i++) {
            ar[i] = arr[i];
        }

        Arrays.sort(ar, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                int x = (int) Math.pow(a, 3);
                int y = (int) Math.pow(b, 3);
                return Integer.compare(x, y);
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.println(ar[i] + " ");
        }
    }

     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputSizes = {10};
        
        for (int n : inputSizes) {
            System.out.println("Input Size: " + n);
            
            // Generate random input array
            int[] randomArray = new int[n];
            Random random = new Random();
            for (int i = 0; i < n; i++) {
                randomArray[i] = random.nextInt();
            }
            
            // Generate decreasing input array
            int[] decreasingArray = new int[n];
            for (int i = 0; i < n; i++) {
                decreasingArray[i] = n - i;
            }

            // Best case scenario: array is already sorted
            int[] bestCaseArray = Arrays.copyOf(randomArray, n);
            Arrays.sort(bestCaseArray);

            // Worst case scenario: array is sorted in reverse order
            int[] worstCaseArray = Arrays.copyOf(randomArray, n);
            Arrays.sort(worstCaseArray);
            for (int i = 0; i < n / 2; i++) {
                int temp = worstCaseArray[i];
                worstCaseArray[i] = worstCaseArray[n - i - 1];
                worstCaseArray[n - i - 1] = temp;
            }

            // Measure time for sorting in different scenarios
            long startTime, endTime, elapsedTime;

            System.out.println("Random Input:");
            startTime = System.nanoTime();
            sortArray(randomArray, n);
            endTime = System.nanoTime();
            elapsedTime = endTime - startTime;
            System.out.println("Time taken: " + elapsedTime + " nanoseconds");

            System.out.println("Decreasing Input:");
            startTime = System.nanoTime();
            sortArray(decreasingArray, n);
            endTime = System.nanoTime();
            elapsedTime = endTime - startTime;
            System.out.println("Time taken: " + elapsedTime + " nanoseconds");

            System.out.println("Best Case Input:");
            startTime = System.nanoTime();
            sortArray(bestCaseArray, n);
            endTime = System.nanoTime();
            elapsedTime = endTime - startTime;
            System.out.println("Time taken: " + elapsedTime + " nanoseconds");

            System.out.println("Worst Case Input:");
            startTime = System.nanoTime();
            sortArray(worstCaseArray, n);
            endTime = System.nanoTime();
            elapsedTime = endTime - startTime;
            System.out.println("Time taken: " + elapsedTime + " nanoseconds");

            System.out.println();
        }
    }
}
