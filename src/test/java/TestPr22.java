import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import java.text.SimpleDateFormat;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import pr22.Calendario;

public class TestPr22 { 

	@Test
	//Test con una fecha laborable
	public void testEsLaborable1() {
		Calendar c = new GregorianCalendar(2020,1,12);
		assertTrue(Calendario.esLaborable(c));
	}	
	
	@Test
	//Test con una fecha NO laborable
	public void testEsLaborable2() {
		Calendar c = new GregorianCalendar(2020,1,16);
		assertTrue(!Calendario.esLaborable(c));
	}	
	
	@Test
	public void testSiguienteLaborable() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Calendar c = new GregorianCalendar(2020,1,14);
		Calendar cs = new GregorianCalendar(2020,1,17);
		assertEquals("El siguiente dia laborable al calendar: "+ sdf.format(c.getTime())+ ", es: "+sdf.format(Calendario.siguienteLaborable(c).getTime()), Calendario.siguienteLaborable(c),cs);
	}
	
	@Test
	@SuppressWarnings("deprecation")
	public void testCalendarToDate() {
		Calendar c = new GregorianCalendar(2020,1,22);
		Date d = new Date(120,1,22);
		assertEquals(Calendario.calendarToDate(c),d);
	}
	
	@Test
	@SuppressWarnings("deprecation")
	public void testDateToCalendar() {
		Calendar c = new GregorianCalendar(2020,1,22);
		Date d = new Date(120,1,22);
		assertEquals(Calendario.dateToCalendar(d),c);
	}
	

}
