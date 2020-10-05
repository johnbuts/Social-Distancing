public class Cell {
   private int status;
   private boolean visited;
   //constructors
   public Cell(int status, boolean visited) {
      this.status = status;
      this.visited = visited; 
   
   }
   
   public Cell(int status) {
      visited = false;
      this.status = status;
   
   }
   //getters and setters for the cells in the grid
   public int getStatus() {
      return status;
   }
   public boolean getVisited() {
      return visited;
   }
   public void setStatus(int v) {
      status = v;
   }
   public void setVisited(boolean v) {
      visited = v;
   }
   
   
   
   
}

