package com.mycompany.invoise;

import com.mycompany.invoise.controller.InvoiceControllerInterface;

import com.mycompany.invoise.controller.InvoiceControllerWeb;
import com.mycompany.invoise.repository.InvoiceRepositoryInterface;

import com.mycompany.invoise.service.InvoiceServiceInterface;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;


public class App 
{
    public static void main( String[] args )  {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        context.getBean(InvoiceControllerInterface.class).createInvoice();

    }
}
