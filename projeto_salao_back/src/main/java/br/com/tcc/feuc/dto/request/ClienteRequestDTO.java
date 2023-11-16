package br.com.tcc.feuc.dto.request;



import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import br.com.tcc.feuc.entities.TipoSexo;
import lombok.Data;
@Data
public class ClienteRequestDTO {
	
	@Size(min = 6, max = 100, message = "Nome deve ter de 6 a 100 caracteres.")
	@NotBlank(message = "Informe o nome do usuário.")
	private String nome;
	private String cpf;
	@NotBlank(message = "Informe o email do usuário.")
	private String email;
	@NotBlank(message = "Informe o seu bairro.")
	private String bairro;
	@NotBlank(message = "Informe sua data de nadcimento.")
	private String dataNascimento;
	@NotBlank(message = "Informe o seu telefone.")
	private String telefone;
	@NotBlank(message = "Informe o seu sexo.")
	private TipoSexo sexo;

}
