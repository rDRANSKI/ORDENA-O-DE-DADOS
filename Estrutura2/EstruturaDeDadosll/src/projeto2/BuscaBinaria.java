package projeto2;

public class BuscaBinaria {

    public static boolean buscar(int[] vetor, int valor) {

        int inicio = 0;
        int fim = vetor.length - 1;

        while (inicio <= fim) {

            int meio = (inicio + fim) / 2;

            if (vetor[meio] == valor) {
                return true;
            }

            if (valor < vetor[meio]) {
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }

        return false;
    }
}
