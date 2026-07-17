package com.mayank.myfancypdfinvoices.service;

import com.mayank.myfancypdfinvoices.context.Application;
import com.mayank.myfancypdfinvoices.model.Invoice;
import com.mayank.myfancypdfinvoices.model.User;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InvoiceService {

    List<Invoice> invoices = new CopyOnWriteArrayList<>();

    public List<Invoice> findAll() {
        return invoices;
    }

    public Invoice create(String userId, Integer amount) {
        User user = Application.userService.findById(userId);
        if(user == null) {
            throw new IllegalStateException();
        }

        Invoice invoice = new Invoice(userId, amount, "http://www.africau.edu/images/default/sample.pdf");
        System.out.println(invoices);
        invoices.add(invoice);
        return invoice;
    }
}
