package visao;

import biblioteca.CampoTxtLimitadoPorQdeCaracteresUpperCase;
import biblioteca.MetodosPublicos;
import biblioteca.VariaveisPublicas;
import static biblioteca.VariaveisPublicas.tabela_da_lista;
import static biblioteca.VariaveisPublicas.TipoModelo;
import static biblioteca.VariaveisPublicas.codTipoSelecionado;
import static biblioteca.VariaveisPublicas.lstListaCampos;
import static biblioteca.VariaveisPublicas.lstAuxiliar;
import static biblioteca.VariaveisPublicas.lstListaStrings;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class F_GERARTXT extends javax.swing.JDialog {
    MetodosPublicos   umMetodo  =  new MetodosPublicos();
    
    String sTipo, sChapa, sSerie  = "";
    Boolean metodoPADRAOINIFIM = false;    
    
    public F_GERARTXT(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Leitura();
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE); //desabilitando o botao fechar

        //Impede que formulario seja arrastado na tela
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentMoved(ComponentEvent e) {
                setEnabled(false);
                setEnabled(true);
            }
        });//fim addComponentListener

        //configuracoes dos edits      
        umMetodo.configurarBotoes(btnGerarTXT);
        umMetodo.configurarBotoes(btnADDAOTXT);
        umMetodo.configurarBotoes(btnLimpar);
        umMetodo.configurarBotoes(btnSair);
        umMetodo.configurarBotoes(btnNovo);
        
        txtRESULTADOS.setForeground(Color.blue);        
        txtRESULTADOS.setFont(new Font("TimesRoman", Font.BOLD, 14));
        txtSERIEINI.setDocument(new CampoTxtLimitadoPorQdeCaracteresUpperCase(20));
        txtSERIEFIM.setDocument(new CampoTxtLimitadoPorQdeCaracteresUpperCase(20));
        
        
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPANELTOTAL = new javax.swing.JPanel();
        jBoxPesquisar1 = new javax.swing.JLayeredPane();
        txtTIPO = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtCHAPA = new javax.swing.JTextField();
        txtSERIEINI = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSECAO = new javax.swing.JTextField();
        txtMODELO = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbSTATUS = new javax.swing.JComboBox<String>();
        txtSERIEFIM = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtRESULTADOS = new javax.swing.JTextArea();
        btnGerarTXT = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnADDAOTXT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GERAR ARQUIVO TXT A PARTIR DE UMA SQL");
        getContentPane().setLayout(null);

        jBoxPesquisar1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jBoxPesquisar1.setName("panelDados"); // NOI18N

        txtTIPO.setEditable(false);
        txtTIPO.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTIPO.setForeground(new java.awt.Color(51, 51, 255));

        jLabel6.setText("TIPO");

        jLabel1.setText("CHAPA");

        txtCHAPA.setEditable(false);
        txtCHAPA.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCHAPA.setForeground(new java.awt.Color(51, 51, 255));

        txtSERIEINI.setEditable(false);
        txtSERIEINI.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtSERIEINI.setForeground(new java.awt.Color(51, 51, 255));
        txtSERIEINI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSERIEINIKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSERIEINIKeyReleased(evt);
            }
        });

        jLabel4.setText("SERIE INICIAL");

        jLabel2.setText("SEÇÃO");

        txtSECAO.setEditable(false);
        txtSECAO.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtSECAO.setForeground(new java.awt.Color(51, 51, 255));
        txtSECAO.setText("INFORMATICA");

        txtMODELO.setEditable(false);
        txtMODELO.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtMODELO.setForeground(new java.awt.Color(51, 51, 255));

        jLabel7.setText("MODELO");

        jLabel8.setText("CONTRATO?");

        cmbSTATUS.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cmbSTATUS.setForeground(new java.awt.Color(51, 51, 255));
        cmbSTATUS.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NAO", "SIM" }));
        cmbSTATUS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txtSERIEFIM.setEditable(false);
        txtSERIEFIM.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtSERIEFIM.setForeground(new java.awt.Color(51, 51, 255));
        txtSERIEFIM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSERIEFIMKeyPressed(evt);
            }
        });

        jLabel5.setText("SERIE FINAL");

        javax.swing.GroupLayout jBoxPesquisar1Layout = new javax.swing.GroupLayout(jBoxPesquisar1);
        jBoxPesquisar1.setLayout(jBoxPesquisar1Layout);
        jBoxPesquisar1Layout.setHorizontalGroup(
            jBoxPesquisar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jBoxPesquisar1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jBoxPesquisar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jBoxPesquisar1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jBoxPesquisar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtSECAO, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jBoxPesquisar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbSTATUS, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(jBoxPesquisar1Layout.createSequentialGroup()
                        .addGroup(jBoxPesquisar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(txtSERIEINI, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                            .addComponent(txtTIPO))
                        .addGroup(jBoxPesquisar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jBoxPesquisar1Layout.createSequentialGroup()
                                .addGroup(jBoxPesquisar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jBoxPesquisar1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtSERIEFIM, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jBoxPesquisar1Layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(jLabel5)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jBoxPesquisar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(txtCHAPA, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 243, Short.MAX_VALUE))
                            .addGroup(jBoxPesquisar1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jBoxPesquisar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jBoxPesquisar1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtMODELO))))))
                .addContainerGap())
        );
        jBoxPesquisar1Layout.setVerticalGroup(
            jBoxPesquisar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jBoxPesquisar1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jBoxPesquisar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jBoxPesquisar1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTIPO, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jBoxPesquisar1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMODELO, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jBoxPesquisar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jBoxPesquisar1Layout.createSequentialGroup()
                        .addGroup(jBoxPesquisar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jBoxPesquisar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jBoxPesquisar1Layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(cmbSTATUS, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel8)
                                .addGroup(jBoxPesquisar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtSECAO, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jBoxPesquisar1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(36, 36, 36))))
                            .addGroup(jBoxPesquisar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtSERIEINI, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtCHAPA, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtSERIEFIM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(jBoxPesquisar1Layout.createSequentialGroup()
                        .addGroup(jBoxPesquisar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1))
                        .addGap(56, 56, 56))))
        );
        jBoxPesquisar1.setLayer(txtTIPO, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jBoxPesquisar1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jBoxPesquisar1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jBoxPesquisar1.setLayer(txtCHAPA, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jBoxPesquisar1.setLayer(txtSERIEINI, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jBoxPesquisar1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jBoxPesquisar1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jBoxPesquisar1.setLayer(txtSECAO, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jBoxPesquisar1.setLayer(txtMODELO, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jBoxPesquisar1.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jBoxPesquisar1.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jBoxPesquisar1.setLayer(cmbSTATUS, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jBoxPesquisar1.setLayer(txtSERIEFIM, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jBoxPesquisar1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        txtRESULTADOS.setColumns(20);
        txtRESULTADOS.setLineWrap(true);
        txtRESULTADOS.setRows(5);
        txtRESULTADOS.setToolTipText("");
        txtRESULTADOS.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane5.setViewportView(txtRESULTADOS);

        btnGerarTXT.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnGerarTXT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/TICK.PNG"))); // NOI18N
        btnGerarTXT.setText("GERAR TXT");
        btnGerarTXT.setToolTipText("");
        btnGerarTXT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGerarTXT.setEnabled(false);
        btnGerarTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarTXTActionPerformed(evt);
            }
        });

        btnLimpar.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_limpar.gif"))); // NOI18N
        btnLimpar.setText("CANCELAR");
        btnLimpar.setToolTipText("");
        btnLimpar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpar.setEnabled(false);
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnSair.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_sair.gif"))); // NOI18N
        btnSair.setText("SAIR");
        btnSair.setToolTipText("");
        btnSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnNovo.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_blocoNotas.gif"))); // NOI18N
        btnNovo.setText("NOVO");
        btnNovo.setToolTipText("");
        btnNovo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnADDAOTXT.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        btnADDAOTXT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/btn_Ok1.gif"))); // NOI18N
        btnADDAOTXT.setText("ADD AO TXT");
        btnADDAOTXT.setToolTipText("");
        btnADDAOTXT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnADDAOTXT.setEnabled(false);
        btnADDAOTXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnADDAOTXTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPANELTOTALLayout = new javax.swing.GroupLayout(jPANELTOTAL);
        jPANELTOTAL.setLayout(jPANELTOTALLayout);
        jPANELTOTALLayout.setHorizontalGroup(
            jPANELTOTALLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPANELTOTALLayout.createSequentialGroup()
                .addGroup(jPANELTOTALLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPANELTOTALLayout.createSequentialGroup()
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnGerarTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(btnADDAOTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jBoxPesquisar1))
                .addContainerGap())
            .addGroup(jPANELTOTALLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPANELTOTALLayout.createSequentialGroup()
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 910, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPANELTOTALLayout.setVerticalGroup(
            jPANELTOTALLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPANELTOTALLayout.createSequentialGroup()
                .addComponent(jBoxPesquisar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 424, Short.MAX_VALUE)
                .addGroup(jPANELTOTALLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGerarTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnADDAOTXT, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPANELTOTALLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPANELTOTALLayout.createSequentialGroup()
                    .addGap(158, 158, 158)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(68, Short.MAX_VALUE)))
        );

        getContentPane().add(jPANELTOTAL);
        jPANELTOTAL.setBounds(24, 11, 920, 640);

        setSize(new java.awt.Dimension(969, 693));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Leitura() 
    {        
        sTipo  = txtTIPO.getText();
        limpar();      
    }
        
    private void addItensAoTXT()
    {  
        sChapa = txtCHAPA.getText();
        sSerie = txtSERIEINI.getText();
        
        //adicionando item na lista
        lstListaCampos.add(sChapa+";"+sSerie+";"+"1;"+"30;"+"202;"+"27;"+"6;"+sTipo+";"+"N");
        lstAuxiliar.add(sChapa+";"+sSerie+";"+"1;"+"30;"+"202;"+"27;"+"6;"+sTipo+";"+"N");

        for(int i = 0; i < lstListaCampos.size(); i++)
        {
            ArrayList itensForm = new ArrayList();            
            itensForm           = lstListaCampos;             
            
            //adicionando item na lista do txtdescricao do formulario -> itensForm.get(i)+"\n" => Retira o [] da String e coloca um embaixo do outro em cada linha
            txtRESULTADOS.append(itensForm.get(i)+"\n");
                        
            //System.out.println(itensForm);             
        }               
               
        txtSERIEINI.setText("");
        txtSERIEFIM.setText("");
        txtSERIEINI.requestFocus();    
    }
    
    private void gerarTXTMANUAL()
    {
        //abrindo opção para selecionar o local para salvar o arquivo
        JFileChooser chooser            = new JFileChooser();
        FileNameExtensionFilter filtro  = new FileNameExtensionFilter("Arquivos txt","txt");
        chooser.setFileFilter(filtro);
        chooser.setDialogTitle("Salvar arquivo");
        chooser.setMultiSelectionEnabled(false);
        chooser.setAcceptAllFileFilterUsed(false);

        //se escolheu um local aceitavel continua
        if(chooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION)
        {
            String caminhoArq = chooser.getSelectedFile().toString().concat(".txt");
            //JOptionPane.showMessageDialog(rootPane, "Qde de itens na lista = "+lstAuxiliar.size()); 
            
            for(String itens : lstAuxiliar){
                gravarNoArquivo(caminhoArq,itens); 
                System.out.println(itens);
            }
            
            //GRAVANDO SOMENTE O ULTIMO REGISTRO MAS LISTANDO TODOS
        }
    }
    
    public static boolean gravarNoArquivo(String Caminho, String Texto)
    {
        try{
            FileWriter        arq = new FileWriter(Caminho);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.println(Texto);
            gravarArq.close();
            return true;
        }catch(IOException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    private void btnGerarTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarTXTActionPerformed
       //Metodo MANUAL inserido a série inteira
       //Metodo não Manual : Serie com padrao inicial / final = metodoLotes
       //JOptionPane.showMessageDialog(null, metodoPADRAOINIFIM);
        
       if(!metodoPADRAOINIFIM){
          gerarTXTMANUAL();
       }
       
       
    }//GEN-LAST:event_btnGerarTXTActionPerformed

    private void limpar(){
        btnNovo.setEnabled(true);
        btnGerarTXT.setEnabled(false);
        btnADDAOTXT.setEnabled(false);
        btnLimpar.setEnabled(false);
        txtTIPO.setText("");
        txtMODELO.setText("");
        txtCHAPA.setText("");
        txtSERIEINI.setText("");
        txtSERIEFIM.setText("");
        txtRESULTADOS.setText("");
        txtRESULTADOS.setEditable(false);
        lstListaCampos.clear();
    }
    
    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        //abrir lista de tipos de equipamentos para cadastrar
        F_LISTATIPOS frmTipos = new F_LISTATIPOS(new javax.swing.JFrame(), true);
        frmTipos.setVisible(true);
        //se este tipo tiver clientes virturais dos setores quero abrir a lista com eles e não a lista com os servidores
        sTipo = frmTipos.getItemSelecionado();       
        txtTIPO.setText(sTipo);  
        codTipoSelecionado = umMetodo.getCodigoPassandoString("tbltipos", "tipo", sTipo);      
        
        //abre a lista de modelos
        tabela_da_lista   = "TBLMODELOS";
        F_LISTAMODELOSGERARTXT frm = new F_LISTAMODELOSGERARTXT(new javax.swing.JFrame(), true);
        frm.setVisible(true);                    
        txtMODELO.setText(TipoModelo);  
                        
        //habilitando edição do txtSerie       
        txtSERIEINI.setEditable(true);        
        txtSERIEINI.requestFocus();
        btnNovo.setEnabled(false);
        btnGerarTXT.setEnabled(true);
        btnADDAOTXT.setEnabled(true);
        btnLimpar.setEnabled(true);
        
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnADDAOTXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnADDAOTXTActionPerformed
    if(txtSERIEINI.getText().equals("") || txtCHAPA.getText().equals(""))
    {
        JOptionPane.showMessageDialog(null, "Os campos [Série e Chapa] são de preenchimento obrigatórios!", "Campos obrigatórios vazios!", 2);
        txtSERIEINI.requestFocus();
    }else{
        if(txtSERIEFIM.getText().equals("") || txtSERIEFIM.getText().equals(null)){
            metodoPADRAOINIFIM = false;
        }else{
            metodoPADRAOINIFIM = true;
        }
        //Limpando a lista pois quando adicionamos novo item ela é prenchida novamento com todos os registros já preenchidos, se não limpar haverá duplucidades
        lstListaCampos.clear();
        addItensAoTXT();
        
        txtCHAPA.setText("");
    }
        //JOptionPane.showMessageDialog(null, metodoPADRAOINIFIM);
    }//GEN-LAST:event_btnADDAOTXTActionPerformed

    private void txtSERIEFIMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSERIEFIMKeyPressed
        btnGerarTXT.setEnabled(false);    
        metodoPADRAOINIFIM = true;
    }//GEN-LAST:event_txtSERIEFIMKeyPressed

    private void txtSERIEINIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSERIEINIKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtSERIEFIM.requestFocus();
            txtSERIEFIM.setEditable(true);
            btnADDAOTXT.setEnabled(true);
        }
    }//GEN-LAST:event_txtSERIEINIKeyPressed

    private void txtSERIEINIKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSERIEINIKeyReleased
        //gera serie automaticamente / manda foco para serie
        txtCHAPA.setText("008"+umMetodo.gerarNumeroAleatorio());
    }//GEN-LAST:event_txtSERIEINIKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(F_GERARTXT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(F_GERARTXT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(F_GERARTXT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(F_GERARTXT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                F_GERARTXT dialog = new F_GERARTXT(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnADDAOTXT;
    private javax.swing.JButton btnGerarTXT;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox<String> cmbSTATUS;
    private javax.swing.JLayeredPane jBoxPesquisar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPANELTOTAL;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField txtCHAPA;
    private javax.swing.JTextField txtMODELO;
    private javax.swing.JTextArea txtRESULTADOS;
    private javax.swing.JTextField txtSECAO;
    private javax.swing.JTextField txtSERIEFIM;
    private javax.swing.JTextField txtSERIEINI;
    private javax.swing.JTextField txtTIPO;
    // End of variables declaration//GEN-END:variables
}
