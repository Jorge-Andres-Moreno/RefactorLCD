package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import model.ImpresorLCD;

public class Ejecutable {

	/*
	 * Entrada: La entrada contiene varias líneas. Cada línea contiene 2 números
	 * separados por coma. El primer número representa el tamaño de la impresión
	 * (entre 1 y 10, esta variable se llama “size”). El segundo número es el número
	 * a mostrar en la pantalla. Para terminar, se debe digitar 0,0. Esto terminará
	 * la aplicación.
	 * 
	 * Salida: Imprimir los números especificados usando el caracter “-“ para los
	 * caracteres horizontales, y “|” para los verticales. Cada dígito debe ocupar
	 * exactamente size+2 columnas y 2*size + 3 filas.
	 * 
	 * Entre cada impresión debe haber una línea blanca.
	 */

	public static void main(String[] args) throws Exception {

		// Inicializa los componentes que utilizara para la prueba
		ImpresorLCD impresorLCD = new ImpresorLCD();

		// Inicializa los buffers para leer y escribir
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = "";

		// leee hasta que la ultima linea tenga el formato 0,0
		while (!(line = in.readLine()).equals("0,0"))
			out.write(impresorLCD.refactorLCD(line) + "\n");

		// imprime y cierra los buffers
		out.close();
		in.close();
	}

}
