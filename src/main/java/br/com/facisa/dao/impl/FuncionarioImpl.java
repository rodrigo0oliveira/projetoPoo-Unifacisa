package br.com.facisa.dao.impl;

import br.com.facisa.dao.FuncionarioDao;
import br.com.facisa.entities.Funcionario;

import static br.com.facisa.database.Db.em;

public class FuncionarioImpl implements FuncionarioDao {

    @Override
    public void cadastrar(Funcionario funcionario) {
        em.getTransaction().begin();
        em.persist(funcionario);
        em.getTransaction().commit();
    }

    @Override
    public void editar(Long id, Funcionario funcionario) {
        em.getTransaction().begin();
        Funcionario obj = em.find(Funcionario.class,id);
        editarFuncionario(obj,funcionario);
        em.getTransaction().commit();
    }

    @Override
    public void excluir(Long id) {
        em.getTransaction().begin();
        em.find(Funcionario.class,id);
        Funcionario funcionario = em.find(Funcionario.class,id);
        em.remove(funcionario);
        em.getTransaction().commit();
    }

    private void editarFuncionario(Funcionario obj,Funcionario funcionario){
        obj.setNome(funcionario.getNome());
        obj.setCargo(funcionario.getCargo());
        obj.setSalario(funcionario.getSalario());
        obj.setTurno(funcionario.getTurno());
    }
}
