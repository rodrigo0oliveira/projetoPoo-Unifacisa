package br.com.facisa.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_hospedes")
public class Hospede extends Pessoa{

    private LocalDate nascimento;

    
    @OneToOne(cascade =  javax.persistence.CascadeType.ALL) 
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    private String numero;

    public Hospede(){
    }

    public Hospede(String cpf, String name, Endereco endereco, LocalDate nascimento, String numero) {
        super(cpf, name);
        this.endereco = endereco;
        this.nascimento = nascimento;
        this.numero = numero;
    }
    
    

    public Hospede(String nome,LocalDate nascimento, Endereco endereco, String numero) {
		super(nome);
		this.nascimento = nascimento;
		this.endereco = endereco;
		this.numero = numero;
	}

	public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

	@Override
	public String toString() {
		return "Hóspede "+getNome()+ ": CPF = "+getCpf()+
				" |Nascimento = "+this.nascimento+" |Número = "+this.numero;
	}
    
    
}
