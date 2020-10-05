import java.util.*; 
public class Propagation{
   private static Stack<ArrayList<Integer>> rval = new Stack<ArrayList<Integer>>();
    private static Stack<ArrayList<Integer>> storage = new Stack<ArrayList<Integer>>();
   public static boolean isEffective(Block area, int startRow, int startCol) {
      
      Cell[][] grid = area.getGrid();
   
      grid[startRow][startCol].setVisited(true);
      area.setGrid(grid);
      ArrayList<Integer> coords = new ArrayList<Integer>();
      coords.add(startRow);
      coords.add(startCol);
      rval.add(coords);
      
      if (startCol == grid[startRow].length - 1 ) { //base case
         return false;
      } 
      if (startCol + 1 <= grid[startRow].length - 1) {// right
         if (grid[startRow][startCol+1].getStatus() == 0 && !(grid[startRow][startCol+1].getVisited())) {
            boolean n = isEffective(area, startRow, startCol + 1);
            if(n == false) 
               return false;
         }//actual check
      }//if right is in bounds
      if (startRow + 1 <= grid.length - 1) {// up
         if (grid[startRow+1][startCol].getStatus() == 0 && !(grid[startRow+1][startCol].getVisited())) {
            boolean n = isEffective(area, startRow + 1, startCol);
            if(n == false) 
               return false;
         }//actual check
      }//if up is in bounds
      if ( (startRow - 1 >= 0)) {// down
         if (grid[startRow-1][startCol].getStatus() == 0 && !(grid[startRow-1][startCol].getVisited()) ) {
            boolean n = isEffective(area, startRow - 1, startCol);
            if(n == false) 
               return false;
         }//actual check
      }//if down is in bounds
             
      if ( startCol - 1 >= 0) {// left
         if (grid[startRow][startCol-1].getStatus() == 0 && !(grid[startRow][startCol-1].getVisited()) ) {
            boolean n = isEffective(area, startRow, startCol - 1);
            if(n == false) 
               return false;
         }
      }
      return true;
   }
            
   public static Stack<ArrayList<Integer>> pathCalc(Block area, int startRow, int startCol){
      boolean n = Propagation.isEffective(area, startRow, startCol);
      if (n) 
         return null; //if there is no path
      return rval;
      
      
           
           
   }
}
      

   
   
   




