import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("placeList", request.session().attribute("placeList"));
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/places", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      ArrayList<Places> placeListJ = request.session().attribute("placeList");
      if (placeListJ == null) {
        placeListJ = new ArrayList<Places>();
        request.session().attribute("placeList", placeListJ);
      }

      String city = request.queryParams("city");
      String country = request.queryParams("country");
      String date = request.queryParams("date");
      String landmark = request.queryParams("landmark");

      Places newPlace = new Places(city, country, date, landmark);
      // request.session().attribute("place", newPlace);
      placeListJ.add(newPlace);

      model.put("template", "templates/success.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
