package console.inicio;

import console.ConsolaHome;
import console.abstracts.AbstractConsola;
import model.Tarjeta;
import model.Usuario;

public class ConsolaInicio extends AbstractConsola{

	public ConsolaInicio(Object[] parametros, AbstractConsola padre) {
		super(parametros, padre);
	}

	@Override
	protected void instanciar() {
		pintarConSalto("");
		pintarConSalto("Bienvenido/a al Cajero de los dineros");
		pintarConSalto("Como desea Iniciar Sesion?");
		pintarListaGuiones(new String[] {"1 Tarjeta"});
		pintarListaGuiones(new String[] {"2 Usuario"});
		String eleccion=leerLinea();
		if (eleccion==null) {
			return;
		}
		AbstractConsola paso = null;
		try {
			switch (Integer.parseInt(eleccion)) {
			case 1: {
				paso=new ConsolaInicioTarjeta(null,this);
				break;
			}
			case 2: {
				paso=new ConsolaInicioUsuario(null,this);
				break;
			}
			default:
				pintarError("Entrada Incorrecta");
				instanciar();
			}
			paso.iniciar();
		} catch (NumberFormatException e) {
			pintarError("Entrada Incorrecta");
			instanciar();
		}
		if (paso!=null) {
			Object salida = paso.getSalida();
			if (salida instanceof Tarjeta) {
				ConsolaHome home = new ConsolaHome(null, this,((Tarjeta) salida).getUsuario());
				home.iniciar();
			}else if(salida instanceof Usuario) {
				ConsolaHome home = new ConsolaHome(null, this, (Usuario) salida);
				home.iniciar();
			}
		}
		
	}
	
}
