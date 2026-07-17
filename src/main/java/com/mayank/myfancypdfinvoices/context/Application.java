package com.mayank.myfancypdfinvoices.context;

import com.mayank.myfancypdfinvoices.service.InvoiceService;
import tools.jackson.databind.ObjectMapper;

public class Application {
    public static final ObjectMapper objectMapper = new ObjectMapper();
    public static final InvoiceService invoiceService = new InvoiceService();
}
