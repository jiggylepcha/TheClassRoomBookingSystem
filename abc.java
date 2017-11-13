package randomfx;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class abc extends Application {
    public class Record {
        public SimpleStringProperty f1, f2, f3, f4, f5, f6;
        public String getF1() {
            return f1.get();
        }
        public String getF2() {
            return f2.get();
        }
        public String getF3() {
            return f3.get();
        }
        public String getF4() {
            return f4.get();
        }
        public String getF5() {
            return f5.get();
        }
        public String getF6() {
            return f6.get();
        }
        Record(String f1, String f2, String f3, String f4,String f5, String f6) {
            this.f1 = new SimpleStringProperty(f1);
            this.f2 = new SimpleStringProperty(f2);
            this.f3 = new SimpleStringProperty(f3);
            this.f4 = new SimpleStringProperty(f4);
            this.f5 = new SimpleStringProperty(f5);
            this.f6 = new SimpleStringProperty(f6);
        }
    }
    private final TableView<Record> tableView = new TableView<>();
    private final TableView<Record> tableView1 = new TableView<>();
    private final ObservableList<Record> dataList = FXCollections.observableArrayList();
    private final ObservableList<Record> dataList1 = FXCollections.observableArrayList();
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("TIMETABLE");
        Group root = new Group();
        TableColumn columnF1 = new TableColumn("f1");
        columnF1.setCellValueFactory(
                new PropertyValueFactory<>("f1"));
        TableColumn columnF2 = new TableColumn("f2");
        columnF2.setCellValueFactory(
                new PropertyValueFactory<>("f2"));
        TableColumn columnF3 = new TableColumn("f3");
        columnF3.setCellValueFactory(
                new PropertyValueFactory<>("f3"));
        TableColumn columnF4 = new TableColumn("f4");
        columnF4.setCellValueFactory(
                new PropertyValueFactory<>("f4"));
        TableColumn columnF5 = new TableColumn("f5");
        columnF5.setCellValueFactory(
                new PropertyValueFactory<>("f5"));
        TableColumn columnF6 = new TableColumn("f6");
        columnF6.setCellValueFactory(
                new PropertyValueFactory<>("f6"));
        TableColumn columnF7 = new TableColumn("f7");
        columnF7.setCellValueFactory(
                new PropertyValueFactory<>("f7"));
        TableColumn columnF8 = new TableColumn("f8");
        columnF8.setCellValueFactory(
                new PropertyValueFactory<>("f8"));
        TableColumn columnF9 = new TableColumn("f9");
        columnF9.setCellValueFactory(
                new PropertyValueFactory<>("f9"));
        TableColumn columnF10 = new TableColumn("f10");
        columnF10.setCellValueFactory(
                new PropertyValueFactory<>("f10"));
        TableColumn columnF11 = new TableColumn("f11");
        columnF11.setCellValueFactory(
                new PropertyValueFactory<>("f11"));
        TableColumn columnF12 = new TableColumn("f12");
        columnF12.setCellValueFactory(
                new PropertyValueFactory<>("f12"));
        tableView.setItems(dataList);
        tableView.getColumns().addAll(columnF1, columnF2, columnF3, columnF4, columnF5, columnF6);
        tableView1.setItems(dataList1);
        tableView1.getColumns().addAll(columnF7, columnF8, columnF9, columnF10, columnF11, columnF12); 
        VBox vBox = new VBox();
        vBox.setSpacing(15);
        vBox.getChildren().add(tableView);
        root.getChildren().add(vBox);
        primaryStage.setScene(new Scene(root, 1000, 500));
        primaryStage.show();
        readCSV();
    }
    private void readCSV(){
        String CsvFile = "C:/Users/Nakul/Desktop/abc.csv";
        String CsvFile2 = "C:/Users/Nakul/Desktop/abc1.csv";
        String FieldDelimiter = ",";
        BufferedReader br , sr;
        try {
            br = new BufferedReader(new FileReader(CsvFile));
            sr = new BufferedReader(new FileReader(CsvFile2));
            String line ,  line2;
            while (((line = br.readLine()) != null)||((line = sr.readLine()) != null)){
                String[] fields = line.split(FieldDelimiter, -1);
            	String[] fields2 = line.split(FieldDelimiter, -1);
                Record record = new Record(fields[0], fields[1], fields[2],fields[3], fields[4], fields[5]);
            	Record record2 = new Record(fields2[0], fields2[1], fields2[2],fields2[3], fields2[4], fields2[5]);
                dataList.add(record);
            	dataList1.add(record2);
            }
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(abc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(abc.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (RuntimeException ex) {
            Logger.getLogger(abc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
