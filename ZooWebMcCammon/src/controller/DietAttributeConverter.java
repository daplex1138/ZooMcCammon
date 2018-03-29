package controller;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class DietAttributeConverter implements AttributeConverter <String, Integer> {
	@Override
	public Integer convertToDatabaseColumn(String attribute) {
		int output = 0;
		switch (attribute.toLowerCase()) {
			case "omnivore":
				output = 1;
				break;
			
			case "herbivore":
				output = 2;
				break;
				
			case "carnivore":
				output = 3;
				break;
				
			default:
				System.out.println("Invalid diet type.");
				break;
		}
		return output;
	}

	@Override
	public String convertToEntityAttribute(Integer dbData) {
		String output = "";
		switch (dbData) {
			case 1:
				output = "omnivore";
				break;
			
			case 2:
				output = "herbivore";
				break;
			case 3:
			output = "carnivore";
			break;
				
			default:
				System.out.println("Invalid diet type Id.");
				break;
		}
		return output;
	}

	
}