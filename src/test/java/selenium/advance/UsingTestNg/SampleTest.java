package selenium.advance.UsingTestNg;

import org.testng.annotations.Test;
import org.testng.Reporter;

public class SampleTest {
    @Test 
    public void sampletest()
    {
        Reporter.log("Hello", true);
    }
}
