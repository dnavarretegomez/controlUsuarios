package cl.bci.apirest.usuario.response;

public class IngresoSistemaResponse {
	private String token;
	private Boolean autorizado;
	
	public IngresoSistemaResponse() {
	}
	public IngresoSistemaResponse(String token, Boolean autorizado) {
		this.token = token;
		this.autorizado = autorizado;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Boolean getAutorizado() {
		return autorizado;
	}
	public void setAutorizado(Boolean autorizado) {
		this.autorizado = autorizado;
	}
	
	
}
