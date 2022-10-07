package controle;
import java.time.LocalDateTime;

import javax.swing.JOptionPane;

import modelo.Conta;
import modelo.Movimentacao;
import visualizacao.EntradaSaida;

public class Controladora {
    Conta conta = new Conta();

    public void exibeMenu(){

        int opcao;
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
					//EntradaSaida.exibirValorInvalido();
                    JOptionPane.showMessageDialog(null, "Valor inválido!");
					deposito = EntradaSaida.solicitaInformacoesDeposito();
				}
				Movimentacao movimentacaoDeposito = new Movimentacao();

                movimentacaoDeposito.setData(LocalDateTime.now());
				movimentacaoDeposito.setValor(deposito);
				movimentacaoDeposito.setTipo(2); //guardar na poupança
				
				this.conta.fazerDeposito(deposito, movimentacaoDeposito);

				EntradaSaida.mostrarInfoDeposito(deposito);

				break;

                case 1:
				double saque = EntradaSaida.solicitaInformacoesSaque();
				while (saque <= 0) {
					JOptionPane.showMessageDialog(null, "Valor inválido!");
					saque = EntradaSaida.solicitaInformacoesSaque();
				}

				Movimentacao movimentacaoSaque = new Movimentacao();

                movimentacaoSaque.setData(LocalDateTime.now());
				movimentacaoSaque.setValor(saque);
				movimentacaoSaque.setTipo(1);// sacar pagamento
				
				
				if (this.conta.getSaldo() - saque < -1000) {
					JOptionPane.showMessageDialog(null, "Saque não permitido, limite maximo negativo atingido: -R$1.000");
				} else {
					this.conta.fazerSaque(saque, movimentacaoSaque);
					EntradaSaida.mostrarInfoSaque(saque);
				}
				break;
            }

        } while (opcao != 5);



        
    }
}
