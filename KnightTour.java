/* THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES.
Jacob Choi */

import java.util.Stack;

// Do you know the chess piece that looks like a horse? It's called a "Knight",
// and the "Knight's Tour" is a famous problem where you want the Knight to move
// around a chess board such that it visits every position on the board exactly once.
// Recall that the Knight can move in the shape of the letter "L" in any direction
// IMPORTANT: See our A2 handout for examples and more detailed instructions/hints!

public class KnightTour {

    // NOTE: There can be several distinct valid tours; your job is to find
    // and print only one valid tour (the first valid one you discover).
    // Please do NOT attempt to discover all possible valid tours! To get
    // a sense of how many valid board configurations exist for different
    // board sizes, see "The Knight's Paths" table here:
    // http://www.behnel.de/knight.html

    /** tour method is where you add your code for implementing
    * a Knight Tour's solution for an n*n chess board
    * @param n size of the board
    * @return KnightBoard object with a valid Knight Tour
    */
    public static KnightBoard tour(int n){
      // Your solution must utilize the stack "candidates" below,
      // to keep track of different possible sequences of Knight moves
      Stack<KnightBoard> candidates = new Stack<KnightBoard>();
      KnightBoard kb = new KnightBoard(n); // create initial board of size n*n
      candidates.push(kb); // push the initial board onto the stack

      while(!candidates.empty()){
        //backtracking
        kb = candidates.pop(); 
        //conditions for winning
        if(kb.getMoveCount() == n*n || (n <= 4 && kb.getMoveCount()==n*n-1)){
          return kb;
        }
        //checking all possible knight movement conditions
        else{
          KnightBoard Algo8 = kb.copyBoard();
          KnightBoard Algo7 = kb.copyBoard();
          KnightBoard Algo6 = kb.copyBoard();
          KnightBoard Algo5 = kb.copyBoard();
          KnightBoard Algo4 = kb.copyBoard();
          KnightBoard Algo3 = kb.copyBoard(); 
          KnightBoard Algo2 = kb.copyBoard();
          KnightBoard Algo1 = kb.copyBoard();

          if(Algo2.move(Algo2.getCurrentX()+1, Algo2.getCurrentY()+2)){
            candidates.push(Algo2);
          }
          if(Algo1.move(Algo1.getCurrentX()+2, Algo1.getCurrentY()+1)){
            candidates.push(Algo1);
          }
          if(Algo8.move(Algo8.getCurrentX()+2, Algo8.getCurrentY()-1)){
            candidates.push(Algo8);
          }
          if(Algo7.move(Algo7.getCurrentX()+1, Algo7.getCurrentY()-2)){
            candidates.push(Algo7);
          }
          if(Algo6.move(Algo6.getCurrentX()-1, Algo6.getCurrentY()-2)){
            candidates.push(Algo6);
          }
          if(Algo5.move(Algo5.getCurrentX()-2, Algo5.getCurrentY()-1)){
            candidates.push(Algo5);
          }
          if(Algo4.move(Algo4.getCurrentX()-2, Algo4.getCurrentY()+1)){
            candidates.push(Algo4);
          }
          if(Algo3.move(Algo3.getCurrentX()-1, Algo3.getCurrentY()+2)){
            candidates.push(Algo3);
          }
        }
      }
      return kb; //returns a KnightBoard object with a valid Knight Tour
    }
    // Do NOT modify this main method. If you need to add code for
    // testing your solution, just make sure to comment it out before submission
    public static void main(String[] args) {
      int n = 3;// default board size if user didn't specify
      // pass in parameter n from command line
      if (args.length == 1) {
        n = Integer.parseInt(args[0].trim());
        if (n < 3) {
          System.out.println("Incorrect parameter (n must be >= 3)");
          System.exit(-1);
        }
      }
      long startTime = System.nanoTime();
      KnightBoard winner = KnightTour.tour(n);
      long endTime = System.nanoTime();
      double delta = (endTime - startTime) / 1e6;
      // Display the solution you discovered:
      System.out.println("\nPossible Knight Tour with max #squares visited in this ("+n+"x" +n+") board:");
      winner.printChessBoard();
      System.out.println("\n(Time to find this solution = " + delta + " milliseconds)");
    }
}
