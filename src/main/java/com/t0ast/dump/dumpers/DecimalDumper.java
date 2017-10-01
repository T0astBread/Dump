/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.dump.dumpers;

import com.t0ast.dump.Utils;
import java.util.function.Function;

/**
 *
 * @author T0astBread
 */
public class DecimalDumper extends BytewiseDumper
{
    public static final Function<Byte, String> toDecimalConverter = b ->
        Utils.fillNumberToDesiredLength(Integer.toUnsignedString(b), 3);
    
    public DecimalDumper()
    {
        super(toDecimalConverter);
    }
}
