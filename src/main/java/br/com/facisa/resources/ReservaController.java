package br.com.facisa.resources;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.facisa.entities.Hospede;
import br.com.facisa.entities.Quarto;
import br.com.facisa.entities.Reserva;
import br.com.facisa.services.HospedeService;
import br.com.facisa.services.QuartoService;
import br.com.facisa.services.ReservaService;

public class ReservaController {
	
	public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	ReservaService reservaService;
	
	HospedeService hospedeService;
	
	QuartoService quartoService;
	
	public ReservaController() {
		this.reservaService = new ReservaService();
		this.hospedeService = new HospedeService();
		this.quartoService = new QuartoService();
	}
	
	public void ReservaController() {
		
		String [] opcoes = {"Criar reserva","Buscar Reservas de determinado hóspede","Excluir reserva"};
		
		Object selecionado = JOptionPane.showInputDialog(null, 
				"Selecione", "Gerenciamento de reservas", JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
		
		String opcaoSelecionada = selecionado.toString();
		
		switch (opcaoSelecionada) {
		case "Criar reserva" : {
			
			try {
				
				String checkinString = JOptionPane.showInputDialog("Digite a data de entrada no formato dd/MM/yyyy ");
				String checkoutString = JOptionPane.showInputDialog("Digite a data de saída no formato dd/MM/yyyy ");
				String identificadorHospede = JOptionPane.showInputDialog("Digite o id do hóspede :");
				Long idHospede = Long.parseLong(identificadorHospede);
				String identificadorQuarto = JOptionPane.showInputDialog("Digite o id do quarto :");
				Long idQuarto = Long.parseLong(identificadorQuarto);
				
				Hospede hospede = hospedeService.buscarPorId(idHospede);
				Quarto quarto = quartoService.buscarPorId(idQuarto);
				
				LocalDate checkin = LocalDate.parse(checkinString,formatter);
				LocalDate checkout = LocalDate.parse(checkoutString,formatter);
				
				
				Reserva reserva = new Reserva(checkin,checkout,hospede,quarto);
				
				String message = reservaService.criarReserva(reserva);
				
				JOptionPane.showMessageDialog(null,message);
				
			}
			catch (RuntimeException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
			}
			break;
			
			
		}
		case "Buscar Reservas de determinado hóspede": {
			
			String identificadorHospede = JOptionPane.showInputDialog("Digite o id do hóspede :");
			Long idHospede = Long.parseLong(identificadorHospede);
			
			List<Reserva> listReserva =  reservaService.buscarReservasPorUsuario(idHospede);
			
			JOptionPane.showMessageDialog(null,listReserva);
			break;
		}
		case "Excluir reserva" : {
			
			String identificadorReserva = JOptionPane.showInputDialog("Digite o id da reserva :");
			Long idReserva = Long.parseLong(identificadorReserva);
			
			String message = reservaService.excluirReserva(idReserva);
			
			JOptionPane.showMessageDialog(null,message);
			break;
			
		}
		default:
			
		}
		
	}
	


	
	
	
	
	

}
