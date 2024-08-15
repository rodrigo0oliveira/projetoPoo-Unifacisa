package br.com.facisa.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
public class Hospede extends Pessoa{

    private LocalDate nascimento;

    @OneToOne
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
}
