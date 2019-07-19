package guce_aop;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

/**
 * @autor slonikmak on 19.07.2019.
 */
public class NotOnWeekendsModule extends AbstractModule {
    protected void configure() {
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(NotOnWeekends.class),
                new WeekendBlocker());

        bind(BillingService.class).to(RealBillingService.class);
    }
}
