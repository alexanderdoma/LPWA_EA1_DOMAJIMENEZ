package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Db {
	String _IP="localhost";
	String _PORT="3306";
	String _BD="cinestar";
	String _USER="root";
	String _PASSWORD="";
	String _SQL="";
	
	Connection cn = null;
	PreparedStatement ps = null;

	public Db(String bd) {
		this._BD = bd;
		getConexion();
	}
	
	private void getConexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection( String.format("jdbc:mysql://%s:%s/%s",_IP,_PORT,_BD ), _USER, _PASSWORD);
		} catch (ClassNotFoundException | SQLException e) { e.printStackTrace(); }
	}

	
	//Prepara la sentencia SQL
	public void Sentencia(String sql) {
		if ( cn == null ) return;
		
		this._SQL = sql;
		try {
			ps = cn.prepareStatement(sql);
		} catch (SQLException e) { e.printStackTrace(); }
	}

	//Ejecuta cualquier consulta y te lo devuelve en una matriz
	public String[][] getRegistros() {
		if ( cn == null ) return null;
		
		try {
			ResultSet rs = ps.executeQuery();
			if ( rs.last() ) {
				int filas = rs.getRow();
				int columnas = rs.getMetaData().getColumnCount();
				String[][] mRegistros = new String[filas][columnas];
				
				rs.beforeFirst();
				for( int fila=0; rs.next(); fila++ )
					for( int columna=0; columna < columnas; columna++ )
						mRegistros[fila][columna] = rs.getString(columna + 1).trim();
				
				return mRegistros;
			}
		} catch (SQLException e) { e.printStackTrace();	}
		return null;
	}
}

