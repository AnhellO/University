// Agent tom in project Practica2.mas2j
/*

Autor: Angel Santiago Jaime Zavala
Práctica 2. Sistemas Inteligentes
http://github.com/AnhellO

1.- Para está práctica se utilizo la misma base de conocimientos de relaciones
familiares que se venía utilizando en las clases prácticas, sin alterar ningun
elemento de la BC salvo el hecho yo(X). para cada agente
2.- Se realizó un intercambio de mensajes con 5 consultas a la BC entre ambos
agentes
3.- Para el ejemplo propuesto en está práctica, a pesar de que los agentes como
tal, son familiares de acuerdo a la BC, se da por hecho que no se conocen, esto
solo para cuestiones prácticas
4.- Para los estados de ánimo solamente agregué un nuevo hecho a la BC:
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

estado_de_animo(triste).

/* The main program */

yo(tom).

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

// Por œltimo las reglas para "X es_pariente_de Y"
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


/* Plans */

+hello[source(B)] : estado_de_animo(Estado)
			<- if(Estado == alegre) {
					.print("Muy bien Bob, tu como estás amigo??!! :D");
					.send(B,tell,preguntar_por_familia_tom);
			} if(Estado == triste) {
					.print("Hola, como va todo?? :(");
					.send(B,tell,preguntar_por_familia_tom);
			} if(Estado == enojado) {
					.print("Que pasa amigo!?, no me grites, tu que tal? >:|");
					.send(B,tell,preguntar_por_familia_tom);
			} if(Estado == sorprendido) {
					.print("Que milagro tú Bob!, que tal? :O");
					.send(B,tell,preguntar_por_familia_tom);
			} if(Estado == indiferente) {
					.print("Hey, que tal? :|");
					.send(B,tell,preguntar_por_familia_tom);
			}.

+preguntar_por_familia_bob[source(B)] : estado_de_animo(Estado)
								<- if(Estado == alegre) {
									.print("Muy bien amigo, la tuya que tal??? :D");
									.send(B,tell,nombre_hija_tom);
								} if(Estado == triste) {
									.print("Un poco apurados, pero bien, tu que tal? :(");
									.send(B,tell,nombre_hija_tom);
								} if(Estado == enojado) {
									.print("Igual que siempre, y la tuya? >:|");
									.send(B,tell,nombre_hija_tom);
								} if(Estado == sorprendido) {
									.print("Muy bien por cierto!!, y la tuya amigo?? :O");
									.send(B,tell,nombre_hija_tom);
								} if(Estado == indiferente) {
									.print("supongo que bien, pero la tuya que tal?? :|");
									.send(B,tell,nombre_hija_tom);
								}.
										
+nombre_hija_bob[source(B)] <- .findall(Hijo,es_descendiente_de(Hijo,tom),L);
							    if(.empty(L)) {
									.print("No tengo hijos. Tu tienes una hija cierto??, como se llama?");
									.send(B,tell,nombre_hermanos_tom);
								} else {
									.print("Si, mis hijos se llaman ",L);
									.send(B,tell,nombre_hermanos_tom);
								}.
								
+nombre_esposa_bob[source(B)] <- .findall(X,es_hermano_de(X,tom),L);
								  if(.empty(L)) {
								  	.print("No tengo hermanos. Como está tu esposa??");
									.send(B,tell,preguntar_esposa_tom);
								  } else {
								  	.print("Si, mis hermanos son: ",L, ". Por cierto, como está tu esposa??");
									.send(B,tell,preguntar_esposa_tom);
								  }.
								  
+contestar_no_esposa_tom[source(B)] : estado_de_animo(Estado) 
								<- if(es_padre_de(tom,Y) & es_madre_de(X,Y) & not X == Y) {
									if(Estado == alegre) {
										.print(X, " está muy bien gracias!!, te manda muchos saludos! :D");
										.send(B,tell,preguntar_padre_tom);
									} if(Estado == triste) {
										.print(X, " ella está bien :(");
										.send(B,tell,preguntar_padre_tom);
									} if(Estado == enojado) {
										.print(X, " ahí está >:|");
										.send(B,tell,preguntar_padre_tom);
									} if(Estado == sorprendido) {
										.print(X, ", que milagro que te acuerdas de ella amigo :O");
										.send(B,tell,preguntar_padre_tom);
									} if(Estado == indiferente) {
										.print(X, " le ha ido bien :|");
										.send(B,tell,preguntar_padre_tom);
									}
								} else {
									if(Estado == alegre) {
										.print("Muchas gracias por preguntar amigo, pero no tengo esposa :D");
										.send(B,tell,preguntar_padre_tom);
									} if(Estado == triste) {
										.print("Estoy soltero :(");
										.send(B,tell,preguntar_padre_tom);
									} if(Estado == enojado) {
										.print("Qué no sabías que no tengo esposa???!! >:|");
										.send(B,tell,preguntar_padre_tom);
									} if(Estado == sorprendido) {
										.print("Me sorprende que no supieras que estoy soltero!! :O");
										.send(B,tell,preguntar_padre_tom);
									} if(Estado == indiferente) {
										.print("No tengo esposa :|");
										.send(B,tell,preguntar_padre_tom);
									}
								}.
								
+adios_bob[source(B)] : estado_de_animo(Estado) & es_padre_de(X,tom) & not X == tom
								<- if(Estado == alegre) {
									.print(X, " está muy bien, gracias, te manda muchos saludos amigo!!. Bueno amigo, me tengo que ir, nos vemos luego!! :D");
									.send(B,tell,adios_tom);
								} if(Estado == triste) {
									.print(X, " ha estado un poco mal amigo, pero bueno, me tengo que ir, nos vemos luego :(");
									.send(B,tell,adios_tom);
								} if(Estado == enojado) {
									.print(X, " baaaah, no lo se honestamente, pero bueno, me retiro >:|");
									.send(B,tell,adios_tom);
								} if(Estado == sorprendido) {
									.print(X, " mi padre!!!, ahora recuerdo que tengo que alcanzarlo en la casa, me voy amigo!! :O");
									.send(B,tell,adios_tom);
								} if(Estado == indiferente) {
									.print(X, " por ahí debe de estar amigo. Bueno, me voy, nos vemos luego :|");
									.send(B,tell,adios_tom);
								}.
