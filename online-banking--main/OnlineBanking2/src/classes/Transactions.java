package classes;

import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Transactions {
    private User first;
    private String firstName;
    private User second;
    private String secondName;
    private int amount;
    private String Type;
    private int Tnum;

    public Transactions(int tnum,String first,String type, String second, int amount ) {
        firstName = first;
        secondName =second;
        this.amount = amount;
        Type = type;
        Tnum = tnum;
    }
    public static Boolean isAvailableBalance(User first,int amount){
        if(first.getBalance()>= amount)
            return true;
        return false;
    }
    public Transactions(User first, User second, int amount) {
        this.first = first;
        firstName=first.getName();
        secondName=second.getName();
        this.second = second;
        this.amount = amount;

    }
    public static   boolean Transfer(User first,User second,int amount) throws SQLException {
        if (isAvailableBalance(first,amount)) {
            second.setBalance(second.getBalance() + amount);
            first.setBalance(first.getBalance() - amount);
            Connection c = DriverManager.getConnection("jdbc:ucanaccess://Gand_bank_DB1.accdb") ;
            Statement stp = c.createStatement();
            stp.executeUpdate("INSERT INTO Transactions (UserName,Typee,User2,amount ) values ('"+first.getName()+"','send','"+second.getName()+"',"+amount+")");
            stp.executeUpdate("INSERT INTO Transactions (UserName,Typee,User2,amount ) values ('"+second.getName()+"','recieve','"+first.getName()+"',"+amount+")");
        return true;
        }
        else return false;
    }
    public static   boolean TransferBank(User first,int amount) throws SQLException {
        if (isAvailableBalance(first,amount)) {
            first.setBalance(first.getBalance() - amount);
            Connection c = DriverManager.getConnection("jdbc:ucanaccess://Gand_bank_DB1.accdb") ;
            Statement stp = c.createStatement();
            stp.executeUpdate("INSERT INTO Transactions (UserName,Typee,User2,amount ) values ('"+first.getName()+"','buy','Bank',"+amount+")");
            return true;
        }
        else return false;
    }
    public static   boolean TransferBill(User first,int amount,String billType) throws SQLException {
        if (isAvailableBalance(first,amount)) {
            first.setBalance(first.getBalance() -amount);
            Connection c = DriverManager.getConnection("jdbc:ucanaccess://Gand_bank_DB1.accdb") ;
            Statement stp = c.createStatement();
            stp.executeUpdate("INSERT INTO Transactions (UserName,Typee,User2,amount ) values ('"+first.getName()+"','pay bill','"+billType+"',"+amount+")");
            return true;
        }
        else return false;
    }
    public List<Transactions> ShowRecords() throws SQLException{
        Connection c = DriverManager.getConnection("jdbc:ucanaccess://Gand_bank_DB1.accdb") ;
        Statement stp = c.createStatement();
        ResultSet rs=  stp.executeQuery("SELECT Transactions.[TransactionNum], Transactions.[UserName], Transactions.[Typee], Transactions.[User2], Transactions.[amount]\n" +
                                            "FROM Transactions\n" +
                                            "WHERE (((Transactions.[UserName])='"+this.first.getName()+"'));");
        List<Transactions> x=new ArrayList<Transactions>();
        while(rs.next()){
            x.add(new Transactions(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
        }
        return x;
    }
    public User getFirst() {
        return first;
    }
    public void setFirst(User first) {
        this.first = first;
    }

    public User getSecond() {
        return second;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setSecond(User second) {
        this.second = second;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getTnum() {
        return Tnum;
    }

    public void setTnum(int tnum) {
        Tnum = tnum;
    }

    public String toString(){
        return Tnum+firstName+" "+Type+" "+secondName+" amount= "+amount;
    }
}
