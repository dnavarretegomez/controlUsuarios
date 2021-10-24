package cl.bci.apirest.usuario.response;

public class LoginResponse {
	private String token;
	private String status;
	private MensajeResponse mensaje;
	
	
	
	public LoginResponse() {
		
	}
	public LoginResponse(String token, String status, MensajeResponse mensaje) {
		this.token = token;
		this.status = status;
		this.mensaje = mensaje;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
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
