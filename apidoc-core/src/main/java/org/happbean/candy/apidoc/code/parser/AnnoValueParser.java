package org.happbean.candy.apidoc.code.parser;

/**
 * @author wgt
 * @date 2018-09-20
 * @description
 **/
public class AnnoValueParser {

    private final Object annotation;

    public AnnoValueParser(Object annotation) {
        this.annotation = annotation;
    }

    public void parseAnnoValue() throws NullPointerException {

        if (this.annotation == null) {
            throw new NullPointerException();
        }

        Parser parser = ApiParser.getParser(this.annotation);
        parseValue(parser);

    }

    private void parseValue(Parser parser) {

        //parser.parseValue();
    }
}
