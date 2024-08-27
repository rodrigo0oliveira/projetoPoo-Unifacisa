package br.com.facisa.dao.impl;

import static br.com.facisa.database.Db.em;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.query.Query;

import br.com.facisa.dao.ReservaDao;
import br.com.facisa.entities.Quarto;
import br.com.facisa.entities.Reserva;

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

	@Override
	public List<Quarto> verificarHorario(Long id, LocalDate checkin, LocalDate checkout) {
		em.getTransaction().begin();
		
		String hql = "FROM Reserva WHERE quarto_id = : id "
				+ "AND checkin < : checkout "
				+ "AND checkout > : checkin  ";
		
		Query query = (Query) em.createQuery(hql);
		query.setParameter("id", id);
		query.setParameter("checkin", checkin);
		query.setParameter("checkout", checkout);
		
		List<Quarto> list = query.getResultList();
		em.getTransaction().commit();
		
		return list;
	}

	

}
