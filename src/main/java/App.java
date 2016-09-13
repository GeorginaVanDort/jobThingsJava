import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import java.util.ArrayList;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/resume", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      ArrayList<Job> resumeJobs = request.session().attribute("resumeJobs");
      model.put("jobs", resumeJobs);
      model.put("template", "templates/output.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/board", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      ArrayList<Job> boardJobs = request.session().attribute("boardJobs");
      model.put("jobs", boardJobs);
      model.put("template", "templates/output.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/resume", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      ArrayList<Job> resumeJobs = request.session().attribute("resumeJobs");
      if(resumeJobs == null){
        resumeJobs = new ArrayList<Job>();
        request.session().attribute("resumeJobs", resumeJobs);
      }
      String title = request.queryParams("title");
      String description = request.queryParams("description");
      String company = request.queryParams("Company");
      String dates = request.queryParams("dates");
      Job job = new Job(title, description, company, dates, false);
      resumeJobs.add(job);
      model.put("jobs", resumeJobs);
      model.put("template", "templates/output.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/board", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      ArrayList<Job> boardJobs = request.session().attribute("boardJobs");
      if(boardJobs == null){
        boardJobs = new ArrayList<Job>();
        request.session().attribute("boardJobs", boardJobs);
      }
      String title = request.queryParams("title");
      String description = request.queryParams("description");
      String company = request.queryParams("Company");
      String dates = request.queryParams("dates");
      Job job = new Job(title, description, company, dates, true);
      boardJobs.add(job);
      model.put("jobs", boardJobs);
      model.put("template", "templates/output.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
