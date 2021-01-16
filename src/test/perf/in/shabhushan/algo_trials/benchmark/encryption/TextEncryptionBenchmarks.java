package in.shabhushan.algo_trials.benchmark.encryption;

import org.openjdk.jmh.annotations.*;
import org.jasypt.util.text.TextEncryptor;
import org.jasypt.util.password.PasswordEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;
import org.jasypt.util.text.StrongTextEncryptor;

import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Warmup(iterations = 3, time = 2, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 2, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Thread)
@BenchmarkMode(Mode.Throughput)
public class TextEncryptionBenchmarks {
  private static final String SHORT_TEXT = "The quick brown fox jumps over the lazy dog";
  private static final String LONG_TEXT = IntStream.range(0, 1000).mapToObj(a -> SHORT_TEXT).collect(Collectors.joining());

  private static final TextEncryptor encryptor = new BasicTextEncryptor();
  private static final TextEncryptor strongEncryptor = new StrongTextEncryptor();

  static {
    ((BasicTextEncryptor)encryptor).setPassword("password");
    ((StrongTextEncryptor)strongEncryptor).setPassword("password");
  }

  @Benchmark
  public void basicTestEncryptorWithShortText() {
    String encrypted = encryptor.encrypt(SHORT_TEXT);
    String decrypted = encryptor.decrypt(encrypted);
  }

  @Benchmark
  public void basicTestEncryptorWithLongText() {
    String encrypted = encryptor.encrypt(LONG_TEXT);
    String decrypted = encryptor.decrypt(encrypted);
  }

  @Benchmark
  public void strongTestEncryptorWithShortText() {
    String encrypted = strongEncryptor.encrypt(SHORT_TEXT);
    String decrypted = strongEncryptor.decrypt(encrypted);
  }

  @Benchmark
  public void strongTestEncryptorWithLongText() {
    String encrypted = strongEncryptor.encrypt(LONG_TEXT);
    String decrypted = strongEncryptor.decrypt(encrypted);
  }
}
