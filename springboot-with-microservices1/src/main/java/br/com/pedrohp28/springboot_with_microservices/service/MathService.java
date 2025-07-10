package br.com.pedrohp28.springboot_with_microservices.service;

import br.com.pedrohp28.springboot_with_microservices.exception.UnsupportedMathOperationException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class MathService {
  public Double sum(
      @PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
      throws UnsupportedMathOperationException {

    if (!isNumeric(numberOne) || !isNumeric(numberTwo))
      throw new UnsupportedMathOperationException("Please set a numeric value!");

    return convertToDouble(numberOne) + convertToDouble(numberTwo);
  }

  public Double subtraction(String numberOne, String numberTwo)
      throws UnsupportedMathOperationException {

    if (!isNumeric(numberOne) || !isNumeric(numberTwo))
      throw new UnsupportedMathOperationException("Please set a numeric value!");

    return convertToDouble(numberOne) - convertToDouble(numberTwo);
  }

  public Double multiplication(String numberOne, String numberTwo)
      throws UnsupportedMathOperationException {

    if (!isNumeric(numberOne) || !isNumeric(numberTwo))
      throw new UnsupportedMathOperationException("Please set a numeric value!");

    return convertToDouble(numberOne) * convertToDouble(numberTwo);
  }

  public Double division(String numberOne, String numberTwo)
      throws UnsupportedMathOperationException {

    if (!isNumeric(numberOne) || !isNumeric(numberTwo))
      throw new UnsupportedMathOperationException("Please set a numeric value!");

    if (convertToDouble(numberTwo) == 0)
      throw new UnsupportedMathOperationException("The number can't divide by 0");
    return convertToDouble(numberOne) / convertToDouble(numberTwo);
  }

  public Double mean(String numberOne, String numberTwo) throws UnsupportedMathOperationException {

    if (!isNumeric(numberOne) || !isNumeric(numberTwo))
      throw new UnsupportedMathOperationException("Please set a numeric value!");

    return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
  }

  public Double squareRoot(String number) throws UnsupportedMathOperationException {

    if (!isNumeric(number))
      throw new UnsupportedMathOperationException("Please set a numeric value!");

    if (convertToDouble(number) < 0)
      throw new UnsupportedMathOperationException("Please set a positive numeric value!");
    return Math.sqrt(convertToDouble(number));
  }

  private Double convertToDouble(String strNumber) throws UnsupportedMathOperationException {
    if (strNumber == null || strNumber.isEmpty())
      throw new UnsupportedMathOperationException("Please set a numeric value!");
    String number = strNumber.replaceAll(",", ".");
    return Double.parseDouble(number);
  }

  private boolean isNumeric(String strNumber) {
    if (strNumber == null || strNumber.isEmpty()) return false;
    String number = strNumber.replaceAll(",", ".");
    return (number.matches("[-+]?[0-9]*\\.?[0-9]+"));
  }
}
