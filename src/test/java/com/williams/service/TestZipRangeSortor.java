package com.williams.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.williams.model.ZipRange;
import com.williams.service.ZipRangeSortor;

import org.junit.jupiter.api.Test;

public class TestZipRangeSortor {

  @Test
  public void compareTest() {
  
    ZipRangeSortor sortor = new ZipRangeSortor();
    
    ZipRange range1 = new ZipRange(0, 5);
    
    ZipRange range2 = new ZipRange(0, 4);
    assertEquals(1, sortor.compare(range1, range2));
    
    ZipRange range3 = new ZipRange(0, 6);
    assertEquals(-1, sortor.compare(range1, range3));
    
    ZipRange range4 = new ZipRange(1, 2);
    assertEquals(-1, sortor.compare(range1, range4));
    
    ZipRange range5 = new ZipRange(4, 7);
    assertEquals(-1, sortor.compare(range1, range5));
    
    ZipRange range6 = new ZipRange(6, 7);
    assertEquals(-1, sortor.compare(range1, range6));
    
    ZipRange range7 = new ZipRange(0, 5);
    assertEquals(-1, sortor.compare(range1, range7));
    
    ZipRange range8 = new ZipRange(4, 5);
    assertEquals(-1, sortor.compare(range1, range8));
    
  }

}
