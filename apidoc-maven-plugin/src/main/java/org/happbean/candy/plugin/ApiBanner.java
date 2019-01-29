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
        System.out.println("    _     ___   ___    ___     _     _  _   ___   __   __");
        System.out.println("   /_\\   | _ \\ |_ _|  / __|   /_\\   | \\| | |   \\  \\ \\ / /");
        System.out.println("  / _ \\  |  _/  | |  | (__   / _ \\  | .` | | |) |  \\ V /");
        System.out.println(" /_/ \\_\\ |_|   |___|  \\___| /_/ \\_\\ |_|\\_| |___/    |_|");
        System.out.println("                                                  v:1.0.0");
        System.out.println("");
    }
}
