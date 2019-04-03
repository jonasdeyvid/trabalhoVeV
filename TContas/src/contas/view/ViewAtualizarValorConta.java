package contas.view;

import javax.swing.JOptionPane;

import database.connection.DAO;

public class ViewAtualizarValorConta extends View {
	public static void mostrar() {
		int idConta = Integer.parseInt(JOptionPane.showInputDialog("Digite o id da conta"));
		double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da conta"));

		try {
			DAO.atualizarConta(idConta, valor);
		} finally {
			//JOptionPane.showMessageDialog(null, "Houve um erro, mas não se preocupe");
			ViewHome.mostrar();
		}
	}
}
