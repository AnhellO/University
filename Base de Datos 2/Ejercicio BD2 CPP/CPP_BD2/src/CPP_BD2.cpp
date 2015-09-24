//============================================================================
// Name        : CPP_BD2.cpp
// Author      : Angel Santiago Jaime Zavala
// Version     : 1.0.0
// Copyright   : GPL
// Description : Databases 2 Exercise. Simulate the indexing process of a database
//============================================================================

#include <iostream>
#include <cstdio>
#include <cstring>
#include <string>
#include <algorithm>
#include <cmath>
#include <vector>
#include <set>
#include <map>
#include <cstdlib>
#include <cctype>
#include <bitset>
#include <sstream>
#include <stack>
#include <queue>
#include <deque>
#include <list>
#include <iomanip>
#include <utility>
#include <fstream>
#include <functional>
using namespace std;

typedef pair<int, int> ii;
typedef pair<int, ii> iii;
typedef vector<int> vi;
typedef vector<vi> vvi;
typedef vector<ii> vii;
typedef vector<iii> viii;
typedef vector<vii> vvii;
typedef map<int, int> mii;
typedef map<char, int> mci;
typedef map<string, int> msi;
typedef map<int, ii> miii;

string nombre, cYn, col, cp, lugar, tel, mail, fecha;
fstream archivo;

vector<string> split(string s, string regex)
{
	vector<string> sections;
	int pos = s.find_first_of(regex);
	string subS;
	while(pos != string::npos)
	{
		subS = s.substr(0, pos);
		s.erase(0, pos + 1);
		sections.push_back(subS);
		pos = s.find_first_of(regex);
	}
	sections.push_back(s);
	return sections;
}

void alta() {
	archivo.open("archivo.txt", ios::out | ios::app);
	cout << "Introduce tu nombre: ";
	while(getline(cin, nombre) && nombre.empty()) {
		cout << "El campo de nombre no puede estar vac�o!!!. Intente de nuevo: ";
	}
	archivo << nombre << '|';
	cout << "Calle y n�mero: ";
	getline(cin, cYn);
	archivo << cYn << '|';
	cout << "Colonia: ";
	getline(cin, col);
	archivo << col << '|';
	cout << "C�digo Postal: ";
	getline(cin, cp);
	archivo << cp << '|';
	cout << "Lugar: ";
	getline(cin, lugar);
	archivo << lugar << '|';
	cout << "Tel�fono: ";
	getline(cin, tel);
	archivo << tel << '|';
	cout << "E-mail: ";
	getline(cin, mail);
	archivo << mail << '|';
	cout << "Fecha de Nacimiento: ";
	getline(cin, fecha);
	archivo << fecha << '\n';
	archivo.close();
}

void baja() {
	cout << "Ingrese el nombre de la persona que desea borrar: ";
	string s;
	getline(cin, s);
	archivo.open("archivo.txt", ios::in);
	string linea;
	bool flag = false;
	vector<vector<string> > registros;
	while(getline(archivo, linea)) {
		vector<string> temp = split(linea, "|");
		if(temp[0] == s) {
			flag = true;
		}
		registros.push_back(temp);
	}
	archivo.close();
	if(!flag) {
		cout << "Registro NO encontrado!!!\n";
		return;
	}
	vector<string> nuevosRegistros;
	for(int i = 0 ; i < registros.size() ; i++) {
		if(registros[i][0] == s) {
			continue;
		}
		string temp;
		for(int j = 0 ; j < registros[i].size() - 1 ; j++) {
			temp.append(registros[i][j] + "|");
		}
		temp.append(registros[i][registros[i].size() - 1] + "\n");
		nuevosRegistros.push_back(temp);
	}
	archivo.open("archivo.txt", ios::out);
	for(int i = 0 ; i < nuevosRegistros.size() ; i++) {
		archivo << nuevosRegistros[i];
	}
	archivo.close();
	cout << "Registro borrado exitosamente!!!\n";
}

