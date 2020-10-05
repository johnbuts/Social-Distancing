import java.util.*; 
public class Block{
   private ArrayList<Cell []> grid = new ArrayList<Cell []>();
   private Cell[][] normal;
   private int currentCol = -1;
   private int currentRow = -1;
   private int startRow = -1;
   private int startCol = -1;

   public Block(Cell[][] g) {
      normal = g;
      Collections.addAll(grid, g);//making an equal arrayList in case it comes in handy
      
   
   }  
     
   public Cell[][] getGrid() { 
      return normal;}//simple getter
   
   public void setGrid(Cell[][] norm){ normal = norm;}//simple setter
   
   public boolean isValid(int row, int col){
      if ((row < normal.length) && (col < normal[0].length) && (col >= 0) && (row >= 0)) //checks if its in the bounds
         return true; 
      return false;
   
   }
   
   public int getStatus(int row, int col) {
      if ((row < normal.length) && (col < normal[0].length) && (col >= 0) && (row >= 0)) //checks if in bounds
         return normal[row][col].getStatus(); //returns if its 1 or 0
      return -1;// returns -1 if its not in bounds
      
   }
   
   public boolean isVisited(int row, int col) {
      if ((row < normal.length) && (col < normal[0].length) && (col >= 0) && (row >= 0))
         return normal[row][col].getVisited(); //returns if its t or f
      return false;// returns f if its not in bounds
      
   }
   public boolean isEntry(int row, int col) { 
      if ((row < normal.length) && (col < normal[0].length) && (col >= 0) && (row >= 0)) {
         if (normal[row][col].getStatus() == 0) {
            return (col == 0);
         }
      }
         
      return false; //if the col is on the left
      
      
   }
   
   public boolean isExit(int row, int col) { 
      
      if (normal[row].length - 1 == col && normal[row][col].getStatus() == 0 ) 
         return true; //if its on the final right hand column
      return false;
   }
   // simple getters and setters
   public int getCurrentRow() {
      return currentRow;}
   public int getCurrentCol() {
      return currentCol;}
   public void setCurrentRow(int row) {currentRow = row;}
   public void setCurrentCol(int col){currentCol = col;}
   
   public boolean isFree(int row, int col) {
      if ((row < normal.length) && (col < normal[0].length) && (col >= 0) && (row >= 0))
         return normal[row][col].getStatus() == 0;//if its marked or not
      return false;  
   }
   
   //simple setters and getters
   public void setStart(int row, int col) { 
      
      if ((row < normal.length) && (col < normal[0].length) && (col >= 0) && (row >= 0)) {
         if(normal[row][col].getStatus() == 0) {
            if(col == 0){
               startRow = row;
               startCol = 0;
               currentRow = row;
               currentCol = 0;
            }
         }
      }
   }
   public int getStartCol(){ 
      return startCol; }
   public int getStartRow(){ 
      return startRow; }
   public void setStartCol(int s){ startCol = s; }
   public void setStartRow(int s){ startRow = s; }
   
   public void moveLeft() { 
      normal[currentRow][currentCol].setVisited(true); //sets the val to true
      if ((currentCol - 1 < normal[0].length) && (currentCol - 1 >= 0)){ //checks if its in the grid
         if(normal[currentRow][currentCol-1].getVisited() == false) { //checks if the spot you're moving to hasnt been visited before
            if(normal[currentRow][currentCol-1].getStatus() == 0) { //checks that th spot is not marked and is clear
               currentCol -= 1; //actually moves the thing to the left
            }
         }
      }
   }
   public void moveRight() { 
      normal[currentRow][currentCol].setVisited(true);
      if ((currentCol + 1 < normal[0].length) && (currentCol + 1 >= 0)){
         if(normal[currentRow][currentCol+1].getVisited() == false) {
            if(normal[currentRow][currentCol+1].getStatus() == 0) {
               currentCol += 1;
            }
         }
      }
   }
   public void moveUp() { 
      normal[currentRow][currentCol].setVisited(true);
      if ((currentRow - 1 < normal.length) && (currentRow - 1 >= 0)){
         if(normal[currentRow - 1][currentCol].getVisited() == false) {
            if(normal[currentRow - 1][currentCol].getStatus() == 0) {
               currentRow -= 1;
            }
         }
      }
   }
   
   public void moveDown() { 
      normal[currentRow][currentCol].setVisited(true);
      if ((currentRow + 1 < normal.length) && (currentRow + 1 >= 0)){
         if(normal[currentRow + 1][currentCol].getVisited() == false) {
            if(normal[currentRow + 1][currentCol].getStatus() == 0) {
               currentRow += 1;
            }
         }
      }
   }
}


   
   
   
   
   
   
   
   
   
   


   
   
   
   


