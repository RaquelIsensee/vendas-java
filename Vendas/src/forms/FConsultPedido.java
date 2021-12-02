/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import classes.Cliente;
import classes.Pedido;
import classes.Produto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import servicos.ServicoBancoPedido;
import servicos.ServicoBancoProduto;

/**
 *
 * @author matheus.aviz
 */
public class FConsultPedido extends javax.swing.JFrame {
    ServicoBancoPedido servicobancopedido = new ServicoBancoPedido();
    ServicoBancoProduto servicobancoproduto = new ServicoBancoProduto();
    /**
     * Creates new form FConsultPedido
     */
    public FConsultPedido() {
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

        jLabel1 = new javax.swing.JLabel();
        jPedido = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jProduto = new javax.swing.JComboBox<>();
        jQuantidade = new javax.swing.JTextField();
        jAlterar = new javax.swing.JButton();
        jDeletar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setText("Selecione o Pedido");

        jPedido.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jPedidoItemStateChanged(evt);
            }
        });
        jPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPedidoActionPerformed(evt);
            }
        });

        jLabel2.setText("Selecione o produto que gostaria de alterar:");

        jProduto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jProdutoItemStateChanged(evt);
            }
        });
        jProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jProdutoActionPerformed(evt);
            }
        });

        jQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jQuantidadeActionPerformed(evt);
            }
        });

        jAlterar.setText("Alterar");
        jAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAlterarMouseClicked(evt);
            }
        });

        jDeletar.setText("Deletar");

        jLabel3.setText("Quantidade");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDeletar)))
                .addContainerGap(73, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAlterar)
                    .addComponent(jDeletar))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPedidoActionPerformed

    private void jQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jQuantidadeActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        jProduto.setVisible(false);
        jQuantidade.setVisible(false);
        jAlterar.setVisible(false);
        jDeletar.setVisible(false);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        this.atualizarListaPedido();
    }//GEN-LAST:event_formWindowActivated

    private void jPedidoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jPedidoItemStateChanged
        if (jPedido.getSelectedIndex() > 0){
            Pedido pedido = (Pedido) jPedido.getSelectedItem();
            this.ativarCampos();
            this.atualizarListaProduto(pedido);
        }
        
        
    }//GEN-LAST:event_jPedidoItemStateChanged

    private void jProdutoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jProdutoItemStateChanged
        if (jProduto.getSelectedIndex() > 0){
            Produto produto = (Produto) jProduto.getSelectedItem();
            this.jQuantidade.setText(String.valueOf(produto.getQuantidade()));
        }
    }//GEN-LAST:event_jProdutoItemStateChanged

    private void jAlterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAlterarMouseClicked
        Produto produto = (Produto) jProduto.getSelectedItem();
        Pedido pedido = (Pedido) jPedido.getSelectedItem();
        produto.setQuantidade(Integer.parseInt(jQuantidade.getText()));
        try {
            servicobancoproduto.update_produto_pedido(produto, pedido);
        } catch (SQLException ex) {
            Logger.getLogger(FConsultPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jAlterarMouseClicked

    private void jProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jProdutoActionPerformed
    public void atualizarListaPedido(){
        try {
            if (jPedido.getItemCount() > 0){
               jPedido.removeAllItems();
        }
        
            ArrayList<Pedido> lista = servicobancopedido.getPedidoByLista();
        
         
          
            lista.forEach((u) -> {
                jPedido.addItem(u);
            }); 
            jPedido.setSelectedIndex(-1);


            } catch (SQLException ex) {
                Logger.getLogger(FConsultCliente.class.getName()).log(Level.SEVERE, null, ex);
            }        
    }
    

    public void atualizarListaProduto(Pedido pedido){
        try {
            if (jProduto.getItemCount() > 0){
               jProduto.removeAllItems();
        }
        
            ArrayList<Produto> lista = servicobancopedido.getProdutosPedidoByLista(pedido);
        
         
          
            lista.forEach((u) -> {
                jProduto.addItem(u);
            }); 
            jProduto.setSelectedIndex(-1);


            } catch (SQLException ex) {
                Logger.getLogger(FConsultCliente.class.getName()).log(Level.SEVERE, null, ex);
            }        
    }
    
    public void ativarCampos(){
        jProduto.setVisible(true);     
        jQuantidade.setVisible(true);
        jAlterar.setVisible(true);
        jDeletar.setVisible(true);
        jLabel2.setVisible(true);
        jLabel3.setVisible(true);

    }
    
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
            java.util.logging.Logger.getLogger(FConsultPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FConsultPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FConsultPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FConsultPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FConsultPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAlterar;
    private javax.swing.JButton jDeletar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<Pedido> jPedido;
    private javax.swing.JComboBox<Produto> jProduto;
    private javax.swing.JTextField jQuantidade;
    // End of variables declaration//GEN-END:variables
}
