package auction.test;

import auction.bidder.Bidder;
import auction.seller.Seller;


/**
 * Created by kostiantynchernovol on 7/31/17.
 */
public class AuctionRunner {

    /**
     *
     * @return
     * positive result means first bidder's win
     * zero means draw
     * negative means second's win
     */
    public static double runAuction(int quantity, Bidder firstBidder, Bidder secondBidder) {

        Seller seller = new Seller(firstBidder, secondBidder);
        for(int i = quantity; i>0; i--) {
            seller.doTradeAction();
        }
        return firstBidder.getQuantity()-secondBidder.getQuantity();
    }
}
