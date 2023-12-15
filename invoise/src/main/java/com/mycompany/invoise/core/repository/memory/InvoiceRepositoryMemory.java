package com.mycompany.invoise.core.repository.memory;

import com.mycompany.invoise.core.entity.Invoice;
import com.mycompany.invoise.core.repository.InvoiceRepositoryInterface;

import java.util.ArrayList;
import java.util.List;

//@Repository
public class InvoiceRepositoryMemory implements InvoiceRepositoryInterface {

    private static List<Invoice> invoices = new ArrayList<>();

    @Override
    public Invoice create(Invoice invoice) {
        invoices.add(invoice);
        System.out.println("Invoice added with number " +invoice.getNumber()+" for "+invoice.getCustomerName());
        return invoice;
    }

    @Override
    public List<Invoice> list() {
        return (List<Invoice>) new UnsupportedOperationException();
    }

    @Override
    public Invoice getById(String number) {
        return null;
    }
}


