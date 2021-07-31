package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE) // class 에 붙는다
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
}
