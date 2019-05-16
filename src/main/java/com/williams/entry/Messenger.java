package com.williams.entry;

import com.williams.constants.ErrorMessage;
import com.williams.exception.InvalidInputFormatException;
import com.williams.exception.InvalidZipRangeException;
import com.williams.model.ZipRange;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * <p>
 * This class provides the functionality for user to talk to the application.
 * </p>
 * @author Ryan Yang
 * @since 1.0
 * @since 05/09/2019
 */
public class Messenger {

  private static final Logger logger = Logger.getLogger(Messenger.class);

  /**
   * <p>
   * Read from console, and create a list of valid ZipRange objects.
   * </p>
   * @return list of valid ZipRange objects.
   */
  public List<ZipRange> read() {
    
    List<ZipRange> ranges = null;

    Scanner scanner = new Scanner(System.in);
    boolean valid = false;
      
    while (!valid) {
      ranges = new ArrayList<>();
      
      logger.info("Please type a group of zip code pairs "
          + "in this format: ([ , ], [ , ], ..., [ , ])");
      
      String inStr = scanner.nextLine().trim();
      try {
        if (!inStr.startsWith("(") || !inStr.endsWith(")")) {
          throw new InvalidInputFormatException(ErrorMessage.INVALID_PARENTHESIS);
        } else {
          inStr = inStr.substring(1, inStr.length() - 1);
              
          int indexLeft = 0;
          int indexRight = 0;

          for (indexLeft = 0; indexLeft < inStr.length(); indexLeft++) {
            
            if (inStr.charAt(indexLeft) == '[') {
              for (indexRight = indexLeft + 1; indexRight < inStr.length(); indexRight++) {
                
                if (inStr.charAt(indexRight) == ']') {
                  
                  String subStr = inStr.substring(indexLeft + 1, indexRight);
                  String[] codePair = subStr.split(",");
                  
                  if (codePair.length != 2) {
                    throw new InvalidInputFormatException(ErrorMessage.UNPAIRED_INTEGERS);
                  }

                  try {
                    int code1 = Integer.parseInt(codePair[0].trim());
                    int code2 = Integer.parseInt(codePair[1].trim());
                    
                    ZipRange range = new ZipRange(code1, code2);
                    ranges.add(range);
                  } catch (NumberFormatException e) {
                    throw new InvalidInputFormatException(ErrorMessage.INVALID_INTEGER);
                  }
                  
                  indexLeft = indexRight;
                  break;
                } else if (inStr.charAt(indexRight) == '[') {
                  throw new InvalidInputFormatException(ErrorMessage.UNPAIRED_BRACKETS);
                }
              }
              
              if (inStr.charAt(indexLeft) == '[' && indexRight >= inStr.length()) {
                throw new InvalidInputFormatException(ErrorMessage.UNPAIRED_BRACKETS);
              }
            } else if (inStr.charAt(indexLeft) == ']') {
              throw new InvalidInputFormatException(ErrorMessage.UNPAIRED_BRACKETS);
            }
          }
          
          //validate every pair of zip codes.
          for (ZipRange e : ranges) {
            e.validate();
          }

          valid = true;    
        }
      } catch (InvalidInputFormatException e) {
        logger.error(e.fillInStackTrace());
      } catch (InvalidZipRangeException e) {
        logger.error(e.fillInStackTrace());
      }

    }
      
    scanner.close();
    return ranges;
  }
  
  /**
   * <p>
   * Write result to console.
   * </p>
   * @param ranges list of ZipRange objects
   */
  public void write(List<ZipRange> ranges) {
    StringBuffer sb = new StringBuffer();

    ranges.forEach(e -> {
      sb.append(e.toString()).append(", ");
    });

    String s = sb.toString();
    logger.info(s.substring(0, s.length() - 2));
  }
  
}
