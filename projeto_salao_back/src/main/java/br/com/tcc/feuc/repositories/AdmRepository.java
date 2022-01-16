package br.com.tcc.feuc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.tcc.feuc.entities.Administrador;
@Repository
public interface AdmRepository extends JpaRepository<Administrador, Long> {

	@Query("from Administrador a where a.email = :param")
	Administrador findByEmail(@Param("param")String email);
	
	@Query("from Administrador a where a.email = :param1 and a.senha = :param2")
	Administrador findByEmailAndSenha(@Param("param1")String email, @Param("param2")String senha);
	
	
	
}
