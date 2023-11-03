package com.mycompany.invoise.service.prefix;

import com.mycompany.invoise.entity.Invoice;
import com.mycompany.invoise.repository.InvoiceRepositoryInterface;
import com.mycompany.invoise.service.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServicePrefix implements InvoiceServiceInterface {

    @Value("${invoice.lastNumber}")
    private  long lastNumber;

    @Value("${invoice.prefix}")
    private String prefix;

    @Autowired
    private final InvoiceRepositoryInterface invoiceRepository;


    public InvoiceServicePrefix(InvoiceRepositoryInterface invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public long getLastNumber() {
        return lastNumber;
    }

    public void setLastNumber(long lastNumber) {
        this.lastNumber = lastNumber;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public InvoiceRepositoryInterface getInvoiceRepository() {
        return invoiceRepository;
    }

    public void createInvoice(Invoice invoice){
        invoice.setNumber(String.valueOf(prefix+(++lastNumber)));
        invoiceRepository.create(invoice);
    }

    @Override
    public List<Invoice> getInvoiceList() {
        return invoiceRepository.list();
    }
}
