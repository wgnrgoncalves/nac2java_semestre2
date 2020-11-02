package fiap.nac2.modelo;

public class Funcionario {
	
	private long id;
	
	private String nome;
	
	private TipoFuncionario tipo;

	
	private String login;
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		if(login != null)
			login = login.toLowerCase();
		
		this.login = login;
	}

	private String senha;

	
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

	public TipoFuncionario getTipo() {
		return tipo;
	}

	/**
	 * @param tipo
	 */
	public void setTipo(TipoFuncionario tipo) {
		this.tipo = tipo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}