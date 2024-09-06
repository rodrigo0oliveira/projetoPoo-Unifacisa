package br.com.facisa.resources;

import javax.swing.*;

import br.com.facisa.database.Db;

public class MainController {

	FuncionarioController funcionarioController;

	HospedeController hospedeController;

	ReservaController reservaController;

	QuartoController quartoController;

	public MainController() {

		this.funcionarioController = new FuncionarioController();
		this.hospedeController = new HospedeController();
		this.reservaController = new ReservaController();
		this.quartoController = new QuartoController();

	}

	public void main() {
		
		JOptionPane.showMessageDialog(null, "Sistema de Gerenciamento do Hotel");

		Db.openConnection();
		boolean rodar = true;

		while (rodar) {
			

			String[] opcoes = { "Funcionário", "Hóspede", "Reserva", "Quarto", "Sair" };

			Object selecionado = JOptionPane.showInputDialog(null, "Selecione ", "Escolha o que quer gerenciar",
					JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

			String opcaoSelecionada = selecionado.toString();

			switch (opcaoSelecionada) {

			case "Funcionário": {
				funcionarioController.FuncionarioController();
				break;
			}
			case "Hóspede": {
				hospedeController.HospedeController();
				break;
			}
			case "Reserva": {
				reservaController.ReservaController();
				break;
			}
			case "Quarto": {
				quartoController.QuartoController();
				break;
			}
			case "Sair" : {
				JOptionPane.showMessageDialog(null, "Gerenciamento encerrado!");
				Db.closeConnection();
				rodar = false;
			}
			
			default:
				
			}

		}

	}
}
