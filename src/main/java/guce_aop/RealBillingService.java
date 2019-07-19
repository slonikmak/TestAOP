package guce_aop;

/**
 * @autor slonikmak on 19.07.2019.
 */
public class RealBillingService implements BillingService {

    public static final String name = "STATIC VALUE";

    @CallJS(methodName = "chargeOrder")
    @Override
    public void chargeOrder(int order, String creditCard) {
        System.out.println("Call Java method");
    }
}
