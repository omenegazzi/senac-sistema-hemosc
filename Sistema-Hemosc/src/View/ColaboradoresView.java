/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller_DAO.CidadesDao;
import Controller_DAO.ColaboradoresDao;
import Controller_DAO.FuncoesDao;
import Model.Cidades;
import Model.Colaboradores;
import Model.Funcoes;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marcelo.nascimento1
 */
public class ColaboradoresView extends javax.swing.JFrame {

    /**
     * Creates new form ColaboradoresView
     */
    public ColaboradoresView() {
        initComponents();
        carregaDados();
        
       CidadesDao Dao = new CidadesDao();
       
       for (Cidades c: Dao.listar()){
           SelecionarCidade.addItem(c);
       }
       
       FuncoesDao dao = new FuncoesDao();
       
       for (Funcoes f: dao.listar()){
           SelecionarFuncao.addItem(f);
       }
    }
    
    public void carregaDados(){
        
        DefaultTableModel tabela = (DefaultTableModel) TabelaColaboradores.getModel();      
        ColaboradoresDao dao = new ColaboradoresDao();
        tabela.setNumRows(0);
                
        for (Colaboradores C : dao.listar()){
            tabela.addRow(new Object[]{
                C.getId_colaborador(),
                C.getCidade().getDescricao(),
                C.getNome(),
                C.getEndereco(),
                C.getFuncao().getFuncao()
            });
        }
    }
    
    
    public void pesquisaDados() {
        DefaultTableModel tabela = (DefaultTableModel) TabelaColaboradores.getModel();
        ColaboradoresDao dao = new ColaboradoresDao();
        tabela.setNumRows(0);

        for (Colaboradores c : dao.pesquisar(tfpesquisar.getText())) {
            tabela.addRow(new Object[]{
                c.getId_colaborador(),
                c.getCidade().getDescricao(),
                c.getNome(),
                c.getEndereco(),
                c.getFuncao().getFuncao()
            });
        }
    }
    
