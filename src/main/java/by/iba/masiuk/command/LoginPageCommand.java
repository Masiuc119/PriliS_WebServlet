package by.iba.masiuk.command;

import by.iba.masiuk.exception.IncorrectDataException;
import by.iba.masiuk.exception.ServiceException;
import by.iba.masiuk.util.pages.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class LoginPageCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse
            response) throws ServiceException, IncorrectDataException {
        System.out.println("LOGIN PAGE");
        return new CommandResult(Page.LOGIN_PAGE.getPage(),false);
    }
}