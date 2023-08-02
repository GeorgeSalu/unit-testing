package br.com.springrest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double greeting(@PathVariable(value = "numberOne") String numberOne,@PathVariable(value = "numberTwo") String numberTwo) {
		return 1D;
	}
	
}
