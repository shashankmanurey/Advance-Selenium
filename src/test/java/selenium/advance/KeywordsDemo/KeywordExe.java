package selenium.advance.KeywordsDemo;

public class KeywordExe {
    KeywordImplementation k = new KeywordImplementation();

    public void executors(String keyword)
    {
        if(keyword.equals("LAUNCH_BROWSER"))
        {
            k.launchbrowser();
        }
        else if(keyword.equals("OPEN_URL"))
        {
            k.openurl();
        }
        else if(keyword.equals("SEARCH"))
        {
            k.search();
        }
        else if(keyword.equals("SEARCH_CLICK"))
        {
            k.searchbutton();
        }
        else if(keyword.equals("CLOSE_BROWSER"))
        {
            k.closebrowser();
        }
    }
}
