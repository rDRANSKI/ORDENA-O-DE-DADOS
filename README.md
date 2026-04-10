# 📊 Estrurura, Pesquise e Ordenação de Dados em Java

Este repositório contém a implementação de três projetos acadêmicos focados em estruturas de dados, algoritmos e análise de desempenho.

---

## 📁 Estrutura do Projeto

O repositório está organizado em três pacotes independentes:

```
Estrutura1/
 └── EstruturaDeDados/       → Projeto 1 (Árvores + Caixeiro Viajante)

Estrutura2/
 └── EstruturaDeDadosII/     → Projeto 2 (Sistemas de Busca)

Estrutura3/
 └── EstruturaDeDadosIII/    → Projeto 3 (Ordenação e Benchmark)
```

Cada projeto possui sua própria classe `main` e deve ser executado separadamente.

---

## ⚙️ Requisitos

* Java JDK **17.0.11** ou superior
* IDE recomendada: **Eclipse**

---

## ▶️ Como Executar

### Pelo Eclipse

1. Clone o repositório:

```
git clone https://github.com/rDRANSKI/ORDENA-O-DE-DADOS.git
```

2. Importe o projeto no Eclipse:

* `File → Import → Existing Projects into Workspace`

3. Navegue até o pacote desejado

4. Execute a classe principal:

* Clique com o botão direito no arquivo `Main.java` ou `main.java`
* `Run As → Java Application`

---

## ✔️ PROJETO 1 – Árvores e Balanceamento

### Estruturas implementadas:

* Árvore Binária de Busca (BST)
* Árvore AVL
* Árvore Rubro-Negra

### Operações:

* Inserção
* Remoção
* Busca
* Cálculo de altura

### Problema do Caixeiro-Viajante:

* Heurística aproximada
* Uso de `java.util.Random`
* Execução automática com múltiplos tamanhos de entrada

### Exemplo de saída:

```
=== BST ===
BST em ordem: 10 20 30 40 50
Altura BST: 5

Removendo 30...
BST após remoção: 10 20 40 50
Altura BST após remoção: 4
```

```
==== CAIXEIRO VIAJANTE ====
Tamanho 5  -> Média do custo: 103.2
Tamanho 10 -> Média do custo: 130.93333333333334
Tamanho 20 -> Média do custo: 177.56666666666666
```

---

## ✔️ PROJETO 2 – Sistemas de Busca

### Algoritmos implementados:

* Busca Sequencial
* Busca Binária
* Busca em Árvore (BST)

### Características:

* Dados gerados automaticamente (`Random`)
* Testes com diferentes tamanhos:

  * 1000
  * 5000
  * 10000

### Métricas:

* Tempo médio
* Desvio padrão

### Exemplo de saída:

```
===== TESTES DE BUSCA =====

Tamanho: 1000
Sequencial -> Média: 548220.0 | Desvio: 2801597.8499658606
Binária   -> Média: 608870.0 | Desvio: 3264158.3511578194
Árvore    -> Média: 30016.666666666668 | Desvio: 50540.268323607284
```

---

## ✔️ PROJETO 3 – Benchmark de Ordenação

### Algoritmos implementados:

* Bubble Sort
* Quick Sort

### Cenários analisados:

* Melhor caso
* Caso médio
* Pior caso

### Métricas:

* Tempo de execução
* Comparação entre teoria e prática

### Exemplo de saída:

```
===== BENCHMARK DE ORDENAÇÃO =====

Tamanho: 100
Bubble Médio -> 135.36666666666667
Quick Médio  -> 57.53333333333333

Bubble Pior  -> 109.96666666666667
Quick Pior   -> 17.166666666666668

Bubble Melhor -> 115.9
Quick Melhor  -> 11.066666666666666
```

---

## Metodologia Experimental

* Execuções automáticas dentro do código
* Uso de dados gerados aleatoriamente
* Cálculo automático de:

  * Média
  * Desvio padrão
* Comparação entre resultados teóricos e empíricos

---

## Bibliotecas Utilizadas

* `java.util.Random`
* `java.util.*`
* `java.util.Arrays`

---

## 📌 Observações

* Não há entrada manual de dados
* Todos os testes são executados automaticamente ao rodar o programa
* Resultados são exibidos diretamente no console

---

## 👨‍💻 Autores

* Marcos Vinicius Cardozo Pereira
* Nefertiti Duane Kruger 
* Ronaldo Dranski

Projeto desenvolvido para fins acadêmicos na disciplina de Estrutura de Dados.

---

