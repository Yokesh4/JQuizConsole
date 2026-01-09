package QuizzApp.Service;

import QuizzApp.Model.Question;
import QuizzApp.Repo.Repo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Service {

    Repo repo=new Repo();

    ArrayList<Question> quizQuestion=new ArrayList<>();
    String selection[]=new String[5];

    public Service(){

        try {
            repo.getQuestions();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ArrayList<Question> allQuestions=repo.allQuestions;
        Collections.shuffle(allQuestions);
//        picking 5

        for(int i=0;i<5;i++){

            quizQuestion.add(allQuestions.get(i));
        }
    }
    public void display(){

        Scanner sc=new Scanner(System.in);
        int s=0;
        for(int i=0;i<quizQuestion.size();i++){

            System.out.println( (i+1)+": "+quizQuestion.get(i).getQuestion());
            System.out.println("A :"+quizQuestion.get(i).getOpt1());
            System.out.println("B :"+quizQuestion.get(i).getOpt2());
            System.out.println("C :"+quizQuestion.get(i).getOpt3());
            System.out.println("D :"+quizQuestion.get(i).getOpt4());
            System.out.println();
            System.out.println("Your Answer : ");
            selection[s++]=sc.nextLine();


        }
    }

    public void getScore(){

         validateAnswer();
    }

    public void validateAnswer(){
//       compare
        int score=0;
        for(int i=0;i<quizQuestion.size();i++){

                if(quizQuestion.get(i).getAnswer().equalsIgnoreCase(selection[i])){
                     score++;
                }
        }

        System.out.println("Your Score is : "+score);
    }

    public void addQuestion(Question question){

        repo.addQuestion(question);
    }
}
