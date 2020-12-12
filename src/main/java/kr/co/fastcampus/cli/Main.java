package kr.co.fastcampus.cli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws ClassNotFoundException {
        logger.info("Hello world!!");

        ApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");
        Dao dao = context.getBean("dao", Dao.class);
        dao.run();
    }
}
