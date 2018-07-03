package za.co.digitalplatoon.invoiceservice.invoice.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import za.co.digitalplatoon.invoiceservice.invoice.data.entity.Invoice;
import za.co.digitalplatoon.invoiceservice.invoice.service.InvoiceService;

@CrossOrigin
@RestController
@RequestMapping (produces = MediaType.APPLICATION_JSON_VALUE)
public class InvoiceController {
	private static final Logger log = LoggerFactory.getLogger(InvoiceController.class);

	@Autowired
	private InvoiceService invoiceService;


	@GetMapping("/ping")
    public String ping() {
		log.info("ping successful!");
        return String.format("Invoice Service is up and running");
    }
	
	@PostMapping(path="/invoices",consumes=MediaType.APPLICATION_JSON_VALUE)
    public  Invoice addInvoice(@RequestBody Invoice invoice) {
    	try {
    		invoiceService.addInvoice(invoice);
    		System.out.println(invoice);
    	} catch (Exception e) {
    		log.error("Error adding invoice  : " + e.getMessage(), e);
    	}
    	return invoice;
    }	
	
	@GetMapping("/invoices/{invoiceId}")	
    public  Invoice viewInvoice(@PathVariable Long invoiceId) {
    	Invoice invoice = null;
    	try {
    		invoice = invoiceService.fetchInvoice(invoiceId);
    	} catch (Exception e) {
    		log.error("Error fetching invoices from database : " + e.getMessage(), e);
    	}
    	return invoice;
    }	

	@GetMapping("/invoices")
    public  List<Invoice> viewAllInvoices() {
    	List<Invoice> invoices = new ArrayList<>();
    	try {
    		invoices = invoiceService.fetchAllInvoices();
    	} catch (Exception e) {
    		log.error("Error fetching invoices from database : " + e.getMessage(), e);
    	}
    	return invoices;
    }	

    
}
