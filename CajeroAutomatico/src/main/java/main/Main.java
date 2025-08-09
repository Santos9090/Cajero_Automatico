package main;

import java.sql.SQLException;

import model.ConexionBD;

public class Main {
	public static ConexionBD conexion;
	public static void main(String[] args) throws SQLException {
		conexion= new ConexionBD();
	}
}
