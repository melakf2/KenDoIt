package il.ac.hit.mvcdemo.model;

/**
 * Interface for the users
 * @author Sanad Satel , Melak Firdo
 * @since 2017
 */
public interface IUserDAO
{
    /**
     * adds new user to the users table in the database
     * @param user the user properties we want to add
     * @throws ToDoListException
     */
    public void addUser(User user) throws ToDoListException;

    /**
     * deletes existing user from the users table in the database by username
     * @param userID the id of username we want to delete
     * @throws ToDoListException
     */
    public void deleteUser(int userID) throws ToDoListException;

    /**
     * gets an existing user from the users table in the database by username
     * @param userEmail the email of the user we want to get
     * @return user properties (id, name, password)
     * @throws ToDoListException
     */
    public User getUser(String userEmail) throws ToDoListException;

    /**
     * check if the email and the password exists in the database
     * @param email the email we want to check in the database
     * @param password the password we want to check in the database
     * @return true if the email and password exists and false other
     * @throws ToDoListException
     */
    public boolean getUserByEmail(String email, String password) throws ToDoListException;

}
