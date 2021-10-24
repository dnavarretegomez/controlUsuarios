package cl.bci.apirest.usuario.service;

import cl.bci.apirest.usuario.request.LoginRequest;
import cl.bci.apirest.usuario.response.LoginResponse;
import cl.bci.apirest.usuario.response.LogoutResponse;
import cl.bci.apirest.usuario.response.ValidateTokenResponse;

public interface MainService {
	
	public ValidateTokenResponse validateToken(String token);
	public LogoutResponse logout(String token);
	public LoginResponse login(LoginRequest request); 
	
}