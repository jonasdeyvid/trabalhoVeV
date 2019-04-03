package contas.view;

import javax.swing.JOptionPane;

import database.connection.DAO;

public class ViewCadastrarBoleto extends View {
	public static void mostrar() {
		String numeroBoleto = JOptionPane.showInputDialog("Digite o numero do boleto");
		try {
			DAO.cadastrarBoleto(numeroBoleto);
		} finally {
			//JOptionPane.showMessageDialog(null, "Houve um erro, mas não se preocupe");
			ViewHome.mostrar();
		}
	}
}
