package br.com.tcc.feuc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.tcc.feuc.entities.Administrador;
@Repository
public interface AdmRepository extends JpaRepository<Administrador, Long> {

}
