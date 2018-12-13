import java.util.*;

public class Brokerage extends java.lang.Object implements Login
{
  private TreeMap<String,Trader> brokers;
  private TreeSet<Trader> active_brokers;
  private StockExchange thisexchange;
  Brokerage(StockExchange exchange)
  {
    //tree map  = brokers
    brokers = new TreeMap<String,Trader>();
    active_brokers = new TreeSet<Trader>();
    // tree set = active_brokers
    thisexchange = exchange;
  }
  public int addUser(java.lang.String name, java.lang.String password)//done
  {
    if (name.length() > 10 || name.length()<4)
    {
      return -1;
    }
    if (password.length() > 10 || password.length()<2)
    {
      return -2;
    }
    private boolean uniqueness = true;

    for (String str: brokers.keySet())
    {
      if (str.equals(name))
      {
        uniqueness = false;
      }
    }
    if (!uniqueness)
    {
      return -3;
    }
    return 0;
  }
  public void getQuote(java.lang.String symbol, Trader trader)
  {

  }
  public int login(java.lang.String name, java.lang.String password) //done
  {
    for ( Trader t: brokers.values())
    {
      if (t.getName().equals(name))
      {
        if(t.getPassword().equals(password))
        {
          for (Trader ti: active_brokers.values())
          {
            if (t.equals(ti)
            {
              return -3;
            }
          }
          if (!t.hasMessage())
          {
            t.receiveMessage("Welcome to SafeTrade!");
          }
          active_brokers.add(t);
          return 0;
        }
      }
      return -2;
    }
    return -1;


  }
  public void logout(Trader trader)
  {
    active_brokers.remove(trader);
  }
  public void placeOrder(TradeOrder order)
  {

  }
}
