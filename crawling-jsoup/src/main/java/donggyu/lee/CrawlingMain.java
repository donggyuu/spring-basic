package donggyu.lee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingMain {

    public static void main(String[] args) {

        String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36";

        try {

            // =================================
            // Basic setting
            // =================================

            // URL you want to parse
            String connectURL = "http://tera.nexon.com/news/events/list.aspx";

            // Make connection and set values
            Connection conn = Jsoup
                    .connect(connectURL)
                    .header("Content-Type", "application/json;charset=UTF-8")
                    .userAgent(USER_AGENT)
                    .method(Connection.Method.GET)
                    .ignoreContentType(true);

            // Get document value from connections
            // Will parsing from this document value
            Document document = conn.get();


            // =================================
            // Get values using class
            // =================================

            // Set class which has values for parsing
            Elements sampleParsingData = document.getElementsByClass("list_title ellipsis");

            System.out.println("=====print titles=====");
            for (String data : elementToString(sampleParsingData)) {
                System.out.println(data);
            }


            // =================================
            // Get values from duplicated tags
            // =================================

            // Get <ol> values from "list_area2" first
            Elements ol = document.select("div.list_area2 > ol");

            // Then get <li> values from <ol> values
            Elements li = ol.select("li > *");

            System.out.println("=====print URLs=====");
            for (int i = 0; i < li.size(); i++) {
                System.out.println(li.get(i).attr("abs:href"));
            }


        } catch (IOException e) {
            e.printStackTrace();

        }

    }


    /**
     * change Elements to List<String>
     * 
     * @param elements
     * @return
     */
    private static List<String> elementToString(Elements elements) {

        List<String> elementStringList = new ArrayList<String>();
        for (Element element : elements) {
            elementStringList.add(element.text());
        }
        return elementStringList;
    }

}
