package controllers;

import classes.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class signupController {
    public TextField SignUp1;
    public TextField SignUp2;
    public TextField SignUp3;
    public TextField SignUp4;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void SUBMIT(ActionEvent e) throws Exception {
       try {
           root = FXMLLoader.load(getClass().getResource("../fxml_fill/MainPage.fxml"));
           System.out.println(SignUp4.getText().length());
           if (SignUp4.getText().length()==14){
               User x=new User(SignUp1.getText(),SignUp2.getText(),SignUp3.getText(),SignUp4.getText());
               x.addNewUser();
               HelloController.x=x;
               Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
               alert.setTitle("Signup successfully");
               alert.setHeaderText("signup successfully");
               alert.show();
               stage = (Stage)((Node)e.getSource()).getScene().getWindow();
               scene = new Scene(root);
               stage.setScene(scene);
               stage.show();}
           else throw new IOException();
          }
       catch (IllegalArgumentException as){
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Signup failed");
           alert.setHeaderText("weak password it should be at least 8 digits and must contain digits and letters");
           alert.show();
       }
       catch (IOException as){
           Alert alert = new Alert(Alert.AlertType.ERROR);
           alert.setTitle("Signup failed");
           alert.setHeaderText("Invalid card number it must be 14 digits");
           alert.show();
       }

    }
}
