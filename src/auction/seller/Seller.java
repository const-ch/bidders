package auction.seller;

import auction.bidder.*;

/**
 * Created by kostiantynchernovol on 7/30/17.
 */
public class Seller {

    private static int operations;
    private static int totalSellerIncome;

    private Bidder firstBidder;
    private Bidder secondBidder;


    public Seller(Bidder firstBidder, Bidder secondBidder) {
        this.firstBidder = firstBidder;
        this.secondBidder = secondBidder;
    }

    public void doTradeAction() {

        int firstBid = firstBidder.placeBid();
        int secondBid = secondBidder.placeBid();

        storeAction(firstBid + secondBid);
        displayAction(firstBid,secondBid);

        System.out.println("First bidder:");
        firstBidder.bids(firstBid, secondBid);
        System.out.println("Second bidder:");
        secondBidder.bids(secondBid, firstBid);
    }

    private void storeAction(int income) {
        operations++;
        totalSellerIncome += income;
    }

    private void displayAction(int firstBid, int secondBid ){
        System.out.println();
        System.out.println("//-----------------------------------" );
        System.out.println("First bidder spend " + firstBid);
        System.out.println("Second bidder spend " + secondBid);

        if(firstBid==secondBid){
            System.out.println("Draw ");
        }else {
            System.out.print(firstBid>secondBid ? "First" : "Second");
            System.out.println(" bidder bought items ");
        }

    }

    public static int getOperations() {
        return operations;
    }

    public static int getTotalSellerIncome() {
        return totalSellerIncome;
    }

}
