package fiap.nac2.modelo;

import java.time.LocalDate;

public class Leito {
private long id;
	
	private String numero;
	
	private TipoLeito tipo;
	
	private LocalDate liberacao;
	
	private StatusLeito status;

	@Override
	public String toString() {
		return "Leito [numero=" + numero + ", tipo=" + tipo
				+ ", dataLiberacao=" + liberacao + ", status=" + status
				+ "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public TipoLeito getTipo() {
		return tipo;
	}

	public void setTipo(TipoLeito tipo) {
		this.tipo = tipo;
	}

	public LocalDate getLiberacao() {
		return liberacao;
	}

	public void setLiberacao(LocalDate liberacao) {
		this.liberacao = liberacao;
	}

	public StatusLeito getStatus() {
		return status;
	}

	public void setStatus(StatusLeito status) {
		this.status = status;
	}	
}
