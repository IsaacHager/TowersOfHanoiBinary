/**
 * Driver class that solves a Towers Of Hanoi puzzle of any size.
 * Usage: TowersOfHanoiDriver <size>
 * Size must be be a positive integer
 * 
 * @param args
 */
public class TowersOfHanoiDriver {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: TowersOfHanoiDriver <size>\nSize must be a positive integer.");
        } else {
            try {
                int size = Integer.parseInt(args[0].trim());
                if (size <= 0) {
                    System.out.println("Usage: TowersOfHanoiDriver <size>\nSize must be a positive integer.");
                } else {
                    TowersOfHanoiBinary tower = new TowersOfHanoiBinary(size);
                    System.out.println("\nSolution --------------------------------");
                    tower.solve();
                    System.out.println("-----------------------------------------");
                }
            } catch (NumberFormatException e) {
                System.out.println("Usage: TowersOfHanoiDriver <size>\nSize must be a positive integer.");
            }
        }
    }
}
