import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;


public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/contacts", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String firstName = request.queryParams("firstName");
      String lastName = request.queryParams("lastName");
      String birthMonth = request.queryParams("birthMonth");
      Contact newContact = new Contact(firstName, lastName, birthMonth);
      request.session().attribute("contacts", newContact);

      model.put("contacts", newContact);
      model.put("allContacts", Contact.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/contacts/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String selectedID = request.params(":id");
      Contact contact = Contact.find(Integer.parseInt(selectedID));
      model.put("contact", contact);
      model.put("template", "templates/info.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    post("/info", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();


      String selectedID = request.queryParams("contactId");
      Contact contact = Contact.find(Integer.parseInt(selectedID));
      ArrayList<Phone> phone = contact.getPhone();

      if (phone == null) {
        phone = new ArrayList<Phone>();
      }
      request.session().attribute("phone", phone);


      String number = request.queryParams("phoneNumber");
      if (number != null) {
        String type = request.queryParams("phoneType");
        Phone newPhone = new Phone(number, type);
        phone.add(newPhone);
      }
      model.put("allPhones", request.session().attribute("phone"));
      model.put("contact", contact);

      model.put("template", "templates/info.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
