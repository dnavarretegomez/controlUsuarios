package cl.bci.apirest.usuario.service;

import cl.bci.apirest.usuario.request.RegistroSistemaRequest;
import cl.bci.apirest.usuario.response.ObtenerUsuariosResponse;
import cl.bci.apirest.usuario.response.RegistroSistemaResponse;

public interface UsuarioService {
	public RegistroSistemaResponse registro(RegistroSistemaRequest request);
	public ObtenerUsuariosResponse getAllUsuario(String token);
}