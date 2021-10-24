package cl.bci.apirest.usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.bci.apirest.usuario.request.RegistroSistemaRequest;
import cl.bci.apirest.usuario.response.RegistroSistemaResponse;
import cl.bci.apirest.usuario.service.UsuarioService;

@RestController
@RequestMapping(path="/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(path="/registro", method=RequestMethod.POST)
	public RegistroSistemaResponse registro(@RequestBody RegistroSistemaRequest request) {
		return usuarioService.registro(request);
	}
}