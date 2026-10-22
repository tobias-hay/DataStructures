package BST;

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
    delete(root, key);
  }

  private void delete(Node<K, V> root, K key) {
    Node<K, V> parent = null;
    Node<K, V> curr = root;

    while (curr != null && ((Comparable) key).compareTo(curr.key) != 0) {
      parent = curr;

      if (((Comparable) key).compareTo(curr.key) < 0) {
        // Go Left
        curr = curr.left;
      } else {
        // Go Right
        curr = curr.right;
      }
    }

    // Nothing found with key, early return
    if (curr == null) {
      return;
    }

    // 1. node is le leaf
    if (curr.left == null && curr.right == null) {
      // if node is not root, then set parent left/right to null
      if (curr == root) {
        root = null;
      } else {
        if (parent.left == curr) {
          parent.left = null;
        } else {
          parent.right = null;
        }
      }
    } else if (curr.left != null && curr.right != null) {
      // 2. node has two childs
      // find successor/predecessor
      Node<K, V> pred = findPred(curr);

      K predKey = pred.key;
      V predVal = pred.value;

      delete(root, predKey);

      curr.key = predKey;
      curr.value = predVal;
    } else {
      Node<K, V> child = (curr.left == null) ? curr.right : curr.left;

      if (curr == root) {
        root = child;
      } else {
        if (curr == parent.left) {
          parent.left = child;
        } else {
          parent.right = child;
        }
      }
    }
  }

  private Node<K, V> findPred(Node<K, V> curr) {
    curr = curr.left;

    while (curr.right != null) {
      curr = curr.right;
    }

    return curr;
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
