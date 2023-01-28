
package Srb;
import javax.swing.JOptionPane;

import java.sql.ResultSet;

public class addtransaction extends javax.swing.JFrame {

    


    public addtransaction() {
        initComponents();
        getEntries();
        display_token_name();
        currentPrice();
        Datepick.setSelectableDateRange(null,new java.util.Date());
   
        
    }
    void currentPrice(){
        String token = (String)Token.getSelectedItem();
        
        ApiReq req = new ApiReq();
        req.currentPrice(token);
        String s=String.valueOf(req.price);  
        currentprice.setText(s+" ₹");
    
    }
    
    void display_token_name(){
        try{
            Token.removeAllItems();
            ResultSet rs =Conn.st.executeQuery("select * from Token_names ORDER BY FIELD(Tokens, \"tether\") DESC");
            while(rs.next()){
                Token.addItem(rs.getString("Tokens"));
        }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
    }
    void holdings(){
        try{
        ResultSet rb=Conn.st2.executeQuery("Select * from Sourabh");
     
        
              
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }
        
    
    void getEntries(){
        
        try{
             javax.swing.table.DefaultTableModel dtm=
                     (javax.swing.table.DefaultTableModel)table.getModel();
             
             int rc=dtm.getRowCount();
             while (rc--!=0){
                 dtm.removeRow(0);
             }
      
            ResultSet rs=Conn.st.executeQuery("Select * from Sourabh");
           int srno =0;
          while(rs.next()){
            String token =rs.getString("token_name");
            Float bprice= rs.getFloat("b_price");
            Float bqty = rs.getFloat("b_qty");
            Float sprice= rs.getFloat("S_price");
            Float sqty = rs.getFloat("s_qty");
            
               
           Object o[]={++srno,token, bprice,bqty};
           dtm.addRow(o);
          
           
           }
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        buttonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Add = new javax.swing.JButton();
        Token = new javax.swing.JComboBox<>();
        Qty_input = new javax.swing.JTextField();
        b_price = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        price_lable = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Datepick = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        currentprice = new javax.swing.JLabel();
        buy_btn = new javax.swing.JRadioButton();
        btn_sell = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        Delete = new javax.swing.JButton();

        jScrollPane2.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Main");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Apple Chancery", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add Transaction");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jLabel3.setText("Token Name");

        Add.setText("Add Transaction");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        Token.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TokenActionPerformed(evt);
            }
        });

        Qty_input.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Qty_inputKeyTyped(evt);
            }
        });

        b_price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                b_priceKeyTyped(evt);
            }
        });

        jLabel2.setText("Quantity :");

        price_lable.setText("Buying price :");

        jButton1.setText("Add new Token");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setText("Date:");

        buttonGroup.add(buy_btn);
        buy_btn.setText("Buy");
        buy_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buy_btnActionPerformed(evt);
            }
        });

        buttonGroup.add(btn_sell);
        btn_sell.setText("Sell");
        btn_sell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sellActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Datepick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Token, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(currentprice, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(price_lable)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buy_btn, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btn_sell, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Qty_input, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(b_price, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(Add)))
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(currentprice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(Token, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Datepick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Qty_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(price_lable)
                            .addComponent(b_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(Add))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(buy_btn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_sell)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Token name", "Price", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);

        Delete.setText("Delete Transaction");
        Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Delete, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Delete, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed

       int r =JOptionPane.showConfirmDialog(null,"Do you want to Delete", 
               "Confirmation",JOptionPane.YES_NO_OPTION);
       if(r==JOptionPane.YES_OPTION){
        int ri= table.getSelectedRow();
        String token= (String)table.getValueAt(ri,1);
        Float price = (Float)table.getValueAt(ri, 2);
        Float qty = (Float)table.getValueAt(ri, 3);
        try{
         
           Conn.st.executeUpdate
        ("Delete from Sourabh where b_price ="+price+" AND b_qty ="+qty+ "and token_name='"+token+"'");
            JOptionPane.showMessageDialog(null,"Transaction Deleted");
            display_token_name();
                    getEntries();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,ex);
        }
       } 
        
    }//GEN-LAST:event_DeleteActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
         currentPrice();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Add_token().setVisible(true);
        display_token_name();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void b_priceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_b_priceKeyTyped

        // TODO add your handling code here:
    }//GEN-LAST:event_b_priceKeyTyped

    private void Qty_inputKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Qty_inputKeyTyped

    }//GEN-LAST:event_Qty_inputKeyTyped

    private void TokenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TokenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TokenActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        try{
            java.util.Date dt=Datepick.getDate();
            String qty= Qty_input.getText();
            String pri=b_price.getText();
            String token = (String)Token.getSelectedItem();

            Double qt=Double.parseDouble(qty);
            Double price=Double.parseDouble(pri);

            if(dt == null){
                String date = "now()";
                if(!qty.equals("") && !token.equals("")){
                    if(buy_btn.isSelected()){
                        Conn.st.executeUpdate(
                        "insert into Sourabh values("+date+",'"+token+"',"+qt+","+price+",0,0)"
                    );
                    JOptionPane.showMessageDialog(null,"Transaction added successfully");
                    display_token_name();
                    getEntries();
                        
                    }else{
                    Conn.st.executeUpdate(
                        "insert into Sourabh values("+date+",'"+token+"',0,0,"+qt+","+price+")"
                    );
                    JOptionPane.showMessageDialog(null,"Transaction added successfully");
                    display_token_name();
                    getEntries();
                    }
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Please enter values");
                }

            }else{
                java.sql.Date date=new java.sql.Date(dt.getTime());
                if(!qty.equals("") && !token.equals("")){
                    if(buy_btn.isSelected()){

                    Conn.st.executeUpdate(
                        "insert into Sourabh values('"+date+"','"+token+"',"+qt+","+price+",0,0)");
                    JOptionPane.showMessageDialog(null,"Buying Transaction added successfully");
                    display_token_name();
                    getEntries();
                    }else
                    {
                    Conn.st.executeUpdate(
                        "insert into Sourabh values('"+date+"','"+token+"',0,0,"+qt+","+price+")"
                    );
                    JOptionPane.showMessageDialog(null,"Selling Transaction added successfully");
                    display_token_name();
                    getEntries();
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Please enter values");
                }
            }

        }
        catch(Exception ex ){
            JOptionPane.showMessageDialog(null,ex);
        }

    }//GEN-LAST:event_AddActionPerformed

    private void btn_sellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sellActionPerformed
        // TODO add your handling code here:
        price_lable.setText("Selling price");
    }//GEN-LAST:event_btn_sellActionPerformed

    private void buy_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buy_btnActionPerformed

        // TODO add your handling code here:
        price_lable.setText("Buying price");
    }//GEN-LAST:event_buy_btnActionPerformed

   
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
            java.util.logging.Logger.getLogger(addtransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addtransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addtransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addtransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            new addtransaction().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private com.toedter.calendar.JDateChooser Datepick;
    private javax.swing.JButton Delete;
    private javax.swing.JTextField Qty_input;
    private javax.swing.JComboBox<String> Token;
    private javax.swing.JTextField b_price;
    private javax.swing.JRadioButton btn_sell;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JRadioButton buy_btn;
    private javax.swing.JLabel currentprice;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel price_lable;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
