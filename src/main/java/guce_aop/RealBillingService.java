package guce_aop;

import java.util.stream.Stream;

/**
 * @autor slonikmak on 19.07.2019.
 */
public class RealBillingService implements BillingService {

    public static final String name = "NAME";

    @NotOnWeekends(value = "value22")
    @Override
    public String chargeOrder(int order, String creditCard) {
        return creditCard+order;
    }
}
