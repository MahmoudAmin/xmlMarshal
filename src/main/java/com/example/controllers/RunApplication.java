package com.example.controllers;

/**
 * Created by mahmoud on 10/5/16.
 */
import java.io.IOException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class RunApplication {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        Converter converter = ctx.getBean(Converter.class);
        //Perform Marshaling
        Country country = new Country();
        country.setId(100);
        country.setCountryName("India");
        country.setPmName("ABC");
        converter.doMarshaling("country.xml", country);
        System.out.println("Marshaling performed");
        //Perform UnMarshaling
        country = (Country)converter.doUnMarshaling("country.xml");
        System.out.println("After UnMarshaling Data is: id:"+ country.getId()+", CountryName:"+country.getCountryName());
    }
}
