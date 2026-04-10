package projeto1;

import java.util.Random;

public class CaixeiroViajante {

    // heurística: vizinho mais próximo
    public static int calcular(int[][] distancias) {
        int n = distancias.length;

        boolean[] visitado = new boolean[n];
        int atual = 0;
        int custo = 0;

        visitado[0] = true;

        for (int i = 0; i < n - 1; i++) {
            int proxima = -1;
            int menorDist = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                if (!visitado[j] && distancias[atual][j] < menorDist) {
                    menorDist = distancias[atual][j];
                    proxima = j;
                }
            }

            visitado[proxima] = true;
            custo += menorDist;
            atual = proxima;
        }

        // voltar para origem
        custo += distancias[atual][0];

        return custo;
    }

    // gerar matriz aleatória
    public static int[][] gerarMatriz(int n) {
        Random r = new Random();
        int[][] m = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    m[i][j] = 0;
                } else {
                    m[i][j] = r.nextInt(50) + 1;
                }
            }
        }

        return m;
    }
}