package auction.bidder;

/**
 * Created by kostiantynchernovol on 7/30/17.
 */
public abstract class BidderBase implements Bidder {

    private int quantity;

    private int totalQuantity;

    protected int cash;

    @Override
    public void init(int totalQuantity, int cash) {
        this.totalQuantity = totalQuantity;
        this.cash = cash;
        quantity=0;
    }

    @Override
    public void bids(int own, int other) {
        if (own == other) {
            quantity++;
        } else {
            if (own > other) {
                quantity += 2;
            }
        }
        displayState();
        analyzeAction(own, other);
    }

    @Override
    public int placeBid() {
        int nextBid = defineNextBid();
        cash -= nextBid;
        return nextBid;
    }

    private void displayState(){
        System.out.println("amounth : "+cash);
        System.out.println(quantity + " items");
    }

    abstract int defineNextBid();

    abstract void analyzeAction(int own, int other);

    public int getMoney() {
        return cash;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }
}
