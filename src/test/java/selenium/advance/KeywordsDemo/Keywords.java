package selenium.advance.KeywordsDemo;

public class Keywords {
    public static void main(String[] args) {
        KeywordExe e = new KeywordExe();

        e.executors("LAUNCH_BROWSER");
        e.executors("OPEN_URL");
        e.executors("SEARCH");
        e.executors("SEARCH_CLICK");
        e.executors("CLOSE_BROWSER");
    }
}
