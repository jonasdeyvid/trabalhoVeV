package database.connection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Boleto;
import models.Conta;
import models.Recebedor;
import models.Usuario;

public class DAO {
	//CRUD para usuario
	public static boolean cadastrarUsuario(String nome, String sobrenome, String dataNasc, String email, String senha) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "insert into usuario (nome, sobrenome, datanasc, email, senha) values (?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, nome);
			ps.setString(2, sobrenome);
			Date x = Date.valueOf(dataNasc);
			ps.setDate(3, x);
			ps.setString(4, email);
			ps.setString(5, senha);
			int result = ps.executeUpdate();
			if(result >=1) {
				System.out.println("Deu certo cadastrar usuario!");
				return true;
			}
			else
				return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
		
	public static boolean removerUsuario(String email) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "delete from usuario where email = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			int result = ps.executeUpdate();
			if(result >=1) {
				System.out.println("Deu certo remover usuario!");
				return true;
			}
			else
				return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static Usuario buscaUsuarioByemail(String email) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "select * from usuario where email = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet result = ps.executeQuery();
			
			if(result != null) {
				System.out.println("Deu buscar usuario por email!");
				result.next();
				return new Usuario(result.getString(1), result.getString(2), result.getDate(3), result.getString(4), result.getInt(5), result.getString(6));
			}
			else
				return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static boolean verificaEmailESenha(String email, String senha) {
		try {
		Usuario u = buscaUsuarioByemail(email);
		if(u != null) {
			if(u.temSenha() || u.verificaSenha(senha)) {
				System.out.println("Deu certo verificar usuario!");
				return true;
			}
		}
		System.out.println("Usuario ou senha incorreta");
		return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean atualizaSenha(String email, String senhaAntiga, String novaSenha) {
		Connection con = null;
		try {
			if(verificaEmailESenha(email, senhaAntiga)) {
				con = ConnectionFactory.getConnection();
				String sql = "update usuario set senha = ? where email = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, novaSenha);
				ps.setString(2, email);
				int result = ps.executeUpdate();
				if(result >=1) {
					System.out.println("Deu certo! atualizar senha");	
					return true;
			}
			else
				System.out.println("Senha não alterada!");
				return false;
			}
			System.out.println("Senha não alterada!");
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//CRUD para conta
	public static boolean cadastraConta(Double valor, String descricao, int idRecebedor, int idUsuario, String dataVencimento) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "insert into conta (valor, descricao, idRecebedor, idUsuario, dataVencimento) values (?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setDouble(1, valor);
			ps.setString(2, descricao);
			Date x = Date.valueOf(dataVencimento);
			ps.setInt(3, idRecebedor);
			ps.setInt(4, idUsuario);
			ps.setDate(5, x);
			
			int result = ps.executeUpdate();
			if(result >=1) {
				System.out.println("Deu certo cadastrar conta!");
				return true;
			}
			else
				return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static boolean removerConta(int idConta) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "delete from conta where idConta = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idConta);
			int result = ps.executeUpdate();
			if(result >=1) {
				System.out.println("Deu certo remover conta!");
				return true;
			}
			else
				return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static Conta buscaContaById(int idConta) {
		Connection con = null;
		Conta c = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "select * from conta where idConta = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idConta);
			ResultSet r = ps.executeQuery();
			
			if(r != null) {
				System.out.println("Deu buscar Conta por id!");
				r.next();
				c = new Conta(r.getDouble(1), r.getString(2), r.getInt(3), r.getInt(4), r.getInt(5), r.getInt(6), r.getDate(7), r.getBoolean(8), r.getDate(9));
				return c;
			}
			else
				return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static boolean atualizarConta(int idConta, Double valor) {
		Connection con = null;
		try {
			if(buscaContaById(idConta) != null) {
				con = ConnectionFactory.getConnection();
				String sql = "update conta set valor = ? where idConta = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setDouble(1, valor);
				ps.setInt(2, idConta);
				int result = ps.executeUpdate();
				if(result >=1) {
					System.out.println("Deu certo atualizar valor da Conta!");	
					return true;
			}
			else
				System.out.println("Senha não alterada!");
				return false;
			}
			System.out.println("Senha não alterada!");
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static ArrayList<Conta> buscaTodasAsContasDeUmUsuario(String email) {
		Connection con = null;
		ArrayList<Conta> contas = null;
		try {
			int idUser = buscaUsuarioByemail(email).getId();
			con = ConnectionFactory.getConnection();
			String sql = "select * from conta where idUsuario = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idUser);
			ResultSet result = ps.executeQuery();
			
			if(result != null) {
				System.out.println("Deu buscar Contas por usuario!");
				contas = new ArrayList<>();
				while(result.next()) {
					contas.add(buscaContaById(result.getInt(3)));
				}
				return contas;
			}
			else
				return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	//CRUD para recebedor
	public static boolean cadastrarRecebedor(String nome, String descricao, String endereco) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "insert into recebedor (nome, descricao, endereco) values (?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, nome);
			ps.setString(2, descricao);
			ps.setString(3, endereco);
			int result = ps.executeUpdate();
			if(result >=1) {
				System.out.println("Deu certo cadastrar recebedor!");
				return true;
			}
			else
				return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static Recebedor buscarRecebedorPorId(int idRecebedor) {
		Connection con = null;
		Recebedor r = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "select * from recebedor where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idRecebedor);
			ResultSet result = ps.executeQuery();
			
			if(result != null) {
				System.out.println("Deu buscar recebedor por id!");
				result.next();
				r = new Recebedor(result.getString(1), result.getInt(2), result.getString(3), result.getString(4));
				return r;
			}
			else
				return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public static ArrayList<Recebedor> buscarTodosOsRecebedores() {
		Connection con = null;
		ArrayList<Recebedor> recebedores = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "select * from recebedor";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet result = ps.executeQuery();
			
			if(result != null) {
				System.out.println("Deu certo buscar todos os recebedores!");
				recebedores = new ArrayList<>();
				while(result.next()) {
					recebedores.add(buscarRecebedorPorId(result.getInt(2)));
				}
				return recebedores;
			}
			else
				return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static Recebedor buscarRecebedorByNome(String nome) {
		Connection con = null;
		Recebedor r = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "select * from recebedor where nome = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, nome);
			ResultSet result = ps.executeQuery();
			
			if(result != null) {
				result.next();
				System.out.println("Deu certo buscar recebedor por nome!");
				r = new Recebedor(result.getString(1), result.getInt(2), result.getString(3), result.getString(4));
				return r;
			}
			else
				return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static boolean atualizarEnderecoRecebedor(int idRecebedor, String novoEndereco) {
		Connection con = null;
		try {
			if(buscarRecebedorPorId(idRecebedor)!= null) {
				con = ConnectionFactory.getConnection();
				String sql = "update recebedor set endereco = ? where idRecebedor = ?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, novoEndereco);
				ps.setInt(2, idRecebedor);
				int result = ps.executeUpdate();
				if(result >=1) {
					System.out.println("Deu certo atualizar o endereco do recebedor!");	
					return true;
			}
			else
				System.out.println("endereco do recebedor não alterado!");
				return false;
			}
			System.out.println("endereco do recebedor não alterado!");
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static boolean removerRecebedor(int idRecebedor) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "delete from recebedor where idRecebedor = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idRecebedor);
			int result = ps.executeUpdate();
			if(result >=1) {
				System.out.println("Deu certo remover recebedor!");
				return true;
			}
			else
				return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//CRUD para boleto
	
	public static boolean cadastrarBoleto(String numeroBoleto) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "insert into boleto (numeroBoleto) values (?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, numeroBoleto);
			int result = ps.executeUpdate();
			if(result >=1) {
				System.out.println("Deu certo cadastrar boleto!");
				return true;
			}
			else
				return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static boolean removerBoleto(int idBoleto) {
		Connection con = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "delete from boleto where idBoleto = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idBoleto);
			int result = ps.executeUpdate();
			if(result >=1) {
				System.out.println("Deu certo remover boleto!");
				return true;
			}
			else
				return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static Boleto buscarBoletoById(int idBoleto) {
		Connection con = null;
		Boleto b = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "select * from boleto where idBoleto = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idBoleto);
			ResultSet result = ps.executeQuery();
			
			if(result != null) {
				System.out.println("Deu buscar boleto por id!");
				b = new Boleto(result.getInt(1), result.getString(2));
				return b;
			}
			else
				return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	/*
	 * sugestoes de consultas ou visoes
	 * 
	 * -- visao com nome do usuario, email, id da conta de titulo da conta de todas as contas dele
	 --exibir qtd de contas que cada usuario tem
	select id, nome, count(valor) from usuario, conta where id = idUsuario group by nome, id;

	--exibir o nome, id do(s) usuario(s) que tem conta de maior valor e o valor da conta
	select nome, id, valor from usuario, conta where id = idUsuario and valor = (select max(valor) from conta);

	--exibir o nome, id do(s) usuario(s) que tem conta de menor valor e o valor da conta
	select nome, id, valor from usuario, conta where id = idUsuario and valor = (select min(valor) from conta);

	--exibir o numero do boleto da(s) conta(s) da usuária 'Marta'
	select b.numeroBoleto from usuario u, conta c, boleto b where lower(u.nome) = 'marta' and u.id = c.idUsuario and c.idBoleto = b.idBoleto;

	--mostrar usuarios que nao tem conta(dívida) cadastrada
	select u.nome, u.id from usuario u where u.id not in (select id from usuario, conta where id = idUsuario);

	--exibir todos os usuários, mesmo os que não tem contas 
	select id, nome, idConta, valor from usuario left outer join conta on id = idUsuario;
	 */
	
}
