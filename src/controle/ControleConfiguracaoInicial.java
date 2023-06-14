/*
 Controla e grava as configurações iniciais se necessário
 */
package controle;

import conexao.ConnConexao;
import static biblioteca.VariaveisPublicas.sql;
import static biblioteca.VariaveisPublicas.confIni;
import java.sql.Connection;
import javax.swing.JOptionPane;


public class ControleConfiguracaoInicial
{
    ConnConexao         conexao             = new ConnConexao();
    Connection          conn                = null;      
    CtrlUsuario         objControleUsuario  = new CtrlUsuario();
    CtrlSecoes          objSecao            = new CtrlSecoes();
    CtrlDepartamento    objDepto            = new CtrlDepartamento();
    CtrlLog             objLog              = new CtrlLog();    
    
    public void gravarConfiguracoesInciais()
    {
        try
        { 
            conn = conexao.conectar();
            sql = "SELECT * FROM tblusuarios";   
            conexao.ExecutarPesquisaSQL(sql);
            if(!conexao.rs.next())
            {
                //objControleUsuario.salvarUsuarioInicial();
                objDepto.salvarDepartamentoInicialDAO();
                objSecao.salvarSecaoInicial();
                objLog.salvarLogInicial();   
                confIni = true;
                JOptionPane.showMessageDialog(null,"Configuração inicial feita com sucesso!","Configuração inicial!",2);      
            }                
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Não foi possível executar o comando sql, \n"+e+", o sql passado foi \n"+sql); 
        } finally {
            conexao.desconectar();
        } 
    }
    
}
