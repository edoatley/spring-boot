package edoatley.example.rest.util;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;

public class CustomLocalDateSerializer extends JsonSerializer<LocalDate> implements ContextualSerializer {

	private String format = "dd.MM.yyyy";

	public CustomLocalDateSerializer() {
		format = "dd.MM.yyyy";
	}
	
	public CustomLocalDateSerializer(String format) {
		this.format = format;
	}

	@Override
	public JsonSerializer<?> createContextual(SerializerProvider prov, BeanProperty beanProperty) throws JsonMappingException {
	    return new CustomLocalDateSerializer(beanProperty.getAnnotation(JsonDateFormat.class).value());
	}
	
	@Override
	public void serialize(LocalDate date, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
	    jsonGenerator.writeString(date.format(formatter));
	}

}
