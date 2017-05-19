/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springdemob.service;

import com.springdemob.common.LoginForm;

/**
 *
 * @author zion
 */
public interface LoginService {
    public String Authenticate(LoginForm loginForm);
}
