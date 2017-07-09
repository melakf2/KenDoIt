package il.ac.hit.mvcdemo.model;

/**
 * Exception that is thrown when there is an error in HibernateToDoListDAO
 * @author Sanad Satel , Melak Firdo
 * @since 2017
 */
public class ToDoListException extends RuntimeException
{
    /**
     * Exception with the cause
     * @param root
     */
    public ToDoListException(Throwable root) {
        super(root);
    }

    /**
     * Exception with the message and the cause of the exception
     * @param msg
     * @param rootcause
     */
    public ToDoListException(String msg, Throwable rootcause) {
        super(msg, rootcause);
    }

    /**
     * Exception with the message of the exception
     * @param s
     */
    public ToDoListException(String s) {
        super(s);
    }
}
