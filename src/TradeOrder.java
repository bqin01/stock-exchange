public class TradeOrder extends java.lang.Object
{
private Trader trader;
private String symbol;
private boolean buyOrder;
private boolean marketOrder;
private int numShares;
private double price;
public TradeOrder(Trader atrader, java.lang.String asymbol, boolean abuyOrder, boolean amarketOrder, int anumShares, double aprice)
{
    trader = atrader;
    symbol = asymbol;
    buyOrder = abuyOrder;
    marketOrder = amarketOrder;
    numShares = anumShares;
    price = aprice;
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
  if (isSell())

  //need to find a way to get the current number of shares otherwsie th
  //this should be pretty much done!!
  {
  //Subtracts a given number of shares from the total number of shares in this trade order.
    if (shares < numShares )
    {
      throw new java.lang.IllegalArgumentException("Not enough shares!");
    }else{
    shares -= numShares;
    }
  }
}//should the stockholder have an attribute for number of
// shares or should we create a counter in here???

}
