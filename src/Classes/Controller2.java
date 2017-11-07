package Classes;

import com.sun.corba.se.pept.encoding.OutputObject;
import com.sun.tools.javac.comp.Check;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;

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

    public static final long serialVersionUID=12323133L;

    public Controller2()
    {
        if(checkStudent!=null)
        checkStudent.setSelected(true);
    }

    public void clickSignUp2() throws IOException {
        String emailID=email.getText().toString();
        String password=pass.getText().toString();
        String confirmPassword=confirmPass.getText().toString();

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
        }

    }

    private void serialize(String emailID, String password, int designation) throws IOException {
        Credentials credentials=new Credentials(emailID, password, designation);
        String file=emailID+".ser";
        ObjectOutputStream objectOutputStream=null;
        try {
            objectOutputStream=new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(credentials);
        }
        finally {
            objectOutputStream.close();
        }
    }

    public boolean validate(String email, String pass, String confirmPass)
    {
        return checkPassword(pass) && checkEmail(email) && confirmPass.equals(pass) && checkCheckbox();
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
}
