package com.mycompany.invoise;

import com.mycompany.invoise.controller.InvoiceControllerKeyboard;
import com.mycompany.invoise.controller.InvoiceControllerDouchette;
import com.mycompany.invoise.controller.InvoiceControllerWeb;
import com.mycompany.invoise.repository.InvoiceRepository;
import com.mycompany.invoise.repository.InvoiceRepositoryMichel;
import com.mycompany.invoise.service.InvoiceServiceNumber;
import com.mycompany.invoise.service.InvoiceServicePrefix;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println("Dans quelle configuration êtes vous ? ");
        Scanner sc = new Scanner(System.in);
        int configuration = sc.nextInt();

        if(configuration == 1){

            InvoiceControllerKeyboard invoiceController = new InvoiceControllerKeyboard();
            InvoiceServiceNumber invoiceService = new InvoiceServiceNumber();
            InvoiceRepository invoiceRepository = new InvoiceRepository();
            invoiceController.setInvoiceService(invoiceService);
            invoiceService.setInvoiceRepository(invoiceRepository);
            invoiceController.createInvoice();

        } else if (configuration == 2){

            InvoiceControllerWeb invoiceController = new InvoiceControllerWeb();
            InvoiceServicePrefix invoiceService = new InvoiceServicePrefix();
            InvoiceRepositoryMichel invoiceRepository = new InvoiceRepositoryMichel();
            invoiceController.setInvoiceService(invoiceService);
            invoiceService.setInvoiceRepository(invoiceRepository);
            invoiceController.createInvoice();

        } else if (configuration == 3){

            InvoiceControllerWeb invoiceController = new InvoiceControllerWeb();
            InvoiceServiceNumber invoiceService = new InvoiceServiceNumber();
            InvoiceRepositoryMichel invoiceRepository = new InvoiceRepositoryMichel();
            invoiceController.setInvoiceService(invoiceService);
            invoiceService.setInvoiceRepository(invoiceRepository);
            invoiceController.createInvoice();

        } else if (configuration == 4){

            InvoiceControllerDouchette invoiceController = new InvoiceControllerDouchette();
            InvoiceServiceNumber invoiceService = new InvoiceServiceNumber();
            InvoiceRepositoryMichel invoiceRepository = new InvoiceRepositoryMichel();
            invoiceController.setInvoiceService(invoiceService);
            invoiceService.setInvoiceRepository(invoiceRepository);
            invoiceController.createInvoice();

        }
    }
}
