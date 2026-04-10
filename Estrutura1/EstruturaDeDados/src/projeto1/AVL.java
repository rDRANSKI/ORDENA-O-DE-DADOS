package projeto1;

public class AVL {
	Node raiz;
	
	public int altura(Node n) {
		if (n == null) {
			return 0;
		}
		return n.altura;
	}
	
	public int fatorBalanceamento(Node n) {
		if (n == null) {
			return 0;
		}
		
		return altura(n.esquerda) - altura(n.direita);
		
	}
	
	public void atualizarAltura(Node n) {
		n.altura = 1 + Math.max(altura(n.esquerda), altura(n.direita));
	}
	
	public Node rotacaoEsquerda(Node x) { 
		Node y = x.direita;
		Node T2 = y.esquerda;
		
		y.esquerda = x; 
		x.direita = T2;
		
		atualizarAltura(x);
		atualizarAltura(y);
		
		return y;
	}
	
	public Node rotacaoDireita(Node y) {
	    Node x = y.esquerda;
	    Node T2 = x.direita;

	    x.direita = y;
	    y.esquerda = T2;

	    atualizarAltura(y);
	    atualizarAltura(x);

	    return x;
	}
	
		public Node balancear(Node n) {
	    int fator = fatorBalanceamento(n);

	    // LL
	    if (fator > 1 && fatorBalanceamento(n.esquerda) >= 0) {
	        return rotacaoDireita(n);
	    }

	    // RR
	    if (fator < -1 && fatorBalanceamento(n.direita) <= 0) {
	        return rotacaoEsquerda(n);
	    }

	    // LR
	    if (fator > 1 && fatorBalanceamento(n.esquerda) < 0) {
	        n.esquerda = rotacaoEsquerda(n.esquerda);
	        return rotacaoDireita(n);
	    }

	    // RL
	    if (fator < -1 && fatorBalanceamento(n.direita) > 0) {
	        n.direita = rotacaoDireita(n.direita);
	        return rotacaoEsquerda(n);
	    }
	    
	    return n;
	    
	}
		
		
		public boolean buscar(int valor) {
		    return buscar(raiz, valor);
		}
		
		public void emOrdem(Node n) {
		    if (n != null) {
		        emOrdem(n.esquerda);
		        System.out.print(n.valor + " ");
		        emOrdem(n.direita);
		    }
		}

		private boolean buscar(Node n, int valor) {
		    if (n == null)
		    	return false;

		    if (valor == n.valor)
		    	return true;

		    if (valor < n.valor) {
		        return buscar(n.esquerda, valor);
		    } else {
		        return buscar(n.direita, valor);
		    }
		}
		
		Node inserir(Node n, int valor) {
		    if (n == null) {
		        return new Node(valor);
		    }

		    if (valor < n.valor) {
		        n.esquerda = inserir(n.esquerda, valor);
		    } else if (valor > n.valor) {
		        n.direita = inserir(n.direita, valor);
		    } else {
		        return n; // não permite duplicado
		    }

		    atualizarAltura(n);

		    return balancear(n);
		}
		

		void inserir(int valor) {
		    raiz = inserir(raiz, valor);
		}
		
		Node remover(Node n, int valor) {
		    if (n == null) return null;

		    if (valor < n.valor) {
		        n.esquerda = remover(n.esquerda, valor);
		    } else if (valor > n.valor) {
		        n.direita = remover(n.direita, valor);
		    } else {

		        // 1 ou 0 filhos
		        if (n.esquerda == null) return n.direita;
		        if (n.direita == null) return n.esquerda;

		        // 2 filhos
		        Node menor = n.direita;
		        while (menor.esquerda != null) {
		            menor = menor.esquerda;
		        }

		        n.valor = menor.valor;
		        n.direita = remover(n.direita, menor.valor);
		    }

		    atualizarAltura(n);

		    return balancear(n);
		}
	
	
	
	
	
	
	
	
	
	
	
	
}
