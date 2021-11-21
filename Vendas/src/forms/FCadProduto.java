package forms;

import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import classes.Produto;
import servicos.ServicoBancoProduto;

import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class FCadProduto extends javax.swing.JFrame {

    public FCadProduto() {
        initComponents();
    }
    ServicoBancoProduto servicobancoproduto = new ServicoBancoProduto();

    @SuppressWarnings("unchecked")
    private void initComponents() {
    	
    	FCadProduto self = this;
    	
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        JLabel lblNome = new JLabel("Nome");
        
        JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
        
        textDescricao = new JTextField();
        textDescricao.setColumns(10);
        
        textNome = new JTextField();
        textNome.setColumns(10);
        
        JLabel lblPreo = new JLabel("Pre\u00E7o");
        
        textPreco = new JTextField();
        textPreco.setColumns(10);
        
        textQuantidade = new JTextField();
        textQuantidade.setColumns(10);
        
        JButton btnSalvar = new JButton();
        btnSalvar.setText("Salvar");
        
        JButton btnSair = new JButton();
        btnSair.setText("Sair");

        btnSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalvarMouseClicked(evt);
            }
        });
        
        
        btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	btnSairMouseClicked(evt);
            }

			private void btnSairMouseClicked(MouseEvent evt) {
				
				self.dispose();
				
			}
        });
        
        JLabel lblQuantidade = new JLabel("Quantidade");
        
        textQuantidade = new JTextField();
        textQuantidade.setColumns(10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(82)
        					.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(38)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(lblPreo)
        						.addComponent(lblDescrio)
        						.addComponent(lblNome)
        						.addComponent(lblQuantidade))
        					.addGap(18)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(textQuantidade, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)
        						.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        							.addComponent(textPreco, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
        							.addComponent(textDescricao)
        							.addComponent(textNome)))))
        			.addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(63, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNome)
        				.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblDescrio)
        				.addComponent(textDescricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblPreo)
        				.addComponent(textPreco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblQuantidade)
        				.addComponent(textQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(68)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnSalvar)
        				.addComponent(btnSair))
        			.addGap(94))
        );
        getContentPane().setLayout(layout);

        pack();
    }
        private void btnSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSalvarMouseClicked
            if (textNome.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Informe o nome do produto!");
                textNome.requestFocus();
                return;
            }
            
            if (textDescricao.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Informe a descricao do produto");
                textDescricao.requestFocus();
                return;
            }
            
            if (textPreco.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Informe o preco do produto");
                textPreco.requestFocus();
                return;
                
            }
            if (textQuantidade.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Informe a quantidade de produtos a serem registrados");
                textQuantidade.requestFocus();
                return;
            }
            if (textQuantidade.getText().equals("0")){
                JOptionPane.showMessageDialog(null, "Informe uma quantidade valida de produtos a serem registrados");
                textQuantidade.requestFocus();
                return;
            }
            
            Produto produto = new Produto (textNome.getText(), textDescricao.getText(), Double.parseDouble(textPreco.getText()), Integer.valueOf(textQuantidade.getText()));
            try {
                servicobancoproduto.insert(produto);
                JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
                textNome.setText("");
                textDescricao.setText("");
                textPreco.setText("");
                textQuantidade.setText("");
            } catch (SQLException ex) {
                Logger.getLogger(FCadCliente.class.getName()).log(Level.SEVERE, null, ex);
            }

    }// </editor-fold>//GEN-END:initComponents
        
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
            java.util.logging.Logger.getLogger(FCadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FCadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FCadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FCadProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FCadProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnSair;
    private JTextField textDescricao;
    private JTextField textNome;
    private JTextField textPreco;
    private JTextField textQuantidade;
}
