/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cvasquez.properties;

import java.io.InputStream;

/**
 *
 * @author NewBie
 */
public class ConfigProperties {
    public static InputStream getResourceAsInputStrings(String name){
        return ConfigProperties.class.getResourceAsStream(name);
    }
}
