package br.com.facisa.dao.impl;

import static br.com.facisa.database.Db.em;

import java.util.List;

import org.hibernate.query.Query;

import br.com.facisa.dao.QuartoDao;
import br.com.facisa.entities.Quarto;
import br.com.facisa.entities.enums.Status;
import br.com.facisa.entities.enums.Tipo;

public class QuartoImpl implements QuartoDao {

	@Override
	public void criarQuarto(Quarto quarto) {
		em.getTransaction().begin();
		em.persist(quarto);
		em.getTransaction().commit();
	}

	@Override
	public List<Quarto> listarDisponiveis() {
		em.getTransaction().begin();
		String hql = "FROM Quarto WHERE status = :status";

		Query query = (Query) em.createQuery(hql);

		query.setParameter("status", Status.DISPONIVEL);
		List<Quarto> list = query.getResultList();
		
		em.getTransaction().commit();
		
		return list;
	}

	@Override
	public List<Quarto> listarTodos() {
		
		em.getTransaction().begin();
		String hql = "FROM Quarto";
		Query query = (Query) em.createQuery(hql,Quarto.class);
		List<Quarto> list = query.getResultList();
		em.getTransaction().commit();
		return list;
		
	}

	@Override
	public void atualizarStatus(Long id, Status status) {
		em.getTransaction().begin();
		Quarto quarto = em.find(Quarto.class, id);
		quarto.getStatus().setName(status.getName());
		em.getTransaction().commit();
	}

	@Override
	public Quarto buscarPorId(Long id) {
		em.getTransaction().begin();
		Quarto quarto = em.find(Quarto.class, id);
		em.getTransaction().commit();
		
		return quarto;
		
	}

	@Override
	public List<Quarto> buscarPorTipo(Tipo tipo) {
		em.getTransaction().begin();
		String hql = "FROM Quarto WHERE tipo = :tipo";
		Query query = (Query) em.createQuery(hql,QuartoDao.class);
		
		List<Quarto> list = query.getResultList();
		
		em.getTransaction().commit();
		
		return list;
	}

}
