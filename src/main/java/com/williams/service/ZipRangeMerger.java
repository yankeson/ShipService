package com.williams.service;

import com.williams.model.ZipRange;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * This is a service class dedicated to merge list of ordered objects.
 * </p>
 * @author Ryan Yang
 * @since 05/09/2010
 * @version 1.0
 */
public class ZipRangeMerger {
  
  /**
   * If the ranges of two ZipRange objects overlap each other, then merger into one object.
   * @param ranges List of validated ZipRange objects
   * @return list of merged objects in ascending order.
   */
  public List<ZipRange> merge(List<ZipRange> ranges) {

    if (ranges == null || ranges.size() == 0) {
      return null;
    }

    List<ZipRange> mergedRanges = new ArrayList<>();
    
    ZipRange preRange = ranges.get(0);
    for (int i = 1; i < ranges.size(); i++) {
      ZipRange nextRange = ranges.get(i);

      if (preRange.getEnd() + 1 < nextRange.getStart()) {
        mergedRanges.add(preRange);
        preRange = nextRange;
      } else {
        preRange.setEnd(Math.max(preRange.getEnd(), nextRange.getEnd()));
      }
    }
    
    mergedRanges.add(preRange);
    
    return mergedRanges;
  }

}
