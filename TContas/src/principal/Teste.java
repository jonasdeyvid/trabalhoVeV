package principal;


import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import database.connection.DAO;

public class Teste {

	public static void main(String[] args) {
		testaUpdateSenha();
	}
	
	public static void testaCadastroUsuario() {
		String nome = JOptionPane.showInputDialog("Digite seu nome");
		String sobrenome = JOptionPane.showInputDialog("Digite seu sobrenome");
		String dataNasc = JOptionPane.showInputDialog("Digite sua data de nascimento");
		String email = JOptionPane.showInputDialog("Digite seu email");
		String senha = JOptionPane.showInputDialog("digite sua senha");
		
		if(DAO.cadastrarUsuario(nome, sobrenome, dataNasc, email, senha))
			System.out.println("Deu certo!");
	}
	
	public static void testaJframe() {
		JFrame telaPrincipal = new JFrame("Login");
		JPanel painel = new JPanel();
		TextField email = new TextField("email");
		TextField senha = new TextField("senha");
		Button login = new Button("login");
		Button cadastrar = new Button("Cadastrar");
		
		ActionListener Clickcadastro = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				testaCadastroUsuario();
				
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
	
	public static void testaRemoveUsuarioPorEmail() {
		String email = JOptionPane.showInputDialog("Digite o email do usuario a ser removido");
		DAO.removerUsuario(email);
	}
	
	public static void testaUpdateSenha() {
		String email = JOptionPane.showInputDialog("digite seu email");
		String senha = JOptionPane.showInputDialog("digite sua senha atual");
		String novaSenha = JOptionPane.showInputDialog("digite sua nova senha");
		
		DAO.atualizaSenha(email, senha, novaSenha);
		
	}
	
	public static void testaCadastroConta(Double valor, String descricao, int idBoleto, int idRecebedor, int idUsuario, Date dataVencimento) {
		Double valor2 = Double.parseDouble(JOptionPane.showInputDialog("digite o valor da conta"));
		int idBoleto2 = Integer.parseInt(JOptionPane.showInputDialog("digite o id do boleto"));
		int idrecebedor2 = Integer.parseInt(JOptionPane.showInputDialog("digite o id do recebedor"));
		
	}

}
