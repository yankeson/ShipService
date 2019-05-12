package com.williams.exception;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.williams.model.ZipRange;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TestCustomerException {

  @Test
  public void whenInvalidZipRangeException_thenAssertSucceed() {

    List<ZipRange> ranges = new ArrayList<>();

    ranges.add(new ZipRange(1, 4));
    ranges.add(new ZipRange(3, 1));
    ranges.add(new ZipRange(5, 6));

    assertThrows(InvalidZipRangeException.class, () -> { 
      ranges.forEach(e -> {
        e.validate();
      }); });

  }

}
