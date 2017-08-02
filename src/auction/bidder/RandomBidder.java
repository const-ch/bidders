package auction.bidder;

import java.util.Random;

/**
 * Created by kostiantynchernovol on 7/30/17.
 */
public class RandomBidder extends BidderBase {

    private final Random random = new Random();

    @Override
    int defineNextBid() {
        return random.nextInt(cash);
    }

    @Override
    void analyzeAction(int own, int other) {
        //dummy bot don't analize
    }
}
