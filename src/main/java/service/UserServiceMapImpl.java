package service;

import exception.UserException;
import model.User;

import java.util.Collection;
import java.util.HashMap;

public class UserServiceMapImpl implements UserService {

    private HashMap<String, User> userMap;

    public UserServiceMapImpl() {
        userMap = new HashMap<>();
    }

    @Override
    public void addUser(User user) {
        userMap.put(user.getId(), user);
    }

    @Override
    public Collection<User> getUsers() {
        return userMap.values();
    }

    @Override
    public User getUser(String id) {
        return userMap.get(id);
    }

    @Override
    public User editUser(User forEdit, String id) throws UserException {
        try {
//            if (id.equals(""))
//                throw new UserException("ID cannot be blank");

            User toEdit = userMap.get(id);

            if (toEdit == null)
                throw new UserException("User not found");

            if (forEdit.getEmail() != null) {
                toEdit.setEmail(forEdit.getEmail());
            }
            if (forEdit.getFirstName() != null) {
                toEdit.setFirstName(forEdit.getFirstName());
            }
            if (forEdit.getLastName() != null) {
                toEdit.setLastName(forEdit.getLastName());
            }
            if (forEdit.getId() != null) {
                toEdit.setId(forEdit.getId());
            }

            return toEdit;
        } catch (Exception ex) {
            throw new UserException(ex.getMessage());
        }
    }

    @Override
    public void deleteUser(String id) {
        userMap.remove(id);
    }

    @Override
    public boolean userExist(String id) {
        return userMap.containsKey(id);
    }

}