import java.util.*;

class FriendNode {
    int friendId;
    FriendNode next;

    FriendNode(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}

class UserNode {
    int userId;
    String name;
    int age;
    FriendNode friendList; // linked list of friend IDs
    UserNode next;

    UserNode(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendList = null;
        this.next = null;
    }
}

class SocialNetwork {
    private UserNode head = null;

    // Add new user
    public void addUser(int userId, String name, int age) {
        UserNode newUser = new UserNode(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            UserNode temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newUser;
        }
        System.out.println("User added successfully: " + name);
    }

    // Find user by ID
    private UserNode findUserById(int userId) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.userId == userId)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    // Add friend connection (both sides)
    public void addFriendConnection(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        if (areFriends(user1, userId2)) {
            System.out.println("They are already friends.");
            return;
        }

        addFriendToList(user1, userId2);
        addFriendToList(user2, userId1);
        System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
    }

    private void addFriendToList(UserNode user, int friendId) {
        FriendNode newFriend = new FriendNode(friendId);
        if (user.friendList == null) {
            user.friendList = newFriend;
        } else {
            FriendNode temp = user.friendList;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newFriend;
        }
    }

    // Check if users are already friends
    private boolean areFriends(UserNode user, int friendId) {
        FriendNode temp = user.friendList;
        while (temp != null) {
            if (temp.friendId == friendId)
                return true;
            temp = temp.next;
        }
        return false;
    }

    // Remove friend connection (both sides)
    public void removeFriendConnection(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        removeFriendFromList(user1, userId2);
        removeFriendFromList(user2, userId1);
        System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
    }

    private void removeFriendFromList(UserNode user, int friendId) {
        if (user.friendList == null)
            return;

        if (user.friendList.friendId == friendId) {
            user.friendList = user.friendList.next;
            return;
        }

        FriendNode temp = user.friendList;
        while (temp.next != null && temp.next.friendId != friendId)
            temp = temp.next;

        if (temp.next != null)
            temp.next = temp.next.next;
    }

    // Display all friends of a user
    public void displayFriends(int userId) {
        UserNode user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.print("Friends of " + user.name + ": ");
        FriendNode temp = user.friendList;
        if (temp == null) {
            System.out.println("No friends yet.");
            return;
        }
        while (temp != null) {
            UserNode friend = findUserById(temp.friendId);
            System.out.print(friend.name + " (" + friend.userId + ") ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Find mutual friends between two users
    public void findMutualFriends(int userId1, int userId2) {
        UserNode user1 = findUserById(userId1);
        UserNode user2 = findUserById(userId2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        System.out.print("Mutual friends between " + user1.name + " and " + user2.name + ": ");
        FriendNode f1 = user1.friendList;
        boolean found = false;

        while (f1 != null) {
            if (areFriends(user2, f1.friendId)) {
                UserNode mutual = findUserById(f1.friendId);
                System.out.print(mutual.name + " ");
                found = true;
            }
            f1 = f1.next;
        }

        if (!found)
            System.out.println("No mutual friends.");
        else
            System.out.println();
    }

    // Search for a user by Name
    public void searchByName(String name) {
        UserNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("Found User -> ID: " + temp.userId + ", Name: " + temp.name + ", Age: " + temp.age);
                found = true;
            }
            temp = temp.next;
        }
        if (!found)
            System.out.println("User not found.");
    }

    // Search for a user by ID
    public void searchById(int userId) {
        UserNode user = findUserById(userId);
        if (user == null)
            System.out.println("User not found.");
        else
            System.out.println("Found User -> ID: " + user.userId + ", Name: " + user.name + ", Age: " + user.age);
    }

    // Count number of friends for each user
    public void countFriends() {
        UserNode temp = head;
        System.out.println("\n--- Friend Counts ---");
        while (temp != null) {
            int count = 0;
            FriendNode f = temp.friendList;
            while (f != null) {
                count++;
                f = f.next;
            }
            System.out.println(temp.name + " has " + count + " friend(s).");
            temp = temp.next;
        }
    }

    // Display all users
    public void displayAllUsers() {
        if (head == null) {
            System.out.println("No users in the system.");
            return;
        }
        UserNode temp = head;
        System.out.println("\n--- All Users ---");
        while (temp != null) {
            System.out.println("ID: " + temp.userId + ", Name: " + temp.name + ", Age: " + temp.age);
            temp = temp.next;
        }
    }
}

public class SocialMediaSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SocialNetwork sn = new SocialNetwork();

        while (true) {
            System.out.println("\n=== Social Media Friend Management ===");
            System.out.println("1. Add User");
            System.out.println("2. Add Friend Connection");
            System.out.println("3. Remove Friend Connection");
            System.out.println("4. Display All Friends of a User");
            System.out.println("5. Find Mutual Friends");
            System.out.println("6. Search User by Name");
            System.out.println("7. Search User by ID");
            System.out.println("8. Count Friends for Each User");
            System.out.println("9. Display All Users");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter User ID, Name, Age: ");
                    sn.addUser(sc.nextInt(), sc.next(), sc.nextInt());
                    break;
                case 2:
                    System.out.print("Enter two User IDs to connect: ");
                    sn.addFriendConnection(sc.nextInt(), sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter two User IDs to remove connection: ");
                    sn.removeFriendConnection(sc.nextInt(), sc.nextInt());
                    break;
                case 4:
                    System.out.print("Enter User ID: ");
                    sn.displayFriends(sc.nextInt());
                    break;
                case 5:
                    System.out.print("Enter two User IDs: ");
                    sn.findMutualFriends(sc.nextInt(), sc.nextInt());
                    break;
                case 6:
                    System.out.print("Enter Name: ");
                    sn.searchByName(sc.next());
                    break;
                case 7:
                    System.out.print("Enter User ID: ");
                    sn.searchById(sc.nextInt());
                    break;
                case 8:
                    sn.countFriends();
                    break;
                case 9:
                    sn.displayAllUsers();
                    break;
                case 10:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
