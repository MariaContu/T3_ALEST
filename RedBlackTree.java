import java.util.ArrayList;
import java.util.List;

public class RedBlackTree {

    //atributos
    Node root;
    Node nil;
    int count;

    public RedBlackTree() { //Construtor da arvore
        count = 0;
        root = null;
    }

    //metodos

    //O(log n)
    public void add(int i)  {
        Node node = new Node(i);

    }


    public Node getParent(Node node)    {//retorna pai
        return node.father;
    }

    public void clear() {   //limpa arvore
        count = 0;
        root = null;
    }

    //O(log n)
    public boolean contains(int i)  {   //retorna true ou false se a arvore contem um elemento
        Node aux = searchNodeRef(i, root);
        return (aux!=null);
    }
    
    public int height() {}

    public int size()   { return count; } //retorna numero de nodos

    public boolean isEmpty()   {
        return (root==null);
    } //retorna se arvore esta vazia
    
    public RedBlackTree clone()   {

    }

    public List<Integer> positionsPre()    {    //lista pre ordenada
        List<Integer> elemPre = new ArrayList<>();
        positionsPreAux(root,elemPre);
        return elemPre;
    }

    private void positionsPreAux(Node n, List<Integer> pre) { //recursao da lista pre ordenada
        if (n != null) {
            pre.add(n.element); //Visita o nodo
            positionsPreAux(n.left, pre); //Visita a subárvore da esquerda
            positionsPreAux(n.right, pre); //Visita a subárvore da direita
        }
    }

    public List<Integer> positionsCentral()    {    //lista central
        List<Integer> elemCen = new ArrayList<>();
        positionsPreAux(root,elemCen);
        return elemCen;
    }

    private void positionsCentralAux(Node n, List<Integer> center) {    //recursao lista central
        if (n != null) {
            positionsCentralAux(n.left, center); //Visita a subárvore da esquerda
            center.add(n.element); //Visita o nodo
            positionsCentralAux(n.right, center); //Visita a subárvore da direita
        }
    }

    public List<Integer> positionsPos()    {    //lista pos ordenada
        List<Integer> elemPos = new ArrayList<>();
        positionsPreAux(root,elemPos);
        return elemPos;
    }

    private void positionsPosAux(Node n, List<Integer> pos) {   //recursao lista pos ordenada
        if (n != null) {
            positionsPreAux(n.left, pos); //Visita a subárvore da esquerda
            positionsPreAux(n.right, pos); //Visita a subárvore da direita
            pos.add(n.element); //Visita o nodo
        }
    }
    public List<Integer> positionsWidth()    {}


    public void rodaEsq(Node nodo)    {  //manda nodo para esquerda, fazendo rotacao
        Node aux = nodo.right;

        nodo.right = aux.left;
        if(aux.left!=null)  {
            aux.left.father=nodo;
        }

        aux.father=nodo.father;
        if (nodo.father==null)   {
            root=aux;
        }
        else {
            if (nodo == nodo.father.left)   {
                nodo.father.left=aux;
            }
            else nodo.father.right=aux;
        }
        aux.left=nodo;
        nodo.father=aux;
    }


    public void rodaDir(Node nodo)    { //manda nodo para direita, fazendo rotacao
        Node aux = nodo.left;

        nodo.left = aux.right;
        if(aux.right!=null)  {
            aux.right.father=nodo;
        }

        aux.father=nodo.father;
        if (nodo.father==null)   {
            root=aux;
        }
        else {
            if (nodo == nodo.father.left)   {
                nodo.father.left=aux;
            }
            else nodo.father.right=aux;
        }
        aux.right=nodo;
        nodo.father=aux;
    }

    //METODOS TIRADOS DE ARQUIVO DA PROFESSORA

    private void GeraConexoesDOT(Node nodo) {
        if (nodo == null) {
            return;
        }

        GeraConexoesDOT(nodo.left);
        //   "nodeA":esq -> "nodeB" [color="0.650 0.700 0.700"]
        if (nodo.left != null) {
            System.out.println("\"node" + nodo.element + "\":esq -> \"node" + nodo.left.element + "\" " + "\n");
        }

        GeraConexoesDOT(nodo.right);
        //   "nodeA":dir -> "nodeB";
        if (nodo.right != null) {
            System.out.println("\"node" + nodo.element + "\":dir -> \"node" + nodo.right.element + "\" " + "\n");
        }
        //"[label = " << nodo->hDir << "]" <<endl;
    }

    private void GeraNodosDOT(Node nodo) {
        if (nodo == null) {
            return;
        }
        GeraNodosDOT(nodo.left);
        //node10[label = "<esq> | 10 | <dir> "];
        System.out.println("node" + nodo.element + "[label = \"<esq> | " + nodo.element + " | <dir> \"]" + "\n");
        GeraNodosDOT(nodo.right);
    }

    public void GeraConexoesDOT() {
        GeraConexoesDOT(root);
    }

    public void GeraNodosDOT() {
        GeraNodosDOT(root);
    }

    // Gera uma saida no formato DOT
    // Esta saida pode ser visualizada no GraphViz
    // Versoes online do GraphViz pode ser encontradas em
    // http://www.webgraphviz.com/
    // http://viz-js.com/
    // https://dreampuf.github.io/GraphvizOnline
    public void geraDOT() {
        System.out.println("digraph g { \nnode [shape = record,height=.1];\n" + "\n");

        GeraNodosDOT();
        System.out.println("");
        GeraConexoesDOT(root);
        System.out.println("}" + "\n");
    }

    private Node searchNodeRef(Integer element, Node target) {  //procura elemento pela arvore RECURSIVO
        if (element == null || target == null)
            return null;
        if (element == target.element)
            return target;
        if (element < target.element)
            return searchNodeRef(element, target.left);
        else
            return searchNodeRef(element, target.right);
    }

}
