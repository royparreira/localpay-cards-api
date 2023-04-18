package dev.royp.localpaycardsapi.fixture;

import java.util.Random;
import java.util.UUID;

public class StringFixture {
  private StringFixture() {}

  private static final String[] firstNames = {
    "Emma", "Liam", "Olivia", "Noah", "Ava", "William", "Sophia", "Elijah", "Isabella", "James"
  };

  private static final String[] lastNames = {
    "Smith", "Johnson", "Brown", "Taylor", "Anderson", "Wilson", "Miller", "Davis", "Garcia"
  };

  public static String getRandomFirstName() {
    return firstNames[(int) (Math.random() * firstNames.length)];
  }

  public static String getRandomLastName() {
    return lastNames[(int) (Math.random() * lastNames.length)];
  }

  public static String getRandomFullName() {
    return getRandomFirstName() + " " + getRandomLastName();
  }

  public static String getRandomStringUUID() {
    return UUID.randomUUID().toString();
  }

  public static String getRandomNumericStringWithSize(int size) {

    var randomValueBoundary = getRandomValueBoundaryForSize(size);

    long cvv = new Random().nextLong(randomValueBoundary);

    return Long.toString(cvv);
  }

  private static long getRandomValueBoundaryForSize(int size) {
    long randomValueBoundary = 0L;

    for (int i = 0; i < size; i++) {
      randomValueBoundary += (i * 10L + 9L);
    }

    return randomValueBoundary;
  }
}
