package dao;

import java.util.ArrayList;
import java.util.List;
import bean.Pelicula;

public class PeliculaDAO {
	String[][] mDatos = null;	
	Pelicula objPelicula = null;
	List<Pelicula> listPeliculas = new ArrayList<>();
	db.Db db = new db.Db("cinestar");
	
	//Devuelve una lista de objetos pelicula
	public List<Pelicula> getPeliculas(int id) {
		db.Sentencia( String.format("call sp_getPeliculas(%s)", id));
		mDatos = db.getRegistros();
		for (String[] pelicula : mDatos) {
			listPeliculas.add(new Pelicula(pelicula));
		}
		return listPeliculas;
	}
	
	//Devuelve un objeto cine
	public Pelicula getPelicula(int id) {
		db.Sentencia(String.format("call sp_getPelicula(%s)", id));
		mDatos = db.getRegistros();
		for (String[] pelicula : mDatos) {
			objPelicula = new Pelicula(pelicula);
		}
		return objPelicula;
	}	
}