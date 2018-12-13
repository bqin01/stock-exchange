//Ignacio Hidalgo
public class Trader extends java.lang.Object implements java.lang.Comparable<Trader>
{
  Brokerage brokerage;
  String name;
  String pswd;
  public Trader(Brokerage brokerage, java.lang.String name, java.lang.String pswd)
  {
    this.brokerage = brokerage;
    this.name = name;
    this.pswd = pswd;
  }

  public int compareTo(Trader other)
  {
    return this.name.compareToIgnoreCase(other.name);
  }

  public boolean equals(Object other)
  {
    if(other.getClass == Trader)
    {

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

  }

  public boolean hasMessages()
  {

  }

  public void openWindow()
  {

  }

  public void placeOrder(TradeOrder order)
  {

  }

  public void receiveMessage(String msg)
  {

  }

  public void quit()
  {

  }
}
