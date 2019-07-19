package guce_aop;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;
import org.aopalliance.intercept.MethodInterceptor;

/**
 * @autor slonikmak on 19.07.2019.
 */
public class NotOnWeekendsModule extends AbstractModule {
    protected void configure() {

        MethodInterceptor interceptor = new JSCaller();
        requestInjection(interceptor);

        bindInterceptor(Matchers.any(), Matchers.annotatedWith(CallJS.class),
                interceptor);

        bind(BillingService.class).to(RealBillingService.class);
        bind(JsBridgeTestObj.class).toInstance(new JsBridgeTestObj());
    }
}
