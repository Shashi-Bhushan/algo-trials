package in.shabhushan.algo_trials.utils;

import java.util.Objects;

public class TreeNode<T extends Object> {
  private T data;
  private TreeNode<T> left;
  private TreeNode<T> right;

  public TreeNode(T data, TreeNode<T> left, TreeNode<T> right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }

  public TreeNode(T data) {
    this.data = data;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public TreeNode<T> getLeft() {
    return left;
  }

  public void setLeft(TreeNode<T> left) {
    this.left = left;
  }

  public boolean hasLeft() {
    return this.left != null;
  }

  public TreeNode<T> getRight() {
    return right;
  }

  public void setRight(TreeNode<T> right) {
    this.right = right;
  }

  public boolean hasRight() {
    return this.right != null;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TreeNode<?> that = (TreeNode<?>) o;
    return Objects.equals(data, that.data) && Objects.equals(left, that.left) && Objects.equals(right, that.right);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, left, right);
  }
}
