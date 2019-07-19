package guce_aop;

import com.google.inject.Inject;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.stream.Stream;

/**
 * @autor slonikmak on 19.07.2019.
 */
public class JSCaller implements MethodInterceptor {

    @Inject
    JsBridgeTestObj bridgeTestObj;


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

        String methodName = methodInvocation.getMethod().getAnnotation(CallJS.class).methodName();
        Object[] args = methodInvocation.getArguments();
        bridgeTestObj.invoke(methodName, args);
        //Stream.of(methodInvocation.getArguments()).forEach(System.out::println);
        return null;
    }
}
