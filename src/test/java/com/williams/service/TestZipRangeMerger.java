package com.williams.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.williams.model.ZipRange;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TestZipRangeMerger {

  @Test
  public void mergeTest() {
        
    List<ZipRange> ranges = new ArrayList<>();
    
    ZipRange range1 = new ZipRange(0, 5);
    ranges.add(range1);
    ZipRange range2 = new ZipRange(0, 1);
    ranges.add(range2);
    ZipRange range3 = new ZipRange(2, 3);
    ranges.add(range3);
    ZipRange range4 = new ZipRange(4, 7);
    ranges.add(range4);
    ZipRange range5 = new ZipRange(5, 6);
    ranges.add(range5);
    ZipRange range6 = new ZipRange(7, 8);
    ranges.add(range6);
    ZipRange range7 = new ZipRange(9, 10);
    ranges.add(range7);
    
    ZipRangeMerger merger = new ZipRangeMerger();
    assertEquals(2, merger.merge(ranges).size());

  }

}
