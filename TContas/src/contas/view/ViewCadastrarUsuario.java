package contas.view;

import javax.swing.JOptionPane;

import database.connection.DAO;

public class ViewCadastrarUsuario extends View {
	public static void mostrar() {
		String nome = JOptionPane.showInputDialog("Digite seu nome");
		String sobrenome = JOptionPane.showInputDialog("Digite seu sobrenome");
		String dataNasc = JOptionPane.showInputDialog("Digite sua data de nascimento");
		String email = JOptionPane.showInputDialog("Digite seu email");
		String senha = JOptionPane.showInputDialog("digite sua senha");
		try {
		if(DAO.cadastrarUsuario(nome, sobrenome, dataNasc, email, senha)) {
			System.out.println("Deu certo!");
		}
	}finally {
		//JOptionPane.showMessageDialog(null, "Houve um erro, mas não se preocupe");
		ViewHome.mostrar();
	}
}
}
