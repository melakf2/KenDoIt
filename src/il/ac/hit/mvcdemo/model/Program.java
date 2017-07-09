package il.ac.hit.mvcdemo.model;

public class Program {
    public static void main(String[] args) {
        HibernateToDoListDAO dao = HibernateToDoListDAO.getInstance();
//        dao.deleteItem(35);
        dao.addUser(new User("kakk","lascct", "passs", "email@g.com"));
        boolean f = dao.getUserByEmail("sanad", "ghh");
        System.out.println(f);
    }
}