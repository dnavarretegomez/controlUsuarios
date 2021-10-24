package cl.bci.apirest.usuario.response;

public class ValidateTokenResponse {
	private String status;
	private MensajeResponse mensaje;

	
	
	public ValidateTokenResponse() {
		
	}
	public ValidateTokenResponse(String status, MensajeResponse mensaje) {
		this.status = status;
		this.mensaje = mensaje;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public MensajeResponse getMensaje() {
		return mensaje;
	}
	public void setMensaje(MensajeResponse mensaje) {
		this.mensaje = mensaje;
	}

	
}