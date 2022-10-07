package modelo;

import java.util.ArrayList;
import java.text.DecimalFormat;

public class Conta {
    private int tipoDeConta;
	private double saldo;
    private String titular;	
	private ArrayList<Movimentacao> listaDeMovimentacao = new ArrayList<Movimentacao>();
	DecimalFormat df = new DecimalFormat("#0.00");

    public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

    public int getTipoDeConta() {

		return tipoDeConta;
	}

	public void setTipoDeConta(int tipoDeConta) {
		this.tipoDeConta = tipoDeConta;
	}

    public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}       


    public void fazerDeposito(double deposito, Movimentacao movimentacao) {
		listaDeMovimentacao.add(movimentacao);
		saldo = saldo + deposito;
	}

    public void fazerSaque(double saque, Movimentacao movimentacao) {

		listaDeMovimentacao.add(movimentacao);
		saldo = saldo - saque;
	}

}
