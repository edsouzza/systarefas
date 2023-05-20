package visao;

import Dao.DAONomeEstacao;
import conexao.ConnConexao;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import biblioteca.Biblioteca;
import biblioteca.MetodosPublicos;
import biblioteca.ModeloTabela;
import static biblioteca.VariaveisPublicas.contador;
import static biblioteca.VariaveisPublicas.totalRegs;
import controle.CtrlNomeEstacao;
import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import modelo.NomeEstacao;


public class F_CONSNOMESTACOESDISPONIVEIS extends javax.swing.JDialog  {

    ConnConexao        conexao                  = new ConnConexao();
    Biblioteca         umaBiblio                = new Biblioteca();
    MetodosPublicos    umMetodo                 = new MetodosPublicos();  
    NomeEstacao        umModeloNomeEstacao      = new NomeEstacao();
    CtrlNomeEstacao    umControleNomeEstacao    = new CtrlNomeEstacao();
    DAONomeEstacao     umEstacaoNomeEstacaoAO   = new DAONomeEstacao();
        
    String inicioRange, finalRange, estacaoInicial, estacaoFinal, strRange, sqlCmb, nomeSecao, nomeDepto, titulo, caminhoTXT, linha, scodigo, snomestacao = "";  
    String sqlDisponiveisPorTMP        = "SELECT * FROM TBLNOMESTACAOTMP WHERE STATUS='DISPONIVEL' ORDER BY NUMESTACAO";
    String sqlVazia                    = "SELECT * FROM TBLNOMESTACAOTMP WHERE CODIGO=0";
    int codDepto;
    boolean selecionouDepto;    
            

    public F_CONSNOMESTACOESDISPONIVEIS() 
    {
        initComponents();
        setResizable(false);   //desabilitando o redimencionamento da tela     
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE); //desabilitando o botao fechar        
                
        Leitura();       
           
        umaBiblio.configurarBotoes(btnPesquisar);
        umaBiblio.configurarBotoes(btnLimparPesquisa);   
        umaBiblio.configurarBotoes(btnSair);   
        
        //cofigurações 
        jTabelaESTACOES.setFont(new Font("TimesRoman", Font.BOLD, 12));
        jTabelaESTACOES.setForeground(Color.blue);  
        
