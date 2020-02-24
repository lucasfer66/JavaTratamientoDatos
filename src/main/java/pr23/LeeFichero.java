//AUTOR: LUCAS FERNANDEZ CEDRON

package pr23;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeeFichero {

	public static float salarioMedio() {

		// DECLARAMOS VARIABLE DEL SALARIO TOTAL, NUMERO DE EMPLEADOS Y UNA AUXILIAR
		int st = 0;
		int aux = 0;
		int n = 0;

		// RECORREMOS LAS LINEAS DEL FICHERO CON EL CODIGO FACILITADO
		try {
			BufferedReader f = new BufferedReader(new FileReader("src/main/java/pr23/datos.txt"));
			String l = f.readLine();

			while (l != null) {
				// PROCESAMOS LA LINEA SEPARANDO LA LINEA EN SUS COMPONENTES
				String[] partes = l.split("\\|");

				// COMPROBAMOS QUE LA LINEA SEA CORRECTA
				if (lineaCorrecta(partes)) {
					aux = 0;
					try {

						// TOMAMOS EL SALARIO Y LO INTRODUCIMOS EN LA VARIABLES AUXILIAR
						aux = Integer.parseInt(partes[3]);

						// AUMENTAMOS EL NUMERO DE EMPLEADOS EN 1
						n++;
					}

					catch (NumberFormatException ex) {
						System.out.println("ERROR EN EL FORMATO NUMERICO");
						ex.printStackTrace();
					}

					// AÑADIMOS EL VALOR DE LA VARIABLE AUXILIAR A LOS SALARIOS TOTALES
					st = st + aux;
				}

				l = f.readLine();
			}

			// CERRAMOS EL LECTOR DE LINEAS
			f.close();
		}

		catch (IOException ex) {
			System.out.println("EXCEPCION DE APLICACION");
			ex.printStackTrace();
		}

		// SALRIO MEDIO = SALRIO TOTAL / NUMERO EMPLEADOS
		float sm = st / n;

		return sm;
	}

	// METODO AUXILIAR PARA COMPROBAR SI UNA LINEA ES CORRECTA
	private static boolean lineaCorrecta(String[] clinea) {

		// COMPROBAMOS SI LA LONGITUD DEL VECTOR DE COMPONENTES ES 5
		if (clinea.length != 5) {
			return false;
		}

		// COMPROBAMOS SI EXISTE ALGUNA COMPONENTE CON VALOR NULO
		for (int i = 0; i < 5; i++) {
			if (clinea[i].trim().contentEquals("")) {
				return false;
			}
		}
		return true;
	}

	public static List<Empleado> creaEmpleados() {

		// DECLARAMOS Y CONSTRUIMOS LA LISTA AUXILIAR Y LA VARIABLE EMPLEADO
		List<Empleado> laux = new ArrayList<Empleado>();
		Empleado e;

		// RECORREMOS EL FICHERO CON EL CODIGO FACILITADO
		try {
			BufferedReader f = new BufferedReader(new FileReader("src/main/java/pr23/datos.txt"));
			String l = f.readLine();

			while (l != null) {

				// SEPARAMOS LA LINEA EN PARTES
				String[] partes = l.split("\\|");

				// COMPROBAMOS QUE LA LINEA ES CORRECTA PARA LEERLA
				if (lineaCorrecta(partes)) {

					// CONTRUIMOS EL EMPLEADO CON EL NOMBRE Y APELLIDOS
					e = new Empleado(partes[0], partes[1]);

					// ANADIMOS EL EMPLEADO A LA LISTA AUXILIAR
					laux.add(e);
				}

				l = f.readLine();
			}
			f.close();
		} catch (IOException ex) {
			System.out.println("EXCEPCION DE APLICACION");
			ex.printStackTrace();
		}

		return laux;
	}
}
