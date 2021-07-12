package bst;
import java.util.*;
public class BSTDebug <T>
{
    // Initialization
    public class Node
    {
        // Each node has a key, left and right branch
        int key;
        Node left;
        Node right;

        // Node constructor
        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // Initializing root node object
    Node root ;

    // Constructor to create a bst.
    // The initial key value of the root is null
    BSTDebug()
    {
        root = null;
    }

    // Recursive insertion
    Node recursiveInsert(Node currentNode, int val)
    {
        System.out.print("\nRecursive insert function is called...\n");
        System.out.printf("Inserted value: %d\n", val);
        if (currentNode != null)
        {
            System.out.printf("Current Node: %d\n", currentNode.key);
        }

        else
            System.out.print("Current Node: null\n");

    /*
        When inserting there are mainly 3 scenarios:
        a) The node is empty
        b) The value to be inserted is lesser than the key of the node
        c) The value to be inserted is more than the key of the node
        d) The value to be inserted is equal to the key of the node
    */

        // Condition a)
        if (currentNode == null)
        {
            System.out.print("Node is empty\n");
            System.out.print("New node is created\n");
            currentNode = new Node(val);
            return currentNode;
        }

        // Condition b)
        if (val < currentNode.key)
        {
            System.out.print(val+" is less than "+currentNode.key+"\n");
            currentNode.left = recursiveInsert(currentNode.left, val);
        }

        // Condition c
        else if (val > currentNode.key)
        {
            System.out.print(val+" is more than "+currentNode.key+"\n");
            currentNode.right = recursiveInsert(currentNode.right, val);
        }

        // Condition d)
        else if (val == currentNode.key)
        {
            // Returns the current node state
            System.out.print(val+" is equal to "+currentNode.key+"\n");
            return currentNode;
        }

        return currentNode;
    }

    // Recursive delete
    /*
        Before deleting, searching has to be carried out
        to look for the node to be deleted

        After searching for the node, deletion can occur

        During deletion, there are 3 cases:
        a) The deleted node does not have any child
        b) The deleted node has one child
        c) The deleted node has two chiild
    */
    Node recursiveDelete(Node currentNode, int val)
    {
        System.out.print("\nRecursive delete function is called...\n");
        System.out.printf("Deleted value: %d\n", val);
        if (currentNode != null)
        {
            System.out.printf("Current Node: %d\n", currentNode.key);
        }

        else
            System.out.print("Current Node: null\n");

        // Searching is carried out first

        // If the node is not found
        if (currentNode == null)
        {
            System.out.print("Current node is null\n");
            return null;
        }

        // Node to delete is found
        if (currentNode.key == val)
        {
            System.out.print("Node to delete is found\n\n");
            // Condition a)
            if (currentNode.left == null &&
                currentNode.right == null)
            {
                System.out.print("Left and right subtree are null\n");
                System.out.printf("Deleting the node...\n");
                return null;
            }

            // Condition b)i) No left child
            else if (currentNode.left == null)
            {
                System.out.print("Node has no left child\n");
                return currentNode.right;
            }

            // Condition b)ii) No right child
            else if (currentNode.right == null)
            {
                System.out.print("Node has no right child\n");
                return currentNode.left;
            }

            //Condition c)
            // Looking for the minimum value in the right
            // subtree
            System.out.print("Node has two child\n");
            System.out.print("Looking for minimum value...\n");
            int minValue = findMinVal(currentNode.right);
            System.out.printf("Minimum value: %d\n", minValue,"\n");

            // Replacing the current node's key with the min value
            System.out.printf("Replacing the deleted node %d with copied minimum value %d...\n", val, minValue);
            currentNode.key = minValue;

            // Deleting the minimum value of the right subtree
            // since it has already replaced the currentNode
            System.out.printf("Deleting the minimum value...\n");
            currentNode.right = recursiveDelete(currentNode.right, minValue);
            return currentNode;
        }

        // Returns the right sub tree if val > node's key
        if (currentNode.key < val)
        {
            System.out.printf("Deleting the minimum value...\n");
            if (currentNode.right != null)
            {
                System.out.printf("Going to right child %d\n", currentNode.right.key);
            }
            currentNode.right = recursiveDelete(currentNode.right, val);
            return currentNode;
        }

        // Returns the left sub tree if val < node's key
        System.out.printf("The node %d is more than %d\n", currentNode.key, val);
        if (currentNode.left != null)
        {
            System.out.printf("Going to left child %d\n", currentNode.left.key);
        }
        currentNode.left = recursiveDelete(currentNode.left, val);
        return currentNode;
    }

