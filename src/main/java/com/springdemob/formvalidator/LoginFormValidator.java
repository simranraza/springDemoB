/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springdemob.formvalidator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.springdemob.common.LoginForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.ValidationUtils;

/**
 *
 * @author zion
 */
@Component
public class LoginFormValidator implements Validator{

    @Override
    public boolean supports(Class<?> type) {
        
        return LoginForm.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        
        LoginForm loginForm = (LoginForm) o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty.loginForm.username");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.loginForm.password");
    }
    
}
