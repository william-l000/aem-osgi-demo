package com.aem.cx.training.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;

import com.aem.cx.training.core.service.Sample;


//@Component(service=Servlet.class,
@SuppressWarnings("deprecation")
//           property={
//                "sling.servlet.methods="+HttpConstants.METHOD_GET,
//                "sling.servlet.paths="+"/bin/getPocData",
//                "sling.servlet.resourceTypes="+"sling/servlet/default"
//           })
@SlingServlet(
                metatype = true,
                paths = {"/bin/getPocData"},
                methods = "GET",
                label = "Annotation Demo Servlet",
                description = "Sample servlet using Felix SCR annotations"
            )
public class POCServlet extends SlingSafeMethodsServlet {

    /**
     * 
     */
    private static final long serialVersionUID = -9089205751030389450L;
    
    @Reference
    private Sample sample;
    
    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException,
                    IOException {
        
        response.setContentType("text/plain");
        response.getWriter().write(sample.getSample());
        
    }

}
