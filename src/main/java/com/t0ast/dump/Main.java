package com.t0ast.dump;

import java.io.IOException;
import org.apache.commons.cli.ParseException;

public class Main
{
    public static final String DEFAULT_OUTPUT_FORMAT = "binary";

    /**
     * @param args the command line arguments
     * @throws org.apache.commons.cli.ParseException
     * @throws java.io.IOException
     * @throws java.lang.ReflectiveOperationException
     */
    public static void main(String[] args) throws ParseException, IOException, ReflectiveOperationException
    {
        new DumpApplication().start(args);
    }
}
