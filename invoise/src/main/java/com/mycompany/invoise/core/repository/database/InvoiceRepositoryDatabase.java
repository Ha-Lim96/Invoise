package com.mycompany.invoise.core.repository.database;

import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.repository.InvoiceRepositoryInterface;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class InvoiceRepositoryDatabase implements InvoiceRepositoryInterface {


    @Override
    public List<Invoice> list() {
        Invoice invoice1 = new Invoice();
        invoice1.setNumber("NUM_1");
        invoice1.setCustomerName("EDF");

        Invoice invoice2 = new Invoice();
        invoice2.setNumber("NUM_2");
        invoice2.setCustomerName("Energy");

        return List.of(invoice1, invoice2);
    }

    public void create(Invoice invoice){
        System.out.println("Invoice added with number " +invoice.getNumber()+" for "+invoice.getCustomerName());
    }

    @Override
    public Invoice getById(String number) {
        Invoice invoice1 = new Invoice();
        invoice1.setNumber(number);
        invoice1.setCustomerName("EDF");
        invoice1.setOrderNumber("ON_002");
        return invoice1;
    }

}
