package controller;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class SkinTypeAttributeConverter implements AttributeConverter <String, Integer> {

	@Override
	public Integer convertToDatabaseColumn(String attribute) {
		int output = 0;
		switch (attribute.toLowerCase()) {
			case "scales":
				output = 1;
				break;
			
			case "shell":
				output = 2;
				break;
				
			default:
				System.out.println("Invalid skin type.");
				break;
		}
		return output;
	}

	@Override
	public String convertToEntityAttribute(Integer dbData) {
		String output = "";
		switch (dbData) {
			case 1:
				output = "scales";
				break;
			
			case 2:
				output = "skin";
				break;
				
			default:
				System.out.println("Invalid skin type Id.");
				break;
		}
		return output;
	}

}