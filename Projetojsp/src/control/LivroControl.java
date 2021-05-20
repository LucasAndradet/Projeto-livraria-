package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Livro;

public class LivroControl {

	private Banco bd = new Banco();

	// TODO: handle exception

	public String exibirLivrosCadastrados() {
		this.bd.Conectarbd();
		try {

			String sql = "SELECT * FROM Livro";
			Connection conn = DriverManager.getConnection(sql);
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {

				System.out.println("Nome do livro: " + resultado.getString("nome") + "\tAutor: "
						+ resultado.getString("autor") + " \tEditora: " + resultado.getString("editora")
						+ "\tQuantidade de P�ginas: " + resultado.getInt("nrPaginas") + "\tPre�o do livro: "
						+ resultado.getDouble("preco") + "\n");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public String excluirLivro(String nome) {
		try {

			String sql = "DELETE FROM Livro WHERE nome=?";
			Connection conn = DriverManager.getConnection(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, nome);
			ps.execute();

			System.out.println("\nLivro excluido!");
			conn.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}


	public boolean cadastrarLivro(Livro livro) {
		//if(validarCampos(livro)) {
	System.out.println("ola");
		try {
			this.bd.Conectarbd();
			String sql = "INSERT INTO livro (nome , autor, editora, nrPaginas, preco) values (?,?,?,?,?)";
			Connection conn = this.bd.getConection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, livro.getNome());
			ps.setString(2, livro.getAutor());
			ps.setString(3, livro.getEditora());
			ps.setInt(4, livro.getNrPaginas());
			ps.setDouble(5, livro.getPreco());

			ps.execute();
			System.out.println(livro.toString());

	

			conn.close();
			return true;
		} catch (Exception e) {
			System.out.println("Erro ao conectar ao banco de dados. Erro 1 : " + e.toString());
			// TODO: handle exception
		}
	
		
	
		//}
		return false;
	}
	public boolean isVazio(String campo) {
		return campo == null || campo.trim().equals("");
	}
	public String isValorValido(double preco) {
	
		if(preco<0) {
		return "-valor do pre�o n�o pode ser negativo";
		}
		else if(preco==0){
				return"- valor do livro n�o pode ser zero";
			}else if(Double.isNaN(preco)) {
				return "-valor do pre�o deve ser um numero";
		
		
	} else {
		return "";
	}
	}
	public static boolean isInt(String text) {
	try {
		Integer.parseInt(text);
		return true;
	} catch (Exception e) {
		return false;
	}
		// TODO: handle exception
	}
	public String isNumeroValido(int nrPaginas) {
		if(nrPaginas<0) {
			return "-numero de paginas nao pode ser negativo";
		}else if(nrPaginas==0) {
			return "-numero de paginas n�o pode ser zero";
		}else if(isInt(String.valueOf(nrPaginas))) {
			return "-numeros de paginas so podem ser contados por numeros";
		}else {
			return "";
		}
	}
			
		
	
	
	private boolean validarCampos(Livro livro) {
		String msg = "";

		//Nome
		if (isVazio(livro.getNome()))
			msg += "- Nome n�o preenchido.\n";
		//autor
		if (isVazio(livro.getAutor()))
			msg += "- CPF n�o preenchido.\n";
		//editora
		if (isVazio(livro.getEditora()))
			msg += "- editora não preenchida.\n";
	String validacaoPreco=isValorValido(livro.getPreco());
		if(validacaoPreco != "") {
			msg += validacaoPreco;
		}
		
String validarNumero=isNumeroValido(livro.getNrPaginas());
		if(validarNumero!="") {
			msg+= validarNumero;
		}
		
		return msg.trim().equals(""); //se "msg" estiver vazio, retorna true
	}
	public void CriartabelaLivro() {
		this.bd.Conectarbd();
		try {
			String sql = "CREATE TABLE IF NOT EXISTS Livro(id int PRIMARY KEY AUTO_INCREMENT, nome varchar(255) NOT NULL, autor varchar(255) NOT NULL, editora varchar(255) NOT NULL, nrPaginas int NOT NULL, preco double NOT NULL )";
			Connection conn = DriverManager.getConnection(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.execute();

			conn.close();
			System.out.println("\nTabela Livros criada!");

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void excluirtabelaLivro() {
		this.bd.Conectarbd();
		try {
			String sql = "DROP TABLE IF  EXISTS livros";
			Connection conn = this.bd.getConection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public Livro localizar(String nome) {
		this.bd.Conectarbd();
		try {

			Connection conn = this.bd.getConection();
			String sql = "SELECT * FROM livro where nome =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, nome);
			ResultSet resultado = ps.executeQuery();
			if (resultado.isBeforeFirst()) {

				if (resultado.next()) {
					Livro livro = new Livro(resultado.getString("nome"), resultado.getString("autor"),
							resultado.getString("editora"), resultado.getInt("nrPaginas"),
							resultado.getDouble("preco"));

					System.out.println("");
					conn.close();
					return livro;
				}

			} else {
				System.out.println("N�o foi encontrada nenhuma informa��o com esse cpf");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	public boolean editarLivro(Livro l, String nome, String campoAlterado) {
		this.bd.Conectarbd();

		try {

			Connection conn = this.bd.getConection();
			String sql = null;
			PreparedStatement ps;
			switch (campoAlterado) {
			case "nome":
				sql = "UPDATE Livro set nome=? where nome=? ";
				ps = conn.prepareStatement(sql);
				ps.setString(1, l.getNome());
				ps.setString(2, nome);
				ps.executeUpdate();
				break;
			case "autor":
				sql = "UPDATE Livro set autor=? where nome=? ";
				ps = conn.prepareStatement(sql);
				ps.setString(1, l.getAutor());
				ps.setString(2, nome);
				ps.executeUpdate();
				break;

			case "editora":
				sql = "UPDATE livro set editora=? where nome=? ";
				ps = conn.prepareStatement(sql);
				ps.setString(1, l.getEditora());
				ps.setString(2, nome);
				ps.executeUpdate();
				break;
			case "nrPaginas":
				sql = "UPDATE Livro set nrPaginas =? where nome=? ";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, l.getNrPaginas());
				ps.setString(2, nome);
				ps.executeUpdate();
				break;
			case "preco":
				sql = "UPDATE Livro set preco =? where nome=? ";
				ps = conn.prepareStatement(sql);
				ps.setDouble(1, l.getPreco());
				ps.setString(2, nome);
				ps.executeUpdate();
				break;

			default:
				break;
			}

			conn.close();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());

			// TODO: handle exception
		}
		return false;
	}
}
