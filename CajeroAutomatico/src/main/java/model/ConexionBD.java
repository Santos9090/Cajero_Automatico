package model;

import java.sql.SQLException;

import h2.AbstractConexionBD;
import model.sqlobjects.SQLData;
import model.sqlobjects.SQLStatement;

public class ConexionBD extends AbstractConexionBD{

	public ConexionBD() throws SQLException {
		super("","","");
	}

	@Override
	protected SQLData ejecutarConsulta(SQLStatement statement) {
		return null;
	}

	@Override
	protected SQLData ejecutarDelete(SQLStatement statement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected SQLData ejecutarUpdate(SQLStatement statement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected SQLData ejecutarInsert(SQLStatement statement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void commit() throws SQLException {
		conn.commit();
	}

	@Override
	protected void liberar() throws SQLException {
		conn.close();
	}

	@Override
	protected void rollback() throws SQLException {
		conn.rollback();
	}

}
