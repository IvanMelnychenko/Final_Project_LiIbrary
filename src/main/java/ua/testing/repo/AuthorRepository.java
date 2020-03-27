package ua.testing.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.testing.entity.Author;


public interface AuthorRepository extends JpaRepository<Author,Long> {

  Optional<Author> findByNameEn(String nameEn);
  Optional<Author> findByNameUa(String nameUa);
  Optional<Author> findBySurnameEn(String surnameEn);
  Optional<Author> findBySurnameUa(String surnameUa);
}
