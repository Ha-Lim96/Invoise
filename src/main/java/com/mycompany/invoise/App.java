package com.mycompany.invoise;

import com.mycompany.invoise.controller.InvoiceControllerInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class App 
{
    public static void main( String[] args )  {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.getBean(InvoiceControllerInterface.class).createInvoice();

    }
}


