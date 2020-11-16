import java.util.Scanner;
import java.sql.*; 
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CliCharacterCreator {
    public static Scanner _scanner;
    public static Connection _connection;
    public static void main(String[] args) {
        // PrintWriter writer = new PrintWriter(System.out);    
        // // writer.write("Javatpoint provides tutorials of all technology.");        
        // writer.flush();  
        // writer.close(); 

        _scanner = new Scanner(System.in);
        startProgram();
    }

    public static void connectToDb() {
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");
            _connection = DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/character_db","root","password");  
            //here sonoo is database name, root is username and password  
            Statement stmt =_connection.createStatement();  
            ResultSet rs = stmt.executeQuery("select * from characters");  
            while(rs.next()) 
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
            _connection.close();  
            }
        catch(Exception e){ 
                System.out.println(e);
        }   
    }  
    

    public static void startProgram() {
        System.out.println("////////////////////////////////////////////////");
        System.out.println("//                                            //");
        System.out.println("//                                            //");
        System.out.println("//      ~* W E L C O M E  T O  T H E *~       //");
        System.out.println("//   ~* C H A R A C T E R  C R E A T O R *~   //");
        System.out.println("//                                            //");
        System.out.println("//           press enter to start             //");
        System.out.println("////////////////////////////////////////////////");
        _scanner.nextLine();
        showMainMenu();
    };

    public static void showMainMenu() {
        System.out.println("Would you like to create a character (1) or view saved characters (2) ?");
        System.out.println("Type in your choice below");
        try {
            int choice = _scanner.nextInt(10);
            chooseOption(choice);
        }
        catch(Exception e) {
            _scanner.nextLine();
            System.out.println("Invalid choice, enter again.");
            showMainMenu();
        }
    }

    public static void chooseOption(int choice) {
        if (choice == 1) {
            createCharacter();

        } else if (choice == 2) {
            viewCharacters();

        } else {
            System.out.println("You have entered an invalid choice. Please choose again.");
            showMainMenu();
        }
    }

    public static void createCharacter(){
        System.out.println("Opening character studio...");
        // add time out...
        System.out.println("Character studio ready.");
        System.out.println("Would you like to choose all of the character attributes or generate them randomly?");
        // add choice here

        
    }
    
    public static void viewCharacters(){
        System.out.println("Retreiving characters.");
        System.out.println("Retreiving characters..");
        System.out.println("Retreiving characters...");
        System.out.println("Retreiving characters..");
        System.out.println("Retreiving characters.");
        System.out.println("Retreiving characters");
        connectToDb();

    }
}




// Create Character
    // Options will be to choose or ask to pick for you
    // Name
    // random??
    // Gender - three options
    // Sexuality - four options
    // Class/Race - random with some options being more heavily weighted
    // Job - random with some options being more heavily weighted
    // Stats - random with some options being more heavily weighted
    // Do you want to save this character? - Yes No
// View Saved Characters
    // List of characters with stats
    // go to main screen

