package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.ComponentScan;

@Aspect
@ComponentScan
public class TimeTraceAop {

    // 공통 관심사를 타겟팅
    // 패키지명.클래스명
    @Around("execution(* hello.hellospring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("START: "+joinPoint.toLongString());
        try {
            return joinPoint.proceed(); // 다음 메서드로 진행

        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: "+joinPoint.toLongString()+" "+timeMs+"ms");
        }

    }
}
