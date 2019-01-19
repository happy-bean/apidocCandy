package org.happbean.candy.apidoc.api;

import org.happbean.candy.apidoc.code.parser.JavaFileParser;
import org.happbean.candy.apidoc.internal.system.JdbcSystem;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author wgt
 * @date 2018-10-24
 * @description
 **/
public class ApiGenerator implements Generator {

    @Override
    public void generate(String xmlConfigPath) {

        GeneratedConf generatedConf = new GeneratedXmlConf(xmlConfigPath);
        generatedConf.generated();

        JavaFileParser.parse();
    }

    public static void main(String[] args) {


        new ApiGenerator().generate("candyconf.xml");
    }
}
