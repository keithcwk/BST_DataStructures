package bst;
import java.util.*;
public class BSTGenericDebugTest
{
    public static void main (String [] args)
    {
        BSTGenericDebug<Integer> BSTint = new BSTGenericDebug<Integer>() ;
        BSTGenericDebug<String> BSTstring = new BSTGenericDebug<String>();
        BSTGenericDebug<Character> BSTchar = new BSTGenericDebug<Character>();

        Integer numberArray[] = {6, 2, 8, 1, 5, 3, 4};
        String stringArray[] =  {"a", "b", "c", "d", "e", "f", "g"};
        Character charArray[] = {'a', 'b', 'c', 'd', 'd', 'e', 'f'};


        // Integer BST
        System.out.print("\n----------" + "Integer BST" + "----------\n");
        for (Integer node: numberArray)
        {
            BSTint.insertVal(node);
        }

        System.out.printf("\n*********" + "insertVal function breakdown "+ "*********\n");
        BSTint.insertVal(9);

        System.out.printf("\n*********" + "deleteVal breakdown "+ "*********\n");
        BSTint.deleteVal(2);

        System.out.printf("\n*********" + "searchVal function breakdown "+ "*********\n");
        BSTint.searchVal(3);

        System.out.printf("\n*********" + "In Order Traversal breakdown "+ "*********\n");
        BSTint.inOrder(BSTint.root);
        System.out.print("Int inOrder: \n");
        BSTint.cleanInOrder(BSTint.root);


    //     // String BST
    //    System.out.print("\n\n\n");
    //    System.out.print("\n----------" + "String BST" + "----------\n");
    //    for (String node: stringArray)
    //    {
    //        BSTstring.insertVal(node);
    //    }

    //    System.out.printf("\n*********" + "insertVal function breakdown "+ "*********\n");
    //    BSTstring.insertVal("h");

    //    System.out.printf("\n*********" + "deleteVal breakdown "+ "*********\n");
    //    BSTstring.deleteVal("c");

    //    System.out.printf("\n*********" + "searchVal function breakdown "+ "*********\n");
    //    BSTstring.searchVal(d);

    //    System.out.printf("*********" + "In Order Traversal breakdown "+ "*********\n");
    //    BSTstring.inOrder(BSTstring.root);
    //    System.out.print("String inOrder: \n");
    //    BSTstring.cleanInOrder(BSTstring.root);

    //     // Char BST
    //    System.out.print("\n\n\n");
    //    System.out.print("\n----------" + "Character BST" + "----------\n");

    //    for (Character node: charArray)
    //    {
    //        BSTchar.insertVal(node);
    //    }

    //    System.out.printf("\n*********" + "insertVal function breakdown "+ "*********\n");
    //    BSTstring.insertVal('z');

    //    System.out.printf("\n*********" + "deleteVal breakdown "+ "*********\n");
    //    BSTstring.deleteVal('c');

    //    System.out.printf("\n*********" + "searchVal function breakdown "+ "*********\n");
    //    BSTchar.searchVal('d');

    //    System.out.printf("*********" + "In Order Traversal breakdown "+ "*********\n");
    //    BSTchar.inOrder(BSTchar.root);
    //    System.out.print("Char inOrder: \n");
    //    BSTchar.cleanInOrder(BSTchar.root);
    }
}