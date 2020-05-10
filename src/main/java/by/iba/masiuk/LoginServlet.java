package by.iba.masiuk;

import by.iba.masiuk.dao.UserDao;
import by.iba.masiuk.util.HashPassword;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

import static java.util.Optional.of;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {
/*    protected void doPost(javax.servlet.http.HttpServletRequest request,
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
            request.getRequestDispatcher("/views/login.jsp")
                    .forward(request, response);
        }
    }*/


    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
       // response.setCharacterEncoding("UTF-8");
        Optional<String> name = of(request).map(httpServletRequest -> httpServletRequest.getParameter("name"));
        Optional<String> password = of(request).map(httpServletRequest -> httpServletRequest.getParameter("password"));
        if (!name.isPresent() || !password.isPresent()) {
            request.setAttribute("errorMessage", "Неверный логин или пароль, заполните все поля");
            request.getRequestDispatcher("/views/login.jsp").forward(request, response);
        }
        else {
            UserDao daoUser = new UserDao();
            if (daoUser.isValidUser(name.get(), HashPassword.getHash(password.get()))) {
                request.getSession().setAttribute("username", name.get());
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
                Cookie userCookie = new Cookie(name.get(), LocalDateTime.now().toString());
                userCookie.setMaxAge(60 * 60 * 24 * 100); //хранить куки 100 дней
                response.addCookie(userCookie);
                request
                        .getRequestDispatcher("/GroupServlet")
                        .forward(request, response);
            } else {
                request.setAttribute("errorMessage", "Неверный логин или пароль" + name.get() + password.get());//неверный логин или пароль
                request.getRequestDispatcher("/views/login.jsp")
                        .forward(request, response);
            }
        }
    }
    protected void doGet(javax.servlet.http.HttpServletRequest request,
                         javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request
                .getRequestDispatcher("/views/login.jsp")
                .forward(request, response);
    }
}