public class BinarySearchTree<K, V> implements BinarySearchTreeI<K, V> {

  private class Node<NK, NV> {
    public Node<NK, NV> left, right;
    public NK key;
    public NV value;

    public Node(NK key, NV value) {
      this.key = key;
      this.value = value;

      this.left = null;
      this.right = null;
    }
  }

  private Node<K, V> root;

  public BinarySearchTree() {
    root = null;
  }

  @Override
  public boolean contains(K key) {
    return searchTree(root, key) != null;
  }

  @Override
  public V get(K key) {
    Node<K, V> tmp = searchTree(root, key);

    if (tmp == null) {
      return null;
    }

    return tmp.value;
  }

  private Node<K, V> searchTree(Node<K, V> currNode, K key) {
    if (currNode == null) {
      return null;
    }

    if (((Comparable) key).compareTo(currNode.key) == 0) {
      return currNode;
    }

    // Go Left
    if (((Comparable) key).compareTo(currNode.key) < 0) {
      return searchTree(currNode.left, key);
    }

    // Go Right
    return searchTree(currNode.right, key);
  }

  @Override
  public void add(K key, V obj) {
    root = add(root, key, obj);
  }

  private Node<K, V> add(Node<K, V> currNode, K key, V val) {
    if (currNode == null) {
      return new Node<>(key, val);
    }

    // Left or right?
    if (((Comparable) key).compareTo(currNode.key) < 0) {
      // Go Left
      currNode.left = add(currNode.left, key, val);
    } else if (((Comparable) key).compareTo(currNode.key) > 0) {
      // Go Right
      currNode.right = add(currNode.right, key, val);
    }

    return currNode;
  }

  @Override
  public void remove(K key) {
  }

  public void printInOrder() {
    inOrder(root);
  }

  private void inOrder(Node<K, V> node) {
    if (node != null) {
      inOrder(node.left);
      System.out.println(node.value);
      inOrder(node.right);
    }
  }
}
