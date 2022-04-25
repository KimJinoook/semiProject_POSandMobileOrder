/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.semi1.mobile;

import com.semi1.data.MemberDAO;
import com.semi1.data.MemberDTO;
import com.semi1.data.OddtDTO;
import com.semi1.data.OddtDAO;
import com.semi1.data.ProductDAO;
import com.semi1.data.ProductDTO;
import com.semi1.data.StoreDAO;
import com.semi1.data.StoreService;
import com.semi1.pos.MainHome;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author USER
 */
public class MobileHome extends javax.swing.JFrame {
    private CardLayout cl1 = new CardLayout();
    private StoreDAO storeDao = new StoreDAO();
    private MemberDAO memberDao = new MemberDAO();
    private MemberDTO memberDto = new MemberDTO();
    private ProductDAO productDao = new ProductDAO();
    private OddtDAO oddtDao = new OddtDAO();
    private boolean loginCheck = false;
    private ArrayList<ProductDTO> menuPdList = new ArrayList<ProductDTO>();
    private ArrayList<String[]> basketList = new ArrayList<String[]>();
    private ArrayList<String[]> receiptList = new ArrayList<String[]>();
    private MainHome mh;
    private MobileHome moh = this;
    
    

    /**
     * Creates new form MobileHome
     */
    public MobileHome() {
        initComponents();
        initcustom();
        addEvent();
    }
    private void initcustom(){
        setSize(448,931);
        jPanel1.setSize(432,889);
        plMiddle.setLayout(cl1);
        plMiddle.add(plMiddleHome,"home");
        plMiddle.add(plMiddleStoreSelect,"store");
        plMiddle.add(plMiddleMenuSelect,"menu");
        plMiddle.add(plMiddleAddpd,"addpd");
        plMiddle.add(plMiddleLogin, "login");
        plMiddle.add(plMiddleSignUp, "signup");
        plMiddle.add(plMiddleMy, "my");
        plMiddle.add(plMiddleStamp, "stamp");
        plMiddle.add(plMiddleBasket,"basket");
        plMiddle.add(plMiddleReceipt,"receipt");
        plMiddle.add(plMiddleCoupon, "coupon");
        
        plCv.setLayout(cl1);
        plCv.add(cvCard1,"cvc1");
        plCv.add(cvCard2,"cvc2");
        plCv.add(cvCard3,"cvc3");
        
        
        jLabel1.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\topban.png")); // NOI18N
        lbOrder.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\order1.png")); // NOI18N
        lbHome.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\phonehome2.png")); // NOI18N
        lbMy.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\my1.png")); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\cv1.png")); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\cv2.png")); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\cv3.png")); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\stamp.png")); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\coupon.png")); // NOI18N
        lbAddpdImg.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\noimage.png")); // NOI18N
        jLabel22.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\coupon.png")); // NOI18N
        jLabel18.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\receipt.png")); // NOI18N
        jLabel20.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\stamp.png")); // NOI18N
        jLabel24.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\smile.png")); // NOI18N
        jLabel26.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\logout.png")); // NOI18N
        lbStamp1.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\s1.png")); // NOI18N
        lbStamp2.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\s2.png")); // NOI18N
        lbStamp3.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\s3.png")); // NOI18N
        lbStamp4.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\s4.png")); // NOI18N
        lbStamp5.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\s5.png")); // NOI18N
        lbStamp6.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\s6.png")); // NOI18N
        lbStamp7.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\s7.png")); // NOI18N
        lbStamp8.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\s8.png")); // NOI18N
        lbStamp9.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\s9.png")); // NOI18N
        lbStamp10.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\s10.png")); // NOI18N
        lbStamp11.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\s11.png")); // NOI18N
        lbStamp12.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\s12.png")); // NOI18N
        
        CvThread r = new CvThread();
        Thread th = new Thread(r);
        th.setDaemon(true);
        th.start();
        
  
    }
    private void addEvent(){
        jLabel1.addMouseListener(new MouseEventHandler());
        lbHome.addMouseListener(new MouseEventHandler());
        lbOrder.addMouseListener(new MouseEventHandler());
        lbMy.addMouseListener(new MouseEventHandler());
        listSi.addMouseListener(new MouseEventHandler());
        listGugun.addMouseListener(new MouseEventHandler());
        listStore.addMouseListener(new MouseEventHandler());
        tfSignupTel.addMouseListener(new MouseEventHandler());
        tfSignupId.addMouseListener(new MouseEventHandler());
        tfSignupPwd1.addMouseListener(new MouseEventHandler());
        tfSignupPwd2.addMouseListener(new MouseEventHandler());
        tfSignupName.addMouseListener(new MouseEventHandler());
        tfSignupBirth.addMouseListener(new MouseEventHandler());
        
        lbMyRecep.addMouseListener(new MyMouseEvent());
        lbMyStamp.addMouseListener(new MyMouseEvent());
        lbMyCoupon.addMouseListener(new MyMouseEvent());
        lbMyInfo.addMouseListener(new MyMouseEvent());
        lbMyLogout.addMouseListener(new MyMouseEvent());
        
        btLogin.addActionListener(new MemberEvent());
        btLoginSign.addActionListener(new MemberEvent());
        btSignupIdCheck.addActionListener(new MemberEvent());
        btSignupSignup.addActionListener(new MemberEvent());
        
        btCoffee.addActionListener(new MenuEvent());
        btNoncoffee.addActionListener(new MenuEvent());
        btIced.addActionListener(new MenuEvent());
        btAde.addActionListener(new MenuEvent());
        btTea.addActionListener(new MenuEvent());
        btSide.addActionListener(new MenuEvent());
        plMenu.addMouseListener(new MenuEvent());
        btPlu1.addActionListener(new MenuEvent());
        btMin1.addActionListener(new MenuEvent());
        btAddBasket.addActionListener(new MenuEvent());
        btAddPd.addActionListener(new MenuEvent());
        btAllCancel.addActionListener(new MenuEvent());
        btPayCard.addActionListener(new MenuEvent());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GroupIH = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        plBottom = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        lbOrder = new javax.swing.JLabel();
        lbHome = new javax.swing.JLabel();
        lbMy = new javax.swing.JLabel();
        plMiddle = new javax.swing.JPanel();
        plMiddleHome = new javax.swing.JPanel();
        plCv = new javax.swing.JPanel();
        cvCard1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cvCard2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cvCard3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbHomeCname = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        lbHomeCoupon = new javax.swing.JLabel();
        lbHomeStamp = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        plMiddleStoreSelect = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        listSi = new javax.swing.JList<>();
        jSplitPane2 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        listGugun = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        listStore = new javax.swing.JList<>();
        plMiddleMenuSelect = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        lbStoreName = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btCoffee = new javax.swing.JButton();
        btNoncoffee = new javax.swing.JButton();
        btIced = new javax.swing.JButton();
        btAde = new javax.swing.JButton();
        btTea = new javax.swing.JButton();
        btSide = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        plMenu = new javax.swing.JPanel();
        plMiddleAddpd = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        lbStoreName1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        lbAddpdImg = new javax.swing.JLabel();
        lbAddpdName = new javax.swing.JLabel();
        lbAddpdPrice = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        radiobtHot = new javax.swing.JRadioButton();
        radiobtIce = new javax.swing.JRadioButton();
        btPlu1 = new javax.swing.JButton();
        btMin1 = new javax.swing.JButton();
        lbAddpdNum = new javax.swing.JLabel();
        btAddBasket = new javax.swing.JButton();
        plMiddleStoreSelect2 = new javax.swing.JPanel();
        plMiddleSignUp = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        tfSignupId = new javax.swing.JTextField();
        btSignupIdCheck = new javax.swing.JButton();
        tfSignupTel = new javax.swing.JFormattedTextField();
        tfSignupPwd1 = new javax.swing.JTextField();
        tfSignupPwd2 = new javax.swing.JTextField();
        tfSignupName = new javax.swing.JTextField();
        tfSignupBirth = new javax.swing.JFormattedTextField();
        btSignupSignup = new javax.swing.JButton();
        plMiddleSample1 = new javax.swing.JPanel();
        plMiddleLogin = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tfLoginId = new javax.swing.JTextField();
        tfLoginPw = new javax.swing.JPasswordField();
        btLogin = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        btLoginSign = new javax.swing.JButton();
        plMiddleMy = new javax.swing.JPanel();
        lbMyName = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        lbMyRecep = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        lbMyStamp = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        lbMyCoupon = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        lbMyInfo = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        lbMyLogout = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        plMiddleStamp = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        lbStampNum = new javax.swing.JLabel();
        lbStamp1 = new javax.swing.JLabel();
        lbStamp2 = new javax.swing.JLabel();
        lbStamp3 = new javax.swing.JLabel();
        lbStamp4 = new javax.swing.JLabel();
        lbStamp5 = new javax.swing.JLabel();
        lbStamp6 = new javax.swing.JLabel();
        lbStamp7 = new javax.swing.JLabel();
        lbStamp8 = new javax.swing.JLabel();
        lbStamp9 = new javax.swing.JLabel();
        lbStamp10 = new javax.swing.JLabel();
        lbStamp11 = new javax.swing.JLabel();
        lbStamp12 = new javax.swing.JLabel();
        plMiddleBasket = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        lbStoreName3 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        btPayCard = new javax.swing.JButton();
        btAddPd = new javax.swing.JButton();
        btAllCancel = new javax.swing.JButton();
        lbBasketTotal = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        plBasket = new javax.swing.JPanel();
        plMiddleReceipt = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        lbStoreName4 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        plReceipt = new javax.swing.JPanel();
        plMiddleCoupon = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        lbCouponCnt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(254, 254, 254));

        plBottom.setBackground(new java.awt.Color(254, 254, 254));

        lbHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbHomeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout plBottomLayout = new javax.swing.GroupLayout(plBottom);
        plBottom.setLayout(plBottomLayout);
        plBottomLayout.setHorizontalGroup(
            plBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plBottomLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbHome)
                .addGap(87, 87, 87)
                .addComponent(lbOrder)
                .addGap(87, 87, 87)
                .addComponent(lbMy)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        plBottomLayout.setVerticalGroup(
            plBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plBottomLayout.createSequentialGroup()
                .addComponent(jSeparator1)
                .addGap(18, 18, 18)
                .addGroup(plBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbOrder)
                    .addComponent(lbMy)
                    .addComponent(lbHome))
                .addContainerGap())
        );

        plMiddle.setLayout(new java.awt.CardLayout());

        plMiddleHome.setBackground(new java.awt.Color(254, 254, 254));
        plMiddleHome.setAlignmentX(0.0F);
        plMiddleHome.setAlignmentY(0.0F);

        plCv.setLayout(new java.awt.CardLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        javax.swing.GroupLayout cvCard1Layout = new javax.swing.GroupLayout(cvCard1);
        cvCard1.setLayout(cvCard1Layout);
        cvCard1Layout.setHorizontalGroup(
            cvCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cvCard1Layout.setVerticalGroup(
            cvCard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        plCv.add(cvCard1, "card4");

        javax.swing.GroupLayout cvCard2Layout = new javax.swing.GroupLayout(cvCard2);
        cvCard2.setLayout(cvCard2Layout);
        cvCard2Layout.setHorizontalGroup(
            cvCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cvCard2Layout.setVerticalGroup(
            cvCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        plCv.add(cvCard2, "card3");

        javax.swing.GroupLayout cvCard3Layout = new javax.swing.GroupLayout(cvCard3);
        cvCard3.setLayout(cvCard3Layout);
        cvCard3Layout.setHorizontalGroup(
            cvCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cvCard3Layout.setVerticalGroup(
            cvCard3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        plCv.add(cvCard3, "card2");

        jPanel2.setBackground(new java.awt.Color(254, 254, 254));

        lbHomeCname.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lbHomeCname.setForeground(new java.awt.Color(250, 110, 71));
        lbHomeCname.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbHomeCname.setText("Guest");

        jLabel4.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel4.setText("고객님");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbHomeCname, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                    .addComponent(lbHomeCname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(254, 254, 254));

        jLabel3.setBackground(new java.awt.Color(254, 254, 254));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel5.setBackground(new java.awt.Color(254, 254, 254));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(254, 254, 254));

        lbHomeCoupon.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        lbHomeCoupon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHomeCoupon.setText("0");

        lbHomeStamp.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        lbHomeStamp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHomeStamp.setText("0/12");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(lbHomeCoupon, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbHomeStamp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbHomeStamp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbHomeCoupon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(254, 254, 254));

        jLabel8.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("보유 쿠폰 수");

        jLabel9.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("보유 스탬프 수");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout plMiddleHomeLayout = new javax.swing.GroupLayout(plMiddleHome);
        plMiddleHome.setLayout(plMiddleHomeLayout);
        plMiddleHomeLayout.setHorizontalGroup(
            plMiddleHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(plCv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        plMiddleHomeLayout.setVerticalGroup(
            plMiddleHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plMiddleHomeLayout.createSequentialGroup()
                .addComponent(plCv, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(202, Short.MAX_VALUE))
        );

        plMiddle.add(plMiddleHome, "home");

        plMiddleStoreSelect.setBackground(new java.awt.Color(254, 254, 254));

        jPanel7.setBackground(new java.awt.Color(254, 254, 254));

        jLabel10.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel10.setText("매장선택");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(jLabel10)
                .addContainerGap(183, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addContainerGap())
        );

        jSplitPane1.setBackground(new java.awt.Color(254, 254, 254));
        jSplitPane1.setDividerLocation(100);
        jSplitPane1.setDividerSize(0);

        listSi.setBackground(new java.awt.Color(245, 245, 245));
        listSi.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        listSi.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        listSi.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listSi.setFixedCellHeight(40);
        listSi.setFocusable(false);
        listSi.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(listSi);

        jSplitPane1.setLeftComponent(jScrollPane1);

        jSplitPane2.setBackground(new java.awt.Color(255, 255, 255));
        jSplitPane2.setDividerLocation(100);
        jSplitPane2.setDividerSize(0);

        listGugun.setBackground(new java.awt.Color(245, 245, 245));
        listGugun.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        listGugun.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        listGugun.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listGugun.setFixedCellHeight(40);
        listGugun.setFocusable(false);
        listGugun.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(listGugun);

        jSplitPane2.setLeftComponent(jScrollPane2);

        listStore.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        listStore.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        listStore.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listStore.setFixedCellHeight(40);
        listStore.setFocusable(false);
        listStore.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(listStore);

        jSplitPane2.setRightComponent(jScrollPane3);

        jSplitPane1.setRightComponent(jSplitPane2);

        javax.swing.GroupLayout plMiddleStoreSelectLayout = new javax.swing.GroupLayout(plMiddleStoreSelect);
        plMiddleStoreSelect.setLayout(plMiddleStoreSelectLayout);
        plMiddleStoreSelectLayout.setHorizontalGroup(
            plMiddleStoreSelectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSplitPane1)
        );
        plMiddleStoreSelectLayout.setVerticalGroup(
            plMiddleStoreSelectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plMiddleStoreSelectLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 686, Short.MAX_VALUE))
        );

        plMiddle.add(plMiddleStoreSelect, "store");

        plMiddleMenuSelect.setBackground(new java.awt.Color(254, 254, 254));

        jPanel8.setBackground(new java.awt.Color(254, 254, 254));

        lbStoreName.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lbStoreName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbStoreName.setText("선택매장명");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbStoreName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbStoreName, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(254, 254, 254));
        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel4.setFocusable(false);

        btCoffee.setBackground(new java.awt.Color(254, 254, 254));
        btCoffee.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        btCoffee.setText("Coffee");
        btCoffee.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btCoffee.setFocusable(false);
        btCoffee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCoffeeActionPerformed(evt);
            }
        });

        btNoncoffee.setBackground(new java.awt.Color(254, 254, 254));
        btNoncoffee.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        btNoncoffee.setText("Non-cof");
        btNoncoffee.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btNoncoffee.setFocusable(false);
        btNoncoffee.setMargin(new java.awt.Insets(2, 2, 2, 2));

        btIced.setBackground(new java.awt.Color(254, 254, 254));
        btIced.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        btIced.setText("Iced");
        btIced.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btIced.setFocusable(false);

        btAde.setBackground(new java.awt.Color(254, 254, 254));
        btAde.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        btAde.setText("Ade");
        btAde.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btAde.setFocusable(false);

        btTea.setBackground(new java.awt.Color(254, 254, 254));
        btTea.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        btTea.setText("Tea");
        btTea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btTea.setFocusable(false);

        btSide.setBackground(new java.awt.Color(254, 254, 254));
        btSide.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        btSide.setText("Side");
        btSide.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        btSide.setFocusable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btNoncoffee, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btIced, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAde, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btTea, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSide, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addComponent(btCoffee, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 363, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btNoncoffee, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btIced, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btAde, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btTea, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btSide, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addComponent(btCoffee, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jScrollPane4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        plMenu.setBackground(new java.awt.Color(254, 254, 254));

        javax.swing.GroupLayout plMenuLayout = new javax.swing.GroupLayout(plMenu);
        plMenu.setLayout(plMenuLayout);
        plMenuLayout.setHorizontalGroup(
            plMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 431, Short.MAX_VALUE)
        );
        plMenuLayout.setVerticalGroup(
            plMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 626, Short.MAX_VALUE)
        );

        jScrollPane4.setViewportView(plMenu);

        javax.swing.GroupLayout plMiddleMenuSelectLayout = new javax.swing.GroupLayout(plMiddleMenuSelect);
        plMiddleMenuSelect.setLayout(plMiddleMenuSelectLayout);
        plMiddleMenuSelectLayout.setHorizontalGroup(
            plMiddleMenuSelectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane4)
        );
        plMiddleMenuSelectLayout.setVerticalGroup(
            plMiddleMenuSelectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plMiddleMenuSelectLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4))
        );

        plMiddle.add(plMiddleMenuSelect, "menu");

        plMiddleAddpd.setBackground(new java.awt.Color(254, 254, 254));

        jPanel9.setBackground(new java.awt.Color(254, 254, 254));

        lbStoreName1.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lbStoreName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbStoreName1.setText("제품명");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbStoreName1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbStoreName1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        lbAddpdName.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        lbAddpdName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbAddpdName.setText("제품명");

        lbAddpdPrice.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        lbAddpdPrice.setForeground(new java.awt.Color(250, 110, 71));
        lbAddpdPrice.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbAddpdPrice.setText("제품가격");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(lbAddpdImg, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAddpdPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAddpdName, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(lbAddpdName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbAddpdPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lbAddpdImg, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        radiobtHot.setBackground(new java.awt.Color(255, 255, 255));
        GroupIH.add(radiobtHot);
        radiobtHot.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        radiobtHot.setText("Hot");

        radiobtIce.setBackground(new java.awt.Color(255, 255, 255));
        GroupIH.add(radiobtIce);
        radiobtIce.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        radiobtIce.setSelected(true);
        radiobtIce.setText("Ice");

        btPlu1.setBackground(new java.awt.Color(254, 254, 254));
        btPlu1.setText("+");
        btPlu1.setMargin(new java.awt.Insets(2, 2, 2, 2));

        btMin1.setBackground(new java.awt.Color(254, 254, 254));
        btMin1.setText("-");

        lbAddpdNum.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        lbAddpdNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAddpdNum.setText("1");

        btAddBasket.setBackground(new java.awt.Color(250, 110, 71));
        btAddBasket.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        btAddBasket.setForeground(new java.awt.Color(255, 255, 255));
        btAddBasket.setText("장바구니 담기");
        btAddBasket.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(radiobtIce)
                .addGap(44, 44, 44)
                .addComponent(radiobtHot)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(btMin1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbAddpdNum, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btPlu1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btAddBasket, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radiobtHot)
                    .addComponent(radiobtIce)
                    .addComponent(btPlu1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btMin1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbAddpdNum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(btAddBasket, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout plMiddleAddpdLayout = new javax.swing.GroupLayout(plMiddleAddpd);
        plMiddleAddpd.setLayout(plMiddleAddpdLayout);
        plMiddleAddpdLayout.setHorizontalGroup(
            plMiddleAddpdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        plMiddleAddpdLayout.setVerticalGroup(
            plMiddleAddpdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plMiddleAddpdLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 351, Short.MAX_VALUE))
        );

        plMiddle.add(plMiddleAddpd, "addpd");

        plMiddleStoreSelect2.setBackground(new java.awt.Color(254, 254, 254));

        javax.swing.GroupLayout plMiddleStoreSelect2Layout = new javax.swing.GroupLayout(plMiddleStoreSelect2);
        plMiddleStoreSelect2.setLayout(plMiddleStoreSelect2Layout);
        plMiddleStoreSelect2Layout.setHorizontalGroup(
            plMiddleStoreSelect2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
        );
        plMiddleStoreSelect2Layout.setVerticalGroup(
            plMiddleStoreSelect2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 729, Short.MAX_VALUE)
        );

        plMiddle.add(plMiddleStoreSelect2, "card3");

        plMiddleSignUp.setBackground(new java.awt.Color(254, 254, 254));

        jLabel12.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("회원가입");

        tfSignupId.setText("아이디");
        tfSignupId.setToolTipText("아이디를 입력하세요");
        tfSignupId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btSignupIdCheck.setBackground(new java.awt.Color(0, 0, 0));
        btSignupIdCheck.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        btSignupIdCheck.setForeground(new java.awt.Color(255, 255, 255));
        btSignupIdCheck.setText("중복확인");

        tfSignupTel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        try {
            tfSignupTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("AAAAAA")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfSignupTel.setText("휴대전화번호");

        tfSignupPwd1.setText("비밀번호");
        tfSignupPwd1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tfSignupPwd2.setText("비밀번호 확인");
        tfSignupPwd2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        tfSignupPwd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSignupPwd2ActionPerformed(evt);
            }
        });

        tfSignupName.setText("이름 (실명입력)");
        tfSignupName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        tfSignupName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSignupNameActionPerformed(evt);
            }
        });

        tfSignupBirth.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        try {
            tfSignupBirth.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("***********")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfSignupBirth.setText("생년월일 (6자리) ");

        btSignupSignup.setBackground(new java.awt.Color(0, 0, 0));
        btSignupSignup.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        btSignupSignup.setForeground(new java.awt.Color(255, 255, 255));
        btSignupSignup.setText("회원가입");

        javax.swing.GroupLayout plMiddleSignUpLayout = new javax.swing.GroupLayout(plMiddleSignUp);
        plMiddleSignUp.setLayout(plMiddleSignUpLayout);
        plMiddleSignUpLayout.setHorizontalGroup(
            plMiddleSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plMiddleSignUpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plMiddleSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btSignupSignup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfSignupBirth)
                    .addComponent(tfSignupName)
                    .addComponent(tfSignupPwd2)
                    .addComponent(tfSignupPwd1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfSignupTel)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, plMiddleSignUpLayout.createSequentialGroup()
                        .addComponent(tfSignupId, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSignupIdCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        plMiddleSignUpLayout.setVerticalGroup(
            plMiddleSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plMiddleSignUpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(plMiddleSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfSignupId)
                    .addComponent(btSignupIdCheck, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(tfSignupPwd1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfSignupPwd2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfSignupName, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfSignupTel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfSignupBirth, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btSignupSignup, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(217, Short.MAX_VALUE))
        );

        plMiddle.add(plMiddleSignUp, "signup");

        plMiddleSample1.setBackground(new java.awt.Color(254, 254, 254));

        javax.swing.GroupLayout plMiddleSample1Layout = new javax.swing.GroupLayout(plMiddleSample1);
        plMiddleSample1.setLayout(plMiddleSample1Layout);
        plMiddleSample1Layout.setHorizontalGroup(
            plMiddleSample1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
        );
        plMiddleSample1Layout.setVerticalGroup(
            plMiddleSample1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 729, Short.MAX_VALUE)
        );

        plMiddle.add(plMiddleSample1, "card3");

        plMiddleLogin.setBackground(new java.awt.Color(254, 254, 254));

        jLabel15.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("로그인");

        jLabel16.setFont(new java.awt.Font("맑은 고딕", 1, 24)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Cafe Ezen");

        tfLoginId.setToolTipText("아이디를 입력하세요");
        tfLoginId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        tfLoginPw.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btLogin.setBackground(new java.awt.Color(0, 0, 0));
        btLogin.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        btLogin.setForeground(new java.awt.Color(255, 255, 255));
        btLogin.setText("로그인 하기");

        btLoginSign.setBackground(new java.awt.Color(254, 254, 254));
        btLoginSign.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        btLoginSign.setText("신규 회원 가입");

        javax.swing.GroupLayout plMiddleLoginLayout = new javax.swing.GroupLayout(plMiddleLogin);
        plMiddleLogin.setLayout(plMiddleLoginLayout);
        plMiddleLoginLayout.setHorizontalGroup(
            plMiddleLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plMiddleLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plMiddleLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btLoginSign, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfLoginPw)
                    .addComponent(tfLoginId)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        plMiddleLoginLayout.setVerticalGroup(
            plMiddleLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plMiddleLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfLoginId, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfLoginPw, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btLoginSign, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(272, Short.MAX_VALUE))
        );

        plMiddle.add(plMiddleLogin, "login");

        plMiddleMy.setBackground(new java.awt.Color(254, 254, 254));

        lbMyName.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lbMyName.setForeground(new java.awt.Color(250, 110, 71));
        lbMyName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbMyName.setText("홍길동");

        jLabel14.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        jLabel14.setText("고객님, 반갑습니다.");

        jSeparator2.setForeground(new java.awt.Color(242, 242, 242));

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\eclipse-workspace\\posnmobileorder\\src\\main\\java\\img\\receipt.png")); // NOI18N

        lbMyRecep.setText("주문 내역");

        jSeparator3.setForeground(new java.awt.Color(242, 242, 242));

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\eclipse-workspace\\posnmobileorder\\src\\main\\java\\img\\stamp.png")); // NOI18N

        lbMyStamp.setText("적립 스탬프");

        jSeparator4.setForeground(new java.awt.Color(242, 242, 242));

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\eclipse-workspace\\posnmobileorder\\src\\main\\java\\img\\coupon.png")); // NOI18N

        lbMyCoupon.setText("쿠폰");

        jSeparator5.setForeground(new java.awt.Color(242, 242, 242));

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\eclipse-workspace\\posnmobileorder\\src\\main\\java\\img\\smile.png")); // NOI18N

        lbMyInfo.setText("내 정보 수정");

        jSeparator6.setForeground(new java.awt.Color(242, 242, 242));

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\eclipse-workspace\\posnmobileorder\\src\\main\\java\\img\\logout.png")); // NOI18N

        lbMyLogout.setText("로그아웃");

        jSeparator7.setForeground(new java.awt.Color(242, 242, 242));

        javax.swing.GroupLayout plMiddleMyLayout = new javax.swing.GroupLayout(plMiddleMy);
        plMiddleMy.setLayout(plMiddleMyLayout);
        plMiddleMyLayout.setHorizontalGroup(
            plMiddleMyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addComponent(jSeparator3)
            .addComponent(jSeparator4)
            .addComponent(jSeparator5)
            .addComponent(jSeparator6)
            .addGroup(plMiddleMyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plMiddleMyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plMiddleMyLayout.createSequentialGroup()
                        .addGroup(plMiddleMyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(plMiddleMyLayout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbMyCoupon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(plMiddleMyLayout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbMyStamp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(plMiddleMyLayout.createSequentialGroup()
                                .addComponent(lbMyName, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE))
                            .addGroup(plMiddleMyLayout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbMyRecep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(plMiddleMyLayout.createSequentialGroup()
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbMyInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(plMiddleMyLayout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbMyLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jSeparator7)
        );
        plMiddleMyLayout.setVerticalGroup(
            plMiddleMyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plMiddleMyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plMiddleMyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(lbMyName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(plMiddleMyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(lbMyRecep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(plMiddleMyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(lbMyStamp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(plMiddleMyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(lbMyCoupon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(plMiddleMyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(lbMyInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(plMiddleMyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(lbMyLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(309, Short.MAX_VALUE))
        );

        plMiddle.add(plMiddleMy, "my");

        plMiddleStamp.setBackground(new java.awt.Color(254, 254, 254));

        jLabel19.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("적립 스탬프");

        lbStampNum.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lbStampNum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbStampNum.setText("0/12");

        lbStamp1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbStamp1.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\eclipse-workspace\\posnmobileorder\\src\\main\\java\\img\\s1.png")); // NOI18N

        lbStamp2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbStamp2.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\eclipse-workspace\\posnmobileorder\\src\\main\\java\\img\\s2.png")); // NOI18N

        lbStamp3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbStamp3.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\eclipse-workspace\\posnmobileorder\\src\\main\\java\\img\\s3.png")); // NOI18N

        lbStamp4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbStamp4.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\eclipse-workspace\\posnmobileorder\\src\\main\\java\\img\\s4.png")); // NOI18N

        lbStamp5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbStamp5.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\eclipse-workspace\\posnmobileorder\\src\\main\\java\\img\\s5.png")); // NOI18N

        lbStamp6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbStamp6.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\eclipse-workspace\\posnmobileorder\\src\\main\\java\\img\\s6.png")); // NOI18N

        lbStamp7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbStamp7.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\eclipse-workspace\\posnmobileorder\\src\\main\\java\\img\\s7.png")); // NOI18N

        lbStamp8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbStamp8.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\eclipse-workspace\\posnmobileorder\\src\\main\\java\\img\\s8.png")); // NOI18N

        lbStamp9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbStamp9.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\eclipse-workspace\\posnmobileorder\\src\\main\\java\\img\\s9.png")); // NOI18N

        lbStamp10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbStamp10.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\eclipse-workspace\\posnmobileorder\\src\\main\\java\\img\\s10.png")); // NOI18N

        lbStamp11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbStamp11.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\eclipse-workspace\\posnmobileorder\\src\\main\\java\\img\\s11.png")); // NOI18N

        lbStamp12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbStamp12.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\eclipse-workspace\\posnmobileorder\\src\\main\\java\\img\\s12.png")); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbStampNum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(lbStamp9, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbStamp10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(lbStamp5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbStamp6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(lbStamp1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbStamp2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbStamp3, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(lbStamp7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbStamp11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbStamp4, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                            .addComponent(lbStamp8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbStamp12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbStampNum, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbStamp1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(lbStamp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbStamp3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbStamp4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbStamp5, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(lbStamp6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbStamp7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbStamp8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbStamp9, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(lbStamp10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbStamp11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbStamp12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout plMiddleStampLayout = new javax.swing.GroupLayout(plMiddleStamp);
        plMiddleStamp.setLayout(plMiddleStampLayout);
        plMiddleStampLayout.setHorizontalGroup(
            plMiddleStampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plMiddleStampLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        plMiddleStampLayout.setVerticalGroup(
            plMiddleStampLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plMiddleStampLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(455, Short.MAX_VALUE))
        );

        plMiddle.add(plMiddleStamp, "stamp");

        plMiddleBasket.setBackground(new java.awt.Color(254, 254, 254));

        jPanel16.setBackground(new java.awt.Color(254, 254, 254));

        lbStoreName3.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lbStoreName3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbStoreName3.setText("장바구니");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbStoreName3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbStoreName3, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        jPanel17.setBackground(new java.awt.Color(254, 254, 254));
        jPanel17.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel17.setFocusable(false);

        btPayCard.setBackground(new java.awt.Color(250, 110, 71));
        btPayCard.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        btPayCard.setForeground(new java.awt.Color(255, 255, 255));
        btPayCard.setText("구매하기");
        btPayCard.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btAddPd.setBackground(new java.awt.Color(254, 254, 254));
        btAddPd.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        btAddPd.setText("추가주문");
        btAddPd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btAllCancel.setBackground(new java.awt.Color(254, 254, 254));
        btAllCancel.setFont(new java.awt.Font("맑은 고딕", 1, 12)); // NOI18N
        btAllCancel.setText("전체취소");
        btAllCancel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbBasketTotal.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lbBasketTotal.setForeground(new java.awt.Color(250, 110, 71));
        lbBasketTotal.setText("0원");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbBasketTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btAllCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAddPd, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btPayCard, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbBasketTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(btAllCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btAddPd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btPayCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jScrollPane5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        plBasket.setBackground(new java.awt.Color(254, 254, 254));

        javax.swing.GroupLayout plBasketLayout = new javax.swing.GroupLayout(plBasket);
        plBasket.setLayout(plBasketLayout);
        plBasketLayout.setHorizontalGroup(
            plBasketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 431, Short.MAX_VALUE)
        );
        plBasketLayout.setVerticalGroup(
            plBasketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 626, Short.MAX_VALUE)
        );

        jScrollPane5.setViewportView(plBasket);

        javax.swing.GroupLayout plMiddleBasketLayout = new javax.swing.GroupLayout(plMiddleBasket);
        plMiddleBasket.setLayout(plMiddleBasketLayout);
        plMiddleBasketLayout.setHorizontalGroup(
            plMiddleBasketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane5)
        );
        plMiddleBasketLayout.setVerticalGroup(
            plMiddleBasketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plMiddleBasketLayout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5))
        );

        plMiddle.add(plMiddleBasket, "menu");

        plMiddleReceipt.setBackground(new java.awt.Color(254, 254, 254));

        jPanel18.setBackground(new java.awt.Color(254, 254, 254));

        lbStoreName4.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        lbStoreName4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbStoreName4.setText("구매내역");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbStoreName4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbStoreName4, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
        );

        jPanel19.setBackground(new java.awt.Color(254, 254, 254));
        jPanel19.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel19.setFocusable(false);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jScrollPane6.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        plReceipt.setBackground(new java.awt.Color(254, 254, 254));

        javax.swing.GroupLayout plReceiptLayout = new javax.swing.GroupLayout(plReceipt);
        plReceipt.setLayout(plReceiptLayout);
        plReceiptLayout.setHorizontalGroup(
            plReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 431, Short.MAX_VALUE)
        );
        plReceiptLayout.setVerticalGroup(
            plReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 626, Short.MAX_VALUE)
        );

        jScrollPane6.setViewportView(plReceipt);

        javax.swing.GroupLayout plMiddleReceiptLayout = new javax.swing.GroupLayout(plMiddleReceipt);
        plMiddleReceipt.setLayout(plMiddleReceiptLayout);
        plMiddleReceiptLayout.setHorizontalGroup(
            plMiddleReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane6)
        );
        plMiddleReceiptLayout.setVerticalGroup(
            plMiddleReceiptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plMiddleReceiptLayout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6))
        );

        plMiddle.add(plMiddleReceipt, "menu");

        plMiddleCoupon.setBackground(new java.awt.Color(254, 254, 254));

        jLabel21.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("쿠폰");

        jPanel13.setBackground(new java.awt.Color(254, 254, 254));

        jLabel11.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        jLabel11.setText("음료 한잔 무료 쿠폰");

        lbCouponCnt.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        lbCouponCnt.setForeground(new java.awt.Color(250, 110, 71));
        lbCouponCnt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbCouponCnt.setText("0개");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                .addComponent(lbCouponCnt, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbCouponCnt, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(283, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout plMiddleCouponLayout = new javax.swing.GroupLayout(plMiddleCoupon);
        plMiddleCoupon.setLayout(plMiddleCouponLayout);
        plMiddleCouponLayout.setHorizontalGroup(
            plMiddleCouponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plMiddleCouponLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        plMiddleCouponLayout.setVerticalGroup(
            plMiddleCouponLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plMiddleCouponLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(455, Short.MAX_VALUE))
        );

        plMiddle.add(plMiddleCoupon, "stamp");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(plBottom, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(plMiddle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(plMiddle, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(plBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCoffeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCoffeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btCoffeeActionPerformed

    private void lbHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHomeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbHomeMouseClicked

    private void tfSignupPwd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSignupPwd2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSignupPwd2ActionPerformed

    private void tfSignupNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSignupNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSignupNameActionPerformed

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
            java.util.logging.Logger.getLogger(MobileHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MobileHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MobileHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MobileHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MobileHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GroupIH;
    private javax.swing.JButton btAddBasket;
    private javax.swing.JButton btAddPd;
    private javax.swing.JButton btAde;
    private javax.swing.JButton btAllCancel;
    private javax.swing.JButton btCoffee;
    private javax.swing.JButton btIced;
    private javax.swing.JButton btLogin;
    private javax.swing.JButton btLoginSign;
    private javax.swing.JButton btMin1;
    private javax.swing.JButton btNoncoffee;
    private javax.swing.JButton btPayCard;
    private javax.swing.JButton btPlu1;
    private javax.swing.JButton btSide;
    private javax.swing.JButton btSignupIdCheck;
    private javax.swing.JButton btSignupSignup;
    private javax.swing.JButton btTea;
    private javax.swing.JPanel cvCard1;
    private javax.swing.JPanel cvCard2;
    private javax.swing.JPanel cvCard3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JLabel lbAddpdImg;
    private javax.swing.JLabel lbAddpdName;
    private javax.swing.JLabel lbAddpdNum;
    private javax.swing.JLabel lbAddpdPrice;
    private javax.swing.JLabel lbBasketTotal;
    private javax.swing.JLabel lbCouponCnt;
    private javax.swing.JLabel lbHome;
    private javax.swing.JLabel lbHomeCname;
    private javax.swing.JLabel lbHomeCoupon;
    private javax.swing.JLabel lbHomeStamp;
    private javax.swing.JLabel lbMy;
    private javax.swing.JLabel lbMyCoupon;
    private javax.swing.JLabel lbMyInfo;
    private javax.swing.JLabel lbMyLogout;
    private javax.swing.JLabel lbMyName;
    private javax.swing.JLabel lbMyRecep;
    private javax.swing.JLabel lbMyStamp;
    private javax.swing.JLabel lbOrder;
    private javax.swing.JLabel lbStamp1;
    private javax.swing.JLabel lbStamp10;
    private javax.swing.JLabel lbStamp11;
    private javax.swing.JLabel lbStamp12;
    private javax.swing.JLabel lbStamp2;
    private javax.swing.JLabel lbStamp3;
    private javax.swing.JLabel lbStamp4;
    private javax.swing.JLabel lbStamp5;
    private javax.swing.JLabel lbStamp6;
    private javax.swing.JLabel lbStamp7;
    private javax.swing.JLabel lbStamp8;
    private javax.swing.JLabel lbStamp9;
    private javax.swing.JLabel lbStampNum;
    private javax.swing.JLabel lbStoreName;
    private javax.swing.JLabel lbStoreName1;
    private javax.swing.JLabel lbStoreName3;
    private javax.swing.JLabel lbStoreName4;
    private javax.swing.JList<String> listGugun;
    private javax.swing.JList<String> listSi;
    private javax.swing.JList<String> listStore;
    private javax.swing.JPanel plBasket;
    private javax.swing.JPanel plBottom;
    private javax.swing.JPanel plCv;
    private javax.swing.JPanel plMenu;
    private javax.swing.JPanel plMiddle;
    private javax.swing.JPanel plMiddleAddpd;
    private javax.swing.JPanel plMiddleBasket;
    private javax.swing.JPanel plMiddleCoupon;
    private javax.swing.JPanel plMiddleHome;
    private javax.swing.JPanel plMiddleLogin;
    private javax.swing.JPanel plMiddleMenuSelect;
    private javax.swing.JPanel plMiddleMy;
    private javax.swing.JPanel plMiddleReceipt;
    private javax.swing.JPanel plMiddleSample1;
    private javax.swing.JPanel plMiddleSignUp;
    private javax.swing.JPanel plMiddleStamp;
    private javax.swing.JPanel plMiddleStoreSelect;
    private javax.swing.JPanel plMiddleStoreSelect2;
    private javax.swing.JPanel plReceipt;
    private javax.swing.JRadioButton radiobtHot;
    private javax.swing.JRadioButton radiobtIce;
    private javax.swing.JTextField tfLoginId;
    private javax.swing.JPasswordField tfLoginPw;
    private javax.swing.JFormattedTextField tfSignupBirth;
    private javax.swing.JTextField tfSignupId;
    private javax.swing.JTextField tfSignupName;
    private javax.swing.JTextField tfSignupPwd1;
    private javax.swing.JTextField tfSignupPwd2;
    private javax.swing.JFormattedTextField tfSignupTel;
    // End of variables declaration//GEN-END:variables

    
    private class MemberEvent implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                if(e.getSource()==btLogin){
                        loginProc();
                }else if(e.getSource()==btLoginSign){
                    showSign();
                }else if(e.getSource()==btSignupSignup){
                    register();
                }else if(e.getSource()==btSignupIdCheck){
                    signIdCheck();
                }
            }catch (SQLException ex) {
                Logger.getLogger(MobileHome.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    private void signIdCheck() throws SQLException{
        if(!loginCheck){
            
            String userid = tfSignupId.getText();
            if(userid==null || userid.isEmpty() || userid.equals("아이디")){
                JOptionPane.showMessageDialog(this, "아이디를 입력하세요");
                tfLoginId.requestFocus();
                return;
            }
            int idc = memberDao.memberIdCheck(userid);
            if(idc==-1){
                JOptionPane.showMessageDialog(this, "이미 사용중인 아이디 입니다.");
                tfSignupId.setText("");
                tfSignupId.requestFocus();
                return;
            }else{
                JOptionPane.showMessageDialog(this, "사용가능한 아이디 입니다.");
                return;
            }
        }
        
    }
    private void register() throws SQLException{
        if(!loginCheck){
            String userid = tfSignupId.getText();
            String pwd1 = tfSignupPwd1.getText();
            String pwd2 = tfSignupPwd2.getText();
            String name = tfSignupName.getText();
            String tel = tfSignupTel.getText();
            String birth = tfSignupBirth.getText();
            
            if(name==null || name.isEmpty()){
                JOptionPane.showMessageDialog(this, "이름을 입력하세요");
                tfSignupName.requestFocus();
                return;
            }
            if(userid==null || userid.isEmpty()){
                JOptionPane.showMessageDialog(this, "아이디를 입력하세요");
                tfLoginId.requestFocus();
                return;
            }
            if(pwd1==null || pwd1.isEmpty()){
                JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요");
                tfSignupPwd1.requestFocus();
                return;
            }
            if(!pwd1.equals(pwd2)){
                JOptionPane.showMessageDialog(this, "비밀번호 확인이 일치하지 않습니다");
                return;
            }
            int idc = memberDao.memberIdCheck(userid);
            if(idc==-1){
                JOptionPane.showMessageDialog(this, "이미 사용중인 아이디 입니다.");
                tfSignupId.setText("");
                tfSignupId.requestFocus();
                return;
            }
            MemberDTO dto = new MemberDTO();
            dto.setMem_name(name);
            dto.setMem_id(userid);
            dto.setMem_pw(pwd1);
            dto.setMem_birth(birth);
            dto.setMem_tel(tel);
            dto.setMem_coupon(0);
            dto.setMem_stamp(0);
            
            int telc = memberDao.memberTelCheck(tel);
            String teltempc = memberDao.memberTelTempCheck(tel);
            if(telc==-1){
                if(teltempc.equals("임시")){
                    int rs = memberDao.updateMember(dto);
                    JOptionPane.showMessageDialog(this, "회원가입이 완료되었습니다.");
                    cl1.show(plMiddle, "login");
                    return;
                }else{
                    JOptionPane.showMessageDialog(this, "이미 사용중인 전화번호 입니다.");
                    tfSignupTel.setText("");
                    tfSignupTel.requestFocus();
                    return;
                }
            }


            int cnt = memberDao.insertMember(dto);
            if(cnt>0){
                JOptionPane.showMessageDialog(this, "회원가입이 완료되었습니다");
                cl1.show(plMiddle, "login");
            }else{
                JOptionPane.showMessageDialog(this, "회원가입 실패");
            }
            
        }else if(loginCheck){
            String userid = tfSignupId.getText();
            String pwd1 = tfSignupPwd1.getText();
            String pwd2 = tfSignupPwd2.getText();
            String name = tfSignupName.getText();
            String tel = tfSignupTel.getText();
            String birth = tfSignupBirth.getText();
            
            if(name==null || name.isEmpty()){
                JOptionPane.showMessageDialog(this, "이름을 입력하세요");
                tfSignupName.requestFocus();
                return;
            }
            if(userid==null || userid.isEmpty()){
                JOptionPane.showMessageDialog(this, "아이디를 입력하세요");
                tfLoginId.requestFocus();
                return;
            }
            if(pwd1==null || pwd1.isEmpty()){
                JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요");
                tfSignupPwd1.requestFocus();
                return;
            }
            if(!pwd1.equals(pwd2)){
                JOptionPane.showMessageDialog(this, "비밀번호 확인이 일치하지 않습니다");
                return;
            }

            MemberDTO dto = new MemberDTO();
            dto.setMem_name(name);
            dto.setMem_id(userid);
            dto.setMem_pw(pwd1);
            dto.setMem_birth(birth);
            dto.setMem_tel(tel);
            dto.setMem_coupon(0);
            dto.setMem_stamp(0);
            
            int telc = memberDao.memberTelCheck(tel);
            String teltempc = memberDao.memberTelTempCheck(tel);
            if(telc==-1){
                if(teltempc.equals(userid)){
                    int rs = memberDao.updateMember(dto);
                    JOptionPane.showMessageDialog(this, "회원정보 수정이 완료되었습니다.");
                    memberDto = memberDao.searchById(userid);
                    userInfoSet();
                    cl1.show(plMiddle, "my");
                    return;
                }else{
                    JOptionPane.showMessageDialog(this, "이미 사용중인 전화번호 입니다.");
                    tfSignupTel.setText("");
                    tfSignupTel.requestFocus();
                    return;
                }
            }else{
                int rs = memberDao.updateMember(dto);
                JOptionPane.showMessageDialog(this, "회원정보 수정이 완료되었습니다.");
                memberDto = memberDao.searchById(userid);
                userInfoSet();
                cl1.show(plMiddle, "my");
            }
        }
        
    }
    private void showSign(){
        cl1.show(plMiddle, "signup");
        if(loginCheck){
            jLabel12.setText("내 정보 수정");
            tfSignupId.setEditable(false);
            tfSignupId.setText(memberDto.getMem_id());
            btSignupIdCheck.setText("");
            tfSignupPwd1.setEditable(true);
            tfSignupPwd1.setText("비밀번호");
            tfSignupPwd2.setEditable(true);
            tfSignupPwd2.setText("비밀번호 확인");
            tfSignupName.setEditable(true);
            tfSignupName.setText("이름 (실명입력)");
            tfSignupTel.setEditable(true);
            try {
                    tfSignupTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-####-####")));
                } catch (java.text.ParseException ex) {
                    ex.printStackTrace();
                }
            tfSignupTel.setText(memberDto.getMem_tel());
            tfSignupBirth.setEditable(true);
            try {
                tfSignupBirth.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("***********")));
            } catch (java.text.ParseException ex) {
                ex.printStackTrace();
            }
            tfSignupBirth.setText("생년월일 (6자리) ");
            btSignupSignup.setText("내 정보 수정");
        }else if(!loginCheck){
            jLabel12.setText("회원가입");
            tfSignupId.setEditable(true);
            tfSignupId.setText("아이디");
            btSignupIdCheck.setText("중복확인");
            tfSignupPwd1.setEditable(true);
            tfSignupPwd1.setText("비밀번호");
            tfSignupPwd2.setEditable(true);
            tfSignupPwd2.setText("비밀번호 확인");
            tfSignupName.setEditable(true);
            tfSignupName.setText("이름 (실명입력)");
            tfSignupTel.setEditable(true);
            try {
                tfSignupTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("******")));
            } catch (java.text.ParseException ex) {
                ex.printStackTrace();
            }
            tfSignupTel.setText("휴대전화번호");
            tfSignupBirth.setEditable(true);
            try {
                tfSignupBirth.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("***********")));
            } catch (java.text.ParseException ex) {
                ex.printStackTrace();
            }
            tfSignupBirth.setText("생년월일 (6자리) ");
            btSignupSignup.setText("회원가입");
            
        }
    }
    private class MenuEvent extends MouseAdapter implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) { 
                if(e.getSource()==btCoffee){
                    showByCateno(1);
                }else if(e.getSource()==btNoncoffee){
                    showByCateno(2);
                }else if(e.getSource()==btIced){
                    showByCateno(3);
                }else if(e.getSource()==btAde){
                    showByCateno(4);
                }else if(e.getSource()==btTea){
                    showByCateno(5);
                }else if(e.getSource()==btSide){
                    showByCateno(6);
                    //showOding();
                }else if(e.getSource()==btPlu1){
                    int num = Integer.parseInt(lbAddpdNum.getText());
                    int price = Integer.parseInt(lbAddpdPrice.getText());
                    price /= num;
                    num+=1;
                    lbAddpdNum.setText(Integer.toString(num));
                    price *= num;
                    lbAddpdPrice.setText(Integer.toString(price));
                }else if(e.getSource()==btMin1){
                    int num = Integer.parseInt(lbAddpdNum.getText());
                    int price = Integer.parseInt(lbAddpdPrice.getText());
                    if(num==1){
                        return;
                    }
                    price /= num;
                    num-=1;
                    lbAddpdNum.setText(Integer.toString(num));
                    price *= num;
                    lbAddpdPrice.setText(Integer.toString(price));
                }else if(e.getSource()==btAddBasket){
                    String ice = "";
                    if(radiobtHot.isSelected()){
                        ice = "H";
                    }else if(radiobtIce.isSelected()){
                        ice = "I";
                    }
                    String[] arr = {lbAddpdName.getText(),ice,lbAddpdNum.getText(),lbAddpdPrice.getText()};
                    basketList.add(arr);
                    cl1.show(plMiddle,"basket");
                    showBasket();
                    
                }else if(e.getSource()==btAddPd){
                    cl1.show(plMiddle, "menu");
                }else if(e.getSource()==btAllCancel){
                    cl1.show(plMiddle,"home");
                    basketList = new ArrayList<String[]>();
                }else if(e.getSource()==btPayCard){
                    payCard();
                    for(int i = 0; i<basketList.size(); i++){
                        receiptList.add(basketList.get(i));
                    }
                    basketList = new ArrayList<String[]>();
                    cl1.show(plMiddle,"receipt");
                    showReceipt();
                    mh.showOding();
                    JOptionPane.showMessageDialog(mh, "모바일 오더가 들어왔습니다");
                }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource()==plMenu){
                cl1.show(plMiddle, "addpd");
                int low = e.getY();
                double dlow = Math.floor(low/132);
                low = (int)dlow;
                showAddPd(low);
                
            }
        }
        
    }
    
    private void payCard(){
        try{
            
            String IO = "N";
            int type = JOptionPane.showConfirmDialog(moh, "매장이용 여부","",JOptionPane.YES_NO_OPTION);
            if(type==JOptionPane.YES_OPTION){
                IO = "Y";
            }
            String cardNum = JOptionPane.showInputDialog("카드번호를 입력하세요");
            String sprice = lbBasketTotal.getText();
            sprice = sprice.substring(0, sprice.indexOf(" 원"));
            int iprice = Integer.parseInt(sprice);
            int cardCnt = mh.getCardCnt();
            cardCnt+=iprice;
            mh.setCardCnt(cardCnt);
            int od = oddtDao.insertOd(mh.getStno(), iprice);
            int odnum = oddtDao.lastOd();
            int oding = oddtDao.insertOdding(odnum);
            int to = oddtDao.insertTo(mh.getStno(), iprice, cardNum,odnum);

            OddtDTO dto = new OddtDTO();

            for(int i = 0; i<basketList.size(); i++) {
                String[] arr = basketList.get(i);
////////////////////////////////////////////////////////////////////////////////////////////////
                dto.setOddt_name(arr[0]);
                dto.setOddt_ice(arr[1]);  
                String num = arr[2];
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

            for(int i = 0; i<basketList.size(); i++) {
                String[] arr = basketList.get(i);
                String price = arr[3];
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
            userInfoSet();
        }catch (SQLException ex){
                Logger.getLogger(MainHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void showAddPd(int low){
        ProductDTO dto = menuPdList.get(low);
        lbAddpdName.setText(dto.getPd_name());
        lbAddpdPrice.setText(dto.getPd_price()+"");
        lbAddpdNum.setText("1");
        lbAddpdImg.setIcon(new javax.swing.ImageIcon(dto.getPd_img()));
    }
    private void showReceipt(){
        try {
            
            int row = receiptList.size();
            plReceipt.removeAll();
            plReceipt.setLayout(new GridLayout(row,1));
            
            for(int i = 0; i<row; i++){
                String[] arr = receiptList.get(i);
                ProductDTO dto = productDao.searchByNameInMobile(arr[0]);
                JPanel tpl1 = new JPanel(new BorderLayout());
                tpl1.setBackground(Color.white);
                tpl1.setSize(431,132);
                JLabel tj11 = new JLabel("");
                tj11.setIcon(new javax.swing.ImageIcon(dto.getPd_img()));
                JLabel tj21 = new JLabel();
                tj21.setText(dto.getPd_name()+"      "+arr[1]+"      "+arr[2]+"개     "+arr[3]+" 원");
                tj21.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
                tj21.setBackground(Color.white);
                tpl1.add(tj21,"East");
                tpl1.add(tj11,"West");
                plReceipt.add(tpl1);
            }

            
        } catch (SQLException ex) {
            Logger.getLogger(MobileHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void showBasket(){
        try {
            
            int row = basketList.size();
            plBasket.removeAll();
            plBasket.setLayout(new GridLayout(row,1));
            int total = 0;
            for(int i = 0; i<row; i++){
                String[] arr = basketList.get(i);
                ProductDTO dto = productDao.searchByNameInMobile(arr[0]);
                JPanel tpl1 = new JPanel(new BorderLayout());
                tpl1.setBackground(Color.white);
                tpl1.setSize(431,132);
                JLabel tj11 = new JLabel("");
                tj11.setIcon(new javax.swing.ImageIcon(dto.getPd_img()));
                JLabel tj21 = new JLabel();
                tj21.setText(dto.getPd_name()+"      "+arr[1]+"      "+arr[2]+"개     "+arr[3]+" 원");
                tj21.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
                tj21.setBackground(Color.white);
                tpl1.add(tj21,"East");
                tpl1.add(tj11,"West");
                plBasket.add(tpl1);
                
                String sprice = arr[3];
                int iprice = Integer.parseInt(sprice);
                total+=iprice;
            }
            lbBasketTotal.setText(total+" 원");

            
        } catch (SQLException ex) {
            Logger.getLogger(MobileHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void showByCateno(int cateno){
        try {
            List<ProductDTO> list = productDao.selectByCatenoInMobile(cateno);
            int row = list.size();
            plMenu.removeAll();
            plMenu.setLayout(new GridLayout(row,1));
            menuPdList = new ArrayList<ProductDTO>();
            
            for(int i = 0; i<list.size(); i++){
                ProductDTO dto = list.get(i);
                JPanel tpl1 = new JPanel(new BorderLayout());
                tpl1.setBackground(Color.white);
                tpl1.setSize(431,132);
                JLabel tj11 = new JLabel("");
                tj11.setIcon(new javax.swing.ImageIcon(dto.getPd_img()));
                JLabel tj21 = new JLabel();
                tj21.setText(dto.getPd_name()+"      "+dto.getPd_price()+" 원");
                tj21.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
                tj21.setBackground(Color.white);
                tpl1.add(tj21,"East");
                tpl1.add(tj11,"West");
                plMenu.add(tpl1);
                menuPdList.add(dto);
            }

            
        } catch (SQLException ex) {
            Logger.getLogger(MobileHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void loginProc() throws SQLException{
        if(!loginCheck){
            
            String userid = tfLoginId.getText();
            String pwd = tfLoginPw.getText();

            if(userid==null || userid.isEmpty()){
                JOptionPane.showMessageDialog(this, "아이디를 입력하세요");
                tfLoginId.requestFocus();
                return;
            }
            if(pwd==null||pwd.isEmpty()){
                JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요");
                tfLoginPw.requestFocus();
                return;
            }
            int result = memberDao.loginCheck(userid, pwd);

            if(result == StoreService.LOGIN_OK){
                JOptionPane.showMessageDialog(this, userid+"로 로그인되었습니다");
                memberDto = memberDao.searchById(userid);
                loginCheck = true;
                userInfoSet();
                cl1.show(plMiddle, "home");
                iconSet(1);

            }else if(result == StoreService.NONE_USERID){
                JOptionPane.showMessageDialog(this, "해당 아이디가 존재하지 않습니다");
            }else if(result==StoreService.PWD_DISAGREE){
                JOptionPane.showMessageDialog(this, "비밀번호가 일치하지 않습니다");
            }else{
                JOptionPane.showMessageDialog(this, "로그인 처리 실패");
            }
        }else if(loginCheck){
            JOptionPane.showMessageDialog(this, "로그아웃 되었습니다");
            memberDto = new MemberDTO();
            loginCheck = false;
            userInfoSet();
            cl1.show(plMiddle,"home");
            iconSet(1);
        }
    }
    
    
    private class MouseEventHandler extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource()== jLabel1){
                cl1.next(plMiddle);
            }
            else if(e.getSource() == lbOrder){
                
                if(!loginCheck){
                    cl1.show(plMiddle, "login");
                    tfLoginId.setText("");
                    tfLoginPw.setText("");
                    
                }else if(loginCheck){
                    cl1.show(plMiddle, "store");
                    iconSet(2);
                    showStoreSi();
                    showStoreGu("서울특별시");
                    listStore.setVisible(false);     
                }  
            }
            else if(e.getSource() == lbMy){
                if(!loginCheck){
                    cl1.show(plMiddle, "login");
                }else if(loginCheck){
                    cl1.show(plMiddle, "my");
                    iconSet(3);
                }
            }
            else if(e.getSource() == lbHome){
                cl1.show(plMiddle,"home");
                iconSet(1);
            }
            if(e.getSource() == listSi){
                String si = listSi.getSelectedValue();
                showStoreGu(si);
                listStore.setVisible(false);
            }
            if(e.getSource()==listGugun){
                String si = listSi.getSelectedValue();
                String gu = listGugun.getSelectedValue();
                listStore.setVisible(true);
                showStoreDong(si, gu);
            }
            try{
                if(e.getSource() == listStore){
                    String stname = listStore.getSelectedValue();
                    int stno = storeDao.getStnoByName(stname);
                    if(StoreService.openList.get(stno)==null){
                        JOptionPane.showMessageDialog(moh, "해당 매장 개점 전 입니다.");
                        return;
                    }
                    mh = StoreService.openList.get(stno);
                    cl1.show(plMiddle, "menu");
                    lbStoreName.setText(stname);
                }
                
            }catch(SQLException ex){
                
            }
            if(e.getSource() == tfSignupTel || e.getSource()==tfSignupId
                                 || e.getSource()==tfSignupName || e.getSource()==tfSignupPwd1
                                 || e.getSource()==tfSignupPwd2 || e.getSource()==tfSignupBirth){
                resetSignForm();
            }
        }
    }
    
    private class MyMouseEvent extends MouseAdapter{

        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource() == lbMyLogout){
                try {
                    loginProc();
                } catch (SQLException ex) {
                    Logger.getLogger(MobileHome.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if(e.getSource() == lbMyStamp){
                cl1.show(plMiddle, "stamp");
            }else if(e.getSource() == lbMyCoupon){
                cl1.show(plMiddle,"coupon");
            }else if(e.getSource() == lbMyRecep){
                cl1.show(plMiddle,"receipt");
            }else if(e.getSource() == lbMyInfo){
                showSign();
            }
        }
        
    }
    
    public void resetSignForm(){
        System.out.println(tfSignupBirth.getText());
        if(!tfSignupId.hasFocus() && tfSignupId.getText().equals("")){
            tfSignupId.setText("아이디");
        }
        if(!tfSignupPwd1.hasFocus() && tfSignupPwd1.getText().equals("")){
            tfSignupPwd1.setText("비밀번호");
        }
        if(!tfSignupPwd2.hasFocus() && tfSignupPwd2.getText().equals("")){
            tfSignupPwd2.setText("비밀번호 확인");
        }
        if(!tfSignupName.hasFocus() && tfSignupName.getText().equals("")){
            tfSignupName.setText("이름 (실명입력)");
        }
        if(!tfSignupTel.hasFocus() && tfSignupTel.getText().equals("   -    -    ")){
            try {
                tfSignupTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("******")));
            } catch (java.text.ParseException ex) {
                ex.printStackTrace();
            }
            tfSignupTel.setText("휴대전화번호");
        }
        if(!tfSignupBirth.hasFocus() && tfSignupBirth.getText().equals("      ")){
            try {
                tfSignupBirth.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("***********")));
            } catch (java.text.ParseException ex) {
                ex.printStackTrace();
            }
            tfSignupBirth.setText("생년월일 (6자리) ");
        }
        
        if(tfSignupTel.hasFocus()){
            if(tfSignupTel.getText().equals("휴대전화번호")){
                tfSignupTel.setText("");
                try {
                    tfSignupTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-####-####")));
                } catch (java.text.ParseException ex) {
                    ex.printStackTrace();
                }
                
            }
        }
        if(tfSignupBirth.hasFocus()){
            if(tfSignupBirth.getText().equals("생년월일 (6자리) ")){
                tfSignupBirth.setText("");
                try {
                    tfSignupBirth.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
                } catch (java.text.ParseException ex) {
                    ex.printStackTrace();
                }
                
            }
        }
        if(tfSignupId.hasFocus()){
            if(tfSignupId.getText().equals("아이디")){
                tfSignupId.setText("");
            }
        }
        if(tfSignupPwd1.hasFocus()){
            if(tfSignupPwd1.getText().equals("비밀번호")){
                tfSignupPwd1.setText("");
            }
        }
        if(tfSignupPwd2.hasFocus()){
            if(tfSignupPwd2.getText().equals("비밀번호 확인")){
                tfSignupPwd2.setText("");
            }
        }
        if(tfSignupName.hasFocus()){
            if(tfSignupName.getText().equals("이름 (실명입력)")){
                tfSignupName.setText("");
            }
        }
    }
    
    public void showStoreDong(String si, String gu){
        try{
            List<String> list = storeDao.getStoreDong(si, gu);
            String[] data = new String[list.size()];
            
            for(int i = 0; i<list.size(); i++){
                data[i] = list.get(i);
            }
            listStore.setListData(data);
            
        }catch(Exception ex){
            
        }
    }
    public void showStoreGu(String si){
        try{
            List<String> list = storeDao.getStoreGu(si);
            String[] data = new String[list.size()];
            
            for(int i = 0; i<list.size(); i++){
                data[i] = list.get(i);
            }
            listGugun.setListData(data);
            
        }catch(Exception ex){
            
        }
    }
    public void showStoreSi(){
        try{
            List<String> list = storeDao.getStoreSi();
            String[] data = new String[list.size()];
            
            for(int i = 0; i<list.size(); i++){
                data[i] = list.get(i);
            }
            listSi.setListData(data);
            
        }catch(Exception ex){
            
        }
    }
    private void iconSet(int a){
        if(a==1){
            lbMy.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\my1.png")); // NOI18N
            lbOrder.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\order1.png")); // NOI18N
            lbHome.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\phonehome2.png")); // NOI18N
        }else if(a==2){
            lbMy.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\my1.png")); // NOI18N
            lbOrder.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\order2.png")); // NOI18N
            lbHome.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\phonehome1.png")); // NOI18N
        }else if(a==3){
            lbMy.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\my2.png")); // NOI18N
            lbOrder.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\order1.png")); // NOI18N
            lbHome.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\phonehome1.png")); // NOI18N
        }
    }
    private void userInfoSet(){
        List<JLabel> list = new ArrayList<JLabel>();
        list.add(lbStamp1);
        list.add(lbStamp2);
        list.add(lbStamp3);
        list.add(lbStamp4);
        list.add(lbStamp5);
        list.add(lbStamp6);
        list.add(lbStamp7);
        list.add(lbStamp8);
        list.add(lbStamp9);
        list.add(lbStamp10);
        list.add(lbStamp11);
        list.add(lbStamp12);
        
        if(loginCheck){
            String userName = memberDto.getMem_name();
            int coupon = memberDto.getMem_coupon();
            int stamp = memberDto.getMem_stamp();
            
            lbHomeCname.setText(userName);
            lbHomeCoupon.setText(coupon+"");
            lbHomeStamp.setText(stamp+"/12");
            
            lbMyName.setText(userName);
            lbStampNum.setText(stamp+"/12");
            lbCouponCnt.setText(coupon+" 개");
            
            
            for(int i=0 ; i<12; i++){
                list.get(i).setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\s"+(i+1)+".png"));
            }
            for(int i=0 ; i<stamp; i++){
                list.get(i).setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\ss.png"));
            }
            
        }else if (!loginCheck){
            lbHomeCname.setText("Guest");
            lbHomeCoupon.setText("0");
            lbHomeStamp.setText("0/12");
            lbStampNum.setText("0/12");
            lbCouponCnt.setText("0 개");
            
            lbMyName.setText("Guest");
            lbStamp1.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\s1.png")); // NOI18N
            lbStamp2.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\s2.png")); // NOI18N
            lbStamp3.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\s3.png")); // NOI18N
            lbStamp4.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\s4.png")); // NOI18N
            lbStamp5.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\s5.png")); // NOI18N
            lbStamp6.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\s6.png")); // NOI18N
            lbStamp7.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\s7.png")); // NOI18N
            lbStamp8.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\s8.png")); // NOI18N
            lbStamp9.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\s9.png")); // NOI18N
            lbStamp10.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\s10.png")); // NOI18N
            lbStamp11.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\s11.png")); // NOI18N
            lbStamp12.setIcon(new javax.swing.ImageIcon("src\\main\\java\\img\\s12.png")); // NOI18N
        }
    } 
    private class CvThread implements Runnable{

        @Override
        public void run() {
            while(true){
                cl1.next(plCv);
                try{
                    Thread.sleep(2500);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
        
    }
}
