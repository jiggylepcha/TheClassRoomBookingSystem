package Classes;
/**
 * Request Controller class
 */

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class RequestController {

    @FXML
    private Button viewRequest;

    @FXML
    private Button cancel;

    @FXML
    private ListView requestList;
    String val;

    public void clickCancel()
    {
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.close();
    }

    public void clickViewRequest()
    {

    }

    public void clickSeeRequest() throws IOException, ClassNotFoundException {
        ArrayList<Request> searchOptions = Admin.deserialiseRequest();
        ObservableList<String> myList = FXCollections.observableArrayList();;
        for(int i = 1; i < searchOptions.size(); i++)
        {
            myList.add(searchOptions.get(i).getPreferredRoom());
            requestList.setItems(myList);

        }
        requestList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("ListView selection changed from oldValue = "
                        + oldValue + " to newValue = " + newValue);
                addRequest(newValue);
            }
        });
    }
    public void addRequest(String newValue)
    {
        val = newValue;
    }
}
