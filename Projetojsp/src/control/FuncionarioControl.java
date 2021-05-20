package control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Funcionario;

public class FuncionarioControl {
	private Banco bd = new Banco();

	public void Criartabelafuncionario() {
		bd.Conectarbd();
		String sql = "CREATE TABLE IF NOT EXISTS Funcionario(int id PRIMARY KEY AUTO_INCREMENT, nome varchar(255) ,cpf varchar(9) NOT NULL UNIQUE ,tel varchar(255),cel varchar(9)NOT NULL UNIQUE,idt varchar(255)NOT NULL UNIQUE,email varchar(255)NOT NULL UNIQUE,usuario NOT NULL UNIQUE,senha NOT NULL UNIQUE";
		try {
			Connection conn = this.bd.getConection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeQuery();
		} catch (Exception e) {

			// TODO: handle exception
		}

	}

	public Funcionario localizarUsuario(String usuario) {

		this.bd.Conectarbd();
		try {

			Connection conn = this.bd.getConection();
			String sql = "SELECT * FROM funcionario where usuario =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, usuario);
			ResultSet resultado = ps.executeQuery();

			if (resultado.isBeforeFirst()) {

				if (resultado.next()) {

					Funcionario funcionario = new Funcionario(resultado.getString("nome"), resultado.getString("cpf"),
							resultado.getString("tel"), resultado.getString("cel"), resultado.getString("idt"),
							resultado.getString("email"));
					funcionario.login(usuario, resultado.getString("senha"));
					return funcionario;
				}

			}
		} catch (Exception e) {
			System.out.println(e.toString());
			// TODO: handle exception
		}
		return null;
	}

	public void excluirTabelaFuncionario() {
		this.bd.Conectarbd();
		String sql = "DROP TABLE IF EXISTS funcionario";
		Connection conn = this.bd.getConection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.execute();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public boolean isVazio(String campo) {
		return campo == null || campo.trim().equals("");
	}

	public boolean validarCampos(Funcionario funcionario) {
		String msg = "";

		// Nome
		if (isVazio(funcionario.getNome()))
			msg += "- Nome não preenchido.\n";
		// CPF
		if (isVazio(funcionario.getCpf()))
			msg += "- CPF não preenchido.\n";
		// Celular
		if (isVazio(funcionario.getCel()))
			msg += "- Celular não preenchido.\n";
		// Identidade
		if (isVazio(funcionario.getIdt()))
			msg += "- Identidade não preenchido.\n";
		// Email
		if (isVazio(funcionario.getEmail()))
			msg += "- Email não preenchido.\n";

		if (!msg.trim().equals(""))
			System.out.println(msg);

		return msg.trim().equals(""); // se "msg" estiver vazio, retorna true
	}

	public List<Funcionario> listarTudo() {
		Funcionario f = new Funcionario();
		List<Funcionario> listFuncionario = new ArrayList<Funcionario>();

		try {
			this.bd.Conectarbd();
			String sql = "SELECT * FROM Funcionario";
			Connection conn = this.bd.getConection();
			Statement st = conn.createStatement();
			ResultSet resultado = st.executeQuery(sql);

			while (resultado.next()) {
				System.out.println(resultado.getString("nome"));
				f.setNome(resultado.getString("nome"));
				f.setCpf(resultado.getString("cpf"));
				f.setCel(resultado.getString("cel"));
				f.setTel(resultado.getString("tel"));
				f.setIdt(resultado.getString("idt"));
				f.setEmail(resultado.getString("email"));
				listFuncionario.add(f);

			}

			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
			e.printStackTrace();
		}
		return listFuncionario;

	}

	public Funcionario localizar(String cpf) {
		this.bd.Conectarbd();
		try {

			Connection conn = this.bd.getConection();
			String sql = "SELECT * FROM funcionario where cpf =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cpf);
			ResultSet resultado = ps.executeQuery();

			if (resultado.isBeforeFirst()) {

				if (resultado.next()) {

					Funcionario funcionario = new Funcionario(resultado.getString("nome"), resultado.getString("cpf"),
							resultado.getString("tel"), resultado.getString("cel"), resultado.getString("idt"),
							resultado.getString("email"));
					System.out.println(
							"funcionario encontrado. nome= " + funcionario.getNome() + " cpf= " + funcionario.getCpf());
					return funcionario;

				}

			} else {
				System.out.println("Nï¿½o foi encontrada nenhuma informaï¿½ï¿½o com esse cpf");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	public void deletar(String cpf) {
		// Falta tratar
		this.bd.Conectarbd();
		try {
			Connection conn = this.bd.getConection();
			String sql = "DELETE FROM funcionario WHERE cpf=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cpf);
			ps.execute();
			conn.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}

	}

	public boolean criarFuncionario(Funcionario funcionario) {
		System.out.println("ola");
		if (validarCampos(funcionario)) {

			try {
				this.bd.Conectarbd();

				String sql = "INSERT INTO funcionario (nome, cpf, tel, cel, idt, email) VALUES(?,?,?,?,?,?)";
				Connection conn = this.bd.getConection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setString(1, funcionario.getNome());
				ps.setString(2, funcionario.getCpf());
				ps.setString(3, funcionario.getTel());
				ps.setString(4, funcionario.getCel());
				ps.setString(5, funcionario.getIdt());
				ps.setString(6, funcionario.getEmail());
				ps.execute();
				conn.close();
				return true;
			} catch (Exception e) {
				System.out.println("Erro ao conectar ao banco de dados. Erro 1 : " + e.toString());
			}
		}
		// TODO: handle exception
		return false;
	}

	public boolean editarFuncionario(Funcionario f, String cpf) {
		if (validarCampos(f)) {

			try {
				this.bd.Conectarbd();
				Connection conn = this.bd.getConection();
				String sql = null;
				PreparedStatement ps;
				sql = "UPDATE funcionario set nome=?,cpf=?,tel=?,cel=?,idt=?,email=? where cpf=? ";
				ps = conn.prepareStatement(sql);
				ps.setString(1, f.getNome());
				ps.setString(2, f.getCpf());
				ps.setString(3, f.getTel());
				ps.setString(4, f.getCel());
				ps.setString(5, f.getIdt());
				ps.setString(6, f.getEmail());
				ps.setString(7, cpf);
				ps.executeUpdate();

				conn.close();
				return true;
			} catch (Exception e) {
				System.out.println(e.getMessage().toString());

				// TODO: handle exception
			}
		}
		return false;
	}
	public boolean atualizarFuncionario(Funcionario f) {
		if (validarCampos(f)) {

			try {
				this.bd.Conectarbd();
				Connection conn = this.bd.getConection();
				String sql = null;
				PreparedStatement ps;
				sql = "UPDATE funcionario set usuario=?,senha=? where cpf=? ";
				ps = conn.prepareStatement(sql);
				ps.setString(1, f.getUsuario());
				ps.setString(2, f.getSenha());
				ps.setString(3, f.getCpf());
				ps.executeUpdate();

				conn.close();
				return true;
			} catch (Exception e) {
				System.out.println(e.getMessage().toString());

				// TODO: handle exception
			}
		}
		return false;
	}
}

