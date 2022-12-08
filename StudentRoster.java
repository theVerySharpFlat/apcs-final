import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

class StudentRoster {
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        students = new ArrayList<>();

        System.out.println("Welcome! Type HELP for help");

        while(true) {
            System.out.print("ENTER COMMAND: ");
            String input = scanner.nextLine();

            if(input.equalsIgnoreCase("help")) {
                System.out.println("StudentRosterManager Commands: ");
                System.out.println("\tHELP: display help");
                System.out.println("\tNEW <new student name>: enter a new student");
                System.out.println("\tDELETE <index>: delete a student at the index");
                System.out.println("\tDELETE <name>: delete a student with the given name");
                System.out.println("\tLIST: list all students");
            } else if(input.length() >= 3 && input.substring(0, 3).equalsIgnoreCase("new")) {
                StringTokenizer tokenizer = new StringTokenizer(input);
                tokenizer.nextToken(); // The first token in the string is the command itself, so we need to get rid of it by calling this function
                if(tokenizer.hasMoreTokens()) { // Be sure to check if we have an argument before we access it
                    String name = tokenizer.nextToken(); // And get the next argument. This is repeated in all of the commands with arguments
                    addStudent(name);
                    System.out.println((students.size() - 1) + ") " + name);
                } else {
                    System.out.println("Invalid name!");
                }
            // Checking the input length helps us avoid out of bounds exceptions, and using substring helps us avoid the case
            // where the user enters a command with another command as an argument
            } else if(input.length() >= 6 && input.substring(0, 6).equalsIgnoreCase("delete")) {
                StringTokenizer tokenizer = new StringTokenizer(input);
                tokenizer.nextToken();
                if(tokenizer.hasMoreTokens()) {
                    String strNum = tokenizer.nextToken();
                    try {
                        int pos = Integer.parseInt(strNum);
                        deleteStudent(pos);
                        
                    } catch (NumberFormatException e) {
                        // If we're here, it means that the argument that the user entered is not an integer, so we try to delete based on name
                        deleteStudent(strNum);
                    }

                    listStudents();
                } else {
                    System.out.println("no argument!");
                }
            } else if(input.length() >= 4 && input.substring(0, 4).equalsIgnoreCase("list")) {
                listStudents();
            } else if(input.length() >= 4 && input.substring(0, 4).equalsIgnoreCase("quit")) {
                System.out.println("Good bye!");
                break;
            } else if(input.length() > 0) {
                System.out.println("unknown command \"" + input + "\"");
            }
        }
    }

    /**
     * Delete the student at the given index in the students ArrayList
     * @param index The index of the student to delete
     */
    private static void deleteStudent(int index) {
        if(index < 0 || index >= students.size()) {
            System.out.println("Invalid student index!");
            return;
        }

        students.remove(index);
    }

    /**
     * Delete a student by name
     * @param name The name of the student to delete
     */
    private static void deleteStudent(String name) {
        if(!students.remove(new Student(name))) {
            System.out.println("invalid student name");
        }
    }

    /**
     * Add a student with the given name
     * @param name The name of the student to add
     */
    private static void addStudent(String name) {
        if(students.contains(new Student(name))) {
            System.out.println("duplicate student!");
        } else {
            students.add(new Student(name));
        }
    }

    /**
     * Print out the students in the ArrayList with their respective indices
     */
    private static void listStudents() {
        for(int i = 0; i < students.size(); i++) {
            System.out.println(i + ") " + students.get(i).getName());
        }

        if(students.size() <= 0) {
            System.out.println("empty roster!");
        }
    }

    static Scanner scanner;
    static ArrayList<Student> students;
}