/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package urnaeletronica.tela;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import urnaeletronica.DAO.CandidatoDAO;
import urnaeletronica.DAO.PartidoDAO;
import urnaeletronica.model.Candidato;
import urnaeletronica.model.Partido;

/**
 *
 * @author TPSI-LUANA
 */
public class CandidatoJDialog extends javax.swing.JDialog {

    private CandidatoDAO candidatoDAO;
    private PartidoDAO partidoDAO;

    public CandidatoJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Candidato");
        candidatoDAO = new CandidatoDAO();

        tfCodigo.setEditable(false);
        setTfCodigo();
        partidoDAO = new PartidoDAO();
        carregaComboPartido();
        desabilitaCampo();
        try {
            carregaTable(candidatoDAO.getAll());
        } catch (SQLException ex) {
            Logger.getLogger(CandidatoJDialog.class.getName()).log(Level.SEVERE, null, ex);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfNumero = new javax.swing.JTextField();
        tfNome = new javax.swing.JTextField();
        cbPartido = new javax.swing.JComboBox<>();
        btSalvar = new javax.swing.JButton();
        btRemover = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        tfCC = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        rbCodigo = new javax.swing.JRadioButton();
        rbCandidato = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        candidatoTable = new javax.swing.JTable();
        btLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(102, 102, 102), null, null));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Candidato");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/urnaeletronica/candidatos.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(310, 310, 310))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(294, 294, 294))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(40, 40, 40))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Número");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nome");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Partido");

        cbPartido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbPartido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btSalvar.setBackground(new java.awt.Color(0, 0, 255));
        btSalvar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btRemover.setBackground(new java.awt.Color(0, 0, 255));
        btRemover.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btRemover.setForeground(new java.awt.Color(255, 255, 255));
        btRemover.setText("Remover");
        btRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoverActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Código");

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        btBuscar.setBackground(new java.awt.Color(0, 0, 255));
        btBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbCodigo);
        rbCodigo.setText("Código");
        rbCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCodigoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbCandidato);
        rbCandidato.setText("Candidato");
        rbCandidato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCandidatoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Buscar Candidato");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/urnaeletronica/atualizar.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rbCodigo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rbCandidato)
                                .addGap(0, 176, Short.MAX_VALUE))
                            .addComponent(tfCC, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btBuscar)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 31, Short.MAX_VALUE)
                        .addComponent(btBuscar)
                        .addGap(2, 2, 2)
                        .addComponent(jButton1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(rbCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbCandidato)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        candidatoTable.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        candidatoTable.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        candidatoTable.setForeground(new java.awt.Color(0, 0, 0));
        candidatoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Número", "Nome", "Partido"
            }
        ));
        candidatoTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                candidatoTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(candidatoTable);

        btLimpar.setBackground(new java.awt.Color(0, 0, 255));
        btLimpar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btLimpar.setForeground(new java.awt.Color(255, 255, 255));
        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfNome, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(cbPartido, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 28, Short.MAX_VALUE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel6)
                .addGap(5, 5, 5)
                .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btSalvar)
                                    .addComponent(btRemover)
                                    .addComponent(btLimpar))
                                .addGap(123, 123, 123))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel2.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        salvar();
        setTfCodigo();
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverActionPerformed
        remover();
        setTfCodigo();
    }//GEN-LAST:event_btRemoverActionPerformed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        if (tfNome.getText().trim().length() > 0 && tfNumero.getText().trim().length() > 0) {
            btSalvar.setEnabled(true);
        } else {
            btSalvar.setEnabled(false);
        }
        if (candidatoTable.getSelectedRow() != -1) {
            btRemover.setEnabled(true);
        } else {
            btRemover.setEnabled(false);
        }
    }//GEN-LAST:event_formMouseMoved

    private void candidatoTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_candidatoTableMouseClicked
        eventoTableAtualizar();
    }//GEN-LAST:event_candidatoTableMouseClicked

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        try {
            tfCodigo.setText(String.valueOf(candidatoDAO.getLastId()));
            limparCampos();
            setTfCodigo();
            btSalvar.setEnabled(false);
            btSalvar.setText("Salvar");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        desabilitaCampo();
    }//GEN-LAST:event_btLimparActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        filtrar();
    }//GEN-LAST:event_btBuscarActionPerformed

    private void rbCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCodigoActionPerformed
        desabilitaCampo();
    }//GEN-LAST:event_rbCodigoActionPerformed

    private void rbCandidatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCandidatoActionPerformed
        desabilitaCampo();
    }//GEN-LAST:event_rbCandidatoActionPerformed

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
            java.util.logging.Logger.getLogger(CandidatoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CandidatoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CandidatoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CandidatoJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CandidatoJDialog dialog = new CandidatoJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btRemover;
    private javax.swing.JButton btSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JTable candidatoTable;
    private javax.swing.JComboBox<String> cbPartido;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbCandidato;
    private javax.swing.JRadioButton rbCodigo;
    private javax.swing.JTextField tfCC;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfNumero;
    // End of variables declaration//GEN-END:variables

    private void salvar() {
        try {
            Candidato candidato = new Candidato();
            candidato.setCodigo(Integer.parseInt(tfCodigo.getText()));
            candidato.setNumero(tfNumero.getText());
            candidato.setNome(tfNome.getText());
            candidato.setPartido((Partido) cbPartido.getSelectedItem());
            try {
                if (candidatoDAO.getLastId() == Integer.parseInt(tfCodigo.getText())) {
                    if (verificaNumero() && verificaPartido()) {
                        candidatoDAO.save(candidato);
                        
                        JOptionPane.showMessageDialog(null, "Registro Salvo Com Sucesso!!!");
                    }

                } else {
                    candidatoDAO.update(candidato);
                    JOptionPane.showMessageDialog(null, "Registro Salvo Com Sucesso!!!");

                }
                carregaTable(candidatoDAO.getAll());
                btSalvar.setText("Salvar");
                btSalvar.setEnabled(false);
                limparCampos();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar.", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limparCampos() {
        tfNumero.setText("");
        tfNome.setText("");
        cbPartido.setSelectedIndex(0);
    }

    private void carregaTable(List<Candidato> candidatoList) {
        if (candidatoList == null) {
            return;
        }
        DefaultTableModel model = (DefaultTableModel) candidatoTable.getModel();
        model.setRowCount(0);
        for (Candidato c : candidatoList) {
            model.addRow(new Object[]{c.getCodigo(), c.getNumero(), c.getNome(), c.getPartido().getSigla()});
        }
    }

    private void carregaComboPartido() {
        try {
            DefaultComboBoxModel modeloComboPartido;
            modeloComboPartido = new DefaultComboBoxModel(partidoDAO.getAll().toArray());
            cbPartido.setModel(modeloComboPartido);
        } catch (SQLException ex) {
            Logger.getLogger(CandidatoJDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void remover() {
        int linhaSeleciona = candidatoTable.getSelectedRow();
        if (linhaSeleciona == -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma linha para Remover", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int codigoRemover = (int) candidatoTable.getValueAt(linhaSeleciona, 0);
        try {
            candidatoDAO.delete(codigoRemover);
            limparCampos();
            btSalvar.setText("Salvar");
            btSalvar.setEnabled(false);
            btRemover.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Removido com Sucesso");
            carregaTable(candidatoDAO.getAll());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível remover este candidato", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscar() {
        try {
            if (rbCodigo.isSelected() && tfCC.getText().trim().length() > 0) {//Codigo está selecionado
                Candidato candidato = candidatoDAO.getById(Integer.parseInt(tfCC.getText()));
                List<Candidato> candidatoList = new ArrayList<>();
                candidatoList.add(candidato);
                carregaTable(candidatoList);
            } else if (rbCandidato.isSelected() && tfCC.getText().trim().length() > 0) {
                carregaTable(candidatoDAO.getByName(tfCC.getText()));
            } else {
                JOptionPane.showMessageDialog(null, "Favor Informe um filtro para Pesquisa...", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NullPointerException npe) {
            JOptionPane.showMessageDialog(null, "Informação Não Encontrada", "ATENÇÃO", JOptionPane.ERROR);
            try {
                carregaTable(candidatoDAO.getAll());
            } catch (SQLException ex) {
                Logger.getLogger(CandidatoJDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Campo somente de números", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
            try {
                carregaTable(candidatoDAO.getAll());
            } catch (SQLException ex) {
                Logger.getLogger(CandidatoJDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void desabilitaCampo() {
        if (rbCodigo.isSelected() || rbCandidato.isSelected()) {
            tfCC.setEditable(true);
        } else {
            tfCC.setEditable(false);
        }
    }

    private void setTfCodigo() {
        try {
            tfCodigo.setText(String.valueOf(candidatoDAO.getLastId()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void eventoTableAtualizar() {
        Candidato candidato = new Candidato();
        try {
            candidato = candidatoDAO.getById((int) candidatoTable.getValueAt(candidatoTable.getSelectedRow(), 0));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        btSalvar.setText("Atualizar");
        tfCodigo.setText(String.valueOf(candidato.getCodigo()));
        tfNome.setText(candidato.getNome());
        tfNumero.setText(candidato.getNumero());
        cbPartido.setSelectedItem(candidato.getPartido().getSigla());
        btSalvar.setEnabled(true);
        btRemover.setEnabled(true);
    }

    private void limpar() {
        try {
            carregaTable(candidatoDAO.getAll());
        } catch (SQLException ex) {
            Logger.getLogger(CandidatoJDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void filtrar() {
        try {
            if (rbCodigo.isSelected() && tfCC.getText().trim().length() > 0) {//Codigo está selecionado
                Candidato candidato = candidatoDAO.getById(Integer.parseInt(tfCC.getText()));
                List<Candidato> candidatoList = new ArrayList<>();
                candidatoList.add(candidato);
                carregaTable(candidatoList);
            } else if (rbCandidato.isSelected() && tfCC.getText().trim().length() > 0) {
                carregaTable(candidatoDAO.getByName(tfCC.getText()));
            } else {
                JOptionPane.showMessageDialog(null, "Favor Informe um filtro para Pesquisa...", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean verificaNumero() {
        List<Candidato> candidatoList = new ArrayList<>();
        try {
            candidatoList = candidatoDAO.getAll();
        } catch (SQLException ex) {
            Logger.getLogger(CandidatoJDialog.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Candidato c : candidatoList) {
            if (tfNumero.getText().equals(c.getNumero())) {
                JOptionPane.showMessageDialog(null, "Número já está sendo usado", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        return true;
    }

    public boolean verificaPartido() {
        try {
            for (Candidato c : candidatoDAO.getAll()) {
                if (c.getPartido().getSigla().equalsIgnoreCase(String.valueOf(cbPartido.getSelectedItem()))) {
                    JOptionPane.showMessageDialog(null, "Já existe candidato cadastrado para este partido", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(CandidatoJDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

   

}
