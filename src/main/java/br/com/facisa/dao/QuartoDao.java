package br.com.facisa.dao;

import java.util.List;

import br.com.facisa.entities.Quarto;
import br.com.facisa.entities.enums.Status;

public interface QuartoDao {
	
	void criarQuarto(Quarto quarto);
	
	List<Quarto> listarDisponiveis();
	
	List<Quarto> listarTodos();
	
	void atualizarStatus(Long id,Status status);

}
