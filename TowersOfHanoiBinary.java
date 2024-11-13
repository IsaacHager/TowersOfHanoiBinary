/**
 * An iterative approach to solving the Towers of Hanoi puzzle using binary counting.
 * 
 * @author isaachager
 */
public class TowersOfHanoiBinary {
    private int size;
    private int direction;
    private int[] discs;

    /**
     * Initializes a tower solver with a given size (must be positive)
     * @param size number of discs
     */
    public TowersOfHanoiBinary(int size) {
        if (size <= 0) {
            throw new IndexOutOfBoundsException();
        }
        this.size = size;
        discs = new int[size];
        direction = (size % 2 == 0) ? 1 : -1;
    }

    /**
     * Basic constructor that initializes a tower with size 3
     */
    public TowersOfHanoiBinary() {
        this(3);
    }

    /**
     * Outputs the moves necessary to solve the tower
     */
    public void solve() {
        for (int i = 1; i < Math.pow(2, size); i++) {
            int discToMove = findLSB(i);
            int toPeg = Math.floorMod(discs[discToMove] + direction, 3);
            if (!canMove(discToMove, toPeg)) {
                toPeg = Math.floorMod(toPeg + direction, 3);
            }
            System.out.println("Move disc " + discToMove +  " from peg " + discs[discToMove] + " to peg " + toPeg);
            discs[discToMove] = toPeg;
        }
    }

    /**
     * Finds the Least Significant Bit in the given number
     * @param n number
     * @return Least Significant Bit
     */
    public static int findLSB(int n) {
        return (int)(Math.log(n & -n) / Math.log(2));
    }

    /**
     * Checks if the given move is valid
     * 
     * @param disc index of the disc to move
     * @param peg peg to move to
     * @return true if valid
     */
    private boolean canMove(int disc, int peg) { // TODO: This could be constant time if I track more variables
        if (disc > size - 1 || disc < 0 || peg > 2 || peg < 0) {
            throw new IndexOutOfBoundsException();
        }
        boolean valid = true;
        if (disc != 0) {
            int index = disc - 1;
            while(valid && index >= 0) {
                if (discs[index] == peg) {
                    valid = false;
                }
                index--;
            }
        }
        return valid;
    }
}