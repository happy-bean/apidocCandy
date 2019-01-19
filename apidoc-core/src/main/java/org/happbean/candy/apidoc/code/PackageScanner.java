package org.happbean.candy.apidoc.code;


import org.happbean.candy.apidoc.code.parser.ApiChecker;
import org.happbean.candy.apidoc.internal.factory.ObjectFactory;
import org.happbean.candy.apidoc.internal.load.JavaClassloader;
import org.happbean.candy.apidoc.internal.system.JavaSystem;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wgt
 * @date 2018-09-17
 * @description
 **/
public class PackageScanner {

    public static List<Class<?>> getApiClasses(String packageName) {

        List<Class<?>> classes = new ArrayList<>();
        // 是否循环迭代
        boolean recursive = true;

        // 获取包的名字 并进行替换
        String packageDirName = packageName.replace('.', '/');

        String filePath = JavaSystem.JAVA_SOURCE.getTargetFilePath() + "/" + packageDirName;

        try {
            JavaClassloader.loadClass(JavaSystem.JAVA_SOURCE.getTargetFilePath());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        findApiClassesInPackageByFile(packageName, filePath, recursive, classes);

//        // 定义一个枚举的集合 并进行循环来处理这个目录下的things
//        Enumeration<URL> dirs;
//        try {
//            dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
//            // 循环迭代下去
//            while (dirs.hasMoreElements()) {
//                // 获取下一个元素
//                URL url = dirs.nextElement();
//                // 得到协议的名称
//                String protocol = url.getProtocol();
//                // 如果是以文件的形式保存在服务器上
//                if ("file".equals(protocol)) {
//                    // 获取包的物理路径
//                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
//                    // 以文件的方式扫描整个包下的文件 并添加到集合中
//                    findApiClassesInPackageByFile(packageName, filePath, recursive, classes);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        return classes;
    }

    private static void findApiClassesInPackageByFile(String packageName, String packagePath, final boolean recursive, List<Class<?>> classes) {
        // 获取此包的目录 建立一个File
        File dir = new File(packagePath);
        // 如果不存在或者 也不是目录就直接返回
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }

        FileFilter fileFilter = (file) -> (recursive && file.isDirectory()) || (file.getName().endsWith(".class"));

        // 如果存在 就获取包下的所有文件 包括目录
        File[] dirfiles = dir.listFiles(fileFilter);

        Arrays.stream(dirfiles).forEach(file -> {
            // 如果是目录 则继续扫描
            if (file.isDirectory()) {
                findApiClassesInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), recursive, classes);
            } else {
                // 如果是java类文件 去掉后面的.java 只留下类名
                String className = file.getName().substring(0, file.getName().length() - 6);
                try {
                    // 添加到集合中去
                    Class<?> clazz = ObjectFactory.externalClassForName(packageName + '.' + className);
                    //先判断是不是 api class
                    if (ApiChecker.isApiClass(clazz)) {
                        classes.add(clazz);
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
