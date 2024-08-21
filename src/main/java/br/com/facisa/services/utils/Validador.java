package br.com.facisa.services.utils;

public class Validador {
	
	public void validarCpf(String cpf) {
		if(cpf.length()!=11||cpf.matches("[A-Z]*")) {
			throw new RuntimeException("CPF inválido!");
		}
	}

}
