package br.com.facisa.entities.enums;

public enum Status {

    DISPONIVEL("DISPONIVEL"),
    OCUPADO("OCUPADO"),
    MANUTENCAO("MANUTENÇAO");

    private String name;

    Status(String name){
        this.name = name;
    }

    public String getName(){
        return this.getName();
    }
}
