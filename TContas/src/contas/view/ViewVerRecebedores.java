package contas.view;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import database.connection.DAO;
import models.Recebedor;

public class ViewVerRecebedores extends View {
	public static void mostrar() {
		try {
			ArrayList<Recebedor> recebedores = DAO.buscarTodosOsRecebedores();
			String message = new String();
			for (int i = 0; i < recebedores.size(); i++) {
				message += "Nome recebedor: " + recebedores.get(i).getNome() + "  Descrição: "
						+ recebedores.get(i).getDescricao() + "   Id:  " + recebedores.get(i).getId() + "   Endereco: "
						+ recebedores.get(i).getEndereco() + "\n";
			}
			JOptionPane.showMessageDialog(null, message);
		} finally {
			//JOptionPane.showMessageDialog(null, "Houve um erro, mas não se preocupe");
			ViewHome.mostrar();
		}

	}
}
