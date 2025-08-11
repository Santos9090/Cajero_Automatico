package console.cuentas;

import console.ConsolaModificarPIN;
import console.ConsolaSolicitarPrestamo;
import console.abstracts.AbstractConsola;
import console.abstracts.AbstractConsolaInterna;
import console.efectivo.ConsolaRealizarIngreso;
import console.efectivo.ConsolaSacarEfectivo;
import console.movimientos.ConsolaConsultarMovimientos;
import console.movimientos.ConsolaRealizarMovimientos;
import model.Cuenta;
import model.Tarjeta;
import model.Titular;
import model.Usuario;

public class ConsolaCuenta extends AbstractConsolaInterna {

	public ConsolaCuenta(Object[] parametros, AbstractConsola padre, Usuario user) {
		super(parametros, padre, user);
	}

	@Override
	protected void instanciar() {
		Cuenta cuenta = (Cuenta) getParameter(0);
		pintarConSalto("Numero de Cuenta: " + cuenta.getNumeroDCuenta());
		pintarConSalto("Saldo: " + cuenta.getSaldo());
		pintarConSalto("Titulares: ");
		Titular[] titulares = cuenta.getTitulares();
		for (Titular titular : titulares) {
			pintarConSalto("-" + titular.getNombreCompleto());
			pintarConSalto(" -Tarjetas: ");
			Tarjeta[] tarjetas = titular.getTarjetas();
			for (Tarjeta tarjeta : tarjetas) {
				pintarConSalto("  -" + tarjeta.getNumeroDTarjeta());
			}
		}
		pintarConSalto("");
		String[] array = new String[] { "1 Realizar Movimiento", "2 Retirar Efectivo", "3 Realizar un ingreso",
				"4 Consultar Movimientos Anteriores", "5 Modificar PIN", "6 Solicitud de Prestamo" };
		pintarListaGuiones(array);
		pintarSinSalto("¿Quiere realizar Alguna Operacion?:");
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
				consola = new ConsolaRealizarMovimientos(null, this, getUser());
				break;
			case 2:
				consola = new ConsolaSacarEfectivo(null, this, getUser());
				break;
			case 3:
				consola = new ConsolaRealizarIngreso(null, this, getUser());
				break;
			case 4:
				consola = new ConsolaConsultarMovimientos(null, this, getUser());
				break;
			case 5:
				consola = new ConsolaModificarPIN(null, this, getUser());
				break;
			case 6:
				consola = new ConsolaSolicitarPrestamo(null, this, getUser());
				break;
			default:
				pintarError("Entrada incorrecta");
				instanciar();
			}
			if (consola != null) {
				consola.iniciar();
			}
		} catch (NumberFormatException e) {
			pintarError("Entrada incorrecta");
			instanciar();
		}
	}

}
