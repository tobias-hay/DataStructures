package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import BST.BinarySearchTree;

public class BSTTest {
  private final PrintStream ogOut = System.out;
  private final ByteArrayOutputStream testOut = new ByteArrayOutputStream();

  @BeforeEach
  public void setUp() {
    System.setOut(new PrintStream(testOut));
  }

  @Test
  public void initTree() {
    BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();

    assertNotNull(tree);
  }

  @Test
  public void addOneItem() {
    BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();

    tree.add(1, "One");
    tree.printInOrder();

    String expected = "One" + System.lineSeparator();
    assertEquals(expected, testOut.toString());
  }

  @Test
  public void addMultipleItems() {
    BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
    int[] keys = { 1, 2, 3, 4, 5 };
    String expected = "";

    for (int key : keys) {
      tree.add(key, "" + key);
      expected += key + System.lineSeparator();
    }

    tree.printInOrder();

    assertEquals(expected, testOut.toString());
  }

  @Test
  public void addMultipleItemsUnsorted() {
    BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
    int[] keys = { 5, 3, 1, 2, 4 };
    int[] sortedKeys = { 1, 2, 3, 4, 5 };

    for (int key : keys) {
      tree.add(key, "" + key);
    }

    tree.printInOrder();

    String expected = "";
    for (int key : sortedKeys) {
      expected += key + System.lineSeparator();
    }
    assertEquals(expected, testOut.toString());
  }

  @Test
  public void addMultipleItemsLargerUnsorted() {
    BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
    int[] keys = { 29, 40, 15, 23, 12, 10, 62, 79, 94, 3, 17, 67, 36 };
    int[] sortedKeys = { 3, 10, 12, 15, 17, 23, 29, 36, 40, 62, 67, 79, 94 };

    for (int key : keys) {
      tree.add(key, "" + key);
    }

    tree.printInOrder();

    String expected = "";
    for (int key : sortedKeys) {
      expected += key + System.lineSeparator();
    }
    assertEquals(expected, testOut.toString());
  }

  @Test
  public void getItemInTree() {
    BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
    int[] keys = { 29, 40, 15, 23, 12, 10, 62, 79, 94, 3, 17, 67, 36 };

    for (int key : keys) {
      tree.add(key, "" + key);
    }

    for (int key : keys) {
      assertEquals("" + key, tree.get(key));
    }
  }

  @Test
  public void getItemNotInTree() {
    BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
    int[] keys = { 29, 40, 15, 23, 12, 10, 62, 79, 94, 3, 17, 67, 36 };

    for (int key : keys) {
      tree.add(key, "" + key);
    }

    assertNull(tree.get(5));
    assertNull(tree.get(-1));
    assertNull(tree.get(0));
  }

  @Test
  public void getItemOnEmptyTree() {
    BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();

    assertNull(tree.get(5));
    assertNull(tree.get(-1));
    assertNull(tree.get(0));
  }

  @Test
  public void treeContainsItem() {
    BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
    int[] keys = { 29, 40, 15, 23, 12, 10, 62, 79, 94, 3, 17, 67, 36 };

    for (int key : keys) {
      tree.add(key, "" + key);
    }

    for (int key : keys) {
      assertTrue(tree.contains(key));
    }
  }

  @Test
  public void treeDoesNotContainItem() {
    BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
    int[] keys = { 29, 40, 15, 23, 12, 10, 62, 79, 94, 3, 17, 67, 36 };

    for (int key : keys) {
      tree.add(key, "" + key);
    }

    assertFalse(tree.contains(2));
    assertFalse(tree.contains(0));
    assertFalse(tree.contains(-1));
  }

  @Test
  public void treeContainsOnEmptyTree() {
    BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();

    assertFalse(tree.contains(2));
    assertFalse(tree.contains(0));
    assertFalse(tree.contains(-1));
  }

  @Test
  public void removeOnEmptyTree() {
    BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();

    tree.remove(2);
    tree.remove(0);
    tree.remove(-1);
  }

  @Test
  public void removeNodeInSingleNodeTree() {
    BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
    int[] keys = { 29 };

    for (int key : keys) {
      tree.add(key, "" + key);
    }

    tree.remove(29);

    tree.printInOrder();

    assertEquals("", testOut.toString());
  }

  @Test
  public void removeTreeRoot() {
    BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
    int[] keys = { 29, 40, 15, 23, 12, 10, 62, 79, 94, 3, 17, 67, 36 };
    int[] sortedKeys = { 3, 10, 12, 15, 17, 23, 36, 40, 62, 67, 79, 94 };

    for (int key : keys) {
      tree.add(key, "" + key);
    }

    tree.remove(29);

    tree.printInOrder();

    String expected = "";
    for (int key : sortedKeys) {
      expected += key + System.lineSeparator();
    }
    assertEquals(expected, testOut.toString());
  }

  @Test
  public void removeLeafInTree() {
    BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
    int[] keys = { 29, 40, 15, 23, 12, 10, 62, 79, 94, 3, 17, 67, 36 };
    int[] sortedKeys = { 10, 12, 15, 17, 23, 29, 36, 40, 62, 67, 79, 94 };

    for (int key : keys) {
      tree.add(key, "" + key);
    }

    tree.remove(3);

    tree.printInOrder();

    String expected = "";
    for (int key : sortedKeys) {
      expected += key + System.lineSeparator();
    }
    assertEquals(expected, testOut.toString());
  }

  @Test
  public void removeSingleConnectedNodeInTree() {
    BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
    int[] keys = { 29, 40, 15, 23, 12, 10, 62, 79, 94, 3, 17, 67, 36 };
    int[] sortedKeys = { 3, 12, 15, 17, 23, 29, 36, 40, 62, 67, 79, 94 };

    for (int key : keys) {
      tree.add(key, "" + key);
    }

    tree.remove(10);

    tree.printInOrder();

    String expected = "";
    for (int key : sortedKeys) {
      expected += key + System.lineSeparator();
    }
    assertEquals(expected, testOut.toString());
  }

  @Test
  public void removeSingleNodeInTree() {
    BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
    int[] keys = { 29, 40, 15, 23, 12, 10, 62, 79, 94, 3, 17, 67, 36 };
    int[] sortedKeys = { 3, 10, 12, 15, 23, 29, 36, 40, 62, 67, 79, 94 };

    for (int key : keys) {
      tree.add(key, "" + key);
    }

    tree.remove(17);

    tree.printInOrder();

    String expected = "";
    for (int key : sortedKeys) {
      expected += key + System.lineSeparator();
    }
    assertEquals(expected, testOut.toString());
  }

  @Test
  public void removeAllInTreeSmall() {
    BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
    int[] keys = { 29, 40, 15, 23, 17 };

    for (int key : keys) {
      tree.add(key, "" + key);
    }

    for (int key : keys) {
      tree.remove(key);
    }

    tree.printInOrder();

    assertEquals("", testOut.toString());
  }

  @Test
  public void removeAllInTreeLarge() {
    BinarySearchTree<Integer, String> tree = new BinarySearchTree<>();
    int[] keys = { 29, 40, 15, 23, 12, 10, 62, 79, 94, 3, 17, 67, 36 };

    for (int key : keys) {
      tree.add(key, "" + key);
    }

    for (int key : keys) {
      tree.remove(key);
    }

    tree.printInOrder();

    assertEquals("", testOut.toString());
  }

  @AfterEach
  public void restore() {
    System.setOut(ogOut);
  }
}
