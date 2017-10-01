/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.dump;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author T0astBread
 */
public class Utils
{
    public static String firstToUpperCase(String str)
    {
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
    
    public static String fillToDesiredLength(String str, String fillerChar, int desiredLength)
    {
        if(str.length() < desiredLength) str = Stream.generate(() -> fillerChar).limit(desiredLength - str.length()).collect(Collectors.joining()) + str;
        return str;
    }
    
    public static String fillNumberToDesiredLength(String numberStr, int desiredLength)
    {
        return fillToDesiredLength(numberStr, "0", desiredLength);
    }
}
