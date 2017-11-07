package Classes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.Serializable;


public class Main extends Application implements Serializable
{
    public static final long serialVersionUID=12323139863L;

    public static Parent root;



    @Override
    public void start(Stage primaryStage) throws Exception
    {
        //System.out.println(new File(""));
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 1000, 1000));
        primaryStage.show();


    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
