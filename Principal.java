import java.util.Arrays;
import java.util.Random;

public class Principal {
    public static void main(String[] args) {
        Cubesort ordenar = new Cubesort();

        int[] randomArray = new int[0];
        int numeroComparacoes = 10000000;
       
        
        System.out.println("Tamanho do array: " + numeroComparacoes);
        
        //Array aleatório
        randomArray = new int[numeroComparacoes];
        Random random = new Random();
        for (int i = 0; i < numeroComparacoes; i++) {
            randomArray[i] = random.nextInt();
        }
        long startTimeRandom = System.nanoTime();
        ordenar.cubesort(randomArray, 2);
        //System.out.println(Arrays.toString(randomArray));
        long endTimeRandom = System.nanoTime();

        //Array decrescente
        int[] decreasingArray = new int[numeroComparacoes];
        for (int i = 0; i < numeroComparacoes; i++) {
            decreasingArray[i] = numeroComparacoes - i;
        } 
        long startTimeDecres = System.nanoTime();
        ordenar.cubesort(decreasingArray, 2);

        //System.out.println(Arrays.toString(decreasingArray));
        long endTimeDecres = System.nanoTime();
        
       
        // Array ordenado
        int[] bestCaseArray = Arrays.copyOf(randomArray, numeroComparacoes);
        Arrays.sort(bestCaseArray);
        long startTimeBest = System.nanoTime();
        ordenar.cubesort(bestCaseArray, 2);
        //System.out.println(Arrays.toString(bestCaseArray));
        long endTimeBest = System.nanoTime();

        
        System.out.println("Tempo de execução do random input: " + (endTimeRandom - startTimeRandom) / 1e9 + " segundos");
        System.out.println("Tempo de execução do melhor caso input: " + (endTimeBest - startTimeBest) / 1e9 + " segundos");
        System.out.println("Tempo de execução do decrescente input: " + (endTimeDecres - startTimeDecres) / 1e9 + " segundos");

       
    }
}
