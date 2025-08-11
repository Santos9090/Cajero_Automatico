package console.inicio;

import console.abstracts.AbstractConsola;
import model.Usuario;

public class ConsolaInicioUsuario extends AbstractConsola {

	public ConsolaInicioUsuario(Object[] parametros, AbstractConsola padre) {
		super(parametros, padre);
	}

	protected void instanciar() {
		pintarConSalto("");
		pintarSinSalto("Introduzca nombre de usuario:");
		String user = leerLinea();
		if (user == null) {
			return;
		}
		pintarSinSalto("Introduzca PIN:");
		String pin = leerLinea();
		Usuario t = null;
		try {
			t = Usuario.login(user, Integer.parseInt(pin));
		} catch (NumberFormatException e) {
			pintarError("Usuario o PIN Incorrectos");
			instanciar();
		}
		if (t != null) {
			setSalida(t);
		} else {
			pintarError("Usuario o PIN Incorrectos");
			instanciar();
		}

	}

}
