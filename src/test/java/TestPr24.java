import static org.junit.Assert.assertEquals;

import org.junit.Test;

import pr24.FileName;

public class TestPr24 {

	@Test
	public void testCreaFicheroNulos1() {
		FileName f= new FileName(null);
		FileName fEsperado= new FileName(null,null,null);
		assertEquals(f,fEsperado);
	} 
	@Test
	public void testCreaFicheroNulos2() {
		FileName f= new FileName("");
		FileName fEsperado= new FileName(null,null,null);
		assertEquals(f,fEsperado);
	}
	@Test
	public void testCreaFicheroNulos3() {
		FileName f= new FileName(" ");
		FileName fEsperado= new FileName(null,null,null);
		assertEquals(f,fEsperado);
	}
	
	
	@Test
	public void testCreaFichero1() {
		FileName f = new FileName("C:/tmp/cosa.txt");
		FileName fEsperado= new FileName("C:/tmp/","cosa","txt");
		assertEquals(f,fEsperado);
	}
	@Test
	public void testCreaFichero2() {
		FileName f = new FileName("/tmp/cosa.txt");
		FileName fEsperado= new FileName("/tmp/","cosa","txt");
		assertEquals(f,fEsperado);
	}
	@Test
	public void testCreaFichero3() {
		FileName f = new FileName("/cosa.txt");
		FileName fEsperado= new FileName("/","cosa","txt");
		assertEquals(f,fEsperado);
	}
	@Test
	public void testCreaFichero4() {
		FileName f = new FileName("cosa.txt");
		FileName fEsperado= new FileName(null,"cosa","txt");
		assertEquals(f,fEsperado);
	}
	@Test
	public void testCreaFichero5() {
		FileName f = new FileName("cosa");
		FileName fEsperado= new FileName(null,"cosa",null);
		assertEquals(f,fEsperado);
	}

	@Test
	public void testCreaFichero1SinRuta1() {
		FileName f= new FileName("./cosa.txt");
		FileName fEsperado= new FileName("./","cosa","txt");
		assertEquals(f,fEsperado);
	}
	@Test
	public void testCreaFichero1SinRuta2() {
		FileName f= new FileName("../cosa.txt");
		FileName fEsperado= new FileName("../","cosa","txt");
		assertEquals(f,fEsperado);
	}
	@Test
	public void testCreaFichero1SinRuta3() {
		FileName f= new FileName("../cosa");
		FileName fEsperado= new FileName("../","cosa",null);
		assertEquals(f,fEsperado);
	}
	@Test
	public void testCreaFichero1SinRuta4() {
		FileName f= new FileName("./cosa.txt");
		FileName fEsperado= new FileName("./","cosa","txt");
		assertEquals(f,fEsperado);
	}
		

	@Test
	public void testCambiaFichero() {
		FileName f = new FileName("C:/tmp/cosa.txt");
		f.setExtension(null);
		FileName fEsperado= new FileName("C:/tmp/","cosa",null);
		assertEquals(f,fEsperado);
	}
	@Test
	public void testCambiaFichero2() {
		FileName f = new FileName("C:/tmp/cosa.txt");
		f.setExtension("");
		FileName fEsperado= new FileName("C:/tmp/","cosa",null);
		assertEquals(f,fEsperado);
	}
	@Test
	public void testCambiaFichero3() {
		FileName f  = new FileName("C:/tmp/cosa.txt");
		f.setExtension(".bmp");
		FileName fEsperado= new FileName("C:/tmp/","cosa","bmp");
		assertEquals(f,fEsperado);
	}
	@Test
	public void testCambiaFichero4() {
		FileName f  = new FileName("C:/tmp/cosa.txt");
		f.setNombre("cosita");
		FileName fEsperado= new FileName("C:/tmp/","cosita","txt");
		assertEquals(f,fEsperado);
	}
	@Test
	public void testCambiaFichero5() {
		FileName f = new FileName("C:/tmp/cosa.txt");
		f.setPath(null);
		FileName fEsperado= new FileName(null,"cosa","txt");
		assertEquals(f,fEsperado);
	}

	@Test
	public void testCambiaFichero6() {
		FileName f = new FileName("C:/tmp/cosa.txt");
		f.setPath("");
		FileName fEsperado= new FileName(null,"cosa","txt");
		assertEquals(f,fEsperado);
	}

	
	@Test
	public void testCambiaFichero7() {
		FileName f = new FileName("C:/tmp/cosa.txt");
		f.setPath("/");
		FileName fEsperado= new FileName("/","cosa","txt");
		assertEquals(f,fEsperado);
	}

	@Test
	public void testCambiaFichero8() {
		FileName f = new FileName("C:/tmp/cosa.txt");
		f.setPath(".");
		FileName fEsperado= new FileName("./","cosa","txt");
		assertEquals(f,fEsperado);
	}

	
}