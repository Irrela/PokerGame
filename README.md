# PokerGame
A stripped down version of Poker game,a Java practicing project.

## Introduction
There are a great mant variations of poker game,this project:
- Only consider a simple 5-card game.
- Rule is roughly based on Texas Poker's.
- With no limit of players.
- Allow same hand for multiple players,thus draw is possible.

## How to run
### User Compilation required
Download dictionary `src` and compile 3 java files in terminal or CMD,make sure you have JDK on your machine.  
I'm trying on a online version that can be run directly on browser but not finish yet.
> javac Poker.java PokerCard.java Player.java

Download JDK8:
https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
### About user input
Users need to assign cards for players,the main class is `Poker` and expects some multiple of 5 cards on the command line.
> java Poker *card1 card2 card3 card4 card5...*

And the program will generate the description and result of this round of game:  
If there is only one player,the output will be like:
>Player 1: *description of hand*  
Player 1 wins.

If more than one player,and player n wins:
>Player 1: *description of hand*   
Player 2: *description of hand*  
...  
Player n:*description of hand*  
...  
Player n wins.

If more than one player,and player n1 and n2 and n3 draw:
>Player 1:*description of hand*  
Player 2: *description of hand*  
...  
Player n1: *description of hand*  
...  
Player n1,n2 and n3 draw.

## Rules
A poker hand consists of 5 cards from a standard 52-card deck(without jokers).The rank,in order of increasing value,are 2~9,TEN,JACK,QUEEN,KING and ACE.
And the suits are Clubs (♣), Diamonds (♦), Hearts (♥), and Spades (♠).Each card has a rank and a suit,all combinations are valid.

### Classification of hand
There are 9 categories of hand as follows,in order of decreasing value:
1. Straight flush:consists of 5 cards of the same suit whose ranks form a sequence.
2. Four of a kind:consists of a set of four cards of the same rank.
3. Full house:consists of three cards of one rank and  two of another.
4. Flush:consists of 5 cards of the same suit.
5. Straight:consists of 5 cards whose ranks form a sequence,regardless of their suits.
6. Three of a kind:consists of 3 cards of the same rank,and any other 2 cards.
7. Two pair:consists of 2 cards of one rank,2 cards of another rank,and any other card.
8. One pair:consists of 2 cards of one rank,and any other 3 cards.
9. High card:consists of 5 cards.
 
The description of hand gives both the hand category and some indication of how to decide ties using standard Poker lingo as follows:

Category | Description | Detail 
- | :-: | :-: | 
Straight flush | r-high straight flush | r is highest rank in hand 
Four of a kind | Four rs | r is rank of 4 cards 
Full house | r1s full of r2s | r1 is rankof 3 cards; r2 is rank of2
Flush | r-high flush | r is highest rank in hand 
Straight | r-high straight | r is highest rank in hand 
Three of a kind | Three rs | r is rank of 3 cards 
Two Pair | r1s over r2s | r1 is rank of higher pair; r2 is rank of lower pair
One Pair | Pair of rs | r is rank of pair
High Card| r-high | r is highest rank in hand 


### About user input
Cards should be entered on the command line as two-character strings:
- The first being an A for Ace,K for King,Q for Queen,J for Jack,T for Ten, or digit between 2 and 9 for ranks 2~9. 
- The second character should be a C for Clubs (♣),D for Diamonds (♦),H for Hearts (♥),or S for Spades (♠).
- Case doesn't matter.

If invalid inputs found,the program will throws exception:  
1. Wrong number of arguments:
> Error: wrong number of arguments; must be a multiple of 5
2. Invalid card name:
>example: java Poker 7s 5d 9c jh qs  
Error: invalid card name ’c’(where c is the first invalid card entered)
