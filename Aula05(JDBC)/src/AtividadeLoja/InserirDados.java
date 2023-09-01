package AtividadeLoja;

import javax.swing.*;
import java.awt.Container;
import java.awt.FlowLayout;
import java.sql.*;

public class InserirDados extends JFrame {
	private Connection con;
	private Statement st;

	public InserirDados() throws SQLException{
		String driver = "org.postgresql.Driver";
		String sUsuario = "postgres";
		String sSenha = "123";
		String sFonte = "jdbc:postgresql://localhost:5434/postgres";

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(sFonte, sUsuario, sSenha);
			JOptionPane.showMessageDialog(this,"Banco conectado com sucesso!","Mensagem", JOptionPane.WARNING_MESSAGE);
		}catch (SQLException eSQL) {
			// exce��es de SQL
			eSQL.printStackTrace();
			JOptionPane.showMessageDialog(this,"Falha na conex�o com o banco!\n" +"Mensagem: " + eSQL.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e) {
			// demais exce��es
			e.printStackTrace();
			JOptionPane.showMessageDialog(this,"Falha na conex�o com o banco!\n" +"Mensagem: " + e.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		try{
			//cria statement para consultar banco de dados
			st = con.createStatement();
			//Cadastro de valores pre-definidos
			st.executeUpdate ("INSERT INTO Loja values(1,'Arroz');");
			st.executeUpdate ("INSERT INTO Loja values(2,'Feij�o');");
			st.executeUpdate ("INSERT INTO Loja values(3,'Macarr�o');");
		}catch(SQLException eSQL){
			JOptionPane.showMessageDialog(this,"Erro na express�o do INSERT!\n" +"Mensagem: " + eSQL.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		
		try {
			st.close();
			con.close();
		}catch(Exception exception){
			exception.printStackTrace();
			System.exit(2);
		}
		
		Container P = getContentPane();
		P.setLayout(new FlowLayout());
		JLabel mensagem = new JLabel("Voc� acabou de testar um exemplo usando INSERT!");
		P.add(mensagem);
	}
	
	public static void main(String args[]) throws SQLException{
		InserirDados ex = new InserirDados();
		ex.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ex.setVisible(true);
		ex.setTitle("USANDO INSERT");
		ex.setSize(400,200);
	}
	
}
