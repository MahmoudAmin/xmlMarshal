package com.example.controllers;

/**
 * Created by mahmoud on 10/4/16.
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.oxm.castor.CastorMarshaller;

@Configuration
@EnableAutoConfiguration
@ComponentScan(value = "com.example.controllers")
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
    /**
     * Shared JAXB marshaller/unmarshaller instance
     * @return The marshaller/unmarshaller instance
     */
    @Bean
    public Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//        marshaller.setMtomEnabled(true);
//        marshaller.setContextPath("com.example.controllers");
        marshaller.setPackagesToScan("com.example.controllers");
        return marshaller;
    }
    @Bean
    public Converter getHandler(){
        Converter handler= new Converter();
        handler.setMarshaller(getCastorMarshaller());
        handler.setUnmarshaller(getCastorMarshaller());
        return handler;
    }
    @Bean
    public CastorMarshaller getCastorMarshaller() {
        CastorMarshaller castorMarshaller = new CastorMarshaller();
        Resource resource = new ClassPathResource("mapping.xml");
        castorMarshaller.setMappingLocation(resource);
        return castorMarshaller;
    }

}