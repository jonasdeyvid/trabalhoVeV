package contas.view;

import javax.swing.JOptionPane;

import database.connection.DAO;

public class ViewRemoverConta extends View {
	public static void mostrar() {
		int idConta = Integer.parseInt(JOptionPane.showInputDialog("Digite o id da conta a ser apagada"));
		try {
		DAO.removerConta(idConta);
		}finally {
			//JOptionPane.showMessageDialog(null, "Houve um erro, mas não se preocupe");
			ViewHome.mostrar();
		}
	}
}
