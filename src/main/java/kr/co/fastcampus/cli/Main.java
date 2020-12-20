package kr.co.fastcampus.cli;

import kr.co.fastcampus.cli.config.AppConfig;
import kr.co.fastcampus.cli.controller.MemberController;
import kr.co.fastcampus.cli.dao.MemberDao;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Scanner;

@Slf4j
@Configuration
@ComponentScan(basePackageClasses = Main.class)
public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        createTable(context.getBean(DataSource.class).getConnection());

        System.out.println("============== 사용자의 username, password를 입력해주세요. ==============");

        Scanner scanner = new Scanner(System.in);
        System.out.println("username : ");
        String username = scanner.nextLine();
        System.out.println("password : ");
        String password = scanner.nextLine();

        MemberController controller = context.getBean(MemberController.class);
        controller.insert(username, password);
        controller.print();

        context.close();
    }

    public static void createTable(Connection connection) throws SQLException {
        connection.createStatement()
                .execute("create table member(id int auto_increment, username varchar(255) not null, password varchar(255) not null, primary key(id))");
    }
}
