package br.com.facisa.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.facisa.dao.QuartoDao;
import br.com.facisa.dao.impl.QuartoImpl;
import br.com.facisa.dtos.QuartoDto;
import br.com.facisa.entities.Quarto;
import br.com.facisa.entities.enums.Status;
import br.com.facisa.entities.enums.Tipo;

public class QuartoService {

	private QuartoDao quartoDao;

	public QuartoService() {
		this.quartoDao = new QuartoImpl();
	}

	public String criarQuarto(Quarto quarto) {
		try {
			quartoDao.criarQuarto(quarto);
			return "Quarto criado!";
		} catch (RuntimeException e) {
			return "Erro ao criar quarto";
		}
	}

	public List<QuartoDto> listarQuartosDisponiveis() {
		List<Quarto> list = quartoDao.listarDisponiveis();
		if (list.isEmpty()) {
			throw new RuntimeException("Não existem quartos disponíveis no momento!");
		}
		List<QuartoDto> listDto = retornarQuartosDtos(list);
		return listDto;
	}

	public List<QuartoDto> listarQuartos() {
		List<Quarto> list = quartoDao.listarTodos();
		if (list.isEmpty()) {
			throw new RuntimeException("Não existem quartos cadastrados!");
		}
		List<QuartoDto> listDto = retornarQuartosDtos(list);
		return listDto;
	}

	public String atualizarStatusQuarto(Long id, Status status) {
		try {
			quartoDao.atualizarStatus(id, status);
			return "Quarto atualizado!";
		} catch (RuntimeException e) {
			return "Erro ao atualizar o quarto";
		}
	}

	public Quarto buscarPorId(Long id) {

		Quarto quarto = quartoDao.buscarPorId(id);
		if (quarto == null) {
			throw new RuntimeException("Quarto não encontrado!");
		}
		return quarto;

	}

	public List<QuartoDto> buscaPorTipo(Tipo tipo) {
		List<Quarto> list = quartoDao.buscarPorTipo(tipo);
		if (list.isEmpty()) {
			throw new RuntimeException("Não existem quartos diponíveis no tipo selecionado!");
		}
		List<QuartoDto> listDto = retornarQuartosDtos(list);
		return listDto;
	}

	public Tipo verificarTipo() {

		String[] turnos = { "Solteiro", "Casal", "Suite" };
		Object turnoEscolha = JOptionPane.showInputDialog(null, "Selecione", "Tipo do quarto",
				JOptionPane.INFORMATION_MESSAGE, null, turnos, turnos[0]);

		String escolha = turnoEscolha.toString();

		switch (escolha) {
		case "Solteiro": {
			return Tipo.SOLTEIRO;
		}
		case "Casal": {
			return Tipo.CASAL;
		}
		case "Suite": {
			return Tipo.SUITE;
		}
		default:

		}
		return null;

	}

	public Status editarStatus() {

		String[] turnos = { "Agendado", "Manutenção", "Disponível" };
		Object turnoEscolha = JOptionPane.showInputDialog(null, "Selecione", "Editar Status do quarto",
				JOptionPane.INFORMATION_MESSAGE, null, turnos, turnos[0]);

		String escolha = turnoEscolha.toString();

		switch (escolha) {
		case "Agendado": {
			return Status.AGENDADO;
		}
		case "Manutenção": {
			return Status.MANUTENCAO;
		}
		case "Disponível": {
			return Status.DISPONIVEL;
		}
		default:

		}
		return null;

	}

	private List<QuartoDto> retornarQuartosDtos(List<Quarto> list) {
		List<QuartoDto> listDtos = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			Long id = list.get(i).getId();
			BigDecimal preco = list.get(i).getPrecoHora();
			Tipo tipo = list.get(i).getTipo();

			QuartoDto dto = new QuartoDto(id, preco, tipo);
			listDtos.add(dto);
		}

		return listDtos;
	}

}
