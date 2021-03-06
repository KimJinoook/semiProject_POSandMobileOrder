/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.semi1.pos;

import com.semi1.data.OddtDAO;
import com.semi1.data.OddtDTO;
import com.semi1.data.ToDAO;
import com.semi1.data.ToDTO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class SalesControl extends javax.swing.JFrame implements ActionListener {
    MainHome mh;
    ToDAO toDao = new ToDAO();
    OddtDAO oddtDao = new OddtDAO();
    /**
     * Creates new form SalesControl
     */
    public SalesControl() {
        initComponents();
        SpinnerDateModel sdmy = new SpinnerDateModel();
        
        JSpinner.DateEditor editor1 = new JSpinner.DateEditor(spYear,"yyyy");
        spYear.setEditor(editor1);
        JSpinner.DateEditor editor2 = new JSpinner.DateEditor(spMon,"MM");
        spMon.setEditor(editor2);
        JSpinner.DateEditor editor3 = new JSpinner.DateEditor(spDay,"dd");
        spDay.setEditor(editor3);

    }
    public SalesControl(MainHome mh){
        this();
        this.mh = mh;
        addEvent();
        init();
    }
    public void init(){
        showAll();
        showDetail();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void addEvent(){
        rbDate.addActionListener(this);
        rbAllDate.addActionListener(this);
        btShowAll.addActionListener(this);
        btShowCard.addActionListener(this);
        btShowCash.addActionListener(this);
        jTable1.addMouseListener(new MouseEventHandler());
        btPayBack.addActionListener(this);
        btCalView.addActionListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Group = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btShowAll = new javax.swing.JButton();
        btShowCard = new javax.swing.JButton();
        btShowCash = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btPayBack = new javax.swing.JButton();
        btRePrint = new javax.swing.JButton();
        btCalView = new javax.swing.JButton();
        spYear = new javax.swing.JSpinner();
        spDay = new javax.swing.JSpinner();
        spMon = new javax.swing.JSpinner();
        rbDate = new javax.swing.JRadioButton();
        rbAllDate = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(59, 78, 112));

        jLabel1.setFont(new java.awt.Font("?????? ??????", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("?????? ??????");

        btShowAll.setBackground(new java.awt.Color(36, 109, 168));
        btShowAll.setFont(new java.awt.Font("?????? ??????", 1, 12)); // NOI18N
        btShowAll.setForeground(new java.awt.Color(255, 255, 255));
        btShowAll.setText("??????");
        btShowAll.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btShowCard.setBackground(new java.awt.Color(36, 109, 168));
        btShowCard.setFont(new java.awt.Font("?????? ??????", 1, 12)); // NOI18N
        btShowCard.setForeground(new java.awt.Color(255, 255, 255));
        btShowCard.setText("????????????");
        btShowCard.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btShowCash.setBackground(new java.awt.Color(36, 109, 168));
        btShowCash.setFont(new java.awt.Font("?????? ??????", 1, 12)); // NOI18N
        btShowCash.setForeground(new java.awt.Color(255, 255, 255));
        btShowCash.setText("??????");
        btShowCash.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btShowAll, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btShowCash, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btShowCard, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btShowCash, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(btShowCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btShowAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btPayBack.setBackground(new java.awt.Color(36, 146, 165));
        btPayBack.setFont(new java.awt.Font("?????? ??????", 1, 12)); // NOI18N
        btPayBack.setForeground(new java.awt.Color(255, 255, 255));
        btPayBack.setText("?????? ??????");

        btRePrint.setBackground(new java.awt.Color(36, 146, 165));
        btRePrint.setFont(new java.awt.Font("?????? ??????", 1, 12)); // NOI18N
        btRePrint.setForeground(new java.awt.Color(255, 255, 255));
        btRePrint.setText("?????????");

        btCalView.setBackground(new java.awt.Color(36, 146, 165));
        btCalView.setFont(new java.awt.Font("?????? ??????", 1, 12)); // NOI18N
        btCalView.setForeground(new java.awt.Color(255, 255, 255));
        btCalView.setText("????????????");

        spYear.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.YEAR));
        spYear.setEnabled(false);

        spDay.setModel(new javax.swing.SpinnerDateModel());
        spDay.setEnabled(false);

        spMon.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.MONTH));
        spMon.setEnabled(false);

        Group.add(rbDate);
        rbDate.setText("?????? ??????");

        Group.add(rbAllDate);
        rbAllDate.setSelected(true);
        rbAllDate.setText("?????? ??????");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btPayBack, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btRePrint, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCalView, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(spYear, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(rbAllDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbDate)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btRePrint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btCalView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbDate)
                    .addComponent(rbAllDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(btPayBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        pack();
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
            java.util.logging.Logger.getLogger(SalesControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalesControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalesControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalesControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalesControl().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Group;
    private javax.swing.JButton btCalView;
    private javax.swing.JButton btPayBack;
    private javax.swing.JButton btRePrint;
    private javax.swing.JButton btShowAll;
    private javax.swing.JButton btShowCard;
    private javax.swing.JButton btShowCash;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JRadioButton rbAllDate;
    private javax.swing.JRadioButton rbDate;
    private javax.swing.JSpinner spDay;
    private javax.swing.JSpinner spMon;
    private javax.swing.JSpinner spYear;
    // End of variables declaration//GEN-END:variables
    public void showAll(){
        try {
            List<ToDTO> list = new ArrayList<ToDTO>();
            
            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",Locale.ENGLISH);
            Date datey = sdf.parse(spYear.getValue().toString());
            Date datem = sdf.parse(spMon.getValue().toString());
            Date dated = sdf.parse(spDay.getValue().toString());
           
            SimpleDateFormat sdfy = new SimpleDateFormat("yyyy");
            SimpleDateFormat sdfm = new SimpleDateFormat("MM");
            SimpleDateFormat sdfd = new SimpleDateFormat("dd");
            
            String sdatey = sdfy.format(datey);
            String sdatem = sdfm.format(datem);
            String sdated = sdfd.format(dated);
            
            String date = sdatey+"-"+sdatem+"-"+sdated;
            System.out.println(date);
       
            if(rbAllDate.isSelected()){
                list = toDao.selectAllTo(mh.getStno());
            }else if(rbDate.isSelected()){
                list = toDao.selectAllTo(mh.getStno(), date);
            }
            
            
            String[][] data = new String[list.size()][4];
            
            for(int i = 0; i<data.length; i++) {
                ToDTO dto = list.get(i);
                data[i][0] = dto.getOd_no()+"";
                data[i][1] = dto.getOp_price()+"";
                data[i][2] = dto.getOd_date()+"";
                data[i][3] = dto.getOd_pay()+"";
            }
            String[] menucolNames = {"????????????","??????","?????????","????????????"};
            DefaultTableModel model = new DefaultTableModel(){
                public boolean isCellEditable(int row, int column){
                return false;
               } 
            };
            
            model.setDataVector(data, menucolNames);
            jTable1.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(SalesControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void showCard(){
        try {
            List<ToDTO> list = new ArrayList<ToDTO>();
            
            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",Locale.ENGLISH);
            Date datey = sdf.parse(spYear.getValue().toString());
            Date datem = sdf.parse(spMon.getValue().toString());
            Date dated = sdf.parse(spDay.getValue().toString());
           
            SimpleDateFormat sdfy = new SimpleDateFormat("yyyy");
            SimpleDateFormat sdfm = new SimpleDateFormat("MM");
            SimpleDateFormat sdfd = new SimpleDateFormat("dd");
            
            String sdatey = sdfy.format(datey);
            String sdatem = sdfm.format(datem);
            String sdated = sdfd.format(dated);
            
            String date = sdatey+"-"+sdatem+"-"+sdated;
            System.out.println(date);
       
            if(rbAllDate.isSelected()){
                list = toDao.selectCardTo(mh.getStno());
            }else if(rbDate.isSelected()){
                list = toDao.selectCardTo(mh.getStno(), date);
            }
            
            
            String[][] data = new String[list.size()][4];
            
            for(int i = 0; i<data.length; i++) {
                ToDTO dto = list.get(i);
                data[i][0] = dto.getOd_no()+"";
                data[i][1] = dto.getOp_price()+"";
                data[i][2] = dto.getOd_date()+"";
                data[i][3] = dto.getOd_pay()+"";
            }
            String[] menucolNames = {"????????????","??????","?????????","????????????"};
            DefaultTableModel model = new DefaultTableModel(){
                public boolean isCellEditable(int row, int column){
                return false;
               } 
            };
            
            model.setDataVector(data, menucolNames);
            jTable1.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(SalesControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void showCash(){
        try {
            List<ToDTO> list = new ArrayList<ToDTO>();
            
            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",Locale.ENGLISH);
            Date datey = sdf.parse(spYear.getValue().toString());
            Date datem = sdf.parse(spMon.getValue().toString());
            Date dated = sdf.parse(spDay.getValue().toString());
           
            SimpleDateFormat sdfy = new SimpleDateFormat("yyyy");
            SimpleDateFormat sdfm = new SimpleDateFormat("MM");
            SimpleDateFormat sdfd = new SimpleDateFormat("dd");
            
            String sdatey = sdfy.format(datey);
            String sdatem = sdfm.format(datem);
            String sdated = sdfd.format(dated);
            
            String date = sdatey+"-"+sdatem+"-"+sdated;
            System.out.println(date);
       
            if(rbAllDate.isSelected()){
                list = toDao.selectCashTo(mh.getStno());
            }else if(rbDate.isSelected()){
                list = toDao.selectCashTo(mh.getStno(), date);
            }
            
            
            String[][] data = new String[list.size()][4];
            
            for(int i = 0; i<data.length; i++) {
                ToDTO dto = list.get(i);
                data[i][0] = dto.getOd_no()+"";
                data[i][1] = dto.getOp_price()+"";
                data[i][2] = dto.getOd_date()+"";
                data[i][3] = dto.getOd_pay()+"";
            }
            String[] menucolNames = {"????????????","??????","?????????","????????????"};
            DefaultTableModel model = new DefaultTableModel(){
                public boolean isCellEditable(int row, int column){
                return false;
               } 
            };
            
            model.setDataVector(data, menucolNames);
            jTable1.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(SalesControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void showDetail(){
      
        String[][] data = new String[1][4];

        String[] addcolNames = {"????????????","?????????","??????","??????"};
        DefaultTableModel model = new DefaultTableModel();

        model.setDataVector(data, addcolNames);
        jTable2.setModel(model);
    }
    public void payBack(){
        try{
            if(jTable1.getSelectedRow()<0){
                return;
            }
            int row = jTable1.getSelectedRow();
            Object obj = jTable1.getValueAt(row, 1);
            String backPrice = obj.toString();
            int ibackPrice = Integer.parseInt(backPrice);

            obj = jTable1.getValueAt(row, 0);
            String sodno = obj.toString();
            int odno = Integer.parseInt(sodno);

            obj = jTable1.getValueAt(row, 3);
            String type = obj.toString();
            if(type.equals("Cash")){
                int bp = mh.getBackCash();
                bp += ibackPrice;
                mh.setBackCash(bp);
            }else{
                int cnt = mh.getCardBackCnt();
                cnt += ibackPrice;
                mh.setCardBackCnt(cnt);
            }
            int cnt = oddtDao.deleteOd(mh.getStno(), odno);   
            showAll();
            showDetail();
        }catch(Exception ex){
            
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==rbAllDate){
            spYear.setEnabled(false);
            spMon.setEnabled(false);
            spDay.setEnabled(false);
        }else if(e.getSource()==rbDate){
            spYear.setEnabled(true);
            spMon.setEnabled(true);
            spDay.setEnabled(true);
        }else if(e.getSource()==btShowAll){
                showAll();
        }else if(e.getSource()==btShowCard){
                showCard();
        }else if(e.getSource()==btShowCash){
            showCash();
        }else if(e.getSource()==btPayBack){
            payBack();
        }else if(e.getSource()==btCalView){
            CalView f = new CalView(mh);
            f.show();
        }
    }

    private class MouseEventHandler extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            try{
                if(e.getSource()==jTable1){
                    int row = jTable1.getSelectedRow();
                    Object obj = jTable1.getValueAt(row, 0);
                    String odno = obj.toString();
                    int iodno = Integer.parseInt(odno);
                    
                    List<OddtDTO> list = oddtDao.selectDetail(mh.getStno(), iodno);
                    String[][] data = new String[list.size()][4];
            
                    for(int i = 0; i<data.length; i++) {
                        OddtDTO dto = list.get(i);
                        data[i][0] = dto.getOd_number()+"";
                        data[i][1] = dto.getOddt_name()+"";
                        data[i][2] = dto.getOddt_cnt()+"";
                        data[i][3] = dto.getOddt_price()+"";
                    }

                    String[] addcolNames = {"????????????","?????????","??????","??????"};
                    DefaultTableModel model = new DefaultTableModel();

                    model.setDataVector(data, addcolNames);
                    jTable2.setModel(model);
                }
                
            }catch (SQLException ex) {
                Logger.getLogger(SalesControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
}
