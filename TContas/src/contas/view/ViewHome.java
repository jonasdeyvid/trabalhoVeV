package contas.view;

import javax.swing.JOptionPane;


public class ViewHome extends View {
	
	public static void mostrar() {
		
		int escolha = 1;
		while(escolha != 0) {
		escolha = Integer.parseInt(JOptionPane.showInputDialog(
				"Escolha o que deseja:\n 1: Cadastrar usuario \n 2: Cadastrar conta \n 3: Ver contas \n 4: Remover conta \n "
						+ "5: Buscar conta \n 6: Atualizar valor da conta \n 7: Cadastrar recebedor \n 8: Buscar recebedor \n"
						+ " 9: ver recebedores \n 10: Cadastrar boleto \n 11: Ver numero de um boleto\n 0: Sair\n"));

		switch (escolha) {
		case 1:
			ViewCadastrarUsuario.mostrar();
			break;

		case 2:
			ViewCadastroConta.mostrar();
			break;

		case 3:
			ViewMostraContas.mostrar();
			break;

		case 4:
			ViewRemoverConta.mostrar();
			break;

		case 5:
			ViewBuscaConta.mostrar();
			break;

		case 6:
			ViewAtualizarValorConta.mostrar();
			break;

		case 7:
			ViewCadastroRecebedor.mostrar();
			break;

		case 8:
			ViewBuscarRecebedor.mostrar();
			break;

		case 9:
			ViewVerRecebedores.mostrar();
			break;

		case 10:
			ViewCadastrarBoleto.mostrar();
			break;

		case 11:
			ViewBuscarBoleto.mostrar();
			break;

		case 0:
			System.exit(0);
			break;
		
		default:
			
		}

		}

	}
}
