package by.iba.masiuk.command.autorization;

import by.iba.masiuk.command.Command;
import by.iba.masiuk.command.CommandResult;
import by.iba.masiuk.exception.IncorrectDataException;
import by.iba.masiuk.exception.ServiceException;
import by.iba.masiuk.model.User;
import by.iba.masiuk.service.UserService;
import by.iba.masiuk.util.HashPassword;
import by.iba.masiuk.util.pages.Page;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

import static by.iba.masiuk.command.autorization.constant.AuthConstants.*;
import static java.util.Optional.of;
import static org.apache.commons.lang3.StringUtils.isEmpty;

public class RegisterNewUserCommand implements Command {
    private static final Logger LOGGER =
            Logger.getLogger(RegisterNewUserCommand.class.getName());
    private CommandResult forwardToRegisterWithError(HttpServletRequest request,
                                                     String ERROR, String ERROR_MESSAGE) {
        request.setAttribute(ERROR, ERROR_MESSAGE);
        return new CommandResult(Page.REGISTER_PAGE.getPage(), false);
    }
    private CommandResult forwardToLogin(HttpServletRequest request) {
        return new CommandResult(Page.LOGIN_PAGE.getPage(), false);
    }
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse
            response) throws ServiceException, IncorrectDataException {
        Optional<String> login = of(request)
                .map(httpServletRequest ->
                        httpServletRequest.getParameter(NAME_FOR_REGISTER));
        Optional<String> password = of(request)
                .map(httpServletRequest ->
                        httpServletRequest.getParameter(PASSWORD_FOR_REGISTER));
        if (isEmpty(login.get()) || isEmpty(password.get())) {
            LOGGER.info("invalid login or password format was received:" + login +
                    " " + password);
            return forwardToRegisterWithError(request, REGISTER_ERROR,
                    ERROR_MESSAGE_TEXT);
        }
        byte[] pass = HashPassword.getHash(password.get());
        User user = new User(login.get(), pass);
        UserService userService = new UserService();
        int userCount = userService.save(user);
        if (userCount != 0) {
            LOGGER.info("user was registered: login:" + login + " password:" +
                    password);
            return forwardToLogin(request);
        } else {
            LOGGER.info("invalid login or password format was received:" + login +
                    " " + password);
            return forwardToRegisterWithError(request, REGISTER_ERROR,
                    REGISTER_ERROR_MESSAGE_IF_EXIST);
        }
    }
}