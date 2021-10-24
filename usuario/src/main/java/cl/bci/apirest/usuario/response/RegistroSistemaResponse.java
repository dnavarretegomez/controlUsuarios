package cl.bci.apirest.usuario.response;

public class RegistroSistemaResponse {
	private DatosRegistroResponse datos;
	
	private MensajeResponse mensaje;
	
	public RegistroSistemaResponse() {
		
	}
	public RegistroSistemaResponse(DatosRegistroResponse datos, MensajeResponse mensaje) {
		this.datos = datos;
		this.mensaje = mensaje;
	}

	public DatosRegistroResponse getDatos() {
		return datos;
	}

	public void setDatos(DatosRegistroResponse datos) {
		this.datos = datos;
	}

	public MensajeResponse getMensaje() {
		return mensaje;
	}

	public void setMensaje(MensajeResponse mensaje) {
		this.mensaje = mensaje;
	}
	
	
	
}
