package in.shabhushan.algo_trials.utils.heap;

public interface Heap<T> {
  public void insert(T item);
  public T delete(int index);
  public void changeKey(T item, T newValue);
  public T top();
  public T removeTop();
}
