/**
 * Player class hold 5 PokerCard instances as a hand, and provides methods below:
 * 
 * 1.Resort hand in terms of rank.
 * 2.Get rank occurs most times.
 * 3.Some hand judging method,like judge a hand is a straight or not.
 * 4.Derive a hand-comparing string based on rules of Poker game(using methods in 3).
 * 5.Get a hand description of this player.
 */
import java.util.Arrays;

public class Player {

    private PokerCard[] hand = new PokerCard[5];
    private int number;

    public Player(){}

    public Player(PokerCard[] card, int number) {
        this.setHand(card);
        this.setNumber(number);
    }

    private void setHand(PokerCard[] hand) {
        this.hand = hand;
    }

    public int getNumber() {
        return number;
    }

    private void setNumber(int number) {
        this.number = number;
    }
    
    /**
     * Sort the cards of a hand accroding to rank.
     */
    private PokerCard.Rank[] getSortedRankOfHand(){
        PokerCard.Rank[] temp = new PokerCard.Rank[5];

        for(int i = 0;i < 5;i++){
            temp[i] = hand[i].getRank();
        }

        Arrays.sort(temp);
        return temp;
    }

    /**
     * Get the count of rank who occurs most times in a hand.
     */
    private int getRankDegreeOfHand(){
        int degree = 0;

        for(int i = 0;i < 4;i++) {
            if (this.getSortedRankOfHand()[i].ordinal() ==
                    this.getSortedRankOfHand()[i + 1].ordinal()){
                degree++;
            }
        }

        return  degree;
    }

    /**
     * Get an Array carrying classifications information of a hand,which can be used to derive:
     *
     * 1.Formatted description of a hand.
     * 2.Hand-weight comparing string, can decide which player's hand is greater.
     * 
     * @see com.ProjPoker.Player.getDescription() 
     * @see com.ProPoker.Player.getHandWeightString)()
     * 
     * @return Array of Rank type
     */
    private PokerCard.Rank[] getRankInfoArray(){

        PokerCard.Rank[] tempArray = new PokerCard.Rank[26];

        for(int i = 0;i < 26;i++){
            tempArray[i] = PokerCard.Rank.INIT;
        }

        if(this.isFlush()&&this.isStraight()){
            tempArray[0] = this.getSortedRankOfHand()[4];
        }

        if(this.getTypeFourOfKind() != 0){
            switch(this.getTypeFourOfKind()){
                case 1:
                    tempArray[1] = this.getSortedRankOfHand()[0];
                    tempArray[2] = this.getSortedRankOfHand()[4];
                    break;
                case 2:
                    tempArray[1] = this.getSortedRankOfHand()[1];
                    tempArray[2] = this.getSortedRankOfHand()[0];
                    break;
            }
        }

        if(this.getTypeFullHouse() != 0){
            switch (this.getTypeFullHouse()){
                case 1:
                    tempArray[3] = this.getSortedRankOfHand()[0];
                    tempArray[4] = this.getSortedRankOfHand()[3];
                    break;
                case 2:
                    tempArray[3] = this.getSortedRankOfHand()[2];
                    tempArray[4] = this.getSortedRankOfHand()[0];
                    break;
            }
        }

        if(this.isFlush()){
            for(int i = 0 ;i < 5;i++){
                tempArray[9-i] = this.getSortedRankOfHand()[i];
            }
        }

        if(this.isStraight()){
            tempArray[10] = this.getSortedRankOfHand()[4];
        }

        if(this.getTypeThreeOfKind() != 0){
            switch (this.getTypeThreeOfKind()){
                case 1:
                    tempArray[11] = this.getSortedRankOfHand()[0];
                    tempArray[12] = this.getSortedRankOfHand()[4];
                    tempArray[13] = this.getSortedRankOfHand()[3];
                    break;
                case 2:
                    tempArray[11] = this.getSortedRankOfHand()[1];
                    tempArray[12] = this.getSortedRankOfHand()[4];
                    tempArray[13] = this.getSortedRankOfHand()[0];
                    break;
                case 3:
                    tempArray[11] = this.getSortedRankOfHand()[2];
                    tempArray[12] = this.getSortedRankOfHand()[1];
                    tempArray[13] = this.getSortedRankOfHand()[0];
                    break;
            }
        }

        if(this.getTypeTwoPair() != 0){
            switch (this.getTypeTwoPair()){
                case 1:
                    tempArray[14] = this.getSortedRankOfHand()[2];
                    tempArray[15] = this.getSortedRankOfHand()[0];
                    tempArray[16] = this.getSortedRankOfHand()[4];
                    break;
                case 2:
                    tempArray[14] = this.getSortedRankOfHand()[3];
                    tempArray[15] = this.getSortedRankOfHand()[0];
                    tempArray[16] = this.getSortedRankOfHand()[2];
                    break;
                case 3:
                    tempArray[14] = this.getSortedRankOfHand()[3];
                    tempArray[15] = this.getSortedRankOfHand()[1];
                    tempArray[16] = this.getSortedRankOfHand()[0];
                    break;
            }
        }

        if(this.getTypeOnePair() != 0){
            switch (this.getTypeOnePair()){
                case 1:
                    tempArray[17] = this.getSortedRankOfHand()[0];
                    tempArray[18] = this.getSortedRankOfHand()[4];
                    tempArray[19] = this.getSortedRankOfHand()[3];
                    tempArray[20] = this.getSortedRankOfHand()[2];
                    break;
                case 2:
                    tempArray[17] = this.getSortedRankOfHand()[1];
                    tempArray[18] = this.getSortedRankOfHand()[4];
                    tempArray[19] = this.getSortedRankOfHand()[3];
                    tempArray[20] = this.getSortedRankOfHand()[0];
                    break;
                case 3:
                    tempArray[17] = this.getSortedRankOfHand()[2];
                    tempArray[18] = this.getSortedRankOfHand()[4];
                    tempArray[19] = this.getSortedRankOfHand()[1];
                    tempArray[20] = this.getSortedRankOfHand()[0];
                    break;
                case 4:
                    tempArray[17] = this.getSortedRankOfHand()[3];
                    tempArray[18] = this.getSortedRankOfHand()[2];
                    tempArray[19] = this.getSortedRankOfHand()[1];
                    tempArray[20] = this.getSortedRankOfHand()[0];
                    break;
            }
        }

        if(this.isHighCard()){
            for(int i = 0 ;i < 5;i++){
                tempArray[25-i] = this.getSortedRankOfHand()[i];
            }
        }

        return tempArray;
    }

