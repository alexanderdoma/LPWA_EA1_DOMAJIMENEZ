package dao;

import java.util.ArrayList;
import java.util.List;
import bean.Cine;

public class CineDAO {
	
	String[][] mDatos = null;	
	Cine objCine = null;
	List<Cine> listCines = new ArrayList<>();
	db.Db db = new db.Db("cinestar");
	
	
	//Devuelve una lista de objetos cine
	public List<Cine> getCines() {
		db.Sentencia( String.format("call sp_getCines()"));
		mDatos = db.getRegistros();
		for (String[] cine : mDatos) {
			listCines.add(new Cine(cine));
		}
		return listCines;
	}
	
	//Devuelve un objeto cine
	public Cine getCine(int id) {
		db.Sentencia(String.format("call sp_getCine(%s)", id));
		mDatos = db.getRegistros();
		for (String[] cine : mDatos) {
			objCine = new Cine(cine);
		}
		return objCine;
	}
}
