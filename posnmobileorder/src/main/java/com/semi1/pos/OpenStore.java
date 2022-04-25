/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.semi1.pos;

import com.semi1.data.CalDAO;
import com.semi1.data.StoreService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author USER
 */
public class OpenStore extends javax.swing.JFrame implements ActionListener {
    private MainHome mh;
    private CalDAO calDao = new CalDAO();
    /**
     * Creates new form OpenStore
     */
    public OpenStore() {
        initComponents();
    }
    public OpenStore(MainHome mh) throws SQLException{
        this();
        this.mh = mh;
        init();
        addEvent();
    }
    private void init() throws SQLException{
        Date toDay = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd (E)");
	String today = sdf.format(toDay);
	System.out.println(today);
        tfDate.setText(today);
        tfName.setText(mh.getStname());
        tfPreDay.setText(calDao.getLastday(mh.getStno()));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    private void addEvent(){
        bt0.addActionListener(this);
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
        bt4.addActionListener(this);
        bt5.addActionListener(this);
        bt6.addActionListener(this);
        bt7.addActionListener(this);
        bt8.addActionListener(this);
        bt9.addActionListener(this);
        btBs.addActionListener(this);
        btC.addActionListener(this);
        btOpen.addActionListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        calcPl = new javax.swing.JPanel();
        bt7 = new javax.swing.JButton();
        bt8 = new javax.swing.JButton();
        bt9 = new javax.swing.JButton();
        bt4 = new javax.swing.JButton();
        bt5 = new javax.swing.JButton();
        bt6 = new javax.swing.JButton();
        bt1 = new javax.swing.JButton();
        bt2 = new javax.swing.JButton();
        bt3 = new javax.swing.JButton();
        btC = new javax.swing.JButton();
        btOpen = new javax.swing.JButton();
        btBs = new javax.swing.JButton();
        bt0 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfDate = new javax.swing.JTextField();
        tfName = new javax.swing.JTextField();
        tfPreDay = new javax.swing.JTextField();
        tfOpenMoney = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        calcPl.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        calcPl.setEnabled(false);
        calcPl.setFocusable(false);

        bt7.setBackground(new java.awt.Color(51, 153, 255));
        bt7.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        bt7.setForeground(new java.awt.Color(255, 255, 255));
        bt7.setText("7");
        bt7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt7.setFocusable(false);

        bt8.setBackground(new java.awt.Color(51, 153, 255));
        bt8.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        bt8.setForeground(new java.awt.Color(255, 255, 255));
        bt8.setText("8");
        bt8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt8.setFocusable(false);

        bt9.setBackground(new java.awt.Color(51, 153, 255));
        bt9.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        bt9.setForeground(new java.awt.Color(255, 255, 255));
        bt9.setText("9");
        bt9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt9.setFocusable(false);

        bt4.setBackground(new java.awt.Color(51, 153, 255));
        bt4.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        bt4.setForeground(new java.awt.Color(255, 255, 255));
        bt4.setText("4");
        bt4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt4.setFocusable(false);

        bt5.setBackground(new java.awt.Color(51, 153, 255));
        bt5.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        bt5.setForeground(new java.awt.Color(255, 255, 255));
        bt5.setText("5");
        bt5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt5.setFocusable(false);

        bt6.setBackground(new java.awt.Color(51, 153, 255));
        bt6.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        bt6.setForeground(new java.awt.Color(255, 255, 255));
        bt6.setText("6");
        bt6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt6.setFocusable(false);

        bt1.setBackground(new java.awt.Color(51, 153, 255));
        bt1.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        bt1.setForeground(new java.awt.Color(255, 255, 255));
        bt1.setText("1");
        bt1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt1.setFocusable(false);

        bt2.setBackground(new java.awt.Color(51, 153, 255));
        bt2.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        bt2.setForeground(new java.awt.Color(255, 255, 255));
        bt2.setText("2");
        bt2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt2.setFocusable(false);

        bt3.setBackground(new java.awt.Color(51, 153, 255));
        bt3.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        bt3.setForeground(new java.awt.Color(255, 255, 255));
        bt3.setText("3");
        bt3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt3.setFocusable(false);

        btC.setBackground(new java.awt.Color(51, 153, 255));
        btC.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        btC.setForeground(new java.awt.Color(255, 255, 255));
        btC.setText("C");
        btC.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btC.setFocusable(false);
        btC.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCActionPerformed(evt);
            }
        });

        btOpen.setBackground(new java.awt.Color(255, 153, 0));
        btOpen.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        btOpen.setForeground(new java.awt.Color(255, 255, 255));
        btOpen.setText("개점처리");
        btOpen.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btOpen.setFocusable(false);

        btBs.setBackground(new java.awt.Color(51, 153, 255));
        btBs.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        btBs.setForeground(new java.awt.Color(255, 255, 255));
        btBs.setText("←");
        btBs.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btBs.setFocusable(false);

        bt0.setBackground(new java.awt.Color(51, 153, 255));
        bt0.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        bt0.setForeground(new java.awt.Color(255, 255, 255));
        bt0.setText("0");
        bt0.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        bt0.setFocusable(false);

        javax.swing.GroupLayout calcPlLayout = new javax.swing.GroupLayout(calcPl);
        calcPl.setLayout(calcPlLayout);
        calcPlLayout.setHorizontalGroup(
            calcPlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calcPlLayout.createSequentialGroup()
                .addGroup(calcPlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(calcPlLayout.createSequentialGroup()
                        .addComponent(bt7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt9, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(calcPlLayout.createSequentialGroup()
                        .addComponent(bt4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(calcPlLayout.createSequentialGroup()
                        .addComponent(bt1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(calcPlLayout.createSequentialGroup()
                        .addComponent(btC, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt0, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btBs, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btOpen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        calcPlLayout.setVerticalGroup(
            calcPlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calcPlLayout.createSequentialGroup()
                .addGroup(calcPlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt9, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(calcPlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(calcPlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(calcPlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btC, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBs, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt0, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(btOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(calcPl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(calcPl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));

        jLabel2.setText("시스템 일자 :");

        jLabel3.setText("영업점 명 :");

        jLabel4.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        jLabel4.setText("마감 정산 현황");

        jLabel5.setText("처리일자 :");

        jLabel7.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        jLabel7.setText("개점처리");

        jLabel8.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 102, 0));
        jLabel8.setText("개점 준비금 :");

        tfDate.setEditable(false);
        tfDate.setBackground(new java.awt.Color(255, 255, 255));
        tfDate.setText("0000 - 00 - 00 (0)");
        tfDate.setFocusable(false);

        tfName.setEditable(false);
        tfName.setBackground(new java.awt.Color(255, 255, 255));
        tfName.setText("영업점 명");
        tfName.setFocusable(false);

        tfPreDay.setEditable(false);
        tfPreDay.setBackground(new java.awt.Color(255, 255, 255));
        tfPreDay.setText("0000 - 00 - 00 (0)");
        tfPreDay.setFocusable(false);

        tfOpenMoney.setEditable(false);
        tfOpenMoney.setBackground(new java.awt.Color(255, 255, 255));
        tfOpenMoney.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfOpenMoney.setText("0");
        tfOpenMoney.setFocusable(false);

        jLabel9.setText("원");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(tfPreDay, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                        .addComponent(tfName)
                        .addComponent(tfDate))
                    .addComponent(tfOpenMoney, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(tfDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfPreDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(tfOpenMoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        jPanel3.setBackground(new java.awt.Color(59, 78, 112));

        jLabel1.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("개점처리");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btCActionPerformed

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
            java.util.logging.Logger.getLogger(OpenStore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OpenStore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OpenStore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OpenStore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OpenStore().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt0;
    private javax.swing.JButton bt1;
    private javax.swing.JButton bt2;
    private javax.swing.JButton bt3;
    private javax.swing.JButton bt4;
    private javax.swing.JButton bt5;
    private javax.swing.JButton bt6;
    private javax.swing.JButton bt7;
    private javax.swing.JButton bt8;
    private javax.swing.JButton bt9;
    private javax.swing.JButton btBs;
    private javax.swing.JButton btC;
    private javax.swing.JButton btOpen;
    private javax.swing.JPanel calcPl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField tfDate;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfOpenMoney;
    private javax.swing.JTextField tfPreDay;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bt0 || e.getSource()==bt1 || e.getSource()==bt2 ||
			e.getSource()==bt3 || e.getSource()==bt4 || e.getSource()==bt5 ||
			e.getSource()==bt6 || e.getSource()==bt7 || e.getSource()==bt8 ||
			e.getSource()==bt9) {

		if(tfOpenMoney.getText().equals("0")) {
			tfOpenMoney.setText("");
		}
				
		String str1 = tfOpenMoney.getText();
		JButton obj = (JButton)e.getSource();
		String str2 = obj.getText();
		tfOpenMoney.setText(str1+str2);
	}
        if(e.getSource()==btC) {
            tfOpenMoney.setText("0");
        }
        if(e.getSource()==btBs) {
            String str = tfOpenMoney.getText();
            str= str.substring(0,str.length()-1);
            tfOpenMoney.setText(str);
            if(tfOpenMoney.getText().length()==0) {
                    tfOpenMoney.setText("0");
            }
        }
        if(e.getSource()==btOpen){
            String str = tfOpenMoney.getText();
            int startCash = Integer.parseInt(str);
            mh.setStartCash(startCash);
            mh.setStartOriginCash(startCash);
            mh.setOpenCheck(true);
            mh.iconOn();
            StoreService.openStore(mh.getStno(), mh);
            this.dispose();
        }
    }
}