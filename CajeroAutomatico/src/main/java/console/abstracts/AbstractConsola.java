package console.abstracts;

import java.util.Scanner;

import model.Usuario;

public abstract class AbstractConsola {
	private Scanner sc;
	private Object salida;
	private Object[] parametros;
	private AbstractConsola padre;

	public AbstractConsola(Object[] parametros, AbstractConsola padre) {
//		limpiarConsola();
		this.parametros = parametros;
		if (padre != null) {
			sc = padre.sc;
			this.padre = padre;
		} else {
			sc = new Scanner(System.in);
		}

	}

	public void iniciar() {
		instanciar();
		if (padre == null) {
			cerrarRecursos();
		}
	}

	protected void cerrarRecursos() {
		sc.close();
	}

	protected abstract void instanciar();

	protected void pintarSinSalto(String txt) {
		System.out.print(txt);
	}

	protected void pintarSinSalto(int txt) {
		System.out.print(txt);
	}

	protected void pintarSinSalto(double txt) {
		System.out.print(txt);
	}

	protected void pintarSinSalto(char txt) {
		System.out.print(txt);
	}

	protected void pintarSinSalto(Object txt) {
		System.out.print(txt);
	}

	protected void pintarConSalto(String txt) {
		System.out.println(txt);
	}

	protected void pintarConSalto(int txt) {
		System.out.println(txt);
	}

	protected void pintarConSalto(double txt) {
		System.out.println(txt);
	}

	protected void pintarConSalto(char txt) {
		System.out.println(txt);
	}

	protected void pintarConSalto(Object txt) {
		System.out.println(txt);
	}

	protected void pintarError(Object txt) {
		System.err.println(txt);
	}

	protected void pintarSeparador() {
		System.out.println("-----------------------------------------------------------------");
	}

	protected void pintarSaludoUsuario(Usuario usuario) {
		System.out.println("Bienvenido " + usuario.getNombre());
	}

	protected void pintarListaGuiones(Object[] array) {
		for (Object object : array) {
			System.out.println("- " + object);
		}
	}

	protected String leerLinea() {
		String entrada = sc.nextLine();
		if (entrada.equals(":q")) {
			if (padre != null) {
				padre.instanciar();
			}
			return null;
		}
		return entrada;
	}

	protected Object getSalida() {
		return salida;
	}

	protected void setSalida(Object salida) {
		this.salida = salida;
	}

	protected Object getParameter(int pos) {
		if (parametros != null && (pos >= 0 && pos <= parametros.length - 1)) {
			return parametros[pos];
		} else {
			return null;
		}
	}

}
