package cl.bci.apirest.usuario.response;

public class MensajeResponse {
	private int codigo;
	private String Mensaje;
	
	public MensajeResponse() {
	}
	
	public MensajeResponse(int codigo, String mensaje) {
		this.codigo = codigo;
		Mensaje = mensaje;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getMensaje() {
		return Mensaje;
	}
	public void setMensaje(String mensaje) {
		Mensaje = mensaje;
	}

	
	
}
