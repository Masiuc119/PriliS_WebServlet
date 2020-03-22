package by.iba.masiuk.dao;

import by.iba.masiuk.model.Person;
import by.iba.masiuk.util.ConnectorDB;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PersonDao {
    private final static String SQL_GET_PERSONS = "select * from person";
    private final static String SQL_INSERT_PERSON = "INSERT INTO person(namel,phone,email) VALUES (? ,?, ?)";
    private static Connection connection ;
    public PersonDao() {
        try {
            if (connection == null){
                connection = ConnectorDB.getConnection(); }
        }
        catch (SQLException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
    public void closeConnection(){
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void insertPerson(Person person) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement(SQL_INSERT_PERSON );
            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getPhone());
            preparedStatement.setString(3, person.getEmail());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Person> getPersons() {
        List<Person> persons = new LinkedList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_GET_PERSONS);
            Person person = null;
            while(resultSet.next()){
                person = new Person();
                person.setName(resultSet.getString("namel"));
                person.setPhone(resultSet.getString("phone"));
                person.setEmail(resultSet.getString("email"));
                persons.add(person);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }
}