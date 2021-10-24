package cl.bci.apirest.usuario.funcion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class prueba {

	public static void main(String[] args) {
		Boolean resultado = false;
		Pattern pattern = Pattern.compile(
				"^(?=.*\\d)(?=.*[\\u0021-\\u002b\\u003c-\\u0040])(?=.*[A-Z])(?=.*[a-z])\\S{8,16}$");
		Matcher mather = pattern.matcher("Nacho1234@");

		if (mather.find() == true) {
			resultado = true;
		} else {
			resultado = false;
		}
		System.out.println(resultado);
	}
}