package Classes;

import com.sun.corba.se.pept.encoding.OutputObject;
import com.sun.tools.javac.comp.Check;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;

public class AdminController
{
    @FXML
    private Button logOutButton;

    @FXML
    private Button viewRoom;

    @FXML
    private Button bookRoom;

    @FXML
    private Button unbookRoom;

    @FXML
    private Button viewRequests;

    public void clickLogOut()
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

    public void clickViewRoom() throws IOException
    {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ViewRoom.fxml"));
        stage.setScene(new Scene(root, 750, 600));
        stage.show();
    }

    public void clickBookRoom() throws IOException
    {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("BookRoom.fxml"));
        stage.setScene(new Scene(root, 750, 600));
        stage.show();
    }

    public void clickUnbookRoom() throws IOException
    {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("CancelBooking.fxml"));
        stage.setScene(new Scene(root, 750, 600));
        stage.show();
    }

    public void clickViewRequests() throws IOException
    {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Request.fxml"));
        stage.setScene(new Scene(root, 750, 600));
        stage.show();
    }
}
