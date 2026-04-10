package projeto1;

public class main {

    public static void main(String[] args) {

  
        System.out.println("=== BST ===");

        BST bst = new BST();

        bst.inserir(10);
        bst.inserir(20);
        bst.inserir(30);
        bst.inserir(40);
        bst.inserir(50);

        System.out.print("BST em ordem: ");
        bst.emOrdem(bst.raiz);

        System.out.println("\nAltura BST: " + bst.altura(bst.raiz));

        //Remoção
        System.out.println("\nRemovendo 30...");
        bst.raiz = bst.remover(bst.raiz, 30);

        System.out.print("BST após remoção: ");
        bst.emOrdem(bst.raiz);

        System.out.println("\nAltura BST após remoção: " + bst.altura(bst.raiz));


       
        System.out.println("\n=== AVL ===");

        AVL avl = new AVL();

        avl.inserir(10);
        avl.inserir(20);
        avl.inserir(30);
        avl.inserir(40);
        avl.inserir(50);

        System.out.print("AVL em ordem: ");
        avl.emOrdem(avl.raiz);

        System.out.println("\nAltura AVL: " + avl.altura(avl.raiz));

        // Remoção
        System.out.println("\nRemovendo 30...");
        avl.raiz = avl.remover(avl.raiz, 30);

        System.out.print("AVL após remoção: ");
        avl.emOrdem(avl.raiz);

        System.out.println("\nAltura AVL após remoção: " + avl.altura(avl.raiz));


        System.out.println("\n=== BUSCA ===");

        System.out.println("BST buscar 40: " + bst.buscar(40));
        System.out.println("BST buscar 99: " + bst.buscar(99));


        System.out.println("\n\n===== RUBRO-NEGRA =====");

        RubroNegra rb = new RubroNegra();

        rb.inserir(10);
        rb.inserir(5);
        rb.inserir(20);

        System.out.print("Em ordem: ");
        rb.emOrdem(rb.raiz);

        System.out.println("\nAltura: " + rb.altura(rb.raiz));

        System.out.println("Buscar 10: " + (rb.buscar(rb.raiz, 10) != null));

        rb.raiz = rb.remover(rb.raiz, 10);

        System.out.print("Após remover 10: ");
        rb.emOrdem(rb.raiz);



     
        System.out.println("\n\n===== CAIXEIRO VIAJANTE =====");

        System.out.println("\n\n===== CAIXEIRO VIAJANTE (EXPERIMENTOS) =====");

        int[] tamanhos = {5, 10, 20};

        for (int n : tamanhos) {
            int soma = 0;

            for (int i = 0; i < 30; i++) {
                int[][] matriz = CaixeiroViajante.gerarMatriz(n);
                int custo = CaixeiroViajante.calcular(matriz);
                soma += custo;
            }

            double media = soma / 30.0;

            System.out.println("Tamanho " + n + " -> Média do custo: " + media);
        }
    } 
 }