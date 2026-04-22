package Bevarsalolistakezelo.vezerlo;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class HibaKezelo {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> futasiHiba(RuntimeException exception) {
        Map<String, String> valasz = new LinkedHashMap<>();
        valasz.put("hiba", exception.getMessage());
        return valasz;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> ervenyesitesiHiba(MethodArgumentNotValidException exception) {
        Map<String, String> valasz = new LinkedHashMap<>();
        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            valasz.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return valasz;
    }
}
