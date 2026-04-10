package projeto3;

public class QuickSort {

    public static void ordenar(int[] vetor, int inicio, int fim) {

        if (inicio < fim) {

            int p = particionar(vetor, inicio, fim);

            ordenar(vetor, inicio, p - 1);
            ordenar(vetor, p + 1, fim);
        }
    }

    private static int particionar(int[] vetor, int inicio, int fim) {

        
        int meio = (inicio + fim) / 2;

       
        int temp = vetor[meio];
        vetor[meio] = vetor[fim];
        vetor[fim] = temp;

        int pivo = vetor[fim];
        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {

            if (vetor[j] < pivo) {
                i++;

                temp = vetor[i];
                vetor[i] = vetor[j];
                vetor[j] = temp;
            }
        }

        temp = vetor[i + 1];
        vetor[i + 1] = vetor[fim];
        vetor[fim] = temp;

        return i + 1;
    }
}