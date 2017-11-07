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



    public void clickLogIn() throws IOException
    {
        Stage curStage = (Stage) loginButton.getScene().getWindow();

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                if(userID.getText().isEmpty())
                {
                    showAlert(Alert.AlertType.ERROR,
                            "Error!", "Email cannot be empty");
                    return;
                }
                String tempEmail = userID.getText();
                String emailDomain = "";
                for (int i = 0; i < tempEmail.length() - 1; i++)
                {
                    String tempChar = tempEmail.substring(i,i+1);
                    if (tempChar.equals("@"))
                    {
                        emailDomain = tempChar.substring(i);
                    }
                }
                if(!emailDomain.equals("@iiitd.ac.in"))
                {
                    showAlert(Alert.AlertType.ERROR, "Error", "Only IIITD email allowed");
                    return;
                }
                if (passwordField.getText().isEmpty())
                {
                    showAlert(Alert.AlertType.ERROR, "Error", "Password field cannot be empty");
                    return;
                }
            }
        });
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
