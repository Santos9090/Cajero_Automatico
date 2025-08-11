package console.inicio;

import console.abstracts.AbstractConsola;
import model.Tarjeta;

public class ConsolaInicioTarjeta extends AbstractConsola {

	public ConsolaInicioTarjeta(Object[] parametros, AbstractConsola padre) {
		super(parametros, padre);
	}

	protected void instanciar() {
		pintarConSalto("");
		pintarSinSalto("Introduzca Numero de Tarjeta:");
		String num = leerLinea();
		if(num==null) {
			return;
		}
		if (validarTarjeta(num)) {
			pintarSinSalto("Introduzca PIN:");
			String pin = leerLinea();
			Tarjeta t = null;
			try {
				t = Tarjeta.login(Long.parseLong(num), Integer.parseInt(pin));
			} catch (NumberFormatException e) {
				pintarError("Numero de Tarjeta o PIN Incorrectos");
				instanciar();
			}
			if (t != null) {
				setSalida(t);
			} else {
				pintarError("Numero de Tarjeta o PIN Incorrectos");
				instanciar();
			}
		} else {
			pintarError("Numero de Tarjeta no valido. Longitud 16");
			instanciar();
		}
	}

	private boolean validarTarjeta(String num) {
		return num.length() == 16;
	}

}
