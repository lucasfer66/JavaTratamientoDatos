import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import pr21.LeeFichero;

public class TestPr21 { 

	@Test
	public void testDevuelveValores() {
		List<String> resultadoEsperado= new ArrayList<String>();
		resultadoEsperado.add("segundo");
		resultadoEsperado.add("prbd");
		resultadoEsperado.add("2020");
		List<String> resultado=LeeFichero.devuelvePropiedades();
		assertTrue(resultado.size() == resultadoEsperado.size() && 
				resultado.containsAll(resultadoEsperado) && resultadoEsperado.containsAll(resultado));
	}	
}
