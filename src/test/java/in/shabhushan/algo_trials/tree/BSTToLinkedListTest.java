package in.shabhushan.algo_trials.tree;

import in.shabhushan.algo_trials.utils.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static in.shabhushan.algo_trials.tree.BSTToLinkedList.getBSTtoLinkedList;
import static org.junit.Assert.assertTrue;

public class BSTToLinkedListTest {
  private Object voidType;

  @Before
  public void setup() throws InstantiationException, IllegalAccessException {
    voidType = null;
  }

  @Test
  public void test() {
    TreeNode<Integer> bst = new TreeNode<>(
        10,
        new TreeNode<>(
            6,
            new TreeNode<>(4),
            new TreeNode<>(8)
        ),
        new TreeNode<>(
            14,
            new TreeNode<>(12),
            new TreeNode<>(16)
        )
    );

    bst = getBSTtoLinkedList(bst);

    assertTrue(ensureOrderAndCount(bst, new int[]{4, 6, 8, 10, 12, 14, 16}));

    bst = new TreeNode<>(
        6,
        new TreeNode<>(
            4
        ),
        new TreeNode<>(
            10,
            new TreeNode<>(8),
            new TreeNode<>(
                14,
                new TreeNode<>(12),
                new TreeNode<>(16)
            )
        )
    );

    bst = getBSTtoLinkedList(bst);

    assertTrue(ensureOrderAndCount(bst, new int[]{4, 6, 8, 10, 12, 14, 16}));
  }

  private static boolean ensureOrderAndCount(TreeNode<Integer> list, int[] arr) {
    int count = 0;

    for (int i = 0; i < arr.length; i++) {
      if (list != null && list.getData() == arr[i]) {
        count++;
        list = list.getRight();
      } else {
        return false;
      }
    }

    return count == arr.length;
  }
}
