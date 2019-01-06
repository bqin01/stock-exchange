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
  // public TradeOrder(TradeOrder order){
  //   trader = order.getTrader();
  //   symbol = order.getSymbol();
  //   buyOrder = order.isBuy();
  //   marketOrder = order.isMarket();
  //   numShares = order.getShares();
  //   price = order.getPrice();
  // }
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
      if (shares > numShares)
      {
        throw new java.lang.IllegalArgumentException("Not enough shares!");
      }else{
      numShares -= shares;
      }
  }
}
