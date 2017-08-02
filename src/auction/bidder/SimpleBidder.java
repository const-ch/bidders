package auction.bidder;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by kostiantynchernovol on 7/30/17.
 */
public class SimpleBidder extends BidderBase {

    private final int OTHER_BOT_IS_TWIN_FACTOR = 3;//number of draws signalize that we play with same bot

    private LinkedList<Bids> bidsLog = new LinkedList<>();

    @Override
    int defineNextBid() {

        Bids previousBids = bidsLog.peek();
        if(bidsLog.isEmpty())
            return getFirstBid();

        int effectiveBid;
        if(previousBids.getOwn()>previousBids.getOther()){//own wins and try to decrease price
            effectiveBid = previousBids.getOther()+1;
        }else {
            if(previousBids.getOther()==previousBids.getOwn()){
                effectiveBid = getAfterDrawBid();
            }else {
                effectiveBid = previousBids.getOther()+1;//lose, then try to increase other bot's price
            }
        }

        if(effectiveBid>cash) {
            effectiveBid = cash;
        }

        return effectiveBid;
    }

    private int getAfterDrawBid(){
        if(checkIfOtherBotIsTwin()) {
            return bidsLog.peek().getOther()-1;
        }else {
            return 0;//if bots are the same we just set minimum price and save the money
        }
    }

    private boolean checkIfOtherBotIsTwin(){
        if (bidsLog.size()>OTHER_BOT_IS_TWIN_FACTOR) {
            for (int i = bidsLog.size()-1; i > bidsLog.size() - OTHER_BOT_IS_TWIN_FACTOR; i--) {
                Bids bids = bidsLog.get(i);
                if (bids.getOther() == bids.getOther()) {
                    return false;
                }
            }
        }
        return true;
    }

    private int getFirstBid(){
        return (new Random()).nextInt(1);
    }

    @Override
    void analyzeAction(int own, int other) {
        bidsLog.add(new Bids(own, other));
    }

    private class Bids {
        private int own;
        private int other;

        public Bids(int own, int other) {
            this.own = own;
            this.other = other;
        }

        public int getOwn() {
            return own;
        }

        public int getOther() {
            return other;
        }
    }
}
