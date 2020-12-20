package kr.co.fastcampus.cli.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
@Aspect
public class TransactionBean {

    private Connection connection;

    public TransactionBean(Connection connection) {
        this.connection = connection;
    }

    @Pointcut("execution(* kr.co.fastcampus.cli.Dao.insert(..))")
    public void transactionPointcut() { }

    @Around("transactionPointcut()")
    public Object aroundTransaction(ProceedingJoinPoint pjp) throws SQLException {
        log.error(">>> before aop transaction");
        connection.setAutoCommit(false);
        try {
            Object proceed = pjp.proceed();
            log.error(">> commit");
            connection.commit();

            return proceed;
        } catch (Throwable throwable) {
            log.error(">> rollback");
        }
        log.error(">>> after aop");
        return null;
    }

}
