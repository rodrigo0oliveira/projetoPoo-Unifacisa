package br.com.facisa.services;

import br.com.facisa.dao.FuncionarioDao;
import br.com.facisa.dao.impl.FuncionarioImpl;
import br.com.facisa.entities.Funcionario;
import br.com.facisa.services.utils.Validador;

public class FuncionarioService {
	
	private FuncionarioDao funcionarioImpl;
	
	private Validador validador;
	
	public FuncionarioService(FuncionarioImpl funcionarioImpl,Validador validador) {
		this.funcionarioImpl = funcionarioImpl;
		this.validador = validador;
	}
	
	public String cadastrarFuncionario(Funcionario funcionario) {
		//validarCampos
		validarCamposFuncionario(funcionario);
		validador.validarCpf(funcionario.getCpf());
		
		//persistir dados
		funcionarioImpl.cadastrar(funcionario);
		
		return "Novo funcionário cadastrado com sucesso!";
	}
	
	public String editarFuncionario(Long id,Funcionario funcionario) {
		try {
			funcionarioImpl.editar(id, funcionario);
			return "Funcionário editado com sucesso!";
		}
		catch (RuntimeException e) {
			return "Erro ao editar usuário";
		}
	}

	public String excluirFuncionario(Long id){
		try{
			funcionarioImpl.excluir(id);
			return "Funcionario excluido com sucesso!";
		}
		catch (RuntimeException e){
			return "Erro ao excluir funcionario";
		}
	}
	
	private void validarCamposFuncionario(Funcionario funcionario) {
		if(funcionario.getCpf()==null
				||funcionario.getNome()==null
				||funcionario.getSalario()==null
				||funcionario.getCargo() == null
				||funcionario.getTurno() == null
				) {
			throw new RuntimeException("Por favor, preencha todos os campos obrigatórios");
		}
	}

}
