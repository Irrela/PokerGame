public class PokerCard {

    public enum Rank {

        TWO("12", "2"),
        THREE("13", "3"),
        FOUR("14", "4"),
        FIVE("15", "5"),
        SIX("16", "6"),
        SEVEN("17", "7"),
        EIGHT("18", "8"),
        NINE("19", "9"),
        TEN("20", "10"),
        JACK("21", "Jack"),
        QUEEN("22", "Queen"),
        KING("23", "King"),
        ACE("24", "Ace"),
        INIT("11", "INIT");

        //This rankWeight is for building comparing string in Player class.
        private String rankWeight;
        /*
        This rankName is for getting accurate description,
        because project expects a output like "Ace-high flush" rather than "ACE-high flush".
         */
        private String rankName;


        Rank(String p, String d) {
            rankWeight = p;
            rankName = d;
        }

        public String getRankWeight() {
            return rankWeight;
        }

        public String getRankName() {
            return rankName;
        }
    }

    enum Suit {Club, Heart, Diamond, Spade}

    private Rank rank;
    private Suit suit;

    public PokerCard(){}

    /**
     * This constructor creates PokerCards instance with args[] elements
     * for example, the input is '7c', then create an PokerCard instance
     * with rank = SEVEN, suit = CLUB.
     * 
     * And if the inputs were invalid,it will throw corresponding exceptions.
     * 
     */
    public PokerCard(String inputArgs) throws Exception {

        switch (inputArgs.charAt(0)) {
            case '2':
                this.rank = Rank.TWO;
                break;
            case '3':
                this.rank = Rank.THREE;
                break;
            case '4':
                this.rank = Rank.FOUR;
                break;
            case '5':
                this.rank = Rank.FIVE;
                break;
            case '6':
                this.rank = Rank.SIX;
                break;
            case '7':
                this.rank = Rank.SEVEN;
                break;
            case '8':
                this.rank = Rank.EIGHT;
                break;
            case '9':
                this.rank = Rank.NINE;
                break;
            case 'T':
                this.rank = Rank.TEN;
                break;
            case 'J':
                this.rank = Rank.JACK;
                break;
            case 'Q':
                this.rank = Rank.QUEEN;
                break;
            case 'K':
                this.rank = Rank.KING;
                break;
            case 'A':
                this.rank = Rank.ACE;
                break;
            default:
                throw new Exception("no match rank");

        }

        switch (inputArgs.charAt(1)) {
            case 'C':
                this.suit = Suit.Club;
                break;
            case 'H':
                this.suit = Suit.Heart;
                break;
            case 'D':
                this.suit = Suit.Diamond;
                break;
            case 'S':
                this.suit = Suit.Spade;
                break;
            default:
                throw new Exception("no matched suit");
        }
    }

    public Rank getRank(){
        return rank;
    }

    public Suit getSuit(){
        return suit;
    }
}

