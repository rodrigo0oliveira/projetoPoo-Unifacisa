package br.com.facisa.entities.enums;

public enum Status {

    DISPONIVEL("DISPONIVEL"),
    AGENDADO("AGENDADO"),
    MANUTENCAO("MANUTENÇAO");

    private String name;

    Status(String name){
        this.name = name;
    }

    public String getName(){
        return this.getName();
    }

	public void setName(String name) {
		this.name = name;
	}
    
    
}
