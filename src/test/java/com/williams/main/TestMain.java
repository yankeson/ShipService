package com.williams.main;

import com.williams.entry.Messager;
import com.williams.model.ZipRange;
import com.williams.service.ZipRangeMerger;
import com.williams.service.ZipRangeSortor;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * This is the main test calss.
 * @author Ryan Yang
 * @version 1.0
 * @since 05/09/2019
 *
 */
public class TestMain {

  @Test
  public void mainTest() {

    Messager messager = new Messager();
    List<ZipRange> ranges = messager.read();

    ZipRangeSortor sortor = new ZipRangeSortor();
    Collections.sort(ranges, sortor);

    ZipRangeMerger merger = new ZipRangeMerger();
    ranges = merger.merge(ranges);

    System.out.println(ranges);
  }
}
