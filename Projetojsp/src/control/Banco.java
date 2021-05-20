package control;

import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;

public class Banco {
public Connection conn;
		public void bd() {
		
					
		}
		public Connection getConection() {
			return this.conn;
		}
		
		public void Conectarbd() {
			// abrir conexao com o bd
			// criar um sql para criar o bd e a tabela
			try {
				String driver = "com.mysql.jdbc.Driver";
				Class.forName(driver);
				String url = "jdbc:mysql://localhost:3306/bdlivraria";
				String user = "root";
				String password = "";
				this.conn= DriverManager.getConnection(url, user, password);
				System.out.println("conex�o feita com sucesso");
			} catch (SQLException e) {
				System.out.println("Falha ao conectar ao banco de dados: " + e);
			} catch (ClassNotFoundException e) {
				System.out.println("Erro falta do drive: " + e.toString());
			}
		}
		
	public String CriarBanco() {
		try {
			Conectarbd();
			String sql="CREATE DATABASE IF NOT EXISTS bdlivraria ";
			conn= DriverManager.getConnection(sql);
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.execute();
			return sql;
		} catch (Exception e) {
			System.out.println();
			// TODO: handle exception
		}
		return null;
	
		
		
	}
	
	
	 
	 
 public String excluirbd() {
	 this.Conectarbd();
	 try {
		String sql = "DROP DATABASE IF NOT EXISTS bdlivraria";
		conn= DriverManager.getConnection(sql);
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.execute();
		conn.close();
		System.out.println("\nBanco de dados excluido!");
		return sql;
	} catch (Exception e) {
		// TODO: handle exception
	}
	return null;


	}
}
	