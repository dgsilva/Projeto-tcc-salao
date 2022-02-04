package br.com.tcc.feuc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.tcc.feuc.entities.Profissional;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long>{
	
	@Query("from Profissional p where p.email = :email")
	Profissional findByEmail(@Param("email")String email);
	
	@Query("from Profissional p where p.cpf = :cpf")
	Profissional findByCpf(@Param("cpf")String cpf);
	
	@Query("from Profissional p where p.telefone = :telefone")
	Profissional findByTelefone(@Param("telefone") String telefone);
	
	@Query("from Profissional p where p.celular = :celular")
	Profissional findByCelular(@Param("celular")String celular);

}
