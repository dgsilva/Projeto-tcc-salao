package br.com.tcc.feuc.controllers;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tcc.feuc.cryptography.MD5Cryptography;
import br.com.tcc.feuc.dto.request.LoginPostRequest;
import br.com.tcc.feuc.dto.response.LoginResponse;
import br.com.tcc.feuc.entities.Administrador;
import br.com.tcc.feuc.repositories.AdmRepository;
import br.com.tcc.feuc.security.JwtSecurity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private AdmRepository admRepositorio;
	
	@Operation(summary = "Realizado autenticação pelo login ")
	@CrossOrigin("*")
	@PostMapping
	public ResponseEntity<LoginResponse>post(@RequestBody LoginPostRequest request){
		
		try {
			LoginResponse response = new LoginResponse();
			
			Administrador administrador = admRepositorio.findByEmailAndSenha(request.getEmail(), MD5Cryptography.encrypt(request.getSenha()));
			if(administrador !=null) {
				response.setStatusCode(200);
				response.setMensagem("Usuário autenticado com sucesso.");
				response.setAccessToken((getAccessToken(administrador.getEmail())));
				response.setNomeUsuario(administrador.getNome());
				response.setEmailUsuario(administrador.getEmail());
				return ResponseEntity.status(HttpStatus.OK)
						.body(response);
			}else {
				response.setStatusCode(401);
				response.setMensagem("Acesso negado.");
				
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
						.body(response);
			}
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
	// método para gerar o ACCESS TOKEN do usuário
			private String getAccessToken(String emailUsuario) {

				List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

				//  -> nome da aplicação que gerou o token!
				return Jwts.builder().setId("SALAO_JWT").setSubject(emailUsuario)
						.claim("authorities",
								grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
						.setIssuedAt(new Date(System.currentTimeMillis()))
						.setExpiration(new Date(System.currentTimeMillis() + 6000000))
						.signWith(SignatureAlgorithm.HS512, JwtSecurity.SECRET.getBytes()).compact();

			}
}