    /**
     * This method generates formatted description of a hand.
     */
    public String getDescription(){

        String tempString = "";

        for(int i = 0;i < 26;i++){
            if(!this.getRankInfoArray()[0].getRankName().equals("INIT")){
                tempString = this.getRankInfoArray()[0].getRankName()+"-high straight flush";
                break;
            }

            if(!this.getRankInfoArray()[1].getRankName().equals("INIT")){
                tempString = "Four "+this.getRankInfoArray()[1].getRankName()+"s";
                break;
            }

            if(!this.getRankInfoArray()[3].getRankName().equals("INIT")){
                tempString = this.getRankInfoArray()[3].getRankName()+"s full of "+
                        this.getRankInfoArray()[4].getRankName()+"s";
                break;
            }

            if(!this.getRankInfoArray()[5].getRankName().equals("INIT")){
                tempString = this.getRankInfoArray()[5].getRankName()+"-high flush";
                break;
            }

            if(!this.getRankInfoArray()[10].getRankName().equals("INIT")){
                tempString = this.getRankInfoArray()[10].getRankName()+"-high straight";
                break;
            }

            if(!this.getRankInfoArray()[11].getRankName().equals("INIT")){
                tempString = "Three "+this.getRankInfoArray()[11].getRankName()+"s";
                break;
            }

            if(!this.getRankInfoArray()[14].getRankName().equals("INIT")){
                tempString = this.getRankInfoArray()[14].getRankName()+"s over "+
                        this.getRankInfoArray()[15].getRankName()+"s";
                break;
            }

            if(!this.getRankInfoArray()[17].getRankName().equals("INIT")){
                tempString = "Pair of "+this.getRankInfoArray()[17].getRankName()+"s";
                break;
            }

            if(!this.getRankInfoArray()[21].getRankName().equals("INIT")){
                tempString = this.getRankInfoArray()[21].getRankName()+"-high";
                break;
            }
        }
        return tempString;
    }

