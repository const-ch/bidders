There are several bidders implementations with testing environment for it

bidders:

- RandomBidder - randomly setted bids
- SimpleBidder - try to emulate simple human strategy, increasing partners bid, and trying to minimize price, also this is a mechanism to identify that parner is similar bidder and setting up zero bid to minimize price as possible.(This is according to 'Prisoner's' dilemma https://en.wikipedia.org/wiki/Prisoner%27s_dilemma )
- HalfPriceBidder - this is based on the formula for the maximum effective behaviour on blind and Vicrey auction https://en.wikipedia.org/wiki/Vickrey_auction, to use the half of real price. For the real price was choosen MU/QU - the average price. This implementation is very effective with random bidder.

seller - game's rule's implementation

testing:

MainProgram - run program with user input data

Championship - competition to compare different bidders in a great number of games.

//------------------------

According to tests RandomBidder is same effective comparing to SimpleBidder, but not effective with HalfPriceBidder.
Simple bidder always win with HalfPriceBidder.

As for me the task is classic implementation of blind auction and 'Prisoners dilemma' both. The solutions are not very effective, and the better solution is usage of machine learning tools to predict partners bids, for example gradient tool to extrapolate the function of partners desicion.
