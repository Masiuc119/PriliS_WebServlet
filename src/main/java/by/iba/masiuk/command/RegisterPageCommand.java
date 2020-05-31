package by.iba.masiuk.command;

import by.iba.masiuk.exception.IncorrectDataException;
import by.iba.masiuk.exception.ServiceException;
import by.iba.masiuk.util.pages.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class RegisterPageCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse
            response) throws ServiceException, IncorrectDataException, ServiceException,
            IOException {
        System.out.println("REGISTER_PAGE");
        return new CommandResult(Page.REGISTER_PAGE.getPage(), false);
    }
}