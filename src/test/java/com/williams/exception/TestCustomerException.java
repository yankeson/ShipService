package com.williams.exception;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.williams.model.ZipRange;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * <p>
 * Test class used to test customer exception.
 * </p>
 * @author Ryan Yang
 * @version 1.0
 * @since 05/09/2019
 *
 */
public class TestCustomerException {

  /**
   * <p>
   * (3, 1) is an invalid object. It's validate method is expected throw InvalideZipRangeException.
   * </p>
   */
  @Test
  public void whenInvalidZipRangeException_thenAssertSucceed() {

    List<ZipRange> ranges = new ArrayList<>();

    ranges.add(new ZipRange(1, 4));
    ranges.add(new ZipRange(3, 1));
    ranges.add(new ZipRange(5, 6));

    assertThrows(InvalidZipRangeException.class, () -> { 
      for (ZipRange e : ranges) {
        e.validate();
      }
    });

  }

}
