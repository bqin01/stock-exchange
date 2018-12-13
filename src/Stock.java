import java.util.*;
/**
 * Represents a stock in the SafeTrade project
 * @author Bill Qin
 * @version 1.0.0
 *
 **/
public class Stock{
  public static DecimalFormat money = "0.00";
  private double lowprice;
  private double highprice;
  private double lastprice;
  private double vol;
  private PriorityQueue<TradeOrder> buyQ;
  private PriorityQueue<TradeOrder> sellQ;
  private String asymbol;
  private String aname;
  /**
   * Constructs a new stock with a given symbol, company name, and starting price.
   * Sets low price, high price, and last price to the same opening price.
   * Sets "day" volume to zero.
   * Initializes a priority queue for sell orders to an empty PriorityQueue with a PriceComparator configured for comparing orders in ascending order;
   * initializes a priority queue for buy orders to an empty PriorityQueue with a PriceComparator configured for comparing orders in descending order.
   *
   * @param symbol - the stock symbol
   * @param name - full company name
   * @param price - opening price for this stock
   **/
  public Stock(String symbol, String name, double price){
    lowprice = price;
    highprice = price;
    lastprice = price;
    buyQ = new PriorityQueue<TradeOrder>(11, new PriceComparator(true));
    sellQ = new PriorityQueue<TradeOrder>(11, new PriceComparator(false));
    asymbol = symbol;
    aname = name;
    vol = 0;
  }
  /**
   * Returns a quote string for this stock.
   * @return The quote for this stock.
   *
   **/
  public String getQuote(){
    String str = aname + " (" + asymbol + ")\n";
    str += "Price: " + money.format(lastprice) + "  lo: " + money.format(lowprice) + "  hi: " + money.format(highprice)  + "vol: " + Math.sqrt(vol) + "\n";
    str += "Ask: " + sellQ.isEmpty()?"none":((sellQ.peek().getPrice()==lastprice)?"market":money.format(sellQ.peek().getPrice()) + "size " + sellQ.peek().getShare());
    str += "Bid: " + buyQ.isEmpty()?"none":((buyQ.peek().getPrice()==lastprice)?"market":money.format(buyQ.peek().getPrice()) + "size " + buyQ.peek().getShare());
    return str;
  }
  /**
   * Places a trading order for this stock.
   * Adds the order to the appropriate priority queue depending on whether this is a buy or sell order.
   * Notifies the trader who placed the order that the order has been placed, by sending a message to that trader.
   *
   * @param order - a trading order to be placed
   **/
  public void placeOrder(TradeOrder order){
    String str = "New order: ";
    str += order.isBuy()?"Buy ":"Sell ";
    str += asymbol + "(" + aname + ")\n";
    str += order.getShare() + " shares at " + (order.getPrice()==lastprice)?"market":money.format(order.getPrice());

    //somehow give the str to the Trader?
    neworder = executeOrders(order);
    if(neworder.getShares()!=0){
      if(order.isBuy()) buyQ.add(neworder);
      else sellQ.add(neworder);
    }
  }
  private TradeOrder executeOrders(TradeOrder order){
    int transacted = 0;
    if(order.isBuy()){
      while(order.getPrice() >= sellQ.peek().getPrice()){
        int removal = Math.min(order.getShares(),sellQ.peek.getShares());
        sellQ.peek().subtractShares(removal);
        order.subtractShares(removal);
        transacted += removal;
        if(sellQ.peek().getShares() == 0) sellQ.remove();
        else break;
      }
    }
    if(order.isSell()){
      while(order.getPrice() <= buyQ.peek().getPrice()){
        int removal = Math.min(order.getShares(),buyQ.peek.getShares());
        buyQ.peek().subtractShares(removal);
        order.subtractShares(removal);
        transacted += removal;
        if(buyQ.peek().getShares() == 0) buyQ.remove();
        else break;
      }
    }
    if(transacted != 0){
      String str = "";
      str += "You " + order.isBuy()?"bought":"sold" + ": " + transacted + " " + asymbol + " at "
                    + money.format(order.getPrice()) + " amt " + money.format(order.getPrice()*transacted);
      //somehow give the str to the Trader?
    }
    return order;
  }
}