package src;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager.LookAndFeelInfo;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class VivasvanHouse extends JFrame {
    Connection con;
    PreparedStatement pst;
    PreparedStatement viv1;
    PreparedStatement viv2;
    PreparedStatement viv3;
    PreparedStatement viv4;
    PreparedStatement mulviv1;
    PreparedStatement mulviv2;
    PreparedStatement mulviv3;
    PreparedStatement mulviv4;
    PreparedStatement cal;
    ResultSet rs;
    int score;
    private JButton jButton1;
    private JButton jButton3;
    private JButton jButton6;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JTextField txtscore;

    public VivasvanHouse() {
        this.initComponents();
        this.setLocationRelativeTo((Component)null);
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jLabel1 = new JLabel();
        this.jButton1 = new JButton();
        this.jButton3 = new JButton();
        this.txtscore = new JTextField();
        this.jLabel2 = new JLabel();
        this.jButton6 = new JButton();
        this.setDefaultCloseOperation(3);
        this.jPanel1.setBackground(new Color(240, 229, 215));
        this.jPanel1.setLayout(new AbsoluteLayout());
        this.jLabel1.setFont(new Font("Lucida Grande", 0, 48));
        this.jLabel1.setText("Vivasvan House");
        this.jPanel1.add(this.jLabel1, new AbsoluteConstraints(10, 10, 360, 60));
        this.jButton1.setText("Back");
        this.jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                VivasvanHouse.this.jButton1ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.jButton1, new AbsoluteConstraints(180, 230, 110, 40));
        this.jButton3.setText("Calculate Score");
        this.jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                VivasvanHouse.this.jButton3ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.jButton3, new AbsoluteConstraints(270, 100, 130, 30));
        this.txtscore.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent evt) {
                VivasvanHouse.this.txtscoreFocusGained(evt);
            }
        });
        this.txtscore.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                VivasvanHouse.this.txtscoreMouseClicked(evt);
            }
        });
        this.txtscore.addInputMethodListener(new InputMethodListener() {
            public void caretPositionChanged(InputMethodEvent evt) {
            }

            public void inputMethodTextChanged(InputMethodEvent evt) {
                VivasvanHouse.this.txtscoreInputMethodTextChanged(evt);
            }
        });
        this.txtscore.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                VivasvanHouse.this.txtscoreKeyTyped(evt);
            }
        });
        this.jPanel1.add(this.txtscore, new AbsoluteConstraints(110, 120, 50, 30));
        this.jLabel2.setFont(new Font("Tahoma", 0, 14));
        this.jLabel2.setText("Total Score");
        this.jPanel1.add(this.jLabel2, new AbsoluteConstraints(30, 120, 80, 30));
        this.jButton6.setText("Display Score");
        this.jButton6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                VivasvanHouse.this.jButton6ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.jButton6, new AbsoluteConstraints(270, 140, 130, 30));
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -1, 464, 32767));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -1, 327, 32767));
        this.pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        this.dispose();
        (new House_Points()).setVisible(true);
    }

    public void Insert() {
        try {
            this.con = src.MsAccessPro.Connection.getConnection();
            this.viv1 = this.con.prepareStatement("INSERT INTO Vivasvan (4P) SELECT [Winrno] FROM Events INNER JOIN Students ON Events.Winrno=Students.Rno WHERE Students.House='Vivasvan'");
            this.viv2 = this.con.prepareStatement("INSERT INTO Vivasvan (3P) SELECT [Runup1] FROM Events INNER JOIN Students ON Events.Runup1=Students.Rno WHERE Students.House='Vivasvan'");
            this.viv3 = this.con.prepareStatement("INSERT INTO Vivasvan (2P) SELECT [Runup2] FROM Events INNER JOIN Students ON Events.Runup2=Students.Rno WHERE Students.House='Vivasvan'");
            this.viv4 = this.con.prepareStatement("INSERT INTO Vivasvan (1P) SELECT [Runup3] FROM Events INNER JOIN Students ON Events.Runup3=Students.Rno WHERE Students.House='Vivasvan'");
            this.viv1.executeUpdate();
            this.viv2.executeUpdate();
            this.viv3.executeUpdate();
            this.viv4.executeUpdate();
        } catch (SQLException var2) {
            System.out.println("" + var2);
        }

    }

    public void Multiply() {
        try {
            this.con = src.MsAccessPro.Connection.getConnection();
            this.mulviv1 = this.con.prepareStatement("INSERT INTO TotalPoints ( Vivasvan ) SELECT Count([4P])*4 FROM Vivasvan WHERE [4P]<>0");
            this.mulviv2 = this.con.prepareStatement("INSERT INTO TotalPoints ( Vivasvan ) SELECT Count([3P])*3 FROM Vivasvan WHERE [3P]<>0");
            this.mulviv3 = this.con.prepareStatement("INSERT INTO TotalPoints ( Vivasvan ) SELECT Count([2P])*2 FROM Vivasvan WHERE [2P]<>0");
            this.mulviv4 = this.con.prepareStatement("INSERT INTO TotalPoints ( Vivasvan ) SELECT Count([1P])*1 FROM Vivasvan WHERE [1P]<>0");
            this.mulviv1.executeUpdate();
            this.mulviv2.executeUpdate();
            this.mulviv3.executeUpdate();
            this.mulviv4.executeUpdate();
        } catch (SQLException var2) {
            System.out.println("" + var2);
        }

    }

    public void Sumdisplay() {
        try {
            this.con = src.MsAccessPro.Connection.getConnection();
            this.cal = this.con.prepareStatement("SELECT SUM (Vivasvan) FROM TotalPoints");
            this.rs = this.cal.executeQuery();
            this.rs.next();
            this.score = this.rs.getInt(1);
            String LA = Integer.toString(this.score);
            this.txtscore.setText(LA);
        } catch (SQLException var2) {
            System.out.println("" + var2);
        }

    }

    private void jButton3ActionPerformed(ActionEvent evt) {
        this.Insert();
        this.Multiply();
        this.jButton3.setEnabled(false);
    }

    private void txtscoreFocusGained(FocusEvent evt) {
        boolean a = this.txtscore.isEditable();
        if (a) {
            JOptionPane.showMessageDialog((Component)null, "You cannot edit this value");
            this.txtscore.setText("");
            this.txtscore.setFocusable(false);
        }

    }

    private void txtscoreInputMethodTextChanged(InputMethodEvent evt) {
    }

    private void txtscoreKeyTyped(KeyEvent evt) {
    }

    private void txtscoreMouseClicked(MouseEvent evt) {
    }

    private void jButton6ActionPerformed(ActionEvent evt) {
        this.Sumdisplay();
    }

    public static void main(String[] args) {
        try {
            LookAndFeelInfo[] var1 = UIManager.getInstalledLookAndFeels();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                LookAndFeelInfo info = var1[var3];
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException var5) {
            Logger.getLogger(VivasvanHouse.class.getName()).log(Level.SEVERE, (String)null, var5);
        } catch (InstantiationException var6) {
            Logger.getLogger(VivasvanHouse.class.getName()).log(Level.SEVERE, (String)null, var6);
        } catch (IllegalAccessException var7) {
            Logger.getLogger(VivasvanHouse.class.getName()).log(Level.SEVERE, (String)null, var7);
        } catch (UnsupportedLookAndFeelException var8) {
            Logger.getLogger(VivasvanHouse.class.getName()).log(Level.SEVERE, (String)null, var8);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new VivasvanHouse()).setVisible(true);
            }
        });
    }
}

