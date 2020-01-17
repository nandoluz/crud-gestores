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
    public Connection getConexao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            URI dbUri = new URI(System.getenv("CLEARDB_DATABASE_URL"));
            String username = dbUri.getUserInfo().split(":")[0];
            String password = dbUri.getUserInfo().split(":")[1];
            String dbUrl = "jdbc:mysql://" + dbUri.getHost() + dbUri.getPath();
            con = (Connection) DriverManager.getConnection(dbUrl, username, password);
            System.out.println("Conexão aberta.");
            return con;
        } catch (ClassNotFoundException ex) {
            System.err.println("Classe JDBC não encontrada." +ex);
            return con;
        } catch (SQLException | URISyntaxException ex) {
            System.err.println("Erro na conexão com o banco de dados." + ex);
            return con;
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
