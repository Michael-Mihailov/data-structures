import java.lang.Comparable;

/**
    This class implements a binary search tree whose
    nodes hold objects that implement the Comparable
    interface.
*/
public class BinarySearchTree
{   
    private Node root;

    /**
        Constructs an empty tree.
    */
    public BinarySearchTree()
    {   
        root = null;
    }
    
    /**
        Inserts a new node into the tree.
        @param obj the object to insert
    */
    public void add(Comparable obj) 
    {   
        Node n = new Node(); 
        n.data = obj; n.left = null; n.right = null;
        root.addNode(n);
    }

    /**
        Tries to find an object in the tree.
        @param obj the object to find
        @return true if the object is contained in the tree
    */
    public boolean find(Comparable obj)
    {
        Node c = root;
        while (c != null)
        {
            int d = obj.compareTo(c.data);
            if (d == 0)
                return true;

            if (d < 0)
                c = c.left;
            else
                c = c.right;
        }

        return false;
    }
    
    /**
        Tries to remove an object from the tree. Does nothing
        if the object is not contained in the tree.
        @param obj the object to remove
    */
    public void remove(Comparable obj)
    {
        Node r = root;
        Node p = null;
        boolean found = false;

        while (!found && r != null)
        {
            int diff = obj.compareTo(r.data);
            if (diff == 0)
                found = true;
            else{
                p = r;
                if (diff < 0)
                    r = r.left;
                else
                    r = r.right;
            }
        }

        if (!found)
            return;

        if (r.left == null || r.right == null)
        {
            Node newChild;

            if (r.left == null)
            {
                newChild = r.right;
            }
            else
            {
                newChild = r.left;
            }

            if (p == null)
            {
                root = newChild;
            }
            else if (p.left == r)
            {
                p.left = newChild;
            }
            else
            {
                p.right = newChild;
            }

            return; //?
        }

        Node leastParent = r;
        Node least = r.right;
        while(least.left != null)
        {
            leastParent = least;
            least = least.left;
        }
        r.data = least.data;
        if (leastParent == r)
        {
            leastParent.right = least.right;
        }
        else
        {
            leastParent.left = least.right;
        }

        

    }
    
    /**
        Prints the contents of the tree in sorted order.
    */
    public void print()
    {   
        print(root);
    }   

    /**
        Prints a node and all of its descendants in sorted order.
        @param parent the root of the subtree to print
    */
    private static void print(Node parent)
    {   
        if (parent == null)
            return;
        
        print(parent.left);
        System.out.println(parent.data);
        print(parent.right);
    }

    /**
        A node of a tree stores a data item and references
        to the left and right child nodes.
    */
    static class Node
    {   
        public Comparable data;
        public Node left;
        public Node right;


        /**
            Inserts a new node as a descendant of this node.
            @param newNode the node to insert
        */
        public void addNode(Node newNode)
        {   
            int diff = newNode.data.compareTo(data);

            if (diff < 0)
            {
                if (left == null)
                    left = newNode;
                else
                    left.addNode(newNode);
                
                return;
            }

            if (diff > 0)
            {
                if (right == null)
                    right = newNode;
                else
                    right.addNode(newNode);
            }
        }
    }
}



