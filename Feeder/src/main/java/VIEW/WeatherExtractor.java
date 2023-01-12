package VIEW;

import MODEL.Weather;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import java.io.IOException;

/*public interface WeatherExtractor {
     public String getDataUrls(String dataUrl, String apiKey) throws IOException;// default??

    public default String getData(String datosUrl) throws IOException {
        return Jsoup.connect(datosUrl)
                .validateTLSCertificates(false)
                .timeout(20000)
                .ignoreContentType(true)
                .header("accept", "application/json")
                .method(Connection.Method.GET)
                .maxBodySize(0).execute().body();
    }
}*/
