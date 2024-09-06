package br.com.facisa.dao.impl;

import static br.com.facisa.database.Db.em;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.facisa.dao.FuncionarioDao;
import br.com.facisa.entities.Funcionario;
import jakarta.persistence.Query;

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

	@Override
	public List<Funcionario> listarTodos() {
		em.getTransaction().begin();
		String hql = "FROM Funcionario";
		TypedQuery<Funcionario> query = em.createQuery(hql,Funcionario.class);
		List<Funcionario> list = query.getResultList();
		em.getTransaction().commit();
		return list;
	}
}
