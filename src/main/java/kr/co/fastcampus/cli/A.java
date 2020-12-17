package kr.co.fastcampus.cli;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.Map;

@Slf4j
@Component
public class A {
//    @Autowired private B b;
    @Autowired ApplicationContext context;
    @Value("#{systemProperties['hello']}") String property;

    @PostConstruct
    void init() {
        log.error("A post construct");
    }

    @PreDestroy
    void destroy() {
        log.error("A pre destroy");
    }
}
