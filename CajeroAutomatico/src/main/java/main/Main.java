package main;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import console.inicio.ConsolaInicio;


public class Main {
	
	static Connection conn;
	
	
	public static void main(String[] args) throws SQLException, IOException, URISyntaxException, ClassNotFoundException {
		try {
			Properties props = new Properties();
            try (InputStream in = Main.class.getClassLoader().getResourceAsStream("conexion.properties")) {
                if (in == null) {
                    throw new IOException("No se encontró config.properties en resources");
                }
                props.load(in);
            }

            String scriptPath = Paths.get(
            	    Main.class.getClassLoader().getResource("db.sql").toURI()
            	).toString().replace("\\", "/");

            String url = props.getProperty("db.url").replace("{SQL_PATH}", scriptPath);
            conn = DriverManager.getConnection(url, props.getProperty("db.user"), props.getProperty("db.password"));
			ConsolaInicio consola= new ConsolaInicio(null, null);
			consola.iniciar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
