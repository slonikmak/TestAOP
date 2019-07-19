package guce_aop;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.matcher.Matchers;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @autor slonikmak on 19.07.2019.
 */
public class Main {
    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new NotOnWeekendsModule());

        injector.getInstance(BillingService.class).chargeOrder(3,"aaaaaaa");
    }
}
