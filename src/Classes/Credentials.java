package Classes;
/**
 * This class stores the Credentials of the the students
 * @author Nakul Ramanathan
 */

import java.io.Serializable;

public class Credentials implements Serializable
{
    public static final long serialVersionUID = 1231212L;
    String emaill;
    String pass;
    int designation;

    /**
     * This constructor sets the credentials
     * @param e
     * @param p
     * @param d
     */
    public Credentials(String e, String p, int d)
    {
        emaill=e;
        pass=p;
        designation=d;
    }
}
