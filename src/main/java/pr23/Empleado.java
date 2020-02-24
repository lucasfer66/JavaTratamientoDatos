//AUTOR: LUCAS FERNANDEZ CEDRON

package pr23;

public class Empleado {

	String nombre;
	String apellidos;

	public Empleado(String nombre, String apellidos) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String toString() {
		return "Empleado: " + nombre + " " + apellidos;
	}

	@Override
	public boolean equals(Object object) {
		boolean iguales = false;
		if (object != null && object instanceof Empleado) {
			iguales = ((Empleado) object).getNombre().equalsIgnoreCase(this.getNombre())
					&& ((Empleado) object).getNombre().equalsIgnoreCase(this.getNombre());
		}

		return iguales;
	}
}
