package projeto1;

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
		        	} else {
		            atual = atual.esquerda;
		        	}
		        	
		        } else {
		        		if (atual.direita == null) {
		        			atual.direita = novo;
		        			return;
		        		} else {
		        			atual = atual.direita;
		        		}
		      }  	
		  }      	
		}        	
		        	
		 public void emOrdem(Node atual) {
			 if (atual != null) {
				 emOrdem(atual.esquerda);
				 System.out.println(atual.valor);
				 emOrdem(atual.direita);
			 }
		 }
		 
		 public void imprimir() {
			 emOrdem(raiz);
			 System.out.println();
		 }
		 
		 public boolean buscar (Node atual, int valor) {
			 if (atual == null) {
				 return false;
			 }
			 
			 if (valor == atual.valor) {
				 return true;
			 }
			 
			 if (valor < atual.valor) {
			return	buscar(atual.esquerda, valor);
			 } else {
			return buscar(atual.direita, valor);
			 }
			 
		 }
		 
		 public boolean buscar(int valor) {
			 return buscar(raiz, valor);
		 }
		 
		 public int altura(Node atual) {
			 if (atual == null) {
				 return 0;
			 }
			 
			 int alturaEsquerda = altura(atual.esquerda);
			 int alturaDireita = altura(atual.direita);
			 return Math.max(alturaEsquerda, alturaDireita) +1;
			  
		 }
		 
		 public Node remover(Node atual, int valor) {
			 if (atual == null) {
				 return null;
			 }
			 
			 if (valor < atual.valor) {
				atual.esquerda = remover(atual.esquerda, valor);
			 } else if (valor > atual.valor) {
				atual.direita = remover(atual.direita, valor); 
			 } else {
				 if (atual.esquerda == null) {
					 return atual.direita;
			 } else if (atual.direita == null ) {
				 return atual.esquerda;
			 }
				 
				 Node menor = atual.direita;
				 
				 while (menor.esquerda != null) {
					 menor = menor.esquerda;
				 }
				 
				 atual.valor = menor.valor;
				 atual.direita = remover (atual.direita, menor.valor);
				 
			 }
			 
			 return atual;
		}
		 
		 public void remover(int valor) {
			    raiz = remover(raiz, valor);
			}
		 
		
			 
		 
	    
	 
}