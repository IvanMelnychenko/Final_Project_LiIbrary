package ua.testing.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.testing.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

  Optional<Book> findBookByNameEn(String nameEn);

  Optional<Book> findBookByNameUa(String nameUa);

  Optional<Book> findBookByGenreEn(String genreEn);

  Optional<Book> findBookByGenreUa(String genreUA);

  /*Optional<Book> findBookByAuthor_NameEn(String nameEn);

  Optional<Book> findBookByAuthor_NameUa(String nameUa);*/
}
