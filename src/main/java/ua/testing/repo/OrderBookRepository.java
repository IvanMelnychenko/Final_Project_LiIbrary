package ua.testing.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.testing.entity.OrderBook;

@Repository
public interface OrderBookRepository extends JpaRepository<OrderBook, Long> {

}
