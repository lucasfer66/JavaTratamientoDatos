//AUTOR: LUCAS FERNANDEZ CEDRON

package pr24;

public class FileName {
	private String nombre, extension, path, nombreCompleto;

	// CONSTRUCTOR
	public FileName(String nombreCompleto) {

		// CASO DE QUE NOMBRE COMPLETO SEA VACIO
		if (nombreCompleto == null || nombreCompleto.trim().equals("")) {
			this.path = null;
			this.nombre = null;
			this.extension = null;
		}

		// CASO QUE NOMBRE COMPLETO NO SEA VACIO
		else {
			this.nombreCompleto = nombreCompleto;
			int posbarra = nombreCompleto.lastIndexOf("/");
			int pospunto = nombreCompleto.lastIndexOf(".");

			// SI NO HAY BARRA
			if (posbarra == -1) {
				this.path = null;

				// SI NO HAY BARRA Y NO HAY PUNTO
				if (pospunto == -1) {
					this.extension = null;
					this.nombre = nombreCompleto;
				}

				// SI NO HAY BARRA PERO SI PUNTO
				else {
					this.nombre = nombreCompleto.substring(0, pospunto);
					this.extension = nombreCompleto.substring(pospunto + 1);
				}
			}

			// SI NO HAY PUNTO
			else if (pospunto == -1) {
				this.extension = null;
				this.path = nombreCompleto.substring(0, posbarra + 1);
				this.nombre = nombreCompleto.substring(posbarra + 1);

			}

			// SI NO HAY PUNTO 2
			else if (pospunto < posbarra) {
				this.extension = null;
				this.path = nombreCompleto.substring(0, posbarra + 1);
				this.nombre = nombreCompleto.substring(posbarra + 1);
			}

			// CASO EN EL QUE EXISTA BARRA Y PUNTO
			else {
				this.path = nombreCompleto.substring(0, posbarra + 1);
				this.nombre = nombreCompleto.substring(posbarra + 1, pospunto);
				this.extension = nombreCompleto.substring(pospunto + 1);
			}
		}
	}

	// CONSTRUCTOR POR PARTES SEPARADAS (PATH, NOMBRE Y EXTENSION)
	public FileName(String p, String n, String e) {

		this.nombreCompleto = "";

		// SI EL PATH ES VACIO
		if (p == null || (p.trim().equals(""))) {
			this.path = null;
		}

		// SI EL PATH NO ES VACIO
		else {
			this.path = p;
		}

		// NOMBRE NO ES NULO NI VACIO
		this.nombre = n;

		// SI LA EXTENSION ES VACIA
		if (e == null || (e.equals(""))) {
			this.extension = null;
		} else {
			if (e.indexOf(".") == 0) {
				this.extension = e.substring(1);
			} else {
				this.extension = e;
			}
			if (p == null || (p.trim().equals(""))) {
				if (e == null || (e.equals(""))) {
					this.nombreCompleto = n;
				} else {
					this.nombreCompleto = n + "." + e;
				}
			} else if (e == null || (e.equals(""))) {
				this.nombreCompleto = p + n;
			} else {
				this.nombreCompleto = p + n + "." + e;
			}
		}

	}

	// METODOS GET

	public String getNombre() {
		return this.nombre;
	}

	public String getPath() {
		return this.path;
	}

	public String getExtension() {
		return this.extension;
	}

	public String getNombreCompleto() {
		return this.nombreCompleto;
	}

	// METODOS SET

	public void setNombre(String nombre) {

		// COMPROBAMOS QUE SE INTRODUZCA UN NOMBRE VALIDO
		if (nombre == null || nombre.trim().equals("")) {
			this.nombre = null;
			this.nombreCompleto = null;
		}
		// CAMBIAMOS EL VALOR DE NOMBRE Y DE NOMBRE COMLPETO
		else {
			this.nombreCompleto.replaceFirst(this.nombre, nombre);
			this.nombre = nombre;
		}
	}

	public void setExtension(String extension) {

		// COMPROBAMOS QUE SE INTRODUZCA UNA EXTENSION
		if (extension == null || extension.trim().equals("")) {
			this.nombreCompleto.replaceFirst(this.extension, "");
			this.extension = null;
		}

		// CAMBIAMOS EL VALOR DE EXTENSION Y EL DE NOMBRECOMPLETO
		else {
			// BUSCAMOS EL . PARA LOCALIZAR LA EXTENSION
			if (extension.indexOf(".") == 0) {
				this.nombreCompleto.replaceFirst(this.extension, extension.substring(1));
				this.extension = extension.substring(1);
			} else {
				this.nombreCompleto.replaceFirst(this.extension, extension);
				this.extension = extension;
			}
		}
	}

	public void setPath(String path) {

		// COMPROBAMOS QUE SE INTRODUCE UN PATH
		if (path == null || path.trim().equals("")) {
			this.nombreCompleto.replaceFirst(this.path, "");
			this.path = null;
		} else {

			// BUSCAMOS LA ULTIMA / PARA LOCALIZAR EL PATH
			if (path.lastIndexOf("/") == path.length() - 1) {
				this.nombreCompleto.replaceFirst(this.path, path + "/");
				this.path = path;
			} else {
				this.nombreCompleto.replaceFirst(this.path, path);
				this.path = path + "/";
			}
		}
	}

	// METODO TOSTRING
	@Override
	public String toString() {
		return getPath() + " - " + getNombre() + " - " + getExtension() + " - " + getNombreCompleto();
	}

	// METODO EQUALS
	@Override
	public boolean equals(Object object) {
		boolean iguales = false;
		if (object != null && object instanceof FileName) {
			iguales = compara(((FileName) object).getPath(), this.getPath())
					&& compara(((FileName) object).getNombre(), this.getNombre())
					&& compara(((FileName) object).getExtension(), this.getExtension());
		}
		return iguales;
	}

	// METODO COMPARA
	public static boolean compara(String a, String b) {

		boolean resultado = false;

		if ((a == null || b == null) && !(a == null && b == null))
			return false;
		else if (a == null && b == null)
			return true;
		else
			resultado = a.equalsIgnoreCase(b);
		return resultado;
	}
}
