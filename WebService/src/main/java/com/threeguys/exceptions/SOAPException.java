package com.threeguys.exceptions;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mint
 */
public class SOAPException extends Exception{
    public SOAPException(String errorMessage) {
        super(errorMessage);
    }
}
