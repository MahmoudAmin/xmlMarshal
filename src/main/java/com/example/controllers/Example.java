package com.example.controllers;

/**
 * Created by mahmoud on 10/4/16.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.core.io.Resource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBContext;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;

@RestController
public class Example {

    @Autowired
    private Jaxb2Marshaller jaxb2Marshaller;
    @Value(value = "classpath:settings.xml")
    private Resource companiesXml;

    @RequestMapping("/test")
    public String home() {
        try{
            JAXBContext jc = JAXBContext.newInstance(Settings.class);
            jc.createUnmarshaller().unmarshal(new StreamSource(companiesXml.getInputStream()));

//            jaxb2Marshaller.setMappedClass(Settings.class);
//            jaxb2Marshaller.unmarshal(new StreamSource(companiesXml.getInputStream()));
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "Hello World!";
    }
}
