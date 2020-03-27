package ua.testing.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.testing.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
  Optional<User> findByUsername(String username);
}
