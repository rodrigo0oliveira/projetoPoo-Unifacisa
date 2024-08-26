package br.com.facisa.dao;

import java.util.List;

import br.com.facisa.entities.Quarto;
import br.com.facisa.entities.enums.Status;
import br.com.facisa.entities.enums.Tipo;

public interface QuartoDao {
	
	void criarQuarto(Quarto quarto);
	
	List<Quarto> listarDisponiveis();
	
	List<Quarto> listarTodos();
	
	void atualizarStatus(Long id,Status status);
	
	Quarto buscarPorId(Long id);
	
	List<Quarto> buscarPorTipo(Tipo tipo);

}
