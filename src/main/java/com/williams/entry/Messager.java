package com.williams.entry;

import com.williams.model.ZipRange;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <p>
 * This class provides the functionality for user to talk to the application.
 * </p>
 * @author Ryan Yang
 * @since 1.0
 * @since 05/09/2019
 */
public class Messager {

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
      
      System.out.println("Please type a group of zip code pairs "
          + "in this format: ([ , ], [ , ], ..., [ , ])");
      
      String inStr = scanner.nextLine().trim();
      try {
        if (!inStr.startsWith("(") || !inStr.endsWith(")")) {
          throw new Exception("Input should start with '(', "
            + "and end with ')'! Please try again.");
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
                    throw new Exception("One pair of brackets have two and "
                      + "only two integers separated by comma. Please try again.");
                  }
                  try {
                    int code1 = Integer.parseInt(codePair[0].trim());
                    int code2 = Integer.parseInt(codePair[1].trim());
                    
                    ZipRange range = new ZipRange(code1, code2);
                    ranges.add(range);
                  } catch (Exception e) {
                    throw new Exception("String cannot be converted into int. Please try again.");
                  }
                  
                  indexLeft = indexRight;
                  break;
                } else if (inStr.charAt(indexRight) == '[') {
                  throw new Exception("Unpaired brackets. Please try again");
                }
              }
              
              if (inStr.charAt(indexLeft) == '[' && indexRight >= inStr.length()) {
                throw new Exception("Unpaired brackets. Please try again");
              }
            } else if (inStr.charAt(indexLeft) == ']') {
              throw new Exception("Unpaired brackets. Please try again");
            }
          }
          
          //validate every pair of zip codes.
          ranges.forEach(e -> {
            e.validate();
          });
       
          valid = true;    
        }
      } catch (Exception e) {
        System.out.println(e.getMessage());
        valid = false;
      }

    }
      
    scanner.close();
    return ranges;
  }
  
}
