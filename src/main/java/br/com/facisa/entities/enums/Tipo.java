package br.com.facisa.entities.enums;

public enum Tipo {

    SOLTEIRO("SOLTEIRO"),
    CASAL("CASAL"),
    SUITE("SUITE");

    private String name;

    Tipo(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
