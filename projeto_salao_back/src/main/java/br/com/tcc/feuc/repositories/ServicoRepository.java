package br.com.tcc.feuc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tcc.feuc.entities.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
