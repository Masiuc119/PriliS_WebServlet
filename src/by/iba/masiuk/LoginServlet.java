package by.iba.masiuk;

import by.iba.masiuk.dao.UserDao;
import by.iba.masiuk.util.HashPassword;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request,
                          javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        UserDao daoUser = new UserDao();
        if (daoUser.isValidUser(name, HashPassword.getHash(password))) {
            request.getSession().setAttribute("username", name);
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie c : cookies) {
                    Cookie cookie = c;
                    System.out.println(cookie.getName() + cookie.getValue());
                    if (name.equals(cookie.getName())) {
                        request.setAttribute("lastdate", cookie.getValue());
                    }
                }
            }
            Cookie userCookie = new Cookie(name, LocalDateTime.now().toString());
            userCookie.setMaxAge(60 * 60 * 24 * 100); //хранить куки 100 дней
            response.addCookie(userCookie);
            request
                    .getRequestDispatcher("/GroupServlet")
                    .forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Неверный логин или пароль" + name+password);//неверный логин или пароль
            request.getRequestDispatcher("/WEB-INF/views/login.jsp")
                    .forward(request, response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request,
                         javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request
                .getRequestDispatcher("/WEB-INF/views/login.jsp")
                .forward(request, response);
    }
}