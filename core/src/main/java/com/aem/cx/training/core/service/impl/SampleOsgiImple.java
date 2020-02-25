package com.aem.cx.training.core.service.impl;


import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.cx.training.core.service.SampleOsgi;

@Designate(ocd=SampleOsgiImple.Config.class)
@Component(
    service=SampleOsgi.class,
    immediate=true
)
public class SampleOsgiImple implements SampleOsgi {
    private static final Logger LOG = LoggerFactory.getLogger(SampleOsgiImple.class);
    
    //define osgi config
    @ObjectClassDefinition(name="Sample osgi demo",description="Sample osgi demo")
    public static @interface Config {
        @AttributeDefinition(name="Sample osgi Property - Name",
                        description="This is osgi Sample Property - Name")
        String property_sample_name() default "default osgi name";
    }
    
    String sampleName;

    @Override
    public String getSample() {
        LOG.info("Started in getSample()");
        return sampleName;
    }
    
    //will be call when activate the component
    @Activate
    protected void activate(final Config config){
        LOG.info("Started in activate()");
        configure(config);
    }
    //will be call when deactivate the component
    @Deactivate
    protected void deactivate() {
        LOG.info("Started in deactivate()");
    }
    //get the osgi config value
    protected void configure(Config config) {
        LOG.info("Started in configure()");
        sampleName = config.property_sample_name();
    }

}
