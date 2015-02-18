package classes_extras;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class Conexao {
	
	public Statement stm;
	public ResultSet rs;
	private String driver="org.postgresql.Driver";
	private String caminho="jdbc:postgresql://localhost:5432/kaching";
	private String usuario="postgres";
	private String senha="123";
	public Connection conn;

	public void conectar(){
		try{
			System.setProperty("jdbc.Drivers", driver);
			conn = DriverManager.getConnection(caminho, usuario, senha);
			JOptionPane.showMessageDialog(null, "Conectado ao banco");//só pra teste
		} catch(SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro"+ex.getMessage());
		}
	}
	
	public void desconectar (){
		try{
			conn.close();
		}catch(SQLException ex){
			JOptionPane.showMessageDialog(null, "Erro ao fechar"+ex.getMessage());
		}
	}
	
	public void executarSQL(String sql){
		try{
			stm = Conexao.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = stm.executeQuery(sql);
		}catch (SQLException sqlex){
			JOptionPane.showMessageDialog(null, "Erro: "+sqlex+" comando: "+sql );
		}
	}

	private static Statement createStatement(int typeScrollSensitive,
			int concurReadOnly) {
		// TODO Auto-generated method stub
		return null;
	}
}
