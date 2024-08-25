package br.com.facisa.entities;

import javax.persistence.*;

@Entity
@Table(name = "tb_enderecos")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pais;

    private String cidade;

    public Endereco(){
    }

    public Endereco(String cidade, String pais) {
        this.cidade = cidade;
        this.pais = pais;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Long getId() {
        return id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

	@Override
	public String toString() {
		return "Endereco : País =" + pais + ", Cidade =" + cidade ;
	}
    
    
    
    
}
