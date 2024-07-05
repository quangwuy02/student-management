package org.example.huydq.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(String string) {
        super(string);
    }
    public StudentNotFoundException(){
        super("Student Not Found");
    }
}
