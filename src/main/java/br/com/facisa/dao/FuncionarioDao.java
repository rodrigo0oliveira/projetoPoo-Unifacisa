package br.com.facisa.dao;

import java.util.List;

import br.com.facisa.entities.Funcionario;

public interface FuncionarioDao {

    void cadastrar(Funcionario funcionario);

    void editar(Long id,Funcionario funcionario);

    void excluir(Long id);
    
    List<Funcionario> listarTodos();
}
