package by.iba.masiuk.command.grouppersons;
import by.iba.masiuk.command.Command;
import by.iba.masiuk.command.CommandResult;
import by.iba.masiuk.exception.IncorrectDataException;
import by.iba.masiuk.exception.ServiceException;
import by.iba.masiuk.model.Person;
import by.iba.masiuk.service.PersonService;
import by.iba.masiuk.util.pages.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static by.iba.masiuk.command.grouppersons.constant.GroupConstant.LISTGROUP;

public class WelcomeCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse
            response)
            throws ServiceException, IncorrectDataException {
        PersonService personService = new PersonService();
        List<Person> clients = personService.findAll();
        if (!clients.isEmpty()) {
            request.setAttribute(LISTGROUP, clients);
        }
        return new CommandResult(Page.WELCOME_PAGE.getPage(), false);
    }
}