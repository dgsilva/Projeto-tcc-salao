package br.com.tcc.feuc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.tcc.feuc.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	@Query("from Cliente c where c.email = :email")
	Cliente findByEmail(@Param("email")String email);
	
	@Query("from Cliente c where c.telefone = :telefone")
	Cliente findByTelefone(@Param("telefone")String telefone);
	
	@Query("from Cliente c where c.cpf = :cpf")
	Cliente findByCpf(@Param("cpf")String cpf);

}
