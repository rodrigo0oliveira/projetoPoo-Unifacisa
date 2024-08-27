package br.com.facisa.dao;

import java.time.LocalDate;
import java.util.List;

import br.com.facisa.entities.Quarto;
import br.com.facisa.entities.Reserva;

public interface ReservaDao {
	
	void criarReserva(Reserva reserva);
	
	void cancelarReserva(Long id);
	
	List<Reserva> visualizarReservasPorUsuario (Long id);

	Reserva buscarPorId(Long id);
	
	List<Quarto> verificarHorario(Long id,LocalDate checkin,LocalDate checkout);
}
