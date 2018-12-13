//Ignacio Hidalgo
import java.util.*;
public class Trader extends java.lang.Object implements java.lang.Comparable<Trader>
{
  private Brokerage brokerage;
  private String name;
  private String pswd;
  private Queue<String> mailbox;

  public Trader(Brokerage brokerage, java.lang.String name, java.lang.String pswd)
  {
    this.brokerage = brokerage;
    this.name = name;
    this.pswd = pswd;
    this.mailbox = new LinkedList();
  }

  public int compareTo(Trader other)
  {
    return this.name.compareToIgnoreCase(other.name);
  }

  public boolean equals(Object other)
  {
    if(other.getClass == Trader)
    {
      if(this.compareTo(other) == 0)
        return true;
      else
        return false;
    }
    else
    {
      throw ClassCastException;
    }
  }

  public String getName()
  {
    return this.name;
  }

  public String getPassword()
  {
    return this.password;
  }

  public void getQuote(String symbol)
  {
    this.brokerage.getQuote(symbol, this);
  }

  public boolean hasMessages()
  {
    if(mailbox.isEmpty())
      return false;
    return true;
  }

  public void openWindow()
  {
    myWindow = new TraderWindow(this);
    while(!mailbox.isEmpty())
    {
      myWindw.show(mailbox.remove());
    }
  }

  public void placeOrder(TradeOrder order)
  {
    brokerage.placeOrder(order);
  }

  public void receiveMessage(String msg)
  {
    mailbox.add(msg);
  }


  public void quit()
  {
    brokerage.logout(this);
  }
}
