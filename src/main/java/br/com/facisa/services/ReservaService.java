package br.com.facisa.services;

import br.com.facisa.dao.ReservaDao;
import br.com.facisa.dao.impl.ReservaImpl;
import br.com.facisa.entities.Reserva;
import br.com.facisa.entities.enums.Status;

import java.util.List;

public class ReservaService {

	private ReservaDao reservaDao;
	

	public ReservaService() {
		this.reservaDao = new ReservaImpl();
	}

	public String criarReserva(Reserva reserva) {
		try {
			
			if(reserva.getQuarto().getStatus()!=Status.DISPONIVEL) {
				return "O quarto selecionado não está disponível!";
			}

			reserva.getQuarto().setStatus(Status.AGENDADO);
			verificarCheckinECheckout(reserva);
			reservaDao.criarReserva(reserva);
			return "Reserva criada";

		} catch (RuntimeException e) {
			return "Erro ao criar reserva!";

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
	
	

	public void verificarCheckinECheckout(Reserva reserva) {
		if (reserva.getCheckout().isBefore(reserva.getCheckin())) {
			throw new RuntimeException("A data de saída(checkout) deve ser posterior a data de entrada(checkin)!");
		}
	}
	
	

}
