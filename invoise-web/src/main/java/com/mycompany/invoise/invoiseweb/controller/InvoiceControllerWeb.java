package com.mycompany.invoise.invoiseweb.controller;

import com.mycompany.invoise.core.controller.InvoiceControllerInterface;
import com.mycompany.invoise.core.entity.Invoice;

import com.mycompany.invoise.core.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/invoice")
public class InvoiceControllerWeb implements InvoiceControllerInterface {

    @Autowired
    private final InvoiceServiceInterface invoiceService;

    public InvoiceControllerWeb(InvoiceServiceInterface invoiceService) {
        this.invoiceService = invoiceService;
    }

    public InvoiceServiceInterface getInvoiceService() {
        return invoiceService;
    }

    public void createInvoice(){
        String customerName = "Tesla";
        Invoice invoice = new Invoice();
        invoice.setCustomerName(customerName);
        invoiceService.createInvoice(invoice);
    }


    @RequestMapping("/home")
    public String displayHome(Model model){
        System.out.println("La méthode displayHome a été appelé");
        model.addAttribute("invoices", invoiceService.getInvoiceList());
        return "invoice-home";
    }

    @RequestMapping("/{id}")
    public String detailsInvoice(@PathVariable("id")String number, Model model){
        System.out.println("La méthode displayInvoice a été invoqué");
        model.addAttribute("invoice", invoiceService.getInvoiceByNumber(number));
        return "invoice-details";
    }



}
