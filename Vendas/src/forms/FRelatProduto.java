package forms;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.GroupLayout;
import javax.swing.JTable;
import javax.swing.JButton;

import servicos.ServicoBancoProduto;
import servicos.SimpleTableModel;

public class FRelatProduto extends javax.swing.JFrame {

    public FRelatProduto() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        JScrollPane jScrollPane1 = new JScrollPane();
        
        JButton jButton1 = new JButton();
        		
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {},
                    {},
                    {},
                    {},
                    {},
                    {},
                    {},
                    {}
                },
                new String [] {

                }
            ));
            table.getTableHeader().setReorderingAllowed(false);
            jScrollPane1.setViewportView(table);

            jButton1.setText("Sair");
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addContainerGap(20, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 584, GroupLayout.PREFERRED_SIZE))
        			.addGap(20))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(20, Short.MAX_VALUE)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE)
        			.addGap(10)
        			.addComponent(jButton1)
        			.addGap(20))
        );
        getContentPane().setLayout(layout);

        pack();
    }
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try {
            this.carregarTabela();
        } catch (SQLException ex) {
            Logger.getLogger(FRelatCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void jButton1ActionPerformed(ActionEvent evt) {
    		self.dispose();
	}
    
    public void carregarTabela() throws SQLException{
        
    	ServicoBancoProduto srv = new ServicoBancoProduto();
        ArrayList dados = srv.getProdutoByListaString();
        String [] colunas = new String[] {"Codigo Produto",
                                          "Nome",
                                          "Descricao",
                                          "Preco",
                                          "Quantidade"
                                         };
       
        SimpleTableModel modelo = new SimpleTableModel(dados, colunas); 
        table.setModel(modelo);
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
            java.util.logging.Logger.getLogger(FRelatProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FRelatProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FRelatProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FRelatProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FRelatProduto().setVisible(true);
            }
        });

    }
	FRelatProduto self = this;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
}
