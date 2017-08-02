package auction.bidder;

/**
 * Created by kostiantynchernovol on 7/30/17.
 */
public interface Bidder {

    void init(int quantity, int cash);

    int placeBid();

    void bids(int own, int other);

    //ToDo deprecated used for stats
    @Deprecated
    int getQuantity();

    @Deprecated
    int getMoney();

}