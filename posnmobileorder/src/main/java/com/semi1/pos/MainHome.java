/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.semi1.pos;

import com.semi1.data.MemberDAO;
import com.semi1.data.MemberDTO;
import com.semi1.data.OddtDAO;
import com.semi1.data.OddtDTO;
import com.semi1.data.ProductDAO;
import com.semi1.data.ProductDTO;
import com.semi1.data.StoreDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author EZEN
 */
public class MainHome extends javax.swing.JFrame {
    private StoreDAO storeDao = new StoreDAO();
    private ProductDAO productDao = new ProductDAO();
    private OddtDAO oddtDao = new OddtDAO();
    private MemberDAO memberDao = new MemberDAO();
    private MemberDTO memberDto = new MemberDTO();
    private int stno;
    private String stname;
    private int startCash;
    private int startOriginCash;
    private int cardCnt;
    private int cardBackCnt;
    private int backCash;
    private boolean openCheck = false;
    private MainHome mh = this; 
    private boolean calbool = false;
    private char calop = 'a';
    private HashMap<Integer,String[]> map = new HashMap<Integer,String[]>();
    private int mouseCnt = 0;

    public int getCardCnt() {
        return cardCnt;
    }

    public void setCardCnt(int cardCnt) {
        this.cardCnt = cardCnt;
    }
    
    

    public int getStartOriginCash() {
        return startOriginCash;
    }

    public void setStartOriginCash(int startOriginCash) {
        this.startOriginCash = startOriginCash;
    }
    
    public int getCardBackCnt() {
        return cardBackCnt;
    }

    public void setCardBackCnt(int cardBackCnt) {
        this.cardBackCnt = cardBackCnt;
    }

    public int getBackCash() {
        return backCash;
    }

    public void setBackCash(int backCash) {
        this.backCash = backCash;
    }


    
    public int getStno() {
        return stno;
    }

    public void setStno(int stno) {
        this.stno = stno;
    }

    public String getStname() {
        return stname;
    }

    public void setStname(String stname) {
        this.stname = stname;
    }

    public int getStartCash() {
        return startCash;
    }

    public void setStartCash(int startCash) {
        this.startCash = startCash;
    }

    public boolean isOpenCheck() {
        return openCheck;
    }
    public String getCuTel(){
        return tfCuTel.getText();
    }
    public String getTmoney(){
        return tfTmoney.getText();
    }
    public HashMap getMap(){
        return map;
    }
    public MemberDTO getMemberDto(){
        return memberDto;
    }

    /**
     * Creates new form MainHome
     */
    public void setOpenCheck(boolean openCheck) {
        this.openCheck = openCheck;
    }

