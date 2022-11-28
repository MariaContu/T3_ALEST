import java.util.List;

public class RedBlackTree {

    //classe nodo
    private static final class Node {

        public Node father;
        public Node left;
        public Node right;
        public Integer element;

        public Node(Integer element) {
            father = null;
            left = null;
            right = null;
            this.element = element;
        }
    }

    //atributos
    Node root = new Node(null);


    //metodos
    public void add(int i)  {
        
    }

    public Node getParent(Node node)    {

    }

    public void clear() {

    }

    public boolean contains(int i)  {}
    
    public int height() {}

    public int size()   {}

    public boolean isEmpty()   {
        if (root==null) return true;
        return false;
    }
    
    public <RedBlackTree> clone()   {

    }

    public List<> positionsPre()    {}

    public List<> positionsCentral()    {}

    public List<> positionsPos()    {}

    public List<> positionsWidth()    {}

    public void GeraDOT()   {}

}
