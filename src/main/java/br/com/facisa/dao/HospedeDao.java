package br.com.facisa.dao;

import br.com.facisa.entities.Hospede;

public interface HospedeDao {

    void cadastrar(Hospede hospede);

    void editar(Long id,Hospede hospede);

    void excluir(Long id);
}
