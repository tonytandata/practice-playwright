package org.tonyyjt.properties;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources("file:src/main/resources/${env}_environment.properties" )
public interface EnvironmentProperties extends Config {
    String url();
    String url2();

    String username();

    String password();
}
