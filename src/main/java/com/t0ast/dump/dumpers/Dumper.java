/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.t0ast.dump.dumpers;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;

/**
 *
 * @author T0astBread
 */
public interface Dumper
{
    void dump(InputStream in, Writer out) throws IOException;
}
