package com.mycompany.invoise.repository;

import com.mycompany.invoise.entity.Invoice;

import java.util.ArrayList;
import java.util.List;

public class InvoiceRepositoryMichel implements InvoiceRepositoryInterface{


    public void create(Invoice invoice){
        System.out.println("Invoice added with number " +invoice.getNumber()+" for "+invoice.getCustomerName());
    }



}