    public MainHome() {
        initComponents();
        addEvent();
    }
    public MainHome(int stno, String stname){
        this();
        this.stno = stno;
        this.stname = stname;
        init();
    }
    private void addEvent(){
        btOnoff.addActionListener(new OnoffEvent());
        lbOnoff.addMouseListener(new OnoffEvent());
        
        bt0.addActionListener(new CalculEvent());
        btC.addActionListener(new CalculEvent());
        bt1.addActionListener(new CalculEvent());
        bt2.addActionListener(new CalculEvent());
        bt3.addActionListener(new CalculEvent());
        bt4.addActionListener(new CalculEvent());
        bt5.addActionListener(new CalculEvent());
        bt6.addActionListener(new CalculEvent());
        bt7.addActionListener(new CalculEvent());
        bt8.addActionListener(new CalculEvent());
        bt9.addActionListener(new CalculEvent());
        btDiv.addActionListener(new CalculEvent());
        btMul.addActionListener(new CalculEvent());
        btPlu.addActionListener(new CalculEvent());
        btRst.addActionListener(new CalculEvent());
        btMin.addActionListener(new CalculEvent());
        
        btCoffe.addActionListener(new OrderEvent());
        btNoncoffee.addActionListener(new OrderEvent());
        btSmoo.addActionListener(new OrderEvent());
        btJuice.addActionListener(new OrderEvent());
        btTea.addActionListener(new OrderEvent());
        btSide.addActionListener(new OrderEvent());
        tbMenu.addMouseListener(new OrderEvent());
        btPlu1.addActionListener(new OrderEvent());
        btMin1.addActionListener(new OrderEvent());
        btOneCancel.addActionListener(new OrderEvent());
        btAllCancel.addActionListener(new OrderEvent());
        btCoupon.addActionListener(new OrderEvent());
        btStamp.addActionListener(new OrderEvent());
        btPayCash.addActionListener(new OrderEvent());
        btPayCard.addActionListener(new OrderEvent());
        btComp.addActionListener(new OrderEvent());
        
        btSellmenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==btSellmenu){
                    SalesControl f = new SalesControl(mh);
                    f.show();
                }
            }
        });
        
    }
    private void init(){
        Date today = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd (E)");
	String stoday = sdf.format(today);
        lbDate.setText(stoday);
        lbStorename.setText(stname);
        showByCateno(1);
        showOding();
        showAdding();
        lbOnoff.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\off.png"));
        jLabel7.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\home.png"));
        jLabel9.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\clock.png")); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\logo3.png"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addedMenuPl = new javax.swing.JScrollPane();
        tbAddmenu = new javax.swing.JTable();
        payPl = new javax.swing.JPanel();
        btPlu1 = new javax.swing.JButton();
        btMin1 = new javax.swing.JButton();
        btCoupon = new javax.swing.JButton();
        btStamp = new javax.swing.JButton();
        btOneCancel = new javax.swing.JButton();
        btAllCancel = new javax.swing.JButton();
        calcPl = new javax.swing.JPanel();
        tfCal1 = new javax.swing.JTextField();
        tfCal2 = new javax.swing.JTextField();
        bt7 = new javax.swing.JButton();
        bt8 = new javax.swing.JButton();
        bt9 = new javax.swing.JButton();
        btDiv = new javax.swing.JButton();
        bt4 = new javax.swing.JButton();
        bt5 = new javax.swing.JButton();
        bt6 = new javax.swing.JButton();
        btMul = new javax.swing.JButton();
        bt1 = new javax.swing.JButton();
        bt2 = new javax.swing.JButton();
        bt3 = new javax.swing.JButton();
        btMin = new javax.swing.JButton();
        btC = new javax.swing.JButton();
        bt0 = new javax.swing.JButton();
        btRst = new javax.swing.JButton();
        btPlu = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfCuName = new javax.swing.JTextField();
        tfCuTel = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btPayCash = new javax.swing.JButton();
        tfOriginPrice = new javax.swing.JTextField();
        tfDisacc = new javax.swing.JTextField();
        tfTmoney = new javax.swing.JTextField();
        btPayCard = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btOnoff = new javax.swing.JButton();
        lbOnoff = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbStorename = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbDate = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btSide = new javax.swing.JButton();
        btCoffe = new javax.swing.JButton();
        btNoncoffee = new javax.swing.JButton();
        btSmoo = new javax.swing.JButton();
        btJuice = new javax.swing.JButton();
        btTea = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMenu = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btComp = new javax.swing.JButton();
        btSellmenu = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbOding = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addedMenuPl.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tbAddmenu.setModel(new javax.swing.table.DefaultTableModel(
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
        tbAddmenu.setRowHeight(30);
        addedMenuPl.setViewportView(tbAddmenu);

        payPl.setBackground(new java.awt.Color(59, 78, 112));
        payPl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        payPl.setFocusable(false);

        btPlu1.setBackground(new java.awt.Color(59, 78, 112));
        btPlu1.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        btPlu1.setForeground(new java.awt.Color(255, 255, 255));
        btPlu1.setText("+1");
        btPlu1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btPlu1.setFocusable(false);
        btPlu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPlu1ActionPerformed(evt);
            }
        });

        btMin1.setBackground(new java.awt.Color(59, 78, 112));
        btMin1.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        btMin1.setForeground(new java.awt.Color(255, 255, 255));
        btMin1.setText("-1");
        btMin1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btMin1.setFocusable(false);

        btCoupon.setBackground(new java.awt.Color(59, 78, 112));
        btCoupon.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        btCoupon.setForeground(new java.awt.Color(255, 255, 255));
        btCoupon.setText("할인");
        btCoupon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btCoupon.setFocusable(false);

        btStamp.setBackground(new java.awt.Color(59, 78, 112));
        btStamp.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        btStamp.setForeground(new java.awt.Color(255, 255, 255));
        btStamp.setText("적립");
        btStamp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btStamp.setFocusable(false);

        btOneCancel.setBackground(new java.awt.Color(59, 78, 112));
        btOneCancel.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        btOneCancel.setForeground(new java.awt.Color(255, 255, 255));
        btOneCancel.setText("선택취소");
        btOneCancel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btOneCancel.setFocusable(false);
        btOneCancel.setMargin(new java.awt.Insets(2, 2, 2, 2));

        btAllCancel.setBackground(new java.awt.Color(59, 78, 112));
        btAllCancel.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        btAllCancel.setForeground(new java.awt.Color(255, 255, 255));
        btAllCancel.setText("전체취소");
        btAllCancel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btAllCancel.setFocusable(false);
        btAllCancel.setMargin(new java.awt.Insets(2, 2, 2, 2));

        calcPl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        calcPl.setEnabled(false);
        calcPl.setFocusable(false);

        tfCal1.setEditable(false);
        tfCal1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfCal1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfCal1.setFocusable(false);

        tfCal2.setEditable(false);
        tfCal2.setFont(new java.awt.Font("맑은 고딕", 0, 18)); // NOI18N
        tfCal2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfCal2.setText("0");
        tfCal2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfCal2.setFocusable(false);

        bt7.setBackground(new java.awt.Color(254, 254, 254));
        bt7.setText("7");
        bt7.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bt7.setFocusable(false);

        bt8.setBackground(new java.awt.Color(254, 254, 254));
        bt8.setText("8");
        bt8.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bt8.setFocusable(false);

        bt9.setBackground(new java.awt.Color(254, 254, 254));
        bt9.setText("9");
        bt9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bt9.setFocusable(false);

        btDiv.setBackground(new java.awt.Color(204, 204, 204));
        btDiv.setText("/");
        btDiv.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btDiv.setFocusable(false);

        bt4.setBackground(new java.awt.Color(254, 254, 254));
        bt4.setText("4");
        bt4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bt4.setFocusable(false);

        bt5.setBackground(new java.awt.Color(254, 254, 254));
        bt5.setText("5");
        bt5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bt5.setFocusable(false);

        bt6.setBackground(new java.awt.Color(254, 254, 254));
        bt6.setText("6");
        bt6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bt6.setFocusable(false);

        btMul.setBackground(new java.awt.Color(204, 204, 204));
        btMul.setText("X");
        btMul.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btMul.setFocusable(false);

        bt1.setBackground(new java.awt.Color(254, 254, 254));
        bt1.setText("1");
        bt1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bt1.setFocusable(false);

        bt2.setBackground(new java.awt.Color(254, 254, 254));
        bt2.setText("2");
        bt2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bt2.setFocusable(false);

        bt3.setBackground(new java.awt.Color(254, 254, 254));
        bt3.setText("3");
        bt3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bt3.setFocusable(false);

        btMin.setBackground(new java.awt.Color(204, 204, 204));
        btMin.setText("-");
        btMin.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btMin.setFocusable(false);

        btC.setBackground(new java.awt.Color(254, 254, 254));
        btC.setText("C");
        btC.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btC.setFocusable(false);
        btC.setMargin(new java.awt.Insets(2, 2, 2, 2));

        bt0.setBackground(new java.awt.Color(254, 254, 254));
        bt0.setText("0");
        bt0.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        bt0.setFocusable(false);

        btRst.setBackground(new java.awt.Color(153, 153, 153));
        btRst.setText("=");
        btRst.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btRst.setFocusable(false);

        btPlu.setBackground(new java.awt.Color(204, 204, 204));
        btPlu.setText("+");
        btPlu.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btPlu.setFocusable(false);

        javax.swing.GroupLayout calcPlLayout = new javax.swing.GroupLayout(calcPl);
        calcPl.setLayout(calcPlLayout);
        calcPlLayout.setHorizontalGroup(
            calcPlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tfCal1)
            .addComponent(tfCal2)
            .addGroup(calcPlLayout.createSequentialGroup()
                .addComponent(bt7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt8, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt9, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btDiv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(calcPlLayout.createSequentialGroup()
                .addComponent(bt4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btMul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(calcPlLayout.createSequentialGroup()
                .addComponent(bt1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btMin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(calcPlLayout.createSequentialGroup()
                .addComponent(btC, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bt0, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btRst, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btPlu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        calcPlLayout.setVerticalGroup(
            calcPlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calcPlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfCal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(calcPlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt9, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDiv, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(calcPlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btMul, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(calcPlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btMin, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(calcPlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btC, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt0, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRst, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPlu, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setFocusable(false);

        jSeparator1.setForeground(new java.awt.Color(57, 98, 112));

        jLabel1.setFont(new java.awt.Font("맑은 고딕", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(57, 98, 112));
        jLabel1.setText("고객명");
        jLabel1.setFocusable(false);

        jLabel2.setFont(new java.awt.Font("맑은 고딕", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(57, 98, 112));
        jLabel2.setText("TEL");
        jLabel2.setFocusable(false);

        tfCuName.setEditable(false);
        tfCuName.setBackground(new java.awt.Color(255, 255, 255));
        tfCuName.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        tfCuName.setForeground(new java.awt.Color(57, 98, 112));
        tfCuName.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfCuName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfCuName.setFocusable(false);

        tfCuTel.setEditable(false);
        tfCuTel.setBackground(new java.awt.Color(255, 255, 255));
        tfCuTel.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        tfCuTel.setForeground(new java.awt.Color(57, 98, 112));
        tfCuTel.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfCuTel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfCuTel.setFocusable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCuName))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCuTel)))
                .addContainerGap())
            .addComponent(jSeparator1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfCuName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfCuTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9))
        );

        jLabel3.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("실판매금액");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel3.setFocusable(false);

        jLabel4.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("받을 금액");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel4.setFocusable(false);

        jLabel5.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("총할인금액");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel5.setFocusable(false);

        btPayCash.setBackground(new java.awt.Color(59, 78, 112));
        btPayCash.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        btPayCash.setForeground(new java.awt.Color(255, 255, 255));
        btPayCash.setText("현금 계산");
        btPayCash.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btPayCash.setFocusable(false);

        tfOriginPrice.setBackground(new java.awt.Color(59, 78, 112));
        tfOriginPrice.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        tfOriginPrice.setForeground(new java.awt.Color(255, 255, 255));
        tfOriginPrice.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfOriginPrice.setText("0");
        tfOriginPrice.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfOriginPrice.setFocusable(false);

        tfDisacc.setBackground(new java.awt.Color(59, 78, 112));
        tfDisacc.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        tfDisacc.setForeground(new java.awt.Color(255, 255, 255));
        tfDisacc.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfDisacc.setText("0");
        tfDisacc.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfDisacc.setFocusable(false);

        tfTmoney.setBackground(new java.awt.Color(59, 78, 112));
        tfTmoney.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        tfTmoney.setForeground(new java.awt.Color(255, 255, 255));
        tfTmoney.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfTmoney.setText("0");
        tfTmoney.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tfTmoney.setFocusable(false);

        btPayCard.setBackground(new java.awt.Color(59, 78, 112));
        btPayCard.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        btPayCard.setForeground(new java.awt.Color(255, 255, 255));
        btPayCard.setText("카드 계산");
        btPayCard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btPayCard.setFocusable(false);

        javax.swing.GroupLayout payPlLayout = new javax.swing.GroupLayout(payPl);
        payPl.setLayout(payPlLayout);
        payPlLayout.setHorizontalGroup(
            payPlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(payPlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(payPlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(payPlLayout.createSequentialGroup()
                        .addComponent(btPlu1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btMin1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCoupon, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(payPlLayout.createSequentialGroup()
                        .addGroup(payPlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btPayCash, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(payPlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfOriginPrice)
                            .addComponent(tfDisacc)
                            .addComponent(tfTmoney)
                            .addComponent(btPayCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(payPlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(payPlLayout.createSequentialGroup()
                        .addComponent(btStamp, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btOneCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAllCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(calcPl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8))
        );
        payPlLayout.setVerticalGroup(
            payPlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(payPlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(payPlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(btPlu1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btMin1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCoupon, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btStamp, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btOneCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAllCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(payPlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(payPlLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(payPlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfOriginPrice)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(payPlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfDisacc)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(payPlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfTmoney)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(payPlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btPayCash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btPayCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(calcPl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(59, 78, 112));
        jPanel2.setFocusable(false);

        btOnoff.setBackground(new java.awt.Color(59, 78, 112));
        btOnoff.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        btOnoff.setForeground(new java.awt.Color(255, 255, 255));
        btOnoff.setText("개/폐점");
        btOnoff.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btOnoff.setFocusable(false);

        lbOnoff.setIcon(new javax.swing.ImageIcon("C:\\lecture\\workspace.list\\nb_ws\\posnmobileorder\\src\\main\\java\\img\\off.png")); // NOI18N
        lbOnoff.setFocusable(false);

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\lecture\\workspace.list\\nb_ws\\posnmobileorder\\src\\main\\java\\img\\home.png")); // NOI18N

        lbStorename.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        lbStorename.setForeground(new java.awt.Color(255, 255, 255));
        lbStorename.setText("지점명");

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\lecture\\workspace.list\\nb_ws\\posnmobileorder\\src\\main\\java\\img\\clock.png")); // NOI18N

        lbDate.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        lbDate.setForeground(new java.awt.Color(255, 255, 255));
        lbDate.setText("0000년 00월 00일");

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\lecture\\workspace.list\\nb_ws\\posnmobileorder\\src\\main\\java\\img\\logo3.png")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btOnoff, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbOnoff)
                .addGap(40, 40, 40)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbDate)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbStorename, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbOnoff)
                                .addComponent(lbDate)
                                .addComponent(jLabel9))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbStorename)
                                    .addComponent(jLabel7))
                                .addGap(3, 3, 3)))
                        .addGap(11, 11, 11))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btOnoff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))))
                .addContainerGap())
        );

        btSide.setBackground(new java.awt.Color(254, 254, 254));
        btSide.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        btSide.setForeground(new java.awt.Color(59, 78, 112));
        btSide.setText("사이드");
        btSide.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(59, 78, 112)));
        btSide.setFocusable(false);

        btCoffe.setBackground(new java.awt.Color(254, 254, 254));
        btCoffe.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        btCoffe.setForeground(new java.awt.Color(59, 78, 112));
        btCoffe.setText("커피");
        btCoffe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(59, 78, 112)));
        btCoffe.setFocusable(false);

        btNoncoffee.setBackground(new java.awt.Color(254, 254, 254));
        btNoncoffee.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        btNoncoffee.setForeground(new java.awt.Color(59, 78, 112));
        btNoncoffee.setText("논커피");
        btNoncoffee.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(59, 78, 112)));
        btNoncoffee.setFocusable(false);

        btSmoo.setBackground(new java.awt.Color(254, 254, 254));
        btSmoo.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        btSmoo.setForeground(new java.awt.Color(59, 78, 112));
        btSmoo.setText("스무디/프라페");
        btSmoo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(59, 78, 112)));
        btSmoo.setFocusable(false);

        btJuice.setBackground(new java.awt.Color(254, 254, 254));
        btJuice.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        btJuice.setForeground(new java.awt.Color(59, 78, 112));
        btJuice.setText("에이드/주스");
        btJuice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(59, 78, 112)));
        btJuice.setFocusable(false);

        btTea.setBackground(new java.awt.Color(254, 254, 254));
        btTea.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        btTea.setForeground(new java.awt.Color(59, 78, 112));
        btTea.setText("티");
        btTea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(59, 78, 112)));
        btTea.setFocusable(false);

        tbMenu.setModel(new javax.swing.table.DefaultTableModel(
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
        tbMenu.setRowHeight(40);
        jScrollPane1.setViewportView(tbMenu);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btCoffe, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btNoncoffee, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSmoo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btJuice, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btTea, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSide, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCoffe, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btNoncoffee, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSmoo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btJuice, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btTea, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSide, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        btComp.setBackground(new java.awt.Color(59, 78, 112));
        btComp.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        btComp.setForeground(new java.awt.Color(255, 255, 255));
        btComp.setText("오더 완료");
        btComp.setFocusable(false);

        btSellmenu.setBackground(new java.awt.Color(59, 78, 112));
        btSellmenu.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        btSellmenu.setForeground(new java.awt.Color(255, 255, 255));
        btSellmenu.setText("매출 관리");
        btSellmenu.setFocusable(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btComp, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
            .addComponent(btSellmenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(btComp, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSellmenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbOding.setModel(new javax.swing.table.DefaultTableModel(
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
        tbOding.setRowHeight(30);
        jScrollPane2.setViewportView(tbOding);

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(59, 78, 112));
        jTextField1.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("진행중인 오더");
        jTextField1.setFocusable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(payPl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addedMenuPl, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addedMenuPl, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(payPl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btPlu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPlu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btPlu1ActionPerformed

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
            java.util.logging.Logger.getLogger(MainHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane addedMenuPl;
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
    private javax.swing.JButton btAllCancel;
    private javax.swing.JButton btC;
    private javax.swing.JButton btCoffe;
    private javax.swing.JButton btComp;
    private javax.swing.JButton btCoupon;
    private javax.swing.JButton btDiv;
    private javax.swing.JButton btJuice;
    private javax.swing.JButton btMin;
    private javax.swing.JButton btMin1;
    private javax.swing.JButton btMul;
    private javax.swing.JButton btNoncoffee;
    private javax.swing.JButton btOneCancel;
    private javax.swing.JButton btOnoff;
    private javax.swing.JButton btPayCard;
    private javax.swing.JButton btPayCash;
    private javax.swing.JButton btPlu;
    private javax.swing.JButton btPlu1;
    private javax.swing.JButton btRst;
    private javax.swing.JButton btSellmenu;
    private javax.swing.JButton btSide;
    private javax.swing.JButton btSmoo;
    private javax.swing.JButton btStamp;
    private javax.swing.JButton btTea;
    private javax.swing.JPanel calcPl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbDate;
    private javax.swing.JLabel lbOnoff;
    private javax.swing.JLabel lbStorename;
    private javax.swing.JPanel payPl;
    private javax.swing.JTable tbAddmenu;
    private javax.swing.JTable tbMenu;
    private javax.swing.JTable tbOding;
    private javax.swing.JTextField tfCal1;
    private javax.swing.JTextField tfCal2;
    private javax.swing.JTextField tfCuName;
    private javax.swing.JTextField tfCuTel;
    private javax.swing.JTextField tfDisacc;
    private javax.swing.JTextField tfOriginPrice;
    private javax.swing.JTextField tfTmoney;
    // End of variables declaration//GEN-END:variables

    private class OnoffEvent extends MouseAdapter implements ActionListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            try{
                if(openCheck==false){
                    OpenStore f = new OpenStore(mh);
                    f.show();
                }else if(openCheck==true){
                    CloseStore f = new CloseStore(mh);
                }  
            }catch(SQLException ee){
                ee.printStackTrace();
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                if(openCheck==false){
                    OpenStore f = new OpenStore(mh);
                    f.show();
                }else if(openCheck==true){
                    CloseStore f = new CloseStore(mh);
                    f.show();
                }  
            }catch(SQLException ee){
                ee.printStackTrace();
            }
        }  
    }
    private class OrderEvent extends MouseAdapter implements ActionListener{

        @Override
        public void mouseClicked(MouseEvent e) {

            try{
                if(e.getSource()==tbMenu){
                    mouseCnt +=1;
                    if(mouseCnt==2){
                        int row = tbMenu.getSelectedRow();
                        Object obj = tbMenu.getValueAt(row, 0);
                        String pdname = obj.toString();
                        ProductDTO dto = productDao.searchByName(pdname);
                        String HI = "H";
                        String shot = "N";
                        if(dto.getCate_no()<3){
                            
                        }
                        String[] arr = {dto.getPd_name(),HI,shot,"1",dto.getPd_price()+""};
                        map.put(map.size(),arr);
                        showAdding();
                        mouseCnt=0;
                    }

                    
                } 
            }catch (SQLException ex){
                Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                
                if(e.getSource()==btCoffe){
                    showByCateno(1);
                }else if(e.getSource()==btNoncoffee){
                    showByCateno(2);
                }else if(e.getSource()==btSmoo){
                    showByCateno(3);
                }else if(e.getSource()==btJuice){
                    showByCateno(4);
                }else if(e.getSource()==btTea){
                    showByCateno(5);
                }else if(e.getSource()==btSide){
                    showByCateno(6);
                    //showOding();
                }else if(e.getSource()==btPlu1){
                    if(tbAddmenu.getSelectedRow()<0){
                        return;
                    }
                    String[] arr = map.get(tbAddmenu.getSelectedRow());
                    String num = arr[3];
                    int inum = Integer.parseInt(num);
                    inum += 1;
                    num = Integer.toString(inum);
                    arr[3] = num;
                    map.put(tbAddmenu.getSelectedRow(),arr);
                    showAdding();
                }else if(e.getSource()==btMin1){
                    if(tbAddmenu.getSelectedRow()<0){
                        return;
                    }
                    String[] arr = map.get(tbAddmenu.getSelectedRow());
                    String num = arr[3];
                    int inum = Integer.parseInt(num);
                    inum -= 1;
                    num = Integer.toString(inum);
                    arr[3] = num;
                    map.put(tbAddmenu.getSelectedRow(),arr);
                    showAdding();
                }else if(e.getSource()==btAllCancel){
                    map = new HashMap<Integer, String[]>();
                    memberDto = new MemberDTO();
                    showAdding();
                }else if(e.getSource()==btOneCancel){
                    if(tbAddmenu.getSelectedRow()<0){
                        return;
                    }
                    int key = tbAddmenu.getSelectedRow();
                    System.out.println(key);
                    System.out.println(map.size());
                    map.remove(key);
                    if(key == map.size()){
                        showAdding();
                        return;
                    }
                    if(key==map.size()-1){
                        String[] arr = map.get(map.size());
                        map.put(key, arr);
                    }
                    for(int i = key+1 ; i<map.size(); i++){
                        String[] arr = map.get(i);
                        map.put(i-1, arr);
                    }
                    map.remove(map.size()-1);
                    if(map.size()<1){
                        memberDto = new MemberDTO();
                    }
                    showAdding();
                }else if(e.getSource()==btStamp){
                    if(memberDto.getMem_tel()==null){
                        String inputTel = JOptionPane.showInputDialog("전화번호를 입력하세요");
                        String tel1 = inputTel.substring(0,3);
                        System.out.println(tel1);
                        String tel2 = inputTel.substring(3,inputTel.length()-4);
                        System.out.println(tel2);
                        String tel3 = inputTel.substring(inputTel.length()-4);
                        System.out.println(tel3);
                        String tel = tel1+"-"+tel2+"-"+tel3;
                        memberDto = memberDao.searchByTel(tel);
                        if(memberDto.getMem_id()==null){
                            memberDto.setMem_tel(tel);
                        }
                        showAdding();
                    }
                }else if(e.getSource()==btCoupon){
                    if(memberDto.getMem_pw()==null){
                        String inputTel = JOptionPane.showInputDialog("전화번호를 입력하세요");
                        String tel1 = inputTel.substring(0,3);
                        System.out.println(tel1);
                        String tel2 = inputTel.substring(3,inputTel.length()-4);
                        System.out.println(tel2);
                        String tel3 = inputTel.substring(inputTel.length()-4);
                        System.out.println(tel3);
                        String tel = tel1+"-"+tel2+"-"+tel3;
                        String inputPw = JOptionPane.showInputDialog("비밀번호를 입력하세요");
                        memberDto = memberDao.searchByTelPw(tel,inputPw);
                        if(memberDto.getMem_id()==null){
                            JOptionPane.showMessageDialog(mh, "정보가 일치하지 않습니다");
                        }
                    }else if(memberDto.getMem_pw()!=null){
                        int couponcnt = memberDto.getMem_coupon();
                        if(tbAddmenu.getSelectedRow()<0){
                            return;
                        }
                        String[] arr = map.get(tbAddmenu.getSelectedRow());
                        String op = arr[4];
                        int iop = -1*Integer.parseInt(op);
                        if(iop > 0){
                            return;
                        }
                        op = Integer.toString(iop);
                        String[] arr2 = {arr[0]+"-쿠폰",arr[1],arr[2],"1",op};
                        
                        JOptionPane.showMessageDialog(mh, "보유 쿠폰 : "+memberDto.getMem_coupon()+"개");
                        if(memberDto.getMem_coupon()<1){
                            return;
                        }
                        map.put(map.size(),arr2);
                        memberDto.setMem_coupon(memberDto.getMem_coupon()-1);
                    }
                        showAdding();
                }else if(e.getSource()==btPayCash){
                    if(!openCheck){
                        JOptionPane.showMessageDialog(mh, "개점 전 입니다");
                        return;
                    }
                    PayCash f = new PayCash(mh);
                    f.show();
                }else if(e.getSource()==btPayCard){
                    if(!openCheck){
                        JOptionPane.showMessageDialog(mh, "개점 전 입니다");
                        return;
                    }

                        String IO = "N";
                        int type = JOptionPane.showConfirmDialog(mh, "매장이용 여부","",JOptionPane.YES_NO_OPTION);
                        if(type==JOptionPane.YES_OPTION){
                            IO = "Y";
                        }
                        String cardNum = JOptionPane.showInputDialog("카드번호를 입력하세요");
                        String sprice = tfTmoney.getText();
                        int iprice = Integer.parseInt(sprice);
                        cardCnt+=iprice;
                        int od = oddtDao.insertOd(mh.getStno(), iprice);
                        int odnum = oddtDao.lastOd();
                        int oding = oddtDao.insertOdding(odnum);
                        int to = oddtDao.insertTo(mh.getStno(), iprice, cardNum,odnum);

                        OddtDTO dto = new OddtDTO();
                        String[][] data = new String[map.size()][5];

                        for(int i = 0; i<map.size(); i++) {
                            String[] arr = map.get(i);
                            if(arr[0].substring(arr[0].length()-2).equals("쿠폰")){
                                continue;
                            }
                            dto.setOddt_name(arr[0]);
                            dto.setOddt_ice(arr[1]);
                            dto.setOddt_shot(arr[2]);     
                            String num = arr[3];
                            int inum = Integer.parseInt(num);
                            dto.setOddt_cnt(inum);
                            dto.setSt_no(mh.getStno());
                            dto.setOddt_io(IO);
                            ProductDTO productDto = new ProductDTO();
                            productDto = productDao.searchByName(arr[0]);
                            int pdno = productDto.getPd_no();
                            dto.setPd_no(pdno);
                            dto.setOd_number(odnum);
                            int cnt = oddtDao.insertOddt(dto);
                            System.out.println(cnt);

                        }
                        int couponcnt = 0;
                        int stampcnt = 0;

                        for(int i = 0; i<map.size(); i++) {
                            String[] arr = map.get(i);
                            String price = arr[4];
                            int pricecheck = Integer.parseInt(price);
                            if(pricecheck>0){
                                stampcnt +=1;
                            }else if(pricecheck<0){
                                stampcnt -=1;
                            }
                        }
                        System.out.println(couponcnt);
                        if(memberDto.getMem_tel()!=null){
                            int curstamp = memberDto.getMem_stamp();
                            curstamp += stampcnt;
                            if(curstamp >=12){
                                curstamp -=12;
                                couponcnt +=1;
                            }
                            memberDto.setMem_stamp(curstamp);
                            if(memberDto.getMem_id()==null){
                                int cnt = memberDao.tempStamp(memberDto);
                            }else if(memberDto.getMem_id()!=null){
                                int cnt = memberDao.updateStamp(memberDto);
                            }
                        }
                        System.out.println(couponcnt);
                        if(memberDto.getMem_id()!=null){
                            int curcoupon = memberDto.getMem_coupon();
                            curcoupon += couponcnt;
                            memberDto.setMem_coupon(curcoupon);
                            int cnt = memberDao.updateCoupon(memberDto);
                            System.out.println(cnt);
                        }

                        mh.showOding();
                        mh.cleanUp();
                }else if(e.getSource()==btComp){
                    if(tbOding.getSelectedRow()<0){
                        return;
                    }
                    int row = tbOding.getSelectedRow();
                    Object obj = tbOding.getValueAt(row, 0);
                    String sodno = obj.toString();
                    int odno = Integer.parseInt(sodno);
                    int cnt = oddtDao.deleteOding(odno);
                    System.out.println(cnt);
                    showOding();
                    
                }
            }catch (SQLException ex){
                Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
    }
    public void showAdding(){
            int originPrice = 0;
            int discountPrice = 0;
            int finalPrice = 0;

            String[][] data = new String[map.size()][5];
            
            for(int i = 0; i<data.length; i++) {
                String[] arr = map.get(i);
                data[i][0] = arr[0];
                data[i][1] = arr[1];
                data[i][2] = arr[2];
                data[i][3] = arr[3];
                String num = arr[3];
                String price = arr[4];
                int inum = Integer.parseInt(num);
                int iprice = Integer.parseInt(price);
                int sum = inum*iprice;
                if(sum>=0) originPrice += sum;
                if(sum<0) discountPrice += sum;
                data[i][4] = Integer.toString(sum);
            }
            String[] addcolNames = {"상품명","핫/아이스","샷추가","수량","가격"};
            DefaultTableModel model = new DefaultTableModel();
            
            model.setDataVector(data, addcolNames);
            tbAddmenu.setModel(model);
            
            String sorigin = Integer.toString(originPrice);
            String sdis = Integer.toString(discountPrice);
            finalPrice = originPrice + discountPrice;
            if(finalPrice < 0) finalPrice = 0;
            String sfinal = Integer.toString(finalPrice);
            tfOriginPrice.setText(sorigin);
            tfDisacc.setText(sdis);
            tfTmoney.setText(sfinal);
            
            String name = memberDto.getMem_name();
            String tel = memberDto.getMem_tel();
            if(memberDto.getMem_tel() != null){
                if(name != null && !name.isEmpty()){
                    name = name.replace(name.substring(1), "**");
                }
                tel = tel.replace(tel.substring(4),"****-****");
            }
            tfCuName.setText(name);
            tfCuTel.setText(tel);

    }
    
    public void showOding(){
        try {
            List<OddtDTO> list = oddtDao.showByStno(mh.stno);
            String[][] data = new String[list.size()][6];
            
            for(int i = 0; i<data.length; i++) {
                OddtDTO dto = list.get(i);
                data[i][0] = dto.getOd_number()+"";
                data[i][1] = dto.getOddt_name()+"";
                data[i][2] = dto.getOddt_cnt()+"";
                data[i][3] = dto.getOddt_ice()+"";
                data[i][4] = dto.getOddt_shot()+"";
                data[i][5] = dto.getOddt_io()+"";
            }
            String[] menucolNames = {"주문번호","상품명","수량","핫/아이스","샷추가","매장이용"};
            DefaultTableModel model = new DefaultTableModel();
            
            model.setDataVector(data, menucolNames);
            tbOding.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void showByCateno(int cateno) {
        try {
            List<ProductDTO> list = productDao.selectByCateno(cateno);
            
            
            String[][] data = new String[list.size()][2];
            
            for(int i = 0; i<data.length; i++) {
                ProductDTO dto = list.get(i);
                data[i][0] = dto.getPd_name()+"";
                data[i][1] = dto.getPd_price()+"";
            }
            String[] menucolNames = {"상품명","가격"};
            DefaultTableModel model = new DefaultTableModel(){
                public boolean isCellEditable(int row, int column){
                return false;
               } 
            };
            
            model.setDataVector(data, menucolNames);
            tbMenu.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private class CalculEvent implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==bt0 || e.getSource()==bt1 || e.getSource()==bt2 ||
                e.getSource()==bt3 || e.getSource()==bt4 || e.getSource()==bt5 ||
                e.getSource()==bt6 || e.getSource()==bt7 || e.getSource()==bt8 ||
                e.getSource()==bt9) {
                    if(!calbool) {
                            calbool = true;
                            tfCal2.setText("0");
                    }
                    if(tfCal2.getText().equals("0")) {
                            tfCal2.setText("");
                    }

                    String str1 = tfCal2.getText();
                    JButton obj = (JButton)e.getSource();
                    String str2 = obj.getText();
                    tfCal2.setText(str1+str2);
            }//숫자버튼

            if(e.getSource()==btPlu) {
                if(!calbool) {
                }
                else if(calop=='a'){
                    tfCal1.setText(tfCal2.getText());
                    calop = '+';
                    calbool = false;
                }
                else if(calop!='a'){
                    String rst = calculator(tfCal1.getText(), tfCal2.getText());
                    tfCal1.setText(rst);
                    calop = '+';
                    calbool=false;
                }
            }
            if(e.getSource()==btMin) {
                    if(!calbool) {
                }
                    else if(calop=='a'){
                    tfCal1.setText(tfCal2.getText());
                    calop = '-';
                    calbool = false;
                }
                    else if(calop!='a'){
                    String rst = calculator(tfCal1.getText(), tfCal2.getText());
                    tfCal1.setText(rst);
                    calop = '-';
                    calbool=false;
                }
            }
            if(e.getSource()==btMul) {
                    if(!calbool) {
                }
                    else if(calop=='a'){
                    tfCal1.setText(tfCal2.getText());
                    calop = '*';
                    calbool = false;
                }
                    else if(calop!='a'){
                    String rst = calculator(tfCal1.getText(), tfCal2.getText());
                    tfCal1.setText(rst);
                    calop = '*';
                    calbool=false;
                }
            }
            if(e.getSource()==btDiv) {
                    if(!calbool) {
                }
                    else if(calop=='a'){
                    tfCal1.setText(tfCal2.getText());
                    calop = '/';
                    calbool = false;
                }
                    else if(calop!='a'){
                    String rst = calculator(tfCal1.getText(), tfCal2.getText());
                    tfCal1.setText(rst);
                    calop = '/';
                    calbool=false;
                }
            }//사칙연산
            
            if(e.getSource()==btC) {
                    calbool=false;
                    calop = 'a';
                    tfCal2.setText("0");
                    tfCal1.setText("");
            }
            
            if(e.getSource()==btRst) {
                if(!calbool) {
                }
                else if(calop=='a'){
                }
                else if(calop!='a'){
                    String rst = calculator(tfCal1.getText(), tfCal2.getText());
                    tfCal1.setText(rst);
                    calop = 'a';
                    tfCal2.setText(rst);
                }
            }
        }   
    }
    public void iconOn(){
        //lbOnoff.setIcon(new javax.swing.ImageIcon("C:\\lecture\\workspace.list\\nb_ws\\posnmobileorder\\src\\main\\java\\img\\on.png"));
        lbOnoff.setIcon(new javax.swing.ImageIcon("src/main/java/img/on.png"));
    }
    public void iconOff(){
        //lbOnoff.setIcon(new javax.swing.ImageIcon("C:\\lecture\\workspace.list\\nb_ws\\posnmobileorder\\src\\main\\java\\img\\off.png"));
        lbOnoff.setIcon(new javax.swing.ImageIcon("src/main/java/img/off.png"));
    }
    private String calculator(String cal1, String cal2){
        Float num1 = Float.parseFloat(cal1);
        Float num2 = Float.parseFloat(cal2);
        Float num3 = 0f;
        switch(calop){
            case '+' : num3=num1+num2; 
                break;
            case '-' : num3=num1-num2;
                break;
            case '*' : num3=num1*num2;
                break;
            case '/' : num3 = num1/num2;
                break;
        }
        String rst = Float.toString(num3);
        for(int i = 0 ; i<rst.length();i++) {
                if(rst.substring(i,i+1).equals(".")){
                        while(rst.substring(rst.length()-1).equals("0")) {
                                rst=rst.substring(0,rst.length()-1);
                        }
                        rst=rst.substring(0,rst.length()-1);
                }
        }
        return rst;
    }
    public void cleanUp(){
        map = new HashMap<Integer, String[]>();
        memberDto = new MemberDTO();
        showAdding();
    }
}
