package contas.view;

import javax.swing.JOptionPane;

import database.connection.DAO;

public class ViewCadastroConta extends View {
	public static void mostrar() {

		Double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da conta"));
		String descricao = JOptionPane.showInputDialog("Digite a descrição da conta");
		// int idBoleto = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do
		// boleto"));
		int idRecebedor = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do recebedor"));
		String email = JOptionPane.showInputDialog("Digite seu email");
		int idUsuario = DAO.buscaUsuarioByemail(email).getId();
		String dataVencimento = JOptionPane.showInputDialog("digite a data de vencimento da conta(ano-mes-dia)");
		try {
			if (DAO.cadastraConta(valor, descricao, idRecebedor, idUsuario, dataVencimento)) {
				System.out.println("Deu certo!");
			}
		} finally {
			//JOptionPane.showMessageDialog(null, "Houve um erro, mas não se preocupe");
			ViewHome.mostrar();
		}
	}
}
