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
		Query<Reserva> query = (Query<Reserva>) em.createQuery("SELECT e FROM tb_reservas WHERE pessoa_id = id").setParameter("id", id)
				.getResultList();
		List<Reserva> list = query.getResultList();
		return list;
	}

}
