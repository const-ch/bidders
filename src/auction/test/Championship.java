package auction.test;

import auction.bidder.Bidder;
import auction.bidder.HalfPriceBidder;
import auction.bidder.RandomBidder;
import auction.bidder.SimpleBidder;

/**
 * Created by kostiantynchernovol on 7/31/17.
 */
public class Championship {

    private static final int INITIAL_MONEY = 30;

    private static final int NUMBER_OF_ROUNDS = 100;

    private static final int TOTAL_QUANTITY = 10;

    public static void contestSimpleBidderVsRandomBidder(){

        Bidder firstBidder = new SimpleBidder();
        Bidder secondBidder = new RandomBidder();

        testCase(INITIAL_MONEY, TOTAL_QUANTITY, firstBidder, secondBidder, NUMBER_OF_ROUNDS,"Simple vs Random");
    }

    public static void contestClassicBidderVsRandomBidder(){

        Bidder firstBidder = new HalfPriceBidder();
        Bidder secondBidder = new RandomBidder();

        testCase(INITIAL_MONEY, TOTAL_QUANTITY, firstBidder, secondBidder, NUMBER_OF_ROUNDS,"Classic vs Random");
    }

    public static void contestClassicBidderVsSimpleBidder(){

        Bidder firstBidder = new HalfPriceBidder();
        Bidder secondBidder = new SimpleBidder();

        testCase(INITIAL_MONEY, TOTAL_QUANTITY, firstBidder, secondBidder, NUMBER_OF_ROUNDS, "Classic vs Simple");
    }

    public static void contestSimpleBidderVsSimpleBidder(){

        Bidder firstBidder = new SimpleBidder();
        Bidder secondBidder = new SimpleBidder();

        testCase(INITIAL_MONEY, TOTAL_QUANTITY, firstBidder, secondBidder, NUMBER_OF_ROUNDS,"Simple vs Simple");
    }

    private static void testCase
            (int initialMoney, int totalQuantityPairs, Bidder firstBidder, Bidder secondBidder, int numberOfRounds, String competitionName) {

        int draw = 0, firstWin = 0, secondWin = 0;

        for (int i = 0; i < numberOfRounds; i++) {

            firstBidder.init(totalQuantityPairs, initialMoney);
            secondBidder.init(totalQuantityPairs, initialMoney);

            double auctionResult = AuctionRunner.runAuction(totalQuantityPairs, firstBidder, secondBidder);
            if (auctionResult == 0) {
                draw++;
            } else {
                if (auctionResult > 0) {
                    firstWin++;
                } else {
                    secondWin++;
                }
            }
        }

        System.out.println();
        System.out.println("//----------------------------------------");
        System.out.println("//--------- "+competitionName);
        System.out.println("//----------------------------------------");
        System.out.println();
        System.out.println("//----------------------------------------");
        System.out.println("//--------- TOTAL RESULTS ----------------");
        System.out.println("//----------------------------------------");
        System.out.println("First bot won "+firstWin+" times ");
        System.out.println("Second bot won "+secondWin+" times ");
        System.out.println("Draw for "+draw+" times ");
    }

    public static void main(String[] argv){
        contestSimpleBidderVsRandomBidder();
        contestSimpleBidderVsSimpleBidder();
        contestClassicBidderVsRandomBidder();
        contestClassicBidderVsSimpleBidder();
    }
}
