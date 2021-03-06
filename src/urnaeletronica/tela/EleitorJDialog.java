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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import urnaeletronica.DAO.EleitorDAO;
import urnaeletronica.DAO.VotoDAO;
import urnaeletronica.model.Eleitor;

/**
 *
 * @author TPSI-LUANA
 */
public class EleitorJDialog extends javax.swing.JDialog {

    private EleitorDAO eleitorDAO;
    private VotoDAO votoDAO;

    public EleitorJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("Eleitor");
        this.setLocationRelativeTo(null);
        eleitorDAO = new EleitorDAO();
        votoDAO = new VotoDAO();
        tfCodigo.setEditable(false);
        btSalvar.setEnabled(false);
        btRemover.setEnabled(false);
        setTfCodigo();
        desabilitaCampo();
        try {
            carregaTable(eleitorDAO.getAll());
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null, "ERRO AO CARREGAR TABLE", "ERRO", JOptionPane.ERROR_MESSAGE);
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

        jButton3 = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        eleitorTable = new javax.swing.JTable();
        btSalvar = new javax.swing.JButton();
        btRemover = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btBuscar = new javax.swing.JButton();
        rbCodigo = new javax.swing.JRadioButton();
        rbEleitor = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        tfCE = new javax.swing.JTextField();
        btAtualizar = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();
        tfCpf = new javax.swing.JFormattedTextField();
        tfTitulo = new javax.swing.JFormattedTextField();
        tfNome = new javax.swing.JFormattedTextField();

