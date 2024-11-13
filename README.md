OVERVIEW:

 Provides a solution for a Towers of Hanoi puzzle of a given size. 


INCLUDED FILES:

 * TowersOfHanoiBinary.java - source file
 * TowersOfHanoiDriver.java - source file
 * README - this file


COMPILING AND RUNNING:

 From the directory containing all source files, compile the
 driver class (and all dependencies) with the command:
 $ javac TowersOfHanoiDriver.java

 Run the compiled class file with the command:
 $ java TowersOfHanoiDriver \<size\>

 Console output will give the results after the program finishes.


PROGRAM DESIGN AND IMPORTANT CONCEPTS:

 This program uses a binary counting algorithm to efficiently
 solve the Towers Of Hanoi puzzle. It generates the minimum number
 of moves required to solve a puzzle of a given size (2^size).

 Any Towers Of Hanoi puzzle can be solved by counting in binary and
 associating each disc with a binary place value. Each move involves
 incrementing the binary number, observing which bit rolled over, and
 moving the corresponding disc to the next available location (left
 assuming an odd number of discs, otherwise right)

 eg: In a game with 4 discs, use a 4-bit number(0000). 
 For the first move, increment the number(0001), and note that the 
 first bit rolled over, so move disc 1 to the next available peg. 
 For the next move, increment the number(0010), and note that the
 second bit rolled over, so move disc 2 to the next available peg.
 etc.

 This "rolled-over bit" is known as the Least Significant Bit, and is
 found by the private findLSB() method in the TowersOfHanoiBinary.java
 class.

 The private canMove() method in the TowersOfHanoiBinary.java class
 is used to determine if a move is valid, and is currently order O(n).
 It is possible for this method to be order O(1) with the addition of
 variables that track the discs on each peg. I chose not to implement
 this method because it would require tracking many more variables and
 an additional memory slot for each disc. This would not be much more
 efficient than simply checking the location of all smaller discs. which
 is what the program currently does.

TESTING:

 This program was tested with the following invalid command line arguments:
 -1;
 0;
 a;
 \<nothing\>
 and the following valid command line arguments:
 1;
 2;
 3;
 4;
 5;
 10 (Note: the solution for this one was not tested, as it was over 1000 moves long)
