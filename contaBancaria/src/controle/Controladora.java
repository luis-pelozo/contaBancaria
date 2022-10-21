package controle;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import modelo.Conta;
import modelo.Movimentacao;
import visualizacao.EntradaSaida;

public class Controladora {
    Conta conta = new Conta();
	static DecimalFormat df = new DecimalFormat("#0.00");

    public void exibeMenu(){

        int opcao, opcao2;
		String informacoes;
		String titular = EntradaSaida.solicitaTitular();
		int tipo = EntradaSaida.solicitarTipoDaConta();
		conta.setTitular(titular);
		conta.setTipoDeConta(tipo);

        do{
            opcao = EntradaSaida.solicitaOpcao();

            switch(opcao){
                case 0:
                double deposito = EntradaSaida.solicitaInformacoesDeposito();
				while (deposito <= 0) {
                    JOptionPane.showMessageDialog(null, "Valor inválido!");
					deposito = EntradaSaida.solicitaInformacoesDeposito();
				}
				Movimentacao movimentacaoDeposito = new Movimentacao();
                movimentacaoDeposito.setData(LocalDateTime.now());
				movimentacaoDeposito.setValor(deposito);
				movimentacaoDeposito.setTipo(1);				
				this.conta.depositar(deposito, movimentacaoDeposito);
				JOptionPane.showMessageDialog(null, "Você depositou: R$" + df.format(deposito));
				break;

                case 1:
				double saque = EntradaSaida.solicitaInformacoesSaque();
				while (saque <= 0) {
					JOptionPane.showMessageDialog(null, "Valor inválido!");
					saque =	 EntradaSaida.solicitaInformacoesSaque();
				}
				Movimentacao movimentacaoSaque = new Movimentacao();
                movimentacaoSaque.setData(LocalDateTime.now());
				movimentacaoSaque.setValor(saque);
				movimentacaoSaque.setTipo(2);			
				
				if (this.conta.getSaldo() - saque < -1000) {
					JOptionPane.showMessageDialog(null, "Saque não permitido, limite maximo negativo atingido: - R$1.000");
				} else {
					this.conta.sacar(saque, movimentacaoSaque);
					JOptionPane.showMessageDialog(null, "Você sacou: R$" + df.format(saque));
				}
				break;

				case 2:
				String infoSaldo = this.conta.verSaldo();
				EntradaSaida.mostrarSaldo(infoSaldo);
				break;

				case 3:
					opcao2 = EntradaSaida.solicitaOpcaoExtrato();
					switch(opcao2){
						case 0:
						if (conta.getListaDeMovimentacao().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Esta conta ainda não possui movimentações","info",
							JOptionPane.ERROR_MESSAGE);
		
						} else {
							informacoes = this.conta.gerarExtratoCompleto();
							EntradaSaida.exibirExtratoCompleto(informacoes);
						}
						break;
						
						case 1:
						if (conta.getListaDeMovimentacao().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Esta conta ainda não possui movimentações","info",
							JOptionPane.ERROR_MESSAGE);
		
						} else {
							informacoes = this.conta.gerarExtratoSaques();
							EntradaSaida.exibirExtratoDeSaques(informacoes);
						}
						break;
						
						case 2:
						if (conta.getListaDeMovimentacao().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Esta conta ainda não possui movimentações","info",
							JOptionPane.ERROR_MESSAGE);
						} else {
							informacoes = this.conta.gerarExtratoDepositos();
							EntradaSaida.exibirExtratoDeDepositos(informacoes);
						}
						break;					
					}
				break;
				
				case 4:
				informacoes = this.conta.gerarDadosDaConta();
				EntradaSaida.exibirDadosDaConta(informacoes);
				break;
            }
        } while (opcao!=5);
		EntradaSaida.msgEncerraConsulta();
		System.exit(0);       
    }
}
