package contas.view;

import javax.swing.JOptionPane;

import database.connection.DAO;
import models.Conta;

public class ViewBuscaConta extends View {
	public static void mostrar() {
		int idConta = Integer.parseInt(JOptionPane.showInputDialog("Digite o id da conta"));
		try {
			Conta c = DAO.buscaContaById(idConta);
			JOptionPane.showMessageDialog(null, "Descrição: " + c.getDescricao() + "  Valor: " + c.getValor()
					+ "  Id recebedor: " + c.getIdRecebedor() + "\n");

		} finally {
			//JOptionPane.showMessageDialog(null, "Houve um erro, mas não se preocupe");
			ViewHome.mostrar();
		}
	}
}
