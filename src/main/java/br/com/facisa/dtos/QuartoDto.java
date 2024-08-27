package br.com.facisa.dtos;

import java.math.BigDecimal;

import br.com.facisa.entities.enums.Tipo;

public record QuartoDto(Long id,BigDecimal precoHora,Tipo tipo) {
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Quarto ").append(id).
		append("|Preço/Hora R$").
		append(precoHora).
		append("|Tipo : ").
		append(tipo).append("\n");
		
		return sb.toString();
		
	}

}
