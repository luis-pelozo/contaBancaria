package visualizacao;

import java.text.DecimalFormat;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class EntradaSaida {

  static DecimalFormat df = new DecimalFormat("#0.00");

    public static int solicitaOpcao(){
		String[] opcoes = {"Depósito", "Saque", "Ver Saldo","Imprimir extrato","Informações da Conta","Sair "};
		JComboBox<String> menu = new JComboBox<String>(opcoes);

		JOptionPane.showConfirmDialog(null, menu, "Selecione uma opção", JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();
	}

  public static int solicitaOpcaoExtrato(){
		String[] opcoesExtrato = {"Extrato completo", "Extrato de SAQUE", "Extrato de DEPÓSITO"};
		JComboBox<String> menu = new JComboBox<String>(opcoesExtrato);

		JOptionPane.showConfirmDialog(null, menu, "Selecione um tipo de extrato", JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();
	}

  public static String solicitaTitular() {
		return JOptionPane.showInputDialog(null, "Informe o nome do TITULAR",JOptionPane.INFORMATION_MESSAGE);
	}

  public static int solicitarTipoDaConta() {		
		int tipoConta = Integer.parseInt(
				JOptionPane.showInputDialog(null, "Conta desejada: "+
                                                           "\n 1 - Conta Poupança"+
                                                           "\n 2 - Conta Corrente",
						"Tipo de conta", JOptionPane.INFORMATION_MESSAGE));
		return tipoConta;
	}

  public static double solicitaInformacoesDeposito(){
    return Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o valor que deseja depositar"));
  }

  public static double solicitaInformacoesSaque(){
    return Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o valo que deseja sacar"));
  }

  public static void exibirSaldo(String infoSaldo) {
		JOptionPane.showMessageDialog(null, infoSaldo, "Saldo", JOptionPane.INFORMATION_MESSAGE);
	}

  public static void exibirDadosDaConta(String informacoes) {
		JOptionPane.showMessageDialog(null, informacoes, "Dados Conta", JOptionPane.INFORMATION_MESSAGE);
	}

  public static void exibirExtratoCompleto(String informacoes) {
		JOptionPane.showMessageDialog(null, informacoes, "Extrato completo", JOptionPane.INFORMATION_MESSAGE);
	}

  public static void exibirExtratoDeDepositos(String informacoes) {
		JOptionPane.showMessageDialog(null, informacoes, "Extrato de Depositos", JOptionPane.INFORMATION_MESSAGE);
	}

	public static void exibirExtratoDeSaques(String informacoes) {
		JOptionPane.showMessageDialog(null, informacoes, "Extrato de Saques", JOptionPane.INFORMATION_MESSAGE);
	}

  public static void msgEncerraConsulta(){
		JOptionPane.showMessageDialog(null, "Obrigado!");		
	}

  public static void mostrarInfoDeposito(double deposito) {
		JOptionPane.showMessageDialog(null, "Você depositou: R$" + df.format(deposito));
	}

  public static void mostrarInfoSaque(double saque) {
		JOptionPane.showMessageDialog(null, "Voçw sacou: R$" + df.format(saque));
	}

    /*
    solicitarInformacoesDeposito()
    solicitarInformacoesSaque()
    exibirSaldo()
    exibirDadosDaConta() - exibir nome do titular, tipo e saldo
    exibirExtratoCompleto()
    exibirExtratoDeDepositos()
    exibirExtratoDeSaques()
 */
}
