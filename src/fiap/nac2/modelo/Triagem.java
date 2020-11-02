package fiap.nac2.modelo;

public class Triagem extends Prontuario {
	
	private double temperatura;
	
	private String pressao;
	
	private double saturacao;

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public String getPressao() {
		return pressao;
	}

	public void setPressao(String pressao) {
		this.pressao = pressao;
	}

	public double getSaturacao() {
		return saturacao;
	}

	public void setSaturacao(double saturacao) {
		this.saturacao = saturacao;
	}
}