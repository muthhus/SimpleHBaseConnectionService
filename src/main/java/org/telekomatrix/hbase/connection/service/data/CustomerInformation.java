package org.telekomatrix.hbase.connection.service.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerInformation {

	private String firstName;
	private String lastName;
	private String role;
	private int age;
}
