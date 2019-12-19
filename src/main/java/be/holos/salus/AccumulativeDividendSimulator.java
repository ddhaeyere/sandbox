package be.holos.salus;

/**
 * @author Dieter D'haeyere on 26/09/14.
 */
public class AccumulativeDividendSimulator {
    private final static double STOCK_PRICE = 15.0;
    private final static double STOCK_DIVIDEND = 0.1;
    private final static double TRANSACTION_COST = 5.0;
    private final static double MONTHLY_PAYOUT = 20.0;

    private final static int MIN_NR_OF_STOCKS_TO_BUY_AT_ONCE = 1;
    private final static int MAX_NR_OF_STOCKS_TO_BUY_AT_ONCE = 50;
    private final static int MAX_NR_OF_REPAY_MONTHS = 120;

    private final static boolean PRINTOUT = false;


    public void runSimulation() {
        for (int minimalNrOfStocksToBuy = MIN_NR_OF_STOCKS_TO_BUY_AT_ONCE; minimalNrOfStocksToBuy <= MAX_NR_OF_STOCKS_TO_BUY_AT_ONCE; minimalNrOfStocksToBuy++) {
//            System.out.println("for minimum " + minimalNrOfStocksToBuy + " to buy, the nr of months is " + calculateMonthsTillProfit(minimalNrOfStocksToBuy));
            calculateMonthsTillProfit(minimalNrOfStocksToBuy);
        }
    }

    private Integer calculateMonthsTillProfit(int minimalNrOfStocksToBuy) {
        double totalCost = 0.0;
        double totalProfit = 0.0;
        int nrOfMonths = 0;
        int nrOfExtraStocks = 0;
        double capital = MONTHLY_PAYOUT;
        int paybackPeriodInMonths = -1;
        boolean breakEvenPointSet = false;
        int nrOftransactions = 0;

        while (nrOfMonths <= MAX_NR_OF_REPAY_MONTHS) {
            totalProfit += nrOfExtraStocks * STOCK_DIVIDEND;

            if (PRINTOUT) {
                System.out.println("before: nr of months: " + nrOfMonths + ", total profit: " + totalProfit + ", total cost: " + totalCost + "' capital: " + capital + ", nrOfExtra stocks: " + nrOfExtraStocks);
            }
            if ((totalProfit - TRANSACTION_COST) > totalCost && !breakEvenPointSet) {
                paybackPeriodInMonths = nrOfMonths;
                breakEvenPointSet = true;
            }


            if ((capital - TRANSACTION_COST) / STOCK_PRICE >= minimalNrOfStocksToBuy) {
//                System.out.println("investing " + capital + " to buy " + Math.floor((capital - TRANSACTION_COST) / STOCK_PRICE) + " stocks");
                totalCost += TRANSACTION_COST;
                nrOftransactions++;
                int nrOfStocksToBuy = (int) Math.floor((capital - TRANSACTION_COST) / STOCK_PRICE);
                capital -= nrOfStocksToBuy * STOCK_PRICE + TRANSACTION_COST;
                nrOfExtraStocks += nrOfStocksToBuy;
            }

            nrOfMonths++;
            capital += MONTHLY_PAYOUT + nrOfExtraStocks * STOCK_DIVIDEND;
            if (PRINTOUT) {
                System.out.println("after: nr of months: " + nrOfMonths + ", total profit: " + totalProfit + ", total cost: " + totalCost + "' capital: " + capital + ", nrOfExtra stocks: " + nrOfExtraStocks);
            }
        }
        System.out.println("for minimal number of stocks to buy: " + minimalNrOfStocksToBuy + ", paybackPeriodInMonths: " + paybackPeriodInMonths + ", nr of transactions: "+ nrOftransactions + ", total profit: " + (totalProfit - totalCost));

        return MAX_NR_OF_REPAY_MONTHS;
    }


    public static void main(String[] args) {

        AccumulativeDividendSimulator simulator = new AccumulativeDividendSimulator();
        simulator.runSimulation();

    }
}
