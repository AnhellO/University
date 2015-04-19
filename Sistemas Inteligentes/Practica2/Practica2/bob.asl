// Agent bob in project Practica2.mas2j
/*

Autor: Angel Santiago Jaime Zavala
Pr�ctica 2. Sistemas Inteligentes
http://github.com/AnhellO

1.- Para est� pr�ctica se utilizo la misma base de conocimientos de relaciones
familiares que se ven�a utilizando en las clases pr�cticas, sin alterar ningun
elemento de la BC salvo el hecho yo(X). para cada agente
2.- Se realiz� un intercambio de mensajes con 5 consultas a la BC entre ambos
agentes
3.- Para el ejemplo propuesto en est� pr�ctica, a pesar de que los agentes como
tal, son familiares de acuerdo a la BC, se da por hecho que no se conocen, esto
solo para cuestiones pr�cticas
4.- Para los estados de �nimo solamente agregu� un nuevo hecho a la BC:
estado_de_animo(X)., que se modifica manualmente
*/

/* Initial beliefs and rules */

/* Estados de animo: 
	alegre -> :D
	triste -> :(
	enojado -> >:|
	sorprendido -> :O
	indiferente -> :|
*/

estado_de_animo(enojado).

/* The main program */

yo(bob).

/* Relaciones paternales */

es_padre_de(fred,erik).
es_padre_de(fred,tom).
es_padre_de(erik,eve).
es_padre_de(bob,liz).
es_padre_de(john,fred).
es_padre_de(john,karl).

/* Relaciones maternales */
es_madre_de(liz,erik).
es_madre_de(liz,tom).
es_madre_de(sally,liz).
es_madre_de(ann,fred).
es_madre_de(ann,karl).
es_madre_de(july,eve).

/* Relaciones de hermanos
Nota: Segun el diccionario consideramos hermanos aquellos que comparten un padre o una madre.
*/

//Primero suponemos que comparten solo padre y no son la misma persona
es_hermano_de(X,Y) :-
	es_padre_de(Z,X)
	& es_padre_de(Z,Y)
	& es_madre_de(W,X)
	& not es_madre_de(W,Y)
	& not X=Y.


//Segundo suponemos que comparten solo madre y no son la misma persona
es_hermano_de(X,Y) :-
	es_madre_de(Z,X)
	& es_madre_de(Z,Y)
	& es_padre_de(W,X)
	& not es_padre_de(W,Y)
	& not X=Y.


//Tercero suponemos que comparten padre y madre y no son la misma persona

es_hermano_de(X,Y) :- 
	es_padre_de(Z,X)
	& es_padre_de(Z,Y)
	& es_madre_de(W,X)
	& es_madre_de(W,Y)
	& not X=Y.

/*
NOTA: Fijaros que el hecho de que tengan padre o madre distinta incluye las situaciones 
de padres divorciados o de horfandad 

Relaciones de parentesco 
Modificamos las anteriores para diferenciar explicitamente entre antepasados y descendientes. 
Comparar las soluciones con la version anterior.
*/

// Primero reglas para "X es_antepasado_de Y"
es_antepasado_de(X,Y) :- 
	es_padre_de(X,Y).

es_antepasado_de(X,Y) :- 
	es_madre_de(X,Y).

es_antepasado_de(X,Y) :- 
	es_padre_de(X,Z)
	& es_antepasado_de(Z,Y).
	
es_antepasado_de(X,Y) :- 
	es_madre_de(X,Z)
	& es_antepasado_de(Z,Y).

es_antepasadoIndirecto_de(X,Y) :- 
	es_hermano_de(X,Z)
	& es_antepasado_de(Z,Y).
	
// Luego reglas para "X es_descendiente_de Y"
es_descendiente_de(X,Y) :- 
	es_padre_de(Y,X).

es_descendiente_de(X,Y) :- 
	es_madre_de(Y,X).

es_descendiente_de(X,Y) :- 
	es_padre_de(Y,Z)
	& es_descendiente_de(X,Z).

es_descendiente_de(X,Y) :- 
	es_madre_de(Y,Z)
	& es_descendiente_de(X,Z).

// Por �ltimo las reglas para "X es_pariente_de Y"
es_pariente_de(X,Y) :-
	es_antepasado_de(X,Y)
	& not X=Y.

es_pariente_de(X,Y) :-
	es_antepasadoIndirecto_de(X,Y)
	& not X=Y.

es_pariente_de(X,Y) :-
	es_descendiente_de(X,Y)
	& not X=Y.

/* Initial goals */

!start.

+!start : estado_de_animo(Estado)
			<- if(Estado == alegre) {
					.print("Hola Tom, como est�s amigo??!! :D");
					.send(tom,tell,hello);
			} if(Estado == triste) {
					.print("Hola, como va todo?? :(");
					.send(tom,tell,hello);
			} if(Estado == enojado) {
					.print("Oye t�! ven aqu�! >:|");
					.send(tom,tell,hello);
			} if(Estado == sorprendido) {
					.print("Que milagro amigo!, que tal? :O");
					.send(tom,tell,hello);
			} if(Estado == indiferente) {
					.print("Hey, que pasa? :|");
					.send(tom,tell,hello);
			}.

/* Plans */

