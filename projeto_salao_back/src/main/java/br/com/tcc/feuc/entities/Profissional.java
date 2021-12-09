package br.com.tcc.feuc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "profissional")
public class Profissional {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProfissional;
	@Column()
	private String nome;
	@Column()
	private String bairro;
	@Column()
	private String dataNascimento;
	@Column()
	private String celular;
	@Column()
	private String telefone;
	@Column(unique = true)
	private String email;
	@Column(length = 15,unique = true)
	private String cpf;
	@Column()
	private String sexo;

}
