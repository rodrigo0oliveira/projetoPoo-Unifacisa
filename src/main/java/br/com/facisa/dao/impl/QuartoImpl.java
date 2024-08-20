package br.com.facisa.dao.impl;

import static br.com.facisa.database.Db.em;

import java.util.List;


import org.hibernate.query.Query;

import br.com.facisa.dao.QuartoDao;
import br.com.facisa.entities.Quarto;
import br.com.facisa.entities.enums.Status;

public class QuartoImpl implements QuartoDao{

	@Override
	public void criarQuarto(Quarto quarto) {
		em.getTransaction().begin();
		em.persist(quarto);
		em.getTransaction().commit();
	}

	@Override
	public List<Quarto> listarDisponiveis() {
		em.getTransaction().begin();
		Query<Quarto> query = (Query<Quarto>) em.createQuery("SELECT E FROM tb_quartos where status = DISPONIVEL");
		List<Quarto> list = query.getResultList();
		return list;
	}

	@Override
	public List<Quarto> listarTodos() {
		em.getTransaction().begin();
		Query<Quarto> query = (Query<Quarto>) em.createQuery("SELECT * FROM tb_quartos");
		List<Quarto> list = query.getResultList();
		return list;
	}

	@Override
	public void atualizarStatus(Long id, Status status) {
		em.getTransaction().begin();
		Quarto quarto = em.find(Quarto.class, id);
		quarto.getStatus().setName(status.getName());
		em.getTransaction().commit();
	}

}
