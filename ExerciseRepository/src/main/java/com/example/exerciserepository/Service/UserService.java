package com.example.exerciserepository.Service;

import com.example.exerciserepository.Api.ApiException;
import com.example.exerciserepository.Model.User;
import com.example.exerciserepository.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(Integer id, User user) {
        User user1 = userRepository.findUserById(id);
        if(user==null) {
            throw new ApiException("id not found");
        }
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setPassword(user.getPassword());
        user1.setAge(user.getAge());
        user1.setRole(user.getRole());
        userRepository.save(user1);

    }

    public void deleteUser(Integer id) {
        User user = userRepository.findUserById(id);
        if (user == null) {
            throw new ApiException("id not found");
        }
        userRepository.delete(user);
    }

    public User email(String email) {
        User user = userRepository.findUserByEmail(email);
        if (user == null) {
            throw new ApiException("Email not found");
        }
        return user;
    }

    public List<User> role(String role) {
        List<User>  user = userRepository.findUsersByRole(role);
        if (user == null) {
            throw new ApiException("not found");
        }
        return user;
    }
    public List<User> age(Integer age) {
        List<User>  user = userRepository.findUsersByAge(age);
        if (user == null) {
            throw new ApiException("not found");
        }
        return user;
    }

    public User check(String userName , String password){
        User  user = userRepository.checkuser(userName , password);
        if (user == null) {
            throw new ApiException("not found");
        }
        return user;
    }
}
