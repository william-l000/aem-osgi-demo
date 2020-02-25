package com.aem.cx.training.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;






import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.aem.cx.training.core.service.SampleOsgi;


@Component(
    service=Servlet.class,
    immediate=true,
    property={
        "sling.servlet.paths=/bin/getPocOsgiData",
        "sling.servlet.methods=get"
    })
public class POCOsgiServlet extends SlingSafeMethodsServlet {

    /**
     * 
     */
    private static final long serialVersionUID = -9089205751030389450L;
    
    @Reference
    private SampleOsgi sample;
    
    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,
                    IOException {
        
        response.setContentType("text/plain");
        response.getWriter().write(sample.getSample());
        
    }

}
