package projeto2;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("===== TESTES DE BUSCA =====");

        int[] tamanhos = {1000, 5000, 10000};
        Random r = new Random();

        for (int n : tamanhos) {

            long[] seq = new long[30];
            long[] bin = new long[30];
            long[] arv = new long[30];

            for (int i = 0; i < 30; i++) {

                int[] vetor = new int[n];

                for (int j = 0; j < n; j++) {
                    vetor[j] = r.nextInt(100000);
                }

                int alvo = vetor[r.nextInt(n)];

                //Sequencial
                long inicio = System.nanoTime();
                BuscaSequencial.buscar(vetor, alvo);
                long fim = System.nanoTime();
                seq[i] = fim - inicio;

                //Binária
                Arrays.sort(vetor);
                inicio = System.nanoTime();
                BuscaBinaria.buscar(vetor, alvo);
                fim = System.nanoTime();
                bin[i] = fim - inicio;

                //Árvore
                BST bst = new BST();
                for (int num : vetor) {
                    bst.inserir(num);
                }

                inicio = System.nanoTime();
                bst.buscar(alvo);
                fim = System.nanoTime();
                arv[i] = fim - inicio;
            }

            System.out.println("\nTamanho: " + n);

            System.out.println("Sequencial -> Média: " + media(seq) + " | Desvio: " + desvio(seq));
                               

            System.out.println("Binária -> Média: " + media(bin) + " | Desvio: " + desvio(bin));
                              

            System.out.println("Árvore -> Média: " + media(arv) +  " | Desvio: " + desvio(arv));
                             
        }
    }

    public static double media(long[] valores) {
        double soma = 0;
        for (long v : valores) soma += v;
        return soma / valores.length;
    }

    public static double desvio(long[] valores) {
        double m = media(valores);
        double soma = 0;

        for (long v : valores) {
            soma += Math.pow(v - m, 2);
        }

        return Math.sqrt(soma / valores.length);
    }
}