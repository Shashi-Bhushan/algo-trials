package in.shabhushan.algo_trials.string;

import org.junit.Assert;
import org.junit.Test;

import static in.shabhushan.algo_trials.string.PalindromePermutation.isPalindromePermutation;

public class PalindromePermutationTest {
  @Test
  public void test() {
    Assert.assertTrue(isPalindromePermutation("aba"));
    Assert.assertFalse(isPalindromePermutation("abac"));
    Assert.assertTrue(isPalindromePermutation("aaa"));
    Assert.assertTrue(isPalindromePermutation("axxbabc"));
    Assert.assertTrue(isPalindromePermutation("xenonexaa"));

  }
}
