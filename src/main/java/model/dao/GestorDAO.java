package model.dao;

import model.bean.Gestor;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nando
 */
public class GestorDAO extends Conexao{
    public boolean create(Gestor gestor){
        getConexao(); //abre conexão com o banco
        String sql = "INSERT INTO gestores (nome, matricula, data_nascimento, setor) VALUES (?,?,?,?);";
        try {
            pstm = (PreparedStatement) con.prepareStatement(sql);
            pstm.setString(1, gestor.getNome());
            pstm.setString(2, gestor.getMatricula());
            pstm.setDate(3, new Date (gestor.getData_nascimento().getTime()));
            pstm.setString(4, gestor.getSetor());
            pstm.execute();
            System.out.println("Salvo novo gestor.");
            fecharConexao();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao salvar novo gestor: " + ex );
            fecharConexao();
            return false;
        }
    }
    public ArrayList<Gestor> readAll(){
        getConexao();
        String sql = "SELECT id, nome, matricula, data_nascimento, setor FROM gestores ORDER BY id DESC";
        ArrayList<Gestor> lista = new ArrayList<>();//lista que será adicionado os gestores retornados do banco de dados
        try {
            pstm = (PreparedStatement) con.prepareStatement(sql);
            rs = pstm.executeQuery();
            Gestor gestor;
            while(rs.next()){
                gestor = new Gestor(); //nova instancia para cada gestor buscado
                gestor.setId(rs.getInt("id"));
                gestor.setNome(rs.getString("nome"));
                gestor.setMatricula(rs.getString("matricula"));
                gestor.setData_nascimento(rs.getDate("data_nascimento"));
                gestor.setSetor(rs.getString("setor"));
                lista.add(gestor);
            }
            fecharConexao();
        } catch (SQLException | NullPointerException ex) {
            System.err.println("Erro ao buscar gestores: " + ex );
            fecharConexao();
        }
        return lista;
    }
    public ArrayList<Gestor> pesquisar(String por){
        getConexao();
        String sql = "SELECT id, nome, matricula, data_nascimento, setor FROM gestores WHERE nome LIKE '%"+por+"%' ORDER BY id DESC;";
        ArrayList<Gestor> lista = new ArrayList<>();//lista que será adicionado os gestores retornados do banco de dados
        try {
            pstm = (PreparedStatement) con.prepareStatement(sql);
            rs = pstm.executeQuery();
            Gestor gestor;
            while(rs.next()){
                gestor = new Gestor(); //nova instancia para cada gestor buscado
                gestor.setId(rs.getInt("id"));
                gestor.setNome(rs.getString("nome"));
                gestor.setMatricula(rs.getString("matricula"));
                gestor.setData_nascimento(rs.getDate("data_nascimento"));
                gestor.setSetor(rs.getString("setor"));
                lista.add(gestor);
            }
            fecharConexao();
        } catch (SQLException | NullPointerException ex) {
            System.err.println("Erro ao buscar gestores: " + ex );
            fecharConexao();
        }
        return lista;
    }
    public boolean update(Gestor gestor){
        getConexao();
        String sql = "UPDATE gestores SET nome=?, matricula=?, data_nascimento=?, setor=? WHERE id=?;";
        try {
            pstm = (PreparedStatement) con.prepareStatement(sql);
            pstm.setString(1, gestor.getNome());
            pstm.setString(2, gestor.getMatricula());
            pstm.setDate(3, new Date (gestor.getData_nascimento().getTime()));
            pstm.setString(4, gestor.getSetor());
            pstm.setInt(5, gestor.getId());
            pstm.execute();
            System.out.println("Alterações salvas gestor.");
            fecharConexao();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao alterar gestor: " + ex );
            fecharConexao();
            return false;
        }
    }
    public boolean delete(int id){
        getConexao();
        String sql = "DELETE FROM gestores WHERE id=?;";
        try {
            pstm = (PreparedStatement) con.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.execute();
            System.out.println("Gestor apagado");
            fecharConexao();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao deletar gestor: " + ex );
            fecharConexao();
            return false;
        }
    }
    public Gestor readOne(int id){
        getConexao();
        String sql = "SELECT nome, matricula, data_nascimento, setor FROM gestores WHERE id=?;";
        Gestor gestor = new Gestor();
        try {
            pstm = (PreparedStatement) con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if(rs.next()){
                gestor.setId(id);
                gestor.setNome(rs.getString("nome"));
                gestor.setMatricula(rs.getString("matricula"));
                gestor.setData_nascimento(rs.getDate("data_nascimento"));
                gestor.setSetor(rs.getString("setor"));
            }
            fecharConexao();
        } catch (SQLException ex) {
            System.err.println("Erro ao buscar gestor: " + ex );
            fecharConexao();
        }
        return gestor;
    }
}