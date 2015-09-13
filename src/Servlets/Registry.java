package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Created by Nikita on 12.09.2015.
 */@WebServlet(name = "registry",urlPatterns = "/registry")
public class Registry extends HttpServlet {
    private static final String URL = "jdbc:mysql://localhost:3306/streamusers";
    private static final String username = "root";
    private static final String password = "root";
    public static void insetValues(int id, String login, String passw, String email, int age, String vk) throws SQLException{
        PreparedStatement statement = null;
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL,username,password);
            statement = connection.prepareStatement("INSERT INTO users VALUES (?,?,?,?,?,?)");
            statement.setInt(1,id);
            statement.setString(2,login);
            statement.setString(3,passw);
            statement.setString(4,email);
            statement.setInt(5,age);
            statement.setString(6,vk);
            statement.executeUpdate();
        }catch (ClassNotFoundException|SQLException e){
            System.out.println("Something goes wrong with ur database connection");
            System.out.println("Look at logs");
        }finally{
        if(statement!=null){
            statement.close();
        }
            if(connection!=null){
                connection.close();
            }
    }
}
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        int id = Integer.parseInt(request.getParameter("id"));
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String  email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));
        String vk = request.getParameter("vk");
        try {
            insetValues(id,login,password,email,age,vk);
            out.println("<h1>Данные успешно записаны</h1>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.println("<html><body><h1>Success registration</h1></body></html>");
        out.flush();
        out.close();

    }
}
