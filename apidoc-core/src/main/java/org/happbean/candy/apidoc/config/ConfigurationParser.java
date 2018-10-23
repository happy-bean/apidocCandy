package org.happbean.candy.apidoc.config;

import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.IbatorConfigurationParser;
import org.mybatis.generator.config.xml.MyBatisGeneratorConfigurationParser;
import org.mybatis.generator.config.xml.ParserEntityResolver;
import org.mybatis.generator.config.xml.ParserErrorHandler;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.util.messages.Messages;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author wgt
 * @date 2018-09-23
 * @description
 **/
public class ConfigurationParser {

    private List<String> warnings;

    private List<String> parseErrors;

    private Properties extraProperties;

    public ConfigurationParser(List<String> warnings) {
        this((Properties) null, warnings);
    }

    public ConfigurationParser(Properties extraProperties, List<String> warnings) {
        this.extraProperties = extraProperties;
        if (warnings == null) {
            this.warnings = new ArrayList();
        } else {
            this.warnings = warnings;
        }

        this.parseErrors = new ArrayList();
    }

    public Configuration parseConfiguration(File inputFile) throws IOException, XMLParserException {
        FileReader fr = new FileReader(inputFile);
        return this.parseConfiguration((Reader) fr);
    }

    public Configuration parseConfiguration(Reader reader) throws IOException, XMLParserException {
        InputSource is = new InputSource(reader);
        return this.parseConfiguration(is);
    }

    public Configuration parseConfiguration(InputStream inputStream) throws IOException, XMLParserException {
        InputSource is = new InputSource(inputStream);
        return this.parseConfiguration(is);
    }

    private Configuration parseConfiguration(InputSource inputSource) throws IOException, XMLParserException {
        this.parseErrors.clear();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.setEntityResolver(new ParserEntityResolver());
            ParserErrorHandler handler = new ParserErrorHandler(this.warnings, this.parseErrors);
            builder.setErrorHandler(handler);
            Document document = null;

            try {
                document = builder.parse(inputSource);
            } catch (SAXParseException var9) {
                throw new XMLParserException(this.parseErrors);
            } catch (SAXException var10) {
                if (var10.getException() == null) {
                    this.parseErrors.add(var10.getMessage());
                } else {
                    this.parseErrors.add(var10.getException().getMessage());
                }
            }

            if (this.parseErrors.size() > 0) {
                throw new XMLParserException(this.parseErrors);
            } else {
                Element rootNode = document.getDocumentElement();
                DocumentType docType = document.getDoctype();
                Configuration config;
                if (rootNode.getNodeType() == 1 && docType.getPublicId().equals("-//Apache Software Foundation//DTD Apache iBATIS Ibator Configuration 1.0//EN")) {
                    config = this.parseIbatorConfiguration(rootNode);
                } else {
                    if (rootNode.getNodeType() != 1 || !docType.getPublicId().equals("-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN")) {
                        throw new XMLParserException(Messages.getString("RuntimeError.5"));
                    }

                    config = this.parseMyBatisGeneratorConfiguration(rootNode);
                }

                if (this.parseErrors.size() > 0) {
                    throw new XMLParserException(this.parseErrors);
                } else {
                    return config;
                }
            }
        } catch (ParserConfigurationException var11) {
            this.parseErrors.add(var11.getMessage());
            throw new XMLParserException(this.parseErrors);
        }
    }

    private Configuration parseIbatorConfiguration(Element rootNode) throws XMLParserException {
        IbatorConfigurationParser parser = new IbatorConfigurationParser(this.extraProperties);
        return parser.parseIbatorConfiguration(rootNode);
    }

    private Configuration parseMyBatisGeneratorConfiguration(Element rootNode) throws XMLParserException {
        MyBatisGeneratorConfigurationParser parser = new MyBatisGeneratorConfigurationParser(this.extraProperties);
        return parser.parseConfiguration(rootNode);
    }
}
