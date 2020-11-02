package fiap.nac2.modelo;

import java.time.LocalDateTime;

public class Internacao {
private long id;
	
	private LocalDateTime entrada;
	
	private LocalDateTime saida;
	
	private Leito leito;
	
	private Paciente paciente;
	
	private Funcionario funcionario;
	
	private LiberacaoLeito motivo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalDateTime entrada) {
		this.entrada = entrada;
	}

	public LocalDateTime getSaida() {
		return saida;
	}

	public void setSaida(LocalDateTime saida) {
		this.saida = saida;
	}

	public Leito getLeito() {
		return leito;
	}

	public void setLeito(Leito leito) {
		this.leito = leito;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public LiberacaoLeito getMotivo() {
		return motivo;
	}

	public void setMotivo(LiberacaoLeito motivo) {
		this.motivo = motivo;
	}	
}
