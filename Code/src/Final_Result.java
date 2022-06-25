package src;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

public class Final_Result extends JFrame {
    Connection con;
    WelcomePage abcd;
    private JTable finaltable;
    private JButton graphbtn;
    private JButton jButton1;
    private JButton jButton3;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JButton pdfgen;

    public Final_Result() {
        this.initComponents();
        this.setLocationRelativeTo((Component)null);
        this.ShowData();
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.jPanel1 = new JPanel();
        this.jLabel2 = new JLabel();
        this.jScrollPane1 = new JScrollPane();
        this.finaltable = new JTable();
        this.pdfgen = new JButton();
        this.jButton3 = new JButton();
        this.graphbtn = new JButton();
        this.jButton1 = new JButton();
        this.jLabel1.setFont(new Font("Lucida Grande", 0, 48));
        this.jLabel1.setText("House Points");
        this.setDefaultCloseOperation(3);
        this.jPanel1.setBackground(new Color(240, 229, 215));
        this.jPanel1.setLayout(new AbsoluteLayout());
        this.jLabel2.setFont(new Font("Lucida Grande", 0, 48));
        this.jLabel2.setText("Final Result");
        this.jPanel1.add(this.jLabel2, new AbsoluteConstraints(250, 10, 260, 60));
        this.finaltable.setModel(new DefaultTableModel(new Object[][]{{null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}}, new String[]{"Aditya", "Bhaskar", "Martand", "Vivasvan"}) {
            Class[] types = new Class[]{Integer.class, Integer.class, Integer.class, Integer.class};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }
        });
        this.finaltable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                Final_Result.this.finaltableMouseClicked(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.finaltable);
        this.jPanel1.add(this.jScrollPane1, new AbsoluteConstraints(140, 130, -1, 110));
        this.pdfgen.setText("Generate PDF");
        this.pdfgen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Final_Result.this.pdfgenActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.pdfgen, new AbsoluteConstraints(320, 370, 110, 40));
        this.jButton3.setText("Back");
        this.jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Final_Result.this.jButton3ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.jButton3, new AbsoluteConstraints(320, 420, 110, 30));
        this.graphbtn.setText("Generate Graph");
        this.graphbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Final_Result.this.graphbtnActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.graphbtn, new AbsoluteConstraints(300, 320, 150, 40));
        this.jButton1.setText("Display Score");
        this.jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Final_Result.this.jButton1ActionPerformed(evt);
            }
        });
        this.jPanel1.add(this.jButton1, new AbsoluteConstraints(320, 270, 110, 40));
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -2, 742, -2));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jPanel1, -1, 461, 32767));
        this.pack();
    }

    private void pdfgenActionPerformed(ActionEvent evt) {
        String path = "";
        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(1);
        int x = j.showSaveDialog(this);
        if (x == 0) {
            path = j.getSelectedFile().getPath();
        }

        Document doc = new Document();

        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path + ".pdf"));
            doc.open();
            PdfPTable tbl = new PdfPTable(4);
            tbl.addCell("Aditya House");
            tbl.addCell("Bhaskar House");
            tbl.addCell("Martand House");
            tbl.addCell("Vivasvan House");

            for(int i = 0; i < this.finaltable.getRowCount(); ++i) {
                String aditya = this.finaltable.getValueAt(i, 0).toString();
                String bhaskar = this.finaltable.getValueAt(i, 1).toString();
                String martand = this.finaltable.getValueAt(i, 2).toString();
                String vivasvan = this.finaltable.getValueAt(i, 3).toString();
                tbl.addCell(aditya);
                tbl.addCell(bhaskar);
                tbl.addCell(martand);
                tbl.addCell(vivasvan);
            }

            doc.add(tbl);
        } catch (DocumentException | FileNotFoundException var12) {
            Logger.getLogger(WelcomePage.class.getName()).log(Level.SEVERE, (String)null, var12);
        }

        doc.close();
    }

    private void jButton3ActionPerformed(ActionEvent evt) {
        this.abcd = new WelcomePage();
        this.abcd.usertrack();
        this.abcd.restrict();
        this.dispose();
        this.abcd.setVisible(true);
    }

    private void graphbtnActionPerformed(ActionEvent evt) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        int aditya = Integer.parseInt(this.finaltable.getValueAt(0, 0).toString());
        int bhaskar = Integer.parseInt(this.finaltable.getValueAt(1, 1).toString());
        int martand = Integer.parseInt(this.finaltable.getValueAt(2, 2).toString());
        int vivasvan = Integer.parseInt(this.finaltable.getValueAt(3, 3).toString());
        dataset.setValue(new Double((double)aditya), "Values", "Aditya");
        dataset.setValue(new Double((double)bhaskar), "Values", "Bhaskar");
        dataset.setValue(new Double((double)martand), "Values", "Martand");
        dataset.setValue(new Double((double)vivasvan), "Values", "Vivasvan");
        JFreeChart chart = ChartFactory.createBarChart("Points vs House", "House", "Points", dataset, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.black);
        ChartFrame frame = new ChartFrame("House Points", chart);
        frame.setVisible(true);
        frame.setSize(550, 450);
    }

    private void finaltableMouseClicked(MouseEvent evt) {
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
        try {
            this.con = src.MsAccessPro.Connection.getConnection();
            String atable = "INSERT into HousePoints (Aditya)SELECT SUM (Aditya) FROM TotalPoints";
            String btable = "INSERT into HousePoints (Bhaskar)SELECT SUM (Bhaskar) FROM TotalPoints";
            String mtable = "INSERT into HousePoints (Martand)SELECT SUM (Martand) FROM TotalPoints";
            String vtable = "INSERT into HousePoints (Vivasvan)SELECT SUM (Vivasvan) FROM TotalPoints";
            PreparedStatement ad = this.con.prepareStatement(atable);
            PreparedStatement bh = this.con.prepareStatement(btable);
            PreparedStatement ma = this.con.prepareStatement(mtable);
            PreparedStatement viv = this.con.prepareStatement(vtable);
            ad.executeUpdate();
            bh.executeUpdate();
            ma.executeUpdate();
            viv.executeUpdate();
            this.ShowData();
        } catch (Exception var10) {
            JOptionPane.showMessageDialog((Component)null, var10);
        }

    }

    public void ShowData() {
        try {
            this.con = src.MsAccessPro.Connection.getConnection();
            String sql = "Select Aditya,Bhaskar,Martand,Vivasvan from HousePoints";
            PreparedStatement pst = this.con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            this.finaltable.setModel(DbUtils.resultSetToTableModel(rs));
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
            Logger.getLogger(Final_Result.class.getName()).log(Level.SEVERE, (String)null, var5);
        } catch (InstantiationException var6) {
            Logger.getLogger(Final_Result.class.getName()).log(Level.SEVERE, (String)null, var6);
        } catch (IllegalAccessException var7) {
            Logger.getLogger(Final_Result.class.getName()).log(Level.SEVERE, (String)null, var7);
        } catch (UnsupportedLookAndFeelException var8) {
            Logger.getLogger(Final_Result.class.getName()).log(Level.SEVERE, (String)null, var8);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new Final_Result()).setVisible(true);
            }
        });
    }
}
