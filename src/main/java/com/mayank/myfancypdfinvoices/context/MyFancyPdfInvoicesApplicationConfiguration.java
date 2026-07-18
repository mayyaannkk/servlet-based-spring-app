package com.mayank.myfancypdfinvoices.context;

import com.mayank.myfancypdfinvoices.service.InvoiceService;
import com.mayank.myfancypdfinvoices.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tools.jackson.databind.ObjectMapper;

@Configuration
public class MyFancyPdfInvoicesApplicationConfiguration {

    @Bean
    public UserService userService() {
        return new UserService();
    }

    @Bean
    public InvoiceService invoiceService(UserService userService) {
        return new InvoiceService(userService);
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
