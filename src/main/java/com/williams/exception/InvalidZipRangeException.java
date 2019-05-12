package com.williams.exception;


/**
 * Runtime expcetion thrown when validating ZipRange object fails.
 * @author Ryan Yang
 * @version 1.0
 * @since 05/09/2019
 */
public class InvalidZipRangeException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public InvalidZipRangeException(String message) {
    super(message);
  }

}
