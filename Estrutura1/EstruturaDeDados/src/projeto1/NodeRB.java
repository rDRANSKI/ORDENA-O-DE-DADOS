package projeto1;

public class NodeRB {
    int valor;
    NodeRB esquerda;
    NodeRB direita;
    NodeRB pai;
    boolean vermelho;

    public NodeRB(int valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
        this.pai = null;
        this.vermelho = true; // sempre nasce vermelho
    }
}