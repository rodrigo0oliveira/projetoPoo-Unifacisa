package br.com.facisa.dao;

import java.util.List;

import br.com.facisa.entities.Funcionario;
import br.com.facisa.entities.Hospede;

public interface HospedeDao {

    void cadastrar(Hospede hospede);

    void editar(Long id,Hospede hospede);

    void excluir(Long id);
    
    Hospede buscarPorId(Long id);
    
    List<Hospede> listarTodos();
    
    
}
