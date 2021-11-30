/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller_DAO.CidadesDao;
import Controller_DAO.EntidadesDao;
import Model.Cidades;
import Model.Entidades;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author david.castagnaro
 */
public final class EntidadesView extends javax.swing.JFrame {

    /**
     * Creates new form Entidades
     */
    public EntidadesView() {
        initComponents();
        carregaDados();

        CidadesDao dao = new CidadesDao();

        for (Cidades d : dao.listar()) {
            cbcidade.addItem(d);
        }

    }

    public void carregaDados() {
        DefaultTableModel tabela = (DefaultTableModel) tTabela.getModel();
        EntidadesDao dao = new EntidadesDao();
        tabela.setNumRows(0);

        dao.listar().forEach((Entidades e) -> {
            tabela.addRow(new Object[]{
                e.getId_entidade(),
                e.getNome(),
                e.getEndereco(),
                e.getCidades().getDescricao()
            });
        }
        );
    }

    public void pesquisaDados() {

        DefaultTableModel tabela = (DefaultTableModel) tTabela.getModel();

       EntidadesDao dao = new EntidadesDao();

        tabela.setNumRows(0);

        for (Entidades e : dao.pesquisar(tfpesquisacampo.getText())) {
            tabela.addRow(new Object[]{
                e.getId_entidade(),
                e.getNome(),
                e.getEndereco(),
                e.getCidades().getDescricao()
            });
        }

    }

    public void LimparCampos() {
        tfnome.setText("");
        tfendereco.setText("");

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
        tfcodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfnome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfendereco = new javax.swing.JTextField();
        cbcidade = new javax.swing.JComboBox<>();
        tfcadastrar = new javax.swing.JButton();
        tfexcluir = new javax.swing.JButton();
        tfalterar = new javax.swing.JButton();
        tflimpar = new javax.swing.JButton();
        tffechar = new javax.swing.JButton();
        tfpesquisacampo = new javax.swing.JTextField();
        tfpesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tTabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro de Entidades"));

        jLabel1.setText("Código:");

        tfcodigo.setEnabled(false);

        jLabel2.setText("Nome:");

        jLabel3.setText("Endereço:");

        jLabel4.setText("Cidade:");

        tfcadastrar.setText("Cadastrar");
        tfcadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfcadastrarActionPerformed(evt);
            }
        });

        tfexcluir.setText("Excluir");
        tfexcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfexcluirActionPerformed(evt);
            }
        });

        tfalterar.setText("Alterar");
        tfalterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfalterarActionPerformed(evt);
            }
        });

        tflimpar.setText("Limpar");
        tflimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tflimparActionPerformed(evt);
            }
        });

        tffechar.setText("Fechar");
        tffechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tffecharActionPerformed(evt);
            }
        });

        tfpesquisar.setText("Pesquisar");
        tfpesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfpesquisarActionPerformed(evt);
            }
        });

        tTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Endereço", "Cidade"
            }
        ));
        tTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tTabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tTabela);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfnome)
                            .addComponent(tfendereco)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbcidade, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfpesquisacampo)
                        .addGap(8, 8, 8)
                        .addComponent(tfpesquisar)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(tfcadastrar)
                .addGap(18, 18, 18)
                .addComponent(tfalterar)
                .addGap(18, 18, 18)
                .addComponent(tfexcluir)
                .addGap(18, 18, 18)
                .addComponent(tflimpar)
                .addGap(18, 18, 18)
                .addComponent(tffechar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfendereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbcidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfcadastrar)
                    .addComponent(tfexcluir)
                    .addComponent(tfalterar)
                    .addComponent(tflimpar)
                    .addComponent(tffechar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfpesquisacampo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfpesquisar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tflimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tflimparActionPerformed
        // TODO add your handling code here:
        LimparCampos();
    }//GEN-LAST:event_tflimparActionPerformed

    private void tfcadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfcadastrarActionPerformed
        // TODO add your handling code here:
        Entidades e = new Entidades();
        EntidadesDao Dao = new EntidadesDao();

        Cidades cidade = (Cidades) cbcidade.getSelectedItem();
        e.setCidades(cidade);

        e.setNome(tfnome.getText());
        e.setEndereco(tfendereco.getText());

        Dao.cadastrar(e);
        carregaDados();
    }//GEN-LAST:event_tfcadastrarActionPerformed

    private void tfalterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfalterarActionPerformed
        Entidades ent = new Entidades();
        EntidadesDao DAO = new EntidadesDao();

        Cidades cid = (Cidades) cbcidade.getSelectedItem();

        ent.setId_entidade(Integer.parseInt(tfcodigo.getText()));
        ent.setNome(tfnome.getText());
        ent.setEndereco(tfendereco.getText());
        ent.setCidades(cid);

        DAO.alterar(ent);
        carregaDados();

    }//GEN-LAST:event_tfalterarActionPerformed

    private void tTabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tTabelaMouseClicked
        String comboEntidades = tTabela.getValueAt(tTabela.getSelectedRow(), 3).toString();
        for (int i = 0; i < cbcidade.getItemCount(); i++) {
            if (cbcidade.getItemAt(i).toString().equalsIgnoreCase(comboEntidades)) {
                cbcidade.setSelectedIndex(i);
            }
        }

        tfcodigo.setText(tTabela.getValueAt(tTabela.getSelectedRow(), 0).toString());
        tfnome.setText(tTabela.getValueAt(tTabela.getSelectedRow(), 1).toString());
        tfendereco.setText(tTabela.getValueAt(tTabela.getSelectedRow(), 2).toString());
    }//GEN-LAST:event_tTabelaMouseClicked

    private void tfexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfexcluirActionPerformed
        try {
            // TODO add your handling code here:
            Entidades ent = new Entidades();
            EntidadesDao dao = new EntidadesDao();

            ent.setId_entidade(Integer.parseInt(tfcodigo.getText()));

            dao.excluir(ent);
            carregaDados();

        } catch (SQLException ex) {
            Logger.getLogger(EntidadesView.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tfexcluirActionPerformed

    private void tffecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tffecharActionPerformed
        // TODO add your handling code here:
        EntidadesView.this.dispose();

    }//GEN-LAST:event_tffecharActionPerformed

    private void tfpesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfpesquisarActionPerformed
        // TODO add your handling code here:
        pesquisaDados();
       
    }//GEN-LAST:event_tfpesquisarActionPerformed

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
            java.util.logging.Logger.getLogger(EntidadesView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EntidadesView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EntidadesView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EntidadesView.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EntidadesView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Object> cbcidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tTabela;
    private javax.swing.JButton tfalterar;
    private javax.swing.JButton tfcadastrar;
    private javax.swing.JTextField tfcodigo;
    private javax.swing.JTextField tfendereco;
    private javax.swing.JButton tfexcluir;
    private javax.swing.JButton tffechar;
    private javax.swing.JButton tflimpar;
    private javax.swing.JTextField tfnome;
    private javax.swing.JTextField tfpesquisacampo;
    private javax.swing.JButton tfpesquisar;
    // End of variables declaration//GEN-END:variables
}
