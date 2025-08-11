package console.cuentas;

import console.abstracts.AbstractConsola;
import console.abstracts.AbstractConsolaInterna;
import model.Cuenta;
import model.Usuario;

public class ConsolaCuentas extends AbstractConsolaInterna {

	public ConsolaCuentas(Object[] parametros, AbstractConsola padre, Usuario user) {
		super(parametros, padre, user);
	}

	@Override
	protected void instanciar() {
		Cuenta[] cuentas = getUser().getCuentas();
		pintarConSalto("Cuentas: ");
		pintarTablaCuentas(cuentas);
		pintarSinSalto("Seleccione una de las cuentas");
		for (int i = 0; i < cuentas.length - 1; i++) {
			pintarSinSalto((i + 1) + ",");
		}
		pintarSinSalto(cuentas.length - 1 + ": ");
		String linea = leerLinea();
		if (linea == null) {
			return;
		}
		try {
			int dir = Integer.parseInt(linea) - 1;
			if (dir >= 0 && dir <= cuentas.length - 1) {
				ConsolaCuenta consola = new ConsolaCuenta(new Cuenta[] { cuentas[dir] }, this, getUser());
				consola.iniciar();
			} else {
				pintarError("Entrada incorrecta");
				pintarConSalto("");
				instanciar();
			}
		} catch (NumberFormatException e) {
			pintarError("Entrada incorrecta");
			pintarConSalto("");
			instanciar();
		}

	}

	private void pintarTablaCuentas(Cuenta[] cuentas) {

	}

}
