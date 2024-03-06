import java.util.*;

class SocialNetwork {
    private Map<String, Set<String>> friendships;

    public SocialNetwork() {
        friendships = new HashMap<>();
    }

    public void addUser(String username) {
        if (!friendships.containsKey(username)) {
            friendships.put(username, new HashSet<>());
        } else {
            System.out.println("User already exists.");
        }
    }

    public void addFriendship(String user1, String user2) {
        if (friendships.containsKey(user1) && friendships.containsKey(user2)) {
            friendships.get(user1).add(user2);
            friendships.get(user2).add(user1);
            System.out.println("Friendship added between " + user1 + " and " + user2);
        } else {
            System.out.println("One or both users do not exist.");
        }
    }

    public void removeFriendship(String user1, String user2) {
        if (friendships.containsKey(user1) && friendships.containsKey(user2)) {
            friendships.get(user1).remove(user2);
            friendships.get(user2).remove(user1);
            System.out.println("Friendship removed between " + user1 + " and " + user2);
        } else {
            System.out.println("One or both users do not exist.");
        }
    }

    public void printFriends(String username) {
        if (friendships.containsKey(username)) {
            System.out.println("Friends of " + username + ": " + friendships.get(username));
        } else {
            System.out.println("User does not exist.");
        }
    }

    public static void main(String[] args) {
        SocialNetwork socialNetwork = new SocialNetwork();

        // Adding users
        socialNetwork.addUser("Alice");
        socialNetwork.addUser("Bob");
        socialNetwork.addUser("Charlie");

        // Adding friendships
        socialNetwork.addFriendship("Alice", "Bob");
        socialNetwork.addFriendship("Alice", "Charlie");

        // Printing friends of users
        socialNetwork.printFriends("Alice");
        socialNetwork.printFriends("Bob");
        socialNetwork.printFriends("Charlie");

        // Removing friendship
        socialNetwork.removeFriendship("Alice", "Bob");

        // Printing friends of users after removal
        socialNetwork.printFriends("Alice");
        socialNetwork.printFriends("Bob");
        socialNetwork.printFriends("Charlie");
    }
}
