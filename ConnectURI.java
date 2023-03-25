package Model;
import java.net.MalformedURLException;
import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.net.URL;
import java.util.regex.Pattern;

public class ConnectURI {

 private final String USER_AGENT = "Mozilla/5.0";

    public static URL buildURL(String urlQuery) {
        URL url = null;
        try {
            url = new URL( urlQuery.toString());
        }catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpsURLConnection urlConnection = (HttpsURLConnection)  url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();
            Scanner scanner = new Scanner(in);
            scanner.useDelimiter(Pattern.compile("//A"));
            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return  scanner.next();
            }else {
                return null;
            }
        }finally {
            urlConnection.disconnect();
        }

    }
}
