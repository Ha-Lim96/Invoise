package com.mycompany.invoise.repository;

import com.mycompany.invoise.entity.Invoice;
import org.springframework.stereotype.Repository;


@Repository
public class InvoiceRepositoryDatabase implements InvoiceRepositoryInterface{


    public void create(Invoice invoice){
        System.out.println("Invoice added with number " +invoice.getNumber()+" for "+invoice.getCustomerName());
    }

}
