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

    public ArrayList<Course> course;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        //System.out.println(new File(""));
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 1000, 1000));
        primaryStage.show();


    }

    public static void main(String[] args)throws IOException, ClassNotFoundException
    {
        Main ob = new Main();
        ob.CSVParser();
        ArrayList<Course> test = deserializeCSV();
        System.out.println(test.get(2).getAcronym());
        launch(args);
    }

    public void CSVParser() throws FileNotFoundException, IOException
    {
        File file=new File("./src/");
        Scanner scanner = new Scanner(new File("./src/Classes/TheFinalCSVYES.csv"));
        String line = null;
        course = new ArrayList<Course>();
        while(scanner.hasNextLine())
        {
            line  = scanner.nextLine();
            String [] splitted = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
            Course c = new Course(splitted[0],
                    splitted[1], splitted[2],splitted[3],splitted[4],splitted[5],
                    splitted[6],splitted[7],splitted[8],splitted[9],splitted[10],
                    splitted[11],splitted[12],splitted[13],splitted[14]);
            course.add(c);
        }
        serializeCSV(course);

    }

    private void serializeCSV(ArrayList<Course> c) throws IOException
    {
        ObjectOutputStream out=null;
        try {
            out=new ObjectOutputStream(new FileOutputStream("csv.ser"));
            out.writeObject(c);
        }
        finally {
            out.close();
        }
    }

    public static ArrayList<Course> deserializeCSV() throws IOException, ClassNotFoundException
    {
        ObjectInputStream in = null;
        ArrayList<Course> cou = null;
        try {
            in = new ObjectInputStream(new FileInputStream("csv.ser"));
            cou = (ArrayList<Course>) in.readObject();
        }
        finally {
            in.close();
        }

        return cou;
    }
}
