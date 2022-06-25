package src.MsAccessPro;

import java.sql.DriverManager;

public class Connection {
    public static java.sql.Connection con;
    public static String dbFile = "src/MsAccessPro/Athletics.accdb";
    public static String dbUrl;

    public Connection() {
    }

    public static java.sql.Connection getConnection() {
        try {
            con = DriverManager.getConnection(dbUrl, "", "");
            System.out.println("Connected Successfully");
        } catch (Exception var1) {
            System.out.println("" + var1);
        }

        return con;
    }

    static {
        dbUrl = "jdbc:ucanaccess://" + dbFile.trim() + ";memory=true";
    }
}

