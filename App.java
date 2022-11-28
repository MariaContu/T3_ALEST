public class App {
    public static void main(String[] args) {
        RedBlackTree rbt = new RedBlackTree();

        //adiciona os elementos da arvore
        for (int i = 1; i <= 9; i++) {
            rbt.add(i);
        }
        //altura
        rbt.height();

        //geradot
        rbt.geraDOT();

        //limpa arvore
        rbt.clear();

        //adiciona elementos de novo
        for (int i = 9; i >= 1; i--) {
            rbt.add(i);
        }

        //conteudo pelo caminhamento central
        rbt.positionsCentral();

        //clona arvore
        rbt.clone();

        //geradot
        rbt.geraDOT();

    }
}