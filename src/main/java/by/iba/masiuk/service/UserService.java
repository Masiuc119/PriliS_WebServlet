package by.iba.masiuk.service;

import by.iba.masiuk.exception.RepositoryException;
import by.iba.masiuk.exception.ServiceException;
import by.iba.masiuk.model.User;
import by.iba.masiuk.repository.RepositoryCreator;
import by.iba.masiuk.repository.SQLHelper;
import by.iba.masiuk.repository.UserRepository;
import by.iba.masiuk.repository.specification.UserByLogin;
import by.iba.masiuk.repository.specification.UserByLoginPassword;

import java.util.Optional;
public class UserService {
    public Optional<User> login(String login, byte[] password) throws
            ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            UserByLoginPassword params = new UserByLoginPassword(login, password);
            return userRepository.queryForSingleResult(SQLHelper.SQL_GET_USER,
                    params);
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
    public Integer save(User user) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            UserByLogin param = new UserByLogin(user.getLogin());
            if (!userRepository.queryForSingleResult(SQLHelper.SQL_CHECK_LOGIN,
                    param).isPresent()) {
                return userRepository.save(user);
            } else {
                return 0;
            }
        } catch (RepositoryException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }
}