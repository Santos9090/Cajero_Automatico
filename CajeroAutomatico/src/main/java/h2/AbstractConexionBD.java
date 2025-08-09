package h2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.sqlobjects.SQLData;
import model.sqlobjects.SQLStatement;

public abstract class AbstractConexionBD {
	private String url;
	protected Connection conn;
	
	public AbstractConexionBD(String url,String user,String pwd) throws SQLException {
		this.url=url;
		conn=DriverManager.getConnection(url, user, pwd);
	}
	
	protected abstract SQLData ejecutarConsulta(SQLStatement statement);
	protected abstract SQLData ejecutarDelete(SQLStatement statement);
	protected abstract SQLData ejecutarUpdate(SQLStatement statement);
	protected abstract SQLData ejecutarInsert(SQLStatement statement);
	protected abstract void commit() throws SQLException;
	protected abstract void liberar()throws SQLException;
	protected abstract void rollback()throws SQLException;


}
