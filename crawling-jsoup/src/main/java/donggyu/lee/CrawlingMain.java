package donggyu.lee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * get title of notice from site by using Jsoup library (crawling)
 * @author donggyu.lee
 *
 */
public class CrawlingMain {

    // TODO : devide class - main class and logic class
    // TODO : below line is needed? what for?
    private final static String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36";

    public static void main(String[] args) {
        try {
            // set URL what I want
            String connUrl = "http://tera.nexon.com/news/events/list.aspx";

            // getting HTML
            Connection conn = Jsoup
                    .connect(connUrl)
                    .header("Content-Type", "application/json;charset=UTF-8")
                    .userAgent(USER_AGENT)
                    .method(Connection.Method.GET)
                    .ignoreContentType(true);

            Document doc = conn.get();

            // get all HTML document
            System.out.println(doc.toString());
            System.out.println("=========================================");

            // get title element only
            System.out.println((doc.title().toString()));

            // get all notice
            System.out.println(doc.getElementsByClass("list_title ellipsis"));
            // get notice titles
            System.out.println(doc.getElementsByClass("list_title ellipsis").text());

            // get latest notice titles 
            Elements resultElement = doc.getElementsByClass("list_title ellipsis");
            System.out.println(elementToString(resultElement).get(0));

            // get all notice titles
            elementToString(resultElement).forEach(System.out::println);

            // elementToString(resultElement).get(2;

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    // TODO remove "static"
    // change elements to String list
    public static List<String> elementToString(Elements elements) {

        List<String> elementStringList = new ArrayList<String>();
        for (Element element : elements) {
            elementStringList.add(element.text());
        }
        return elementStringList;
    }

}
