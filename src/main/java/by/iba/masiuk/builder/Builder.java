package by.iba.masiuk.builder;

import by.iba.masiuk.exception.RepositoryException;

import java.sql.ResultSet;

public interface Builder <T> {
    T build(ResultSet resultSet) throws RepositoryException;
}