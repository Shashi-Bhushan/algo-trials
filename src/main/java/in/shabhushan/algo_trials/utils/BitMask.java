package in.shabhushan.algo_trials.utils;

public class BitMask {

  private long mask;
  private final int size;

  public BitMask(int size) {
    this.size = size;
    // unset all by default
    this.mask = 0L;
  }

  public BitMask(int size, boolean setAllBits) {
    this.size = size;

    if (setAllBits) {
      this.mask = (1L << (this.size + 1)) - 1;
    } else {
      // unset all by default
      this.mask = 0L;
    }
  }

  public void toggle(int index) {
    if (index > size) {
      throw new IllegalArgumentException("Greater than size");
    }

    if (isBitSet(index)) {
      unsetBit(index);
    } else {
      setBit(index);
    }
  }

  public boolean isBitSet(int index) {
    return ((mask & (1L << index)) != 0);
  }

  public void setBit(int index) {
    this.mask = this.mask | (1L << index);
  }

  public void unsetBit(int index) {
    this.mask = this.mask & ~(1L << index);
  }

  public String getState() {
    return Long.toBinaryString(mask);
  }

  public long getMask() {
    return this.mask;
  }
}
