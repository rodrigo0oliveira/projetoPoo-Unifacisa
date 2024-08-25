package br.com.facisa.entities;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Funcionario extends Pessoa{

    private String cargo;

    private BigDecimal salario;

    private String turno;

    public Funcionario(){
    }

    public Funcionario(String cpf, String name, String cargo, BigDecimal salario, String turno) {
        super(cpf, name);
        this.cargo = cargo;
        this.salario = salario;
        this.turno = turno;
    }

    public Funcionario(String name,String cargo, BigDecimal salario, String turno) {
		super(name);
		this.cargo = cargo;
		this.salario = salario;
		this.turno = turno;
	}

	public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

	@Override
	public String toString() {
		return "Funcionario "+getNome()+ ": CPF = "+getCpf()+
				" |Cargo = "+this.cargo+" |Salário = R$"+this.salario+" |Turno = "+this.turno;
	}
    
    
    
    

}
