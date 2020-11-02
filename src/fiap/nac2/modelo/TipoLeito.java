package fiap.nac2.modelo;

public enum TipoLeito {
	ENF_ADULTO("Enfermaria adulto"),
	ENF_INFANTIL("Enfermaria infantil"),
	UTI_ADULTO("UTI adulto"),
	UTI_INFANTIL("UTI infantil");
	
	private TipoLeito(String nome) {
		this.nome = nome;
	}

	private String nome;
	
	public String getNome() {
		return nome;
	}
}
