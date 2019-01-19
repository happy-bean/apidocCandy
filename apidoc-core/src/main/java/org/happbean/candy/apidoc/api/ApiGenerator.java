package org.happbean.candy.apidoc.api;

import org.happbean.candy.apidoc.code.parser.JavaFileParser;
import org.happbean.candy.apidoc.internal.system.JavaSystem;

/**
 * @author wgt
 * @date 2018-10-24
 * @description
 **/
public class ApiGenerator implements Generator {

    @Override
    public void generate(String xmlConfigPath, String targetFilePath) {

        GeneratedConf generatedConf = new GeneratedXmlConf(xmlConfigPath);
        generatedConf.generated();

        JavaSystem.JAVA_SOURCE.setTargetFilePath(targetFilePath);
        JavaFileParser.parse();
    }
}
