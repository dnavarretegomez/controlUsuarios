package cl.bci.apirest.usuario.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.bci.apirest.usuario.funcion.Funciones;
import cl.bci.apirest.usuario.model.Auditoria;
import cl.bci.apirest.usuario.repository.AuditoriaRepository;
import cl.bci.apirest.usuario.repository.UsuarioRepository;
import cl.bci.apirest.usuario.request.LoginRequest;
import cl.bci.apirest.usuario.response.LoginResponse;
import cl.bci.apirest.usuario.response.LogoutResponse;
import cl.bci.apirest.usuario.response.MensajeResponse;
import cl.bci.apirest.usuario.response.ValidateTokenResponse;
import cl.bci.apirest.usuario.service.MainService;

@Service
public class MainServiceImpl implements MainService {
	
	@Autowired
	private AuditoriaRepository auditoriaRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public ValidateTokenResponse validateToken(String token) {
		Auditoria auditoria = new Auditoria();
		auditoria = auditoriaRepository.validateToken(token);
		ValidateTokenResponse response = new ValidateTokenResponse();
		MensajeResponse mensaje = new MensajeResponse();
		try {
		if(auditoria.isIsactive() == false) {
			response.setStatus("TOKEN NO VALIDO");
			mensaje.setCodigo(400);
			mensaje.setMensaje("El token expiro o no existe");
		}else {
			response.setStatus("TOKEN ACTIVO");
			mensaje.setCodigo(200);
			mensaje.setMensaje("Operación Exitosa");
		}
		}catch (Exception e) {
			System.out.println(e.getMessage());
			mensaje.setCodigo(404);
			mensaje.setMensaje("El token informado no existe");
		}
		response.setMensaje(mensaje);
		return response;
	}

	@Override
	public LogoutResponse logout(String token) {
		LogoutResponse response = new LogoutResponse();
		MensajeResponse mensaje = new MensajeResponse();
		try {
			auditoriaRepository.logout(token);
			response.setStatus("Se ha cerrado la sesión correctamente");
			mensaje.setCodigo(200);
			mensaje.setMensaje("Operación Exitosa");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			response.setStatus("Ha ocurrido un error");
			mensaje.setCodigo(500);
			mensaje.setMensaje("Internal server error");
		}
		response.setMensaje(mensaje);
		return response;
	}

	@Override
	public LoginResponse login(LoginRequest request) {
		LoginResponse response = new LoginResponse();
		MensajeResponse mensaje = new MensajeResponse();
		int idUsuarioLogin = 0;
		Funciones funcion = new Funciones();
		try {
			String token = funcion.generateUUID();
			LocalDateTime local = LocalDateTime.now();
			idUsuarioLogin = usuarioRepository.getIdUsuario(request.getEmail(), request.getPassword());
			auditoriaRepository.Login(token, local, local, idUsuarioLogin);
			response.setToken(token);
			response.setStatus("Bienvenido devuelta");
			mensaje.setCodigo(200);
			mensaje.setMensaje("Operación Exitosa");
		} catch (Exception e) {
			response.setStatus("Ha ocurrido un error");
			mensaje.setCodigo(400);
			mensaje.setMensaje("Bad request");
			System.out.println(e.getMessage());
		}
		response.setMensaje(mensaje);
		return response;
	}

}
