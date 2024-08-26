package br.com.facisa.services;

import br.com.facisa.dao.QuartoDao;
import br.com.facisa.dao.impl.QuartoImpl;
import br.com.facisa.entities.Quarto;
import br.com.facisa.entities.enums.Status;

import java.util.List;

public class QuartoService {

    private QuartoDao quartoDao;

    public QuartoService(){
        this.quartoDao = new QuartoImpl();
    }

    public String criarQuarto (Quarto quarto){
        try{
            quartoDao.criarQuarto(quarto);
            return "Quarto criado!";
        }catch (RuntimeException e){
            return "Erro ao criar quarto";
        }
    }

    public List<Quarto> listarQuartosDisponiveis(){
    	List<Quarto> list = quartoDao.listarDisponiveis();
        if(list.isEmpty()) {
        	throw new RuntimeException("Não existem quartos disponíveis no momento!");
        }
        return list;
    }

    public List<Quarto> listarQuartos(){
        List<Quarto> list = quartoDao.listarTodos();
        if(list.isEmpty()) {
        	throw new RuntimeException("Não existem quartos cadastrados!");
        }
        return list;
    }

    public String atualizarStatusQuarto(Long id, Status status){
        try{
            quartoDao.atualizarStatus(id,status);
            return "Quarto atualizado!";
        }catch (RuntimeException e){
            return "Erro ao atualizar o quarto";
        }
    }
    
    public Quarto buscarPorId(Long id) {
    	
    	Quarto quarto = quartoDao.buscarPorId(id);
    	if(quarto==null) {
    		throw new RuntimeException("Quarto não encontrado!");
    	}
    	return quarto;
    	
    }
    
  
}
