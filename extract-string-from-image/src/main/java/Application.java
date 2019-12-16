public class Application {

    public static void main(String[] args) throws Exception {

        ExtractStringFromImage imgToString = new ExtractStringFromImage();

        imgToString.detectText("/Users/muse/Downloads/sample_image.png");

    }
}
