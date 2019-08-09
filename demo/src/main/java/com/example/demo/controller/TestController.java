package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.MyClass;
import com.example.demo.model.MyTargetClass;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.google.gson.Gson;

@RestController
public class TestController {
	//@RestFilter
	@GetMapping("/get-response-from-advice")
	public ResponseEntity<Object>  response() {
		Gson gson = new Gson();
		Object myClass = gson.fromJson("{\r\n" + 
				"    \"greeting\": \"hello\",\r\n" + 
				"	\"farewell\": \"byesss\",\r\n" + 
				"    \"nested\": {\r\n" + 
				"        \"fname\": \"John\",\r\n" + 
				"		\"lname\":\"Smith\"\r\n" + 
				"    }\r\n" + 
				"}",MyTargetClass.class);
		
        return new ResponseEntity<>(myClass,HttpStatus.OK);
	}
	@GetMapping("/get-hello")
	public MappingJacksonValue  hello() {
		SimpleFilterProvider filterProvider = new SimpleFilterProvider();
		filterProvider.addFilter("greetingFilter",
		        SimpleBeanPropertyFilter.filterOutAllExcept("greeting","nested"))
		.addFilter("nameFilter",
		        SimpleBeanPropertyFilter.filterOutAllExcept("fname")); 
		MyClass myClass = new MyClass();
		MappingJacksonValue jacksonValue = new MappingJacksonValue(myClass);    
        jacksonValue.setFilters(filterProvider);
        System.out.println(jacksonValue);
        return jacksonValue;
	}
	
	@GetMapping("/get-hello2")
	public ResponseEntity<?> hello2() {
		return new ResponseEntity("hello", HttpStatus.OK);
	}
}
