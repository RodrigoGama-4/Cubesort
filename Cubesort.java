import java.util.Arrays;
import java.util.Random;

public class CubesortRan {
    public static void cubesort(int[] A, int p) {
        
        int n = A.length;
        int subarraySize = n / p;
        
        // Step 1: Partition the data
        int[][] subarrays = new int[p][];
        for (int i = 0; i < p; i++) {
            int[] subarray = Arrays.copyOfRange(A, i * subarraySize, (i + 1) * subarraySize);
            subarrays[i] = subarray;
        }
        
        // Step 2: Sort each subarray in parallel
        for (int[] subarray : subarrays) {
            Arrays.sort(subarray);
        }
        
        
        for (int dim = 0; dim < Integer.numberOfTrailingZeros(p); dim++) {
            for (int i = 0; i < p; i++) {
                int partner = i ^ (1 << dim);
                if (i < partner) {
                    int[] merged = new int[subarraySize * 2];
                    System.arraycopy(subarrays[i], 0, merged, 0, subarraySize);
                    System.arraycopy(subarrays[partner], 0, merged, subarraySize, subarraySize);
                    Arrays.sort(merged);
                    System.arraycopy(merged, 0, subarrays[i], 0, subarraySize);
                    System.arraycopy(merged, subarraySize, subarrays[partner], 0, subarraySize);
                }
            }
        }
        
        
        // Step 4: Copy the sorted subarrays back to the original array
        int index = 0;
        for (int[] subarray : subarrays) {
            System.arraycopy(subarray, 0, A, index, subarraySize);
            index += subarraySize;
        }
    }

    public static void main(String[] args) {
        int[] randomArray = new int[0];
        int numeroComparacoes = 10000000;
       
        
        System.out.println("Input Size: " + numeroComparacoes);
        
        
        // Generate random input array
        randomArray = new int[numeroComparacoes];
        Random random = new Random();
        for (int i = 0; i < numeroComparacoes; i++) {
            randomArray[i] = random.nextInt();
        }
        long startTimeRandom = System.nanoTime();
        cubesort(randomArray, 2);
        //System.out.println(Arrays.toString(randomArray));
        long endTimeRandom = System.nanoTime();
        
        
        // Generate decreasing input array
        int[] decreasingArray = new int[numeroComparacoes];
        for (int i = 0; i < numeroComparacoes; i++) {
            decreasingArray[i] = numeroComparacoes - i;
        } 
        long startTimeDecres = System.nanoTime();
        cubesort(decreasingArray, 2);
        //System.out.println(Arrays.toString(decreasingArray));
        long endTimeDecres = System.nanoTime();
        
        
        // Best case scenario: array is already sorted
        int[] bestCaseArray = Arrays.copyOf(randomArray, numeroComparacoes);
        Arrays.sort(bestCaseArray);
        long startTimeBest = System.nanoTime();
        cubesort(bestCaseArray, numeroComparacoes);
        //System.out.println(Arrays.toString(bestCaseArray));
        long endTimeBest = System.nanoTime();
        
        
        // Worst case scenario: array is sorted in reverse order
        int[] worstCaseArray = Arrays.copyOf(randomArray, numeroComparacoes);
        Arrays.sort(worstCaseArray);
        for (int i = 0; i < numeroComparacoes / 2; i++) {
            int temp = worstCaseArray[i];
            worstCaseArray[i] = worstCaseArray[numeroComparacoes - i - 1];
            worstCaseArray[numeroComparacoes - i - 1] = temp;
        }
        long startTimeWorst = System.nanoTime();
        cubesort(worstCaseArray, numeroComparacoes);
        //System.out.println(Arrays.toString(worstCaseArray));
        long endTimeWorst = System.nanoTime();

        System.out.println("Tempo de execução do random input: " + (endTimeRandom - startTimeRandom) / 1e9 + " segundos");
        System.out.println("Tempo de execução do decrescente input: " + (endTimeDecres - startTimeDecres) / 1e9 + " segundos");
        System.out.println("Tempo de execução do melhor caso input: " + (endTimeBest - startTimeBest) / 1e9 + " segundos");
        System.out.println("Tempo de execução do pior caso input: " + (endTimeWorst - startTimeWorst) / 1e9 + " segundos");




    }
}
