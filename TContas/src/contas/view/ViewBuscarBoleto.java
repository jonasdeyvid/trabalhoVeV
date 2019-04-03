package contas.view;

import javax.swing.JOptionPane;

import database.connection.DAO;
import models.Boleto;

public class ViewBuscarBoleto extends View {
	public static void mostrar() {
		int idBoleto = Integer.parseInt(JOptionPane.showInputDialog("digite o id do boleto"));
		try {
			Boleto b = DAO.buscarBoletoById(idBoleto);
			JOptionPane.showMessageDialog(null, b.getNumeroBoleto());
		} finally {
			//JOptionPane.showMessageDialog(null, "Houve um erro, mas não se preocupe");
			ViewHome.mostrar();
		}

	}
}
