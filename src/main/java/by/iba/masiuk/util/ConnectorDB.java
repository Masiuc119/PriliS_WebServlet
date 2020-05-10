package by.iba.masiuk.util;


import org.apache.log4j.*;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;


public class ConnectorDB
{
    private static final Logger LOGGER = Logger.getLogger(ConnectorDB.class);
    public static Connection getConnection() throws SQLException, InstantiationException, IllegalAccessException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException | InvocationTargetException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        ResourceBundle resource = ResourceBundle.getBundle("db", Locale.getDefault());
        String url = resource.getString("db.url");
        String user = resource.getString("db.user");
        String pass = resource.getString("db.password");
        Properties p=new Properties();
        p.setProperty("user",user);
        p.setProperty("password",pass);
        p.setProperty("useUnicode", "true");
        p.setProperty("characterEncoding", "UTF-8");
        LOGGER.info("connection establish");
        return DriverManager.getConnection(url, p);
    }
}