package il.ac.hit.mvcdemo.model;

/**
 * Class for the user
 * @author Sanad Satel , Melak Firdo
 * @since 2017
 */
public class User
{
    private int userId;
    private String userFirstName;
    private String userLastName;
    private String userPassword;
    private String email;

    /**
     * constructor that initializes the user with name and password
     * @param userFirstName
     * @param userPassword
     */
    public User(String userFirstName, String userLastName, String userPassword, String userEmail) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userPassword = userPassword;
        this.email = userEmail;
    }

    /**
     * default constructor
     */
    public User(){}

    /**
     * gets user id
     * @return user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * sets user id
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * get first name
     * @return String firstName
     */
    public String getUserFirstName() {
        return userFirstName;
    }

    /**
     * set user first name
     * @param userFirstName
     */
    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    /**
     * gets the last name
     * @return String last name
     */
    public String getUserLastName() {
        return userLastName;
    }

    /**
     * set user name
     * @param userLastName
     */
    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    /**
     * gets user email
     * @return the password of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * set user email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * gets user password
     * @return the password of the user
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * sets user's password
     * @param userPassword
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     *implements toString method
     * @return string of the user properties
     */
    @Override
    public String toString()
    {
        return ("user id: " + this.userId + " name: " + this.userFirstName + " password: " + this.userPassword);
    }
}

