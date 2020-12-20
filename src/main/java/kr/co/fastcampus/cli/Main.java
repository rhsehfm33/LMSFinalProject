package kr.co.fastcampus.cli;

import kr.co.fastcampus.cli.aop.TransactionBean;
import kr.co.fastcampus.cli.service.MyService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.sql.*;

@Slf4j
@Configuration
@ComponentScan(basePackageClasses = Main.class)
public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.register(TransactionBean.class);
        context.refresh();

        createTable(context.getBean(Connection.class));

        Dao dao = context.getBean(Dao.class);
        dao.insert();
        dao.print();

        context.close();
    }

    public static void createTable(Connection connection) throws SQLException {
        connection.createStatement()
                .execute("create table member(id int auto_increment, username varchar(255) not null, password varchar(255) not null, primary key(id))");
    }
}
