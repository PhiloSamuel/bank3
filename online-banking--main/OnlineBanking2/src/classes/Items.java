package classes;

import java.sql.*;

public class Items {
    private int Price;
    private String NameItem;

    public void setPrice(int price) {
        Price = price;
    }

    public String getNameItem() {
        return NameItem;
    }

    public void setNameItem(String nameItem) {
        NameItem = nameItem;
    }

    public Items( String nameItem,int price) {
        Price = price;
        NameItem = nameItem;
    }
    public Items(){}

//
    public static int getPrice(String NameItem) throws SQLException {
        Connection c = DriverManager.getConnection("jdbc:ucanaccess://Gand_bank_DB1.accdb") ;
        Statement stp = c.createStatement();
        ResultSet rs= stp.executeQuery("SELECT Items.[NameItem], Items.[Price]\n" +
                "FROM Items\n" +
                "WHERE (((Items.[NameItem])='"+NameItem+"'));");
        rs.next();
        return rs.getInt(2);


    }
}
