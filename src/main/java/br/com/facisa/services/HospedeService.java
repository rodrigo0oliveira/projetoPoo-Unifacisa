package br.com.facisa.services;

import br.com.facisa.dao.HospedeDao;
import br.com.facisa.dao.impl.HospedeImpl;
import br.com.facisa.entities.Hospede;
import br.com.facisa.services.utils.Validador;

public class HospedeService {
	
	private HospedeDao hospedeDao;
	
	private Validador validador;
	
	public HospedeService() {
		this.hospedeDao = new HospedeImpl();
		this.validador = new Validador();
	}
	
	public String cadastrarHospede(Hospede hospede) {
		//validarCadastro
		verificarCamposHospede(hospede);
		validador.validarCpf(hospede.getCpf());
		
		//Persistir dados
		this.hospedeDao.cadastrar(hospede);
		
		return "Hóspede cadastrado com sucesso!";
	}
	
	public String editarHospede(Long id,Hospede hospede) {
		try {
			this.hospedeDao.editar(id, hospede);
			return "Hóspede editado!";
		}
		catch (RuntimeException e) {
			return "Erro ao editar hóspede!";
		}
		
	}
	
	public String excluirHospede(Long id) {
		try {
			this.hospedeDao.excluir(id);
			return "Hóspede excluído";
		}
		catch (RuntimeException e) {
			return "Erro ao excluir hóspede";
		}
	}
	
	public Hospede buscarPorId(Long id) {
		return hospedeDao.buscarPorId(id);
	}
	
	
	private void verificarCamposHospede(Hospede hospede) {
		if(hospede.getNascimento()==null
				||hospede.getCpf()==null
				||hospede.getEndereco()==null
				||hospede.getNome()==null
				||hospede.getNumero()==null
				
				) {
			throw new RuntimeException("Por favor, preencha todos os campos obrigatórios");
		}
	}

}
