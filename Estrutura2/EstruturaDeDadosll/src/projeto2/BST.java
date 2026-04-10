package projeto2;

public class BST {

    Node raiz;

    public void inserir(int valor) {

        Node novo = new Node(valor);

        if (raiz == null) {
            raiz = novo;
            return;
        }

        Node atual = raiz;

        while (true) {

            if (valor < atual.valor) {

                if (atual.esquerda == null) {
                    atual.esquerda = novo;
                    return;
                }

                atual = atual.esquerda;

            } else {

                if (atual.direita == null) {
                    atual.direita = novo;
                    return;
                }

                atual = atual.direita;
            }
        }
    }

    public boolean buscar(int valor) {
        return buscar(raiz, valor);
    }

    private boolean buscar(Node atual, int valor) {

        if (atual == null)
        	return false;

        if (valor == atual.valor)
        	return true;

        if (valor < atual.valor) {
            return buscar(atual.esquerda, valor);
        } else {
            return buscar(atual.direita, valor);
        }
    }
}