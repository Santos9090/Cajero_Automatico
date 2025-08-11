package console.abstracts;

import model.Usuario;

public abstract class AbstractConsolaInterna extends AbstractConsola {
	private Usuario user;
	public AbstractConsolaInterna(Object[] parametros, AbstractConsola padre,Usuario user) {
		super(parametros, padre);
		this.user=user;
	}

	@Override
	protected abstract void instanciar();

	protected Usuario getUser() {
		return user;
	}

	protected void setUser(Usuario user) {
		this.user = user;
	}
	
}
