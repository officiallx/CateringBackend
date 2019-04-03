package org.obnoxious.Service;

import org.obnoxious.entities.User;
import org.obnoxious.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return (List<User>) userRepository.findAll();
    }

    public User getUser(Long userId){
        return userRepository.findOne(userId);
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public void updateUser(Long menuId, User user) {
        userRepository.save(user);
    }

    public void deleteUser(Long menuId) {
        userRepository.delete(menuId);
    }
}
