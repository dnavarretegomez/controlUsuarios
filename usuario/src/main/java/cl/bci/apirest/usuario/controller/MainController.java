package cl.bci.apirest.usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.bci.apirest.usuario.response.LogoutResponse;
import cl.bci.apirest.usuario.response.ValidateTokenResponse;
import cl.bci.apirest.usuario.service.MainService;

@RestController
@RequestMapping(path="/Main")
public class MainController {
	
	@Autowired
	private MainService mainService;
	
	@GetMapping(path = "/validateToken")
	public ValidateTokenResponse validateToken(@RequestHeader("token") String token) {
		return mainService.validateToken(token);
	}
	
	@GetMapping(path = "logout")
	public LogoutResponse logout(@RequestHeader("token") String token) {
		return mainService.logout(token);
	}
}