package com.example.controller;

import com.example.exception.DefaultException;
import com.example.service.ParagraphAnalyzer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: Victor
 *
 * Controller for all the accounts processing, uses customer and
 * bankAccount repository, transaction aggregator to call
 * transaction service.
 */
@RestController
public class HelloController {

	@Autowired
	ParagraphAnalyzer paragraphAnalyzer;

	@GetMapping("/message/{username}")
	public String findAll(@PathVariable("username") String username) throws DefaultException {
		if(username == null)
			throw new DefaultException("user_not_found", "User was not found");
		return "Hello " + username;
	}

	@PostMapping("/paragraph/count")
	public Map<String, Integer> paragraphAnalyzerCount(@RequestBody String paragraph){
		return paragraphAnalyzer.countWords(paragraph);
	}

}
