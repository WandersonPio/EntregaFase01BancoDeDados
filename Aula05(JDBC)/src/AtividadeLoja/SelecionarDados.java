package AtividadeLoja;

import javax.swing.*;
import java.awt.Container;
import java.awt.FlowLayout;
import java.sql.*;

public class SelecionarDados extends JFrame {
	private Connection con;
	private Statement st;

	public SelecionarDados() throws SQLException{
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
			JOptionPane.showMessageDialog(this,"Falha na conex�o com o banco!\n" + "Mensagem: " + eSQL.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e) {
			// demais exce��es
			e.printStackTrace();
			JOptionPane.showMessageDialog(this,"Falha na conex�o com o banco!\n" +"Mensagem: " + e.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		try{
			st = con.createStatement();
			ResultSet resultSet = st.executeQuery("SELECT * FROM Loja;");
			//processa resultados da consulta
			ResultSetMetaData metaData = resultSet.getMetaData();
			int numberOfColumns = metaData.getColumnCount();
			System.out.println("Rela��o de pessoas cadastradas");
			for (int i=1; i<=numberOfColumns; i++){
				//exibe o nome dos campos da tabela
				System.out.printf("%-8s\t",metaData.getColumnName(i));
			}
			while (resultSet.next()){
				System.out.println();
				String linha = "";
				for (int x=1; x<=numberOfColumns; x++){
					//exibe o conteudo dos campos
					System.out.printf("%-8s\t",resultSet.getObject(x));
					linha = linha + " " + resultSet.getObject(x);
				}
			}
		}catch(SQLException eSQL){
			JOptionPane.showMessageDialog(this,"Erro na express�o do SELECT!\n" + "Mensagem: " + eSQL.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
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
		JLabel mensagem1 = new JLabel("Voc� acabou de testar um exemplo usando SELECT!");
		JLabel mensagem2 = new JLabel("O resultado da consulta esta no Console!");
		P.add(mensagem1);
		P.add(mensagem2);
	}
	
	public static void main(String args[]) throws SQLException{
		SelecionarDados ex = new SelecionarDados ();
		ex.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ex.setVisible(true);
		ex.setTitle("USANDO SELECT");
		ex.setSize(400,200);
	}
}