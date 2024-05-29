import java.util.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SocialNetworkGraph {
    Map<String, Person> people = new HashMap<>();
    Map<Person, List<Person>> friendships = new HashMap<>();

    // Method to add a person
    public void addPerson(String name, int age, List<String> hobbies) {
        Person found = people.get(name);;
        if (found == null){   
            Person person = new Person(name, age, hobbies);
            people.put(name, person);
            friendships.put(person, new ArrayList<>());
            System.out.println("Person added: " + person);
        }
        else
            System.out.println("Person with name " + name + " already added.");
    }

    // Method to add a person
    public void removePerson(String name) {
        Person removedPerson = people.remove(name);
        
        friendships.remove(removedPerson);

        for (Map.Entry<Person, List<Person>> entry : friendships.entrySet()) {
            entry.getValue().remove(removedPerson);
        }

        // Check if the person was removed
        if (removedPerson != null) {
            System.out.println("Removed person: " + removedPerson);
        } else {
            System.out.println("No person found with the name: " + name);
        }
    }


    // Method to add a friendship
    public void addFriendship(String name1, String name2) {
        Person person1 = people.get(name1);
        Person person2 = people.get(name2);
        boolean alreadyFriend = true;
        if ((person1 != null && person2 != null) && (person1 != person2)) {
            List<Person> friends1 = friendships.get(person1);
            List<Person> friends2 = friendships.get(person2);
            if (!friends1.contains(person2))
            {
                friends1.add(person2);
                alreadyFriend = false;
            }
            if (!friends2.contains(person1)) 
            {
                friends2.add(person1);
                alreadyFriend = false;
            }
            if(alreadyFriend == true)
                 System.out.println(name1 + " and " + name2 + " are altready friends");
            else
                System.out.println("Friendship added between " + person1.name + " and " + person2.name);
        
        } else {
            System.out.println("One or both persons not found in the network.");
        }
    }

    // Method to remove a friendship
    public void removeFriendship(String name1, String name2) {
        Person person1 = people.get(name1);
        Person person2 = people.get(name2);
        boolean alreadyFriend = false;
        if ((person1 != null && person2 != null) && (person1 != person2)) {
            List<Person> friends1 = friendships.get(person1);
            List<Person> friends2 = friendships.get(person2);
            if (friends1.contains(person2))
            {
                friends1.remove(person2);
                alreadyFriend = true;
            }
            if (friends2.contains(person1)) 
            {
                friends2.remove(person1);
                alreadyFriend = true;
            }
            if(alreadyFriend == false)
                 System.out.println(name1 + " and " + name2 + " are not friends");
            else
                System.out.println("Friendship removed between " + person1.name + " and " + person2.name);
        
        } else {
            System.out.println("One or both persons not found in the network.");
        }
    }


    // Method to find the shortest path using BFS
    public void findShortestPath(String startName, String endName) {
        //implement logic here
        Person startPerson = people.get(startName);
        Person endPerson = people.get(endName);
        
        if (startPerson == null || endPerson == null) {
            System.out.println("One or both persons not found in the network.");
            return;
        }

        Map<Person, Person> prev = new HashMap<>();
        Queue<Person> queue = new LinkedList<>();
        Set<Person> visited = new HashSet<>();

        queue.add(startPerson);
        visited.add(startPerson);

        while (!queue.isEmpty()) {
            Person current = queue.poll();
            if (current.equals(endPerson)) {
                printPath(startPerson, endPerson, prev);
                return;
            }

            for (Person neighbor : friendships.get(current)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                    prev.put(neighbor, current);
                }
            }
        }
    }

    private void printPath(Person start, Person end, Map<Person, Person> prev) {
        List<Person> path = new ArrayList<>();
        for (Person at = end; at != null; at = prev.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        System.out.println("Shortest path: ");
        for (Person person : path) {
            if(person.compareTo(end) != 0)
                System.out.print(person.getName() + " --> ");
            else
                System.out.print(person.getName());
        }
        System.out.println();
    }

    // Method to count clusters using BFS
    public void countClusters() {
        Set<Person> visited = new HashSet<>();
        int clusterCount = 0;

        for (Person person : people.values()) {
            if (!visited.contains(person)) {
                List<Person> cluster = new ArrayList<>();
                bfs(person, visited, cluster);
                clusterCount++;

                // Print the names of people in the cluster
                System.out.println("Cluster " + clusterCount + ":");
                for (Person p : cluster) {
                    System.out.println(p.getName());
                }
                System.out.println();
            }
        }

        System.out.println("Number of clusters found: " + clusterCount);
    }

    private void bfs(Person start, Set<Person> visited, List<Person> cluster) {
        Queue<Person> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            Person current = queue.poll();
            cluster.add(current);

            for (Person neighbor : friendships.get(current)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }


    // Method to suggest friends
    public void suggestFriends(String personName, int maxSuggestions) {
        Person person = people.get(personName);
        if (person == null) {
            System.out.println("Person not found in the network.");
            return;
        }

        Map<Person, Double> scores = new HashMap<>();
        
        for (Person candidate : people.values()) {
            if (!candidate.equals(person) && !friendships.get(person).contains(candidate)) {
                int mutualFriends = countMutualFriends(person, candidate);
                int commonHobbies = countCommonHobbies(person, candidate);

                double score = mutualFriends * 1.0 + commonHobbies * 0.5;
                scores.put(candidate, score);
            }
        }

        List<Map.Entry<Person, Double>> sortedCandidates = new ArrayList<>(scores.entrySet());
        sortedCandidates.sort((entry1, entry2) -> Double.compare(entry2.getValue(), entry1.getValue()));

        for (int i = 0; i < Math.min(maxSuggestions, sortedCandidates.size()); i++) {
            Map.Entry<Person, Double> entry = sortedCandidates.get(i);
            Person suggestedFriend = entry.getKey();
            double score = entry.getValue();
            int mutualFriends = countMutualFriends(person, suggestedFriend);
            int commonHobbies = countCommonHobbies(person, suggestedFriend);

            System.out.println(suggestedFriend.name + " (Score: " + score + ", " + mutualFriends + " mutual friends, " + commonHobbies + " common hobbies)");
        }
    }

    private int countMutualFriends(Person person1, Person person2) {
        List<Person> friends1 = friendships.get(person1);
        List<Person> friends2 = friendships.get(person2);
        Set<Person> mutualFriends = new HashSet<>(friends1);
        mutualFriends.retainAll(friends2);
        return mutualFriends.size();
    }

    private int countCommonHobbies(Person person1, Person person2) {
        Set<String> hobbies1 = new HashSet<>(person1.hobbies);
        Set<String> hobbies2 = new HashSet<>(person2.hobbies);
        hobbies1.retainAll(hobbies2);
        return hobbies1.size();
    }







}
