package projeto3;

import java.util.Random;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println("===== BENCHMARK DE ORDENAÇÃO =====");

        int[] tamanhos = {100, 500, 1000};
        Random r = new Random();

        for (int n : tamanhos) {

            long[] bubbleMedio = new long[30];
            long[] quickMedio = new long[30];

            long[] bubblePior = new long[30];
            long[] quickPior = new long[30];

            long[] bubbleMelhor = new long[30];
            long[] quickMelhor = new long[30];

            for (int i = 0; i < 30; i++) {

                // Caso medio(aleatório)
                int[] vetor = new int[n];
                for (int j = 0; j < n; j++) {
                    vetor[j] = r.nextInt(10000);
                }

                int[] copia1 = Arrays.copyOf(vetor, n); //copia 1 recebe a copia do array para testar bubblesort ou quicksort
                int[] copia2 = Arrays.copyOf(vetor, n);	//copia 2 recebe a copia do array para testar bubblesort ou quicksort

                long inicio = System.nanoTime();
                BubbleSort.ordenar(copia1);
                long fim = System.nanoTime();
                bubbleMedio[i] = (fim - inicio) / 1000;

                inicio = System.nanoTime();
                QuickSort.ordenar(copia2, 0, n - 1);
                fim = System.nanoTime();
                quickMedio[i] = (fim - inicio) / 1000;

                // Pior caso (ordenado inverso)
                int[] pior = new int[n];
                for (int j = 0; j < n; j++) {
                    pior[j] = n - j;
                }

                copia1 = Arrays.copyOf(pior, n);
                copia2 = Arrays.copyOf(pior, n);

                inicio = System.nanoTime();
                BubbleSort.ordenar(copia1);
                fim = System.nanoTime();
                bubblePior[i] = (fim - inicio) / 1000;

                inicio = System.nanoTime();
                QuickSort.ordenar(copia2, 0, n - 1);
                fim = System.nanoTime();
                quickPior[i] = (fim - inicio) / 1000;

                //Melhor caso (já ordenado)
                int[] melhor = new int[n];
                for (int j = 0; j < n; j++) {
                    melhor[j] = j;
                }

                copia1 = Arrays.copyOf(melhor, n);
                copia2 = Arrays.copyOf(melhor, n);

                inicio = System.nanoTime();
                BubbleSort.ordenar(copia1);
                fim = System.nanoTime();
                bubbleMelhor[i] = (fim - inicio) / 1000;

                inicio = System.nanoTime();
                QuickSort.ordenar(copia2, 0, n - 1);
                fim = System.nanoTime();
                quickMelhor[i] = (fim - inicio) / 1000;
            }

            System.out.println("\nTamanho: " + n);

            System.out.println("Bubble Médio -> " + media(bubbleMedio));
            System.out.println("Quick Médio -> " + media(quickMedio));

            System.out.println("Bubble Pior -> " + media(bubblePior));
            System.out.println("Quick Pior -> " + media(quickPior));

            System.out.println("Bubble Melhor -> " + media(bubbleMelhor));
            System.out.println("Quick Melhor -> " + media(quickMelhor));
        }
    }

    public static double media(long[] valores) {
        double soma = 0;
        for (long v : valores) soma += v;
        return soma / valores.length;
    }
}