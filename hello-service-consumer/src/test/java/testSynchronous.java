import org.junit.Test;
import rx.Observable;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;

/**
 * @author : Cheese
 * @date : 2018/5/4
 * @description : TODO
 */
public class testSynchronous {
    @Test
    public void testSynchronous() {
        assertEquals("Hello World!", new CommandHelloWorld("World").execute());
        assertEquals("Hello Bob!", new CommandHelloWorld("Bob").execute());
    }
    @Test
    public void testObservable() {
        Observable<String> observable= new CommandHelloWorld2("World").observe();
        Iterator<String> iterator = observable.toBlocking().getIterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void testToObservable() {
        Observable<String> observable= new CommandHelloWorld2("World").toObservable();
        Iterator<String> iterator = observable.toBlocking().getIterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

}
