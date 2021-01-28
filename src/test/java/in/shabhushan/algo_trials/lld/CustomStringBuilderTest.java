package in.shabhushan.algo_trials.lld;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomStringBuilderTest {
  @Test
  public void testCustomStringBuilder() {
    CustomStringBuilder builder = new CustomStringBuilder("Abc");

    assertEquals("Abc", builder.toString());

    builder.append(" ").append("exponential");

    assertEquals("Abc exponential", builder.toString());

    builder.insert(3, "-new ");

    assertEquals("Abc-new  exponential", builder.toString());
  }
}
