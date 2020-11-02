package fiap.nac2.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectionFactory {

	public Connection getConexao() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String jdbc = "jdbc:oracle:thin:@192.168.56.120:1521:orcl";		
		return DriverManager.getConnection(jdbc, "SAITH", "SAITH");		
	}
}
