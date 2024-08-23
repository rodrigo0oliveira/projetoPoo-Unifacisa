package br.com.facisa.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.facisa.dao.impl.FuncionarioImpl;
import br.com.facisa.database.Db;
import br.com.facisa.entities.Funcionario;
import br.com.facisa.services.utils.Validador;

public class FuncionarioServiceTest {
	
	Validador validador;
	FuncionarioImpl funcionarioImpl;
	
	FuncionarioService funcionarioService;
	
	Db db = new Db();
	
	@Before
	public void setup() {
		validador = new Validador();
		funcionarioImpl = new FuncionarioImpl();
		Db.openConnection();
		
		funcionarioService = new FuncionarioService(funcionarioImpl, validador);
	}
	
	@After
	public void end() {
		Db.closeConnection();
	}
	
	
	@Test
	public void TesteQuandoCadastrarFuncionarioRetornaSucesso () {
		BigDecimal salario = new BigDecimal(200);
		Funcionario funcionario = new Funcionario(
				"12232143211","Rodrigo","Diretor",salario,"Manhã");
		
		
		String actual = funcionarioService.cadastrarFuncionario(funcionario);
		String expected = "Novo funcionário cadastrado com sucesso!";
		
		assertEquals(expected, actual);
		
		
	}
	@Test
	public void TesteQuandoCadastroDeveRetornarRunTimeException() {
		Funcionario funcionario = new Funcionario(
				"12232143211","Rodrigo","Diretor",null,"Manhã");
		
		String expected = "Por favor, preencha todos os campos obrigatórios";
		
		RuntimeException actual = assertThrows(RuntimeException.class,
				()->{funcionarioService.cadastrarFuncionario(funcionario);});
		
		assertEquals(expected, actual.getMessage());
		
		
		
	}

}
