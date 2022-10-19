package modelo;

import java.util.ArrayList;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

	public String verSaldo() {

		String infoSaldo = "";

		infoSaldo += "Saldo atual: R$" + df.format(this.saldo);

		return infoSaldo;

	}

	public ArrayList<Movimentacao> getListaDeMovimentacao() {
		return listaDeMovimentacao;
	}

	public void setListaDeMovimentacao(ArrayList<Movimentacao> listaDeMovimentacao) {
		this.listaDeMovimentacao = listaDeMovimentacao;
	}

	public void depositar(double deposito, Movimentacao movimentacao) {
		listaDeMovimentacao.add(movimentacao);
		saldo = saldo + deposito;
	}

	public String verificaTipoDeConta(){
		String tipoDaConta ="";
		if(getTipoDeConta() ==1){
			tipoDaConta = "Conta Poupança";
		} else{
			tipoDaConta = "Conta Corrente";
		}
		return tipoDaConta;
	}

	public String gerarExtratoCompleto() {
		String informacoes = "";
		for (Movimentacao movimentacao : this.listaDeMovimentacao) {
			int tipoMovimentacao = movimentacao.getTipo();
			String infoMovimentacao = "";

			if (tipoMovimentacao == 2) {
				infoMovimentacao = "--SAQUE--";
			} else {
				infoMovimentacao = "--DEPOSITO--";
			}

			informacoes += movimentacao.getData() + " - " + infoMovimentacao + "  R$"
					+ df.format(movimentacao.getValor()) + "\n" 
					+"Saldo: "+df.format(getSaldo())+ "\n" 
					+verificaTipoDeConta();
		}		
		return informacoes;
	}

	public String gerarExtratoSaques() {
		String informacoes = "";
		for (Movimentacao movimentacao : this.listaDeMovimentacao) {
			int tipoMovimentacao = movimentacao.getTipo();
			String infoMovimentacao = "";

			if (tipoMovimentacao == 2) {
				infoMovimentacao = "--SAQUE--";
				informacoes += movimentacao.getData() + " - " + infoMovimentacao + "  R$"
						+ df.format(movimentacao.getValor()) + "\n"
						+"Saldo: " +df.format(getSaldo())+"\n" 
						+verificaTipoDeConta();
			}			
		}

		if (informacoes == "") {
			String semMovimentacao = "Sua conta não possui movimentações de saques!";
			return semMovimentacao;
		} else {
			return informacoes;
		}
	}

	public String gerarExtratoDepositos() {
		String informacoes = "";
		for (Movimentacao movimentacao : this.listaDeMovimentacao) {
			
			int tipoMovimentacao = movimentacao.getTipo();
			String infoMovimentacao = "";

			if (tipoMovimentacao == 1) {
				infoMovimentacao = "--DEPOSITO--";
				informacoes += movimentacao.getData() + " - " + infoMovimentacao + "  R$"
						+ df.format(movimentacao.getValor()) + "\n"
						+ "Saldo: " +df.format(getSaldo())+"\n" 
						+verificaTipoDeConta();
			}
		}

		if (informacoes == "") {
			String semMovimentacao = "Sua conta não possui movimentações de depositos!";
			return semMovimentacao;
		} else {
			return informacoes;
		}
	}

	public String gerarDadosDaConta() {

		String informacoes = "";
		int tipoConta = tipoDeConta;
		LocalDateTime data = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String infoTipo = "";

		if (tipoConta == 1) {
			infoTipo = "Conta Poupança";
		} else {
			infoTipo = "Conta Corrente";
		}
		informacoes += "Nome do titular: " + titular + "\n" + "Tipo da conta: " + infoTipo + "\n"
				+ "Data do acesso: " + data.format(formatter) + "\n" + "Saldo: R$" + df.format(saldo) + "\n";

		return informacoes;
	}
}
