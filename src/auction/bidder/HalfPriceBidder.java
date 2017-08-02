package auction.bidder;

/**
 * Created by kostiantynchernovol on 8/1/17.
 */
public class HalfPriceBidder extends BidderBase{

    private int REAL_PRICE;

    @Override
    public void init(int totalQuantity, int cash) {
        super.init(totalQuantity, cash);
        REAL_PRICE = cash/totalQuantity;
    }

    @Override
    int defineNextBid() {
        return REAL_PRICE/2;
    }

    @Override
    void analyzeAction(int own, int other) {

    }
}
