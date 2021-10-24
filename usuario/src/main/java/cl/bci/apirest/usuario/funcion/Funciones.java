package cl.bci.apirest.usuario.funcion;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Funciones {
	
	public String generateUUID() {
		String resultado = "";
		UUID uuid = UUID.randomUUID();
		resultado = String.valueOf(uuid);
		return resultado;
	}
	
	public Boolean validateEmail(String email) {
		Boolean resultado = false;
		 Pattern pattern = Pattern
	                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	        Matcher mather = pattern.matcher(email);
	 
	        if (mather.find() == true) {
	            resultado = true;
	        } else {
	           resultado = false;
	        }
			return resultado;
	}
	
	public Boolean validatePassword(String regex, String password) {
		Boolean resultado = false;
		try {
			Pattern pattern = Pattern.compile(regex);
			Matcher mather = pattern.matcher(password);
			if (mather.find() == true) {
				resultado = true;
			} else {
				resultado = false;
			}
			
		} catch (Exception e) {
			System.out.println("error " + e.getMessage());
		}
		return resultado;
	}
	
}