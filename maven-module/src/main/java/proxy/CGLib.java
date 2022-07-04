package proxy;

import com.company.reflection.Randomizer;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

import static java.util.Arrays.asList;

public class CGLib {

    public static void main(String[] args) {
        final var enhancer = new Enhancer();

        enhancer.setSuperclass(Randomizer.class);
        enhancer.setCallback((MethodInterceptor) (obj, method, methodArgs, proxy) -> {
            if (method.getName().equals("randomize")){
                System.out.println("CGLib proxy");
                return proxy.invokeSuper(obj, methodArgs);
            }
            throw new UnsupportedOperationException();
        });

        final Randomizer randomizer = (Randomizer) enhancer.create();
        final Integer result = randomizer.randomize(asList(1, 5, 6, 7, 8, 9));

        System.out.println(result);

    }
}
