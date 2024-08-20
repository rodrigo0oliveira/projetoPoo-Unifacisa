package br.com.facisa.dao;

import java.util.List;

import br.com.facisa.entities.Reserva;

public interface ReservaDao {
	
	void criarReserva(Reserva reserva);
	
	void cancelarReserva(Long id);
	
	List<Reserva> visualizarReservasPorUsuario (Long id);
}
