package br.com.facisa.entities;

import br.com.facisa.entities.enums.Status;
import br.com.facisa.entities.enums.Tipo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tb_quartos")
public class Quarto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private int numero;

    private Tipo tipo;

    private int capacidade;

    private BigDecimal precoHora;

    private Status status;

    public Quarto(){
    }

    public Quarto(int capacidade, int numero, BigDecimal precoHora, Tipo tipo) {
        this.capacidade = capacidade;
        this.numero = numero;
        this.precoHora = precoHora;
        this.tipo = tipo;
        this.status = Status.DISPONIVEL;
    }


    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public BigDecimal getPrecoHora() {
        return precoHora;
    }

    public void setPrecoHora(BigDecimal precoHora) {
        this.precoHora = precoHora;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quarto quarto = (Quarto) o;
        return Objects.equals(id, quarto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
