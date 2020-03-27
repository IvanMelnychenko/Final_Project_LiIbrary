package ua.testing.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "orderbook")
public class OrderBook {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne(optional = false)
private User user;
  @Column(name = "date_of_order")
  private LocalDateTime dateOf;
  @Column(name = "date_to_order")
  private LocalDateTime dateTo;
  @Column(name = "name_of_book_en", nullable = false)
  private String nameEn;
  @Column(name = "name_of_book_ua", nullable = false)
  private String nameUa;

  public OrderBook() {
  }
}
