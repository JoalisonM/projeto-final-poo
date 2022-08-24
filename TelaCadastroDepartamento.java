/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.gerenciamentoempresa;

/**
 *
 * @author joalison
 */
public class TelaCadastroDepartamento extends javax.swing.JInternalFrame {

    private boolean editando = false;
    private Departamento departamento = new Departamento();
    /**
     * Creates new form TelaCadastroDepartamento
     */
    public TelaCadastroDepartamento() {
        initComponents();
    }
    
    public TelaCadastroDepartamento(boolean editando, Departamento departamento) {
        initComponents();
        this.editando = editando;
        this.departamento = departamento;
        
        jTextNomeDepartamento.setText(departamento.getNome());
        jTextEmailDepartamento.setText(departamento.getEmail());
        jTextCodigoFilial.setText(String.valueOf(departamento.getCodigoFilial()));
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
        jTextNomeDepartamento = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextEmailDepartamento = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextCodigoFilial = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel1.setText("Departamentos da filial");

        jLabel2.setText("Nome:");

        jLabel3.setText("E-mail:");

        jLabel4.setText("Código filial:");

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
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)
                        .addComponent(jTextNomeDepartamento)
                        .addComponent(jTextEmailDepartamento)
                        .addComponent(jTextCodigoFilial, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)))
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
                .addComponent(jTextNomeDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel3)
                .addGap(12, 12, 12)
                .addComponent(jTextEmailDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addGap(12, 12, 12)
                .addComponent(jTextCodigoFilial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DepartamentoDAO departamentoBanco = new DepartamentoDAO();
        
        departamento.setNome(jTextNomeDepartamento.getText());
        departamento.setEmail(jTextEmailDepartamento.getText());
        departamento.setCodigoFilial(Integer.parseInt(jTextCodigoFilial.getText()));
        
        if(!editando) {
            departamentoBanco.adicionarDepartamento(departamento);
        } else {
            departamentoBanco.atualizarDepartamento(departamento);
        }
        
        jTextNomeDepartamento.setText("");
        jTextEmailDepartamento.setText("");
        jTextCodigoFilial.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextCodigoFilial;
    private javax.swing.JTextField jTextEmailDepartamento;
    private javax.swing.JTextField jTextNomeDepartamento;
    // End of variables declaration//GEN-END:variables
}
