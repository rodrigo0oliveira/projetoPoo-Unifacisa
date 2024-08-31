package br.com.facisa.resources;

import java.math.BigDecimal;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.facisa.dtos.QuartoDto;
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
				Tipo tipo = quartoService.verificarTipo();
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
				List<QuartoDto> listQuartosDiponiveis = quartoService.listarQuartosDisponiveis();
				JOptionPane.showMessageDialog(null,listQuartosDiponiveis.toString());
			}
			catch (RuntimeException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
			}
		
			break;

		}
		case "Buscar todos": {
			
			try {
				List<QuartoDto> listQuartos = quartoService.listarQuartos();
				JOptionPane.showMessageDialog(null,listQuartos.toString());
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
				Status status = quartoService.editarStatus();
				
				String message = quartoService.atualizarStatusQuarto(id, status);
				
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
