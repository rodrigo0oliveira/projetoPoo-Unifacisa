package br.com.facisa.dao.impl;

import br.com.facisa.dao.ReservaDao;
import br.com.facisa.entities.Reserva;
import static br.com.facisa.database.Db.em;

import java.util.List;

import org.hibernate.query.Query;

public class ReservaImpl implements ReservaDao{

	@Override
	public void criarReserva(Reserva reserva) {
		em.getTransaction().begin();
		em.persist(reserva);
		em.getTransaction().commit();
	}

	@Override
	public void cancelarReserva(Long id) {
		em.getTransaction().begin();
		Reserva reserva = em.find(Reserva.class, id);
		em.remove(reserva);
		em.getTransaction().commit();
	}

	@Override
	public List<Reserva> visualizarReservasPorUsuario(Long id) {
		em.getTransaction().begin();
		
		String hql = "FROM Reserva WHERE pessoa_id = : id";
		Query query = (Query) em.createQuery(hql);
		query.setParameter("id", id);
		
		List<Reserva> list = query.getResultList();
		
		em.getTransaction().commit();
		return list;
	}

	@Override
	public Reserva buscarPorId(Long id) {
		em.getTransaction().begin();
        Reserva reserva = em.find(Reserva.class,id);
        em.getTransaction().commit();
        return reserva;
	}

}
