package Dao;

import conexao.ConnConexao;
import static biblioteca.VariaveisPublicas.dataDoDia;
import static biblioteca.VariaveisPublicas.sql;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import modelo.PatriDepto;


public class DAOPatriDeptos {

    ConnConexao       conexao  = new ConnConexao(); 
    SimpleDateFormat  sdf      = new SimpleDateFormat("dd/MM/yyyy");
    
    public boolean salvarPatriDeptosDAO(PatriDepto umPatriDepto) 
    {
        conexao.conectar();
        try 
        {
            sql = "INSERT INTO TBLPATRIDEPTOS (tipoid, serie, chapa, origem, dtentrada, memoenvio, memodevolucao, status, obs) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = conexao.getConnection().prepareStatement(sql);
            pst.setInt(1, umPatriDepto.getTipoid());
            pst.setString(2, umPatriDepto.getSerie());
            pst.setString(3, umPatriDepto.getChapa());
            pst.setString(4, umPatriDepto.getOrigem());
            pst.setString(5, umPatriDepto.getDtentrada());
            pst.setString(6, "N");
            pst.setString(7, "N");
            pst.setString(8, umPatriDepto.getStatus());
            pst.setString(9, umPatriDepto.getObs());            
            pst.executeUpdate();
            pst.close(); 
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Não foi possível executar o comando sql, \n"+e+", o sql passado foi \n"+sql);  
            return false;
        } finally {
            conexao.desconectar();
        }
    }
    
    public boolean AtualizarPatriDeptosDAO(PatriDepto umPatriDeptos) 
    {
        conexao.conectar();
        try
        {
            sql = "UPDATE TBLPATRIDEPTOS SET tipoid=?, serie=?, chapa=?, origem=?, destino=?, dtenvio=?, memoenvio=?, dtdevolucao=?, memodevolucao=?, status=?, obs=? WHERE codigo=?";
            PreparedStatement pst = conexao.getConnection().prepareStatement(sql);
            pst.setInt(1, umPatriDeptos.getTipoid());
            pst.setString(2, umPatriDeptos.getSerie());
            pst.setString(3, umPatriDeptos.getChapa());
            pst.setString(4, umPatriDeptos.getOrigem());
            pst.setString(5, umPatriDeptos.getDestino());
            pst.setString(6, umPatriDeptos.getDtenvio());
            pst.setString(7, umPatriDeptos.getMemoenvio());
            pst.setString(8, umPatriDeptos.getDtdevolucao()); 
            pst.setString(9, umPatriDeptos.getMemodevolucao()); 
            pst.setString(10, umPatriDeptos.getStatus());
            pst.setString(11, umPatriDeptos.getObs());
            pst.setInt(12, umPatriDeptos.getCodigo());
            pst.executeUpdate();
            pst.close();  
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Não foi possível atualizar o registro, \n "+e+" , o sql passado foi \n"+sql);  
            return false;
        }finally{
            conexao.desconectar();
        }        
    }    
    
    public PatriDepto pesquisarPatriDeptoDAO(PatriDepto umPatridepto) 
    {    
        conexao.conectar();
        try
        {       
            sql =     "SELECT * FROM tblpatrideptos WHERE "
                    + "(serie = '"+umPatridepto.getSerie()+"' OR chapa = '"+umPatridepto.getChapa()+"' "
                    + "OR origem = '"+umPatridepto.getOrigem()+"' OR destino = '"+umPatridepto.getDestino()+"' "
                    + "OR codigo = '"+umPatridepto.getCodigo()+"') "
                    + "ORDER BY codigo";      
            
            conexao.ExecutarPesquisaSQL(sql);
            
            while (conexao.rs.next())
            {
                umPatridepto.setCodigo(conexao.rs.getInt("codigo"));
                umPatridepto.setTipoid(conexao.rs.getInt("tipoid"));
                umPatridepto.setSerie(conexao.rs.getString("serie"));
                umPatridepto.setChapa(conexao.rs.getString("chapa"));
                umPatridepto.setOrigem(conexao.rs.getString("origem"));
                umPatridepto.setDestino(conexao.rs.getString("destino"));     
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Não foi possível executar o comando sql, \n"+e+", o sql passado foi \n"+sql); 
        } finally {
            conexao.desconectar();
        }
        return umPatridepto;
    } 
                    
}