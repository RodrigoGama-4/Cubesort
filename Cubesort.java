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

        int[] inputSizes = {10, 100};
        
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
            long startTimeRandom, startTimeDecres, startTimeBest,
            startTimeWorst,endTimeWorst, endTimeRandom, endTimeDecres, endTimeBest,
            elapsedTimeDecres,elapsedTimeBest, elapsedTimeWorst,
            elapsedTimeRandom;

            System.out.println("Random Input:");
            startTimeRandom = System.nanoTime();
            sortArray(randomArray, n);
            endTimeRandom = System.nanoTime();
            elapsedTimeRandom = endTimeRandom - startTimeRandom;
           

            System.out.println("Decreasing Input:");
            startTimeDecres = System.nanoTime();
            sortArray(decreasingArray, n);
            endTimeDecres = System.nanoTime();
            elapsedTimeDecres = endTimeDecres - startTimeDecres;
            

            System.out.println("Best Case Input:");
            startTimeBest = System.nanoTime();
            sortArray(bestCaseArray, n);
            endTimeBest = System.nanoTime();
            elapsedTimeBest = endTimeBest - startTimeBest;
            

            System.out.println("Worst Case Input:");
            startTimeWorst = System.nanoTime();
            sortArray(worstCaseArray, n);
            endTimeWorst = System.nanoTime();
            elapsedTimeWorst = endTimeWorst - startTimeWorst;
          
            //tempos
            System.out.println("Input aleatorio teve um tempo de " + elapsedTimeRandom + " nanoseconds");
            System.out.println("Input decrescente teve um tempo de " + elapsedTimeDecres + " nanoseconds");
            System.out.println("INput com melhor caso teve um tempo de " + elapsedTimeBest + " nanoseconds");
            System.out.println("Pior caso teve um tempo de " + elapsedTimeWorst + " nanoseconds");

            System.out.println();
        }
    }
}
