package projeto1;

 public class Node {
   int valor;
   Node esquerda;
   Node direita;
   int altura;
   
   public Node(int valor) {
	   this.valor = valor;
	   this.esquerda = null;
	   this.direita = null;
	   this.altura = 1;
   }
   
}	