    /**
     * This method concatenates all elements in RankInfoArray as a string, 
     * which can tell whose hand is greater.
     * 
     * For example, a Ace-high flush hand's string will be generated like:
     * 1111111111242322211911111111111111111111111111111111
     * and a 3s full of 7s hand's string:
     * 1111111317111111111111111111111111111111111111111111
     * as 3s full of 7s is greater than Ace-high flush.
     *
     * @see com.ProjPoker.PokerCard.getRankWeight() 
     */
    public String getHandWeightString(){

        String tempString = "";

        for(PokerCard.Rank x : this.getRankInfoArray()){
            tempString = tempString.concat(x.getRankWeight());
        }

        return tempString;
    }

    private boolean isFlush(){
        int flag = 0;

        for(int i = 0;i < 4;i++) {
            if (hand[i].getSuit() == hand[i + 1].getSuit()) {
                flag++;
            }
        }

        return flag == 4;
    }

    private boolean isStraight(){
        int flag = 0;

        for(int i = 0;i < 4;i++) {
            if (this.getSortedRankOfHand()[i].ordinal() ==
                    this.getSortedRankOfHand()[i + 1].ordinal()-1){

                flag++;
            }
        }

        return flag == 4;
    }

    private int getTypeFourOfKind(){

        if(this.getRankDegreeOfHand() == 3 &&
                (this.getSortedRankOfHand()[3] != this.getSortedRankOfHand()[4])){

            return 1;

        }else if(this.getRankDegreeOfHand() == 3 &&
                this.getSortedRankOfHand()[0] != this.getSortedRankOfHand()[1]){

            return 2;

        }else {
            return 0;
        }
    }

    private int getTypeFullHouse(){

        if(this.getRankDegreeOfHand() == 3 &&
                (this.getSortedRankOfHand()[2] != this.getSortedRankOfHand()[3])){

            return 1;

        }else if(this.getRankDegreeOfHand() == 3 &&
                (this.getSortedRankOfHand()[1] != this.getSortedRankOfHand()[2])){

            return 2;

        }else {
            return 0;
        }
    }

    private int getTypeThreeOfKind(){
        if(this.getRankDegreeOfHand() == 2 &&
                (this.getSortedRankOfHand()[0] == this.getSortedRankOfHand()[1] &&
                        this.getSortedRankOfHand()[1] == this.getSortedRankOfHand()[2])){

            return 1;

        }else if(this.getRankDegreeOfHand() == 2 &&
                (this.getSortedRankOfHand()[1] == this.getSortedRankOfHand()[2] &&
                        this.getSortedRankOfHand()[2] == this.getSortedRankOfHand()[3])){

            return 2;

        }else if(this.getRankDegreeOfHand() == 2 &&
                (this.getSortedRankOfHand()[2] == this.getSortedRankOfHand()[3] &&
                        this.getSortedRankOfHand()[3] == this.getSortedRankOfHand()[4])){

            return 3;

        }else {
            return 0;
        }
    }

    private int getTypeTwoPair(){
        if(this.getRankDegreeOfHand() == 2 &&
                (this.getSortedRankOfHand()[0] == this.getSortedRankOfHand()[1] &&
                        this.getSortedRankOfHand()[2] == this.getSortedRankOfHand()[3])){

            return 1;

        }else if(this.getRankDegreeOfHand() == 2 &&
                (this.getSortedRankOfHand()[0] == this.getSortedRankOfHand()[1] &&
                        this.getSortedRankOfHand()[3] == this.getSortedRankOfHand()[4])){

            return 2;

        }else if(this.getRankDegreeOfHand() == 2 &&
                (this.getSortedRankOfHand()[1] == this.getSortedRankOfHand()[2] &&
                        this.getSortedRankOfHand()[3] == this.getSortedRankOfHand()[4])){

            return 3;

        }else {
            return 0;
        }
    }

    private int getTypeOnePair(){
        if(this.getRankDegreeOfHand() == 1 &&
                this.getSortedRankOfHand()[0] == this.getSortedRankOfHand()[1]){

            return 1;

        }else if(this.getRankDegreeOfHand() == 1 &&
                this.getSortedRankOfHand()[1] == this.getSortedRankOfHand()[2]){

            return 2;

        }else if(this.getRankDegreeOfHand() == 1 &&
                this.getSortedRankOfHand()[2] == this.getSortedRankOfHand()[3]){

            return 3;

        }else if(this.getRankDegreeOfHand() == 1 &&
                this.getSortedRankOfHand()[3] == this.getSortedRankOfHand()[4]){

            return 4;

        }else {
            return 0;
        }
    }

    private boolean isHighCard(){
        return !this.isFlush() && this.getRankDegreeOfHand() == 0;
    }
}
