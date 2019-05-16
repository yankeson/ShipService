package com.williams.exception;


/**
 * Expcetion thrown when validating ZipRange object fails.
 * @author Ryan Yang
 * @version 1.0
 * @since 05/09/2019
 */
public class InvalidZipRangeException extends Exception {

  private static final long serialVersionUID = 1L;

  /**
   * <p>
   * Constructor to instantiate a customer Exception with proper message.
   * </p>
   * @param message a string of error message.
   */
  public InvalidZipRangeException(String message) {
    super(message);
  }

}
