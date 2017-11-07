package Classes;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller
{
    @FXML
    Button signUpButton;
    Button loginButton;



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
}
