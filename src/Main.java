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
        int maxFriends;
        
        // Adding some initial people for demonstration
        addInitialPeople(network);
        
        while (!exit) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:                     // Adding a new person
                                
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
                case 2:                    // Removing a person
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    network.removePerson(name);
                    break;
                case 3:                    // Adding a friendship
                    
                    System.out.print("Enter first person's name: ");
                    firstName = scanner.nextLine();

                    System.out.print("Enter second person's name: ");
                    secondName = scanner.nextLine();
                    
                    network.addFriendship(firstName, secondName);
                    break;
                case 4:                    // Removing a friendship

                    System.out.print("Enter first person's name: ");
                    firstName = scanner.nextLine();

                    System.out.print("Enter second person's name: ");
                    secondName = scanner.nextLine();

                    network.removeFriendship(firstName, secondName);
                    break;
                case 5:                    // Finding shortest path
                    System.out.print("Enter first person's name: ");
                    firstName = scanner.nextLine();

                    System.out.print("Enter second person's name: ");
                    secondName = scanner.nextLine();
                    network.findShortestPath(firstName, secondName);
                    break;
                case 6:                    // Suggesting friends
                    

                    // Prompt the user for input
                    System.out.print("Enter person’s name: ");
                    name = scanner.nextLine();

                    System.out.print("Enter maximum number of friends to suggest: ");
                    maxFriends = scanner.nextInt();
                    System.out.println("Suggested friends for " + name + ":");
                    System.out.println();
                    network.suggestFriends(name, maxFriends);
                    break;
                case 7:                    // Counting clusters
                    System.out.println("Counting clusters in the social network...");
                    network.countClusters();
                    break;
                case 8:                    // Exiting the program
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


    private static void addInitialPeople(SocialNetworkGraph network) {
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


        network.addPerson("Charlie Lee", 29, Arrays.asList("cooking", "painting"));
        network.addPerson("David Kim", 24, Arrays.asList("reading", "cooking"));
        network.addPerson("Ella Garcia", 31, Arrays.asList("running", "painting"));
        network.addPerson("Grace Martinez", 23, Arrays.asList("swimming", "painting"));
        network.addPerson("Henry Nguyen", 32, Arrays.asList("reading", "hiking"));

        // Adding more friendships for demonstration
        network.addFriendship("Alice Johnson", "Charlie Lee");
        network.addFriendship("Alice Johnson", "David Kim");
        network.addFriendship("Charlie Lee", "David Kim");
        network.addFriendship("Ella Garcia", "Grace Martinez");
        network.addFriendship("Henry Nguyen", "Frank Wilson");


        // Adding more people for demonstration
        network.addPerson("Isabella Hernandez", 26, Arrays.asList("reading", "cooking"));
        network.addPerson("Jacob Lopez", 30, Arrays.asList("running", "painting"));
        network.addPerson("Liam Gonzalez", 28, Arrays.asList("swimming", "hiking"));
        network.addPerson("Mia Perez", 25, Arrays.asList("reading", "painting"));
        network.addPerson("Noah Torres", 29, Arrays.asList("cooking", "running"));
        network.addPerson("Olivia Ramirez", 27, Arrays.asList("swimming", "hiking"));
        network.addPerson("Sophia Flores", 24, Arrays.asList("reading", "painting"));
        network.addPerson("William Cruz", 31, Arrays.asList("cooking", "running"));

        // Adding more friendships for demonstration
        network.addFriendship("Isabella Hernandez", "Jacob Lopez");
        network.addFriendship("Isabella Hernandez", "Mia Perez");
        network.addFriendship("Jacob Lopez", "Liam Gonzalez");
        network.addFriendship("Mia Perez", "Noah Torres");
        network.addFriendship("Noah Torres", "Olivia Ramirez");
        network.addFriendship("Olivia Ramirez", "Sophia Flores");
        network.addFriendship("Sophia Flores", "William Cruz");

        network.addPerson("Tayyip Soner Tekin", 22, Arrays.asList("Planting", "Surviving"));
    }



}
