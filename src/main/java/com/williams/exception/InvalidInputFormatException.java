package com.williams.exception;

/**
 * <p>
 * Exception thrown when input format is wrong.
 * </p>
 * @author Ryan Yang
 * @version 1.0
 * @since 05/09/2019
 */
public class InvalidInputFormatException extends Exception {

  private static final long serialVersionUID = 1L;

  public InvalidInputFormatException(String message) {
    super(message);
  }

}
