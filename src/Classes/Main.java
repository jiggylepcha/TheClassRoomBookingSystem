package Classes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Main extends Application implements Serializable
{
    public static final long serialVersionUID=12323139863L;

    public static Parent root;

    public static ArrayList<Course> course;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        //System.out.println(new File(""));
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 1000, 1000));
        primaryStage.show();


    }

    public static void main(String[] args)throws IOException
    {
        CSVParser();
        launch(args);
    }

    public static void CSVParser() throws FileNotFoundException, IOException
    {
        File file=new File("./src/");
        Scanner scanner = new Scanner(new File("./src/Classes/TheFinalCSVYES.csv"));
        String line = null;
        while(scanner.hasNextLine())
        {
            line  = scanner.nextLine();
            String [] splitted = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
            for (int i = 0; i < splitted.length; i++){System.out.println(splitted[i]);}
            System.out.println();
//            Course c = new Course(splitted[0],
//                    splitted[1], splitted[2],splitted[3],splitted[4],splitted[5],
//                    splitted[6],splitted[7],splitted[8],splitted[9],splitted[10],
//                    splitted[11],splitted[12],splitted[13],splitted[14],splitted[15],
//                    splitted[16],splitted[17],splitted[18],splitted[19],splitted[20],
//                    splitted[21],splitted[22],splitted[23]);
//            course.add(c);
        }

    }
}
