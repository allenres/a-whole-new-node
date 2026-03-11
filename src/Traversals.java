import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Traversals {
  public static void main(String[] args) {
    Node<Integer> root = new Node<>(88);


    Node<Integer> child1 = new Node<>(17);
    Node<Integer> child2 = new Node<>(58);
    Node<Integer> child3 = new Node<>(33);

    root.children.add(child1);
    root.children.add(child2);
    root.children.add(child3);

    Node<Integer> child1_1 = new Node<>(5);
    Node<Integer> child1_2 = new Node<>(99);
    child1.children.add(child1_1);
    child1.children.add(child1_2);


    Node<Integer> child2_1 = new Node<>(73);
    child2.children.add(child2_1);

    Node<Integer> child3_1 = new Node<>(24);
    Node<Integer> child3_2 = new Node<>(61);
    Node<Integer> child3_3 = new Node<>(12);
    child3.children.add(child3_1);
    child3.children.add(child3_2);
    child3.children.add(child3_3);


    Node<Integer> child3_1_1 = new Node<>(83);
    Node<Integer> child3_1_2 = new Node<>(6);
    child3_1.children.add(child3_1_1);
    child3_1.children.add(child3_1_2);

    // System.out.print(max(root));

    Map<Integer, List<Integer>> tree = new HashMap<>();
    tree.put(33, List.of(24, 61, 12));
    tree.put(17, List.of(5, 99));
    tree.put(58, List.of(73));
    tree.put(24, List.of(83, 6));
    tree.put(88, List.of(17, 58, 33));
    tree.put(5, new ArrayList<>());
    tree.put(99, new ArrayList<>());
    tree.put(73, new ArrayList<>());
    tree.put(83, new ArrayList<>());
    tree.put(6, new ArrayList<>());
    tree.put(61, new ArrayList<>());
    tree.put(12, new ArrayList<>());

    preOrderMap(tree, 88);
  }

  static void preOrder(Node<?> node) {
    if(node == null) return;
    System.out.println(node.value);
    for(Node<?> child : node.children) {
      preOrder(child);
    }
  }

  static void preOrderMap(Map<Integer, List<Integer>> tree, int current) {
    // what if current isnt in our tree
    if(!tree.containsKey(current)) return;

    // print current
    System.out.println(current);

    // recurse its children
    List<Integer> children = tree.get(current);
    for(int child : children) {
      preOrderMap(tree, child);
    }
  }

  // returns the max value in the tree
  // if node is null, return Integer.MIN_VALUE
  static int max(Node<Integer> node) {
    if(node == null) return Integer.MIN_VALUE;
    int biggest = node.value;
    for(Node<Integer> subtree : node.children) {
      int subTreeBiggest = max(subtree);
      if(subTreeBiggest > biggest) biggest = subTreeBiggest;
    }
    return biggest;
  }
}
