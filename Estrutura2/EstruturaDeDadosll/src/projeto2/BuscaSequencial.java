package projeto2;

public class BuscaSequencial {

    public static boolean buscar(int[] vetor, int valor) {

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == valor) {
                return true;
            }
        }

        return false;
    }
}
