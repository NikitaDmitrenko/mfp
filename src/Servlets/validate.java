package Servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.io.IOException;
import java.sql.*;

/**
 * Created by Nikita on 17.09.2015.
 */
@WebServlet
public class validate extends HttpServlet {
    private static final String URL = "jdbc:mysql://localhost:3306/streamusers";
    private static final String USERNAME="root";
    private static final String PASSWORD="root";
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        Connection connection = null;
        Statement statement = null;
        ResultSet resultset = null;
        try {
            Class.forName("");
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            statement = connection.createStatement();
            resultset = statement.executeQuery("Select * FROM users");
            while(resultset.next()){
                String s2 = resultset.getString(2);
                String s3 = resultset.getString(3);
                if(s2.equalsIgnoreCase(request.getParameter("login"))||s3.equalsIgnoreCase(request.getParameter("password"))){
                    RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("journal.jsp");
                }
            }

        } catch (ClassNotFoundException|SQLException e) {
            e.printStackTrace();
        }

    }
}
