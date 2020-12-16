package fastcampus;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

public class BeanScopeTest {

//    @Test
//    public void testIdentity() {
//        // 동일성(identity) : 객체 주소 같다. - (obj1 == obj2 == obj3) == true
//        // 동등성(equals) : 객체의 값이 같다. - (obj1.equals(obj2)) == true
//        A a1 = new A();
//        A a2 = a1;
//        Assert.assertTrue(a1 == a2);
//    }

    @Test
    public void testEquals() {
        A a1 = new A(10, "Hello world");
        A a2 = new A(10, "Hello world");
        A a3 = new A(5, "hello");

        Assert.assertTrue(a1.equals(a2));
        Assert.assertFalse(a1.equals(a3));
    }
}

@EqualsAndHashCode
@AllArgsConstructor
class A {
    private int a1;
    private String a2;
}