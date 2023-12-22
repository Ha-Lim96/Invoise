package com.mycompany.invoise.invoice.api;

import com.mycompany.invoise.core.entity.customer.Customer;
import com.mycompany.invoise.core.entity.invoice.Invoice;
import com.mycompany.invoise.invoice.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceResource {


    @Autowired
    private final InvoiceServiceInterface invoiceService;

    @Autowired
    private RestTemplate restTemplate;

    public InvoiceResource(InvoiceServiceInterface invoiceService, RestTemplate restTemplate) {
        this.invoiceService = invoiceService;
        this.restTemplate = restTemplate;
    }

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    @GetMapping
    public Iterable<Invoice> list(){
        System.out.println("La méthode displayHome a été appelé");
        Iterable<Invoice> invoices = invoiceService.getInvoiceList();
        invoices.forEach(invoice-> {
            invoice.setCustomer(restTemplate.getForObject("http://localhost:8083/customer/"+invoice.getIdCustomer(), Customer.class));
        });
        return invoices;
    }

    @GetMapping("/{id}")
    public Invoice get(@PathVariable("id")String number){
        System.out.println("La méthode displayInvoice a été invoqué");
        Invoice invoice = invoiceService.getInvoiceByNumber(number);
        invoice.setCustomer(restTemplate.getForObject("http://localhost:8083/customer/"+invoice.getIdCustomer(), Customer.class));
        return invoice;
    }



    /*
    @PostMapping("")
    public Invoice create(@RequestBody Invoice invoice){
        return invoiceService.createInvoice(invoice);
    }


     /*
    @GetMapping("/create-form")
    public String displayInvoiceCreateForm(@ModelAttribute InvoiceForm invoice){
        return "invoice-create-form";
    }
    */


}
