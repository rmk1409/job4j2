package ru.job4j.tracker;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Roman on 11.04.2020
 */
public class TrackerSQL implements ITracker, AutoCloseable {
    private static final Logger LOGGER = LogManager.getLogger(TrackerSQL.class);
    private Connection connection;

    public boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
            var script = "CREATE TABLE IF NOT EXISTS item("
                    + "    id serial primary key,"
                    + "    name text"
                    + ")";
            Statement st = this.connection.createStatement();
            st.execute(script);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new IllegalStateException(e);
        }
        return this.connection != null;
    }

    @Override
    public void close() throws Exception {
        if (this.connection != null) {
            this.connection.close();
        }
    }

    @Override
    public Item add(Item item) {
        var sql = "insert into item(name) values(?);";
        try {
            var statement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, item.getName());
            statement.executeUpdate();
            var generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                item.setId(generatedKeys.getLong(1));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(Long id, Item item) {
        var result = false;
        var sql = "update item set name = ? where id = ?";
        try {
            var statement = this.connection.prepareStatement(sql);
            statement.setString(1, item.getName());
            statement.setLong(2, id);
            result = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(Long id) {
        var result = false;
        var sql = "delete from item where id = ?";
        try {
            var statement = this.connection.prepareStatement(sql);
            statement.setLong(1, id);
            result = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        var result = new ArrayList<Item>();
        var sql = "select * from item";
        try {
            var resultSet = this.connection.createStatement().executeQuery(sql);
            while (resultSet.next()) {
                result.add(new Item(resultSet.getLong("id"), resultSet.getString("name")));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findByName(String name) {
        var result = new ArrayList<Item>();
        var sql = "select * from item where name = ?";
        try {
            var statement = this.connection.prepareStatement(sql);
            statement.setString(1, name);
            var resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result.add(new Item(resultSet.getLong("id"), resultSet.getString("name")));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Item findById(Long id) {
        Item result = null;
        var sql = "select * from item where id = ?";
        try {
            var statement = this.connection.prepareStatement(sql);
            statement.setLong(1, id);
            var resultSet = statement.executeQuery();
            if (resultSet.next()) {
                result = new Item(id, resultSet.getString("name"));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return result;
    }

    public void cleadDB() {
        var sql = "delete from item";
        try {
            this.connection.createStatement().execute(sql);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
            e.printStackTrace();
        }
    }
}
