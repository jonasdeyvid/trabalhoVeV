package contas.view;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import database.connection.DAO;
import models.Conta;

public class ViewMostraContas extends View {
	public static void mostrar() {
		String email = JOptionPane.showInputDialog("Digite seu email");
		String resultado = new String();
		try {
			ArrayList<Conta> contas = DAO.buscaTodasAsContasDeUmUsuario(email);

			for (int i = 0; i < contas.size(); i++) {
				resultado += "Descrição: " + contas.get(i).getDescricao() + "  Valor: " + contas.get(i).getValor()
						+ "  Id recebedor: " + contas.get(i).getIdRecebedor() + "\n";
			}
			JOptionPane.showMessageDialog(null, resultado);

		} finally {
			//JOptionPane.showMessageDialog(null, "Houve um erro, mas não se preocupe");
			ViewHome.mostrar();
		}
	}
}
