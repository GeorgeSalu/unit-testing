package br.com.springrest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.springrest.exceptions.UnsuportedMathOperationException;

@RestController
public class MathController {

	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double greeting(@PathVariable(value = "numberOne") String numberOne,@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("please set a numeric value");
		}
		
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}

	private Double convertToDouble(String numberOne) {
		if(numberOne == null) return 0D;
		String number = numberOne.replaceAll(",", ".");
		if(isNumeric(numberOne)) return Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String numberOne) {
		if(numberOne == null) return false;
		String number = numberOne.replaceAll(",",".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
	
}
