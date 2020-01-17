package model.dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author nando
 */
public class Conexao {
    Connection con;
    PreparedStatement pstm;
    ResultSet rs;
    public void getConexao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://us-cdbr-iron-east-05.cleardb.net:3306/heroku_a0953116a219a95", "bbac8f9e95d3f9", "a43a95ea");
            System.out.println("Conexão aberta.");
        } catch (ClassNotFoundException ex) {
            System.err.println("Classe JDBC não encontrada." +ex);
        } catch (SQLException ex) {
            System.err.println("Erro na conexão com o banco de dados." + ex);
        }
    }
    public void fecharConexao(){
        if(con != null){
            try {
                con.close();
                pstm.close();
                if(rs != null){
                    rs.close();
                }
                System.out.println("Conexão fechada");
            } catch (SQLException ex) {
                System.err.println("Erro ao fechar conexão." + ex);
            }
        }
    }
}
