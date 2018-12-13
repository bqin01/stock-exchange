public class TradeOrder extends java.lang.Object
{

TradeOrder(Trader trader, java.lang.String symbol, boolean buyOrder, boolean marketOrder, int numShares, double price)
{
  public int numShares;

}
public Trader getTrader()
{
  return trader;
}
public java.lang.String getSymbol()
{
  return symbol;
}
public boolean isBuy()
{
  return buyOrder;
}
public boolean isSell()
{
  return !buyOrder;
}
public boolean isMarket()
{
  return marketOrder;
}
public boolean isLimit()
{
  return !marketOrder;
}
public int getShares()
{
  return numShares;
}
public double getPrice()
{
  return price;
}
public void subtractShares(int shares)
{
  if (isSell)

  //need to find a way to get the current number of shares otherwsie th
  //this should be pretty much done!!
  {
  //Subtracts a given number of shares from the total number of shares in this trade order.
    if (shares < numShares );
    {
      throw java.lang.IllegalArgumentException;
    }
    shares -= numShares;
  }
}//should the stockholder have an attribute for number of
// shares or should we create a counter in here???

}
