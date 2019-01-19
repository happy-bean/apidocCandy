package org.happbean.candy.apidoc.config.xml;

import org.happbean.candy.apidoc.config.xml.elements.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * @author wgt
 * @date 2018-09-25
 * @description
 **/
public class XmlConfFormatter {

    public static Object xmlToBean(String xmlPath, Class<?> load) {

        Object object = null;
        try {

            JAXBContext context = JAXBContext.newInstance(load);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            File file = new File(xmlPath);
            if(!file.exists()){
                //TODO
                System.out.println("文件不存在 ："+xmlPath);
            }
            object = unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return object;
    }

    public static CandyConfiguration parse(String xmlPath) {

        Object object = xmlToBean(xmlPath, CandyConfiguration.class);
        CandyConfiguration configuration = (CandyConfiguration) object;

        return configuration;
    }
}
