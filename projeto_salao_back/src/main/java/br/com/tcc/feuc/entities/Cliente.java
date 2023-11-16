package br.com.tcc.feuc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long idCliente;
	@Column(length = 100, nullable = false)
	@NotNull
	@NotBlank
	private String nome;
	@Column(length = 15, unique = true)
	private String cpf;
	@Column(length = 60, unique = true)
	private String email;
	@Column(nullable = false)
	private String bairro;
	@Column(nullable = false)
	private String dataNascimento;
	@Column(nullable = false)
	private String telefone;
	@Enumerated(EnumType.STRING)
	private TipoSexo sexo;

}
