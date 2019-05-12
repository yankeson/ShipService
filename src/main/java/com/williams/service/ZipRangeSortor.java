package com.williams.service;

import com.williams.model.ZipRange;

import java.util.Comparator;

/**
 * <p>
 * Use Collections.sort() method to sort list of ZipRange objects
 * </p>
 * @author Ryan Yang
 * @version 1.0
 * @since 05/09/2019
 */
public class ZipRangeSortor implements Comparator<ZipRange> {

  @Override
  /**
   * Override compare method inherited from Comparator Interface.
   * The two parameters should be valid ZipRange objects.
   */
  public int compare(ZipRange o1, ZipRange o2) {
    if (o1.getStart() < o2.getStart()) {
      return -1;
    } else if (o1.getStart() == o2.getStart()) {
      if (o1.getEnd() <= o2.getEnd()) {
        return -1;
      }
    }
    
    return 1;
  }

}
