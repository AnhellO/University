/*
	*** Representación del Conocimiento y Web Semántica
	*** SI (Sistemas Inteligentes) 2014/15
	*** Integrantes:
	    *** Gabriela Guadalupe Martínez Puente
	    *** Karen Elizabeth Torres Delgado
	    *** Angel Santiago Jaime Zavala
	*** Profesor: Victor Manuel Darriba Bilbao
*/

/* (1.1) Carga de la librería */

:- use_module(library(semweb/rdf_db)).

/* (1.2) Carga de tuplas RDF */
:- rdf_load('/jamendo-rdf/jamendo.rdf'). 

/* (2.1) Habilitar uso de prefijos en URIs */
:- use_module(library(semweb/rdf_portray)).

/* (2.2) Definir los prefijos de las tuplas del ejemplo de Jamendo*/
:- rdf_register_prefix(dc,'http://purl.org/dc/elements/1.1/').
:- rdf_register_prefix(event,'http://purl.org/NET/c4dm/event.owl#').
:- rdf_register_prefix(foaf,'http://xmlns.com/foaf/0.1/').
:- rdf_register_prefix(mo, 'http://purl.org/ontology/mo/').
:- rdf_register_prefix(tags, 'http://www.holygoat.co.uk/owl/redwood/0.1/tags/').
:- rdf_register_prefix(time, 'http://www.w3.org/2006/time#').
:- rdf_register_prefix(tl, 'http://purl.org/NET/c4dm/timeline.owl#').

/* Librería y prefijos de GeoNames */
:- use_module(library(semweb/rdf_http_plugin)).
:- rdf_register_prefix(gn, 'http://www.geonames.org/ontology#').

/*Probar con Zumbido, Patient 99, Loon Attic, Mamut, Dom The Bear, Spronk, Breeding Sonic Waves, Ekat*/
artista(Artista,ArtistaURI) :-
	rdf(ArtistaURI,foaf:name,literal(type(xsd:string,Artista))).

discos(Artista,ListaDiscos) :-
	artista(Artista,ArtistaURI),
    findall(Disco,rdf(ArtistaURI,foaf:made,Disco),ListaDiscos).

etiquetas(DiscoURI,ListaEtiquetas) :-
    findall(Etiqueta,rdf(DiscoURI,tags:taggedWithTag,Etiqueta),ListaEtiquetas).

etiquetas_discos([],[]).
etiquetas_discos([Car|Cdr],ListaEtiquetas) :-
    etiquetas(Car,EtiquetasCar),
	etiquetas_discos(Cdr,EtiquetasCdr),
	union(EtiquetasCar,EtiquetasCdr,ListaEtiquetas).

etiquetas_artista(Artista,ListaEtiquetas) :-
	discos(Artista,ListaDiscos),
    etiquetas_discos(ListaDiscos,ListaEtiquetas).
	
coeficiente_jaccard(Lista1,Lista2,Valor) :- 
	intersection(Lista1,Lista2,Interseccion),
	length(Interseccion,A),
	union(Lista1,Lista2,Union),
	length(Union,B),
	Valor is float(A) / float(B).

coeficiente_dice(Lista1,Lista2,Valor) :-
	intersection(Lista1,Lista2,Interseccion),
	length(Interseccion,A),
	length(Lista1,S1),
	length(Lista2,S2),
	Valor is float(2.0 * A) / float(S1 + S2).

usar_coeficiente(Coeficiente,Lista1,Lista2,Valor) :-
	(Coeficiente == 'Jaccard' -> coeficiente_jaccard(Lista1,Lista2,Valor); coeficiente_dice(Lista1,Lista2,Valor)).

artista_similar(Artista1,Artista2,Coeficiente,Similitud) :-
	etiquetas_artista(Artista1,ListaEtiquetas1),
	etiquetas_artista(Artista2,ListaEtiquetas2),
	usar_coeficiente(Coeficiente,ListaEtiquetas1,ListaEtiquetas2,Similitud).
	
recomendar(Artista,Coeficiente,Umbral,ListaArtistas) :-
	findall(Art,
	(artista(Art,ArtistaURI),
	Art \== Artista,
	artista_similar(Artista,Art,Coeficiente,Similitud),
	Similitud >= Umbral),
	ListaArtistas).

paisParent(Artista,Pais) :-
	artista(Artista,ArtistaURI),
	rdf(ArtistaURI,foaf:based_near,GeonameURL),
	concat(GeonameURL,'about.rdf',P1),
	rdf_load(P1),
	rdf(GeonameURL,gn:parentCountry,Pais),
	concat(Pais,'about.rdf',P2),
	rdf_load(P2).
	/*rdf(GeonameURL2,gn:name,literal(Pais)).*/
	
pais(Artista,Pais) :-
	artista(Artista,ArtistaURI),
	rdf(ArtistaURI,foaf:based_near,Pais),
	concat(Pais,'about.rdf',P),
	rdf_load(P).
	/*rdf(GeonameURL,gn:name,literal(Pais)).*/
	
pais_artista(Artista,Pais) :-
	paisParent(Artista,Pais);
	pais(Artista,Pais).
	
mismo_pais(Artista1,Artista2) :-
	pais_artista(Artista1,Pais1),
	pais_artista(Artista2,Pais2),
	Pais1 == Pais2.

paises_vecinos(Artista,ListaPaises) :-
	pais_artista(Artista,Pais),
	rdf(Pais,gn:neighbouringFeatures,PaisesVecinos),
	rdf_load(PaisesVecinos),
	findall(PaisVecino,rdf(PaisVecino,gn:neighbour,Pais),ListaPaises).

/*artista_vecino(Artista1,Artista2) :-
	paises_vecinos(Artista1,ListaPaises),
	pais_artista(Artista2,Pais),
	member(Pais,ListaPaises).*/
	
recomendar_pais(Artista,Coeficiente,Umbral,ListaArtistas) :-
	paises_vecinos(Artista,ListaPaises),
	findall(Art,
	(artista(Art,ArtistaURI),
	Art \== Artista,
	artista_similar(Artista,Art,Coeficiente,Similitud),
	Similitud >= Umbral,
	(mismo_pais(Artista,Art); (pais_artista(Art,P), member(P,ListaPaises))))
	,ListaArtistas).
	