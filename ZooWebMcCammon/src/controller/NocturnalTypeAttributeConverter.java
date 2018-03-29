package controller;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class NocturnalTypeAttributeConverter implements AttributeConverter <Boolean, Integer> {
	@Override
	public Integer convertToDatabaseColumn(Boolean attribute) {
		int output = 0;
		if(attribute) {
				output = 1;
		}else {	
				output = 0;
		}	
		return output;
	}

	@Override
	public Boolean convertToEntityAttribute(Integer dbData) {
		Boolean output = null;
		if(dbData == 1) {
				output = true;
		}else if(dbData == 0) {
				output = false;
		}
		return output;
	}

	
}