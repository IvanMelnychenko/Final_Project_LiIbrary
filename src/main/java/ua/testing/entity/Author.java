package ua.testing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "author")
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "author_id")
  private Long id;
  @Column(name = "author_name_en",nullable = false)
  private String nameEn;
  @Column(name = "author_name_ua",nullable = false)
  private String nameUa;
  @Column(name = "author_surname_en",nullable = false)
  private String surnameEn;
  @Column(name = "author_surname_ua",nullable = false)
  private String surnameUa;
  @Column(name = "country_en")
  private String countryEn;
  @Column(name = "country_ua")
  private String countryUa;
}
