package console;

import console.abstracts.AbstractConsola;
import console.abstracts.AbstractConsolaInterna;
import console.cuentas.ConsolaCuenta;
import console.cuentas.ConsolaCuentas;
import console.efectivo.ConsolaRealizarIngreso;
import console.efectivo.ConsolaSacarEfectivo;
import console.movimientos.ConsolaConsultarMovimientos;
import console.movimientos.ConsolaRealizarMovimientos;
import model.Cuenta;
import model.Usuario;

public class ConsolaHome extends AbstractConsolaInterna {

	public ConsolaHome(Object[] parametros, AbstractConsola padre, Usuario user) {
		super(parametros, padre, user);
	}

	@Override
	protected void instanciar() {
		pintarSaludoUsuario(getUser());
		pintarConSalto("");
		pintarConSalto("Opciones:");
		String[] array = new String[] { "1 Consultar Cuenta", "2 Realizar Movimiento", "3 Retirar Efectivo",
				"4 Realizar un ingreso", "5 Consultar Movimientos Anteriores", "6 Modificar PIN",
				"7 Solicitud de Prestamo" };
		pintarListaGuiones(array);
		String entrada = leerLinea();
		if (entrada == null) {
			return;
		}
		int dir = 0;
		try {
			dir = Integer.parseInt(entrada);
			AbstractConsolaInterna consola = null;
			switch (dir) {
			case 1:
				if (masDUnaCuenta()) {
					consola = new ConsolaCuentas(null, this, getUser());
				} else {
					consola = new ConsolaCuenta(new Cuenta[] {getUser().getCuentas()[0]}, this, getUser());
				}
				break;
			case 2:
				consola = new ConsolaRealizarMovimientos(null, this, getUser());
				break;
			case 3:
				consola = new ConsolaSacarEfectivo(null, this, getUser());
				break;
			case 4:
				consola = new ConsolaRealizarIngreso(null, this, getUser());
				break;
			case 5:
				consola = new ConsolaConsultarMovimientos(null, this, getUser());
				break;
			case 6:
				consola = new ConsolaModificarPIN(null, this, getUser());
				break;
			case 7:
				consola = new ConsolaSolicitarPrestamo(null, this, getUser());
				break;
			default:
				pintarError("Entrada incorrecta");
				instanciar();
				break;
			}
			if (consola != null) {
				consola.iniciar();
			}
		} catch (NumberFormatException e) {
			pintarError("Entrada incorrecta");
			instanciar();
		}

	}

	private boolean masDUnaCuenta() {
		return getUser().getCuentas().length > 1;
	}

}
