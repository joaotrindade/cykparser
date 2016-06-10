**T�TULO DO PROJECTO: CykParser

**GRUPO: TURMA 6 - GRUPO 3



NOME1: Jo�o Manuel Ferreira Trindade, NR1: 201109221, AUTO1: 18, CONTRIBUI��O: 25%)

NOME2: Paulo Bordalo Marcos, NR2: 201100759, AUTO2: 18, CONTRIBUI��O: 25%)

NOME3: Pedro Miguel Sousa Santos, NR3: 201102999, AUTO3: 18, CONTRIBUI��O: 25%)

NOME4: Rui Pedro Menezes da Rosa Neves, NR4: 201109350, AUTO4: 18, CONTRIBUI��O: 25%)



** SUM�RIO:

O nosso projecto � sobre o algoritmo Cyk. O algoritmo Cyk verifica para uma dada gram�tica na forma 
Chomsky (nesta forma cada produ��o apenas pode ser dois s�mbolos n�o terminais ou um s�mbolo n�o terminal) 
se uma dada frase se verifica naquela gram�tica.
Dividimos isto em duas vertentes:

- A primeira � onde o utilizador insere ele pr�prio a gram�tica atrav�s da linha de comandos e fornece a frase para testar.
- A segunda � onde o utilizador escolhe um ficheiro para carregar a gram�tica e fornece uma frase para testar para a gram�tica carregada.

**VERIFICA��ES SINT�TICAS:

O nosso programa apenas aceita gram�ticas na forma Chomsky, logo tivemos que limitar os inputs para os seguintes formatos:
VARIAVEL "->" NAO TERMINAL NAO TERMINAL
VARIAVEL "->" TERMINAL
TS "->" TERMINAL

em que TS � um terminal (Exemplo: "Det -> a").

Logo, se for inserido um NAO TERMINAL a seguir a um TS a excep��o ser� apanhada e ser� dito que a produ��o est� incorrecta devolvendo o utilizador ao menu inicial para ele inserir uma nova gram�tica.
O mesmo acontece com a VARIAVEL e o TS se se inserir mais que duas produ��es NAO TERMINAIS para o caso da VARIAVEL e duas TERMINAIS para a TS (ultrapassando assim o limite da forma normal de Chomsky).

**AN�LISE SEM�NTICA:

Para a an�lise sem�ntica temos a nossa fun��o cyk que recebe uma frase para testar se se verifica na gram�tica inserida ou carregada. Uma frase � aceite se na tabela que construimos, o elemento do topo tiver pelo menos uma produ��o.
Por exemplo, para a gram�tica:
S->A B
A->a
B->b
			1�itera��o
				 _ _ _ _                       _ _ _ _
				|       |                     |       |
				|_ _ _ _|_ _ _ _              |_ _ _ _|_ _ _ _
				|       |       |     -->     |   A   |   B   |
				|_ _ _ _|_ _ _ _|             |_ _ _ _|_ _ _ _|
				|   a   |   b   |             |   a   |   b   |
				
				o algoritmo ir� verificar se existem regras para os n�o terminais a e b e vai adicionar essas regras � tabela. Neste caso ir� encontrar A->a e B->b adicionando A e B � tabela.
				
			2�itera��o
				 _ _ _ _                       _ _ _ _
				|       |                     |   S   |
				|_ _ _ _|_ _ _ _              |_ _ _ _|_ _ _ _
				|   A   |   B   |     -->     |   A   |   B   |
				|_ _ _ _|_ _ _ _|             |_ _ _ _|_ _ _ _|
				|   a   |   b   |             |   a   |   b   |
				
				depois o algoritmo ir� verificar linha a linha, nomeadamente os campos abaixo na sua coluna com os campos na sua diagonal inferior direita. Ou seja, se estiver na linha 2 coluna 1, ir� verificar a linha 1 coluna 1 com
				a linha 1 coluna 2. Se houvesse uma terceira linha iria verificar a linha 2 coluna 1 (imediatamente abaixo) com a linha 1 coluna 3 (diagonal inferior direita, depois subindo em escada) e de seguida a linha 1 coluna 1 com 
				a linha 2 coluna 2 fazendo um "X".
				
				
**REPRESENTA��O INTERM�DIA (IRs):

Para a representa��o interm�dia fizemos uma �rvore abstracta da nossa gram�tica onde apenas temos um n�vel na �rvore (ASSIGNMNT) Ela � apresentada no final do algoritmo.
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
				
**GERA��O DE C�DIGO: (Describe how the code generation of your tool works and identify the possible problems your tool has regarding code generation.)

Para a gera��o de c�digo guardamos os nossos s�mbolos em dois ArrayList, um para os s�mbolos terminais (terminals) e outro para os s�mbolos n�o terminais (variables) o que nos foi bastante �til para a execu��o do algoritmo.

**OVERVIEW: (refer the approach used in your tool, the main algorithms, etc.)

Usamos o JJTREE e o JAVACC para fazer o "parse" da gram�tica e anotar a mesma e usamos o CYK Algorithm para verificar se uma dada frase se insere na gram�tica.

**TESTES: 

Temos 5 .txt's com exemplos de gram�ticas com um bom n�mero de produ��es em que testamos frases que se verificam nas mesmas. Com os txt's apenas ser� necess�rio inserir a frase que se quer testar, visto que esta poder� ser diferente.
Existe tamb�m a possibilidade de criarmos n�s a gram�tica com base no que aprendemos de CFG's ( tendo estas que ser convertidas para CNF (Chomsky Normal Form)).

**DISTRIBUI��O DE TAREFAS: 

An�lise Sint�tica e Sem�ntica trabalhada em conjunto com a percep��o e desenvolvimento / adapta��o do algoritmo.
Tratamento de excep��es decidido tamb�m em conjunto.

O trabalho foi efectuado com todos os membros presentes, visto que nos juntavamos na FEUP para o fazer.


**PROS: (Identify the most positive aspects of your tool)
- Algoritmo r�pido e funcional
- Boa apresenta��o da AST
- Boa ajuda ao utilizador (tratamento de erros)
- Dois modos de teste
- Continua��o do programa em caso de erros

**CONS: (Identify the most negative aspects of your tool)
- N�o tem interface gr�fica