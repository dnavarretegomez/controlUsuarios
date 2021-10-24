package cl.bci.apirest.usuario.service;

import cl.bci.apirest.usuario.response.LogoutResponse;
import cl.bci.apirest.usuario.response.ValidateTokenResponse;

public interface MainService {
	
	public ValidateTokenResponse validateToken(String token);
	public LogoutResponse logout(String token);
}