package QuizzApp.Controller;

import QuizzApp.Service.Service;

public class Controller {

    Service service =new Service();

    public void display() {

        service.display();
    }

    public void getScore(){

        service.getScore();
    }
}
