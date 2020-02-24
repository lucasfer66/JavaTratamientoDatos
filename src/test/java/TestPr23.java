import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import pr23.Empleado;
import pr23.LeeFichero;

public class TestPr23 {
	private static final double DELTA = 1e-15;

	@Test
	public void testSalarioMedio() {
		double salarioMedio = LeeFichero.salarioMedio();
		assertEquals("El salario medio de los empleados debe ser: \"1560\" ", salarioMedio, 1560.0, DELTA);
	}

	@Test
	public void testCreaEmpleados() {
		List<Empleado> resultadoEsperado= new ArrayList<Empleado>();
		resultadoEsperado.add(new Empleado("Alberto", "García Romero"));
		resultadoEsperado.add(new Empleado("José", "Martí Ramos"));
		resultadoEsperado.add(new Empleado("José Luis", "Aznar Cabo"));
		resultadoEsperado.add(new Empleado("José Antonio", "Antolín de Juan"));
		resultadoEsperado.add(new Empleado("Maria Antonia", "Alfonsín García"));
		List<Empleado> resultado=LeeFichero.creaEmpleados();
		assertTrue(resultado.size() == resultadoEsperado.size() &&	
		resultado.containsAll(resultadoEsperado) && resultadoEsperado.containsAll(resultado));
	}
}
