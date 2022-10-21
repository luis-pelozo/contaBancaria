package modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Movimentacao {
    int tipo;
	double valor;
	LocalDateTime data = LocalDateTime.now();
	DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getData() {
		return data.format(formatar);
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
    
}
