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
public class HexDumper extends BytewiseDumper
{
    public static final Function<Byte, String> toHexConverter = b ->
        Utils.fillNumberToDesiredLength(Integer.toHexString(Byte.toUnsignedInt(b)), 2);
    
    public HexDumper()
    {
        super(toHexConverter);
    }
}
