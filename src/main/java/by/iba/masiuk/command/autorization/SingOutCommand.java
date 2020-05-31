package by.iba.masiuk.command.autorization;

import by.iba.masiuk.command.Command;
import by.iba.masiuk.command.CommandResult;
import by.iba.masiuk.command.session.SessionAttribute;
import by.iba.masiuk.exception.IncorrectDataException;
import by.iba.masiuk.exception.ServiceException;
import by.iba.masiuk.util.pages.Page;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SingOutCommand implements Command {
    private static final Logger LOGGER =
            Logger.getLogger(SingOutCommand.class.getName());
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse
            response) throws ServiceException, IncorrectDataException {
        HttpSession session = request.getSession();
        String username =
                (String)session.getAttribute(SessionAttribute.NAME);
        LOGGER.info("user was above: name:" + username);
        session.removeAttribute(SessionAttribute.NAME);
        return new CommandResult(Page.LOGIN_PAGE.getPage(), false);
    }
}