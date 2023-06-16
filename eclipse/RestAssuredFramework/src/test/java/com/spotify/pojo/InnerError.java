
package com.spotify.pojo;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;
@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InnerError {

    @JsonProperty("status")
    private Integer status;
    @JsonProperty("message")
    private String message;
	
   
}
