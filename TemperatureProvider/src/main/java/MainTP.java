import com.google.gson.Gson;
import java.util.List;

import static spark.Spark.*;

public class MainTP {
    public static void main(String[] args) {
        port(8088);
        get("/v1/places/with-max-temperature", (req, res) -> {
            List<Weather> weathers = new DatamartReader().selectWeathersInRangeMaxTemp(req.queryParams("from"), req.queryParams("to"));
            return new Gson().toJson(weathers);
        });
        get("/v1/places/with-min-temperature", (req, res) -> {
            List<Weather> weathers = new DatamartReader().selectWeathersInRangeMinTemp(req.queryParams("from"), req.queryParams("to"));
            return new Gson().toJson(weathers);
        });
    }
}
