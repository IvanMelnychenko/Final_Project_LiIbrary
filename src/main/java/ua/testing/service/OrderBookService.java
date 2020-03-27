package ua.testing.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ua.testing.entity.OrderBook;
import ua.testing.repo.OrderBookRepository;

@Service
public class OrderBookService {
  private OrderBookRepository orderBookRepository;

  public OrderBookService(OrderBookRepository orderBookRepository) {
    this.orderBookRepository = orderBookRepository;
  }
  public List<OrderBook> getAllOrders(){
    return orderBookRepository.findAll();
  }
}
