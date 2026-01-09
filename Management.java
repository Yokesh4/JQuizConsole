package QuizzApp;

import QuizzApp.Config.db;
import QuizzApp.Controller.AdminController;
import QuizzApp.Controller.Controller;
import QuizzApp.Model.Question;

import java.util.Scanner;

public class Management {

    public Management(){

        allowAccess();
    }

    Scanner sc=new Scanner(System.in);
    Controller controller=new Controller();
    AdminController adminController=new AdminController();

    public void startQuiz(){

        controller.display();
        controller.getScore();
    }

    public void allowAccess(){

        System.out.println("Enter Password : ");
        String userInput=sc.nextLine();

        if(userInput.equals("admin")){

            System.out.println("How Many Question Do you Want to add : ");
            int n=sc.nextInt();

            for(int i=0;i<n;i++){

                getInputs();
            }


        }else{

            System.out.println("you Entered Wrong Password You are in User Mode ! ");
            startQuiz();
        }



    }

    public void getInputs(){

            System.out.println("Enter Qid : ");
            int Qid = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter Question : ");
            String qns = sc.nextLine();
            System.out.println("Enter Option one : ");
            String optionOne = sc.nextLine();
            System.out.println("Enter Option Two : ");
            String optionTwo = sc.nextLine();
            System.out.println("Enter Option Three : ");
            String optionThree = sc.nextLine();
            System.out.println("Enter Option Four : ");
            String optionFour = sc.nextLine();
            System.out.println("Enter Right Answer Option (like : a or A )");
            String answer = sc.nextLine();

           Question question=new Question(Qid,qns,optionOne,optionTwo,optionThree,optionFour,answer);

           adminController.addQuestion(question);

    }


}
