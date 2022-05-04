package classes;

import java.sql.*;
import java.util.ArrayList;


public class main  {
    public static void main(String[] args) throws Exception {
//User x=new User();
//x.EnterCardNumber("123123123");
//Transactions w=new Transactions(x);
//        ArrayList<Transactions>f=w.ShowRecords();
//for (int i=0;i<f.size();i++)
//System.out.println(f.get(i));
        Items rekt=new Items();

       System.out.println(rekt.getPrice("iphone"));

    }
}
