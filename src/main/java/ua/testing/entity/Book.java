package ua.testing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "book_id")
  private Long id;
  @Column(name = "book_name_en",nullable = false)
  private String nameEn;
  @Column(name = "book_name_ua",nullable = false)
  private String nameUa;
  @Column(name= "available",nullable = false)
  private boolean isAvailable;
  @Column(name = "genre_en",nullable = false)
  private String genreEn;
  @Column(name = "genre_ua",nullable = false)
  private String genreUa;
  @Column(name = "number_page",nullable = false)
  private int numbPage;
  @OneToOne(optional = false)
  private Author author;
  @Column(name = "year",nullable = false)
  private int year;
}
