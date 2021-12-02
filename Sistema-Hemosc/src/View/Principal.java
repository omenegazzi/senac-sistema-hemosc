/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller_DAO.AgendamentosDao;
import Model.Agendamentos;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author diegomenegazzi
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        carregaDados();
    }

    public void carregaDados() {

        DefaultTableModel tabela = (DefaultTableModel) jTableAgendamentos.getModel();
        AgendamentosDao dao = new AgendamentosDao();
        tabela.setNumRows(0);

        for (Agendamentos A : dao.listar()) {
            tabela.addRow(new Object[]{
                A.getId_agendamento(),
                A.getData(),
                A.getHora(),
                A.getDoador()
            });
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAgendamentos = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuDeFunções = new javax.swing.JMenu();
        jMenuColaboradores = new javax.swing.JMenuItem();
        Doadores = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        MenuFunções = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        Jmenu = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Agendamentos do dia"));

        jTableAgendamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Data", "Hora", "Doador"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableAgendamentos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuDeFunções.setText("Cadastros");
        jMenuDeFunções.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuDeFunçõesActionPerformed(evt);
            }
        });

        jMenuColaboradores.setText("Colaboradores");
        jMenuColaboradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuColaboradoresActionPerformed(evt);
            }
        });
        jMenuDeFunções.add(jMenuColaboradores);

        Doadores.setText("Doadores");
        Doadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoadoresActionPerformed(evt);
            }
        });
        jMenuDeFunções.add(Doadores);

        jMenuItem2.setText("Tipo Sanguíneo");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenuDeFunções.add(jMenuItem2);

        MenuFunções.setText("Funções");
        MenuFunções.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuFunçõesActionPerformed(evt);
            }
        });
        jMenuDeFunções.add(MenuFunções);

        jMenuItem1.setText("Usuários");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuDeFunções.add(jMenuItem1);

        jMenuItem3.setText("Cidades");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenuDeFunções.add(jMenuItem3);

        jMenuItem4.setText("Agendamentos");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenuDeFunções.add(jMenuItem4);

        Jmenu.setText("Entidades");
        Jmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmenuActionPerformed(evt);
            }
        });
        jMenuDeFunções.add(Jmenu);
        jMenuDeFunções.add(jSeparator1);

        jMenuItem9.setText("Doações");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenuDeFunções.add(jMenuItem9);

        jMenuItem10.setText("Saída de Sangue");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenuDeFunções.add(jMenuItem10);

        jMenuBar1.add(jMenuDeFunções);

        jMenu3.setText("Relatórios");
        jMenuBar1.add(jMenu3);

        jMenu2.setText("Ajuda");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        UsuariosView usuarios = new UsuariosView();
        usuarios.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuColaboradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuColaboradoresActionPerformed
        ColaboradoresView c = new ColaboradoresView();
        c.setVisible(true);
    }//GEN-LAST:event_jMenuColaboradoresActionPerformed

    private void DoadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoadoresActionPerformed
        // TODO add your handling code here:
        DoadoresView c = new DoadoresView();
        c.setVisible(true);
    }//GEN-LAST:event_DoadoresActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        TipoSanguineoView t = new TipoSanguineoView();
        t.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuDeFunçõesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuDeFunçõesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuDeFunçõesActionPerformed

    private void MenuFunçõesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuFunçõesActionPerformed
        FuncoesView f = new FuncoesView();
        f.setVisible(true);
    }//GEN-LAST:event_MenuFunçõesActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        CidadesView f = new CidadesView();
        f.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        SaidaSangueView s = new SaidaSangueView();
        s.setVisible(true);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        AgendamentoView a = new AgendamentoView();
        a.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void JmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmenuActionPerformed
        EntidadesView e = new EntidadesView();
        e.setVisible(true);
    }//GEN-LAST:event_JmenuActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        DoacoesView d = new DoacoesView();
        d.setVisible(true);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Doadores;
    private javax.swing.JMenuItem Jmenu;
    private javax.swing.JMenuItem MenuFunções;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuColaboradores;
    private javax.swing.JMenu jMenuDeFunções;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable jTableAgendamentos;
    // End of variables declaration//GEN-END:variables
}
