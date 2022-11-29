class Node {
    //atributos
    Integer element;
    Node father;
    Node left;
    Node right;
    Cor color;

    //construtor


    public Node(Integer element) {
        father=null;
        left = null;
        right = null;
        this.element = element;
        color = Cor.BLACK;
    }



}