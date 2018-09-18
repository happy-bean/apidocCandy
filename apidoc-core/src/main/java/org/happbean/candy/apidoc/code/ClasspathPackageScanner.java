package org.happbean.candy.apidoc.code;


import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

/**
 * @author wgt
 * @date 2018-09-17
 * @description
 **/
public class ClasspathPackageScanner {

    public static List<Class<?>> getClasses(String packageName) {

        List<Class<?>> classes = new ArrayList<>();

        boolean recursive = true;

        String packageDirName = packageName.replace('.', '/');

        Enumeration<URL> dirs;
        try {
            dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);

            while (dirs.hasMoreElements()) {

                URL url = dirs.nextElement();

                String protocol = url.getProtocol();

                if ("file".equals(protocol)) {

                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");

                    findAndAddClassesInPackageByFile(packageName, filePath, recursive, classes);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return classes;
    }

    private static void findAndAddClassesInPackageByFile(String packageName, String packagePath, final boolean recursive, List<Class<?>> classes) {

        File dir = new File(packagePath);

        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }

        FileFilter fileFilter = (file) -> (recursive && file.isDirectory()) || (file.getName().endsWith(".class"));

        File[] dirfiles = dir.listFiles(fileFilter);

        Arrays.stream(dirfiles).forEach(file -> {

            if (file.isDirectory()) {
                findAndAddClassesInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), recursive, classes);
            } else {

                String className = file.getName().substring(0, file.getName().length() - 6);
                try {
                   
                    classes.add(Class.forName(packageName + '.' + className));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
