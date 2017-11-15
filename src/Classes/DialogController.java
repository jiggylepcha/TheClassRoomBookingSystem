package Classes;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;

public class DialogController
{
    @FXML
    private Button cancelButton;

    @FXML
    private Button checkAvailability;

    @FXML
    private Button unbookRoom;

    @FXML
    private Button bookRoom;

    @FXML
    private Button approve;

    @FXML
    private Button reject;

    @FXML
    private TextField roomNumber;

    @FXML
    private TextField time;

    @FXML
    private TextField day;


    public void clickCancelButton()
    {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void clickCheckAvailability() throws IOException, ClassNotFoundException {
        String roomCheck = roomNumber.getText().toString();
        String timeCheck = time.getText().toString();
        String dayCheck = day.getText().toString();

        Student student = new Student(roomCheck, timeCheck, dayCheck);
        System.out.println(student.checkRoomAvailability());
        if (student.checkRoomAvailability())
        {
            showAlert(Alert.AlertType.INFORMATION,"Room Status", "The room is available for booking");
        }
        else
        {
            showAlert(Alert.AlertType.ERROR,"Room Status","The room is not available for booking");
        }

    }

    public void clickUnbookRoom()
    {

    }

    public void clickBookRoom()
    {

    }

    public void clickApprove()
    {

    }

    public void clickReject()
    {

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
}
