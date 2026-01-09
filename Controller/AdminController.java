package QuizzApp.Controller;

import QuizzApp.Model.Question;
import QuizzApp.Service.Service;

public class AdminController {

    Service service=new Service();

    public void addQuestion(Question question){

         service.addQuestion(question);
    }
}
