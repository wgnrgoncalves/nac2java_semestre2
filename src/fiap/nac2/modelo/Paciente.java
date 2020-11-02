package fiap.nac2.modelo;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.time.LocalDateTime;


public class Paciente {
	private long id;

	private String nome;

	private String telefone;

	private String email;

	private long cpf;

	private String responsavel;

	private LocalDate nascimento;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome != null)
			nome = nome.toUpperCase();
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		
		return email;
	}

	public void setEmail(String email) {
		if(email != null)
			email = email.toLowerCase();
		this.email = email;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	
	public Date getDt() {
		return java.util.Date.from(this.nascimento.atStartOfDay()
			      .atZone(ZoneId.systemDefault())
			      .toInstant());
	}
}
