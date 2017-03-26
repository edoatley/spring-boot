package edoatley.example.rest.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.fasterxml.jackson.annotation.JacksonAnnotation;

@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotation
public @interface JsonDateFormat {
   String value();
}
