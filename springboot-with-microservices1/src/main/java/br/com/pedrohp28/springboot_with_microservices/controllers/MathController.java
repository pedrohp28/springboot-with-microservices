package br.com.pedrohp28.springboot_with_microservices.controllers;

import br.com.pedrohp28.springboot_with_microservices.exception.UnsupportedMathOperationException;
import br.com.pedrohp28.springboot_with_microservices.service.MathService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

  final MathService service;

  public MathController(MathService service) {
    this.service = service;
  }

  @RequestMapping("/sum/{numberOne}/{numberTwo}")
  public Double sum(
      @PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
      throws UnsupportedMathOperationException {

    return service.sum(numberOne, numberTwo);
  }

  @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
  public Double subtraction(
      @PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
      throws UnsupportedMathOperationException {

    return service.subtraction(numberOne, numberTwo);
  }

  @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
  public Double multiplication(
      @PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
      throws UnsupportedMathOperationException {

    return service.multiplication(numberOne, numberTwo);
  }

  @RequestMapping("/division/{numberOne}/{numberTwo}")
  public Double division(
      @PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
      throws UnsupportedMathOperationException {

    return service.division(numberOne, numberTwo);
  }

  @RequestMapping("/mean/{numberOne}/{numberTwo}")
  public Double mean(
      @PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
      throws UnsupportedMathOperationException {

    return service.mean(numberOne, numberTwo);
  }

  @RequestMapping("/square-root/{number}")
  public Double squareRoot(@PathVariable("number") String number)
      throws UnsupportedMathOperationException {

    return service.squareRoot(number);
  }
}
