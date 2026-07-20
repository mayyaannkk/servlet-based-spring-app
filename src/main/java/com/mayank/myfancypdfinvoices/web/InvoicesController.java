package com.mayank.myfancypdfinvoices.web;

import com.mayank.myfancypdfinvoices.dto.InvoiceDto;
import com.mayank.myfancypdfinvoices.model.Invoice;
import com.mayank.myfancypdfinvoices.service.InvoiceService;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class InvoicesController {

    private final InvoiceService invoiceService;

    public InvoicesController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/invoices")
    // @RequestMapping(value = "/invoices", method = RequestMethod.GET)
    public List<Invoice> invoices() {
        return invoiceService.findAll();
    }

    @PostMapping("/invoices")
    public Invoice createInvoice(@RequestBody @Valid InvoiceDto invoiceDto) {
        return invoiceService.create(invoiceDto.getUserId(), invoiceDto.getAmount());
    }
}
