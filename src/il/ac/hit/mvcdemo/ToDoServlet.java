package il.ac.hit.mvcdemo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import il.ac.hit.mvcdemo.model.*;

//@WebServlet(name = "ToDoServlet", urlPatterns = "/a")
//public class ToDoServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//    private static final HibernateToDoListDAO htdl = HibernateToDoListDAO.getInstance();
//
//    public ToDoServlet() {
//        super();
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        PrintWriter out = response.getWriter();
//
//        try{
//            StringBuffer sb = request.getRequestURL();
//            StringTokenizer tokenizer = new StringTokenizer(sb.toString(), "/");
//            String actionToDo = request.getParameter("page");
//
//            switch (actionToDo)
//            {
//                case "signUp":
//                    signUp(request, response);
//            }
//        } catch (SecurityException | IllegalArgumentException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void signUp(HttpServletRequest request, HttpServletResponse response){
//        RequestDispatcher dispatcher = null;
//        boolean isSignUp = false;
//        String firstName = request.getParameter("txt-first-name");
//        String lastName = request.getParameter("txt-last-name");
//        String email = request.getParameter("txt-email");
//        String password = request.getParameter("txt-password");
//        String passwordConfirm=(String)request.getParameter("txt-password-confirm");
//        //register new user
//        if(passwordConfirm.equals(password) && !password.equals("") && !passwordConfirm.equals("")
//                && !firstName.equals("") && !lastName.equals("") && !email.equals("")){
//            User registerUser = new User(firstName, lastName, email, password);
//            htdl.addUser(registerUser);
//            dispatcher = request.getRequestDispatcher("tasks.jsp");
//            try{
//                dispatcher.forward(request, response);
//            } catch (ServletException e){
//                e.printStackTrace();
//            } catch (IOException e){
//                e.printStackTrace();
//            }
//        } else {
//            request.setAttribute("error", "true");
//        }
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);
//    }
//
//}

//Router:
//package il.ac.hit.mvcdemo;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.util.StringTokenizer;
//
///**
// * Servlet implementation class Router
// */
//@WebServlet(name = "Router", urlPatterns = {"/"})
//public class Router extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public Router() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        PrintWriter out = response.getWriter();
//
//        try {
//            StringBuffer sb = request.getRequestURL();
//            // out.write(sb.toString());
//            StringTokenizer tokenizer = new StringTokenizer(sb.toString(), "/");
//            int numberOfTokens = tokenizer.countTokens();
//            tokenizer.nextToken();
//            tokenizer.nextToken();
//            tokenizer.nextToken();
//            tokenizer.nextToken();
//            String controller = tokenizer.nextToken();
//            String action = tokenizer.nextToken();
//            // out.println("controller="+controller+" action="+action);
//
//            controller = controller.substring(0, 1).toUpperCase()+controller.substring(1)+"Controller";
//            Class clazz = Class.forName("il.ac.hit.mvcdemo.controller." + controller);
//            Object ob = clazz.newInstance();
//            Method method = clazz.getMethod(action, HttpServletRequest.class, HttpServletResponse.class);
//            method.invoke(ob, request, response);
//            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/"+action+".jsp");
//            dispatcher.forward(request, response);
//
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//}
