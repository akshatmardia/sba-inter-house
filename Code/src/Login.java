package src;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class Login extends JFrame {
    Connection con;
    PreparedStatement pst;
    PreparedStatement inst;
    PreparedStatement checkuser;
    ResultSet rs;
    boolean ch = false;
    String username = null;
    private JButton Next;
    private JPasswordField Password;
    private JButton ReEnter;
    private JTextField Username;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;

    public Login() {
        this.initComponents();
        this.setLocationRelativeTo((Component)null);
    }

    public void close() {
        WindowEvent winClosingEvent = new WindowEvent(this, 201);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

    private void initComponents() {
        this.jPanel3 = new JPanel();
        this.jLabel4 = new JLabel();
        this.jLabel5 = new JLabel();
        this.jLabel7 = new JLabel();
        this.jLabel6 = new JLabel();
        this.jPanel2 = new JPanel();
        this.jLabel3 = new JLabel();
        this.jPanel1 = new JPanel();
        this.Username = new JTextField();
        this.Password = new JPasswordField();
        this.jLabel2 = new JLabel();
        this.jLabel1 = new JLabel();
        this.ReEnter = new JButton();
        this.Next = new JButton();
        this.setDefaultCloseOperation(2);
        this.setBackground(new Color(255, 255, 255));
        this.setResizable(false);
        this.getContentPane().setLayout(new AbsoluteLayout());
        this.jPanel3.setBackground(new Color(0, 102, 153));
        this.jLabel4.setFont(new Font("Tahoma", 1, 36));
        this.jLabel4.setForeground(new Color(255, 255, 255));
        this.jLabel4.setText("-");
        this.jLabel5.setFont(new Font("Tahoma", 1, 36));
        this.jLabel5.setForeground(new Color(255, 255, 255));
        this.jLabel5.setText("Login Form");
        this.jLabel7.setFont(new Font("Tahoma", 1, 36));
        this.jLabel7.setForeground(new Color(255, 255, 255));
        this.jLabel7.setText("X");
        this.jLabel7.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                Login.this.jLabel7MouseClicked(evt);
            }
        });
        GroupLayout jPanel3Layout = new GroupLayout(this.jPanel3);
        this.jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel6, -2, 54, -2).addGap(12, 12, 12).addComponent(this.jLabel5).addPreferredGap(ComponentPlacement.RELATED, 209, 32767).addComponent(this.jLabel4).addGap(18, 18, 18).addComponent(this.jLabel7).addGap(56, 56, 56)));
        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel6, -1, -1, 32767).addContainerGap()).addGroup(Alignment.TRAILING, jPanel3Layout.createSequentialGroup().addContainerGap(30, 32767).addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.jLabel7).addComponent(this.jLabel5)).addGap(26, 26, 26)));
        this.getContentPane().add(this.jPanel3, new AbsoluteConstraints(0, 0, 600, 100));
        this.jPanel2.setBackground(new Color(255, 153, 0));
        this.jLabel3.setFont(new Font("Lucida Grande", 0, 28));
        this.jLabel3.setForeground(new Color(236, 240, 241));
        this.jLabel3.setText("Sign In");
        this.jPanel1.setBackground(new Color(255, 153, 0));
        this.jPanel1.setLayout(new AbsoluteLayout());
        this.Username.setBackground(new Color(108, 122, 137));
        this.Username.setFont(new Font("Lucida Grande", 0, 15));
        this.Username.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Login.this.UsernameActionPerformed(evt);
            }
        });
        this.Username.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                Login.this.UsernameKeyPressed(evt);
            }
        });
        this.jPanel1.add(this.Username, new AbsoluteConstraints(144, 6, 185, -1));
        this.Password.setBackground(new Color(108, 122, 137));
        this.Password.setFont(new Font("Lucida Grande", 0, 15));
        this.Password.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Login.this.PasswordActionPerformed(evt);
            }
        });
        this.Password.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                Login.this.PasswordKeyPressed(evt);
            }
        });
        this.jPanel1.add(this.Password, new AbsoluteConstraints(144, 53, 185, -1));
        this.jLabel2.setFont(new Font("Lucida Grande", 0, 18));
        this.jLabel2.setForeground(new Color(236, 240, 241));
        this.jLabel2.setText("Password");
        this.jPanel1.add(this.jLabel2, new AbsoluteConstraints(12, 55, -1, -1));
        this.jLabel1.setFont(new Font("Lucida Grande", 0, 18));
        this.jLabel1.setForeground(new Color(236, 240, 241));
        this.jLabel1.setText("Username");
        this.jPanel1.add(this.jLabel1, new AbsoluteConstraints(12, 8, -1, -1));
        this.ReEnter.setBackground(new Color(255, 255, 255));
        this.ReEnter.setText("Re-Enter");
        this.ReEnter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Login.this.ReEnterActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.ReEnter, new AbsoluteConstraints(66, 119, 84, 40));
        this.Next.setBackground(new Color(102, 153, 255));
        this.Next.setFont(new Font("Lucida Grande", 0, 14));
        this.Next.setForeground(new Color(255, 255, 255));
        this.Next.setText("Next");
        this.Next.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Login.this.NextActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.Next, new AbsoluteConstraints(189, 119, 84, 39));
        GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
        this.jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(247, 247, 247).addComponent(this.jLabel3)).addGroup(jPanel2Layout.createSequentialGroup().addGap(129, 129, 129).addComponent(this.jPanel1, -2, -1, -2))).addContainerGap(142, 32767)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(28, 28, 28).addComponent(this.jLabel3).addGap(35, 35, 35).addComponent(this.jPanel1, -2, -1, -2).addContainerGap(94, 32767)));
        this.getContentPane().add(this.jPanel2, new AbsoluteConstraints(0, 90, 600, 350));
        this.pack();
    }

    public void login() {
        String password = this.Password.getText();
        this.username = this.Username.getText();
        if (!this.username.equals("") && !password.equals("")) {
            try {
                this.con = src.MsAccessPro.Connection.getConnection();
                this.pst = this.con.prepareStatement("SELECT * FROM LoginTable WHERE username=? AND password=?");
                this.pst.setString(1, this.username);
                this.pst.setString(2, password);
                this.rs = this.pst.executeQuery();
                if (this.rs.next()) {
                    this.ch = true;
                } else {
                    JOptionPane.showMessageDialog((Component)null, "Invalid Login Detals", "Login Error", 0);
                }

                this.Username.setText((String)null);
                this.Password.setText((String)null);
                this.Username.requestFocus();
            } catch (Exception var3) {
                System.out.println("" + var3);
            }
        } else {
            JOptionPane.showMessageDialog((Component)null, "Either field is empty", "Login Error", 0);
            this.Username.setText((String)null);
            this.Password.setText((String)null);
            this.Username.requestFocus();
        }

    }

    private void NextActionPerformed(ActionEvent evt) {
        this.login();
        if (this.ch) {
            try {
                this.inst = this.con.prepareStatement("INSERT INTO LoginHistory (History) values (?)");
                this.inst.setString(1, this.username);
                this.inst.executeUpdate();
                String dbusername = this.rs.getString("username");
                WelcomePage welcome = new WelcomePage(dbusername);
                welcome.setVisible(true);
                this.setVisible(false);
            } catch (Exception var4) {
                System.out.println("" + var4);
            }
        }

    }

    private void PasswordActionPerformed(ActionEvent evt) {
    }

    private void ReEnterActionPerformed(ActionEvent evt) {
        this.Password.setText((String)null);
        this.Username.setText((String)null);
        this.Username.requestFocus();
    }

    private void UsernameActionPerformed(ActionEvent evt) {
    }

    private void PasswordKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.login();
            if (this.ch) {
                try {
                    this.inst = this.con.prepareStatement("INSERT INTO LoginHistory (History) values (?)");
                    this.inst.setString(1, this.username);
                    this.inst.executeUpdate();
                    String dbusername = this.rs.getString("username");
                    WelcomePage welcome = new WelcomePage(dbusername);
                    welcome.setVisible(true);
                    this.setVisible(false);
                } catch (Exception var4) {
                    System.out.println("" + var4);
                }
            }
        }

    }

    private void UsernameKeyPressed(KeyEvent evt) {
        if (evt.getKeyCode() == 10) {
            this.Password.requestFocus();
        }

    }

    private void jLabel7MouseClicked(MouseEvent evt) {
        System.exit(0);
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
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, (String)null, var5);
        } catch (InstantiationException var6) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, (String)null, var6);
        } catch (IllegalAccessException var7) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, (String)null, var7);
        } catch (UnsupportedLookAndFeelException var8) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, (String)null, var8);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new Login()).setVisible(true);
            }
        });
    }
}
