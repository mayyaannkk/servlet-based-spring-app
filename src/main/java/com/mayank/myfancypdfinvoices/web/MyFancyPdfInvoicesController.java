package com.mayank.myfancypdfinvoices.web;

import com.mayank.myfancypdfinvoices.model.Invoice;
import com.mayank.myfancypdfinvoices.service.InvoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyFancyPdfInvoicesController {

    private final InvoiceService invoiceService;

    public MyFancyPdfInvoicesController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/invoices")
    // @RequestMapping(value = "/invoices", method = RequestMethod.GET)
    public List<Invoice> invoices() {
        return invoiceService.findAll();
    }

    @PostMapping("/invoices/{userId}/{amount}")
    public Invoice createInvoice(@PathVariable("userId") String userId, @PathVariable("amount") Integer amount) {
        return invoiceService.create(userId, amount);
    }
}
