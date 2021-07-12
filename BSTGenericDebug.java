package bst;
import java.util.*;
// Using the comparable interface to compare different
// data types

// Only classes that uses interface comparable<T> can be used
// with this method
public class BSTGenericDebug <T extends Comparable <T>>
{
    // Initialization
    public class Node<T>
    {
        // Each node has a key, left and right branch
        T key;
        Node<T> left;
        Node<T> right;

        // Constructor
        Node(T key, Node<T> left, Node<T> right)
        {
            this.key = key;
            this.left = left;
            this.right = right;
        }

        // Constructor that accepts the key item as parameter
        Node(T item)
        {
            key = item;
            left = right = null;
        }

    }

    // Forms the root of the BST
    Node<T> root;


    // Recursive insertion
    Node<T> recursiveInsert(Node<T> currentNode, T val)
    {
        System.out.print("\nRecursive insert function is called...\n");
        System.out.printf("Inserted value: " + val + "\n");

        if (currentNode != null)
        {
            System.out.printf("Current Node: " + currentNode.key + "\n");
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
            currentNode = new Node<T>(val);
            return currentNode;
        }

        // Condition b)
        if (compare(val, currentNode) < 0)
        {
            System.out.print(val +" is less than "+ currentNode.key+"\n");
            currentNode.left = recursiveInsert(currentNode.left, val);
        }

        // Condition c)
        else if (compare(val, currentNode) > 0)
        {
            System.out.print(val+" is more than "+currentNode.key+"\n");
            currentNode.right = recursiveInsert(currentNode.right, val);
        }

        // Condition d)
        else if (val == currentNode.key)
        {
            // Returns the current node state
            System.out.print(val+" is equal to "+currentNode.key+"\n");
            System.out.print("Duplicate value is found. Node " + currentNode.key + " is returned\n");
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
        c) The deleted node has two children
    */
    Node<T> recursiveDelete(Node<T> currentNode, T val)
    {
        System.out.print("\nRecursive delete function is called...\n");
        System.out.printf("Deleted value: " + val + "\n");
        if (currentNode != null)
        {
            System.out.printf("Current Node: " + currentNode.key + "\n");
        }

        else
            System.out.print("Current Node: null\n");

        // Searching for the node to be deleted

        // If the node isn't found
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
                System.out.print("Node is deleted, returning right child\n");
                return currentNode.right;

            }

            // Condition b)ii) No right child
            else if (currentNode.right == null)
            {
                System.out.print("Node has no right child\n");
                System.out.print("Node is deleted, returning left child\n");
                return currentNode.left;
            }

            // Condition c)
            // Looking for the minimum value in the right
            // subtree

            System.out.print("Node has two child\n");
            System.out.print("Looking for minimum value...\n");

            T minValue = findMinVal(currentNode.right);

            // Replacing the current node's key with the min value
            System.out.printf("Replacing the deleted node " + val + " with copied minimum value " + minValue + "\n");
            currentNode.key = minValue;

            // Deleting the minimum value of the right subtree
            // since it has already replaced the currentNode
            System.out.printf("Deleting the minimum value...\n");
            currentNode.right = recursiveDelete(currentNode.right, minValue);
            return currentNode;
        }

        // Returns the right sub tree if val > node's key
        else if (compare(val, currentNode) > 0)
        {
            System.out.printf("Deleting the minimum value...\n");
            if (currentNode.right != null)
            {
                System.out.printf("Going to right child " + currentNode.right.key + "\n");
            }

            currentNode.right = recursiveDelete(currentNode.right, val);
            return currentNode;
        }

        // Returns the left sub tree if val < node's key
        else if (compare(val, currentNode) < 0)
        {
            System.out.printf("The node " + currentNode.key + " is more than " + val + "\n");
            if (currentNode.left != null)
            {
                System.out.printf("Going to left child " + currentNode.left.key + "\n");
            }
            currentNode.left = recursiveDelete(currentNode.left, val);
            return currentNode;
        }

