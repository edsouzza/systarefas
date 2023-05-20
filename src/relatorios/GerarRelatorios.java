//Impressão de relatórios através do JasperStudio
package relatorios;

import conexao.ConnConexao;
import biblioteca.Biblioteca;
import static biblioteca.VariaveisPublicas.indiceItemSelecionado;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import javax.swing.ImageIcon;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class GerarRelatorios 
{
    Connection conexao   = ConnConexao.conectar();
    Biblioteca umabiblio = new Biblioteca();
    
    //imprimindo os micros
     public void imprimirTodos(String caminho, String tabela) throws JRException,Exception
    {
        //para mostrar somente o nome da tabela no formulario do jasperrport no metodo viewer.setTitle
        String nomeTabela = tabela.substring(3);    
        //exibindo o relatorio
        JasperPrint impressao = JasperFillManager.fillReport( caminho , null, conexao );
        JasperViewer viewer   = new JasperViewer( impressao , false );
        viewer.setTitle("Relatório de "+nomeTabela); //titulo a ser mostrado no formulario de relatorio
        viewer.setZoomRatio(new Float(0.7956));      //ajustando o relatorio na pagina
        viewer.setVisible(true);    
        conexao.close();        
    } 
     public void imprimirSelecionado(String caminho, int codigo, String tabela) throws JRException,Exception
    {
        //para mostrar somente o nome da tabela no formulario do jasperrport no metodo viewer.setTitle
        String nomeTabela = tabela.substring(3);    
        //exibindo o relatorio
        HashMap filtro = new HashMap();
        filtro.put("codigo", codigo);
        JasperPrint impressao = JasperFillManager.fillReport( caminho, filtro, conexao );
        JasperViewer viewer   = new JasperViewer( impressao , false );
        viewer.setTitle("Relatório de "+nomeTabela); //titulo a ser mostrado no formulario de relatorio
        viewer.setZoomRatio(new Float(0.7956));      //ajustando o relatorio na pagina
        viewer.setVisible(true);        
        conexao.close();        
    } 
    public void imprimirTodosPatrimonios(String caminho, String tabela) throws JRException,Exception
    {
        //para mostrar somente o nome da tabela no formulario do jasperrport no metodo viewer.setTitle
        String nomeTabela = tabela.substring(3);    
        //exibindo o relatorio
        JasperPrint impressao = JasperFillManager.fillReport( caminho , null, conexao );
        JasperViewer viewer   = new JasperViewer( impressao , false );
        viewer.setTitle("Relatório de "+nomeTabela); //titulo a ser mostrado no formulario de relatorio
        viewer.setZoomRatio(new Float(0.7956));      //ajustando o relatorio na pagina
        viewer.setVisible(true);        
        conexao.close();        
    } 
    public void imprimirPatrimonioSelecionado(String caminho, int codigo, String tabela) throws JRException,Exception
    {
        //para mostrar somente o nome da tabela no formulario do jasperrport no metodo viewer.setTitle
        String nomeTabela = tabela.substring(3);    
        //exibindo o relatorio
        HashMap filtro = new HashMap();
        filtro.put("codigo", codigo);
        JasperPrint impressao = JasperFillManager.fillReport( caminho, filtro, conexao );
        JasperViewer viewer   = new JasperViewer( impressao , false );
        viewer.setTitle("Relatório de "+nomeTabela); //titulo a ser mostrado no formulario de relatorio
        viewer.setZoomRatio(new Float(0.7956));      //ajustando o relatorio na pagina
        viewer.setVisible(true);        
        conexao.close();        
    } 
    public void imprimirPatrimoniosFiltrados(String caminho, String secao, String tabela) throws JRException,Exception
    {
        //para mostrar somente o nome da tabela no formulario do jasperrport no metodo viewer.setTitle
        String nomeTabela = tabela.substring(3);        
        //exibindo o relatorio
        HashMap filtro = new HashMap();
        filtro.put("nomeSecao", secao);
        JasperPrint impressao = JasperFillManager.fillReport( caminho, filtro, conexao );
        JasperViewer viewer   = new JasperViewer( impressao , false );
        viewer.setTitle("Relatório de "+nomeTabela); //titulo a ser mostrado no formulario de relatorio
        viewer.setZoomRatio(new Float(0.7956));      //ajustando o relatorio na pagina
        viewer.setVisible(true);        
        conexao.close();        
    } 
    public void imprimirSomenteTipoSelecionado(String caminho, int idTipo, String tabela ) throws JRException,Exception
    {
        //para mostrar somente o nome da tabela no formulario do jasperrport no metodo viewer.setTitle
        String titulo = umabiblio.retornaStringPassandoInteiro(idTipo, "tipo", "tbltipos");
        //exibindo o relatorio
        HashMap filtro = new HashMap();
        filtro.put("idtipo", idTipo);
        JasperPrint impressao = JasperFillManager.fillReport( caminho, filtro, conexao );
        JasperViewer viewer   = new JasperViewer( impressao , false );
        viewer.setTitle("Relatório de "+titulo); //titulo a ser mostrado no formulario de relatorio
        viewer.setZoomRatio(new Float(0.7956));      //ajustando o relatorio na pagina
        viewer.setVisible(true);        
        conexao.close();        
    }
    public void imprimirPatrimoniosFiltradosPorModeloSecao(String caminho, int codmodelo, int codsecao) throws JRException,Exception
    {
        //para mostrar somente o nome da tabela no formulario do jasperrport no metodo viewer.setTitle
        //String nomeTabela = tabela.substring(3);    
        //exibindo o relatorio
        HashMap filtro = new HashMap();
        filtro.put("codModelo", codmodelo);
        filtro.put("codSecao", codsecao);
        JasperPrint impressao = JasperFillManager.fillReport( caminho, filtro, conexao );
        JasperViewer viewer   = new JasperViewer( impressao , false );
        viewer.setTitle("Relatório de Micros Filtrados por Modelo e Seção"); //titulo a ser mostrado no formulario de relatorio
        viewer.setZoomRatio(new Float(0.7956));      //ajustando o relatorio na pagina
        viewer.setVisible(true);        
        conexao.close();        
    } 
    public void imprimirPatrimoniosFiltradosPorTipoSecao(String caminho, String secao, String tipo, String tabela) throws JRException,Exception
    {
        //para mostrar somente o nome da tabela no formulario do jasperrport no metodo viewer.setTitle
        String nomeTabela = tabela.substring(3);    
        //exibindo o relatorio
        HashMap filtro = new HashMap();
        filtro.put("nomeSecao", secao);
        filtro.put("tipoPatrimonio", tipo);
        JasperPrint impressao = JasperFillManager.fillReport( caminho, filtro, conexao );
        JasperViewer viewer   = new JasperViewer( impressao , false );
        viewer.setTitle("Relatório de "+nomeTabela); //titulo a ser mostrado no formulario de relatorio
        viewer.setZoomRatio(new Float(0.7956));      //ajustando o relatorio na pagina
        viewer.setVisible(true);        
        conexao.close();        
    } 
    public void imprimirPatrimoniosFiltradosPorDepartamento(String caminho, int iddepto, String tipo, String tabela) throws JRException,Exception
    {
        //para mostrar somente o nome da tabela no formulario do jasperrport no metodo viewer.setTitle
        String nomeTabela = tabela.substring(3);    
        //exibindo o relatorio
        HashMap filtro = new HashMap();
        filtro.put("idDepto", iddepto);
        filtro.put("tipoPatrimonio", tipo);
        JasperPrint impressao = JasperFillManager.fillReport( caminho, filtro, conexao );
        JasperViewer viewer   = new JasperViewer( impressao , false );
        viewer.setTitle("Relatório de "+nomeTabela); //titulo a ser mostrado no formulario de relatorio
        viewer.setZoomRatio(new Float(0.7956));      //ajustando o relatorio na pagina
        viewer.setVisible(true);        
        conexao.close();        
    } 
    public void imprimirPatrimoniosInativos(String caminho, String tabela) throws JRException,Exception
    {
        //para mostrar somente o nome da tabela no formulario do jasperrport no metodo viewer.setTitle
        String nomeTabela = tabela.substring(3);    
        //exibindo o relatorio
        JasperPrint impressao = JasperFillManager.fillReport( caminho , null, conexao );
        JasperViewer viewer   = new JasperViewer( impressao , false );
        viewer.setTitle("Relatório de "+nomeTabela); //titulo a ser mostrado no formulario de relatorio
        viewer.setZoomRatio(new Float(0.7956));      //ajustando o relatorio na pagina
        viewer.setVisible(true);        
        conexao.close();        
    } 
    //imprimindo as impressoras
    public void imprimirTodasImpressoras(String caminho, String tabela) throws JRException,Exception
    {
        //para mostrar somente o nome da tabela no formulario do jasperrport no metodo viewer.setTitle
        String nomeTabela = tabela.substring(3);    
        //exibindo o relatorio
        JasperPrint impressao = JasperFillManager.fillReport( caminho , null, conexao );
        JasperViewer viewer   = new JasperViewer( impressao , false );
        viewer.setTitle("Relatório de "+nomeTabela); //titulo a ser mostrado no formulario de relatorio
        viewer.setZoomRatio(new Float(0.7956));      //ajustando o relatorio na pagina
        viewer.setVisible(true);        
        conexao.close();        
    } 
    public void imprimirImpressoraSelecionada(String caminho, int codigo, String tabela) throws JRException,Exception
    {
        //para mostrar somente o nome da tabela no formulario do jasperrport no metodo viewer.setTitle
        String nomeTabela = tabela.substring(3);    
        //exibindo o relatorio
        HashMap filtro = new HashMap();
        filtro.put("codigoImpressora", codigo);
        JasperPrint impressao = JasperFillManager.fillReport( caminho, filtro, conexao );
        JasperViewer viewer   = new JasperViewer( impressao , false );
        viewer.setTitle("Relatório de "+nomeTabela); //titulo a ser mostrado no formulario de relatorio
        viewer.setZoomRatio(new Float(0.7956));      //ajustando o relatorio na pagina
        viewer.setVisible(true);        
        conexao.close();        
    } 
    public void imprimirImpressorasFiltradas(String caminho, String secao, String tabela) throws JRException,Exception
    {
        //para mostrar somente o nome da tabela no formulario do jasperrport no metodo viewer.setTitle
        String nomeTabela = tabela.substring(3);        
        //exibindo o relatorio
        HashMap filtro = new HashMap();
        filtro.put("nomeSecao", secao);
        JasperPrint impressao = JasperFillManager.fillReport( caminho, filtro, conexao );
        JasperViewer viewer   = new JasperViewer( impressao , false );
        viewer.setTitle("Relatório de "+nomeTabela); //titulo a ser mostrado no formulario de relatorio
        viewer.setZoomRatio(new Float(0.7956));      //ajustando o relatorio na pagina
        viewer.setVisible(true);        
        conexao.close();        
    } 
    public void imprimirTodasImpressorasInativas(String caminho, String tabela) throws JRException,Exception
    {
        //para mostrar somente o nome da tabela no formulario do jasperrport no metodo viewer.setTitle
        String nomeTabela = tabela.substring(3);    
        //exibindo o relatorio
        JasperPrint impressao = JasperFillManager.fillReport( caminho , null, conexao );
        JasperViewer viewer   = new JasperViewer( impressao , false );
        viewer.setTitle("Relatório de "+nomeTabela); //titulo a ser mostrado no formulario de relatorio
        viewer.setZoomRatio(new Float(0.7956));      //ajustando o relatorio na pagina
        viewer.setVisible(true);        
        conexao.close();        
    }    
    public void imprimirPeriodoSelecionado(String caminho, Date inicio, Date fim, String tabela) throws JRException,Exception
    {
        //para mostrar somente o nome da tabela no formulario do jasperrport no metodo viewer.setTitle
        String nomeTabela = tabela.substring(3);    
        //exibindo o relatorio
        HashMap filtro = new HashMap();
        //As data passadas tem que ser do tipo java.util.date mesmo tipo dos parametros dentro do relatorio
        filtro.put("data1", inicio);
        filtro.put("data2", fim);
        JasperPrint impressao = JasperFillManager.fillReport( caminho, filtro, conexao );
        JasperViewer viewer   = new JasperViewer( impressao , false );
        viewer.setTitle("Relatório de "+nomeTabela); //titulo a ser mostrado no formulario de relatorio
        viewer.setZoomRatio(new Float(0.7956));      //ajustando o relatorio na pagina
        viewer.setVisible(true);        
        conexao.close();        
    } 
    public void imprimirEtiquetaSelecionada(String caminho, String param) throws JRException,Exception
    {
        //exibindo o relatorio
        HashMap filtro = new HashMap();
        //o primeiro param trata-se do parametro criado dentro do relatorio, o segundo esta sendo passado como parametro no proprio procedimento
        filtro.put("param", param);  
        JasperPrint impressao = JasperFillManager.fillReport( caminho, filtro, conexao );
        JasperViewer viewer   = new JasperViewer( impressao , false );
        viewer.setTitle("Impressão de etiqueta da estação digitada"); //titulo a ser mostrado no formulario de relatorio
        viewer.setZoomRatio(new Float(0.7956));      //ajustando o relatorio na pagina
        viewer.setVisible(true);        
        conexao.close();        
    } 
    public void imprimirEtiquetas(String caminho) throws JRException,Exception
    {
        //exibindo o relatorio
        HashMap filtro = new HashMap();
        //o primeiro param trata-se do parametro criado dentro do relatorio, o segundo esta sendo passado como parametro no proprio procedimento
        JasperPrint impressao = JasperFillManager.fillReport( caminho, filtro, conexao );
        JasperViewer viewer   = new JasperViewer( impressao , false );
        viewer.setTitle("Impressão de etiquetas de todas as estações"); //titulo a ser mostrado no formulario de relatorio
        viewer.setZoomRatio(new Float(0.7956));      //ajustando o relatorio na pagina
        viewer.setVisible(true);        
        conexao.close();        
    } 
    public void imprimirImpressorasInativas(String caminho) throws JRException,Exception
    {
        //exibindo o relatorio
        HashMap filtro = new HashMap();
        //o primeiro param trata-se do parametro criado dentro do relatorio, o segundo esta sendo passado como parametro no proprio procedimento
        JasperPrint impressao = JasperFillManager.fillReport( caminho, filtro, conexao );
        JasperViewer viewer   = new JasperViewer( impressao , false );
        viewer.setTitle("Relatório de Impressoras"); //titulo a ser mostrado no formulario de relatorio
        viewer.setZoomRatio(new Float(0.7956));      //ajustando o relatorio na pagina
        viewer.setVisible(true);        
        conexao.close();        
    } 
    public void imprimirImpressorasCadastradas(String caminho) throws JRException,Exception
    {
        //exibindo o relatorio
        HashMap filtro = new HashMap();
        //o primeiro param trata-se do parametro criado dentro do relatorio, o segundo esta sendo passado como parametro no proprio procedimento
        JasperPrint impressao = JasperFillManager.fillReport( caminho, filtro, conexao );
        JasperViewer viewer   = new JasperViewer( impressao , false );
        viewer.setTitle("Relatório de Impressoras"); //titulo a ser mostrado no formulario de relatorio
        viewer.setZoomRatio(new Float(0.7956));      //ajustando o relatorio na pagina
        viewer.setVisible(true);        
        conexao.close();        
    } 
    public void imprimirImpressorasSecaoSelecionada(String caminho, int param) throws JRException,Exception
    {
        //exibindo o relatorio
        HashMap filtro = new HashMap();
        //o primeiro param trata-se do parametro criado dentro do relatorio, o segundo esta sendo passado como parametro no proprio procedimento
        filtro.put("codigoSecao", param); 
        JasperPrint impressao = JasperFillManager.fillReport( caminho, filtro, conexao );
        JasperViewer viewer   = new JasperViewer( impressao , false );
        viewer.setTitle("Relatório de Impressoras"); //titulo a ser mostrado no formulario de relatorio
        viewer.setZoomRatio(new Float(0.7956));      //ajustando o relatorio na pagina
        viewer.setVisible(true);        
        conexao.close();        
    } 
    public void imprimirImpressorasModeloSelecionado(String caminho, int param) throws JRException,Exception
    {
        //exibindo o relatorio
        HashMap filtro = new HashMap();
        //o primeiro param trata-se do parametro criado dentro do relatorio, o segundo esta sendo passado como parametro no proprio procedimento
        filtro.put("modeloid", param);
        JasperPrint impressao = JasperFillManager.fillReport( caminho, filtro, conexao );
        JasperViewer viewer   = new JasperViewer( impressao , false );
        viewer.setTitle("Relatório de Impressoras"); //titulo a ser mostrado no formulario de relatorio
        viewer.setZoomRatio(new Float(0.7956));      //ajustando o relatorio na pagina
        viewer.setVisible(true);        
        conexao.close();        
    } 
    public void imprimirMicrosInativos(String caminho) throws JRException,Exception
    {
        //exibindo o relatorio
        HashMap filtro = new HashMap();
        //o primeiro param trata-se do parametro criado dentro do relatorio, o segundo esta sendo passado como parametro no proprio procedimento
        JasperPrint impressao = JasperFillManager.fillReport( caminho, filtro, conexao );
        JasperViewer viewer   = new JasperViewer( impressao , false );
        viewer.setTitle("Relatório de Micros Inativos"); //titulo a ser mostrado no formulario de relatorio
        viewer.setZoomRatio(new Float(0.7956));      //ajustando o relatorio na pagina
        viewer.setVisible(true);        
        conexao.close();        
    } 
    public void imprimirMicrosCadastrados(String caminho) throws JRException,Exception
    {
        //exibindo o relatorio
        HashMap filtro = new HashMap();
        //o primeiro param trata-se do parametro criado dentro do relatorio, o segundo esta sendo passado como parametro no proprio procedimento
        JasperPrint impressao = JasperFillManager.fillReport( caminho, filtro, conexao );
        JasperViewer viewer   = new JasperViewer( impressao , false );
        viewer.setTitle("Relatório de Micros"); //titulo a ser mostrado no formulario de relatorio
        viewer.setZoomRatio(new Float(0.7956));      //ajustando o relatorio na pagina
        viewer.setVisible(true);        
        conexao.close();        
    } 
    public void imprimirMicrosSecaoSelecionada(String caminho, int param) throws JRException,Exception
    {
        //exibindo o relatorio
        HashMap filtro = new HashMap();
        //o primeiro param trata-se do parametro criado dentro do relatorio, o segundo esta sendo passado como parametro no proprio procedimento
        filtro.put("codigoSecao", param); 
        JasperPrint impressao = JasperFillManager.fillReport( caminho, filtro, conexao );
        JasperViewer viewer   = new JasperViewer( impressao , false );
        viewer.setTitle("Relatório de Micros"); //titulo a ser mostrado no formulario de relatorio
        viewer.setZoomRatio(new Float(0.7956));      //ajustando o relatorio na pagina
        viewer.setVisible(true);        
        conexao.close();        
    } 
    public void imprimirMicrosModeloSelecionado(String caminho, int param) throws JRException,Exception
    {
        //exibindo o relatorio
        HashMap filtro = new HashMap();
        //o primeiro param trata-se do parametro criado dentro do relatorio, o segundo esta sendo passado como parametro no proprio procedimento
        filtro.put("codModelo", param);
        JasperPrint impressao = JasperFillManager.fillReport( caminho, filtro, conexao );
        JasperViewer viewer   = new JasperViewer( impressao , false );
        viewer.setTitle("Relatório de Micros"); //titulo a ser mostrado no formulario de relatorio
        viewer.setZoomRatio(new Float(0.7956));      //ajustando o relatorio na pagina
        viewer.setVisible(true);        
        conexao.close();        
    } 
    public void imprimirMonitoresInativos(String caminho) throws JRException,Exception
    {
        //exibindo o relatorio
        HashMap filtro = new HashMap();
        //o primeiro param trata-se do parametro criado dentro do relatorio, o segundo esta sendo passado como parametro no proprio procedimento
        JasperPrint impressao = JasperFillManager.fillReport( caminho, filtro, conexao );
        JasperViewer viewer   = new JasperViewer( impressao , false );
        viewer.setTitle("Relatório de Micros"); //titulo a ser mostrado no formulario de relatorio
        viewer.setZoomRatio(new Float(0.7956));      //ajustando o relatorio na pagina
        viewer.setVisible(true);        
        conexao.close();        
    } 
    public void imprimirMonitoresCadastrados(String caminho) throws JRException,Exception
    {
        //exibindo o relatorio
        HashMap filtro = new HashMap();
        //o primeiro param trata-se do parametro criado dentro do relatorio, o segundo esta sendo passado como parametro no proprio procedimento
        JasperPrint impressao = JasperFillManager.fillReport( caminho, filtro, conexao );
        JasperViewer viewer   = new JasperViewer( impressao , false );
        viewer.setTitle("Relatório de Micros"); //titulo a ser mostrado no formulario de relatorio
        viewer.setZoomRatio(new Float(0.7956));      //ajustando o relatorio na pagina
        viewer.setVisible(true);        
        conexao.close();        
    } 
    public void imprimirMonitoresSecaoSelecionada(String caminho, int param) throws JRException,Exception
    {
        //exibindo o relatorio
        HashMap filtro = new HashMap();
        //o primeiro param trata-se do parametro criado dentro do relatorio, o segundo esta sendo passado como parametro no proprio procedimento
        filtro.put("codigoSecao", param); 
        JasperPrint impressao = JasperFillManager.fillReport( caminho, filtro, conexao );
        JasperViewer viewer   = new JasperViewer( impressao , false );
        viewer.setTitle("Relatório de Micros"); //titulo a ser mostrado no formulario de relatorio
        viewer.setZoomRatio(new Float(0.7956));      //ajustando o relatorio na pagina
        viewer.setVisible(true);        
        conexao.close();        
    } 
    public void imprimirMonitoresModeloSelecionado(String caminho, int param) throws JRException,Exception
    {
        //exibindo o relatorio
        HashMap filtro = new HashMap();
        //o primeiro param trata-se do parametro criado dentro do relatorio, o segundo esta sendo passado como parametro no proprio procedimento
        filtro.put("codModelo", param);
        JasperPrint impressao = JasperFillManager.fillReport( caminho, filtro, conexao );
        JasperViewer viewer   = new JasperViewer( impressao , false );
        viewer.setTitle("Relatório de Micros"); //titulo a ser mostrado no formulario de relatorio
        viewer.setZoomRatio(new Float(0.7956));      //ajustando o relatorio na pagina
        viewer.setVisible(true);        
        conexao.close();        
    } 
    public void imprimirPatrimoniosTransferidos(String caminho) throws JRException,Exception
    {                    
        //exibindo o relatorio
        HashMap filtro = new HashMap();         
                        
        ImageIcon gto = new ImageIcon(getClass().getResource("/images/cabecalho.png"));
        filtro.put("CABECALHO", gto.getImage());
        
        JasperPrint impressao = JasperFillManager.fillReport( caminho, filtro, conexao );
        JasperViewer viewer   = new JasperViewer( impressao , false );
        viewer.setTitle("Relatório de Patrimônios Transferidos");
        viewer.setZoomRatio(new Float(0.7956));  //ajustando o relatorio na pagina
        viewer.setVisible(true);        
        conexao.close();        
    }       
    
    public void imprimirRelatorioPatrimoniosTransferidos(String caminho, String pParam) throws JRException,Exception
    {                   
        //exibindo o relatorio
        HashMap filtro = new HashMap();         
                        
        ImageIcon gto = new ImageIcon(getClass().getResource("/images/cabecalho.png"));
        filtro.put("CABECALHO", gto.getImage());
        filtro.put("numemo", pParam);
        
        JasperPrint impressao = JasperFillManager.fillReport( caminho, filtro, conexao );
        JasperViewer viewer   = new JasperViewer( impressao , false );
        viewer.setTitle("Relatório de Patrimônios Transferidos pelo Número do Memorando");
        viewer.setZoomRatio(new Float(0.7956));  //ajustando o relatorio na pagina
        viewer.setVisible(true);           
        conexao.close();      
    }     
    
    /*IMPRESSÃO DE PATRIMONIOS DOS DEPTOS PARA ENVIO A MANUTENÇÃO*/
    
    public void imprimirPatrimoniosDepartamentosPorOrigem(String caminho, String pParam) throws JRException,Exception
    {                   
        //exibindo o relatorio
        HashMap filtro = new HashMap();         
                        
        ImageIcon gto = new ImageIcon(getClass().getResource("/images/cabecalho.png"));
        filtro.put("CABECALHO", gto.getImage());
        filtro.put("pOrigem", pParam);
        
        JasperPrint impressao = JasperFillManager.fillReport( caminho, filtro, conexao );
        JasperViewer viewer   = new JasperViewer( impressao , false );
        viewer.setTitle("Relatório de Patrimônios de :"+pParam);
        viewer.setZoomRatio(new Float(0.7956));  //ajustando o relatorio na pagina
        viewer.setVisible(true);           
        conexao.close();      
    }             
    
    public void imprimirPatrimoniosDepartamentos(String caminho) throws JRException,Exception
    {                    
        //exibindo o relatorio de todos os patrimonios devolvidos a suas origens
        HashMap filtro = new HashMap();         
                        
        ImageIcon gto = new ImageIcon(getClass().getResource("/images/cabecalho.png"));
        filtro.put("CABECALHO", gto.getImage());
        
        JasperPrint impressao = JasperFillManager.fillReport( caminho, filtro, conexao );
        JasperViewer viewer   = new JasperViewer( impressao , false );
        
        switch(indiceItemSelecionado)
        {
            case 2:
                viewer.setTitle("Relatório de Patrimônios Encerrados e Devolvidos a suas Unidades de Origem");
                break;
            case 0:
                viewer.setTitle("Relatório de Patrimônios Prontos para serem Enviados");
                break;
            case 1:
                viewer.setTitle("Relatório de Patrimônios enviados para manutenção");
                break;
            case 3:
                viewer.setTitle("Relatório de Patrimônios dos Departamentos Cadastrados");
                break;            
        }
        
        viewer.setZoomRatio(new Float(0.7956));  //ajustando o relatorio na pagina
        viewer.setVisible(true);        
        conexao.close();        
    }       
    
}