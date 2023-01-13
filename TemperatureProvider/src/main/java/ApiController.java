import com.google.gson.Gson;

import java.util.List;

import static spark.Spark.get;
import static spark.Spark.port;

public class ApiController {
    public void control(){
        SelectMethodsDefiner methods = new SelectMethodsDefiner();
        port(8088);
        get("/v1/places/all-max-temps", (req, res) -> {
            List<Weather> weathers = methods.selectWeathersMaxTemp();
            return new Gson().toJson(weathers);
        });
        get("/v1/places/all-min-temps", (req, res) -> {
            List<Weather> weathers = methods.selectWeathersMinTemp();
            return new Gson().toJson(weathers);
        });
        get("/v1/places/with-max-temperature", (req, res) -> {
            List<Weather> weathers = methods.selectWeathersInRangeMaxTemp(req.queryParams("from"), req.queryParams("to"));
            return new Gson().toJson(weathers);
        });
        get("/v1/places/with-min-temperature", (req, res) -> {
            List<Weather> weathers = methods.selectWeathersInRangeMinTemp(req.queryParams("from"), req.queryParams("to"));
            return new Gson().toJson(weathers);
        });
    }
}
