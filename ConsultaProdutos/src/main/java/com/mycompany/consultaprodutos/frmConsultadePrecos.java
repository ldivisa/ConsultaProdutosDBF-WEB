/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.consultaprodutos;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import static sun.jvm.hotspot.HelloWorld.e;

/**
 *
 * @author Luiz
 */
public class frmConsultadePrecos extends javax.swing.JFrame {
         public ConsultaProdutos consulta;
         public List<Produtos> resultado = new ArrayList<>();

         public frmConsultadePrecos() {
    

     consulta = new ConsultaProdutos();
     resultado = consulta.ConsultarProduto();
     initComponents();
    //atualizadados();
                    lbl_descricao_bd.setText("");
                    lbl_Estoque.setText("");
                    lbl_Estoque_Estoque_db.setText("");
                    lbl_Preco.setText("");
                    lbl_Preco.setText("");
                    lbl_descricao_bd.setText("");
                    lbl_erro.setText("");
                    tb_CodigoaPesquisar.setText("");
                    lbl_R$.setText("");
                    tb_CodigoaPesquisar.requestFocus();
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        tb_CodigoaPesquisar = new javax.swing.JTextField();
        lbl_descricao_bd = new javax.swing.JLabel();
        lbl_R$ = new javax.swing.JLabel();
        lbl_Preco = new javax.swing.JLabel();
        lbl_Estoque = new javax.swing.JLabel();
        lbl_Estoque_Estoque_db = new javax.swing.JLabel();
        lbl_erro = new javax.swing.JLabel();
        lbl_desciritvo1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pesquisa de produtos "+resultado.size()+" regsitros ");
        setAlwaysOnTop(true);
        setBackground(java.awt.Color.black);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(1024, 768));
        setPreferredSize(new java.awt.Dimension(1024, 768));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1024, 768));

        tb_CodigoaPesquisar.setBackground(new java.awt.Color(153, 153, 153));
        tb_CodigoaPesquisar.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        tb_CodigoaPesquisar.setForeground(new java.awt.Color(255, 255, 255));
        tb_CodigoaPesquisar.setAutoscrolls(false);
        tb_CodigoaPesquisar.setSelectionStart(5);
        tb_CodigoaPesquisar.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tb_CodigoaPesquisarPropertyChange(evt);
            }
        });
        tb_CodigoaPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tb_CodigoaPesquisarKeyReleased(evt);
            }
        });

        lbl_descricao_bd.setBackground(new java.awt.Color(102, 102, 0));
        lbl_descricao_bd.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        lbl_descricao_bd.setForeground(new java.awt.Color(255, 255, 0));
        lbl_descricao_bd.setText("Descrição do Produto");

        lbl_R$.setBackground(new java.awt.Color(0, 0, 0));
        lbl_R$.setFont(new java.awt.Font("Arial", 0, 190)); // NOI18N
        lbl_R$.setForeground(new java.awt.Color(255, 255, 0));
        lbl_R$.setText("$");

        lbl_Preco.setBackground(new java.awt.Color(0, 0, 204));
        lbl_Preco.setFont(new java.awt.Font("Arial", 0, 190)); // NOI18N
        lbl_Preco.setForeground(new java.awt.Color(255, 255, 0));
        lbl_Preco.setText("Preco");

        lbl_Estoque.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lbl_Estoque.setForeground(new java.awt.Color(255, 255, 51));
        lbl_Estoque.setText("Estoque:");

        lbl_Estoque_Estoque_db.setBackground(new java.awt.Color(0, 51, 51));
        lbl_Estoque_Estoque_db.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lbl_Estoque_Estoque_db.setForeground(new java.awt.Color(255, 255, 0));
        lbl_Estoque_Estoque_db.setText("jLabel6");

        lbl_erro.setBackground(new java.awt.Color(0, 51, 51));
        lbl_erro.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lbl_erro.setForeground(new java.awt.Color(255, 255, 0));
        lbl_erro.setText("Erro");

        lbl_desciritvo1.setBackground(new java.awt.Color(102, 102, 0));
        lbl_desciritvo1.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        lbl_desciritvo1.setForeground(new java.awt.Color(255, 255, 0));
        lbl_desciritvo1.setText("Insira o código a pesquisar:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(496, 496, 496)
                                .addComponent(tb_CodigoaPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbl_R$)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_Preco, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_erro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_descricao_bd, javax.swing.GroupLayout.PREFERRED_SIZE, 972, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 57, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_Estoque)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_Estoque_Estoque_db)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(60, 60, 60)
                    .addComponent(lbl_desciritvo1)
                    .addContainerGap(569, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(tb_CodigoaPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Preco, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_R$, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_descricao_bd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_erro, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Estoque)
                    .addComponent(lbl_Estoque_Estoque_db))
                .addContainerGap(117, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addComponent(lbl_desciritvo1)
                    .addContainerGap(504, Short.MAX_VALUE)))
        );

        tb_CodigoaPesquisar.getAccessibleContext().setAccessibleName("");

        jLayeredPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1055, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
        );

        jMenu1.setText("Conexão");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        jMenuItem1.setText("Atualizar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(800, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb_CodigoaPesquisarPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tb_CodigoaPesquisarPropertyChange
;     // TODO add your handling code here:
    }//GEN-LAST:event_tb_CodigoaPesquisarPropertyChange

    private void tb_CodigoaPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_CodigoaPesquisarKeyReleased
