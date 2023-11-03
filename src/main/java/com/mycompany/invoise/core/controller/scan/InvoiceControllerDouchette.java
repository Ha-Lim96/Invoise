package com.mycompany.invoise.core.controller.scan;

import com.mycompany.invoise.core.controller.InvoiceControllerInterface;
import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.service.InvoiceServiceInterface;

//@Controller
public class InvoiceControllerDouchette implements InvoiceControllerInterface {


    private final InvoiceServiceInterface invoiceService;

    public InvoiceControllerDouchette(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }


    @Override
    public void createInvoice() {
        System.out.println("Usage of Scanner");

        Invoice invoice = new Invoice();
        invoice.setCustomerName("Virgin Galactic");
        invoiceService.createInvoice(invoice);

    }
}