        //Impede que formulario seja arrastado na tela
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                setEnabled(false);
                setEnabled(true);
            }
        });//fim addComponentListener      
        
    }  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        btnPesquisar = new javax.swing.JButton();
        cmbFILTRARPORDEPTO = new javax.swing.JComboBox<>();
        btnLimparPesquisa = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        txtNOMESTACAO = new javax.swing.JTextField();
        lblTITULO = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabelaESTACOES = new javax.swing.JTable();
        btnUtilizados = new javax.swing.JButton();

        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPrincipal.setPreferredSize(new java.awt.Dimension(1024, 733));
        panelPrincipal.setLayout(null);

        btnPesquisar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_pesquisa.gif"))); // NOI18N
        btnPesquisar.setText("Disponíveis");
        btnPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPesquisar.setEnabled(false);
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        panelPrincipal.add(btnPesquisar);
        btnPesquisar.setBounds(340, 10, 120, 33);

        cmbFILTRARPORDEPTO.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        cmbFILTRARPORDEPTO.setForeground(new java.awt.Color(51, 51, 255));
        cmbFILTRARPORDEPTO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<ESCOLHA A SEÇÃO>" }));
        cmbFILTRARPORDEPTO.setToolTipText("Escolha um departamento para filtrar");
        cmbFILTRARPORDEPTO.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbFILTRARPORDEPTO.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbFILTRARPORDEPTOItemStateChanged(evt);
            }
        });
        panelPrincipal.add(cmbFILTRARPORDEPTO);
        cmbFILTRARPORDEPTO.setBounds(10, 10, 320, 30);

        btnLimparPesquisa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLimparPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_limpar.gif"))); // NOI18N
        btnLimparPesquisa.setText("Limpar");
        btnLimparPesquisa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimparPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparPesquisaActionPerformed(evt);
            }
        });
        panelPrincipal.add(btnLimparPesquisa);
        btnLimparPesquisa.setBounds(600, 10, 110, 33);

        btnSair.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_sair.gif"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        panelPrincipal.add(btnSair);
        btnSair.setBounds(720, 10, 110, 33);

        txtNOMESTACAO.setEditable(false);
        txtNOMESTACAO.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNOMESTACAO.setForeground(new java.awt.Color(51, 51, 255));
        panelPrincipal.add(txtNOMESTACAO);
        txtNOMESTACAO.setBounds(10, 95, 820, 30);

        lblTITULO.setText("PRÓXIMO NOME DE ESTAÇÃO DE");
        panelPrincipal.add(lblTITULO);
        lblTITULO.setBounds(12, 70, 390, 14);

        jTabelaESTACOES.setAutoCreateRowSorter(true);
        jTabelaESTACOES.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTabelaESTACOES.setToolTipText("");
        jTabelaESTACOES.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane3.setViewportView(jTabelaESTACOES);

        panelPrincipal.add(jScrollPane3);
        jScrollPane3.setBounds(10, 140, 820, 430);

        btnUtilizados.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnUtilizados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_sairPrograma.gif"))); // NOI18N
        btnUtilizados.setText("Utilizados");
        btnUtilizados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUtilizados.setEnabled(false);
        btnUtilizados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUtilizadosActionPerformed(evt);
            }
        });
        panelPrincipal.add(btnUtilizados);
        btnUtilizados.setBounds(470, 10, 120, 33);

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 830, 570));

        setSize(new java.awt.Dimension(852, 622));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void Leitura()
    {       
        //Populando o combo com os nomes dos departamentos
        sqlCmb = "select nome from tbldepartamentos where status='ATIVO' order by nome";
        umMetodo.PreencherComboVariandoTipo(cmbFILTRARPORDEPTO, sqlCmb, "NOME");
        nomeDepto = cmbFILTRARPORDEPTO.getSelectedItem().toString();
        cmbFILTRARPORDEPTO.setSelectedIndex(-1); 
        
        btnPesquisar.setEnabled(false);
        btnLimparPesquisa.setEnabled(false);        
        contador  = 0; 
        lblTITULO.setText("SELECIONE UM DEPARTAMENTO ACIMA E DEFINA UMA CONSULTA ATRAVÉS DOS BOTÕES DE PESQUISA");        
        titulo = "SELECIONE UM DEPARTAMENTO PARA CONSULTAR NOMES DE ESTAÇÕES DISPONÍVEIS PARA CADASTRO";        
        this.setTitle(titulo);  
        PreencherTabelaESTACOES(sqlVazia);
        
    }    
    
    private void LimparPesquisa()
    {
       lblTITULO.setText("NOMES DE ESTAÇÕES DISPONÍVEIS PARA CADASTRO");
       
       btnLimparPesquisa.setEnabled(false);
       cmbFILTRARPORDEPTO.setEnabled(true);
       cmbFILTRARPORDEPTO.setSelectedIndex(-1); 
       txtNOMESTACAO.setText(null);
       txtNOMESTACAO.setEditable(false);   
       btnUtilizados.setEnabled(true);
       Leitura();        
    }
    
     public void PesquisarUtilizados(String pDepto) 
    {                     
                
        //JOptionPane.showMessageDialog(rootPane,"CODIGO DO DEPTO : "+ String.valueOf(codDepto));                
        //JOptionPane.showMessageDialog(rootPane,"DEPARTAMENTO : "+ pDepto);                
        
        String sqlPesquisa = "select p.codigo, p.ip, p.estacao, s.nome as secao, t.*, c.nome as usuario from tblpatrimonios p, tblsecoes s, tbltipos t, tblclientes c "
             + "where p.tipoid=t.codigo and p.secaoid=s.codigo and c.codigo=p.clienteid and t.tipopatrimonio = 'PATRIMONIO' and (t.tipo='MICRO') "
             + "and p.status='ATIVO' and p.deptoid = "+codDepto+" and p.ip<>'0' order BY RIGHT('000000000000' || p.estacao, 12)";      
                  
                                  
        PreencherTabelaESTACOESUTILIZADAS(sqlPesquisa);             
         
        btnPesquisar.setEnabled(false);
        btnLimparPesquisa.setEnabled(true);   
        cmbFILTRARPORDEPTO.setEnabled(false);
        
        //JOptionPane.showMessageDialog(rootPane,"TOTAL DE REGISTROS ENCONTRADOS : "+ String.valueOf(totalRegs));        
        titulo = pDepto+" - TOTAL DE ESTAÇÕES/MICROS : "+totalRegs+"";          
        this.setTitle(titulo);       
        
        if(totalRegs == 0){
          
            JOptionPane.showMessageDialog(null, "Não foram encontrados registros para "+pDepto+"!","Nenhum registro encontrado!",2);
            btnLimparPesquisaActionPerformed(null);
        }
    }     
    
    public void Pesquisar(String pDepto) 
    {              
        //nomeDepartamento = cmbFILTRARPORDEPTO.getSelectedItem().toString();
        
        if(pDepto.equals("CGGM"))
        {
          String sqlDisponiveisPorInativacao = "SELECT * FROM TBLNOMESTACAO WHERE status='DISPONIVEL' AND Depto = '"+pDepto+"' ORDER BY numestacao";   
          PreencherTabelaESTACOES(sqlDisponiveisPorInativacao);
          txtNOMESTACAO.setText(umMetodo.gerarProximoNomestacao(nomeDepto)); 
          lblTITULO.setText("NOMES DE ESTAÇÕES DISPONÍVEIS PARA CADASTRO : "+nomeDepto);

        }else{
            //JOptionPane.showMessageDialog(null, "DEPARTAMENTO SELECIONADO : "+nomeDepto);
            txtNOMESTACAO.setText(umMetodo.gerarProximoNomestacao(nomeDepto)); 
            lblTITULO.setText("NOMES DE ESTAÇÕES DISPONÍVEIS PARA CADASTRO : "+nomeDepto);
        }                 

        btnLimparPesquisa.setEnabled(true);
        btnPesquisar.setEnabled(false);
        txtNOMESTACAO.setEditable(false);
        cmbFILTRARPORDEPTO.setEnabled(false);
    }        
      
    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed

        btnUtilizados.setEnabled(false);
        btnPesquisar.setEnabled(false); 
        
        nomeDepto = cmbFILTRARPORDEPTO.getSelectedItem().toString();        
        codDepto  = umaBiblio.buscarCodigoGenerico("tbldepartamentos", "nome", cmbFILTRARPORDEPTO.getSelectedItem().toString());
        
        if(contador == 1)
        {
            Pesquisar(nomeDepto);            
        }          
                
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        contador = 0;
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnLimparPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparPesquisaActionPerformed
       LimparPesquisa();
    }//GEN-LAST:event_btnLimparPesquisaActionPerformed

    private void cmbFILTRARPORDEPTOItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbFILTRARPORDEPTOItemStateChanged
         contador++;            
         //JOptionPane.showMessageDialog(rootPane,"VL CONTADOR : "+ String.valueOf(contador)); 
         
         if( contador == 1){
             btnPesquisar.setEnabled(true); 
             btnUtilizados.setEnabled(true);
         }else{
            btnPesquisar.setEnabled(false); 
            btnUtilizados.setEnabled(false);
         }
    }//GEN-LAST:event_cmbFILTRARPORDEPTOItemStateChanged

    private void btnUtilizadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUtilizadosActionPerformed
       
        btnUtilizados.setEnabled(false);
        btnPesquisar.setEnabled(false); 
        nomeDepto = cmbFILTRARPORDEPTO.getSelectedItem().toString();
        codDepto  = umaBiblio.buscarCodigoGenerico("tbldepartamentos", "nome", cmbFILTRARPORDEPTO.getSelectedItem().toString());
        
        if(contador == 1)
        {
            PesquisarUtilizados(nomeDepto);            
        }             
        
    }//GEN-LAST:event_btnUtilizadosActionPerformed
         
    public void PreencherTabelaESTACOES(String sql) {
        conexao.conectar();
        ArrayList dados = new ArrayList();
        //para receber os dados das colunas(exibe os titulos das colunas)
        String[] Colunas = new String[]{"Código", "Estação"};
        try {
            conexao.ExecutarPesquisaSQL(sql);
            while (conexao.rs.next()) {
                dados.add(new Object[]{
                    conexao.rs.getInt("codigo"),
                    conexao.rs.getString("nomestacao")

                });
                totalRegs = conexao.rs.getRow();
            };
                        
            ModeloTabela modelo = new ModeloTabela(dados, Colunas);
            jTabelaESTACOES.setModel(modelo);
            
            //define tamanho das colunas
            jTabelaESTACOES.getColumnModel().getColumn(0).setPreferredWidth(70);  //define o tamanho da coluna
            jTabelaESTACOES.getColumnModel().getColumn(0).setResizable(false);    //nao será possivel redimencionar a coluna 
            jTabelaESTACOES.getColumnModel().getColumn(1).setPreferredWidth(725);  //define o tamanho da coluna
            jTabelaESTACOES.getColumnModel().getColumn(1).setResizable(false);    //nao será possivel redimencionar a coluna            

            //define propriedades da tabela
            jTabelaESTACOES.getTableHeader().setReorderingAllowed(false);        //nao podera ser reorganizada
            jTabelaESTACOES.setAutoResizeMode(jTabelaESTACOES.AUTO_RESIZE_OFF);          //nao será possivel redimencionar a tabela
            jTabelaESTACOES.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //so podera selecionar apena uma linha  

        } catch (SQLException ex) {
            //apos a consulta acima abrir o formulario mesmo que a tabela esteja vazia  
            JOptionPane.showMessageDialog(null, "Erro ao preencher o ArrayList!\nErro: " + ex.getMessage());
        } finally {
            conexao.desconectar();
        }

    }
    
    public void PreencherTabelaESTACOESUTILIZADAS(String sql) {
        conexao.conectar();
        ArrayList dados = new ArrayList();
        //para receber os dados das colunas(exibe os titulos das colunas)
        String[] Colunas = new String[]{"Código", "Estação", "Ip", "Seção", "Usuário"};
        try {
            conexao.ExecutarPesquisaSQL(sql);
            while (conexao.rs.next()) {
                dados.add(new Object[]{
                    conexao.rs.getInt("codigo"),
                    conexao.rs.getString("estacao"),
                    conexao.rs.getString("ip"),
                    conexao.rs.getString("secao"),
                    conexao.rs.getString("usuario")

                });
                totalRegs = conexao.rs.getRow();
            };
                        
            ModeloTabela modelo = new ModeloTabela(dados, Colunas);
            jTabelaESTACOES.setModel(modelo);
            
            //define tamanho das colunas
            jTabelaESTACOES.getColumnModel().getColumn(0).setPreferredWidth(70);  //define o tamanho da coluna
            jTabelaESTACOES.getColumnModel().getColumn(0).setResizable(false);    //nao será possivel redimencionar a coluna 
            jTabelaESTACOES.getColumnModel().getColumn(1).setPreferredWidth(120);  //define o tamanho da coluna
            jTabelaESTACOES.getColumnModel().getColumn(1).setResizable(false);    //nao será possivel redimencionar a coluna 
            jTabelaESTACOES.getColumnModel().getColumn(2).setPreferredWidth(100);  //define o tamanho da coluna
            jTabelaESTACOES.getColumnModel().getColumn(2).setResizable(false);    //nao será possivel redimencionar a coluna 
            jTabelaESTACOES.getColumnModel().getColumn(3).setPreferredWidth(130);  //define o tamanho da coluna
            jTabelaESTACOES.getColumnModel().getColumn(3).setResizable(false);    //nao será possivel redimencionar a coluna 
            jTabelaESTACOES.getColumnModel().getColumn(4).setPreferredWidth(320);  //define o tamanho da coluna
            jTabelaESTACOES.getColumnModel().getColumn(4).setResizable(false);    //nao será possivel redimencionar a coluna 

            //define propriedades da tabela
            jTabelaESTACOES.getTableHeader().setReorderingAllowed(false);        //nao podera ser reorganizada
            jTabelaESTACOES.setAutoResizeMode(jTabelaESTACOES.AUTO_RESIZE_OFF);          //nao será possivel redimencionar a tabela
            jTabelaESTACOES.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //so podera selecionar apena uma linha  

        } catch (SQLException ex) {
            //apos a consulta acima abrir o formulario mesmo que a tabela esteja vazia  
            JOptionPane.showMessageDialog(null, "Erro ao preencher o ArrayList!\nErro: " + ex.getMessage());
        } finally {
            conexao.desconectar();
        }

    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnLimparPesquisa;
    public javax.swing.JButton btnPesquisar;
    public javax.swing.JButton btnSair;
    public javax.swing.JButton btnUtilizados;
    private javax.swing.JComboBox<String> cmbFILTRARPORDEPTO;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTable jTabelaESTACOES;
    private javax.swing.JLabel lblTITULO;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTextField txtNOMESTACAO;
    // End of variables declaration//GEN-END:variables
}
