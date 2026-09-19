package selenium.advance.UsingTestNg;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class BatchExecution
{
    @Test
    public void Register() {
        Reporter.log("register", true);
    }

    @Test
    public void login() {
        Reporter.log("login", true);
    }

    @Test
    public void Wishlist() {
        Reporter.log("wishlist", true);
    }

    @Test
    public void Addcart() {
        Reporter.log("register", true);
    }
}