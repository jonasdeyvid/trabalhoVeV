package contas.view;

import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import database.connection.DAO;

public class ViewLogin extends View {
	public static void mostrar() {
	JFrame telaPrincipal = new JFrame("Login");
	JPanel painel = new JPanel();
	TextField email = new TextField("email");
	TextField senha = new TextField("senha");
	Button login = new Button("login");
	Button cadastrar = new Button("Cadastrar");
	
	ActionListener Clickcadastro = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ViewCadastrarUsuario.mostrar();
			
		}
	};
	ActionListener clickLogin = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(DAO.verificaEmailESenha(email.getText(), senha.getText())) {
				ViewHome.mostrar();
			}
			
		}
	};
	cadastrar.addActionListener(Clickcadastro);
	
	painel.add(email);
	painel.add(senha);
	painel.add(login);
	painel.add(cadastrar);
	
	telaPrincipal.add(painel);
	telaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	telaPrincipal.pack();
	telaPrincipal.setBounds(600, 300, 300, 100);
	telaPrincipal.setVisible(true);
	}	
}

