package com.example.demo.model;

import lombok.Data;

@Data 	   
public class MyTargetClass {
	private String farewell = "bye";
	private MyNestedClass nested = new MyNestedClass();
}
