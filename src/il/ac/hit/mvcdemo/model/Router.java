package il.ac.hit.mvcdemo.model;

//import il.ac.hit.mvcdemo.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.StringTokenizer;

/**
 * Servlet implementation class Router
 */
@WebServlet(value = "/Router")
public class Router extends HttpServlet {
    private static final long serialVersionUID = 1L;
    boolean isSuccess=false;
    private String linkTo;
    HibernateToDoListDAO htdl = HibernateToDoListDAO.getInstance();
    static User globalUser;

    /**
     * return the user that is signed in
     * @return globalUser
     */
    public static User getCurrentUser()
    {
        if (globalUser!=null)
           return globalUser;
        else return null;
    }

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Router() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        RequestDispatcher dispatcher = null;

        try{
            StringBuffer sb = request.getRequestURL();
            StringTokenizer tokenizer = new StringTokenizer(sb.toString(), "/");
            String actionToDo = request.getParameter("page");

            switch (actionToDo)
            {
                case "signUp":
                    signUp(request, response);
                    break;
                case "task":
                    task(request, response);
                    break;
                case "main":
                    main(request, response);
                case "signIn":
                    signIn(request, response);
            }
            if (linkTo!=null) {
                //dispatcher = request.getRequestDispatcher("task.jsp");
                if (linkTo.equals("task")) response.sendRedirect(linkTo + ".jsp");
                else {
                    dispatcher = request.getRequestDispatcher(linkTo + ".jsp");
                    dispatcher.forward(request, response);
                }
            }
        } catch (SecurityException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * method that adds the new user email and password from the app signUp button to the database
     * @param request HttpServletRequest to get the parameters of the user
     * @param response
     */
    public void signUp(HttpServletRequest request, HttpServletResponse response){

        boolean isSignUp = false;
        String firstName = request.getParameter("txt-first-name");
        String lastName = request.getParameter("txt-last-name");
        String email = request.getParameter("txt-email");
        String password = request.getParameter("txt-password");
        String passwordConfirm=(String)request.getParameter("txt-password-confirm");

        //register new user
        if(passwordConfirm.equals(password) && !password.equals("") && !passwordConfirm.equals("")
                && !firstName.equals("") && !lastName.equals("") && !email.equals("")){
            User registerUser = new User(firstName, lastName, password, email);
            htdl.addUser(registerUser);
            isSuccess=true;
            linkTo = "task";
         //  dispatcher = request.getRequestDispatcher("task.jsp");
//            try{
//               dispatcher.forward(request, response);
//
//            } catch (ServletException e){
//                e.printStackTrace();
//            } catch (IOException e){
//                e.printStackTrace();
            }
        //else {
//            request.setAttribute("error", "true");
//        }
    }


    public void task(HttpServletRequest request, HttpServletResponse response){
        try{
            String actionTask = request.getParameter("actionTask");

            switch (actionTask){
                case "addTask":
                    String itemName = request.getParameter("itemName");
                    String description = request.getParameter("description");

                    if(!itemName.equals("") && !description.equals("")){
                        Items item = new Items(itemName, description, globalUser.getUserId());
                        htdl.addItem(item);
                        isSuccess = true;
                        linkTo = "task";
                    }
                    break;
                case "deleteTask":
                    break;
                case "updateTask":
                    break;

            }
        }catch (ToDoListException todo){
            todo.printStackTrace();
        }
    }

    public void signIn(HttpServletRequest request, HttpServletResponse response){
        try{
            String email = request.getParameter("txt-email");
            String password = request.getParameter("txt-password");
            boolean emailFromDataBase = htdl.getUserByEmail(email, password);


            if(emailFromDataBase){
                isSuccess = true;
                linkTo = "task";
                globalUser = htdl.getUser(email);
            }
        }catch (ToDoListException se){
            se.printStackTrace();
        }


    }

    public void main(HttpServletRequest request, HttpServletResponse response){
        String goTo = request.getParameter("main");

        if(goTo != null){
            linkTo=goTo;
        }else{
            linkTo="main";
        }
    }
}
