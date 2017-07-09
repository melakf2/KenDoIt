package il.ac.hit.mvcdemo.model;

/**
 * Class for the items of the to do list
 * @author Sanad Satel , Melak Firdo
 * @since 2017
 */
public class Items
{
    private int id;
    private String itemName;
    private String description;
    private int userId;

    /**
     * default constructor
     */
    public Items(){}

    /**
     * constructor that initializes the item with name, description and user id
     * @param itemName
     * @param description
     * @param userId
     */
    public Items(String itemName, String description, int userId)
    {
        this.itemName = itemName;
        this.description = description;
        this.userId = userId;
    }

    /**
     * gets the item id
     * @return item id
     */
    public int getId() {
        return id;
    }

    /**
     * sets the item id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * gets the name of the item
     * @return the name of the item
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * sets the name of the item
     * @param itemName
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * gets description about the item
     * @return string description about the item
     */
    public String getDescription() {
        return description;
    }

    /**
     * sets the item's description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * gets the id of the user that belongs to the item
     * @return user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * sets the id of the user that belongs to the item
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * implementation of the method toString
     * @return string that includes the item properties
     */
    @Override
    public String toString()
    {
        return ("item id: " + this.id + " item name: " + this.itemName +
                " description: " + this.description);
    }
}
