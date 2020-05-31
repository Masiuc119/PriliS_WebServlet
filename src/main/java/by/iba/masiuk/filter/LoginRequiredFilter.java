package by.iba.masiuk.filter;

import by.iba.masiuk.command.session.SessionAttribute;
import by.iba.masiuk.util.pages.Page;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/controller")
public class LoginRequiredFilter implements Filter {
    private static final String COMMAND = "command";
    private static final String WELCOME = "welcome";
    private static final String ERROR_MESSAGE = "error_message";
    private static final String ERROR_TEXT = "Нет авторизации для выполнения данной команды";
    private static final Logger LOGGER =
            Logger.getLogger(LoginRequiredFilter.class.getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain
            chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        String command = request.getParameter(COMMAND);
        LOGGER.info("Filter is working " + COMMAND + "= " + command);
        if (!command.equals(WELCOME)) {
            chain.doFilter(req, resp);
        } else {
            if (request.getSession().getAttribute(SessionAttribute.NAME) != null)
            {
                chain.doFilter(req, resp);
            } else {
                request.setAttribute(ERROR_MESSAGE, ERROR_TEXT);
                request.getRequestDispatcher(Page.ERROR_PAGE.getPage()).forward(req, resp);
            }
        }
    }

    @Override
    public void destroy() {

    }
}