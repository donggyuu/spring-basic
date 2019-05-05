package donggyu.lee;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class CrawlingMain {

    private final static String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36";

    public static void main(String[] args) {
        try {
            // setting URL
            // String connUrl = "https://naver.com";

            String connUrl = "http://tera.nexon.com/news/events/list.aspx";

            // getting HTML
            Connection conn = Jsoup
                    .connect(connUrl)
                    .header("Content-Type", "application/json;charset=UTF-8")
                    .userAgent(USER_AGENT)
                    .method(Connection.Method.GET)
                    .ignoreContentType(true);

            Document doc = conn.get();

            // checking HTML document
            System.out.println(doc.toString());
        } catch (IOException e){
            e.printStackTrace();

        }
        
    }
}
