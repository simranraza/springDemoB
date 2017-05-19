/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springdemob.controllers;

/**
 *
 * @author zion
 */
import com.springdemob.common.LoginForm;
import com.springdemob.formvalidator.LoginFormValidator;
import com.springdemob.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {
    
    @Autowired
    LoginService loginService;
    
    @Autowired
    LoginFormValidator loginFormValidator;
    
    Logger logger = LoggerFactory.getLogger(MainController.class);
    
    //Set a form validator
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(loginFormValidator);
	}
    @RequestMapping(value="/index", method = RequestMethod.GET)
    public String viewHome(){
        return "index";
    }
    
    @RequestMapping(value="/loginsubmit",method=RequestMethod.POST)
    @ResponseBody
    public String LoginSubmit(@ModelAttribute ("loginForm") @Validated LoginForm loginForm, BindingResult result
    ,Model model){
        
        if (result.hasErrors()) {
			
			return "Form has following Errors: " + result.getFieldErrors().get(0).toString();
		} 
        logger.info("user name:" + loginForm.getUsername());
        logger.info("pass:" + loginForm.getPassword());
        String rval = loginService.Authenticate(loginForm);
        return rval;
    }
}
