package kr.co.fastcampus.cli;

import ch.qos.logback.core.spi.LifeCycle;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.Lifecycle;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.*;

@Slf4j
public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {
        logger.info("Hello world!!");
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");
        Lifecycle lifeCycle = context.getBean(Lifecycle.class);
        log.info(">> 1: " + lifeCycle.isRunning());
        context.close();
        log.info(">> 2: " + lifeCycle.isRunning());
    }
}
