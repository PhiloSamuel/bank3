package controllers;
import  java.util.Random;

import classes.Items;
import classes.Transactions;
import classes.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.sql.SQLException;

public class HelloController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    public static   User x;

    public void switchToBuyItems(javafx.event.ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../fxml_fill/BuyItemsPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToTransfer(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxml_fill/TransferPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToPayBills(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxml_fill/PayBillPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToStatement(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxml_fill/StatementPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToMainPage(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../fxml_fill/MainPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
        public void Buymac(ActionEvent a) {
        try {
            int amount= Items.getPrice("Mackbook");
            if (x.getBalance() <amount) throw new ArithmeticException();
            else {
                Transactions.TransferBank(x,amount);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Congratulations");
                alert.setContentText("Item bought successfully");
                alert.show();
            }
        }
        catch (ArithmeticException | SQLException al) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Insufficient Funds");
            alert.setContentText("Check Balance");
            alert.show();
        }
    }
        public void Buyiphone(ActionEvent a){
            try {
                int amount= Items.getPrice("Iphone");
                if (x.getBalance() <amount) throw new ArithmeticException();
                else {
                    Transactions.TransferBank(x,amount);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Congratulations");
                    alert.setContentText("Item bought successfully");
                    alert.show();
                }
            }
            catch (ArithmeticException | SQLException al) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Insufficient Funds");
                alert.setContentText("Check Balance");
                alert.show();
            }
        }
        public void BuyPS5(ActionEvent a){
            try {
                int amount= Items.getPrice("Ps5");
                if (x.getBalance() <amount) throw new ArithmeticException();
                else {
                    Transactions.TransferBank(x,amount);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Congratulations");
                    alert.setContentText("Item bought successfully");
                    alert.show();
                }
            }
            catch (ArithmeticException | SQLException al) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Insufficient Funds");
                alert.setContentText("Check Balance");
                alert.show();
            }

    }
        public void BuyTv(ActionEvent a){
        try {
            int amount= Items.getPrice("Apple Tv");
            if (x.getBalance() <amount) throw new ArithmeticException();
            else {
                Transactions.TransferBank(x,amount);
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Congratulations");
                alert.setContentText("Item bought successfully");
                alert.show();
            }
        }
        catch (ArithmeticException | SQLException al) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Insufficient Funds");
            alert.setContentText("Check Balance");
            alert.show();
        }
    }

    public void PayElectric(ActionEvent a){
        try
        {
            if(4<2000) throw new ArithmeticException();


        }
        catch (ArithmeticException al) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Payment");
            alert.setContentText("Please Pay "+gRand()+" EGP");
            alert.show();
        }
    }

    public int gRand(){
        Random rand = new Random();
        int n = rand.nextInt(1000);
        return n;
    }
    public void PayLoans(ActionEvent a){
        try
        {
//                    User philo = new User(333444);
//                    int Balance = philo.getBalance();
            if(4<2000) throw new ArithmeticException();


        }
        catch (ArithmeticException al) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Payment");
            alert.setContentText("Please Pay "+gRand()+" EGP");
            alert.show();
        }
    }
    public void PayGas(ActionEvent a){
        try
        {
//          User philo = new User(333444);
//          int Balance = philo.getBalance();
            String type = "gas";
            if(4<2000) throw new ArithmeticException();


        }
        catch (ArithmeticException al) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Payment");
            alert.setContentText("Please Pay "+gRand()+" EGP");
            alert.show();
        }
    }
    public void PayTrans(ActionEvent a){
        try
        {
//          User philo = new User(333444);
//          int Balance = philo.getBalance();
            String type = "gas";
            if(4<2000) throw new ArithmeticException();


        }
        catch (ArithmeticException al) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Payment");
            alert.setContentText("Please Pay "+gRand()+" EGP");;
            alert.show();
        }
    }
    public void PayWater(ActionEvent a){
        try
        {
//          User philo = new User(333444);
//          int Balance = philo.getBalance();
            String type = "gas";
            if(4<2000) throw new ArithmeticException();


        }
        catch (ArithmeticException al) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Payment");
            alert.setContentText("Please Pay "+gRand()+" EGP");
            alert.show();
        }
    }
}