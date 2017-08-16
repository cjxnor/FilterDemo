package servlet;

import util.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        User user1 = new User();
//        user1.setUsername(request.getParameter("username"));
//        user1.setPassword(request.getParameter("password"));

        String username = request.getParameter("username");
        String password = request.getParameter("password");

//        System.out.println(username + ":" + password);

        if(username.equals("admin") && password.equals("admin")){
            request.getSession().setAttribute("user1",username);
            request.getRequestDispatcher("/succeed.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/failed.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
