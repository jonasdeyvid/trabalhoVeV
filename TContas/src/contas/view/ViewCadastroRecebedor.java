package contas.view;

import javax.swing.JOptionPane;

import database.connection.DAO;

public class ViewCadastroRecebedor extends View {
	public static void mostrar() {
		String nomeRecebedor = JOptionPane.showInputDialog("Digite o nome do recebedor");
		String descricao = JOptionPane.showInputDialog("Digite a descricao do recebedor");
		String endereco = JOptionPane.showInputDialog("Digite o endereco do recebedor");
		try {
			DAO.cadastrarRecebedor(nomeRecebedor, descricao, endereco);
			JOptionPane.showMessageDialog(null,
					"Recebedor cadastrado, id: " + DAO.buscarRecebedorByNome(nomeRecebedor).getId());
		} finally {
			//JOptionPane.showMessageDialog(null, "Houve um erro, mas não se preocupe");
			ViewHome.mostrar();
		}
	}
}
