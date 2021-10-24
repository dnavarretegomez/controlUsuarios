package cl.bci.apirest.usuario.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.bci.apirest.usuario.funcion.Funciones;
import cl.bci.apirest.usuario.model.Auditoria;
import cl.bci.apirest.usuario.model.Phone;
import cl.bci.apirest.usuario.model.Usuario;
import cl.bci.apirest.usuario.repository.AuditoriaRepository;
import cl.bci.apirest.usuario.repository.PhoneRepository;
import cl.bci.apirest.usuario.repository.UsuarioRepository;
import cl.bci.apirest.usuario.request.RegistroSistemaRequest;
import cl.bci.apirest.usuario.response.DatosRegistroResponse;
import cl.bci.apirest.usuario.response.MensajeResponse;
import cl.bci.apirest.usuario.response.RegistroSistemaResponse;
import cl.bci.apirest.usuario.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//@Autowired
	//private PhoneRepository phoneRepository;
	
	@Autowired
	private AuditoriaRepository auditoriaRepository;
	
	@Override
	public RegistroSistemaResponse registro(RegistroSistemaRequest request) {
		RegistroSistemaResponse response = new RegistroSistemaResponse();
		DatosRegistroResponse datosResponse = new DatosRegistroResponse();
		MensajeResponse mensajeResponse = new MensajeResponse();
		Auditoria auditoria = new Auditoria();
		Funciones funcion = new Funciones();
		List<Phone> phones = new ArrayList<>();
		Usuario usuario = new Usuario();
		int flagCorreoExistente =0;
		boolean flagFormatoPassword = false;
		try {
			if (funcion.validateEmail(request.getEmail()) == true) {
				flagCorreoExistente = usuarioRepository.countEmail(request.getEmail());
				if (flagCorreoExistente != 1) {
					flagFormatoPassword = funcion.validatePassword(
							"^(?=.*\\d)(?=.*[\\u0021-\\u002b\\u003c-\\u0040])(?=.*[A-Z])(?=.*[a-z])\\S{8,16}$",
							request.getPassword());
					if (flagFormatoPassword == true) {
						// guardo phone
						for (int i = 0; i < request.getPhones().size(); i++) {
							Phone phone = new Phone();
							phone.setNumber(request.getPhones().get(i).getNumber());
							phone.setCitycode(request.getPhones().get(i).getCitycode());
							phone.setContrycode(request.getPhones().get(i).getContrycode());
							phone.setFkUsuario(usuario);
							phones.add(phone);
						}
						// guardo usuario

						usuario.setName(request.getName());
						usuario.setEmail(request.getEmail());
						usuario.setPassword(request.getPassword());
						usuario.setPhones(phones);
						usuarioRepository.save(usuario);

						String token = funcion.generateUUID();
						// set datos auditoria
						auditoria.setId(token);
						auditoria.setCreated(Calendar.getInstance().getTime());
						auditoria.setModified(Calendar.getInstance().getTime());
						auditoria.setLast_login(Calendar.getInstance().getTime());
						auditoria.setToken(token);
						auditoria.setIsactive(true);
						auditoria.setFkUsuario(usuario);
						auditoriaRepository.save(auditoria);

						// set response
						datosResponse.setId(auditoria.getToken());
						datosResponse
								.setCreated(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(auditoria.getCreated()));
						datosResponse.setModified(
								new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(auditoria.getModified()));
						datosResponse.setLast_login(
								new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(auditoria.getLast_login()));
						datosResponse.setToken(auditoria.getToken());
						datosResponse.setIsactive(auditoria.isIsactive());

						mensajeResponse.setCodigo(200);
						mensajeResponse.setMensaje("Operación exitosa");

					} else {
						mensajeResponse.setCodigo(400);
						mensajeResponse.setMensaje(
								"La contraseña debe tener al entre 8 y 16 caracteres, al menos un dígito, al menos una minúscula, al menos una mayúscula y al menos un caracter no alfanumérico.");
					}
				} else {
					mensajeResponse.setCodigo(400);
					mensajeResponse.setMensaje("Bad Request. correo ya registrado");
				}
			} else {
				mensajeResponse.setCodigo(400);
				mensajeResponse.setMensaje("Campo Email incorrecto. Ingrese un correo válido (aaaaaaa@dominio.cl)");
			}
			
		}catch (Exception e) {
			mensajeResponse.setCodigo(500);
			mensajeResponse.setMensaje("Operación fallida");
		}
		response.setDatos(datosResponse);
		response.setMensaje(mensajeResponse);
		return response;
	}
}