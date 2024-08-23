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
		
		JOptionPane.showMessageDialog(null, "Sistema de " + "gerenciamento do hotel");

		Db.openConnection();
		boolean rodar = true;

		while (rodar) {
			

			String[] opcoes = { "Funcionário", "Hóspede", "Reserva", "Quarto" };

			Object selecionado = JOptionPane.showInputDialog(null, "Selecione ", "Escolha o que quer gerenciar",
					JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

			String opcaoSelecionada = selecionado.toString();

			switch (opcaoSelecionada) {

			case "Funcionário": {
				funcionarioController.FuncionarioController();

			}
			case "Hóspede": {
				hospedeController.HospedeController();

			}
			case "Reserva": {
				reservaController.ReservaController();
			}
			case "Quarto": {
				quartoController.QuartoController();
			}
			int continuar = JOptionPane.showConfirmDialog(null, "Deseja continuar ?","Input",JOptionPane.YES_NO_OPTION);
			if(continuar == 1) {
				Db.closeConnection();
				JOptionPane.showMessageDialog(null, "Gerenciamento encerrado!");
				rodar = false;
			}
			default:
				
			}

		}

	}
}
