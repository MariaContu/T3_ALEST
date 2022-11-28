class Node {
    //atributos
    int element;
    Node father;
    Node left;
    Node right;
    Cor color;

    //construtor


    public Node(int element) {
        father=null;
        left = null;
        right = null;
        this.element = element;
        color = Cor.BLACK;
    }



}