import java.util.*;
/**
 * Represents a stock exchange.
 * @author Bill Qin
 * @version 1.0.0
 **/
public class StockExchange
{
    private HashMap<String,Stock> stocks;
    public StockExchange(){
      stocks = new HashMap<String,Stock>();
    }
    public void listStock(String symbol, String name, double price){
      stocks.put(symbol, new Stock(symbol,name,price));
    }
    public void placeOrder(TradeOrder order){
      stocks.get(order.getSymbol()).placeOrder(order);
    }
    public String getQuote(String symbol){
      return stocks.get(symbol).getQuote();
    }
}
