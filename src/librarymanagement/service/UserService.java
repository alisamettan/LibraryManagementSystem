package librarymanagement.service;

import librarymanagement.model.Library;
import librarymanagement.model.User;

public class UserService {
    private Library library;

    public UserService(Library library) {
        this.library = library;
    }

    public void addUser(User user){
        library.addUser(user);
    }

    public void removeUser(User user){
        library.removeUser(user);
    }

    public void updateUser(User user){
        for(User existingUser:library.getUsers()){
            if(existingUser.getId()==(user.getId())){
                existingUser.setName(user.getName());
                System.out.println("User updated successfully");
                return;
            }
        }
        System.out.println("User not found.");
    }
}
