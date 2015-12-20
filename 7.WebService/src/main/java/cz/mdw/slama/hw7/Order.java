package cz.mdw.slama.hw7;

/**
 * Created by Drugnanov on 20.12.2015.
 */
public class Order {

  int identity;
  int value;
  String item;
  String description;

  public int getIdentity() {
    return identity;
  }

  public void setIdentity(int identity) {
    this.identity = identity;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
