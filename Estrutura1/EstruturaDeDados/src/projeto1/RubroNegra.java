package projeto1;

public class RubroNegra {
	NodeRB raiz;

	public NodeRB inserir(NodeRB raiz, NodeRB novo) {
	    if (raiz == null) {
	        return novo;
	    }

	    if (novo.valor < raiz.valor) {
	        raiz.esquerda = inserir(raiz.esquerda, novo);
	        raiz.esquerda.pai = raiz;
	    } else {
	        raiz.direita = inserir(raiz.direita, novo);
	        raiz.direita.pai = raiz;
	    }

	    return raiz;
	}
	
	public void inserir(int valor) {
	    NodeRB novo = new NodeRB(valor);

	    raiz = inserir(raiz, novo);
	    corrigirInsercao(novo);

	    raiz.vermelho = false;
	}
	
	public NodeRB rotacaoEsquerda(NodeRB x) {
	    NodeRB y = x.direita;
	    x.direita = y.esquerda;

	    if (y.esquerda != null) {
	        y.esquerda.pai = x;
	    }

	    y.pai = x.pai;

	    if (x.pai == null) {
	        raiz = y;
	    } else if (x == x.pai.esquerda) {
	        x.pai.esquerda = y;
	    } else {
	        x.pai.direita = y;
	    }

	    y.esquerda = x;
	    x.pai = y;

	    return y;
	}
	
	public NodeRB rotacaoDireita(NodeRB y) {
	    NodeRB x = y.esquerda;
	    y.esquerda = x.direita;

	    if (x.direita != null) {
	        x.direita.pai = y;
	    }

	    x.pai = y.pai;

	    if (y.pai == null) {
	        raiz = x;
	    } else if (y == y.pai.esquerda) {
	        y.pai.esquerda = x;
	    } else {
	        y.pai.direita = x;
	    }

	    x.direita = y;
	    y.pai = x;

	    return x;
	    
	}
	
	public void corrigirInsercao(NodeRB n) {

	    while (n != raiz && n.pai.vermelho) {

	        if (n.pai == n.pai.pai.esquerda) {

	            NodeRB tio = n.pai.pai.direita;

	            // tio vermelho
	            if (tio != null && tio.vermelho) {
	                n.pai.vermelho = false;
	                tio.vermelho = false;
	                n.pai.pai.vermelho = true;
	                n = n.pai.pai;
	            } else {

	                // zig-zag
	                if (n == n.pai.direita) {
	                    n = n.pai;
	                    rotacaoEsquerda(n);
	                }

	                //linha reta
	                n.pai.vermelho = false;
	                n.pai.pai.vermelho = true;
	                rotacaoDireita(n.pai.pai);
	            }

	        } else {

	            // espelhado
	            NodeRB tio = n.pai.pai.esquerda;

	            if (tio != null && tio.vermelho) {
	                n.pai.vermelho = false;
	                tio.vermelho = false;
	                n.pai.pai.vermelho = true;
	                n = n.pai.pai;
	            } else {

	                if (n == n.pai.esquerda) {
	                    n = n.pai;
	                    rotacaoDireita(n);
	                }

	                n.pai.vermelho = false;
	                n.pai.pai.vermelho = true;
	                rotacaoEsquerda(n.pai.pai);
	            }
	        }
	    }
	}
	
	public void emOrdem(NodeRB n) {
	    if (n != null) {
	        emOrdem(n.esquerda);
	        System.out.print(n.valor + " ");
	        emOrdem(n.direita);
	    }
	}
	
	public int altura(NodeRB n) {
	    if (n == null)
	    	return 0;

	    int esq = altura(n.esquerda);
	    int dir = altura(n.direita);

	    return Math.max(esq, dir) + 1;
	}
	
	public NodeRB buscar(NodeRB n, int valor) {
	    if (n == null || n.valor == valor)
	    	return n;

	    if (valor < n.valor)
	        return buscar(n.esquerda, valor);
	    else
	        return buscar(n.direita, valor);
	}
	
	public NodeRB remover(NodeRB raiz, int valor) {
	    if (raiz == null) return null;

	    if (valor < raiz.valor) {
	        raiz.esquerda = remover(raiz.esquerda, valor);
	    } else if (valor > raiz.valor) {
	        raiz.direita = remover(raiz.direita, valor);
	    } else {

	        // nó com 1 ou 0 filhos
	        if (raiz.esquerda == null)
	            return raiz.direita;
	        else if (raiz.direita == null)
	            return raiz.esquerda;

	        // nó com 2 filhos
	        NodeRB sucessor = menorValor(raiz.direita);
	        raiz.valor = sucessor.valor;
	        raiz.direita = remover(raiz.direita, sucessor.valor);
	    }

	    return raiz;
	}
	
	public NodeRB menorValor(NodeRB n) {
	    while (n.esquerda != null)
	        n = n.esquerda;
	    return n;
	}



}
