package il.ac.hit.mvcdemo.model;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that applies the to do list system, implements the interfaces IToDoListDAO and IUserDAO, using hibernate library
 * @author Sanad Satel , Melak Firdo
 * @since 2017
 */
public class HibernateToDoListDAO implements IToDoListDAO, IUserDAO
{
    SessionFactory factory = new AnnotationConfiguration().configure().buildSessionFactory();
    private static HibernateToDoListDAO singleton ;
    Session session;

    private HibernateToDoListDAO(){}

    public static HibernateToDoListDAO getInstance()
    {
        if(singleton==null) {
            singleton = new HibernateToDoListDAO();
        }
        return singleton;
    }

    /**
     * Adds new item to the items table in the Database
     * @param item the item to add to the table
     * @throws ToDoListException
     */
    @Override
    public void addItem(Items item) throws ToDoListException
    {
        session = factory.openSession();

        try
        {
            session.beginTransaction();
            if (item != null)
            {
                int userId = item.getUserId();
                Query query = session.createQuery("from User where userId =:USER_ID");
                query.setParameter("USER_ID", userId);
                User user = (User) query.uniqueResult();
                //if the user we are trying to add the item to is exist
                if (user != null)
                {
                        session.save(item);
                        session.getTransaction().commit();
                }
                else
                {
                    System.out.println("The user you trying to add the item to does not exists");
                }
            }
        }
        catch(HibernateException e)
        {
            System.out.println("Add exe");
            session.getTransaction().rollback();
            e.printStackTrace();
            throw new ToDoListException("add item error");
        }
        finally
        {
            if(session != null) { session.close(); }
        }
    }

    /**
     * Gets the items of a specific user
     * @param user the user we want to get his items
     * @return Items[] an array of user's items
     * @throws ToDoListException
     */
    @Override
    public Items[] getItems(User user) throws ToDoListException
    {
        session = factory.openSession();

        List<Items> allItems = new ArrayList<>();

        try
        {
            //session.beginTransaction();
            session.getTransaction().begin();
            if (user != null)
            {
                Query query = session.createQuery("from Items where userId =:USERID");
                query.setParameter("USERID", user.getUserId());
                allItems = query.list();

                session.getTransaction().commit();
            }
        }
        catch(HibernateException e)
        {
            session.getTransaction().rollback();
            e.printStackTrace();
            throw new ToDoListException("get items error");
        }
        finally
        {
            if(session != null)
            {
                session.close();
            }
        }

        Items[] itms = new Items[allItems.size()];
        itms = allItems.toArray(itms);

        return itms;
    }

    /**
     * Gets a specific item from the Database
     *
     * @param id the id of the item we want to get
     * @return Items
     * @throws ToDoListException
     */
    @Override
    public Items getItem(int id) throws ToDoListException
    {
        Items item = null;
		session = factory.openSession();

		try
        {
			session.beginTransaction();
			Query query = session.createQuery("from Items where id =:ID");
			query.setParameter("ID", id);
			item = (Items) query.list().get(0);

			session.getTransaction().commit();
		}
		catch(HibernateException e)
        {
			session.getTransaction().rollback();
			e.printStackTrace();
            throw new ToDoListException("get item error");
        }
		finally
        {
			if(session != null) { session.close(); }
		}
		return item;
    }

    /**
     * Updates an item in the Database
     *
     * @param item the item we want to update
     * @throws ToDoListException
     */
    @Override
    public void updateItem(Items item, int itemId) throws ToDoListException
    {
        session = factory.openSession();
        String description = item.getDescription();

        try
        {
            session.beginTransaction();

            Query query = session.createQuery("from Items where id =:ItemId");
            query.setParameter("ItemId", itemId);
            item = (Items) query.uniqueResult();

            //if the item that we are trying to update is exist
            if (item != null)
            {
                item.setDescription(description);
                session.update(item);
                session.getTransaction().commit();
            }
            else
            {
                System.out.println("item id does not exist");
            }

        }
        catch (HibernateException e)
        {
            session.getTransaction().rollback();
            e.printStackTrace();
            throw new ToDoListException("add item error");
        }
        finally
        {
            if(session != null) { session.close(); }
        }
    }

