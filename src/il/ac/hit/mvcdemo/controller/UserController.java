//package il.ac.hit.mvcdemo.controller;
//
//import il.ac.hit.mvcdemo.model.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import il.ac.hit.mvcdemo.ProductsDAOException;
//
//
//public class UserController {
//
//    public void about(HttpServletRequest request, HttpServletResponse response) {
//        // ..
//    }
//
//    public void help(HttpServletRequest request, HttpServletResponse response) {
//        // ..
//    }
//
//    public void product(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Product product = ProductsDAO.getInstance().getProduct(id);
//        request.setAttribute("product", product);
//    }
//
//    public void add(HttpServletRequest request, HttpServletResponse response) {
//        String isbn = request.getParameter("isbn");
//        String title = request.getParameter("title");
//        String price = request.getParameter("price");
//
//        if(isbn!=null && title!=null && price!=null) {
//            int isbnNumber;
//            double priceNumber;
//            Product prod;
//
//            try {
//                isbnNumber = Integer.parseInt(isbn);
//                priceNumber = Double.parseDouble(price);
//                prod = new Product(isbnNumber,title,priceNumber);
//
//                ProductsDAO.getInstance().addProduct(prod);
//                request.setAttribute("error","0");
//            }
//            catch(ProductsDAOException e) {
//                request.setAttribute("error","1");
//            }
//            catch(NumberFormatException e) {
//                request.setAttribute("error","1");
//            }
//        } else {
//
//            //a request for getting the form
//
//        }
//    }
//
//
//    public void signUp(HttpServletRequest request, HttpServletResponse response){
//        String firstName = request.getParameter("txt-first-name");
//        String lastName = request.getParameter("txt-last-name");
//        String email = request.getParameter("txt-email");
//        String password = request.getParameter("txt-password");
//        HibernateToDoListDAO dao = HibernateToDoListDAO.getInstance();
//
//        if(firstName!=null && lastName!=null && email!=null && password!=null){
//            User user;
//
//            try{
//                user = new User(firstName, lastName, email, password);
//
//                dao.addUser(user);
//                request.setAttribute("error", "0");
//            }  catch(ProductsDAOException e) {
//                request.setAttribute("error","1");
//            }
//            catch(NumberFormatException e) {
//                request.setAttribute("error","1");
//            }
//        }
//    }
//
//    public void task(HttpServletRequest request, HttpServletResponse response){
//        String itemName = request.getParameter("name");
//        String description = request.getParameter("description");
//
//        if(itemName!=null && description!=null) {
//            Items item;
//            try {
//                item = new Items(itemName, description, 1);
//                //HibernateToDoListDAO.getInstance().addItem(item);
//                request.setAttribute("error","0");
//            }
//            catch(ProductsDAOException e) {
//                request.setAttribute("error","1");
//            }
//            catch(NumberFormatException e) {
//                request.setAttribute("error","1");
//            }
//        } else {
//
//            //a request for getting the form
//
//        }
//
//    }
//
//}
