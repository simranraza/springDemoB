/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springdemob.service;

import com.springdemob.common.LoginForm;
import com.springdemob.dao.UsersDao;
import com.springdemob.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author zion
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UsersDao usersDao;
    
    @Override
    public String Authenticate(LoginForm loginForm) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Users user = usersDao.findByUserName(loginForm.getUsername());
        
        if (user.getPassword() == null ? loginForm.getPassword() == null : user.getPassword().equals(loginForm.getPassword()))
            return "LOGIN_SUCCESSFUL";
        else
            return "LOGIN_NOT_SUCCESSFUL";
    }
    
}
