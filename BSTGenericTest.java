package bst;
public class BSTGenericTest 
{
    public static void main (String [] args)
    {
        BSTGeneric<Integer> BSTint = new BSTGeneric<Integer>() ;
        BSTGeneric<String> BSTstring = new BSTGeneric<String>();
        BSTGeneric<Character> BSTchar = new BSTGeneric<Character>();

        Integer numberArray[] = {6, 2, 8, 1, 5, 3, 4};
        String stringArray[] =  {"a", "b", "c", "d", "e", "f", "g"};
        Character charArray[] = {'a', 'b', 'c', 'd', 'd', 'e', 'f'};


        // Integer BST
        System.out.print("\n----------" + "Integer BST" + "----------\n");
        for (Integer node: numberArray)
        {
            BSTint.insertVal(node);
        }

        // Testing the functions
        BSTint.insertVal(9);
        BSTint.searchVal(1);
        BSTint.deleteVal(2);

        // Printing the inorder traversals
        System.out.print("\n");
        System.out.printf("\n*********" + "In Order Traversal"+ "*********\n");
        System.out.print("Int inOrder: \n");
        BSTint.inOrder(BSTint.root);

        // String BST
       System.out.print("\n\n\n");
       System.out.print("\n----------" + "String BST" + "----------\n");
       for (String node: stringArray)
       {
           BSTstring.insertVal(node);
       }

       // Testing the functions
       BSTstring.insertVal("z");
       BSTstring.searchVal("a");
       BSTstring.deleteVal("b");

       // Printing the inorder traversals
       System.out.print("\n");
       System.out.printf("\n*********" + "In Order Traversal"+ "*********\n");
       System.out.print("String inOrder: \n");
       BSTstring.inOrder(BSTstring.root);

       // Character BST
       System.out.print("\n\n\n");
       System.out.print("\n----------" + "Character BST" + "----------\n");

       for (Character node: charArray)
       {
           BSTchar.insertVal(node);
       }

       // Testing the functions
       BSTchar.insertVal('h');
       BSTchar.searchVal('a');
       BSTchar.deleteVal('d');

       // Printing
       System.out.print("\n");
       System.out.printf("\n*********" + "In Order Traversal"+ "*********\n");
       System.out.print("Char inOrder: \n");
       BSTchar.inOrder(BSTchar.root);
       
    }
}
