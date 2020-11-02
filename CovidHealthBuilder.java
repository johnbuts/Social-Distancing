
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
* This class is pretty much where everything comes together, where we are actually creating the tree and doing the project implementation that isn't all setters and getters.
* 
* 
* 
*/
public class CovidHealthBuilder {
    /**
    *these are our current instance field variables.
    *
    *
    *@value counter this is our counter used for keeping track of index
    *@value list this is our list that is made from split(), by spltting our file
    *@value tree this is our binary tree that is made from build tree an our list of strings
    *@value ans this is the string we get in decide, and we need to keep this stored so we can use it in learn 
    */

    private int counter;
    /**
    *these are our current instance field variables.
    *
    *
    */
    private ArrayList<String> list;
    /**
    *these are our current instance field variables.
    *
    *
    */
    private BinaryNode<String> tree;
    /**
    *these are our current instance field variables.
    *
    *
    */
    private String ans;
    
   
   
   
    /**
    *this method is our constructor, and makes our tree based on the file.
    *
    *@param fileName this is the file that we are using to determine our pathway  
    *@throws FileNotFoundException this is something w need to throw if we have a file type variable      
    */ 
    public CovidHealthBuilder(String fileName) throws FileNotFoundException{
        File input = new File(fileName);
        String str = "";
        Scanner scan = new Scanner(input);
        while(scan.hasNextLine()) {
            str = str.concat(scan.nextLine() + "\n");
        }
        BinaryNode storage = new BinaryNode();
        readData(str); //makes our list
        BinaryNode<String> n = new BinaryNode<String>(list.get(0));
        tree = buildTree(n, 0);
      
      
      
   
    }
    /**
    *We want to turn this file string into a list so we can iterate through it.
    *
    *@param s this is our string of the txt file that we want to turn into a list 
    *@return list , this is the list that we are returning of the string that is made from the text file
    *      
    */
    public ArrayList<String> readData(String s) {   
        String replace = s.replaceAll("\n",",");
        String[] data = replace.split(",");
        list = new ArrayList<String>();
        Collections.addAll(list, data);
      
        return list;
      
    }
    /**
    *this is what we use for creating our tree, and we use recursion to create it, and you can look at the implmentation details.
    *
    *
    *@param root this is the param we need for recursion because we need to give this root node children then it's children children, then so forth
    *@param index this is the index we are using for our list, the pattern goes index * 2 + 1 for the left child and index * 2 + 2 for the right child 
    *@return this returns the node that is equal to a tree with all of the values we need         
    */
    
    public BinaryNode<String> buildTree(BinaryNode<String> root, int index) {
        if((index * 2 + 2) < list.size()) {
            root = new BinaryNode<String>(list.get(index));
            BinaryNode<String> left = new BinaryNode<String>(list.get(index * 2 + 1));
            BinaryNode<String> right = new BinaryNode<String>(list.get(index * 2 + 2));
            root.setLeftChild(buildTree(left, index * 2 + 1));
            root.setRightChild(buildTree(right, index * 2 + 2));
         
         
      
        }
      
        return root;
      
   
    }
   
    /**
    *We use this to iterate through our tree, so whenever we get a yes response we go to our right, and no response we go to our left.
    *And if we are out of bounds or the index is out of bounds, we go to our learn method.
    *
    *
    *         
    */
   
    public void decide() {
      
        Scanner question = new Scanner(System.in);  // Create a Scanner object
        counter = 0;
        while(true) {
         
        
            if(tree.getRightChild().getData().equals("null") && 
                tree.getLeftChild().getData().equals("null") ) {
                System.out.println(tree.getData());
                System.out.println("Satisfied by my intelligence ?");
                ans = question.nextLine();
                learn();
                break;
         
            }
         
            System.out.println(tree.getData());
            String input = question.nextLine();
         
            if(input.equals("yes")) {
                tree = tree.getRightChild();
                counter = counter * 2 + 2;
         
            }
         
            if(input.equals("no")) {
                tree = tree.getLeftChild();
                counter = counter * 2 + 1;
         
            }
         
         
      
        }
   
   
    }
   
   
    /**
    *For this method, we call it when we are at the end of the tree, and what we do is we ask our person if they are.
    *are satisfied, if they are then we end, if they aren't then we ask them for a replacement question and an answer for yes.
    *once we do that we replace our last question and the yes option from null to the one that they inputted, at the end of the method.
    *we need to point the node to the top of the node, so we reconstruct it with the new values.
    *
    *
    *         
    */
   
    public void learn() {
        Scanner asker = new Scanner(System.in);
        if(ans.equals("no")) {
            System.out.println("What should be the answer ?");
            String replace = asker.nextLine();
            System.out.println("Give me a question whose answer is yes for " +
                replace + " but no for " + tree.getData());
         
            String ques = asker.nextLine();
            list.set(counter, ques);
            list.set(counter * 2 + 2, replace);
            BinaryNode<String> n = new BinaryNode<String>(list.get(0));
            tree = buildTree(n, 0);
         
        }
      
   
    }
   
    /**
    *This is used for creating a new node, I didn't want to use this because by the time I was done with learn() I realized I could've used this.
    *
    *
    *
    *@param question and this is our new node with right and left child data being yes and no answer
    *@param yesAnswer this would be the data for the right child
    *@param noAnswer  this is the data for the left child
    */
   
    public void updateTree(String question, String noAnswer, String yesAnswer) {
        BinaryNode<String> l = new BinaryNode<String>(noAnswer);
        BinaryNode<String> r = new BinaryNode<String>(yesAnswer);
        BinaryNode<String> n = new BinaryNode<String>(question, l, r);
   
   
   
    }
   







}