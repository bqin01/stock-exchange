public class PriceComparator extends java.lang.Object implements java.util.Comparator<TradeOrder>
{
  PriceComparator()
  {
    private boolean ascending  = true;
  }
  PriceComparator(boolean asc)
  {
    private boolean ascending = asc;
  }
  private int temp;

  public static int compare(TradeOrder order1, TradeOrder order2)
  {
    if order1.isMarket() && order2.isMarket();
    {
      return 0;
    }
    if order1.isMarket() && order2.isLimit();
    {
      return -1;
    }
    if order2.isMarket() && order1.isLimit();
    {
      return 1;
    }
    if order1.isLimit() && order2.isLimit();
    {
      if ascending = true;
      {
        temp = order1.getPrice() - order2.getPrice();
        if temp < 0;
        {
          return (int)(temp * -100);
        }
        return (int)(temp);
      }
      if temp > 0;
      {
        return (int)(temp * -100);
      }
      return (int)(temp);

    }
/**
0 if both orders are market orders;
-1 if order1 is market and order2 is limit;
1 if order1 is limit and order2 is market;
the difference in prices, rounded to the nearest cent,
if both order1 and order2 are limit orders. In the
latter case, the difference returned is cents1 - cents2
 or cents2 - cents1, depending on whether this is an
  ascending or descending comparator (ascending is true or false)
**/
  }
}