    /**
     * delete a specific item from the table in the database
     * @param id the id of the item we want to delete
     * @throws ToDoListException
     */
    @Override
    public void deleteItem(int id) throws ToDoListException
    {
        session = factory.openSession();

        try
        {
            session.beginTransaction();
            Query query = session.createQuery("delete Items where id = :ID");
            query.setParameter("ID", id);
            query.executeUpdate();

            session.getTransaction().commit();
        }
        catch(Exception e)
        {
            session.getTransaction().rollback();
            e.printStackTrace();
            throw new ToDoListException("delete item error");
        }
        finally
        {
            if(session != null) { session.close(); }
        }
    }

    /**
     * adds new user to the users table in the database
     * @param user the user we want to add to the table
     * @throws ToDoListException
     */
    @Override
    public void addUser(User user) throws ToDoListException
    {
        session = factory.openSession();

        try
        {
            session.beginTransaction();
            if (user != null)
            {
                String username = user.getUserFirstName();
                Query query = session.createQuery("from User where userFirstName =:UserName");
                query.setParameter("UserName", username);
                User userTmp = (User) query.uniqueResult();

                // if the user that we are trying to add exists
                if (userTmp != null)
                {
                    System.out.println("User already exists");
                }
                else
                {
                    session.save(user);
                    session.getTransaction().commit();
                }
            }
        }
        catch (HibernateException e)
        {
            session.getTransaction().rollback();
            e.printStackTrace();
            throw new ToDoListException("add user error");
        }
        finally
        {
            if(session != null) { session.close(); }
        }
    }

    /**
     * deletes a user from the users table in the database
     * @param userID the id of the user we want to delete
     * @throws ToDoListException
     */
    @Override
    public void deleteUser(int userID) throws ToDoListException
    {
        session = factory.openSession();

        try
        {
            session.beginTransaction();
            Query query = session.createQuery("delete User where userId = :USERID");
            query.setParameter("USERID", userID);
            query.executeUpdate();

            session.getTransaction().commit();
        }
        catch (HibernateException e)
        {
            session.getTransaction().rollback();
            e.printStackTrace();
            throw new ToDoListException("delete user error");
        }
        finally
        {
            if(session != null) { session.close(); }
        }
    }

    /**
     * gets  user from the users table in the database
     * @return the user we want to get
     * @throws ToDoListException
     */
    @Override
    public User getUser(String userEmail) throws ToDoListException
    {
        User user = null;
        session = factory.openSession();

        try
        {
            session.beginTransaction();
            Query query = session.createQuery("from User where email =:EMAIL");
            query.setParameter("EMAIL", userEmail);
            user = (User) query.list().get(0);

            session.getTransaction().commit();
        }
        catch(HibernateException e)
        {
            session.getTransaction().rollback();
            e.printStackTrace();
            throw new ToDoListException("get user error");
        }
        finally
        {
            if(session != null) { session.close(); }
        }

        return user;
    }



    @Override
    public boolean getUserByEmail(String email, String password) throws ToDoListException {
        User user = null;
        boolean isEmailExist = false;
        session = factory.openSession();

        try
        {
            session.beginTransaction();

            Query query = session.createQuery("from User where email =:EMAIL and userPassword =:UserPassword");
            query.setParameter("EMAIL", email);
            query.setParameter("UserPassword", password);
            user = (User) query.list().get(0);
            session.getTransaction().commit();
            isEmailExist = true;
        }
        catch(HibernateException e)
        {
            session.getTransaction().rollback();
            e.printStackTrace();
            throw new ToDoListException("get user error");
        }
        finally
        {
            if(session != null) { session.close(); }
            return isEmailExist;
        }
    }
}
