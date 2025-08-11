package console;

import console.abstracts.AbstractConsola;
import console.abstracts.AbstractConsolaInterna;
import model.Usuario;

public class ConsolaSolicitarPrestamo extends AbstractConsolaInterna {

	public ConsolaSolicitarPrestamo(Object[] parametros, AbstractConsola padre, Usuario user) {
		super(parametros, padre, user);
	}

	@Override
	protected void instanciar() {
		// TODO Auto-generated method stub

	}

}
