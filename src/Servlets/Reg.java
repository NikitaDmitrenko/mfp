package Servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Nikita on 16.09.2015.
 */
public class Reg extends HttpServlet {
    //Объявление констант для доступа в базу данных : URL-путь к БД, USERNAME - имя пользователя БД ,Password - Пароль к БД;
    private static final String URL = "jdbc:mysql://localhost:3306/streamusers";
    private static final String USERNAME="root";
    private static final String PASSWORD="root";
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //Получаем значения с формочки
        int id = Integer.parseInt(request.getParameter("id"));
        String login = request.getParameter("login");
        String password = request.getParameter("password");
       /* String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));
        String vk = request.getParameter("vk");*/
        //Проверяем полученные данные
        out.println(id);
        out.println(login);
        out.println(password);
        /*out.println(email);
        out.println(age);
        out.println(vk);*/
        Connection connection = null;
        PreparedStatement preparedStatement = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                preparedStatement = connection.prepareStatement("INSERT INTO users VALUES (?,?,?,?,?,?)");
                preparedStatement.setInt(1,id);
                preparedStatement.setString(2, login);
                preparedStatement.setString(3,password);
                preparedStatement.setString(4,"");
                preparedStatement.setInt(5, 1);
                preparedStatement.setString(6, "");
                preparedStatement.executeUpdate();
            } catch (ClassNotFoundException|SQLException e) {
                out.println("<h1>Проблемы с загрузкой данных в бд</h1>");
            }finally {
            }
        out.println("<h1>Регистрация успешно завершена</h1>");
        out.println("<h1>Вас будет перенаправлено на страницу </h1>");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
    }
}
