package Classes;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

public class Controller implements Serializable
{
    public static final long serialVersionUID=12323131133L;

    @FXML
    private Button signUpButton;
    @FXML
    private Button loginButton;
    @FXML
    private TextField userID;
    @FXML
    private PasswordField passwordField;




    public void clickSignUp() throws IOException
    {

        Stage curStage=(Stage) signUpButton.getScene().getWindow();


            try
            {
                Main.root=FXMLLoader.load(getClass().getResource("SignUp.fxml"));
                curStage.setScene(new Scene(Main.root, 1000, 1000));
                curStage.setTitle("Sign Up");
                curStage.show();
            }
            catch (IOException e1)
            {
                e1.printStackTrace();
            }
    }



    public void clickLogIn() throws IOException , ClassNotFoundException
    {
        Stage curStage = (Stage) loginButton.getScene().getWindow();

        if(userID.getText().isEmpty())
        {
            showAlert(Alert.AlertType.ERROR,
                    "Error!", "Email cannot be empty");
            return;
        }
        if (passwordField.getText().isEmpty())
        {
            showAlert(Alert.AlertType.ERROR, "Error", "Password field cannot be empty");
            return;
        }
        String tempEmail = userID.getText();
        HashMap<String,Person> myMap = Controller2.deserialise();

        if (!myMap.containsKey(tempEmail))
        {
            showAlert(Alert.AlertType.ERROR, "Error", "Invalid Email. Please Sign Up");
            return;
        }
        Person p = myMap.get(tempEmail);
//        Student s = myMap.get(tempEmail);
        if (passwordField.getText().compareTo(p.credentials.pass) != 0)
        {
            showAlert(Alert.AlertType.ERROR, "Error", "Wrong Password.");
            return;
        }
        if (p.typeOfUser == 0)
        {
            System.out.println("FOUND STUDENT");
            try
            {
                Main.root=FXMLLoader.load(getClass().getResource("Student.fxml"));
                curStage.setScene(new Scene(Main.root, 1000, 1000));
                curStage.setTitle("Student Page");
                curStage.show();
            }
            catch (IOException e1)
            {
                e1.printStackTrace();
            }
        }
        else if (p.typeOfUser == 1)
        {
            System.out.println("FOUND ADMIN");
            try
            {
                Main.root=FXMLLoader.load(getClass().getResource("Admin.fxml"));
                curStage.setScene(new Scene(Main.root, 1000, 1000));
                curStage.setTitle("Admin Page");
                curStage.show();
            }
            catch (IOException e1)
            {
                e1.printStackTrace();
            }
        }
        else
        {
            System.out.println("FOUND FACULTY");
            try
            {
                Main.root=FXMLLoader.load(getClass().getResource("Faculty.fxml"));
                curStage.setScene(new Scene(Main.root, 1000, 1000));
                curStage.setTitle("Faculty Page");
                curStage.show();
            }
            catch (IOException e1)
            {
                e1.printStackTrace();
            }
        }

    }
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        //alert.initOwner(owner);
        alert.show();
    }



}
