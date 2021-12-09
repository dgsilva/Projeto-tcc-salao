package br.com.tcc.feuc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tcc.feuc.entities.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
