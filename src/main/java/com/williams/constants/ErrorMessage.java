package com.williams.constants;

/**
 * <p>
 * Constant Strings for Invalid Input.
 * </p>
 * @author Ryan Yang
 * @version 1.0
 * @since 05/09/2019
 *
 */
public interface ErrorMessage {

  public static final String UNPAIRED_BRACKETS = "Unpaired brackets. Please try again";
  public static final String UNPAIRED_INTEGERS = "One pair of brackets have two and only "
      + "two integers separated by comma. Please try again.";
  public static final String INVALID_INTEGER = "String cannot be converted into int. "
      + "Please try again.";
  public static final String INVALID_PARENTHESIS = "Input should start with '(', "
          + "and end with ')'! Please try again.";
  
}
