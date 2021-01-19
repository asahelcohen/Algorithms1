package Alice_Bob;

/**
 * bob and alice are both placed in different rooms.
 * each flips a coin. in order to win either bob needs to guess what alice flipped, or alice guess what bob flipped.
 * solution: bob always guesses the same as he got. alice always guesses the opposite of what she got.
 * result: 100% success.
 */
public class alice_bob {
    public static void main(String[] args) {
        int count = 0;
        int bob_decision=0;

        for (int i = 0; i < 6; i++) {
            int alice = (int) (Math.random() * 2);
            int bob = (int) (Math.random() * 2);

            if (bob == 1)
                bob_decision = 0;
            else if (bob == 0)
                bob_decision = 1;
            if (alice == bob || alice == bob_decision)
                count++;
        }
        System.out.println(count);
    }
}
