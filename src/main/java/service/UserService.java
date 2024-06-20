package service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import exception.ResourceNotFoundException;
import model.User;
import repository.UserRepository;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(User.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        logger.debug("Saving user");
        return userRepository.save(user);
    }

    public List<User> findAll(){
        logger.info("Fetching all users");
        return userRepository.findAll();
    }

    public User findByUsername(String username){
        logger.info("Fetching user by username");
        return userRepository.findByUsername(username)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with username: " + username));

    }
    
}
