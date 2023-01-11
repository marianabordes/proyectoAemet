/*import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;

public class DataExtractor {
    public static String dataUrl = "https://opendata.aemet.es/opendata/api/observacion/convencional/todas";
    public static String apiKey = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtYXJpYW5hLmJvcmRlczEwMUBhbHUudWxwZ2MuZXMiLCJqdGkiOiIwYjE1YmU1OC0zNGQ2LTQxZGMtYmMwMS00OWI4NmU0ZjFmOTciLCJpc3MiOiJBRU1FVCIsImlhdCI6MTY3MjI0MzM3OSwidXNlcklkIjoiMGIxNWJlNTgtMzRkNi00MWRjLWJjMDEtNDliODZlNGYxZjk3Iiwicm9sZSI6IiJ9.IJ-zH2SJWP5xcOsjVWLJ9hQ15zhfuscrpXaaDf3qJFk";

    public static String getDataUrls() throws IOException {
        String jsonResponse = Jsoup.connect(dataUrl)
                .validateTLSCertificates(false)
                .timeout(10000)
                .ignoreContentType(true)
                .header("accept", "application/json")
                .header("api_key", apiKey)
                .method(Connection.Method.GET)
                .maxBodySize(0).execute().body();
        JsonObject jsonObject = new Gson().fromJson(jsonResponse, JsonObject.class);
        String datosUrl = jsonObject.get("datos").getAsString();
        return datosUrl;
    }

    public static String getData(String datosUrl) throws IOException {
        String dataContent = Jsoup.connect(datosUrl)
                .validateTLSCertificates(false)
                .timeout(20000)
                .ignoreContentType(true)
                .header("accept", "application/json")
                .method(Connection.Method.GET)
                .maxBodySize(0).execute().body();
        return dataContent;
    }
}
*/