rodarConsulta();        // TODO add your handling code here:
    }//GEN-LAST:event_tb_CodigoaPesquisarKeyReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
atualizadados();        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(frmConsultadePrecos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmConsultadePrecos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmConsultadePrecos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmConsultadePrecos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmConsultadePrecos().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_Estoque;
    private javax.swing.JLabel lbl_Estoque_Estoque_db;
    private javax.swing.JLabel lbl_Preco;
    private javax.swing.JLabel lbl_R$;
    private javax.swing.JLabel lbl_desciritvo1;
    private javax.swing.JLabel lbl_descricao_bd;
    private javax.swing.JLabel lbl_erro;
    private javax.swing.JTextField tb_CodigoaPesquisar;
    // End of variables declaration//GEN-END:variables


public void rodarConsulta(){
    
tb_CodigoaPesquisar.requestFocus();    
      if (tb_CodigoaPesquisar.getText().length()<5 && tb_CodigoaPesquisar.getText().length()>0)
      {        
       
        //System.out.print("\nTemos "+resultado.size()+" registros");
        lbl_Estoque_Estoque_db.setText("");
        lbl_Preco.setText("");
        lbl_descricao_bd.setText("");
        int codigopesquisado;
       boolean sucesso = false;
       
        codigopesquisado = Integer.valueOf(tb_CodigoaPesquisar.getText());




        
        if (codigopesquisado>0){ 
                for (int i = 0 ; i<resultado.size();i++)
                {
                    if (Integer.valueOf(resultado.get(i).getCodigo())== codigopesquisado){
                        sucesso=true;
                        lbl_erro.setText("");
                        lbl_descricao_bd.setText("Produto:");
                        lbl_Estoque.setText("Estoque:");
                        lbl_Preco.setText("Preco:");
                        lbl_R$.setText("R$");
                        lbl_Estoque_Estoque_db.setText(String.valueOf(resultado.get(i).getEstoque()));
                        DecimalFormat df = new DecimalFormat("0.00");
                        lbl_Preco.setText(String.valueOf(df.format(resultado.get(i).getPreco())));
                        lbl_descricao_bd.setText(String.valueOf(resultado.get(i).getNome()));
                       
                    //System.out.print("\n "+String.valueOf(resultado.get(i).getNome()));
                                break;
                } 
                    
                }
                if (sucesso==false){
                        
                    lbl_erro.setText("Não encontrei produto com o código "+codigopesquisado);
                    limpatexto();
                }
                 
        
        
        
       
}
} else
      {
             lbl_erro.setText("Verifique o código digitado");   
             
             tb_CodigoaPesquisar.setText("");
             
     //impatexto();
      }         
}
public void limpatexto()
{
                    //_CodigoaPesquisar.setText(" ");
                    lbl_descricao_bd.setText(" ");
                    
                    lbl_Estoque.setText(" ");
                    lbl_Estoque_Estoque_db.setText(" ");
                    lbl_Preco.setText(" ");
                    lbl_descricao_bd.setText(" ");
                    lbl_Preco.setText(" ");
                    lbl_R$.setText(" ");
                    tb_CodigoaPesquisar.requestFocus();
}

public void atualizadados()
{
lbl_erro.setText("Buscando produtos...!");
    resultado = consulta.ConsultarProduto();
lbl_erro.setText("Registros atualizados!");
}
}