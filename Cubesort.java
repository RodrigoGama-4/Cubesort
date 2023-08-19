import java.util.Arrays;

public class Cubesort {
    public void cubesort(int[] A, int p) {
        
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

  
}
