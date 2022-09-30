package visualizacao;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class EntradaSaida {

    public static int solicitaOpcao(){
		String[] opcoes = {"Saque", "Depósito", "Ver Saldo","Imprimir extrato" ,"Sair "};
		JComboBox<String> menu = new JComboBox<String>(opcoes);

		JOptionPane.showConfirmDialog(null, menu, "Selecione uma opção", JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();
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
