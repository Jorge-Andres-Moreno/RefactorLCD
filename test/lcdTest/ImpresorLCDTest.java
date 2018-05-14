package lcdTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.ImpresorLCD;

class ImpresorLCDTest {

	private ImpresorLCD impresorLCD = new ImpresorLCD();

	@Test
	void testRefactorSmallSize() {

		assertEquals(impresorLCD.refactorLCD("1,12345678901"),
				"   -   -       -   -   -   -   -   -     \n" + "|   |   | | | |   |     | | | | | | |   |\n"
						+ "   -   -   -   -   -       -   -         \n" + "| |     |   |   | | |   | | |   | | |   |\n"
						+ "   -   -       -   -       -   -   -     \n");
	}

	@Test
	void testRefactorMediumSize() {

		assertEquals(impresorLCD.refactorLCD("5,12345678901"),
				"   -----   -----           -----   -----   -----   -----   -----   -----         \n"
						+ "|       |       | |     | |       |             | |     | |     | |     |       |\n"
						+ "|       |       | |     | |       |             | |     | |     | |     |       |\n"
						+ "|       |       | |     | |       |             | |     | |     | |     |       |\n"
						+ "|       |       | |     | |       |             | |     | |     | |     |       |\n"
						+ "|       |       | |     | |       |             | |     | |     | |     |       |\n"
						+ "   -----   -----   -----   -----   -----           -----   -----                 \n"
						+ "| |             |       |       | |     |       | |     |       | |     |       |\n"
						+ "| |             |       |       | |     |       | |     |       | |     |       |\n"
						+ "| |             |       |       | |     |       | |     |       | |     |       |\n"
						+ "| |             |       |       | |     |       | |     |       | |     |       |\n"
						+ "| |             |       |       | |     |       | |     |       | |     |       |\n"
						+ "   -----   -----           -----   -----           -----   -----   -----         \n");
	}

	@Test
	void testRefactorBigSize() {

		assertEquals(impresorLCD.refactorLCD("10,12345678901"),
				"   ----------   ----------                ----------   ----------   ----------   ----------   ----------   ----------              \n"
						+ "|            |            | |          | |            |                       | |          | |          | |          |            |\n"
						+ "|            |            | |          | |            |                       | |          | |          | |          |            |\n"
						+ "|            |            | |          | |            |                       | |          | |          | |          |            |\n"
						+ "|            |            | |          | |            |                       | |          | |          | |          |            |\n"
						+ "|            |            | |          | |            |                       | |          | |          | |          |            |\n"
						+ "|            |            | |          | |            |                       | |          | |          | |          |            |\n"
						+ "|            |            | |          | |            |                       | |          | |          | |          |            |\n"
						+ "|            |            | |          | |            |                       | |          | |          | |          |            |\n"
						+ "|            |            | |          | |            |                       | |          | |          | |          |            |\n"
						+ "|            |            | |          | |            |                       | |          | |          | |          |            |\n"
						+ "   ----------   ----------   ----------   ----------   ----------                ----------   ----------                           \n"
						+ "| |                       |            |            | |          |            | |          |            | |          |            |\n"
						+ "| |                       |            |            | |          |            | |          |            | |          |            |\n"
						+ "| |                       |            |            | |          |            | |          |            | |          |            |\n"
						+ "| |                       |            |            | |          |            | |          |            | |          |            |\n"
						+ "| |                       |            |            | |          |            | |          |            | |          |            |\n"
						+ "| |                       |            |            | |          |            | |          |            | |          |            |\n"
						+ "| |                       |            |            | |          |            | |          |            | |          |            |\n"
						+ "| |                       |            |            | |          |            | |          |            | |          |            |\n"
						+ "| |                       |            |            | |          |            | |          |            | |          |            |\n"
						+ "| |                       |            |            | |          |            | |          |            | |          |            |\n"
						+ "   ----------   ----------                ----------   ----------                ----------   ----------   ----------              \n");
	}

	@Test
	void doesntContainCaracterSpecial() {

		try {
			impresorLCD.refactorLCD("1.12345678901");
			fail("No posee el caracter , ");
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Cadena 1.12345678901 no contiene caracter ,");
		}
	}

	@Test
	void duplicatedCaracterSpecial() {

		try {
			impresorLCD.refactorLCD("1,1,234567,8901");
			fail("Posee un duplicado del caracter,");
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Cadena 1,1,234567,8901 contiene mas caracter ,");
		}
	}
	
	@Test
	void ilegalParametersRequired() {

		try {
			impresorLCD.refactorLCD(",");
			fail("No contiene los parametros requeridos");
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Cadena , no contiene los parametros requeridos");
		}
	}

	@Test
	void ilegalSizeTop() {

		try {
			impresorLCD.refactorLCD("11,12345678901");
			fail("El tamaño del formato es demasiado grande");
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "El parametro size [11] debe estar entre 1 y 10");
		}
	}
	

	@Test
	void ilegalSizeBottom() {

		try {
			impresorLCD.refactorLCD("0,12345678901");
			fail("El tamaño del formato es demasiado pequeño");
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "El parametro size [0] debe estar entre 1 y 10");
		}
	}
	

	@Test
	void ilegalSize() {

		try {
			impresorLCD.refactorLCD("+,12345678901");
			fail("El formato contiene un tamaño incorrecto");
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Parametro Size [+] no es un numero");
		}
	}

	@Test
	void ilegalCaracter() {

		try {
			impresorLCD.refactorLCD("10,123b45678901");
			fail("Existe un caracter invalido en el formato");
		} catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Caracter b no es un digito");
		}
	}


}
