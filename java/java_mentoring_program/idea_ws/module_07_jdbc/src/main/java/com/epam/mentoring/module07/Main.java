package com.epam.mentoring.module07;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Random;

public class Main {
    public static String URL = "jdbc:mysql://localhost:3306/ammcars";
    public static String USER = "root";
    public static String PASS = "";

    public static void main(String[] args) {
        System.out.println("Java Mentoring Program - Module 07");
        Logger logger = LogManager.getRootLogger();
        logger.debug("Java Mentoring Program - Module 07");

        // Options to save some data for application:
        // - don't save data
        // - *.txt, *.csv, *.xml, *.json file (common formats)
        // - specially organized files (specific formats)
        // - SQL database
        // - NoSQL database
        // - keep all data in memory

        // SQL command types:
        // - DDL - Data Definition Language (CREATE TABLE, ALTER TABLE, DROP TABLE etc.)
        // - DML - Data Manipulation Language (Insert, DELETE etc.)
        // - DCL - Data Control Language
        // - TCL - Transaction Control Language

        // Normal forms:
        // 0 -
        // 1 -
        // 2 -
        // 3 -

        // SQL JOINs

        // JDBC - Java Data Base Connectivity

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        try {
            connection = DriverManager.getConnection(URL + "?user=" + USER + "&password=" + PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        Properties properties = new Properties();
        properties.setProperty("user", USER);
        properties.setProperty("password", PASS);

        Statement statement = null;

        try {
            connection = DriverManager.getConnection(URL, properties);

            logger.debug("Current catalog " + connection.getCatalog());
            logger.debug("Current transaction isolation " + connection.getTransactionIsolation());

            statement = connection.createStatement();
            if (statement.execute("CREATE TABLE IF NOT EXISTS users(id INT NOT NULL AUTO_INCREMENT, name VARCHAR(10), PRIMARY KEY(id) )")) {
                logger.debug("Table was successfully created.");
                statement.execute("DROP TABLE users");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        ResultSet result = null;

        try {
            connection = DriverManager.getConnection(URL, properties);

            statement = connection.createStatement();
            result = statement.executeQuery("SELECT * FROM drivers WHERE lastname LIKE 'Ra%'");

            while (result.next()) {
                logger.debug(result.getRow() + " " + result.getString(2) + " " +
                        result.getString("lastname") + " " +
                        result.getDate("birthdate").toLocalDate().getYear());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        try (Connection connectionJava7 = DriverManager.getConnection(URL, properties);
            Statement statementJava7 = connectionJava7.createStatement();
            ResultSet resultSetJava7 = statementJava7.executeQuery("SELECT * FROM drivers WHERE lastname LIKE 'Ra%'")) {

            while (resultSetJava7.next()) {
                logger.debug(resultSetJava7.getRow() + " " + resultSetJava7.getString(2) + " " +
                        resultSetJava7.getString("lastname") + " " +
                        resultSetJava7.getDate("birthdate").toLocalDate().getYear());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection connectionJava7 = DriverManager.getConnection(URL, properties);
            PreparedStatement statementJava7 = connectionJava7.prepareStatement("SELECT * FROM cab WHERE capacity = ?")) {

            for (int i = 0; i < 30; ++i) {
                statementJava7.setInt(1, i);
                ResultSet resultSetJava7 = statementJava7.executeQuery();

                while (resultSetJava7.next()) {
                    logger.debug(resultSetJava7.getString("car_make"));
                }

                resultSetJava7.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection connectionJava7 = DriverManager.getConnection(URL, properties);
             CallableStatement statementJava7 = connectionJava7.prepareCall("CALL getAllCars");
             ResultSet resultSetJava7 = statementJava7.executeQuery()) {

            while (resultSetJava7.next()) {
                logger.debug(resultSetJava7.getString("car_make"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        Properties propertiesFromFile = new Properties();
        try {
            propertiesFromFile.load(new FileInputStream("module_07_jdbc/out/production/resources/jdbc.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Connection connectionJava7 = DriverManager.getConnection(
                propertiesFromFile.getProperty("jdbc.url"),
                propertiesFromFile.getProperty("jdbc.username"),
                propertiesFromFile.getProperty("jdbc.password"));
             CallableStatement statementJava7 = connectionJava7.prepareCall("CALL getAllCars");
             ResultSet resultSetJava7 = statementJava7.executeQuery()) {

            while (resultSetJava7.next()) {
                logger.debug(resultSetJava7.getString("car_make"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Cursors
        // Scrollable and Non-scrollable

        logger.debug("CURSORS:");

        try (Connection connectionJava7 = DriverManager.getConnection(
                propertiesFromFile.getProperty("jdbc.url"),
                propertiesFromFile.getProperty("jdbc.username"),
                propertiesFromFile.getProperty("jdbc.password"));
              PreparedStatement statementJava7 = connectionJava7.prepareStatement("SELECT * FROM taxi_ride",
                      ResultSet.TYPE_SCROLL_INSENSITIVE,
                      ResultSet.CONCUR_READ_ONLY);
              ResultSet resultSetJava7 = statementJava7.executeQuery()) {

            resultSetJava7.first();
            logger.debug("First " + resultSetJava7.getRow() + " "
                    + resultSetJava7.getString("start_point") + " "
                    + resultSetJava7.getString("end_point"));

            resultSetJava7.last();
            logger.debug("Last " + resultSetJava7.getRow() + " "
                    + resultSetJava7.getString("start_point") + " "
                    + resultSetJava7.getString("end_point"));

            resultSetJava7.afterLast();

            while (resultSetJava7.previous()) {
                logger.debug("Row " + resultSetJava7.getRow() + " "
                        + resultSetJava7.getString("start_point") + " "
                        + resultSetJava7.getString("end_point"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection connectionJava7 = DriverManager.getConnection(
                propertiesFromFile.getProperty("jdbc.url"),
                propertiesFromFile.getProperty("jdbc.username"),
                propertiesFromFile.getProperty("jdbc.password"));
             PreparedStatement statementJava7 = connectionJava7.prepareStatement("SELECT * FROM taxi_company",
                     ResultSet.TYPE_SCROLL_INSENSITIVE,
             //        ResultSet.CONCUR_READ_ONLY);  // NotUpdatable exception
                     ResultSet.CONCUR_UPDATABLE);
             ResultSet resultSetJava7 = statementJava7.executeQuery()) {

            resultSetJava7.afterLast();

            while (resultSetJava7.previous()) {
                int rate = resultSetJava7.getInt(4);
                resultSetJava7.updateInt(4, rate + 1);
                resultSetJava7.updateRow();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection connectionJava7 = DriverManager.getConnection(
                propertiesFromFile.getProperty("jdbc.url"),
                propertiesFromFile.getProperty("jdbc.username"),
                propertiesFromFile.getProperty("jdbc.password"));
                      PreparedStatement statementJava7 = connectionJava7.prepareStatement("SELECT * FROM taxi_company",
                              ResultSet.TYPE_SCROLL_INSENSITIVE,
                              ResultSet.CONCUR_UPDATABLE);
                      ResultSet resultSetJava7 = statementJava7.executeQuery()) {

            resultSetJava7.afterLast();

            while (resultSetJava7.previous()) {
                int rate = resultSetJava7.getInt(4);
                resultSetJava7.updateInt(4, rate - 1);
                resultSetJava7.updateRow();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection connectionJava7 = DriverManager.getConnection(
                propertiesFromFile.getProperty("jdbc.url"),
                propertiesFromFile.getProperty("jdbc.username"),
                propertiesFromFile.getProperty("jdbc.password"));
             PreparedStatement statementJava7 = connectionJava7.prepareStatement("SELECT * FROM taxi_company",
                     ResultSet.TYPE_SCROLL_INSENSITIVE,
                     ResultSet.CONCUR_UPDATABLE);
             ResultSet resultSetJava7 = statementJava7.executeQuery()) {

            resultSetJava7.last();
            resultSetJava7.moveToInsertRow();
            resultSetJava7.updateInt(1, 4);
            resultSetJava7.updateString(2, "NETT");
            resultSetJava7.updateString(3,"default city");
            resultSetJava7.updateInt(4, 888);
            resultSetJava7.insertRow();

            resultSetJava7.beforeFirst();
            while (resultSetJava7.next()) {
                logger.debug("Row " + resultSetJava7.getRow() + " "
                        + resultSetJava7.getString(2));
            }

            resultSetJava7.last();
            resultSetJava7.deleteRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Batches & Transactions

        // Transaction principles:
        // Atomicity
        // Consistency
        // Isolation
        // Durability

        // States of transaction
        // Active
        // Partially committed
        // Failed
        // Aborted
        // Committed

        // Save points in transaction

        logger.debug("BATCHES & TRANSACTIONS:");

        try (Connection connectionJava7 = DriverManager.getConnection(
                propertiesFromFile.getProperty("jdbc.url"),
                propertiesFromFile.getProperty("jdbc.username"),
                propertiesFromFile.getProperty("jdbc.password"));
             PreparedStatement statementJava7 = connectionJava7.prepareStatement("SELECT * FROM drivers WHERE sex = ?",
                     ResultSet.TYPE_SCROLL_INSENSITIVE,
                     ResultSet.CONCUR_UPDATABLE);
             PreparedStatement updateStatement = connectionJava7.prepareStatement("UPDATE drivers SET sex = ? WHERE id = ?")) {

            statementJava7.setString(1, "M");
            ResultSet allMen = statementJava7.executeQuery();

            while (allMen.next()) {
                logger.debug(allMen.getRow() + " " + allMen.getString("firstname"));
            }

            updateStatement.setString(1, "F");
            updateStatement.setInt(2, 3);
            updateStatement.executeUpdate();

            if (new Random().nextBoolean()) {
                throw new SQLException("Transaction crashed!");
            }

            updateStatement.setString(1, "M");
            updateStatement.setInt(2, 2);
            updateStatement.executeUpdate();

            logger.debug("Changes complete");

            statementJava7.setString(1, "F");
            ResultSet allWomen = statementJava7.executeQuery();

            while (allWomen.next()) {
                logger.debug(allWomen.getRow() + " " + allWomen.getString("firstname"));
            }

            updateStatement.setString(1, "M");
            updateStatement.setInt(2, 3);
            updateStatement.executeUpdate();

            updateStatement.setString(1, "F");
            updateStatement.setInt(2, 2);
            updateStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }
}
