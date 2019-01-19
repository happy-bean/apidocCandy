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
@Mojo(name = "generator", defaultPhase = LifecyclePhase.PACKAGE)
public class ApiCandyMavenPlugin extends AbstractMojo {

    @Parameter(property = "xmlFileName")
    private String xmlFileName;

    @Parameter(property = "apicandy.configFilePath",
            defaultValue = "${project.basedir}/src/main/resources", required = true)
    private String configurationFile;

    @Parameter(property = "apicandy.targetFilePath",
            defaultValue = "${project.basedir}/target/classes", required = true)
    private String targetFilePath;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        if (this.xmlFileName == null) {
            this.xmlFileName = "candyconf.xml";
        }
        try {
            String xmlConfigPath = this.configurationFile + "/" + this.xmlFileName;
            Generator generator = new ApiGenerator();
            generator.generate(xmlConfigPath,this.targetFilePath);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
