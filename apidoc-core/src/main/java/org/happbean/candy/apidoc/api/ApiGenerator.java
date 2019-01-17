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
public class ApiGenerator {

    public static void main(String[] args) throws IOException {
        File files = new File(ApiGenerator.class.getResource("/").getPath());
        String projectPath = files.getAbsolutePath();


        String xmlFileName = "candyconf.xml";
        GeneratedConf generatedConf = new GeneratedXmlConf(xmlFileName,projectPath);
        generatedConf.generated();

        String classPath = JdbcSystem.JDBC_CONNECTION.getClassPath();

        System.out.println(classPath);

        JavaFileParser.parse();
    }


}
