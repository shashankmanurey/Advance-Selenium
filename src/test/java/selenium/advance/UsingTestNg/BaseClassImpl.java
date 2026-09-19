package selenium.advance.UsingTestNg;

import org.testng.annotations.Test;
import selenium.advance.BaseClassUtility.BaseClass;

public class BaseClassImpl extends BaseClass {

    @Test
    public void sample() {
        System.out.println("Executed");
    }

    @Test
    public void sample1() {
        System.out.println("hello");
    }
}