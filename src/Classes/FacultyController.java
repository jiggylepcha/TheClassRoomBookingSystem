package Classes;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;


public class FacultyController
{
    @FXML
    private Button logOutButton;

    public void clickLogOutButton() throws IOException
    {

        Stage curStage=(Stage) logOutButton.getScene().getWindow();
        StudentController.showAlert(Alert.AlertType.INFORMATION, "Logout Successful", "You have been successfully logged out");
        try
        {
            Main.root= FXMLLoader.load(getClass().getResource("Login.fxml"));
            curStage.setScene(new Scene(Main.root, 1000, 1000));
            curStage.setTitle("Sign In");
            curStage.show();
        }
        catch (IOException e1)
        {
            e1.printStackTrace();
        }
    }

}
