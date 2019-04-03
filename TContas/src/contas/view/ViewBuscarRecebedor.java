package contas.view;

import javax.swing.JOptionPane;

import database.connection.DAO;
import models.Recebedor;

public class ViewBuscarRecebedor extends View {
	public static void mostrar() {
		int idRecebedor = Integer.parseInt(JOptionPane.showInputDialog("Digite o id do recebedor"));
		try {
			Recebedor r = DAO.buscarRecebedorPorId(idRecebedor);
			JOptionPane.showMessageDialog(null, "Nome recebedor: " + r.getNome() + "  \nDescrição: " + r.getDescricao()
					+ "  \nId: " + r.getId() + "  \nEndereco: " + r.getEndereco());
		} finally {
			//JOptionPane.showMessageDialog(null, "Houve um erro, mas não se preocupe");
			ViewHome.mostrar();
		}
	}
}
