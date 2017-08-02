package auction.test;

import auction.bidder.Bidder;
import auction.bidder.RandomBidder;
import auction.bidder.SimpleBidder;
import auction.seller.Seller;

import java.util.Scanner;

/**
 * Created by kostiantynchernovol on 77/30/17.
 */
public class MainProgram {

    public static void main(String[] argv) {
        runWithUserInputData();
    }

    private static void runWithUserInputData() {
        System.out.println("Press any positive number to set quantity of sell actions");

        Scanner s = new Scanner(System.in);

        int totalQuantity = s.nextInt();

        if (totalQuantity < 0) {
            return;
        }

        System.out.println("Press any positive number to set initial money");

        int initialMoney = s.nextInt();

        Bidder firstBidder = new SimpleBidder();
        Bidder secondBidder = new RandomBidder();

        firstBidder.init(totalQuantity, initialMoney);
        secondBidder.init(totalQuantity, initialMoney);

        AuctionRunner.runAuction(totalQuantity, firstBidder,secondBidder);
    }
}
