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
 * 参考↓
 * https://jsoup.org/cookbook/extracting-data/attributes-text-html
 * https://jsoup.org/cookbook/extracting-data/dom-navigation
 * https://jsoup.org/apidocs/org/jsoup/select/Selector.html
 * https://stackoverflow.com/questions/21336845/how-to-parse-ul-li-tags-using-jsoup-in-android
 * 
 */

// TODO : divide class - main class and logic class
public class CrawlingMain {

    // TODO : divide class - main class and logic class
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

            System.out.println("after Jsoup.connect -> " + conn);

            Document doc = conn.get();

            // System.out.println("get all HTML as String -> " + doc.toString());
            System.out.println("after conn.get() -> " + doc);
            System.out.println(("get title elements only ->" + doc.title().toString()));
            System.out.println("get all notice -> " + doc.getElementsByClass("list_title ellipsis"));
            System.out.println("get all titles as one String -> " + doc.getElementsByClass("list_title ellipsis").text());

            // get all titles as List<String>
            Elements resultElement = doc.getElementsByClass("list_title ellipsis");
            for(String webContent : elementToString(resultElement)) {
                System.out.println(webContent);
            }

            // get elements under <div class="list_area2">
            Elements resultLinks = doc.select("div.list_area2 > *");
            System.out.println("get elements under <div class=\"list_area2\">");
            System.out.println(resultLinks);
            // System.out.println(elementToString(resultLinks));

            // need to close all spans for getting <li> or something under <div> or other class
            // 参考 → https://stackoverflow.com/questions/21336845/how-to-parse-ul-li-tags-using-jsoup-in-android
            // like below...
            Elements ol = doc.select("div.list_area2 > ol");
            Elements li = ol.select("li > *");
            // System.out.println(li);

            System.out.println("=================get absolute URLs only=================");
            for (int i = 0; i < li.size(); i++) {
                System.out.println(li.get(i).attr("abs:href"));
            }


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
