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
public class JavaFXCSVTableView extends Application {
 
    class Record {
        private SimpleStringProperty f1, f2, f3, f4, f5, f6, f7 , f8 , f9, f10 , f11 , f12 , f13 , f14 , f15;
 
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
        public String getF7() {
            return f7.get();
        }
        public String getF8() {
            return f8.get();
        }
        public String getF9() {
            return f9.get();
        }
        public String getF10() {
            return f10.get();
        }
        public String getF11() {
            return f11.get();
        }
        public String getF12() {
            return f12.get();
        }
        public String getF13() {
            return f13.get();
        }
        public String getF14() {
            return f14.get();
        }
        public String getF15() {
            return f15.get();
        }
        public Record(){
        	
        }

        public Record(String f1, String f2, String f3, String f4,String f5, String f6 , String f7 ,String f8 , String f9 , String f10 ,String f11 ,String f12, String f13 ,String f14 ,String f15){
            this.f1 = new SimpleStringProperty(f1);
            this.f2 = new SimpleStringProperty(f2);
            this.f3 = new SimpleStringProperty(f3);
            this.f4 = new SimpleStringProperty(f4);
            this.f5 = new SimpleStringProperty(f5);
            this.f6 = new SimpleStringProperty(f6);
            this.f7 = new SimpleStringProperty(f7);
            this.f8 = new SimpleStringProperty(f8);
            this.f9 = new SimpleStringProperty(f9);
            this.f10 = new SimpleStringProperty(f10);
            this.f11 = new SimpleStringProperty(f11);
            this.f12 = new SimpleStringProperty(f12);
            this.f13 = new SimpleStringProperty(f13);
            this.f14 = new SimpleStringProperty(f14);
            this.f15 = new SimpleStringProperty(f15);
        }
    }
 
    public TableView<Record> tableView = new TableView<>(); 
    public ObservableList<Record> dataList = FXCollections.observableArrayList();
    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("TIMETABLE");
        Group root = new Group();
        TableColumn columnF1 = new TableColumn("Mandatory/Elective");
        columnF1.setCellValueFactory(
                new PropertyValueFactory<>("Mandatory/Elective"));
 
        TableColumn columnF2 = new TableColumn("Course Name");
        columnF2.setCellValueFactory(
                new PropertyValueFactory<>("Course Name"));
 
        TableColumn columnF3 = new TableColumn("Course Code");
        columnF3.setCellValueFactory(
                new PropertyValueFactory<>("Course Code"));
 
        TableColumn columnF4 = new TableColumn("Instructor");
        columnF4.setCellValueFactory(
                new PropertyValueFactory<>("Instructor"));
 
        TableColumn columnF5 = new TableColumn("Credits");
        columnF5.setCellValueFactory(
                new PropertyValueFactory<>("Credits"));
 
        TableColumn columnF6 = new TableColumn("Acronym");
        columnF6.setCellValueFactory(
                new PropertyValueFactory<>("Acronym"));
        
        TableColumn columnF7 = new TableColumn("Monday Time$Venue");
        columnF1.setCellValueFactory(
                new PropertyValueFactory<>("Monday Time$Venue"));
        
        TableColumn columnF8 = new TableColumn("Tueday Time$Venue");
        columnF1.setCellValueFactory(
                new PropertyValueFactory<>("Tueday Time$Venue"));
        
        TableColumn columnF9 = new TableColumn("Wednesday Time$Venue");
        columnF1.setCellValueFactory(
                new PropertyValueFactory<>("Wednesday Time$Venue"));
        
        TableColumn columnF10 = new TableColumn("Thurday Time$Venue");
        columnF1.setCellValueFactory(
                new PropertyValueFactory<>("Thurday Time$Venue"));
        
        TableColumn columnF11 = new TableColumn("Friday Time$Venue");
        columnF1.setCellValueFactory(
                new PropertyValueFactory<>("Friday Time$Venue"));
        
        TableColumn columnF12 = new TableColumn("Tut Day$Time$Venue");
        columnF1.setCellValueFactory(
                new PropertyValueFactory<>("Tut Day$Time$Venue"));
        
        TableColumn columnF13 = new TableColumn("Lab Day$Time$Venue");
        columnF1.setCellValueFactory(
                new PropertyValueFactory<>("Lab Day$Time$Venue"));
        
        TableColumn columnF14 = new TableColumn("Pre-conditions");
        columnF1.setCellValueFactory(
                new PropertyValueFactory<>("Pre-conditions"));
        
        TableColumn columnF15 = new TableColumn("Post-conditions");
        columnF1.setCellValueFactory(
                new PropertyValueFactory<>("Post-conditions"));
        
        tableView.setItems(dataList);
        tableView.getColumns().addAll(columnF1, columnF2, columnF3, columnF4, columnF5, columnF6 , columnF7 ,columnF8 ,columnF9 ,columnF10 ,columnF11 ,columnF12 ,columnF13 ,columnF14 ,columnF15 );
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.getChildren().add(tableView);
        root.getChildren().add(vBox);
        primaryStage.setScene(new Scene(root, 1200, 400));
        primaryStage.show();
        readCSV();
    }
    public void readCSV() {
    	//dataList.
        String CsvFile = "C:/Users/Nakul/Downloads/csv.csv";
        String FieldDelimiter = ",";
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(CsvFile));
            String line;
            while ((line = br.readLine()) != null) {
            	String[] arr = line.split(FieldDelimiter, -1);
                Record record = new Record(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6],arr[7],arr[8],arr[9],arr[10],arr[11],arr[12],arr[13],arr[14]) ;
                dataList.addAll(record);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JavaFXCSVTableView.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JavaFXCSVTableView.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        catch (RuntimeException ex) {
            Logger.getLogger(JavaFXCSVTableView.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
 
    public static void main(String[] args) {
        launch(args);
    }
 
}
