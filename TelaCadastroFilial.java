package com.mycompany.gerenciamentoempresa;

public class TelaCadastroFilial extends javax.swing.JInternalFrame {

    private boolean editando = false;
    private Filial filial = new Filial();
    /**
     * Creates new form TelaCadastroFilial
     */
    public TelaCadastroFilial() {
        initComponents();
    }
    
    public TelaCadastroFilial(boolean editando, Filial filial) {
        initComponents();
        this.editando = editando;
        this.filial = filial;
        
        jTextNomeFilial.setText(filial.getNome());
        jTextCNPJEmpresa.setText(filial.getCNPJEmpresa());
        jTextTipoFilial.setText(filial.getTipo());
        jTextRuaFilial.setText(filial.getRua());
        jTextBairroFilial.setText(filial.getBairro());
        jTextCidadeFilial.setText(filial.getCidade());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextNomeFilial = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextCNPJEmpresa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextTipoFilial = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextRuaFilial = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextBairroFilial = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextCidadeFilial = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel1.setText("Filial da empresa");

        jLabel2.setText("Nome:");

        jTextNomeFilial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNomeFilialActionPerformed(evt);
            }
        });

        jLabel3.setText("CNPJ da empresa:");

        jLabel4.setText("Tipo (Nacional/Internacional):");

        jLabel5.setText("Rua:");

        jLabel6.setText("Bairro:");

        jLabel7.setText("Cidade:");

        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Fechar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(12, 12, 12)
                        .addComponent(jButton1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel7)
                        .addComponent(jLabel6)
                        .addComponent(jLabel5)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)
                        .addComponent(jTextNomeFilial)
                        .addComponent(jTextCNPJEmpresa)
                        .addComponent(jTextTipoFilial, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                        .addComponent(jTextRuaFilial)
                        .addComponent(jTextBairroFilial)
                        .addComponent(jTextCidadeFilial)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addComponent(jTextNomeFilial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addGap(12, 12, 12)
                .addComponent(jTextCNPJEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addGap(12, 12, 12)
                .addComponent(jTextTipoFilial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel5)
                .addGap(12, 12, 12)
                .addComponent(jTextRuaFilial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel6)
                .addGap(12, 12, 12)
                .addComponent(jTextBairroFilial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel7)
                .addGap(12, 12, 12)
                .addComponent(jTextCidadeFilial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextNomeFilialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNomeFilialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNomeFilialActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FilialDAO filialBanco = new FilialDAO();
        
        filial.setNome(jTextNomeFilial.getText());
        filial.setCNPJEmpresa(jTextCNPJEmpresa.getText());
        filial.setTipo(jTextTipoFilial.getText());
        filial.setRua(jTextRuaFilial.getText());
        filial.setBairro(jTextBairroFilial.getText());
        filial.setCidade(jTextCidadeFilial.getText());
        
        if(!editando) {
            filialBanco.adicionarFilial(filial);
        } else {
            filialBanco.atualizarFilial(filial);
        }
        
        jTextNomeFilial.setText("");
        jTextCNPJEmpresa.setText("");
        jTextTipoFilial.setText("");
        jTextRuaFilial.setText("");
        jTextBairroFilial.setText("");
        jTextCidadeFilial.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextBairroFilial;
    private javax.swing.JTextField jTextCNPJEmpresa;
    private javax.swing.JTextField jTextCidadeFilial;
    private javax.swing.JTextField jTextNomeFilial;
    private javax.swing.JTextField jTextRuaFilial;
    private javax.swing.JTextField jTextTipoFilial;
    // End of variables declaration//GEN-END:variables
}
