/**
 *this is our general node class that we use in our trees.
*
*
*@param <T> this is our variable
 */

public class BinaryNode<T> {
    /**
    *these are our current instance field variables.
    *
    *
    *@value counter this is what we are using to count the number of nodes
    *@value copied this is what we are copying our values to in copy()
    *@value leftChild this is the left child of the node
    *@value rightChild this is the right child of the node
    *@value data this will be our data for this tree, probably won't be used but ti's nice to have incase we want somehting like a name for the tree
    */
    private T data;
    /**
    *these are our current instance field variables.
    *
    *
    */
    private BinaryNode<T> leftChild = null;
    /**
    *these are our current instance field variables.
    *
    *
    */
    private BinaryNode<T> rightChild = null;
    /**
    *these are our current instance field variables.
    *
    *
    */
    private BinaryNode<T> copied = null;
    /**
    *these are our current instance field variables.
    *
    *
    */
    
    private int counter;
   
    /**
    *This is our default constructor that puts all of our values to null.
    *
    *
    *
    */
    public BinaryNode() {
        data = null; leftChild = null; rightChild = null;
    }
    /**
    *This is our single paramaterized constructor that puts all of our values to null except for data.
    *
    *
    *@param data this is the data we use for this class, just a constructor
    */
    public BinaryNode(T data) {
        this.data = data; leftChild = null; rightChild = null;
    }
    /**
    *This is our paramaterized constructor that puts all of our values equal to something.
    *
    *
    *@param rightChild this is what we want our rightChild to be
    *@param leftChild this is what we want our leftChild to be
    *@param data this is the data we use for this class, just a constructor
    */
    public BinaryNode(T data, BinaryNode<T> leftChild, BinaryNode<T> rightChild) {
        this.data = data; this.leftChild = leftChild; this.rightChild = rightChild;
    }
   
   
    /**
    *This is simple setter.
    *
    *
    *@param date this is just the data we want to set our current data to
    */
    public void setData(T date) {
      
        data = (T)date;
    }
    /**
    *This is simple getter.
    *
    *
    *@return data this is the data we are returning
    */
   
    public T getData() {
        return data;
    }
    /**
    *This is simple getter.
    *
    *
    *@return the left child of this node
    */
   
    public BinaryNode<T> getLeftChild() {
        return leftChild;
    }
    /**
    *This is simple setter.
    *
    *
    *@param kid this is what we want our left child to be
    */
   
    public void setLeftChild(BinaryNode<T> kid) {
        leftChild = kid;
    }
    /**
    *This is simple getter.
    *
    *
    *@return the right child of this node
    */
    public BinaryNode<T> getRightChild() {
        return rightChild;
    }
    /**
    *This is simple setter.
    *
    *
    *@param kid this is what we want our right child to be
    */
    public void setRightChild(BinaryNode<T> kid) {
        rightChild = kid;
    }
    /**
    *This is a simple checker.
    *
    *
    *@return whether or not the left child exists
    */
    public boolean hasLeftChild() {
        return leftChild != null;
    }
    /**
    *This is a simple checker.
    *
    *
    *@return whether or not the right child exists
    */
    public boolean hasRightChild() {
        return rightChild != null;
    }
    /**
    *This is a simple checker.
    *
    *
    *@return whether or not the left and right child exists
    */
    public boolean isLeaf() {
        return (leftChild == null && rightChild == null);
    }
    /**
    *This is something that the project outlined to have no param or return value, so I had to make my own method to get the height.
    *
    *
    *@return the height from the current nodes position
    */
    public int getHeight() {
        return height(leftChild) + height(rightChild);
    }
   
    /**
    *This is uses recursion to get the trees height.
    *
    *@param n the node of which we want the height from
    *@return the height of the tree
    
    */
    public int height(BinaryNode<T> n) { //where we are actually getting the height
        if(n == null) {
            return 0;
        }
        else {
            int right = height(n.getRightChild());
            int left = height(n.getLeftChild());
            if(right > left) {
                return right + 1;
            }
         
            else {
                return left + 1;
            }
      
        }
   
   
   
    }
    /**
    *This is something that the project outlined to have no param or return value, so I had to make my own method to get the height.
    *
    *
    *@return the number of nodes
    */
    public int getNumberOfNodes() {
        int right = getNum(rightChild);
        counter = 0;
        int left = getNum(leftChild);
        return right + left;
   
    }
    /**
    *This is uses recursion to get the number of nodes.
    *
    *@param n node at which we want to see how many it's connected to
    *@return the number of nodes
    
    */
    public int getNum(BinaryNode<T> n) {
        if(n == null) return 0;
        counter += 1;
        getNum(n.getRightChild());
        getNum(n.getLeftChild());
        return counter;
      
      
    }
  
    /**
    *This is making a copy of our node.
    *
    *
    *@return the same node but stored in a diffferent place
    *
    */
    public BinaryNode<T> copy() {
     
        BinaryNode<T> right = rightChild;
        BinaryNode<T> left = leftChild;
        T date = data;
        copied.setRightChild(right);
        copied.setLeftChild(left);
        copied.setData(date);
        return copied;
   
    }
   
   
   


}