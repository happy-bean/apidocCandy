package org.happbean.candy.apidoc.config.xml;

import org.happbean.candy.apidoc.config.xml.xmlpo.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * @author wgt
 * @date 2018-09-25
 * @description
 **/
public class XmlConfPaser {

    public static Object xmlToBean(String xmlPath, Class<?> load) {
        Object object = null;
        try {
            JAXBContext context = JAXBContext.newInstance(load);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            object = unmarshaller.unmarshal(new File(xmlPath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return object;
    }

    public static CandyConfiguration pase(String xmlPath) {
        Object object = xmlToBean(xmlPath, CandyConfiguration.class);
        CandyConfiguration configuration = (CandyConfiguration) object;
        return configuration;
    }
}
