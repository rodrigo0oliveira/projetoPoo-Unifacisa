package br.com.facisa.services;

import br.com.facisa.dao.ReservaDao;
import br.com.facisa.dao.impl.ReservaImpl;
import br.com.facisa.entities.Reserva;
import br.com.facisa.entities.enums.Status;

import java.util.List;

public class ReservaService {

    private ReservaDao reservaDao;

    public ReservaService(ReservaImpl reserva){
        this.reservaDao = reserva;
    }

    public String criarReserva(Reserva reserva){
        try{
            reserva.getQuarto().setStatus(Status.OCUPADO);
            reservaDao.criarReserva(reserva);
            return "Reserva criada";
        }catch (RuntimeException e){
            return "Erro ao criar reserva!";
        }
    }

    public String excluirReserva(Long id){
        try{
            Reserva reserva = reservaDao.buscarPorId(id);
            reserva.getQuarto().setStatus(Status.DISPONIVEL);
            reservaDao.cancelarReserva(id);

            return "Reserva excluida!";
        }
        catch (RuntimeException e){
            return "Erro ao excluir reserva!";
        }
    }

    public List<Reserva> buscarReservasPorUsuario(Long id){
       return reservaDao.visualizarReservasPorUsuario(id);
    }
}
