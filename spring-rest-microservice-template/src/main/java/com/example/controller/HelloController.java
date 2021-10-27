package com.example.controller;

import com.example.exception.DefaultException;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Victor
 *
 * Controller for all the accounts processing, uses customer and
 * bankAccount repository, transaction aggregator to call
 * transaction service.
 */
@RestController
public class HelloController {

	@GetMapping("/message/{username}")
	public String findAll(@PathVariable("username") String username) throws DefaultException {
		if(username == null)
			throw new DefaultException("user_not_found", "User was not found");
		return "Hello " + username;
	}

}
