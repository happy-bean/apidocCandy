package org.happbean.candy.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.happbean.candy.apidoc.api.ApiGenerator;
import org.happbean.candy.apidoc.api.Generator;

/**
 * @author wgt
 * @date 2019-01-18
 * @description
 **/
@Mojo(name = "apicandy", defaultPhase = LifecyclePhase.PACKAGE)
public class ApiCandyMavenPlugin extends AbstractMojo {

    @Parameter(property = "args")
    private String args;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        System.out.println(args + "-----");
        if (args == null) {
            args = "candyconf.xml";
        }
        Generator generator = new ApiGenerator();
        generator.generate(args);
    }
}
