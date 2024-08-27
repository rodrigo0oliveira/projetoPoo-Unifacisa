package br.com.facisa.services;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;

import br.com.facisa.dao.ReservaDao;
import br.com.facisa.dao.impl.ReservaImpl;
import br.com.facisa.dtos.ExtratoEstadia;
import br.com.facisa.entities.Quarto;
import br.com.facisa.entities.Reserva;
import br.com.facisa.entities.enums.Status;

public class ReservaService {

	private ReservaDao reservaDao;
	

	public ReservaService() {
		this.reservaDao = new ReservaImpl();
	}

	public String criarReserva(Reserva reserva) {
		try {
			
			if(reserva.getQuarto().getStatus()==Status.MANUTENCAO) {
				return "O quarto selecionado não está disponível!";
			}
			verificarCheckinECheckout(reserva);
			reserva.getQuarto().setStatus(Status.AGENDADO);
			reservaDao.criarReserva(reserva);
			return "Reserva criada";

		} catch (RuntimeException e) {
			return e.getMessage();

		}
	}

	public String excluirReserva(Long id) {
		try {
			Reserva reserva = reservaDao.buscarPorId(id);
			reserva.getQuarto().setStatus(Status.DISPONIVEL);
			reservaDao.cancelarReserva(id);

			return "Reserva excluida!";
		} catch (RuntimeException e) {
			return "Erro ao excluir reserva!";
		}
	}

	public List<Reserva> buscarReservasPorUsuario(Long id) {
		return reservaDao.visualizarReservasPorUsuario(id);
	}
	
	public void verificarHorarioDisponivel(Long id,LocalDate checkin,LocalDate checkout) {
		
			List<Quarto> list =reservaDao.verificarHorario(id, checkin, checkout);
			if(!list.isEmpty()) {
				throw new RuntimeException("Horário indisponível para reservar esse quarto!");
			}
		
	}
	
	

	public void verificarCheckinECheckout(Reserva reserva) {
		if (reserva.getCheckout().isBefore(reserva.getCheckin())) {
			throw new RuntimeException("A data de saída(checkout) deve ser posterior a data de entrada(checkin)!");
		}
	}
	
	public String calcularValorEstadia(Long id) {
		
		Reserva reserva = reservaDao.buscarPorId(id);
		if(reserva!=null) {
			BigDecimal precoHora = reserva.getQuarto().getPrecoHora();
			long dias = ChronoUnit.DAYS.between(reserva.getCheckin(), reserva.getCheckout());
			
			long  horas = dias*24;
			
			Double valorTotal = precoHora.doubleValue()*horas;
			
			ExtratoEstadia extrato = new ExtratoEstadia(reserva.getQuarto().getId()
					, reserva.getPessoa().getNome(), valorTotal, reserva.getCheckin(), reserva.getCheckout(), precoHora);
			
			return extrato.toString();
		}
		throw new RuntimeException("Reserva não encontrada!");
		
	}
	
	

}