        return currentNode;

    }

        // findMinVal
    /*
        This function is used to search for the minimum value
        in the right subtree

        This is used during the deletion method, where the node
        has two children
    */
    T findMinVal(Node<T> rightSmallest)
    {
        System.out.print("findMinVal function is called...\n");
        System.out.printf("Current node: " + rightSmallest.key + "\n");
        if (rightSmallest.left == null)
        {
            System.out.printf("The left child of the node is null\n");
            System.out.printf("Returning the smallest key of the right subtree " + rightSmallest.key + "\n\n");
            return rightSmallest.key;
        }

        else
        {
            System.out.printf(rightSmallest.key + " has a left child " + rightSmallest.left.key + "\n");
            System.out.printf("The smallest node is not found yet, returning left child " + rightSmallest.left.key + "\n\n");
            return findMinVal(rightSmallest.left);
        }
    }

    // Recursive search
    /*
        Takes the root as a parameter and searches from the root
        node to the target node
    */
    Node<T> recursiveSearch(Node<T> root, T target)
    {
        System.out.print("\n\nRecursive search function is called...\n");
        System.out.printf("Searched value: " + target + "\n");
        if (root != null)
        {
            System.out.printf("Current node: " + root.key + "\n");
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
        if (compare(target, root) > 0)
        {
            System.out.printf("The node " + root.key + " is less than " + target + "\n");
            if (root.right != null)
            {
                System.out.printf("Going to right child " + root.right.key + "\n");
            }
            return recursiveSearch(root.right, target);
        }

        // Returns left node if target < key
        else
        {
            System.out.printf("The node " +root.key + " is more than " + target + "\n");
            if (root.left != null)
            {
                System.out.printf("Going to left child " + root.left.key + "\n");
            }
            return recursiveSearch(root.left, target);
        }

        // null value will be returned if the value is not found
        // thus, there is no need to write an else statement for it
    }

    // Traversal
    void inOrder(Node<T> root)
    {
        if (root != null)
        {
            System.out.printf("Current Node: " + root.key + "\n");

            // Left child
            if (root.left != null)
            {
                System.out.printf("Exploring the left node: " + root.left.key + "\n\n");
            }

            else
                System.out.printf("The root of left subtree has been reached\nGoing back to parent node \n");

            inOrder(root.left);

            // Root
            System.out.print("The node" + " "+ root.key + " is added to the traversal" + "\n\n");

            // Right child
            if (root.right != null)
            {
                System.out.printf("Exploring the right node: " + root.right.key + "\n");
            }

            else
                System.out.printf("The root of right subtree has been reached\nGoing back to parent node \n");

            inOrder(root.right);


        }
    }

    void cleanInOrder(Node<T> root)
    {
        if (root != null)
        {
            cleanInOrder(root.left);
            System.out.print(" "+ root.key);
            cleanInOrder(root.right);
        }
    }


    // Insert method
    /*
        Takes in the value to be inserted and passes it to the
        recursiveInsert method
    */
    void insertVal(T val)
    {
        // The return type of the function is a root, so the method
        // can be assigned to root
        root = recursiveInsert(root, val);
        System.out.println("The value "+ val + " has been inserted\n");
    }

    // Deletion method
    void deleteVal(T val)
    {
        // To check whether the val to be deleted is in tree
        Node<T> preDel = recursiveSearch(root, val);

        // To call the recursiveDelete method
        root = recursiveDelete(root, val);

        // To check if the number is deleted
        Node<T> postDel = recursiveSearch(root, val);

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
    void searchVal(T val)
    {
        // Assigning a variable to hold the return value of the function
        Node<T> currentNode = recursiveSearch(root, val);

        // If the node is not found
        if (currentNode != null)
        {
            System.out.printf("The node " + val + " is found!\n");
        }

        // If the node is found
        else
        {
            System.out.printf("The node " + val + " is not found!\n");
        }
    }

    int compare(T val, Node<T> node)
    {
        int comparedVal = val.compareTo(node.key);
        return comparedVal;
    }
}