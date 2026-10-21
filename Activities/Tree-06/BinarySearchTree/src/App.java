public class App {
    public static void main(String[] args) throws Exception {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();

        bst.add(29, "Twenty Nine");
        bst.add(40, "Forty");
        bst.add(15, "Fifteen");
        bst.add(23, "Twenty Three");
        bst.add(12, "Twelve");
        bst.add(10, "Ten");
        bst.add(62, "Sixty Two");
        bst.add(79, "Seventy Nine");
        bst.add(94, "Ninety Four");
        bst.add(3, "Three");
        bst.add(17, "Seventeen");
        bst.add(67, "Sixty Seven");

        bst.printInOrder();
    }
}
