package guce_aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.stream.Stream;

/**
 * @autor slonikmak on 19.07.2019.
 */
public class WeekendBlocker implements MethodInterceptor {


    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Field[] fields = methodInvocation.getMethod().getDeclaringClass().getFields();

        Stream.of(fields).filter(f-> Modifier.isStatic(f.getModifiers())).findFirst().ifPresent(f-> {
            try {
                System.out.println(f.get(null));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        System.out.println(methodInvocation.getMethod().getAnnotation(NotOnWeekends.class).value());
        Stream.of(methodInvocation.getArguments()).forEach(System.out::println);
        return null;
    }
}
