package br.com.tcc.feuc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import br.com.tcc.feuc.dto.request.LoginPostRequest;
import br.com.tcc.feuc.entities.Cliente;
import br.com.tcc.feuc.entities.Profissional;
import br.com.tcc.feuc.entities.TipoSexo;

@SpringBootTest
@AutoConfigureMockMvc
class ProjetoSalaoBackApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	
	
	
//	@Test
//	public void AuthAdministrador()throws Exception{
//		
//        Administrador dto = new Administrador();
//		Faker faker = new Faker(new Locale("pt-Br"));
//		dto.setEmail("diego@gmail.com");
//		dto.setSenha("123456");
//		
//		mockMvc.perform(
//				post("/login")
//				.contentType("application/json")
//				.content(objectMapper.writeValueAsString(dto)))
//				.andExpect(status()
//						.isCreated());
//
//		
//		
//		
//	}
	
	
	@Test
	public void postClient()throws Exception{
		
		Faker faker = new Faker(new Locale("pt-Br"));
		
		
		for (int i = 0; i < 50; i++) {
		LoginPostRequest authDto = new LoginPostRequest();
		authDto.setEmail("diego@gmail.com");
		authDto.setSenha("123456");
		
		mockMvc.perform(
				post("/login")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(authDto)))
				.andExpect(status().isOk());
		
			
		
		Cliente dto = new Cliente();
//		Faker faker = new Faker(new Locale("pt-Br"));
		dto.setNome(faker.name().fullName());
		dto.setEmail(faker.internet().emailAddress());
		Date dataNascimento = faker.date().birthday();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dataNascimentoFormatada = dateFormat.format(dataNascimento);
		dto.setDataNascimento(dataNascimentoFormatada);
		dto.setBairro(faker.address().cityName());
		dto.setTelefone(faker.phoneNumber().phoneNumber());
		dto.setSexo(faker.options().option(TipoSexo.Masculino,TipoSexo.Feminino));
		dto.setCpf(faker.number().digits(11));
		
		mockMvc.perform(
				post("/cliente")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(dto)))
		.andExpect(status().isCreated());
		}
		
		
	}
	
//	@Test
//	public void postProfissional() throws Exception {
//	
//		Faker faker = new Faker(new Locale("pt-Br"));
//				
//			Profissional p = new Profissional();
//			p.setNome(faker.name().fullName());
//			p.setBairro(faker.address().cityName());
//			p.setCpf(faker.number().digits(11));
//			p.setCelular(faker.phoneNumber().cellPhone());
//			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//			Date dataNascimento = faker.date().birthday();
//			String dataNascimentoFormatada = dateFormat.format(dataNascimento);
//			p.setDataNascimento(dataNascimentoFormatada);
//			p.setTelefone(faker.phoneNumber().phoneNumber());
//			p.setEmail(faker.internet().emailAddress());
//			p.setSexo(faker.options().option("Masculino","Feminino"));
//			
//			mockMvc.perform(
//					post("/profissionais")
//					.contentType("application/json")
//					.content(objectMapper.writeValueAsString(p)))
//			.andExpect(status().isCreated());
//			
//		
//
//	}

		
	
	
	
//	@Test
//	public void AuthAccessDenid()throws Exception{		
//	
//		LoginPostRequest authDto = new LoginPostRequest();
//		Faker faker = new Faker(new Locale("pt-Br"));
//		authDto.setEmail(faker.internet().emailAddress());
//		authDto.setSenha(faker.internet().password(8,12));
//
//		
//		mockMvc.perform(
//				post("/login")
//				.contentType("application/json")
//				.content(objectMapper.writeValueAsString(authDto)))
//				.andExpect(status().isUnauthorized());
//
//	}
	
	

}
