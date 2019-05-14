package com.williams.main;

import com.williams.entry.Messenger;
import com.williams.model.ZipRange;
import com.williams.service.ZipRangeMerger;
import com.williams.service.ZipRangeSorter;

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
  /**
   * Run as JUnit, it would log info on console. By following the log info, user can test any case.
   */
  public void mainTest() {

    Messenger messager = new Messenger();
    List<ZipRange> ranges = messager.read();

    ZipRangeSorter sortor = new ZipRangeSorter();
    Collections.sort(ranges, sortor);

    ZipRangeMerger merger = new ZipRangeMerger();
    ranges = merger.merge(ranges);

    messager.write(ranges);
  }
}
