package il.ac.hit.mvcdemo.model;

/**
 * Interface for the items
 * @author Sanad Satel , Melak Firdo
 * @since 2017
 */
public interface IToDoListDAO
{
    /**
     * adds new item to the items table in the database
     * @param item the properties of the item we want to add
     * @throws ToDoListException
     */
    public void addItem(Items item) throws ToDoListException;

    /**
     * gets all the items of a specific user from the items table in the database
     * @param user the properties of the user we want to get its items
     * @return an array of items (all the items of the user we entered)
     * @throws ToDoListException
     */
    public Items[] getItems(User user) throws ToDoListException;

    /**
     * gets single item from the items table in the database by the id of the item
     * @param id the id of the item we want to get
     * @return item properties (id, item name, description, user id)
     * @throws ToDoListException
     */
    public Items getItem(int id) throws ToDoListException;

    /**
     * updates an existing item from the items table in the database
     * @param item the item properties with the new description
     * @param id the id of the item we want to update
     * @throws ToDoListException
     */
    public void updateItem(Items item, int id) throws ToDoListException;

    /**
     * deletes an existing item from the items table in the database
     * @param id the id of the item we want to delete
     * @throws ToDoListException
     */
    public void deleteItem(int id) throws ToDoListException;
}


