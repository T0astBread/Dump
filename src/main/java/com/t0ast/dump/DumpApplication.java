/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.dump;

import static com.t0ast.dump.Main.DEFAULT_OUTPUT_FORMAT;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 *
 * @author T0astBread
 */
public class DumpApplication
{
    public void start(String[] args) throws ParseException, IOException, ReflectiveOperationException
    {
        CommandLine cli = parseCl(args);
        
        try(FileInputStream fileIn = new FileInputStream(cli.getOptionValue("f").trim()))
        {
            DumperManager manager = new DumperManager();
            manager.dump(fileIn, System.out, cli.getOptionValue("format", DEFAULT_OUTPUT_FORMAT).toUpperCase());
        }
    }
    
    private CommandLine parseCl(String[] args) throws ParseException
    {
        Options cliOptions = new Options();
        cliOptions.addRequiredOption("f", "file", true, "The file to dump");
        cliOptions.addOption("F", "format", true, "The output format. Possible values: hex, binary, bytes; Will default to " + DEFAULT_OUTPUT_FORMAT + ".");
        
        Options helpOptions = new Options();
        helpOptions.addOption("h", "help", false, "Displays a helptext");
        
        CommandLineParser cliParser = new DefaultParser();
        CommandLine helpCli = cliParser.parse(helpOptions, args, true);
        if(helpCli.hasOption("h"))
        {
            printHelpText(cliOptions);
            System.exit(0);
        }
        return cliParser.parse(cliOptions, args);
    }
    
    private void printHelpText(Options cliOptions)
    {
        HelpFormatter helpFormatter = new HelpFormatter();
        helpFormatter.printHelp("dump -f <FILE> [-F <hex|binary|decimal>]\n",
        "Dumps the content of a file in a specific format", cliOptions,
        "\nMade by T0astBread (twitter.com/t0astbread, github.com/t0astbread)");
    }
}