void modificacion() {
	cout << "Ingrese el nombre de la persona que desea modificar: ";
	string s;
	getline(cin, s);
	archivo.open("archivo.txt", ios::in);
	string linea;
	bool flag = false;
	vector<vector<string> > registros;
	while(getline(archivo, linea)) {
		vector<string> temp = split(linea, "|");
		if(temp[0] == s) {
			flag = true;
			cout << "Registro Encontrado!!!\nA continueaci�n modifique los campos que desea cambiar: \n";
			cout << "Introduce el nuevo nombre: ";
			while(getline(cin, nombre) && nombre.empty()) {
				cout << "El campo de nombre no puede estar vac�o!!!. Intente de nuevo: ";
			}
			cout << "Nueva Calle y n�mero: ";
			getline(cin, cYn);
			cout << "Nueva Colonia: ";
			getline(cin, col);
			cout << "Nuevo C�digo Postal: ";
			getline(cin, cp);
			cout << "Nuevo Lugar: ";
			getline(cin, lugar);
			cout << "Nuevo Tel�fono: ";
			getline(cin, tel);
			cout << "Nuevo E-mail: ";
			getline(cin, mail);
			cout << "Nueva Fecha de Nacimiento: ";
			getline(cin, fecha);
			for(int i = 0 ; i < temp.size() ; i++) {
				if(!i) {
					temp[0] = nombre;
				} else if(i == 1) {
					temp[1] = cYn;
				} else if(i == 2) {
					temp[2] = col;
				} else if(i == 3) {
					temp[3] = cp;
				} else if(i == 4) {
					temp[4] = lugar;
				} else if(i == 5) {
					temp[5] = tel;
				} else if(i == 6) {
					temp[6] = mail;
				} else {
					temp[7] = fecha;
				}
			}
		}
		registros.push_back(temp);
	}
	archivo.close();
	if(!flag) {
		cout << "Registro NO encontrado!!!\n";
		return;
	}
	archivo.open("archivo.txt", ios::out);
	for(int i = 0 ; i < registros.size() ; i++) {
		string temp;
		for(int j = 0 ; j < registros[i].size() - 1 ; j++) {
			temp.append(registros[i][j] + "|");
		}
		temp.append(registros[i][registros[i].size() - 1] + "\n");
		archivo << temp;
	}
	archivo.close();
	cout << "Registro modificado exitosamente!!!\n";
}

void consulta() {
	cout << "Ingrese el nombre de la persona que desea buscar: ";
	string s;
	getline(cin, s);
	archivo.open("archivo.txt", ios::in);
	string linea;
	while(getline(archivo, linea)) {
		vector<string> temp = split(linea, "|");
		if(temp[0] == s) {
			cout << "Registro Encontrado!!!\n";
			for(int i = 0 ; i < temp.size() ; i++) {
				if(!i) {
					cout << "Nombre: " << temp[0] << '\n';
				} else if(i == 1) {
					cout << "Calle y N�mero: " << temp[1] << '\n';
				} else if(i == 2) {
					cout << "Colonia: " << temp[2] << '\n';
				} else if(i == 3) {
					cout << "C�digo Postal: " << temp[3] << '\n';
				} else if(i == 4) {
					cout << "Lugar: " << temp[4] << '\n';
				} else if(i == 5) {
					cout << "Tel�fono: " << temp[5] << '\n';
				} else if(i == 6) {
					cout << "E-mail: " << temp[6] << '\n';
				} else {
					cout << "Fecha de Nacimiento: " << temp[7] << '\n';
				}
			}
			archivo.close();
			return;
		}
	}
	archivo.close();
	cout << "Registro NO encontrado!!!\n";
}

int main() {
	string opc;
	cout << "\t\tA G E N D A		P E R S O N A L I Z A D A\n";
	cout << "\t\t----------------------------------------------\n\n";
	while(true) {
		cout << "Selecciona una opci�n: ";
		getline(cin, opc);
		if(opc == "A") {
			alta();
		} else if(opc == "B") {
			baja();
		} else if(opc == "M") {
			modificacion();
		} else if(opc == "C") {
			consulta();
		} else if(opc == "S") {
			return 0;
		} else {
			cout << "Opci�n incorrecta. ";
		}
	}
}
