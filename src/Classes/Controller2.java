package Classes;

import com.sun.corba.se.pept.encoding.OutputObject;
import com.sun.tools.javac.comp.Check;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Controller2 implements Serializable
{
    @FXML
    private Button signUpButton;

    @FXML
    private TextField email;

    @FXML
    private PasswordField pass;

    @FXML
    private PasswordField confirmPass;

    @FXML
    private CheckBox checkStudent;

    @FXML
    private CheckBox checkAdmin;

    @FXML
    private CheckBox checkFaculty;

    @FXML
    private Button backButton;

    public static final long serialVersionUID=12323133L;

    public Controller2()
    {
        if(checkStudent!=null)
        checkStudent.setSelected(true);
    }

    public void clickSignUp2() throws IOException , ClassNotFoundException{
        String emailID=email.getText().toString();
        String password=pass.getText().toString();
        String confirmPassword=confirmPass.getText().toString();

        Stage curStage=(Stage) signUpButton.getScene().getWindow();

        if(!validate(emailID, password, confirmPassword))
        {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Invalid email/password");
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.show();
        }
        else
        {
            int designation;
            if(checkStudent.isSelected())
                designation=0;
            else if(checkAdmin.isSelected())
                designation=1;
            else
                designation=2;

            serialize(emailID, password, designation);

            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("You have been successfully signed up. Try loggin in");
            alert.setTitle("Sign Up successful");
            alert.setHeaderText(null);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.setAlwaysOnTop(true);
            alert.show();
            try
            {
                Main.root=FXMLLoader.load(getClass().getResource("Login.fxml"));
                curStage.setScene(new Scene(Main.root, 1000, 1000));
                curStage.setTitle("Login");
                curStage.show();
            }
            catch (IOException e1)
            {
                e1.printStackTrace();
            }
        }

    }

    private void serialize(String emailID, String password, int designation) throws IOException ,ClassNotFoundException {
        Credentials credentials=new Credentials(emailID, password, designation);
        Person tempPerson;
        if (designation == 0)
        {
            tempPerson = new Student(credentials);
        }
        else if (designation == 1)
        {
            tempPerson = new Admin(credentials);
        }
        else {
            tempPerson = new Faculty(credentials);
        }
        HashMap<String,Person> myMap = deserialise();
        myMap.put(emailID,tempPerson);
        serialiseMap(myMap);
        System.out.println(myMap);

    }

    private void serialiseMap(HashMap<String, Person> xxx) throws IOException {
        ObjectOutputStream out=null;
        try {
            out=new ObjectOutputStream(new FileOutputStream("hashmap.ser"));
            out.writeObject(xxx);
        }
        finally {
            out.close();
        }
    }

    public static HashMap<String, Person > deserialise() throws IOException, ClassNotFoundException {
        ObjectInputStream in=null;
        HashMap<String, Person> s1=null;
        try {
            in=new ObjectInputStream(new FileInputStream("hashmap.ser"));
             s1=(HashMap<String, Person>) in.readObject();
        }
        finally {
            in.close();
        }

        return s1;
    }

    public boolean validate(String email, String pass, String confirmPass) throws IOException, ClassNotFoundException
    {
        return checkExists(email) && checkPassword(pass) && checkEmail(email) && confirmPass.equals(pass) && checkCheckbox();
    }

    private boolean checkExists(String email) throws IOException, ClassNotFoundException {
        HashMap<String, Person> x=Controller2.deserialise();
        for(Map.Entry<String, Person> entry:x.entrySet())
        {
            if(entry.getValue().credentials.emaill.equals(email)){
                return false;
            }
        }
        return true;
    }

    private boolean checkCheckbox()
    {
        if(checkStudent.isSelected() && !checkAdmin.isSelected() && !checkFaculty.isSelected())
        {
            return true;
        }
        else if(checkFaculty.isSelected() && !checkAdmin.isSelected() && !checkStudent.isSelected())
        {
            return true;
        }
        else if(checkAdmin.isSelected() && !checkStudent.isSelected() && !checkFaculty.isSelected())
            return true;
        return false;
    }

    private boolean checkPassword(String pass)
    {
        System.out.println(pass.isEmpty());
        return !pass.isEmpty();
    }

    private boolean checkEmail(String email)
    {
        String tempEmail = email;
        String emailDomain = "";


        int pos=tempEmail.indexOf("@");
        if(pos==-1)
            return false;
        emailDomain=tempEmail.substring(pos);
        System.out.println(emailDomain);
        return emailDomain.equals("@iiitd.ac.in");
    }

    public void clickBackButton() throws IOException
    {
        Stage curStage=(Stage) backButton.getScene().getWindow();


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
}
