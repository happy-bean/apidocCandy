package org.happbean.candy.plugin;

/**
 * @author wgt
 * @date 2019-01-24
 * @description
 **/
public class ApiBanner implements Banner {

    Log log = null;

    @Override
    public void printBanner() {
        log.info("    _     ___   ___    ___     _     _  _   ___   __   __");
        log.info("\"   /_\\\\   | _ \\\\ |_ _|  / __|   /_\\\\   | \\\\| | |   \\\\  \\\\ \\\\ / /\"");
        log.info("\"  / _ \\\\  |  _/  | |  | (__   / _ \\\\  | .` | | |) |  \\\\ V /\"");
        log.info("\" /_/ \\\\_\\\\ |_|   |___|  \\\\___| /_/ \\\\_\\\\ |_|\\\\_| |___/    |_|  \"");
        log.info("                                                  v:1.0.0");
    }
}
