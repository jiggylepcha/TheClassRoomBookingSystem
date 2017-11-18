package Classes;
/**
 * This class controls the Faculty page
 * @author Nakul Ramanathan
 */

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;


public class FacultyController
{
    @FXML
    private Button logOutButton;

    /**
     * Logs out from the faculty page
     * @throws IOException
     */

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

    /**
     * Goes to the View Room window
     * @throws IOException
     */
    public void clickRoomAvailibiity() throws IOException
    {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ViewRoom.fxml"));
        stage.setScene(new Scene(root, 750, 600));
        stage.show();

    }

    /**
     * Goes to a new window containing the Book Room details
     * @throws IOException
     */
    public void clickBookRoom() throws IOException
    {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("BookRoom.fxml"));
        stage.setScene(new Scene(root, 750, 600));
        stage.show();
    }

    /**
     * Goes to the cancel booking window
     * @throws IOException
     */
    public void clickUnbookRoom() throws IOException
    {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("CancelBooking.fxml"));
        stage.setScene(new Scene(root, 750, 600));
        stage.show();
    }

}
