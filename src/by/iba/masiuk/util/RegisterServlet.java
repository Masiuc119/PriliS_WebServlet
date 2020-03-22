package by.iba.masiuk.util;

import by.iba.masiuk.dao.UserDao;
import by.iba.masiuk.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("newLoginName");
        String password = request.getParameter("newPassword");
        UserDao daoUser = new UserDao();
        User user = new User(name,HashPassword.getHash(password));
        if (daoUser.insertUser(user)) {
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(
                    request, response);
        }
        else{
            request.setAttribute("errorRegister", "Выберите другое имя, такой пользователь существет");
            request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request
                .getRequestDispatcher("/WEB-INF/views/register.jsp")
                .forward(request, response);
    }
}