    public void LimparCampos() {
        CampoId.setText("");
        CampoNome.setText("");
        CampoEndereco.setText("");
        tfpesquisar.setText("");

    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        CampoId = new javax.swing.JTextField();
        CampoNome = new javax.swing.JTextField();
        CampoEndereco = new javax.swing.JTextField();
        SelecionarFuncao = new javax.swing.JComboBox<>();
        BotãoCadastrar = new javax.swing.JButton();
        BotãoAlterar = new javax.swing.JButton();
        BotãoExcluir = new javax.swing.JButton();
        BotãoLimpar = new javax.swing.JButton();
        BotãoFechar = new javax.swing.JButton();
        SelecionarCidade = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaColaboradores = new javax.swing.JTable();
        BotãoPesquisar = new javax.swing.JButton();
        tfpesquisar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Código:");

        jLabel2.setText(" Cidade:");

        jLabel3.setText("Nome:");

        jLabel4.setText("Endereço:");

        jLabel5.setText("Função:");

        CampoId.setEditable(false);

        CampoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoNomeActionPerformed(evt);
            }
        });

        CampoEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoEnderecoActionPerformed(evt);
            }
        });

        BotãoCadastrar.setText("Cadastrar");
        BotãoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotãoCadastrarActionPerformed(evt);
            }
        });

        BotãoAlterar.setText("Alterar");

        BotãoExcluir.setText("Excluir");

        BotãoLimpar.setText("Limpar");
        BotãoLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotãoLimparActionPerformed(evt);
            }
        });

        BotãoFechar.setText("Fechar");
        BotãoFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotãoFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CampoNome)
                            .addComponent(CampoEndereco)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CampoId, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SelecionarFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SelecionarCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(BotãoCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotãoAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(BotãoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotãoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BotãoFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CampoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(SelecionarCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CampoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(CampoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(SelecionarFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotãoCadastrar)
                    .addComponent(BotãoAlterar)
                    .addComponent(BotãoExcluir)
                    .addComponent(BotãoLimpar)
                    .addComponent(BotãoFechar))
                .addContainerGap())
        );

        TabelaColaboradores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Cidade", "Nome", "Endereço", "Função"
            }
        ));
        TabelaColaboradores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaColaboradoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaColaboradores);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addContainerGap())
        );

        BotãoPesquisar.setText("Pesquisar");
        BotãoPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotãoPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(tfpesquisar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotãoPesquisar)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotãoPesquisar)
                    .addComponent(tfpesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CampoEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoEnderecoActionPerformed

    private void TabelaColaboradoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaColaboradoresMouseClicked
        CampoId.setText(TabelaColaboradores.getValueAt(TabelaColaboradores.getSelectedRow(), 0).toString());                
        CampoNome.setText(TabelaColaboradores.getValueAt(TabelaColaboradores.getSelectedRow(),2).toString());
        CampoEndereco.setText(TabelaColaboradores.getValueAt(TabelaColaboradores.getSelectedRow(),3).toString());        
                    
        String Cidade = TabelaColaboradores.getValueAt(TabelaColaboradores.getSelectedRow(), 1).toString();
        for(int i = 0; i < SelecionarCidade.getItemCount();i++){
            if(SelecionarCidade.getItemAt(i).toString().equalsIgnoreCase(Cidade)){
                SelecionarCidade.setSelectedIndex(i);
            }
        }     
        
        String Funcao = TabelaColaboradores.getValueAt(TabelaColaboradores.getSelectedRow(), 4).toString();
        for(int i = 0; i < SelecionarFuncao.getItemCount();i++){
            if(SelecionarFuncao.getItemAt(i).toString().equalsIgnoreCase(Funcao)){
                SelecionarFuncao.setSelectedIndex(i);
            }
        }     
    }//GEN-LAST:event_TabelaColaboradoresMouseClicked

    private void BotãoPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotãoPesquisarActionPerformed
    pesquisaDados(); 
    }//GEN-LAST:event_BotãoPesquisarActionPerformed

    private void BotãoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotãoCadastrarActionPerformed
    
        Colaboradores c = new Colaboradores();
        ColaboradoresDao DAO = new ColaboradoresDao();
       
        Cidades cid = (Cidades) SelecionarCidade.getSelectedItem();
        Funcoes fun = (Funcoes) SelecionarFuncao.getSelectedItem();
        
        c.setCidade(cid);
        c.setNome(CampoNome.getText());
        c.setEndereco(CampoEndereco.getText());
        c.setFuncao(fun);
        
        DAO.cadastrar(c);
        carregaDados();
        
    }//GEN-LAST:event_BotãoCadastrarActionPerformed

    private void CampoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoNomeActionPerformed

    private void BotãoLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotãoLimparActionPerformed
        LimparCampos();
    }//GEN-LAST:event_BotãoLimparActionPerformed

    private void BotãoFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotãoFecharActionPerformed
        ColaboradoresView.this.dispose();
    }//GEN-LAST:event_BotãoFecharActionPerformed

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
            java.util.logging.Logger.getLogger(ColaboradoresView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ColaboradoresView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ColaboradoresView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ColaboradoresView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ColaboradoresView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotãoAlterar;
    private javax.swing.JButton BotãoCadastrar;
    private javax.swing.JButton BotãoExcluir;
    private javax.swing.JButton BotãoFechar;
    private javax.swing.JButton BotãoLimpar;
    private javax.swing.JButton BotãoPesquisar;
    private javax.swing.JTextField CampoEndereco;
    private javax.swing.JTextField CampoId;
    private javax.swing.JTextField CampoNome;
    private javax.swing.JComboBox<Object> SelecionarCidade;
    private javax.swing.JComboBox<Object> SelecionarFuncao;
    private javax.swing.JTable TabelaColaboradores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tfpesquisar;
    // End of variables declaration//GEN-END:variables
}