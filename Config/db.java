package QuizzApp.Config;

import java.sql.Connection;
import java.sql.DriverManager;

public class db {

    public Connection connection = null;

    enum  status{

        SUCCESS,FAILURE
    }
    public void makeConnection(){

        String username = "root";
        String password="yokesh";
        String url ="jdbc:mysql://localhost:3306/quizzapp";

        try{

            connection= DriverManager.getConnection(url,username,password);
            System.out.println(status.SUCCESS);

        }catch (Exception e){


            e.printStackTrace();
        }



    }
}
