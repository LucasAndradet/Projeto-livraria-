package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Cliente;
import model.Funcionario;

public class ClienteControl {
	Banco bd = new Banco();

	public Cliente localizar(String cpf) {
		this.bd.Conectarbd();
		try {

			Connection conn = this.bd.getConection();
			String sql = "SELECT * FROM Cliente where cpf =?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cpf);
			ResultSet resultado = ps.executeQuery();
			if (resultado.isBeforeFirst()) {
				if (resultado.next()) {
					Cliente Cliente = new Cliente(resultado.getString("nome"), resultado.getString("cpf"),
							resultado.getString("sexo"), resultado.getInt("idade"));
					System.out.println("Cliente encontrado. nome= " + Cliente.getNome() + " cpf= " + Cliente.getCpf());

					return Cliente;
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	public void criarTabelaCliente() {
		this.bd.Conectarbd();
		try {

			Connection conn = this.bd.getConection();
			String sql = "CREATE TABLE IF NOT EXISTS Cliente (id int PRIMARY KEY auto_increment, nome varchar(255) , idade int, sexo varchar(11), cpf varchar(20) UNIQUE )";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.execute();

			conn.close();
			System.out.println("\nTabela Clientes criada!");

		} catch (Exception e) {

			System.out.println("Erro ao conectar ao banco de dados. Erro 1 : " + e.toString());
		}

	}

	public String excluirTabelaCliente() {
		this.bd.Conectarbd();
		try {
			Connection conn = this.bd.getConection();
			String sql = "DROP TABLE IF  EXISTS Cliente";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.execute();

			conn.close();
			System.out.println("\nTabela Clientes excluida!");

		} catch (Exception e) {

			System.out.println("Erro ao conectar ao banco de dados. Erro 1 : " + e.toString());
		}
		return null;
	}
	public boolean cadastrarCliente(Cliente cliente) {
	if(validarCampos(cliente)) {
		try {
		this.bd.Conectarbd();
			
			String sql = "insert into Cliente (nome, cpf, sexo, idade) values (?,?,?,?)";
			Connection conn = this.bd.getConection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,cliente.getNome() );
			ps.setString(2, cliente.getCpf());
			ps.setString(3, cliente.getSexo());
			ps.setInt(4, cliente.getIdade());

			ps.execute();

		

			conn.close();
			return true;
		} catch (Exception e) {

			System.out.println("Erro ao conectar ao banco de dados. Erro 1 : " + e.toString());
		}
	
	}
	return false;
	}

	public void cadastrarCliente(String nome, String cpf, String sexo, int idade) {
		Cliente Cliente = new Cliente(nome, cpf, sexo, idade);
		this.bd.Conectarbd();
		try {

			String sql = "insert into Cliente (nome, idade, sexo, cpf) values (?,?,?,?)";
			Connection conn = this.bd.getConection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, nome);
			ps.setString(2, cpf);
			ps.setString(3, sexo);
			ps.setInt(4, idade);

			ps.executeUpdate();

			System.out.println("\nCliente inserido!");

			conn.close();
			System.out.println(Cliente.toString());
		} catch (Exception e) {

			System.out.println("Erro ao conectar ao banco de dados. Erro 1 : " + e.toString());
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
	public String isIdadeValida(int idade) {
		if(idade<0) {
			return "-idade nao pode ser negativa";
		}else if(idade==0) {
			return "-numero de paginas não pode ser zero";
		}else if(!isInt(String.valueOf(idade))) {
			return "-idade  so pode ser contada por numeros";
		}else {
			return "";
		}
	}
	public boolean isVazio(String campo) {
		return campo == null || campo.trim().equals("");
	}
	private boolean validarCampos(Cliente c) {
		String msg = "";

		//Nome
		if (isVazio(c.getNome()))
			msg += "- Nome n�o preenchido.\n";
		//CPF
		if (isVazio(c.getCpf()))
			msg += "- CPF n�o preenchido.\n";
		//Celular
		if (isVazio(c.getSexo()))
			msg += "- sexo não preenchido.\n";		
		//Email
		String validarIdade=isIdadeValida(c.getIdade());
		if(validarIdade != "") 
			msg += validarIdade;
			
		if (!msg.trim().equals(""))
			System.out.println(msg);

		return msg.trim().equals(""); 
		}
		//se "msg" estiver vazio, retorna true

	
	public void excluirCliente(String cpf) {
		this.bd.Conectarbd();
		try {

			Connection conn = this.bd.getConection();
			String sql = "DELETE FROM Cliente WHERE cpf = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cpf);
			ps.executeUpdate();
			conn.close();
			System.out.println("\nCliente Excluido!");

			conn.close();

		} catch (Exception e) {

			System.out.println("Erro ao conectar ao banco de dados. Erro 1 : " + e.toString());
		}

	}

	public void exibirClientesCadastrados() {

		try {

			String sql = "SELECT nome, idade, sexo, cpf  FROM Cliente;";
			Connection conn = DriverManager.getConnection(sql);
			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet resultado = stmt.executeQuery();
			while (resultado.next()) {

				System.out.println("Nome do cliente: " + resultado.getString("nome") + "\tIdade: "
						+ resultado.getInt("idade") + " \tSexo: " + resultado.getString("sexo") + "\tCPF: "
						+ resultado.getString("cpf") + "\n");
			}

			conn.close();

		} catch (Exception e) {

			System.out.println("Erro ao conectar ao banco de dados. Erro 1 : " + e.toString());

		}
	}

	public boolean editarCliente(Cliente c, String cpf, String campoAlterado) {
		this.bd.Conectarbd();
		try {
			Connection conn = this.bd.getConection();
			String sql = null;
			switch (campoAlterado) {
			case "nome":
				sql = "UPDATE Cliente set nome=? where cpf=? ";
				break;
			case "cpf":
				sql = "UPDATE Cliente set cpf=? where cpf=? ";
				break;

			case "sexo":
				sql = "UPDATE Cliente set sexo=? where cpf=? ";
				break;
			case "cel":
				sql = "UPDATE Cliente set idade =? where cpf=? ";
				break;
			default:

			}
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.executeUpdate();
			conn.close();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());

			// TODO: handle exception
		}
		return false;
	}
public boolean atualizarCliente(Cliente c) {
	this.bd.Conectarbd();
	try {
		Connection conn = this.bd.getConection();
		String sql = null;
	
		
			sql = "UPDATE Cliente set usuario=?,senha=? where cpf=? ";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, c.getUsuario());
		ps.setString(2, c.getSenha());
		ps.setString(3, c.getCpf());
		ps.executeUpdate();
		conn.close();
		return true;
	} catch (Exception e) {
		System.out.println(e.getMessage().toString());

		// TODO: handle exception
	}
	return false;
}
}