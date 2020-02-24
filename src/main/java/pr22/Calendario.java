//AUTOR: LUCAS FERNANDEZ CEDRON

package pr22;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Calendario {

	public static boolean esLaborable(Calendar cal) {

		// INICIALIZAMOS EL BOOLEANO Y EL CALENDAR
		boolean laborable = true;
		int dia = cal.get(Calendar.DAY_OF_WEEK);

		if ((dia == Calendar.SUNDAY) || (dia == Calendar.SATURDAY)) {

			// SI ES SABADO O DOMINGO EL BOOLEANO PASA A SER FALSE
			laborable = false;
		}

		return laborable;
	}

	public static Calendar siguienteLaborable(Calendar cal) {

		// TOMAMOS EL DIA DE LA SEMANA Y CLONAMOS EL CALENDARIO
		int dia = cal.get(Calendar.DAY_OF_WEEK);
		Calendar aux = (Calendar) cal.clone();

		// ES VIERNES
		if ((dia == Calendar.FRIDAY)) {
			aux.add(Calendar.DAY_OF_YEAR, 3);
		}

		// ES SABADO
		else if ((dia == Calendar.SATURDAY)) {
			aux.add(Calendar.DAY_OF_YEAR, 2);
		}

		// NO VIERNES Y NO SABADO
		else {
			aux.add(Calendar.DAY_OF_YEAR, 1);
		}
		return aux;
	}

	public static java.sql.Date calendarToDate(Calendar cal) {

		// AÑO DE CALENDAR A DATE
		int año = cal.get(Calendar.YEAR) - 1900;

		// MES DE CALENDAR A DATE
		int mes = cal.get(Calendar.MONTH);

		// DIA DE CALENDAR A DATE
		int dia = cal.get(Calendar.DAY_OF_MONTH);

		// CONSTRUIMOS E INICIALIZAMOS LA FECHA
		java.sql.Date fecha = new java.sql.Date(año, mes, dia);

		return fecha;

	}

	public static Calendar dateToCalendar(java.sql.Date dat) {

		// DECLARAMOS UN CALENDARIO CONSTRUYENDOLO COMO UN CALENDARIO GREGORIANO
		Calendar cal = new GregorianCalendar();

		// UTILIZAMOS EL SETTIMEINMILLIS PARA INTRODUCIR LA FECHA AL CALENDARIO
		cal.setTimeInMillis(dat.getTime());

		return cal;

	}

}