import java.util.*;

public class Main {
    public static void main(String[] args) {
        SocialNetworkGraph network = new SocialNetworkGraph();
        
        Scanner scanner = new Scanner(System.in);        
        boolean exit = false;

        String name;
        int age;
        String hobbiesInput;
        String[] hobbies;
        String secondName;
        String firstName;

        while (!exit) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: 
                                
                    // Get name input
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();

                    // Get age input
                    System.out.print("Enter age: ");
                    age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    // Get hobbies input
                    System.out.print("Enter hobbies (comma-separated): ");
                    hobbiesInput = scanner.nextLine();
                    hobbies = hobbiesInput.split(",");
                    
                    network.addPerson(name, age, Arrays.asList(hobbies));
                    break;
                case 2:
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    network.removePerson(name);
                    break;
                case 3:
                    
                    System.out.print("Enter first person's name: ");
                    firstName = scanner.nextLine();

                    System.out.print("Enter second person's name: ");
                    secondName = scanner.nextLine();
                    
                    network.addFriendship(firstName, secondName);
                    break;
                case 4:

                    System.out.print("Enter first person's name: ");
                    firstName = scanner.nextLine();

                    System.out.print("Enter second person's name: ");
                    secondName = scanner.nextLine();

                    network.removeFriendship(firstName, secondName);
                    break;
                case 5:
                    //findShortestPath();
                    break;
                case 6:
                    //suggestFriends();
                    break;
                case 7:
                    //countClusters();
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please select an option from 1 to 8.");
            }
        }
        scanner.close();
        System.out.println("Exiting... Goodbye!");
    }

    private static void printMenu() {
        System.out.println("===== Social Network Analysis Menu =====");
        System.out.println("1. Add person");
        System.out.println("2. Remove person");
        System.out.println("3. Add friendship");
        System.out.println("4. Remove friendship");
        System.out.println("5. Find shortest path");
        System.out.println("6. Suggest friends");
        System.out.println("7. Count clusters");
        System.out.println("8. Exit");
        System.out.print("Please select an option: ");
    }


        
        
        
        
        
        
        
        
        /*
        
        // Adding some people for demonstration
        network.addPerson("John Doe", 25, Arrays.asList("reading", "hiking", "cooking"));
        network.addPerson("Jane Smith", 22, Arrays.asList("swimming", "cooking"));
        network.addPerson("Alice Johnson", 27, Arrays.asList("hiking", "painting"));
        network.addPerson("Bob Brown", 30, Arrays.asList("reading", "swimming"));
        network.addPerson("Emily Davis", 28, Arrays.asList("running", "swimming"));
        network.addPerson("Frank Wilson", 26, Arrays.asList("reading", "hiking"));

        // Adding friendships for demonstration
        network.addFriendship("John Doe", "Jane Smith");
        network.addFriendship("John Doe", "Alice Johnson");
        network.addFriendship("Jane Smith", "Bob Brown");
        network.addFriendship("Emily Davis", "Frank Wilson");

        // Finding shortest path for demonstration
        network.findShortestPath("John Doe", "Bob Brown");

        // Counting clusters for demonstration
        network.countClusters();

        scanner.close();
    }
    */
}
