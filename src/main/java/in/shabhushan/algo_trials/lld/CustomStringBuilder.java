package in.shabhushan.algo_trials.lld;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Create a custom StringBuilder class.
 * Methods to support
 * - append
 * - insert
 * - toString()
 */
public class CustomStringBuilder {
  private static final int INITIAL_CAPACITY = 16;

  private byte[] bytes;
  private int capacity;

  // count is the current index till where the array is filled
  private int count;

  public CustomStringBuilder() {
    capacity = INITIAL_CAPACITY;
    this.bytes = new byte[INITIAL_CAPACITY];
    count = 0;
  }

  public CustomStringBuilder(String str) {
    capacity = INITIAL_CAPACITY + str.length();
    this.bytes = new byte[capacity];

    append(str);
  }

  public CustomStringBuilder append(String str) {
    insert(count, str);

    return this;
  }

  public CustomStringBuilder insert(int index, String str) {
    ensureCapacity(count + str.length());

    byte[] source = str.getBytes(StandardCharsets.UTF_8);

    // just an optimization
    if (index != count) {
      // Copies the array element forward
      // Initially array is filled till count
      // Now I want to put source.length elements in between at `index` position
      // so, I need to move `(count - index)` elements `(index + source.length)` position forward
      System.arraycopy(bytes, index, bytes, index + source.length, count - index);
    }

    // copy source bytes to current bytes and increment count
    System.arraycopy(source, 0, bytes, index, source.length);
    count += source.length;

    return this;
  }

  @Override
  public String toString() {
    byte[] str = Arrays.copyOf(this.bytes, count);

    return new String(str);
  }

  private void ensureCapacity(int minimumCapacity) {
    if (capacity <= minimumCapacity) {
      int newCapacity = minimumCapacity + capacity;
      this.bytes = Arrays.copyOf(bytes, newCapacity);
      capacity = newCapacity;
    }
  }
}
