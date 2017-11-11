package Classes;

import java.io.Serializable;

public class Credentials implements Serializable
{
    public static final long serialVersionUID = 1231212L;
    String emaill;
    String pass;
    int designation;

    public Credentials(String e, String p, int d)
    {
        emaill=e;
        pass=p;
        designation=d;
    }
}
