package ua.testing.service;

import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.testing.confige.PasswordCoder;
import ua.testing.entity.Role;
import ua.testing.entity.User;
import ua.testing.repo.UserRepository;

@Service
public class UserService {

  private UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User findUserByUsername(String username) {
    return userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("No user with this username: " + username));
  }

  public void saveUser(User user) {
    userRepository.save(user);
  }
  public List<User> getAllUser(){
   return userRepository.findAll();
  }

  @PostConstruct
  private void addAdminUser() {
    userRepository.save(
        User.builder()
            .username("admin")
            .password(PasswordCoder.ENCODER.getEncoder().encode("admin"))
            .role(Collections.singleton(Role.ADMIN))
            .build()
    );
  }
}