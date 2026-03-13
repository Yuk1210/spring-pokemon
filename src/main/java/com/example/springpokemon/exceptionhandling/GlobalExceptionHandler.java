package com.example.springpokemon.exceptionhandling;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ModelAndView handleNotFound(NoSuchElementException e) {
        return new ModelAndView("error-pages/404");
    }

    @ExceptionHandler(SQLException.class)
    public ModelAndView handleDatabase(SQLException e) {
        return new ModelAndView("error-pages/500");
    }
}
