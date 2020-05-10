package by.iba.masiuk.util;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectorDBTest {
    // это плохой тест - он использует зависимые объекты
    @Test
    public void testGetConnection() throws IllegalAccessException, SQLException, InstantiationException {
//give
        Connection connection = ConnectorDB.getConnection();
//when
//then
        Assert.assertNotNull(connection);
    }
}