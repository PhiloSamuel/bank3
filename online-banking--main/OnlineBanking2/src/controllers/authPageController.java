package controllers;

import classes.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class authPageController {
    public Button authLogin;
    public Button authSignup;
    public TextField authUser;
    public PasswordField authPass;
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void switchSignup(ActionEvent e) throws IOException{
        root = FXMLLoader.load(getClass().getResource("../fxml_fill/Signup.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchHomePage(ActionEvent e) {
        User x=new User();
        try {
            if (x.login(authUser.getText(),authPass.getText()))
            {
            root = FXMLLoader.load(getClass().getResource("../fxml_fill/MainPage.fxml"));
            HelloController.x=x;
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();}
         else{throw new Exception();
            }
    }
        catch (Exception er){ Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("login failed");
            alert.setHeaderText("Invalid username or password");
            alert.show();
        }
    }
}
