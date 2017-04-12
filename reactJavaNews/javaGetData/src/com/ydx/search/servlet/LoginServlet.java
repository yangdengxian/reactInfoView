package com.ydx.search.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import com.data.book;

import com.ydx.search.util.User;

public class LoginServlet extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public LoginServlet() {
        super();
    }

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    /**
     * The doGet method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to get.
     * 
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

         //Add some codes
        doPost(request,response);
    }

    /**
     * The doPost method of the servlet. <br>
     *
     * This method is called when a form has its tag value method equals to post.
     * 
     * @param request the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws ServletException if an error occurred
     * @throws IOException if an error occurred
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String userName = request.getParameter("username");
         String password = request.getParameter("password");
         request.getSession().setAttribute("user", userName);      //将user放在Attribute中
         User user1=new User();
         user1.setUserName(userName);
         user1.setPassword(password);
         System.out.println(userName+" "+password);
         
         if(user1.validate())
         {
           
             request.getRequestDispatcher("index_new.html").forward(request, response); //校验用户名密码正确，跳转到welcome.jsp
              
         }
         else
         {
             request.getRequestDispatcher("login.html").forward(request, response);  //校验用户名密码不正确，跳转到index.jsp
             
         }
         
    }
    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    public void init() throws ServletException {
        // Put your code here
    }

}