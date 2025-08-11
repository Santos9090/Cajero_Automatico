package model;

public class Titular {
	
	private Usuario usuario;
	private Cuenta cuenta;
	private Tarjeta[] tarjetas;
	
	public String getNombreCompleto() {
		return usuario.getNombre();
	}


	public Tarjeta[] getTarjetas() {
		return tarjetas;
	}

}
