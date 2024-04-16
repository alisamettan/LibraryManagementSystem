package librarymanagement.database;

import librarymanagement.model.User;

import java.util.ArrayList;
import java.util.List;

public class Users {
    private List<User> users;


    public Users() {
        users=new ArrayList<>();
        User user1=new User(1,"Ali Samet Tan");
        User user2=new User(2,"Barkın Argın");
        User user3=new User(3,"Alara Karacabey");
        User user4=new User(4,"Sinan Yıldız");
        User user5=new User(5,"Özge Çapar");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

    }

    public List<User> getUsers() {
        return users;
    }
}
