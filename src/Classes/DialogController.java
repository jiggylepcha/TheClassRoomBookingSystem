package Classes;
/**
 * Controller for the diagonal classes
 * @author Jigme Lobsang Lepcha
 */

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Queue;

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

    @FXML
    private TextField searchBar;

    @FXML
    private TextField purposeBooking;

    @FXML
    private TextField requiredCapacity;

    @FXML
    private Label bookingPurpose;

    @FXML
    private Label preferredRoom;

    @FXML
    private Label capacity;

    @FXML
    private Label timeRequested;

    @FXML
    private Label dayRequested;

    @FXML
    private ListView<String> searchList;

    @FXML
    private Button addButton;

    /**
     * Closes the Stage when the user presses cancel button.
     */
    public void clickCancelButton()
    {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    /**
     * Checks whether the room is available or not.
     * @throws IOException
     * @throws ClassNotFoundException
     */
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

    /**
     * Unbooks an room
     */
    public void clickUnbookRoom()
    {

    }

    /**
     * Books an available room.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void clickBookRoom() throws IOException, ClassNotFoundException
    {
        String roomCheck = roomNumber.getText().toString();
        String timeCheck = time.getText().toString();
        String dayCheck = day.getText().toString();

        Student student = new Student(roomCheck, timeCheck, dayCheck);
        if(student.checkRoomAvailability())
        {
            showAlert(Alert.AlertType.INFORMATION,"Room Status", "Room Booked");

        }
        else
        {
            showAlert(Alert.AlertType.ERROR,"Room Status","The room is not available for booking");
        }
    }

    /**
     * Approves the booking request.
     */
    public void clickApprove()
    {

    }

    /**
     * Rejects the booking request
     */
    public void clickReject()
    {
        showAlert(Alert.AlertType.INFORMATION, "Reject", "Room booking cancelled");

    }

    String newCourse;

    /**
     * Searches for a course from the database
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void search() throws IOException, ClassNotFoundException {
        String searchQuery = searchBar.getText().toString();
        //System.out.println(searchQuery);
        ArrayList<Course> searchOptions = Main.deserializeCSV();
        ObservableList<String> myList = FXCollections.observableArrayList();;
        for(int i = 1; i < searchOptions.size(); i++)
        {
            if(searchOptions.get(i).getPostConditions().contains(searchQuery))
            {
                System.out.println(searchOptions.get(i).getCourseName());
                myList.add(searchOptions.get(i).getCourseName());
                searchList.setItems(myList);
            }
        }
        searchList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("ListView selection changed from oldValue = "
                        + oldValue + " to newValue = " + newValue);
                joinCourse(newValue);
            }
        });
    }

    /**
     * Sets the course name to newCourse
     * @param value name of the course to join
     */
    public void joinCourse(String value)
    {
        newCourse = value;
    }

    public void addCourse() throws IOException, ClassNotFoundException {
        //System.out.println("Course name: "+newCourse);
        if(Student.addCourse(newCourse))
        {
            showAlert(Alert.AlertType.ERROR,"Course registration","You already have taken this course");
        }
        else
        {
            showAlert(Alert.AlertType.INFORMATION,"Course Registration", "Registration Successful");
        }
//        Stage stage = (Stage) addButton.getScene().getWindow();
//        stage.close();
    }

    /**
     * Displays the alert
     * @param alertType Type of alert
     * @param title Title of the alert
     * @param message Message to be shown
     */
    public static void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.setAlwaysOnTop(true);
        alert.show();
    }

    /**
     * Maintains a queue containing the various student booking requests
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void clickStudentBookRoom() throws IOException, ClassNotFoundException
    {
        String roomCheck = roomNumber.getText().toString();
        String timeCheck = time.getText().toString();
        String dayCheck = day.getText().toString();
        String reqCap = requiredCapacity.getText().toString();
        String purpBooking = purposeBooking.getText().toString();

        Request request = new Request(roomCheck, purpBooking, reqCap, dayCheck, timeCheck);

        Queue<Request> requests= new LinkedList<Request>();
        requests.add(request);

        Admin ob = new Admin();
        ob.serialiseRequest(requests);

        showAlert(Alert.AlertType.INFORMATION,"Room Book Request", "Request Successfully sent");

        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();

    }
}
