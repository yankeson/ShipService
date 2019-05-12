package com.williams.service;

import com.williams.model.ZipRange;

import java.util.ArrayList;
import java.util.List;

public class ZipRangeMerger {
  
  /**
   * If the ranges of two ZipRange objets overlap each other, then merger into one object.
   * @param ranges List of validated ZipRange objects
   * @return
   */
  public List<ZipRange> merge(List<ZipRange> ranges) {

    if (ranges == null || ranges.size() == 0) {
      return null;
    }

    List<ZipRange> mergedRanges = new ArrayList<>();
    
    ZipRange preRange = ranges.get(0);
    for (int i = 1; i < ranges.size(); i++) {
      ZipRange nextRange = ranges.get(i);

      if (preRange.getEnd() < nextRange.getStart()) {
        mergedRanges.add(preRange);
        preRange = nextRange;
        continue;
      } else {
        preRange.setEnd(Math.max(preRange.getEnd(), nextRange.getEnd()));
      }
    }
    
    mergedRanges.add(preRange);
    
    return mergedRanges;
  }

}
