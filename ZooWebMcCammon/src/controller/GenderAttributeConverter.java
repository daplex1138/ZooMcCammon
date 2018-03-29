package controller;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class GenderAttributeConverter implements AttributeConverter <String, Integer> {
	@Override
	public Integer convertToDatabaseColumn(String attribute) {
		int output = 0;
		switch (attribute.toLowerCase()) {
			case "male":
				output = 1;
				break;
			
			case "female":
				output = 2;
				break;
				
			default:
				System.out.println("Invalid gender.");
				break;
		}
		return output;
	}

	@Override
	public String convertToEntityAttribute(Integer dbData) {
		String output = "";
		switch (dbData) {
			case 1:
				output = "male";
				break;
			
			case 2:
				output = "female";
				break;
				
			default:
				System.out.println("Invalid gender type Id.");
				break;
		}
		return output;
	}

	
}