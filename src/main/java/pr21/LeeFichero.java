//AUTOR: LUCAS FERNANDEZ CEDRON

package pr21;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

public class LeeFichero {

	public static List<String> devuelvePropiedades() {

		List<String> listaPropiedades = new ArrayList<String>();
		Properties props = new Properties();

		try {

			// CARGAMOS FICHERO MISPROPIEDADES
			props.load(new java.io.FileInputStream("src/main/java/pr21/misPropiedades.properties"));

			// TOMAMOS LOS NOMBRES DE MISPROPIEDADES
			Enumeration<?> pNames = props.propertyNames();

			while (pNames.hasMoreElements()) {
				String item = (String) pNames.nextElement();

				// TOMAMOS LOS VALORES DE LOS NOMBRES DE MISPROPIEDADES
				String valor = props.getProperty(item);

				// CREAMOS UNA LISTA CON LOS VALORES DE LAS PROPIEDADES
				listaPropiedades.add(valor);
			}

		} catch (FileNotFoundException exc) {
			// TODO Auto-generated catch block
			System.out.println("NO SE HA ENCONTRADO EL FICHERO");
			exc.printStackTrace();
		} catch (IOException exc) {
			// TODO Auto-generated catch block
			System.out.println("ERROR EN LA APLICACIÓN");
			exc.printStackTrace();
		}

		return listaPropiedades;
	}
}
