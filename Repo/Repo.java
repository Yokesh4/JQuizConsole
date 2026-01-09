package QuizzApp.Repo;

import QuizzApp.Config.db;
import QuizzApp.Model.Question;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Repo {

    db database= new db();

    public ArrayList<Question> allQuestions=new ArrayList<>();


    public Repo(){

        database.makeConnection();
    }

//      public Repo(){
//
//          allQuestions.addAll(Arrays.asList(
//                  new Question(1, "Size Of Int", "6", "4", "8", "10", "B"),
//                  new Question(2, "Which keyword is used to inherit a class in Java?", "this", "super", "extends", "implements", "C"),
//                  new Question(3, "Default value of boolean variable?", "true", "false", "0", "1", "B"),
//                  new Question(4, "Which of these is not a Java OOP concept?", "Encapsulation", "Polymorphism", "Compilation", "Inheritance", "C"),
//                  new Question(5, "Which method is the entry point of Java program?", "start()", "main()", "run()", "execute()", "B"),
//                  new Question(6, "Which data type is used for decimal values?", "int", "float", "char", "boolean", "B"),
//                  new Question(7, "Which operator is used to compare two values?", "=", "==", "!=", ">=", "B"),
//                  new Question(8, "Which collection allows duplicates?", "Set", "Map", "List", "TreeSet", "C"),
//                  new Question(9, "Which exception is thrown when array index is invalid?", "NullPointerException", "IOException", "ArithmeticException", "ArrayIndexOutOfBoundsException", "D"),
//                  new Question(10, "Which keyword creates an object in Java?", "new", "class", "public", "alloc", "A")
//
//          ));
//     }

    enum status{

        INSERTION_SUCCESS,INSERTION_FAILURE
    }

    public void getQuestions() throws Exception{

        String sql="select * from questions";

        Statement st= database.connection.createStatement();

        ResultSet result= st.executeQuery(sql);

        result.next();

        while(result.next()){

            allQuestions.add(new Question(result.getInt("qid"),result.getString("question"),result.getString("opt1"),result.getString("opt2"),
                    result.getString("opt3"),result.getString("opt4"),
                    result.getString("answer")));

        }

        result.close();
        st.close();

    }

    public void addQuestion(Question question){

        String sql = "INSERT INTO questions (qid, question, opt1, opt2, opt3, opt4, answer) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement=database.connection.prepareStatement(sql);

            preparedStatement.setInt(1,question.getQid());
            preparedStatement.setString(2,question.getQuestion());
            preparedStatement.setString(3,question.getOpt1());
            preparedStatement.setString(4,question.getOpt2());
            preparedStatement.setString(5,question.getOpt3());
            preparedStatement.setString(6,question.getOpt4());
            preparedStatement.setString(7,question.getAnswer());

            int rows = preparedStatement.executeUpdate();

            if(rows > 0)
              System.out.println(status.INSERTION_SUCCESS);
            else System.out.println(status.INSERTION_FAILURE);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
