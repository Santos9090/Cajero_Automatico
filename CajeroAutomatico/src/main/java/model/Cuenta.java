package model;

public class Cuenta {
	private long id_cuenta;
	private long num_cuenta;
	private double saldo;

	public Titular[] getTitulares() {
		return new Titular[] { new Titular(), new Titular(), new Titular() };
	}

	public double getSaldo() {
		return saldo;
	}

	public long getNumeroDCuenta() {
		return num_cuenta;
	}
}
