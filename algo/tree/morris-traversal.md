## Morris Traversal

Morris Traversal is used to traverse the tree *without using stack and recursion*.
The idea is based on a Threaded Binary tree.

| Complexity | Order |
|------------|-------|
| **TIME**   | O(N)  |
| **SPACE**  | O(1)  |


## References

1. [GeeksForGeeks](https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/)

## Related Questions

1. [Flatten Binary Tree to Linked List](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/)

```java
class Solution {
    // solution based on morris traversal
  public void flatten(TreeNode root) {
    TreeNode curr = root;

    while (curr != null) {
      // Process left node
      if (curr.left != null) {
        // update Predecessor
        TreeNode predecessor = getInorderPredecessor(curr);
        predecessor.right = curr.right;

        curr.right = curr.left;
        curr.left = null;
      }

      curr = curr.right;
    }
  }

  private TreeNode getInorderPredecessor(TreeNode node) {
    node = node.left;

    while (node.right != null) {
      node = node.right;
    }

    return node;
  }
}
```
