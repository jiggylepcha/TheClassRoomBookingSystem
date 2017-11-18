package Classes;
/**
 * Person Super Class
 * @author Jigme Lobsang Lepcha
 * @author Nakul Ramanathan
 */

import java.io.Serializable;

public class Person implements Serializable
{
    Credentials credentials;
    int typeOfUser;

    /**
     * Constructor to initialise the credentials
     * @param cred email, password and designation
     * @param typeOfUser type of user
     */
    Person(Credentials cred, int typeOfUser)
    {
        this.credentials = cred;
        this.typeOfUser = typeOfUser;
    }

    /**
     * Default Constructor
     */
    Person()
    {

    }
}
