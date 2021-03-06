package com.williams.model;

import com.williams.exception.InvalidZipRangeException;

/**
 * <h1>Set a Range of Zip Code.</h1>
 * <p>
 * <b>Note: </b>The range is given with two int numbers, start and end. start must be less or equal
 * to end.
 * </p>
 * @author Ryan Yang
 * @version 1.0
 * @since 05/09/2019
 */
public class ZipRange {

  private int start;
  private int end;

  public ZipRange(int start, int end) {
    this.start = start;
    this.end = end;
  }

  public int getStart() {
    return start;
  }

  public void setStart(int start) {
    this.start = start;
  }

  public int getEnd() {
    return end;
  }

  public void setEnd(int end) {
    this.end = end;
  }

  /**
   * check if the initial boundaries are valid. For example, 
   * if start is greater than end, then it's not valid.
   * @throws InvalidZipRangeException
   * 
  */
  public void validate() throws InvalidZipRangeException {
    if (start > end) {
      throw new InvalidZipRangeException("Invalide initial boundaries");
    }

  }
  
  @Override
  public String toString() {
    return "[" + start + ", " + end + "]";
  }

  /**
   * Override hashCode method to maintain the contract between equals and hashCode.
   */
  @Override
  public int hashCode() {

    int hash = 7;

    hash = hash * 379 + this.start;
    hash = hash * 379 + this.end;
    
    return hash;
  }

  /**
   * <p>
   * When and only when the objects have the equal values for the ordered 
   * integer pairs, then they are equal.
   * </p>
   */
  @Override
  public boolean equals(Object obj) {

    if (obj == null) {
      return false;
    }

    if (!(obj instanceof ZipRange)) {
      return false;
    }

    ZipRange zips = (ZipRange)obj;

    if (zips.getStart() == this.start && zips.getEnd() == this.end) {
      return true;
    }

    return false;
  }
  
  

}
