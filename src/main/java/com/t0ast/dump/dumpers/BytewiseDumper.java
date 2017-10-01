/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.dump.dumpers;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.function.Function;

/**
 *
 * @author T0astBread
 */
public class BytewiseDumper implements Dumper
{
    private Function<Byte, String> byteToStringConverter;

    public BytewiseDumper(Function<Byte, String> byteToStringConverter)
    {
        this.byteToStringConverter = byteToStringConverter;
    }
    
    @Override
    public void dump(InputStream in, Writer out) throws IOException
    {
        byte b;
        while(true)
        {
            b = (byte) in.read();
            if(b == -1) break;
            out.write(this.byteToStringConverter.apply(b));
        }
        out.flush();
    }
}
