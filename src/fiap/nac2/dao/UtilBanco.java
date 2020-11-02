package fiap.nac2.dao;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.ParseException;

public class UtilBanco {
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss"); 
	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
	
	private static DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy"); 
	

	public static Date converte(LocalDateTime data) throws ParseException {
		
		String dataTexto = data.format(dtf);		
		java.util.Date dataUtil = sdf.parse(dataTexto);		
		Date retorno = new Date(dataUtil.getTime());
		return retorno;
		
	}
	
	public static LocalDateTime converte(Date dateSql) {
		
		String s = sdf.format(dateSql);
		LocalDateTime ldt = LocalDateTime.parse(s, dtf);
		return ldt;
		
	}
	
	public static LocalDate converteDt(Date dateSql) {
		
		String s = sdf.format(dateSql);
		LocalDate ldt = LocalDate.parse(s, dtf);
		return ldt;
		
	}

	public static Date converte(LocalDate data) throws ParseException {
		
		String dataTexto = data.format(dtf2);		
		java.util.Date dataUtil = sdf2.parse(dataTexto);		
		Date retorno = new Date(dataUtil.getTime());
		return retorno;
	}

}
