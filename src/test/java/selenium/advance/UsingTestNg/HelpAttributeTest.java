
package selenium.advance.UsingTestNg;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class HelpAttributeTest {

    @Test(priority = 2)
    public void Register() {
        Reporter.log("register", true);
    }

    @Test(priority = 1, invocationCount = 3)
    public void login() {
        Reporter.log("login", true);
    }

    @Test(priority = 3)
    public void Wishlist() {
        Reporter.log("wishlist", true);
    }

    @Test(priority = 4)
    public void Addcart() {
        Reporter.log("register", true);
    }
}