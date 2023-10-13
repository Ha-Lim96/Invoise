package com.mycompany.invoise.controller;

import com.mycompany.invoise.entity.Invoice;

import com.mycompany.invoise.service.InvoiceServiceInterface;
import com.mycompany.invoise.service.InvoiceServiceMichel;

import java.util.Scanner;

public class InvoiceControllerMichel implements InvoiceControllerInterface{

    private InvoiceServiceInterface invoiceService;

    public void createInvoice(){

        String customerName = "Tesla";
        Invoice invoice = new Invoice();
        invoice.setCustomerName(customerName);

        InvoiceServiceMichel invoiceService = new InvoiceServiceMichel();
        invoiceService.createInvoice(invoice);
    }
}
