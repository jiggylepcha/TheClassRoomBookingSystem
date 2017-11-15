package Classes;

import com.sun.corba.se.pept.encoding.OutputObject;
import com.sun.tools.javac.comp.Check;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;

public class StudentController
{
    @FXML
    private Button logOutButton;

    public void clickLogOut() throws IOException
    {
        showAlert(Alert.AlertType.INFORMATION, "Logout Successful", "You have been successfully logged out");
        Stage curStage = (Stage) logOutButton.getScene().getWindow();
        try
        {
            Main.root=FXMLLoader.load(getClass().getResource("Login.fxml"));
            curStage.setScene(new Scene(Main.root, 1000, 1000));
            curStage.setTitle("Login");
            curStage.show();
        }
        catch (IOException e1)
        {
            e1.printStackTrace();
        }
    }


    public static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.setAlwaysOnTop(true);
        alert.show();
    }

    public void clickTimetable() throws IOException
    {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("TimeTable.fxml"));
        stage.setScene(new Scene(root, 750, 600));
        stage.show();
    }

    public void clickSearchCourse() throws IOException
    {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Search.fxml"));
        stage.setScene(new Scene(root, 750, 600));
        stage.show();
    }

    public void clickBookRoom() throws IOException
    {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("StudentBookRoom.fxml"));
        stage.setScene(new Scene(root, 750, 600));
        stage.show();
    }

    public void clickRoomAvailability() throws IOException
    {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ViewRoom.fxml"));
        stage.setScene(new Scene(root, 750, 600));
        stage.show();
    }
}
