package Classes;

import java.io.Serializable;

public class Person implements Serializable
{
    Credentials credentials;
    int typeOfUser;
    Person(Credentials cred, int typeOfUser)
    {
        this.credentials = cred;
        this.typeOfUser = typeOfUser;
    }

    Person()
    {

    }
}
