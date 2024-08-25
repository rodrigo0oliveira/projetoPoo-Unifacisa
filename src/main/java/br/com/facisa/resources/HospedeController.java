package br.com.facisa.resources;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import br.com.facisa.entities.Endereco;
import br.com.facisa.entities.Hospede;
import br.com.facisa.services.HospedeService;

public class HospedeController {
	
	public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	HospedeService hospedeService;
	
	public HospedeController() {
		this.hospedeService = new HospedeService();
	}

	public void HospedeController() {

		String[] opcoes = { "Cadastrar", "Editar", "Excluir" };

		Object selecionado = JOptionPane.showInputDialog(null, "Selecione", "Gerenciamento de hóspedes",
				JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

		String opcaoSelecionada = selecionado.toString();
		
		
		switch (opcaoSelecionada) {
		case "Cadastrar" : {
			
			try {
				
				String nome = JOptionPane.showInputDialog("Insira o nome do hóspede");
				String cpf = JOptionPane.showInputDialog("Insira o cpf do hóspede");
				String date = JOptionPane.showInputDialog("Digite a data de nascimento do hóspede no formato dd/MM/yyyy ");
				String numero  = JOptionPane.showInputDialog("Insira o número do hóspede");
				String pais = JOptionPane.showInputDialog("País","Insira o país do hóspede");
				String cidade = JOptionPane.showInputDialog("Cidade","Insira a cidade  do hóspede");
				
				LocalDate nascimento = LocalDate.parse(date,formatter);
				
				Endereco endereco = new Endereco(pais,cidade);
				
				Hospede hospede = new Hospede(cpf,nome,endereco,nascimento,numero);
				
				String message = hospedeService.cadastrarHospede(hospede);
				
				JOptionPane.showMessageDialog(null,message);
				
				
			}
			catch (RuntimeException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
			}
			break;
			
			
		}
		case "Editar" : {
			
			try {
				
				String identificador = JOptionPane.showInputDialog("Digite o id do hóspede :");
				Long id = Long.parseLong(identificador);
				String nome = JOptionPane.showInputDialog("Insira o novo nome do hóspede");
				String date = JOptionPane.showInputDialog("Digite a data de nascimento do hóspede no formato dd/MM/yyyy ");
				String numero  = JOptionPane.showInputDialog("Insira o novo número do hóspede");
				String pais = JOptionPane.showInputDialog("País","Insira o país do hóspede");
				String cidade = JOptionPane.showInputDialog("Cidade","Insira a cidade  do hóspede");
				
				LocalDate nascimento = LocalDate.parse(date,formatter);
				
				Endereco endereco = new Endereco(pais,cidade);
				
				Hospede hospede = new Hospede(nome, nascimento, endereco, numero);
				
				String message = hospedeService.editarHospede(id,hospede);
				
				JOptionPane.showMessageDialog(null,message);
				
			}
			catch (RuntimeException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
			}
			break;
			
		}
		case "Excluir" : {
			
			try {
				String identificador = JOptionPane.showInputDialog("Digite o id do hóspede :");
				Long id = Long.parseLong(identificador);
				
				String message = hospedeService.excluirHospede(id);
				
				JOptionPane.showMessageDialog(null,message);
			}
			catch (RuntimeException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
			}
			break;
		}
		default:
		
		}
		

	}

}
