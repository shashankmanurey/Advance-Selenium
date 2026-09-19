package selenium.advance.Examples;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertDemo2 {
    @Test
    public void HA() {

        System.out.println("Hello");
        System.out.println("World");

        Assert.assertEquals(1, 1);

        System.out.println("Hello");
        System.out.println("World");
    }

    @Test
    public void SA() {

        System.out.println("abc");
        System.out.println("xyz");

        SoftAssert s = new SoftAssert();

        s.assertEquals(1, 2);

        System.out.println("abc");
        System.out.println("xyz");

        s.assertAll();
    }
}