package br.com.facisa.resources;

import java.math.BigDecimal;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.facisa.entities.Quarto;
import br.com.facisa.entities.enums.Status;
import br.com.facisa.entities.enums.Tipo;
import br.com.facisa.services.QuartoService;

public class QuartoController {

	QuartoService quartoService;

	public QuartoController() {
		this.quartoService = new QuartoService();
	}

	public void QuartoController() {

		String[] opcoes = { "Cadastrar", "Buscar quartos disponíveis", "Buscar todos", "Editar status do quarto" };

		Object selecionado = JOptionPane.showInputDialog(null, "Selecione", "Gerenciamento de quartos",
				JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

		String opcaoSelecionada = selecionado.toString();

		switch (opcaoSelecionada) {

		case "Cadastrar": {
			try {
				Tipo tipo = verificarTipo();
				String capacidadeString = JOptionPane.showInputDialog("Digite a capacidade do quarto :");
				String precoString = JOptionPane.showInputDialog("Digite o preço por hora do quarto :");
				
				
				int capacidade = Integer.parseInt(capacidadeString);
				BigDecimal preco = new BigDecimal(precoString);
				
				Quarto quarto = new Quarto(capacidade,preco,tipo);
				
				String message = quartoService.criarQuarto(quarto);
				
				JOptionPane.showMessageDialog(null,message);
				
			}
			catch (RuntimeException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
			}
			break;

		}
		case "Buscar quartos disponíveis": {
			
			try {
				List<Quarto> listQuartosDiponiveis = quartoService.listarQuartosDisponiveis();
				JOptionPane.showMessageDialog(null,listQuartosDiponiveis);
			}
			catch (RuntimeException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
			}
		
			break;

		}
		case "Buscar todos": {
			
			try {
				List<Quarto> listQuartos = quartoService.listarQuartos();
				JOptionPane.showMessageDialog(null,listQuartos);
			}
			catch (RuntimeException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
			}
			break;

		}
		case "Editar status do quarto": {
			try {
				String identificador = JOptionPane.showInputDialog("Digite o id do quarto :");
				Long id = Long.parseLong(identificador);
				Status status = editarStatus();
				
				quartoService.atualizarStatusQuarto(id, status);
			}
			catch (RuntimeException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
			}
			break;
			
		}
		default:

		}

	}

	private Tipo verificarTipo() {

		String[] turnos = { "Solteiro", "Casal", "Suite" };
		Object turnoEscolha = JOptionPane.showInputDialog(null, "Selecione", "Tipo do quarto",
				JOptionPane.INFORMATION_MESSAGE, null, turnos, turnos[0]);
		
		String escolha = turnoEscolha.toString();

		switch (escolha) {
		case "Solteiro" : {
			return Tipo.SOLTEIRO;
		}
		case "Casal" : {
			return Tipo.CASAL;
		}
		case "Suite" : {
			return Tipo.SUITE;
		}
		default:
			
		}
		return null;

	}
	
	private Status editarStatus() {
		
		String[] turnos = { "Ocupado", "Manutenção", "Disponível" };
		Object turnoEscolha = JOptionPane.showInputDialog(null, "Selecione", "Editar Status do quarto",
				JOptionPane.INFORMATION_MESSAGE, null, turnos, turnos[0]);
		
		String escolha = turnoEscolha.toString();

		switch (escolha) {
		case "Ocupado" : {
			return Status.OCUPADO;
		}
		case "Manutenção" : {
			return Status.MANUTENCAO;
		}
		case "Disponível" : {
			return Status.DISPONIVEL;
		}
		default:
			
		}
		return null;
		
	}
	


}
