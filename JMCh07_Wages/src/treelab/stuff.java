package treelab;
import java.util.Stack;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeSet;

public class stuff<E>
{
    private TreeNode<E> root;
    
    public stuff()
    {
        root = null;
    }

    
    public int findMax(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        else
        {
            if (root.getRight() == null)
            {
                return (int)root.getValue();
            }
            else
            {
                return findMax(root.getRight());
            }
        }
    }
    
    public static void main(String args[])
    {
        TreeNode doge = new TreeNode();
    }
}