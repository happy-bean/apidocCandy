package org.happbean.candy.apidoc.api;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author wgt
 * @date 2018-10-24
 * @description
 **/
public class ApiGenerator {

    public static void main(String[] args) throws IOException {
        File file4 = new File(ApiGenerator.class.getResource("/").getPath());
        System.out.println(file4.getAbsolutePath());
        System.out.println();
        Arrays.stream(file4.listFiles()).forEach(file -> {
            System.out.println(file.getName());
        });
        System.out.println(ApiGenerator.class.getResource("/").toString());

        String path2 = Thread.currentThread().getContextClassLoader().getResource("/").getPath();

        System.out.println(path2);
    }


}
