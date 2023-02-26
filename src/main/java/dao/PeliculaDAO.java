package dao;

public class PeliculaDAO {
	db.Db db = new db.Db("cinestar");
	
	public Object getPeliculas(int id) {
		db.Sentencia( String.format("call sp_getPeliculas(%s)",id) );
		return db.getRegistros();	
	}
}
