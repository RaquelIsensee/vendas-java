/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;
import javax.swing.JComboBox;
import classes.Cliente;
import classes.Produto;
import servicos.ServicoBancoProduto;

import javax.swing.GroupLayout.Alignment;

import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class FConsultProduto extends javax.swing.JFrame {


	ServicoBancoProduto servicobancoproduto = new ServicoBancoProduto();
    public FConsultProduto() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	
    	FConsultProduto self = this;

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        jProduto = new JComboBox<Produto>();
        
        jProduto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
            	jProdutoItemStateChanged(evt);
            }
        });
        
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        
        JLabel lblNome = new JLabel("Nome");
        
        textNome = new JTextField();
        textNome.setColumns(10);
        
        JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
        
        textDescricao = new JTextField();
        textDescricao.setColumns(10);
        
        JLabel lblPreo = new JLabel("Pre\u00E7o");
        
        textPreco = new JTextField();
        textPreco.setColumns(10);
        
        JLabel lblQuantidade = new JLabel("Quantidade");
        
        textQuantidade = new JTextField();
        textQuantidade.setColumns(10);
        
        JButton btnAlterar = new JButton();
        btnAlterar.setText("Alterar");
        btnAlterar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAlterarMouseClicked(evt);
            }
        });
        
        JButton btnSair = new JButton();
        btnSair.setText("Sair");
        btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	btnSairMouseClicked(evt);
            }

			private void btnSairMouseClicked(MouseEvent evt) {
				
				self.dispose();
				
			}
        });
                
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jProduto, GroupLayout.PREFERRED_SIZE, 380, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(63)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(layout.createParallelGroup(Alignment.LEADING)
        							.addGroup(layout.createSequentialGroup()
        								.addGap(29)
        								.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
        								.addGap(18)
        								.addComponent(textNome, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
        							.addGroup(layout.createSequentialGroup()
        								.addGap(10)
        								.addComponent(lblDescrio)
        								.addGap(18)
        								.addComponent(textDescricao, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
        							.addGroup(layout.createSequentialGroup()
        								.addGap(29)
        								.addComponent(lblPreo, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
        								.addGap(18)
        								.addComponent(textPreco, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE))
        							.addGroup(layout.createSequentialGroup()
        								.addComponent(lblQuantidade, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
        								.addGap(18)
        								.addComponent(textQuantidade, GroupLayout.PREFERRED_SIZE, 198, GroupLayout.PREFERRED_SIZE)))
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
        							.addGap(88)
        							.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)))))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jProduto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(42)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(3)
        					.addComponent(lblNome))
        				.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(11)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(3)
        					.addComponent(lblDescrio))
        				.addComponent(textDescricao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(11)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(3)
        					.addComponent(lblPreo))
        				.addComponent(textPreco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(11)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(3)
        					.addComponent(lblQuantidade))
        				.addComponent(textQuantidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(37)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(btnAlterar)
        				.addComponent(btnSair))
        			.addContainerGap(54, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }
    
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        this.atualizarListaProduto();
    }//GEN-LAST:event_formWindowActivated
    
    private void atualizarListaProduto(){
        try {
        	
            if (jProduto.getItemCount() > 0){
            	jProduto.removeAllItems();
            }
   
            ArrayList<Produto> lista = servicobancoproduto.getProdutoByLista();
          
            for (Produto itemDaLista:lista){
                jProduto.addItem(itemDaLista);
            }      

            textNome.setText("");
            textDescricao.setText("");
            textPreco.setText("");
            textQuantidade.setText("");
            jProduto.setSelectedIndex(-1);
            
        } catch (SQLException ex) {
            Logger.getLogger(FConsultCliente.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    private void jProdutoItemStateChanged(java.awt.event.ItemEvent evt) {
        if (jProduto.getItemCount() <= 0){
            return;
        }
        
        if (jProduto.getSelectedIndex() < 0){
            return;
        } 
        
        Produto produto = (Produto) jProduto.getSelectedItem();
        textNome.setText(produto.getNome());
        textDescricao.setText(produto.getDescricao());
        textPreco.setText(String.valueOf(produto.getPreco()));
        textQuantidade.setText(String.valueOf(produto.getQuantidade()));        
    }
    private void btnAlterarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAlterarMouseClicked
        if(jProduto.getSelectedIndex() >= 0){
            Produto produto = (Produto) jProduto.getSelectedItem();
            produto.setNome(textNome.getText());
            produto.setDescricao(textDescricao.getText());
            produto.setPreco(Double.parseDouble(textPreco.getText()));
            produto.setQuantidade(Integer.valueOf(textQuantidade.getText()));            
            try {
            	servicobancoproduto.update(produto);
            } catch (SQLException ex) {
                Logger.getLogger(FConsultProduto.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso");
            textNome.setText("");
            textDescricao.setText("");
            textPreco.setText("");
            textQuantidade.setText("");
            jProduto.setSelectedIndex(-1);
        }
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FConsultProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FConsultProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FConsultProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FConsultProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FConsultProduto().setVisible(true);
            }
        });
    }
    private javax.swing.JComboBox<Produto> jProduto;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnSair;
	private JTextField textNome;
	private JTextField textDescricao;
	private JTextField textPreco;
	private JTextField textQuantidade;

}
