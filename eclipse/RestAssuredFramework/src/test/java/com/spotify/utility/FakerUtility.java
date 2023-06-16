package com.spotify.utility;
import com.github.javafaker.*;
public class FakerUtility {

 public static String generateName() {
	Faker faker = new Faker();
	return "PlayList" +faker.regexify("[a-z0-9-,]{36}");
 }
 
 
 
 public static String generateDescription() {
		Faker faker = new Faker();
		return "PlayList" +faker.regexify("[a-z0-9-,]{36}");
	 }
	 
 
 
 
}
