package com.epam.mentoring.module09.services;

import com.epam.mentoring.module09.beans.Cab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class CabsHelloService {

    private JdbcTemplate jdbcTemplate;
//    private SimpleJdbcInsert jdbcInsert;
//    private NamedParameterJdbcTemplate namedTemplate;

    @Autowired
    public void setBasicDataSource(DataSource basicDataSource) {
        jdbcTemplate = new JdbcTemplate(basicDataSource);
//        jdbcInsert = new SimpleJdbcInsert(basicDataSource).withTableName("cab");
//        namedTemplate = new NamedParameterJdbcTemplate(basicDataSource);
    }

//    public List<Cab> getCabs() {
//        String URL = "jdbc:mysql://localhost:3306/ammcars";
//        Properties properties = new Properties();
//        properties.setProperty("user", "root");
//        properties.setProperty("password", "root");
//
//        List<Cab> cabs = new ArrayList<>();
//        try {
//            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return cabs;
//        }
//
//        try (   Connection connectionJava7 = DriverManager.getConnection(URL, properties);
//                PreparedStatement statementJava7 = connectionJava7.prepareStatement("SELECT * FROM cab ")) {
//
//             ResultSet resultSetJava7 = statementJava7.executeQuery();
//
//             while (resultSetJava7.next()) {
//                 cabs.add(new Cab(resultSetJava7.getString("car_make")));
//             }
//
//             resultSetJava7.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return cabs;
//    }

    public List<Cab> getCabs() {
        return jdbcTemplate.query("SELECT * FROM cab",
                                   (rs, rowNumber) -> new Cab(rs.getString("car_make")));
    }

    public String getRandomCabName() {
        return "Crazy BMW";
    }
}
