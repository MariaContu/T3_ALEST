import java.util.ArrayList;
import java.util.List;

public class RedBlackTree {

    //atributos
    Node root;
    Node nil;
    int count;

    public RedBlackTree() {
        count = 0;
        root = null;
    }

    //metodos
    public void add(int i)  {
        Node node = new Node(i);

    }

    public Node getParent(Node node)    {
        return node.father;
    }

    public void clear() {
        count = 0;
        root = null;
    }

    public boolean contains(int i)  {}
    
    public int height() {}

    public int size()   { return count; }

    public boolean isEmpty()   {
        return (root==null);
    }
    
    public RedBlackTree clone()   {
        RedBlackTree equal = new RedBlackTree();
        return equal;
    }

    public List<Integer> positionsPre()    {
        List<Integer> elemPre = new ArrayList<>();
        positionsPreAux(root,elemPre);
        return elemPre;
    }

    private void positionsPreAux(Node n, List<Integer> pre) {
        if (n != null) {
            pre.add(n.element); //Visita o nodo
            positionsPreAux(n.left, pre); //Visita a subárvore da esquerda
            positionsPreAux(n.right, pre); //Visita a subárvore da direita
        }
    }

    public List<Integer> positionsCentral()    {
        List<Integer> elemCen = new ArrayList<>();
        positionsPreAux(root,elemCen);
        return elemCen;
    }

    private void positionsCentralAux(Node n, List<Integer> center) {
        if (n != null) {
            positionsCentralAux(n.left, center); //Visita a subárvore da esquerda
            center.add(n.element); //Visita o nodo
            positionsCentralAux(n.right, center); //Visita a subárvore da direita
        }
    }

    public List<Integer> positionsPos()    {
        List<Integer> elemPos = new ArrayList<>();
        positionsPreAux(root,elemPos);
        return elemPos;
    }

    private void positionsPosAux(Node n, List<Integer> pos) {
        if (n != null) {
            positionsPreAux(n.left, pos); //Visita a subárvore da esquerda
            positionsPreAux(n.right, pos); //Visita a subárvore da direita
            pos.add(n.element); //Visita o nodo
        }
    }

    public List<Integer> positionsWidth()    {}

    public void geraDOT()   {}

}
