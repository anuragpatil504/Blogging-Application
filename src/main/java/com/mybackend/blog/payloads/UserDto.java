package com.mybackend.blog.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlInlineBinaryData;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@NoArgsConstructor
@Getter
@Setter

public class UserDto {
	
	private int id;
	@NotEmpty
	@Size(min=4,message="Username must have minimum 4 characters")
	private String name;
	@Email(message="Enter valid email address")
	private String email;
	@NotEmpty
	@Size(min=3,max=10,message="Password must be between 3 and 10 characters")
	private String password;
	@NotEmpty
	private String about;
}
