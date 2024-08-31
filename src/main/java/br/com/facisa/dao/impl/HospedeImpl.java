package br.com.facisa.dao.impl;

import br.com.facisa.dao.HospedeDao;
import br.com.facisa.entities.Hospede;

import static br.com.facisa.database.Db.em;

public class HospedeImpl implements HospedeDao {

	@Override
	public void cadastrar(Hospede hospede) {
		em.getTransaction().begin();
		em.persist(hospede);
		em.getTransaction().commit();
	}

	@Override
	public void editar(Long id, Hospede hospede) {
		Hospede obj = em.find(Hospede.class, id);
		em.getTransaction().begin();
		editarHospede(obj, hospede);
		em.getTransaction().commit();

	}

	@Override
	public void excluir(Long id) {
		em.getTransaction().begin();
		Hospede hospede = em.find(Hospede.class, id);
		em.remove(hospede);
		em.getTransaction().commit();
	}

	private void editarHospede(Hospede obj, Hospede hospede) {
		obj.setEndereco(hospede.getEndereco());
		obj.setNascimento(hospede.getNascimento());
		obj.setNumero(hospede.getNumero());
		obj.setNome(hospede.getNome());
	}

	@Override
	public Hospede buscarPorId(Long id) {

		em.getTransaction().begin();
		Hospede hospede = em.find(Hospede.class, id);
		em.getTransaction().commit();
		return hospede;

	}
}