        // findMinVal
    /*
        This function is used to search for the minimum value
        in the right subtree

        This is used during the deletion method, where the node
        has two children
    */
    int findMinVal(Node rightLargest)
    {
        if (rightLargest.left == null)
        {
            return rightLargest.key;
        }

        else
        {
            return findMinVal(rightLargest.left);
        }
    }

    // Recursive search
    /*
        Takes the root as a parameter and searches from the root
        node to the target node
    */
    Node recursiveSearch(Node root, int target)
    {
        System.out.print("\n\nRecursive search function is called...\n");
        System.out.printf("Searched value: %d\n", target);
        if (root != null)
        {
            System.out.printf("Current node: %d\n", root.key);
        }
        else
            System.out.print("Current Node: null\n");

        if (root == null)
        {
            System.out.print("Root is null\n");
            return root;
        }

        if (root.key == target)
        {
            System.out.print("The target is found!\n");
            return root;
        }

        // Returns right node if target > key
        if (root.key < target)
        {
            System.out.printf("The node %d is less than %d\n", root.key, target);
            if (root.right != null)
            {
                System.out.printf("Going to right child %d\n", root.right.key);
            }
            return recursiveSearch(root.right, target);
        }

        // Returns left node if target < key
        else
        {
            System.out.printf("The node %d is more than %d\n", root.key, target);
            if (root.left != null)
            {
                System.out.printf("Going to left child %d\n", root.left.key);
            }
            return recursiveSearch(root.left, target);
        }

        // null value will be returned if the value is not found
        // thus, there is no need to write an else statement for it
    }

    // Traversal of int tree
    void inOrderInt(Node root)
    {
        if (root != null)
        {
            inOrderInt(root.left);
            System.out.print(" "+ root.key);
            inOrderInt(root.right);
        }
    }

    // Insert method
    /*
        Takes in the value to be inserted and passes it to the
        recursiveInsert method
    */
    void insertVal(int val)
    {
        // The return type of the function is a root, so the method
        // can be assigned to root
        root = recursiveInsert(root, val);
    }

    // Deletion method
    void deleteVal(int val)
    {
        // To check whether the val to be deleted is in tree
        Node preDel = recursiveSearch(root, val);

        // To call the recursiveDelete method
        root = recursiveDelete(root, val);

        // To check if the number is deleted
        Node postDel = recursiveSearch(root, val);

        // If the number is in the tree and has been deleted
        if (preDel != null && postDel == null)
        {
            System.out.printf("\nThe node "+ val + " was present"
            +" in the tree and has been deleted\n");
        }

        // // Number is not in the tree
        if (preDel == null)
        {
            System.out.printf("\nThe node "+ val +" is not in the tree\n");
        }

    }

    // Searching method
    void searchVal(int val)
    {
        // Assigning a variable to hold the return value of the function
        Node currentNode = recursiveSearch(root, val);

        // If the node is not found
        if (currentNode != null)
        {
            System.out.printf("The node %d is found!\n", val);
        }

        // If the node is found
        else
        {
            System.out.printf("The node %d is not found!\n", val);
        }
    }



    // Char BST Methods
    // Insertion for char BST
    void insertChar(char character)
    {
        int charInt = (int) character;
        insertVal(charInt);
    }

    // Deletion for char BST
    void deleteChar(char character)
    {
        int charInt = (int) character;
        deleteVal(charInt);
    }

    // Searching for char BST
    void searchChar(char character)
    {
        int charInt = (int) character;
        searchVal(charInt);
    }

    // Traversal of char tree
    void inOrderChar(Node root)
    {
        if (root != null)
        {
            inOrderChar(root.left);
            System.out.print(" "+ (char) root.key);
            inOrderChar(root.right);
        }
    }
}
