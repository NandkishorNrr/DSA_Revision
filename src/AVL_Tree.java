public class AVL_Tree {
    public static void main(String[] args) {
        AVL_Tree avl_tree = new AVL_Tree();
        avl_tree.insert(10);
        avl_tree.insert(20);
        avl_tree.insert(30);
    }
    class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;
        private int height = 0;

        Node(int value){
            this.value = value;
        }
        @Override
        public String toString(){
            return "Value: " + this.value +
                    "Height: " + this.height;
        }
    }
    private Node root;

    public void insert(int value){
        root = insert(root, value);
    }
    private Node insert(Node root, int value){
        var newNode = new Node(value);
        if (root == null)
            return newNode;

        if (value < root.value)
            root.leftChild = insert(root.leftChild, value);
        else
            root.rightChild = insert(root.rightChild, value);

        setHeight(root);

        return balance(root);
    }
    private void setHeight(Node node){
        root.height = Math.max(
                height(root.leftChild),
                height(root.rightChild)) + 1;
    }

    private Node balance(Node root) {
        if (isLeftHeavy(root)) {
            if (balanceFactor(root.leftChild) < 0)
                root.leftChild = rotateLeft(root.leftChild);
            return rotateRight(root);
        }
        else if (isRightHeavy(root)) {
            if (balanceFactor(root.rightChild) > 0)
                root.rightChild = rotateRight(root.rightChild);
            return rotateLeft(root);
        }
        return root;
    }

    private Node rotateRight(Node root) {
        var node = root.leftChild;

        root.leftChild = node.rightChild;
        node.rightChild = root;

        setHeight(root);
        setHeight(node);

        return node;
    }

    private Node rotateLeft(Node leftChild) {
        var node = root.rightChild;

        root.rightChild = node.leftChild;
        node.leftChild = root;

        setHeight(root);
        setHeight(node);

        return node;
    }


    private boolean isLeftHeavy(Node node){
        return balanceFactor(node) > 1;
    }
    private boolean isRightHeavy(Node node){
        return balanceFactor(node) < -1;
    }

    private int balanceFactor(Node node) {
        return (node == null) ? 0 : height(node.leftChild) - height(root.rightChild);
    }

    private int height(Node node){
        return (node == null) ? -1 : node.height;
    }
}
