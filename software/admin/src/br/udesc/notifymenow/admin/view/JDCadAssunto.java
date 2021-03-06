/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.notifymenow.admin.view;

/**
 *
 * @author Wagner
 */
public class JDCadAssunto extends javax.swing.JDialog {

    /**
     * Creates new form FCadAssunto
     */
    public JDCadAssunto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDescricao = new javax.swing.JTable();
        tfAssunto = new javax.swing.JTextField();
        btAdicionar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panel1.setBackground(new java.awt.Color(204, 204, 255));

        tbDescricao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Descrição"
            }
        ));
        jScrollPane1.setViewportView(tbDescricao);

        tfAssunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfAssuntoActionPerformed(evt);
            }
        });

        btAdicionar.setText("Adicionar");
        btAdicionar.setPreferredSize(new java.awt.Dimension(79, 23));
        btAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarActionPerformed(evt);
            }
        });

        btEditar.setText("Editar");
        btEditar.setMaximumSize(new java.awt.Dimension(63, 23));
        btEditar.setMinimumSize(new java.awt.Dimension(63, 23));
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 18)); // NOI18N
        jLabel1.setText("  Assuntos de Pesquisa");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Assunto:");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(tfAssunto, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addGroup(panel1Layout.createSequentialGroup()
                            .addComponent(btAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfAssunto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btExcluir))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfAssuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfAssuntoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfAssuntoActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btEditarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btAdicionarActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btAdicionar;
    public javax.swing.JButton btEditar;
    public javax.swing.JButton btExcluir;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JScrollPane jScrollPane1;
    public java.awt.Panel panel1;
    public javax.swing.JTable tbDescricao;
    public javax.swing.JTextField tfAssunto;
    // End of variables declaration//GEN-END:variables
}
