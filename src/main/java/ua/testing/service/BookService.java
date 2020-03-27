package ua.testing.service;

import java.util.List;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.testing.entity.Book;
import ua.testing.repo.BookRepository;

@Service
public class BookService {

  private BookRepository bookRepository;

  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public List<Book> getAllBook() {
    List<Book> listBooks = bookRepository.findAll();
    return listBooks;
  }

  public Book findBookByNameEn(String nameEn) {
    return bookRepository.findBookByNameEn(nameEn)
        .orElseThrow(() -> new UsernameNotFoundException("No books with name " + nameEn));
  }
  public Book findBookByNameUa(String nameUA) {
    return bookRepository.findBookByNameUa(nameUA)
        .orElseThrow(() -> new UsernameNotFoundException("No books with name " + nameUA));
  }
  public Book findBookByGenreEn(String genreEn) {
    return bookRepository.findBookByGenreEn(genreEn)
        .orElseThrow(() -> new UsernameNotFoundException("No books with genre " + genreEn));
  }
  public Book findBookByGenreUa(String genreUa) {
    return bookRepository.findBookByGenreUa(genreUa)
        .orElseThrow(() -> new UsernameNotFoundException("No books with genre " + genreUa));
  }
  /*public Book findBookByAuthorNameEn(String nameEn) {
    return bookRepository.findBookByAuthor_NameEn(nameEn)
        .orElseThrow(() -> new UsernameNotFoundException("No books with Author's name " + nameEn));
  }
  public Book findBookByAuthorNameUa(String nameUa) {
    return bookRepository.findBookByAuthor_NameUa(nameUa)
        .orElseThrow(() -> new UsernameNotFoundException("No books with Author's name " + nameUa));
  }*/

}
