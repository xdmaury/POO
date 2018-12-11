
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author maury
 */
public class ContaDAO {

    private static ContaDAO instance;

    private ContaDAO() {
        MySQLDAO.getConnection();
    }

    public static ContaDAO getInstance() {
        if (instance == null) {
            instance = new ContaDAO();
        }
        return instance;
    }

    public long create(Conta conta) {
        String query = "INSERT INTO tbl_conta (num_conta, senha, saldo_disponivel, saldo_total) VALUES (?,?,?,?)";
        return MySQLDAO.executeQuery(query, conta.getNumConta(), conta.getSenha(), conta.getSaldo_disponível(), conta.getSaldo_total());
    }
    public void update(Conta conta) {
        String query = "UPDATE tbl_conta SET senha=?, saldo_disponivel=?, saldo_total=? WHERE num_conta = ?";
        MySQLDAO.executeQuery(query, conta.getSenha(), conta.getSaldo_disponível(), conta.getSaldo_total(), conta.getNumConta());
    }

    public void delete(Conta conta) {
        MySQLDAO.executeQuery("DELETE FROM tbl_conta WHERE num_conta = ?", conta.getNumConta());
    }

    public ArrayList<Conta> findAllContas() {
        return listaConta("SELECT * FROM tbl_conta ORDER BY Nome");
    }

    public ArrayList<Conta> listaConta(String query) {
        ArrayList<Conta> lista = new ArrayList<Conta>();
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet(query);
        try {
            while (rs.next()) {
                lista.add(new Conta(rs.getInt("num_conta"), rs.getString("senha"), rs.getDouble("saldo_disponivel"), rs.getDouble("saldo_total")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public Conta findConta(int id) {
        Conta result = null;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM tbl_conta WHERE num_conta=?", id);
        try {
            if (rs.next()) {
                result = new Conta(rs.getInt("num_conta"), rs.getString("senha"), rs.getDouble("saldo_disponivel"), rs.getDouble("saldo_total"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public boolean isExistConta(int numConta, String senha){
        Boolean resut = false;
        ResultSet rs = null;
        rs = MySQLDAO.getResultSet("SELECT * FROM tbl_cnta WHERE num_conta=? AND senha=?", numConta, senha);
        try{
            if(rs.next()){
                resut = true;
            }
            rs.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return resut;
    }

}
