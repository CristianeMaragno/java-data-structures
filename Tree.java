import java.util.Scanner;

public class Tree {
  public static void main(String[] args){
    //Get expression
    String expression = getExpression();

    //Create tree
    TreeNode treeHead = mountTree(expression);

    //Print result em pré-ordem
    String preOrder = printPreOrder(treeHead);
    System.out.println(preOrder);
    //Print result em pós-ordem
    String postOrder = printPostOrder(treeHead);
    System.out.println(postOrder);
  }

  public static String getExpression(){
    Scanner scanner = new Scanner(System.in);
    String expression = scanner.nextLine(); 
    scanner.close();
    return expression;
  }

  public static TreeNode mountTree(String expression){
    String[] expressionArray = expression.split("");
    TreeNode newNode = new TreeNode();
    if(expressionArray.length == 1){
      newNode.setValue(expressionArray[0]);
      newNode.setLeft(null);
      newNode.setRight(null);
    }else{
      String operator = ""; 
      int index = 0;
      for(int i = (expressionArray.length - 1); i >= 0; i--){
        String term = expressionArray[i];
        if(term.equals("-") && !operator.equals("-")){
          operator = term;
          index = i;
        }
        if(term.equals("+") && !operator.equals("-") && !operator.equals("+")){
          operator = term;
          index = i;
        }
        if(term.equals("*") && !operator.equals("+") && !operator.equals("-") && !operator.equals("*")){
          operator = term;
          index = i;
        }
        if(term.equals("/") && !operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator.equals("/")){
          operator = term;
          index = i;
        }
      }
      newNode.setValue(operator);
      newNode.setLeft(mountTree(expression.substring(0, index)));
      newNode.setRight(mountTree(expression.substring(index + 1)));

    }
    return newNode;
  }

  public static String printPreOrder(TreeNode root){
    String result = (String) root.value;
    if(root.left != null){
      result += printPreOrder(root.left);
    }
    if(root.right != null){
      result += printPreOrder(root.right);
    } 

    return result;
  }

  public static String printPostOrder(TreeNode root){
    String result = "";
    if(root.left != null){
      result += printPostOrder(root.left);
    }
    if(root.right != null){
      result += printPostOrder(root.right);
    } 
    result += (String) root.value;

    return result;
  }
}

class TreeNode<E>{
  E value;

  TreeNode<E> left;

  TreeNode<E> right;

  TreeNode(){

  }

  TreeNode(E value){
    this.value = value;
  }
  
  TreeNode(E value, TreeNode<E> left, TreeNode<E> right){
    this.value = value;
    this.left = left;
    this.right = right;
  }

  public E getValue() {
    return value;
  }

  public void setValue(E value) {
    this.value = value;
  }

  public TreeNode<E> getLeft() {
    return left;
  }

  public void setLeft(TreeNode<E> left) {
    this.left = left;
  }

  public TreeNode<E> getRight() {
    return right;
  }

  public void setRight(TreeNode<E> right) {
    this.right = right;
  }
}