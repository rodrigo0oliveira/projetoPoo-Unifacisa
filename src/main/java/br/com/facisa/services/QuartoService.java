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
        return quartoDao.listarDisponiveis();
    }

    public List<Quarto> listarQuartos(){
        return quartoDao.listarTodos();
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
    	return quartoDao.buscarPorId(id);
    }
    
  
}
