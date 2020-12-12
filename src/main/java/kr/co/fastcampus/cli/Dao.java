package kr.co.fastcampus.cli;

import lombok.extern.slf4j.Slf4j;

import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
public class Dao {
    public void run() throws ClassNotFoundException {
        Class.forName("org.h2.Driver");
        var url = "jdbc:h2:mem:test;MODE=MySQL;";

        try (var connection = DriverManager.getConnection(url, "sa", "");
             var statement = connection.createStatement())   {

            connection.setAutoCommit(false);
            statement.execute("create table member(id int auto_increment, username varchar(255) not null, password varchar(255) not null, primary key(id))");
            try {
                statement.executeUpdate("insert into member(username, password) values('minseong', '1234')");
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
            }

            var resultSet = statement.executeQuery("select id, username, password from member");
            while (resultSet.next()) {
                Member member = new Member("minseong", "1234");
                log.info(member.toString());
            }
        } catch (SQLException e) {
        }
    }
}
