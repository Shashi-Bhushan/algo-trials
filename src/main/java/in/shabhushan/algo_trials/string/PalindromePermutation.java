package in.shabhushan.algo_trials.string;

import in.shabhushan.algo_trials.utils.BitMask;

public class PalindromePermutation {
  public static boolean isPalindromePermutation(String string) {
    // set bit means odd occurrence of a number
    BitMask mask = new BitMask(26);

    for (char c: string.toCharArray()) {
      mask.toggle(c - 'a');
    }

    // check if mask power of two i.e. only one set bit
    return (mask.getMask() & (mask.getMask() - 1)) == 0;
  }
}
