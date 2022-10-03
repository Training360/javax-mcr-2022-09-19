package training.employees.employees.service;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggerAspect {

    @Around("execution(* training.employees.employees.service.EmployeesService.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Call method: {}", joinPoint.getSignature().getName());
        var start = System.currentTimeMillis();
        try {
            return joinPoint.proceed();
        }
        finally {
            var end = System.currentTimeMillis();
            log.info("Time of method: {} ms", end - start);
        }
    }
}
