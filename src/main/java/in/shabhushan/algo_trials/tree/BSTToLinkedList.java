package in.shabhushan.algo_trials.tree;

import in.shabhushan.algo_trials.utils.TreeNode;

public class BSTToLinkedList {

  public static TreeNode<Integer> getBSTtoLinkedList(TreeNode<Integer> bst) {
    return convert(bst).first;
  }

  private static ConvertedTreeNodes<Integer> convert(TreeNode<Integer> bst) {
    if (!bst.hasLeft() && !bst.hasRight()) return new ConvertedTreeNodes<>(bst, bst);

    ConvertedTreeNodes<Integer> output = new ConvertedTreeNodes<>();

    ConvertedTreeNodes<Integer> leftOutput = convert(bst.getLeft());
    ConvertedTreeNodes<Integer> rightOutput = convert(bst.getRight());

    output.first = (bst.hasLeft()) ? leftOutput.first : bst;
    output.last = (bst.hasRight()) ? rightOutput.last : bst;

    // Change tree structure now
    leftOutput.last.setRight(bst);
    bst.setLeft(leftOutput.last);

    rightOutput.first.setLeft(bst);
    bst.setRight(rightOutput.first);

    return output;
  }

  private static class ConvertedTreeNodes<T> {
    TreeNode<T> first;
    TreeNode<T> last;

    public ConvertedTreeNodes() {

    }

    public ConvertedTreeNodes(TreeNode<T> first, TreeNode<T> last) {
      this.first = first;
      this.last = last;
    }
  }
}
