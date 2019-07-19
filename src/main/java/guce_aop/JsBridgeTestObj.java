package guce_aop;

import java.util.stream.Stream;

/**
 * @autor slonikmak on 19.07.2019.
 */
public class JsBridgeTestObj {
    public void invoke(Object... objects){
        System.out.println("Call JS method");
        System.out.println("Method: "+objects[0]);
        Object[] args = (Object[]) objects[1];
        Stream.of(args).forEach(o-> System.out.println("Arg: "+o));
    }
}
