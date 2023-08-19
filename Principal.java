import java.util.Arrays;
import java.util.Random;

public class Principal {
    public static void main(String[] args) {
        Cubesort ordenar = new Cubesort();

        int[] randomArray = new int[0];
        int numeroComparacoes = 10000000;
       
        
        System.out.println("Tamanho do array: " + numeroComparacoes);
        
        
       
        // Array ordenado
        int[] bestCaseArray = Arrays.copyOf(randomArray, numeroComparacoes);
        Arrays.sort(bestCaseArray);
        long startTimeBest = System.nanoTime();
        ordenar.cubesort(bestCaseArray, 2);
        //System.out.println(Arrays.toString(bestCaseArray));
        long endTimeBest = System.nanoTime();


        System.out.println("Tempo de execução do random input: " + (endTimeBest - startTimeBest) / 1e9 + " segundos");
       
    }
}
