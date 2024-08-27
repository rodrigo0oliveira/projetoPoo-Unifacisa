package br.com.facisa.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ExtratoEstadiaDto(
		Long quartoId,String hospedeNome,Double valor
		,LocalDate checkin,LocalDate checkout,BigDecimal precoHora) {

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Quarto ").append(quartoId).append("\n");
		sb.append("\n");
		sb.append("Nome do hóspede : ").append(hospedeNome).append("\n");
		sb.append("Data de entrada : ").append(checkin).append("\n");
		sb.append("Data de saída : ").append(checkout).append("\n");
		sb.append("Valor por hora -> R$").append(precoHora).append("\n");
		sb.append("\n");
		sb.append("Valor total da estadia R$").append(valor).append("\n");
		
		return sb.toString();
	}

	
}