        jButton3.setBackground(new java.awt.Color(102, 102, 102));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Salvar");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Eleitor");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/urnaeletronica/eleitor.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(299, 299, 299)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Código");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Titulo de Eleitor");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Nome");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("CPF");

        eleitorTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Titulo Eleitor", "CPF"
            }
        ));
        eleitorTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eleitorTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(eleitorTable);

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

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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

        buttonGroup1.add(rbEleitor);
        rbEleitor.setText("Eleitor");
        rbEleitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbEleitorActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Buscar Eleitor");

        btAtualizar.setBackground(new java.awt.Color(255, 255, 255));
        btAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/urnaeletronica/atualizar.png"))); // NOI18N
        btAtualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
            }
        });

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
                                .addComponent(rbEleitor)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tfCE, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(btBuscar))
                            .addComponent(btAtualizar, javax.swing.GroupLayout.Alignment.TRAILING))))
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
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAtualizar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(rbCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbEleitor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(37, Short.MAX_VALUE))))
        );

        btLimpar.setBackground(new java.awt.Color(0, 0, 255));
        btLimpar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btLimpar.setForeground(new java.awt.Color(255, 255, 255));
        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        try {
            tfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            tfTitulo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########/##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(tfCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfNome))
                                .addGap(358, 359, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btSalvar)
                        .addComponent(btRemover)
                        .addComponent(btLimpar))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        salvar();
        setTfCodigo();
    }//GEN-LAST:event_btSalvarActionPerformed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        if (tfNome.getText().trim().length() > 0 && tfTitulo.getText().trim().length() == 12 && tfCpf.getText().trim().length() == 14) {
            btSalvar.setEnabled(true);
        } else {
            btSalvar.setEnabled(false);
        }
        if (eleitorTable.getSelectedRow() != -1) {
            btRemover.setEnabled(true);
        } else {
            btRemover.setEnabled(false);
        }
    }//GEN-LAST:event_formMouseMoved

    private void btRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoverActionPerformed
        remover();
        setTfCodigo();
    }//GEN-LAST:event_btRemoverActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        try {
            tfCodigo.setText(String.valueOf(eleitorDAO.getLastId()));
            limparCampos();
            setTfCodigo();
            btSalvar.setEnabled(false);
            btSalvar.setText("Salvar");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        desabilitaCampo();
    }//GEN-LAST:event_btLimparActionPerformed

    private void eleitorTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eleitorTableMouseClicked
        eventoTableAtualizar();
    }//GEN-LAST:event_eleitorTableMouseClicked

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        filtrar();
    }//GEN-LAST:event_btBuscarActionPerformed

    private void rbCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCodigoActionPerformed
        desabilitaCampo();
    }//GEN-LAST:event_rbCodigoActionPerformed

    private void rbEleitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbEleitorActionPerformed
        desabilitaCampo();
    }//GEN-LAST:event_rbEleitorActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        try {
            carregaTable(eleitorDAO.getAll());
        } catch (SQLException ex) {
            Logger.getLogger(EleitorJDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btAtualizarActionPerformed

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
            java.util.logging.Logger.getLogger(EleitorJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EleitorJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EleitorJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EleitorJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EleitorJDialog dialog = new EleitorJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btLimpar;
    private javax.swing.JButton btRemover;
    private javax.swing.JButton btSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTable eleitorTable;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbCodigo;
    private javax.swing.JRadioButton rbEleitor;
    private javax.swing.JTextField tfCE;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JFormattedTextField tfCpf;
    private javax.swing.JFormattedTextField tfNome;
    private javax.swing.JFormattedTextField tfTitulo;
    // End of variables declaration//GEN-END:variables

    private void salvar() {
        Eleitor eleitor = new Eleitor();
        eleitor.setCodigo(Integer.parseInt(tfCodigo.getText()));
        eleitor.setNome(tfNome.getText());
        eleitor.setTitulo_eleitor(tfTitulo.getText());
        eleitor.setCpf(tfCpf.getText());
        try {
            if (eleitorDAO.getLastId() == Integer.parseInt(tfCodigo.getText())) {
                if (verificaTituloCpf()) {
                    eleitorDAO.save(eleitor);
                    JOptionPane.showMessageDialog(null, "Registro Salvo Com Sucesso!!!");
                } else {
                    JOptionPane.showMessageDialog(null, "CPF ou TÍTULO DE ELEITOR já foram cadastrados!", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                eleitorDAO.update(eleitor);
                JOptionPane.showMessageDialog(null, "Registro Atualizado Com Sucesso!!!");
            }

            carregaTable(eleitorDAO.getAll());
            btSalvar.setText("Salvar");
            btSalvar.setEnabled(false);
            limparCampos();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void limparCampos() {
        tfCodigo.setText("");
        tfNome.setText("");
        tfCpf.setText("");
        tfTitulo.setText("");
    }

    private void carregaTable(List<Eleitor> eleitorList) {
        if (eleitorList == null) {
            return;
        }
        DefaultTableModel model = (DefaultTableModel) eleitorTable.getModel();
        model.setRowCount(0);
        for (Eleitor e : eleitorList) {
            model.addRow(new Object[]{e.getCodigo(), e.getNome(), e.getTitulo_eleitor(), e.getCpf()});
        }
    }

    private void desabilitaCampo() {
        if (rbCodigo.isSelected() || rbEleitor.isSelected()) {
            tfCE.setEditable(true);
        } else {
            tfCE.setEditable(false);
        }
    }

    private void atualizar() {
        try {
            carregaTable(eleitorDAO.getAll());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Foi possível atualizar", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setTfCodigo() {
        try {
            tfCodigo.setText(String.valueOf(eleitorDAO.getLastId()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void eventoTableAtualizar() {
        Eleitor eleitor = new Eleitor();
        try {
            eleitor = eleitorDAO.getById((int) eleitorTable.getValueAt(eleitorTable.getSelectedRow(), 0));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        btSalvar.setText("Atualizar");
        tfCodigo.setText(String.valueOf(eleitor.getCodigo()));
        tfNome.setText(eleitor.getNome());
        tfTitulo.setText(eleitor.getTitulo_eleitor());
        tfCpf.setText(eleitor.getCpf());
        btSalvar.setEnabled(true);
        btRemover.setEnabled(true);
    }

    private void remover() {
        int linhaSeleciona = eleitorTable.getSelectedRow();
        if (linhaSeleciona == -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma linha para Remover", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int codigoRemover = (int) eleitorTable.getValueAt(linhaSeleciona, 0);
        try {
            eleitorDAO.delete(codigoRemover);
            limparCampos();
            btSalvar.setText("Salvar");
            btSalvar.setEnabled(false);
            btRemover.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Removido com Sucesso");
            carregaTable(eleitorDAO.getAll());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void filtrar() {
        try {
            if (rbCodigo.isSelected() && tfCE.getText().trim().length() > 0) {//Codigo está selecionado
                Eleitor eleitor = eleitorDAO.getById(Integer.parseInt(tfCE.getText()));
                List<Eleitor> eleitorList = new ArrayList<>();
                eleitorList.add(eleitor);
                carregaTable(eleitorList);
            } else if (rbEleitor.isSelected() && tfCE.getText().trim().length() > 0) {
                carregaTable(eleitorDAO.getByName(tfCE.getText()));
            } else {
                JOptionPane.showMessageDialog(null, "Favor Informe um filtro para Pesquisa...", "ATENÇÃO", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado!", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean verificaTituloCpf() {
        try {
            List<Eleitor> eleitorList = new ArrayList<>();
            eleitorList = eleitorDAO.getAll();

            for (Eleitor e : eleitorList) {
                if ((tfTitulo.getText().equals(e.getTitulo_eleitor()))
                        || (tfCpf.getText().equals(e.getCpf()))) {
                    return false;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(EleitorJDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

}
