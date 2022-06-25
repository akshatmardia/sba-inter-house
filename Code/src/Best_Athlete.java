package src;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class Best_Athlete extends JFrame {
    Connection con;
    PreparedStatement u12;
    PreparedStatement u14;
    PreparedStatement u16;
    PreparedStatement a16;
    PreparedStatement bu12;
    PreparedStatement bu14;
    PreparedStatement bu16;
    PreparedStatement ba16;
    private JTable bestAthtable;
    private JButton bestath;
    private JButton jButton1;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;

    public Best_Athlete() {
        this.initComponents();
        this.setLocationRelativeTo((Component)null);
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jLabel1 = new JLabel();
        this.jButton1 = new JButton();
        this.bestath = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.bestAthtable = new JTable();
        this.setDefaultCloseOperation(3);
        this.jPanel1.setBackground(new Color(240, 229, 215));
        this.jPanel1.setLayout(new AbsoluteLayout());
        this.jLabel1.setFont(new Font("Lucida Grande", 0, 48));
        this.jLabel1.setText("Best Athlete");
        this.jPanel1.add(this.jLabel1, new AbsoluteConstraints(10, 10, 330, 60));
        this.jButton1.setText("Back");
        this.jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Best_Athlete.this.jButton1ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.jButton1, new AbsoluteConstraints(540, 380, 120, 40));
        this.bestath.setText("Best Athlete");
        this.bestath.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Best_Athlete.this.bestathActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.bestath, new AbsoluteConstraints(310, 320, 110, 30));
        this.bestAthtable.setModel(new DefaultTableModel(new Object[][]{{null, null, null, null}, {null, null, null, null}, {null, null, null, null}}, new String[]{"Under 12", "Under 14", "Under 16", "Above 16"}) {
            Class[] types = new Class[]{Integer.class, Integer.class, Integer.class, Integer.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }
        });
        this.jScrollPane1.setViewportView(this.bestAthtable);
        this.jPanel1.add(this.jScrollPane1, new AbsoluteConstraints(140, 130, -1, 130));
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -2, 717, -2));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -2, 449, -2));
        this.pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        this.dispose();
        (new Events()).setVisible(true);
    }

    private void bestathActionPerformed(ActionEvent evt) {
        int ok = JOptionPane.showConfirmDialog(this.rootPane, "Have all the events been added?", "", 0);
        if (ok == 0) {
            try {
                this.con = src.MsAccessPro.Connection.getConnection();
                this.u12 = this.con.prepareStatement("INSERT INTO Under12 SELECT [Winrno] FROM Events WHERE [Evcat]='Under 12'");
                this.u14 = this.con.prepareStatement("INSERT INTO Under14 SELECT [Winrno] FROM Events WHERE [Evcat]='Under 14'");
                this.u16 = this.con.prepareStatement("INSERT INTO Under16 SELECT [Winrno] FROM Events WHERE [Evcat]='Under 16'");
                this.a16 = this.con.prepareStatement("INSERT INTO Above16 SELECT [Winrno] FROM Events WHERE [Evcat]='Above 16'");
                this.u12.executeUpdate();
                this.u14.executeUpdate();
                this.u16.executeUpdate();
                this.a16.executeUpdate();
                this.bu12 = this.con.prepareStatement("INSERT INTO BestAth (Under12) SELECT TOP 1 Under12 FROM Under12 GROUP BY Under12 ORDER BY COUNT(*) DESC");
                this.bu14 = this.con.prepareStatement("INSERT INTO BestAth (Under14) SELECT TOP 1 Under14 FROM Under14 GROUP BY Under14 ORDER BY COUNT(*) DESC");
                this.bu16 = this.con.prepareStatement("INSERT INTO BestAth (Under16) SELECT TOP 1 Under16 FROM Under16 GROUP BY Under16 ORDER BY COUNT(*) DESC");
                this.ba16 = this.con.prepareStatement("INSERT INTO BestAth (Above16) SELECT TOP 1 Above16 FROM Above16 GROUP BY Above16 ORDER BY COUNT(*) DESC");
                this.bu12.executeUpdate();
                this.bu14.executeUpdate();
                this.bu16.executeUpdate();
                this.ba16.executeUpdate();
            } catch (Exception var4) {
                System.out.println("" + var4);
            }

            this.ShowData();
        }

    }

    public void ShowData() {
        try {
            this.con = src.MsAccessPro.Connection.getConnection();
            String sql = "Select Under12,Under14,Under16,Above16 from BestAth";
            PreparedStatement pst = this.con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            this.bestAthtable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception var4) {
            JOptionPane.showMessageDialog((Component)null, var4);
        }

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
            Logger.getLogger(Best_Athlete.class.getName()).log(Level.SEVERE, (String)null, var5);
        } catch (InstantiationException var6) {
            Logger.getLogger(Best_Athlete.class.getName()).log(Level.SEVERE, (String)null, var6);
        } catch (IllegalAccessException var7) {
            Logger.getLogger(Best_Athlete.class.getName()).log(Level.SEVERE, (String)null, var7);
        } catch (UnsupportedLookAndFeelException var8) {
            Logger.getLogger(Best_Athlete.class.getName()).log(Level.SEVERE, (String)null, var8);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new Best_Athlete()).setVisible(true);
            }
        });
    }
}

