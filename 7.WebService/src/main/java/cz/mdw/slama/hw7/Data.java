package cz.mdw.slama.hw7;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Drugnanov on 20.12.2015.
 */
public class Data {

  public static List<Order> orders = new ArrayList<Order>();

  public static boolean updateOrderFromList(Order order) {
    for (Order o : orders) {
      if (o.getIdentity() == order.getIdentity()) {
        o.setDescription(order.getDescription());
        o.setItem(order.getItem());
        o.setValue(order.getValue());
        return true;
      }
    }
    return false;
  }

  public static boolean containsOrder(Order order) {
    for (Order o : orders) {
      if (o.getIdentity() == order.getIdentity())
        return true;
    }
    return false;
  }

  public static boolean removeOrderFromList(Order order) {
    for (Order o : orders) {
      if (o.getIdentity() == order.getIdentity()) {
        orders.remove(o);
        return true;
      }
    }
    return false;
  }

  public static Order[] getOrders() {
    return orders.toArray(new Order[orders.size()]);
  }


  public static void addOrder(Order order) {
    orders.add(order);
  }
}
