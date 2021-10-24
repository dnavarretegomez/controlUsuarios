package cl.bci.apirest.usuario.response;

import java.util.List;

import cl.bci.apirest.usuario.model.Usuario;

public class ObtenerUsuariosResponse {
	private List<Usuario> usuarios;
	private MensajeResponse mensaje;
	
	
	public ObtenerUsuariosResponse() {
		
	}
	public ObtenerUsuariosResponse(List<Usuario> usuarios, MensajeResponse mensaje) {
		this.usuarios = usuarios;
		this.mensaje = mensaje;
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public MensajeResponse getMensaje() {
		return mensaje;
	}
	public void setMensaje(MensajeResponse mensaje) {
		this.mensaje = mensaje;
	}
	
	
	
}