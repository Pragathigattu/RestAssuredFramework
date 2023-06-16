package com.spotify.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
public class Person {
	 @Getter Integer id;
	
	@Getter @Setter String name;

}
