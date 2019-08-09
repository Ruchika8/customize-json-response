package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFilter;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonFilter("greetingFilter")
public class MyClass {
private String greeting = "hello";
private String farewell = "bye";
private MyNestedClass nested = new MyNestedClass();
}
