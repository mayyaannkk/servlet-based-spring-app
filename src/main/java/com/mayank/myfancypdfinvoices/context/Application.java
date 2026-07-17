package com.mayank.myfancypdfinvoices.context;

import com.mayank.myfancypdfinvoices.service.InvoiceService;
import com.mayank.myfancypdfinvoices.service.UserService;
import tools.jackson.databind.ObjectMapper;

public class Application {
    public static final ObjectMapper objectMapper = new ObjectMapper();
    public static final InvoiceService invoiceService = new InvoiceService();
    public static final UserService userService = new UserService();
}
