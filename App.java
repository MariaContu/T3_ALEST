public class App {
    public static void main(String[] args) {
        RedBlackTree rbt = new RedBlackTree();
        RedBlackTree newRbt = new RedBlackTree();

        //adiciona os elementos da arvore
        for (int i = 1; i <= 9; i++) {
            rbt.add(i);
        }

        //altura da arvore
        rbt.height();

        //geradot
        rbt.geraDOT();

        //limpa arvore
        rbt.clear();

        //adiciona elementos de novo
        for (int i = 9; i >= 1; i--) {
            rbt.add(i);
        }

        //apresenta conteudo pelo caminhamento central
        System.out.println(rbt.positionsCentral());

        //clona arvore
        newRbt=rbt.clone();

        //geradot
        newRbt.geraDOT();

    }
}