+preguntar_por_familia_tom[source(T)] : estado_de_animo(Estado)
								<- if(Estado == alegre) {
									.print("Bien amigo, que tal tu familia?? :D");
									.send(T,tell,preguntar_por_familia_bob);
								} if(Estado == triste) {
									.print("Hey, que tal la familia?? :(");
									.send(T,tell,preguntar_por_familia_bob);
								} if(Estado == enojado) {
									.print("Y la familia? >:|");
									.send(T,tell,preguntar_por_familia_bob);
								} if(Estado == sorprendido) {
									.print("Oye, y tu familia amigo??? :O");
									.send(T,tell,preguntar_por_familia_bob);
								} if(Estado == indiferente) {
									.print("que dicen los dem�s? :|");
									.send(T,tell,preguntar_por_familia_bob);
								}.
										
+nombre_hija_tom[source(T)] : estado_de_animo(Estado)
							<- if(Estado == alegre) {
									.print("Muy bien, gracias amigo!!, que tal tu hija??? :D");
									.send(T,tell,nombre_hija_bob);
								} if(Estado == triste) {
									.print("Un poco apurados, pero bien amigo. Tu hija que tal? :(");
									.send(T,tell,nombre_hija_bob);
								} if(Estado == enojado) {
									.print("Ah� deben de estar como siempre, tu hija??? >:|");
									.send(T,tell,nombre_hija_bob);
								} if(Estado == sorprendido) {
									.print("Mi familia??, milagro que me preguntas de ellos amigo!!, bien gracias y tu hija? :O");
									.send(T,tell,nombre_hija_bob);
								} if(Estado == indiferente) {
									.print("Bien, tu hija??? :|");
									.send(T,tell,nombre_hija_bob);
								}.

+nombre_hermanos_tom[source(T)] : estado_de_animo(Estado) & yo(bob) & es_padre_de(bob,Liz) & Liz == liz
							<- if(.empty(Liz)) {
								if(Estado == alegre) {
									.print("No tengo hijas amigo!, pero que tal tus hermanos, dime??? :D");
									.send(T,tell,nombre_esposa_bob);
								} if(Estado == triste) {
									.print("Sin hijas amigo, y tus hermanos?? :(");
									.send(T,tell,nombre_esposa_bob);
								} if(Estado == enojado) {
									.print("Todav�a se te olvida que no tengo hijas???, mejor dime de tus hermanos >:|");
									.send(T,tell,nombre_esposa_bob);
								} if(Estado == sorprendido) {
									.print("Me sorprende que me preguntes por hijas amigo!!!, no tengo, y tus hermanos? :O");
									.send(T,tell,nombre_esposa_bob);
								} if(Estado == indiferente) {
									.print("No tengo. Tus hermanos? :|");
									.send(T,tell,nombre_esposa_bob);
								}
							} else {
								if(Estado == alegre) {
									.print(Liz, " est� muy bien amigo, gracias, pero que tal tus hermanos, dime??? :D");
									.send(T,tell,nombre_esposa_bob);
								} if(Estado == triste) {
									.print(Liz, " bien, y tus hermanos?? :(");
									.send(T,tell,nombre_esposa_bob);
								} if(Estado == enojado) {
									.print(Liz, " igual de inmadura, pero bueno, mejor dime de tus hermanos >:|");
									.send(T,tell,nombre_esposa_bob);
								} if(Estado == sorprendido) {
									.print(Liz, ", Me sorprende que me preguntes de ella amigo!!!, pero bien, gracias, y tus hermanos? :O");
									.send(T,tell,nombre_esposa_bob);
								} if(Estado == indiferente) {
									.print(Liz, " bien. Tus hermanos? :|");
									.send(T,tell,nombre_esposa_bob);
								}
							}.
							
+preguntar_esposa_tom[source(T)] : es_padre_de(bob,Y) & es_madre_de(Z,Y)
					  <- if(.empty(Z)) {
					  	.print("No tengo esposa ",T);
						.send(T,tell,contestar_no_esposa_tom);
					  } else {
					  	.print(Z, " est� muy bien, gracias ",T);
						.send(T,tell,contestar_no_esposa_tom);
					  }.
					  
+preguntar_padre_tom[source(T)] : estado_de_animo(Estado)
								<- if(Estado == alegre) {
									.print("Amigo, no lo sab�a, disculpa!!!, pero que tal tu padre amigo??? :D");
									.send(T,tell,adios_bob);
								} if(Estado == triste) {
									.print("Disculpa, no sab�a de eso. Tu padre??? :(");
									.send(T,tell,adios_bob);
								} if(Estado == enojado) {
									.print("Joder, no lo sab�a!!, y tu padre??? >:|");
									.send(T,tell,adios_bob);
								} if(Estado == sorprendido) {
									.print("Juro que no lo sab�a!!!, pero tu padre que tal??? :O");
									.send(T,tell,adios_bob);
								} if(Estado == indiferente) {
									.print("Bueno, y tu padre? :|");
									.send(T,tell,adios_bob);
								}.
								
+adios_tom[source(T)] : estado_de_animo(Estado)
							<- if(Estado == alegre) {
									.print("Nos vemos luego amigo, que todo vaya muy bien!! :D");
								} if(Estado == triste) {
									.print("Ciao :(");
								} if(Estado == enojado) {
									.print("Vale, te puedes ir! >:|");
								} if(Estado == sorprendido) {
									.print("O amigo, pero porqu�??!, bueno, que te vaya bien! :O");
								} if(Estado == indiferente) {
									.print("Sale, luego nos vemos :|");
								}.
