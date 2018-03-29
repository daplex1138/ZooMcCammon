package controller;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class AnimalTypeAttributeConverter implements AttributeConverter <String, Integer> {
	@Override
	public Integer convertToDatabaseColumn(String attribute) {
		int output = 0;
		switch (attribute.toLowerCase()) {
			case "mammal":
				output = 1;
				break;
			
			case "reptile":
				output = 2;
				break;
				
			default:
				System.out.println("Invalid animal type.");
				break;
		}
		return output;
	}

	@Override
	public String convertToEntityAttribute(Integer dbData) {
		String output = "";
		switch (dbData) {
			case 1:
				output = "mammal";
				break;
			
			case 2:
				output = "reptile";
				break;
				
			default:
				System.out.println("Invalid animal type Id.");
				break;
		}
		return output;
	}

	
}