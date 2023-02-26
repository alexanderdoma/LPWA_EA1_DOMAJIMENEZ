package bean;

public class Cine {
	int id, Salas, idDistrito;
	String RazonSocial, Direccion, Telefonos, Detalle;
	
	
	public Cine() {
		
	}
	
	public Cine(int id, int salas, int idDistrito, String razonSocial, String direccion, String telefonos, String detalle) {
		this.id = id;
		Salas = salas;
		this.idDistrito = idDistrito;
		RazonSocial = razonSocial;
		Direccion = direccion;
		Telefonos = telefonos;
		Detalle = detalle;
	}

	public String getDetalle() {
		return Detalle;
	}

	public void setDetalle(String detalle) {
		Detalle = detalle;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSalas() {
		return Salas;
	}
	public void setSalas(int salas) {
		Salas = salas;
	}
	public int getIdDistrito() {
		return idDistrito;
	}
	public void setIdDistrito(int idDistrito) {
		this.idDistrito = idDistrito;
	}
	public String getRazonSocial() {
		return RazonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		RazonSocial = razonSocial;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public String getTelefonos() {
		return Telefonos;
	}
	public void setTelefonos(String telefonos) {
		Telefonos = telefonos;
	}
	
	//Crea la clase cine con los datos de la matriz dada
	public Cine( String[] aRegistro ) {
		if ( aRegistro == null ) return;
		
		id = Integer.parseInt( aRegistro[0] );
		RazonSocial = aRegistro[1];
		Salas = Integer.parseInt(aRegistro[2]);
		idDistrito = Integer.parseInt(aRegistro[3]);
		Direccion = aRegistro[4];
		Telefonos = aRegistro[5];
		Detalle = aRegistro[6];
	}
}
