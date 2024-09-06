package br.com.facisa.resources;

import java.math.BigDecimal;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.facisa.entities.Funcionario;
import br.com.facisa.services.FuncionarioService;

public class FuncionarioController {

	FuncionarioService funcionarioService;

	public FuncionarioController() {
		funcionarioService = new FuncionarioService();
	}

	public void FuncionarioController() {

		String[] opcoes = { "Cadastrar", "Editar", "Excluir", "Listar todos os funcionários" };

		Object selecionado = JOptionPane.showInputDialog(null, "Selecione", "Gerenciamento de funcionário",
				JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

		String opcaoSelecionada = selecionado.toString();

		switch (opcaoSelecionada) {

		case "Cadastrar": {

			try {
				String nome = JOptionPane.showInputDialog("Insira o nome do funcionário");
				String cpf = JOptionPane.showInputDialog("Insira o cpf do funcionário");
				String cargo = JOptionPane.showInputDialog("Insira o cargo do funcionário");
				String salarioString = JOptionPane.showInputDialog("Insira o salário do funcionário");

				BigDecimal salario = new BigDecimal(salarioString);

				String turno = verificarTurno();

				Funcionario funcionario = new Funcionario(cpf, nome, cargo, salario, turno);

				String message = funcionarioService.cadastrarFuncionario(funcionario);

				JOptionPane.showMessageDialog(null, message);

			} catch (RuntimeException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
			}
			break;
		}
		case "Editar": {

			try {
				String identificador = JOptionPane.showInputDialog("Digite o id do funcionário :");
				Long id = Long.parseLong(identificador);
				String nome = JOptionPane.showInputDialog("Insira o novo nome do funcionário");
				String cargo = JOptionPane.showInputDialog("Insira o novo cargo do funcionário");
				String salarioString = JOptionPane.showInputDialog("Insira o novo salário do funcionário");

				BigDecimal salario = new BigDecimal(salarioString);

				String turno = verificarTurno();

				Funcionario funcionario = new Funcionario(nome, cargo, salario, turno);

				String message = funcionarioService.editarFuncionario(id, funcionario);

				JOptionPane.showMessageDialog(null, message);
			} catch (RuntimeException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
			}
			break;

		}
		case "Excluir": {
			try {
				String identificador = JOptionPane.showInputDialog("Digite o id do funcionário :");
				Long id = Long.parseLong(identificador);

				String message = funcionarioService.excluirFuncionario(id);

				JOptionPane.showMessageDialog(null, message);
			} catch (RuntimeException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
			}
			break;
		}
		case "Listar todos os funcionários": {

			List<Funcionario> list = funcionarioService.listarTodos();
			if (list.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Não existem funcionários cadastrados!");
			} else {
				JOptionPane.showMessageDialog(null, list);
			}
			break;

		}

		default:

		}
	}

	private String verificarTurno() {

		String[] turnos = { "Manhã", "Tarde", "Noite" };
		Object turnoEscolha = JOptionPane.showInputDialog(null, "Selecione", "Gerenciamento de funcionário",
				JOptionPane.INFORMATION_MESSAGE, null, turnos, turnos[0]);

		return turnoEscolha.toString();

	}

}
