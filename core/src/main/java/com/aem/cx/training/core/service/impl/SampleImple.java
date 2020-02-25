package com.aem.cx.training.core.service.impl;

import java.util.Dictionary;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.commons.osgi.OsgiUtil;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.cx.training.core.service.Sample;
//This is a component so it can provide or consume services
@SuppressWarnings("deprecation")
@Component(metatype=true, label="Sample demo", description="sample demo",immediate=true)
@Service(value=Sample.class)
public class SampleImple implements Sample {
    private static final Logger LOG = LoggerFactory.getLogger(SampleImple.class);
    
    //define the osgi config
    @Property(label="Sample Property - Name", description="This is sample name")
    public static final String SAMPLE_NAME = "property.sample.name";
    
    String sampleName;

    @Override
    public String getSample() {
        LOG.info("Started in getSample()");
        LOG.info("sampleName={}",sampleName);
        return sampleName;
    }
    
    //will be call when activate the component
    @Activate
    protected void activate(ComponentContext componentContext){
        LOG.info("Started in activate()");
        configure(componentContext.getProperties());
    }
    
    //will be call when deactivate the component
    @Deactivate
    protected void deactivate() {
        LOG.info("Started in deactivate()");
    }
    //get the osgi config by the config property name
    protected void configure(Dictionary<String, Object> dictionary) {
        LOG.info("Started in configure()");
        sampleName = OsgiUtil.toString(dictionary.get(SAMPLE_NAME), "default name");
    }

}
