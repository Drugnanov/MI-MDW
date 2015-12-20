package cz.mdw.slama.hw7;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Drugnanov on 24.11.2015.
 */
@WebService
public class OrderService {

  public Order[] orders() {
    return Data.getOrders();
  }

  public boolean addOrder(Order order) {
    if (Data.containsOrder(order)) {
      return false;
    }
    Data.addOrder(order);
    return true;
  }

  public boolean removeOrder(Order order) {
    if (!Data.containsOrder(order)) {
      return false;
    }
    return Data.removeOrderFromList(order);
  }

  public boolean updateOrder(Order order) {
    if (!Data.containsOrder(order)) {
      return false;
    }
    return Data.updateOrderFromList(order);
  }
}

