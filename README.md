**TÍTULO DO PROJECTO: CykParser

**GRUPO: TURMA 6 - GRUPO 3



NOME1: João Manuel Ferreira Trindade, NR1: 201109221, AUTO1: 18, CONTRIBUIÇÃO: 25%)

NOME2: Paulo Bordalo Marcos, NR2: 201100759, AUTO2: 18, CONTRIBUIÇÃO: 25%)

NOME3: Pedro Miguel Sousa Santos, NR3: 201102999, AUTO3: 18, CONTRIBUIÇÃO: 25%)

NOME4: Rui Pedro Menezes da Rosa Neves, NR4: 201109350, AUTO4: 18, CONTRIBUIÇÃO: 25%)



** SUMÁRIO:

O nosso projecto é sobre o algoritmo Cyk. O algoritmo Cyk verifica para uma dada gramática na forma 
Chomsky (nesta forma cada produção apenas pode ser dois símbolos não terminais ou um símbolo não terminal) 
se uma dada frase se verifica naquela gramática.
Dividimos isto em duas vertentes:

- A primeira é onde o utilizador insere ele próprio a gramática através da linha de comandos e fornece a frase para testar.
- A segunda é onde o utilizador escolhe um ficheiro para carregar a gramática e fornece uma frase para testar para a gramática carregada.

**VERIFICAÇÕES SINTÁTICAS:

O nosso programa apenas aceita gramáticas na forma Chomsky, logo tivemos que limitar os inputs para os seguintes formatos:
VARIAVEL "->" NAO TERMINAL NAO TERMINAL
VARIAVEL "->" TERMINAL
TS "->" TERMINAL

em que TS é um terminal (Exemplo: "Det -> a").

Logo, se for inserido um NAO TERMINAL a seguir a um TS a excepção será apanhada e será dito que a produção está incorrecta devolvendo o utilizador ao menu inicial para ele inserir uma nova gramática.
O mesmo acontece com a VARIAVEL e o TS se se inserir mais que duas produções NAO TERMINAIS para o caso da VARIAVEL e duas TERMINAIS para a TS (ultrapassando assim o limite da forma normal de Chomsky).

**ANÁLISE SEMÂNTICA:

Para a análise semântica temos a nossa função cyk que recebe uma frase para testar se se verifica na gramática inserida ou carregada. Uma frase é aceite se na tabela que construimos, o elemento do topo tiver pelo menos uma produção.
Por exemplo, para a gramática:
S->A B
A->a
B->b
			1ªiteração
				 _ _ _ _                       _ _ _ _
				|       |                     |       |
				|_ _ _ _|_ _ _ _              |_ _ _ _|_ _ _ _
				|       |       |     -->     |   A   |   B   |
				|_ _ _ _|_ _ _ _|             |_ _ _ _|_ _ _ _|
				|   a   |   b   |             |   a   |   b   |
				
				o algoritmo irá verificar se existem regras para os não terminais a e b e vai adicionar essas regras à tabela. Neste caso irá encontrar A->a e B->b adicionando A e B à tabela.
				
			2ªiteração
				 _ _ _ _                       _ _ _ _
				|       |                     |   S   |
				|_ _ _ _|_ _ _ _              |_ _ _ _|_ _ _ _
				|   A   |   B   |     -->     |   A   |   B   |
				|_ _ _ _|_ _ _ _|             |_ _ _ _|_ _ _ _|
				|   a   |   b   |             |   a   |   b   |
				
				depois o algoritmo irá verificar linha a linha, nomeadamente os campos abaixo na sua coluna com os campos na sua diagonal inferior direita. Ou seja, se estiver na linha 2 coluna 1, irá verificar a linha 1 coluna 1 com
				a linha 1 coluna 2. Se houvesse uma terceira linha iria verificar a linha 2 coluna 1 (imediatamente abaixo) com a linha 1 coluna 3 (diagonal inferior direita, depois subindo em escada) e de seguida a linha 1 coluna 1 com 
				a linha 2 coluna 2 fazendo um "X".
				
				
**REPRESENTAÇÃO INTERMÉDIA (IRs):

Para a representação intermédia fizemos uma árvore abstracta da nossa gramática onde apenas temos um nível na árvore (ASSIGNMNT) Ela é apresentada no final do algoritmo.
Exemplo:
S->A B
A->a
B->b

			ASSIGNMNT
			    |
			   / \
			  A   B
			  
			ASSIGNMNT
			    |
				A
				|
				a
				
			ASSIGNMNT
			    |
				B
				|
				b
				
**GERAÇÃO DE CÓDIGO: (Describe how the code generation of your tool works and identify the possible problems your tool has regarding code generation.)

Para a geração de código guardamos os nossos símbolos em dois ArrayList, um para os símbolos terminais (terminals) e outro para os símbolos não terminais (variables) o que nos foi bastante útil para a execução do algoritmo.

**OVERVIEW: (refer the approach used in your tool, the main algorithms, etc.)

Usamos o JJTREE e o JAVACC para fazer o "parse" da gramática e anotar a mesma e usamos o CYK Algorithm para verificar se uma dada frase se insere na gramática.

**TESTES: 

Temos 5 .txt's com exemplos de gramáticas com um bom número de produções em que testamos frases que se verificam nas mesmas. Com os txt's apenas será necessário inserir a frase que se quer testar, visto que esta poderá ser diferente.
Existe também a possibilidade de criarmos nós a gramática com base no que aprendemos de CFG's ( tendo estas que ser convertidas para CNF (Chomsky Normal Form)).

**DISTRIBUIÇÃO DE TAREFAS: 

Análise Sintática e Semântica trabalhada em conjunto com a percepção e desenvolvimento / adaptação do algoritmo.
Tratamento de excepções decidido também em conjunto.

O trabalho foi efectuado com todos os membros presentes, visto que nos juntavamos na FEUP para o fazer.


**PROS: (Identify the most positive aspects of your tool)
- Algoritmo rápido e funcional
- Boa apresentação da AST
- Boa ajuda ao utilizador (tratamento de erros)
- Dois modos de teste
- Continuação do programa em caso de erros

**CONS: (Identify the most negative aspects of your tool)
- Não tem interface gráfica  
