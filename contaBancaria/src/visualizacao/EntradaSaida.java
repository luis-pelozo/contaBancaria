package visualizacao;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class EntradaSaida {

    public static int solicitaOpcao(){
		String[] opcoes = {"Saque", "Depósito", "Ver Saldo","Informações da Conta","Imprimir extrato" ,"Sair "};
		JComboBox<String> menu = new JComboBox<String>(opcoes);

		JOptionPane.showConfirmDialog(null, menu, "Selecione uma opção", JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();
	}

  public static int solicitarInformacoesDeposito(){
    int valorDeposito = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o valor que deseja depositar"));

    return valorDeposito;
  }

  public static int solicitaInformacoesSaque(){
    int valorSaque = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o valo que deseja sacar"));
    
    return valorSaque;
  }

  


  public static void msgEncerraConsulta(){
		JOptionPane.showMessageDialog(null, "Obrigado!");		
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
