import com.google.gson.Gson;
import static spark.Spark.get;
import static spark.Spark.post;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Weather> dogFoods = new ArrayList<>();

        get("/weathers with max temperature", (req, res) -> {
            String startDate = req.queryParams("date1", "date2");
            List<Weather> weathersInRangeWithMaxTemp = new ArrayList<>();
            weathers.getMaxTemp();
            return new Gson().toJson(filtered);
        });
        post("/dogfoods", (req, res) -> {
            DogFood dogFood = new Gson().fromJson(req.body(), DogFood.class);
            dogFoods.add(dogFood);
            return "OK";
        });
    }
}
