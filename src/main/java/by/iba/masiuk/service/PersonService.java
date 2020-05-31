package by.iba.masiuk.service;

import by.iba.masiuk.exception.RepositoryException;
import by.iba.masiuk.exception.ServiceException;
import by.iba.masiuk.model.Person;
import by.iba.masiuk.repository.PersonRepository;
import by.iba.masiuk.repository.RepositoryCreator;

import java.util.List;
public class PersonService {
    public List<Person> findAll() throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            PersonRepository personRepository =
                    repositoryCreator.getPersonRepository();
            return personRepository.findAll();
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
    public void save(Person person) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            PersonRepository personRepository =
                    repositoryCreator.getPersonRepository();
            personRepository.save(person);
        } catch (RepositoryException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }
}