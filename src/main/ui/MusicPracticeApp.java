package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.PracticeLog;
import model.PracticeSession;
import model.User;

// A music application that would allow users to make sessions and enter the details of their practice to have 
// a record of it.
public class MusicPracticeApp {
    private Scanner scanner;
    private String firstOption;
    private String name;
    private String newSession;
    private List<String> listComments;
    private String commentEntered;
    private static int sessionCounter = 1;
    private PracticeLog log;
    private PracticeSession newUserSession;
    private int totalDuration;


    
    // EFFECTS: creates an instance of the MusciPracticeApp console ui application
    public MusicPracticeApp() {

        init();
        printWelcomeMessage();

        boolean running = true;

        while (running) {
            mainmenu();
            running = optionHandler();
        }
       
        
        
    }

    // Construsts the scanner and practice log
    public void init() {
        this.scanner = new Scanner(System.in);
        this.log = new PracticeLog();
    }


    // EFFECTS: Prints welcome message
    private void printWelcomeMessage() {
        printDivider();
        System.out.println("Welcome to Music Logger!");
        System.out.println("Please select from the following options:"); 
        printDivider();      
    }

    // EFFECTS: Prints divider
    private void printDivider() {
        System.out.println("------------------------------------");
    }

    // EFFECTS: Displays and processes inputs for the main menu
    public void mainmenu() {
        displayMenu();
        firstOption = scanner.nextLine().toUpperCase();
    }


    // EFFECTS: Prints out the four initiall options a user have when they open the application
    public void displayMenu() {
        System.out.println("A: Add a new user");
        System.out.println("L: View user log");
        System.out.println("T: Total practice time");
        System.out.println("Choose your option");
        System.out.println("Q: Quit");
        printDivider();
    }

    // EFFECTS: Processes the user's input in the main menu
    public boolean optionHandler() {
        if (firstOption.equals("A")) {
            optionA();
            printDivider();
            
        } else if (firstOption.equals("L")) {
            optionL();
            printDivider();
            

        } else if (firstOption.equals("Q")) {
            System.out.println("Goodbye! Until your next session:)");
            return false;
        
        } else if (firstOption.equals("T")) {
            optionT();
            printDivider();
        }
        return true;
    }
    

    // EFFECTS: handles the program when option "A" is entered and let the user make a new session
    public void optionA() {
        System.out.println("What is your name?");
        name = scanner.nextLine();
        new User(name, log);
        System.out.println("Hello " + name + " press M to Make a new practice session");
        

        do {
            System.out.println("Enter 'M' to create a new session:");
            newSession = scanner.nextLine().toUpperCase();

            if (newSession.equalsIgnoreCase("M")) {
                sessionEntries(); 
                break; 
            } else {
                System.out.println("Invalid option. Try again.");
            }
        } while (true);    
         
    }

    
    // EFFECTS: handles the program when option "L" is entered and displays all the sessions to the user
    public PracticeLog optionL() {
        if (log.getPracticeSession().isEmpty()) {
            System.out.println("No practice sessions found!");
        } else {
            for (int i = 0; i < log.getPracticeSession().size(); i++) {
                System.out.println(log.showPracticeSession(i));
            } 
        }
        return log;

    }
    // MODIFIES: this
    // EFFECTS: handles the program when option "T" is entered and displays the total duration of practice

    public int optionT() {
        totalDuration = newUserSession.getDuration();
        totalDuration = 0;

        for (PracticeSession newUserSession : log.getPracticeSession()) {
            totalDuration += newUserSession.getDuration();

        }
        System.out.println("Total practice time: " + totalDuration + " minutes");
        

        return totalDuration;
    }

    // this
    // EFFECTS: Gets different entries from the user to make a practice session
    public void sessionEntries() {
        System.out.println("What is the date of your practice?");
        String dateEntered = scanner.nextLine();
        System.out.println("What is the instrument you play?");
        String instrumentEntered = scanner.nextLine();
        System.out.println("What is the piece you are working on?");
        String pieceEntered = scanner.nextLine();
        System.out.println("What genres of music is the piece that you practiced?");
        String categoryEntered = scanner.nextLine();
        System.out.println("What was the goal of this session?");
        String goalEntered = scanner.nextLine();
        System.out.println("What was the focus of this practice session on?");
        String focusAreaEntered = scanner.nextLine();
        System.out.println("Type dow any commnets you have about your session");
        commentEntered = scanner.nextLine();
        System.out.println("How long have you practiced?(in minutes)");
        int durationEntered = scanner.nextInt();
        scanner.nextLine();
        
        

        newUserSession = new PracticeSession(dateEntered, instrumentEntered, pieceEntered, 
                durationEntered, focusAreaEntered, commentEntered, categoryEntered, goalEntered);
        
        log.addSession(newUserSession);              

        sessionCounter++; 

        
    }


    
}

    



