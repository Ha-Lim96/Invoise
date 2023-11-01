package com.mycompany.invoise;

import com.mycompany.invoise.controller.InvoiceControllerInterface;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;



@SpringBootApplication
public class App
{
    public static void main( String[] args )  {

        //ApplicationContext context = new AnnotationConfigApplicationContext(App.class);

        ApplicationContext context = SpringApplication.run(App.class, args);
        InvoiceControllerInterface invoiceController = context.getBean(InvoiceControllerInterface.class);
        invoiceController.createInvoice();

    }
}


