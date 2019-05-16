package com.williams.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.williams.model.ZipRange;

import org.junit.jupiter.api.Test;

/**
 * <p>
 * This test class is dedicated to test the methods of ZipRangeSortor.
 * </p>
 * @author Rya Yang
 * @version 1.0
 * @since 05/09/2019
 *
 */
public class TestZipRangeSorter {

  @Test
  /**
   * Test the overridden compare method.
   */
  public void compareTest() {
  
    ZipRangeSorter sortor = new ZipRangeSorter();
    
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
    assertEquals(0, sortor.compare(range1, range7));
    
    ZipRange range8 = new ZipRange(4, 5);
    assertEquals(-1, sortor.compare(range1, range8));
    
  }

}
