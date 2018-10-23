package conf;

import org.happbean.candy.apidoc.config.xml.xmlpo.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author wgt
 * @date 2018-09-25
 * @description
 **/
public class Test {

    public static Object xmlToBean(String xmlPath, Class<?> load) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(load);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Object object = unmarshaller.unmarshal(new File(xmlPath));
        return object;
    }

    public static void main(String[] args) throws IOException, JAXBException {
        String xmlPath = "/Users/wgt/IdeaProjects/java/apidocCandy/apidoc-core/src/test/java/conf/candyconf.xml";
        Object object = xmlToBean(xmlPath, CandyConfiguration.class);
        CandyConfiguration configuration = (CandyConfiguration) object;
        Properties properties = configuration.getProperties();
        JdbcConnection connection = configuration.getJdbcConnection();

        List<Table> tables = configuration.getTables().getTables();

        System.out.println(tables.size());
        tables.stream().forEach(table -> {
            System.out.println(table.getTableName());
            List<Column> columns = table.getColumns();
            columns.stream().forEach(System.out::println);
        });
        System.out.println(properties.getResource());
        System.out.println(connection.getConnectionURL());
    }
}
