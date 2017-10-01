/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.dump;

import com.t0ast.dump.dumpers.Dumper;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 *
 * @author T0astBread
 */
public class DumperManager
{
    public void dump(InputStream in, OutputStream out, String format) throws IOException, ReflectiveOperationException
    {
        dump(in, out, OutputFormat.valueOf(format));
    }
    
    public void dump(InputStream in, OutputStream out, OutputFormat format) throws IOException, ReflectiveOperationException
    {
        try(Writer outWr = new OutputStreamWriter(out); InputStream inStr = in)
        {
            Dumper dumperToUse = (Dumper) Class.forName("com.t0ast.dump.dumpers." + Utils.firstToUpperCase(format.toString()) + "Dumper").newInstance();
            dumperToUse.dump(in, outWr);
        }
    }
    
    public static enum OutputFormat
    {
        BINARY, DECIMAL, HEX
    }
}
