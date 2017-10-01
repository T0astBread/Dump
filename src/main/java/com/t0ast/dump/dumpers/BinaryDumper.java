/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.dump.dumpers;

import com.t0ast.dump.Utils;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author T0astBread
 */
public class BinaryDumper extends BytewiseDumper
{
//    public static final Function<Byte, String> toBinaryConverter = b ->
//    {
//        StringBuilder strB = new StringBuilder();
//        do
//        {
//            strB.append(b%2);
//            b = (byte) (b/2);
//        } while(b > 0);
//        return strB.toString();
//    };
    
    public static final Function<Byte, String> toBinaryConverter = b ->
        Utils.fillNumberToDesiredLength(Integer.toBinaryString(Byte.toUnsignedInt(b)), 8);
    
    public BinaryDumper()
    {
        super(toBinaryConverter);
    }
}
