package il.ac.hit.mvcdemo.model;

import java.util.*;

import il.ac.hit.mvcdemo.ProductsDAOException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

public class ProductsDAO {
    private static ProductsDAO instance;
    private Map<Integer,Product> products = new Hashtable<Integer,Product>();

    public static ProductsDAO getInstance() {
        if(instance==null) {
            instance = new ProductsDAO();
        }
        return instance;
    }

    private ProductsDAO() {

        products.put(101,new Product(101,"Mosh Achashverosh",20));
        products.put(102,new Product(101,"Kalmar Yarok",20));
        //..
    }

    public Product getProduct(int id) throws ProductsDAOException {
        return products.get(id);
    }

    public void addProduct(Product prod) throws ProductsDAOException {
        //...
    }
}
